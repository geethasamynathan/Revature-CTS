# Jenkins + CI/CD for a Spring Boot (H2) Java App 



So, the goal is: **Use Jenkins to automate build → test → package → deploy** whenever code changes in GitHub.


## 1) DevOps (Overview) — What it means in real projects

### DevOps = Dev + Ops working together
DevOps is a culture + set of practices to:
- deliver software **faster**
- reduce production failures
- make deployments **repeatable**
- automate boring manual tasks

### DevOps pipeline concept (high-level)
```
Developer commits code → CI (build+test) → artifact created → Delivery/Deployment → monitoring/feedback
```

---

## 2) Continuous Integration (CI)

### What is CI?
CI means:
- Developers frequently push code to Git
- Every push triggers an automated:
  - **compile**
  - **unit tests**
  - **package/build artifact**

### Why CI is important?
- Detects errors quickly
- Avoids “it works on my machine”
- Ensures main branch stays stable

**CI output example for Spring Boot:**
- `mvn test`
- `mvn package`
- produces: `target/*.jar`

---

## 3) Continuous Delivery vs Continuous Deployment

### A) Continuous Delivery (CD - Delivery)
- After CI, the app is **always deployable**
- BUT deployment to production is usually **manual approval**
- Example: Jenkins builds artifact, and someone clicks “Deploy to Prod”

### B) Continuous Deployment (CD - Deployment)
- After CI, deployment happens **automatically** if tests pass
- No manual approval
- Example: every successful merge to `main` auto-deploys

**Key difference:**
- **Delivery** = ready to deploy (manual release step)
- **Deployment** = auto deploy (no manual step)

---

## 4) What is Jenkins?

**Jenkins** is an automation server that runs jobs/pipelines for CI/CD.

### Jenkins job types (common)
1. **Freestyle Job** (beginner-friendly)
2. **Pipeline Job** (recommended; uses `Jenkinsfile` in Git)
3. **Multibranch Pipeline** (auto detects branches + PRs)

✅ For modern teams, **Pipeline Job + Jenkinsfile** is best.

---

## 5) Tools you need (for a fresher demo)

### Required
- **Git**
- **GitHub**
- **JDK 21** (or the Java version your project uses)
- **Maven** (or Maven Wrapper `mvnw`)
- **Jenkins** (installed locally or via Docker)

### Optional but great for demos
- **Docker Desktop** (run Jenkins + deploy app in containers)
- **ngrok** (GitHub Webhook to local Jenkins)
- **Postman** (verify APIs after deployment)

---

## 6) Understand your demo app quickly

From `application.properties` in your repo, we can infer:
- App runs on **port 8088**
- Uses **H2 in-memory database**
- H2 console enabled at `/h2-console`
- JWT properties exist (secret/expiration)

This is ideal for CI/CD demos because it starts fast and has no external DB dependency.

---

## 7) What changes you should do in your app for a clean CI/CD demo

### ✅ Change #1: Add at least 1–2 tests
CI must run tests to prove quality gates work.

Example: a simple context load test in `src/test/java/...` using `@SpringBootTest`.

### ✅ Change #2: Add Maven Wrapper (recommended)
So Jenkins can build without installing Maven on every machine.

Run inside your app folder:
```bash
mvn -N wrapper:wrapper
```

Commit these files:
- `mvnw`, `mvnw.cmd`, `.mvn/`

### ✅ Change #3: Add a Jenkinsfile
Create: `Week 9/spring-rest-h2-demo-1/Jenkinsfile`

### ✅ Change #4 (Optional): Add Dockerfile
Cleaner deployment demo (container-based).

---

## 8) Jenkins setup (2 easy options)

### Option A (Easiest): Run Jenkins using Docker
```bash
docker run -d --name jenkins \
  -p 8080:8080 -p 50000:50000 \
  -v jenkins_home:/var/jenkins_home \
  jenkins/jenkins:lts
```

Unlock password:
```bash
docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```

Open: `http://localhost:8080`

### Option B: Install Jenkins on Windows
- Install Jenkins MSI
- Ensure Java installed and `JAVA_HOME` configured
- Open Jenkins on `http://localhost:8080`

---

## 9) Configure Jenkins for the project

### Step 1: Install plugins
Manage Jenkins → Plugins:
- Git
- Pipeline
- JUnit
- (Optional) Blue Ocean
- (Optional) Docker related plugins

### Step 2: Configure tools
Manage Jenkins → Tools:
- JDK (point to JDK 21)
- Maven (optional if using `mvnw`)

### Step 3: Credentials
- If repo is public → no credentials needed
- If private → add GitHub token in Jenkins Credentials

---

## 10) Create Jenkins Pipeline Job (Recommended)

1. Dashboard → **New Item**
2. Name: `spring-rest-h2-demo-ci-cd`
3. Type: **Pipeline**
4. Pipeline section:
   - Definition: **Pipeline script from SCM**
   - SCM: **Git**
   - Repository URL: your GitHub repo
   - Branch: `main`
   - Script Path: `Week 9/spring-rest-h2-demo-1/Jenkinsfile`

Save → **Build Now**

---

## 11) Working Jenkinsfile (CI + Simple Deployment on Windows)

Create file: `Week 9/spring-rest-h2-demo-1/Jenkinsfile`

```groovy
pipeline {
  agent any

  environment {
    APP_DIR = "Week 9/spring-rest-h2-demo-1"
    JAR_GLOB = "target/*.jar"
  }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Build & Test') {
      steps {
        dir("${APP_DIR}") {
          bat "mvnw.cmd -B clean test"
        }
      }
      post {
        always {
          dir("${APP_DIR}") {
            junit "target/surefire-reports/*.xml"
          }
        }
      }
    }

    stage('Package') {
      steps {
        dir("${APP_DIR}") {
          bat "mvnw.cmd -B clean package -DskipTests"
        }
      }
      post {
        success {
          dir("${APP_DIR}") {
            archiveArtifacts artifacts: "target/*.jar", fingerprint: true
          }
        }
      }
    }

    stage('Deploy (Demo) - Run on port 8088') {
      steps {
        dir("${APP_DIR}") {
          // kill process using 8088 (demo only)
          bat "for /f \"tokens=5\" %%a in ('netstat -aon ^| findstr :8088') do taskkill /F /PID %%a || echo No process to kill"

          // run the new jar
          bat "for %%f in (%JAR_GLOB%) do (echo Starting %%f & start \"spring-demo\" java -jar %%f)"
        }
      }
    }
  }
}
```

✅ This gives you a complete fresher CI/CD demo: **Push → Jenkins builds/tests/packages → redeploys**.

---

## 12) Cleaner deployment (Optional): Docker-based

### Add Dockerfile
Create: `Week 9/spring-rest-h2-demo-1/Dockerfile`

```dockerfile
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","/app/app.jar"]
```

### Add Docker stages (optional)
```groovy
stage('Docker Build') {
  steps {
    dir("${APP_DIR}") {
      bat "docker build -t spring-rest-h2-demo-1:latest ."
    }
  }
}

stage('Docker Deploy') {
  steps {
    bat "docker rm -f spring-demo || echo no container"
    bat "docker run -d --name spring-demo -p 8088:8088 spring-rest-h2-demo-1:latest"
  }
}
```

---

## 13) Auto-trigger pipeline on Git push

### Option 1 (Easy): Poll SCM
- Job → Configure → Build Triggers → **Poll SCM**
- Example: `H/2 * * * *` (every 2 minutes)

### Option 2 (Professional): GitHub Webhook
- Install GitHub plugin
- Job trigger: **GitHub hook trigger**
- GitHub repo → Settings → Webhooks → payload: `http://<jenkins-url>/github-webhook/`

If Jenkins is local, use ngrok:
```bash
ngrok http 8080
```

---

## 14) How to showcase this demo for freshers (best flow)

### 10–15 minute demo plan
1. Explain CI/CD with one diagram:
   ```
   Git Push -> Jenkins -> Build -> Test -> Package -> Deploy -> Verify
   ```
2. Show GitHub repo
3. Show Jenkins pipeline job and Jenkinsfile
4. Trigger build once
5. Make a small change (e.g., API response text)
6. Push to GitHub
7. Jenkins auto runs and redeploys
8. Verify app in browser/Postman
9. Show test report + archived jar in Jenkins

---

## 15) Common errors and fixes

### Jenkins can’t find Java
- Manage Jenkins → Tools → Configure JDK
- Ensure `JAVA_HOME` is set

### Maven not found
- Use Maven Wrapper (`mvnw.cmd`)
- Ensure wrapper files are committed

### Port 8088 already used
- Stop old process/container
- Or change port temporarily
