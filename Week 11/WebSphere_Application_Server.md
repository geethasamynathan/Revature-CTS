# WebSphere Application Server (WAS)

## 1) What is WebSphere Application Server?

**WebSphere Application Server (WAS)** is IBM’s **enterprise Java application server** (Java EE / Jakarta EE).  
It is used to **host, run, secure, scale, and manage** Java enterprise applications in production.

### Quick analogy
- **Your Spring application** = the “business logic”
- **WAS** = the “enterprise runtime + operations layer” that runs and manages the app (security, pooling, clustering, monitoring, admin console)

---

## 2) Where WAS fits in the Java world

You already know:
- **Java code (OOPS)**
- **Spring Boot / Spring MVC** (REST controllers, dependency injection)
- **JPA/Hibernate** (database access)

WAS provides enterprise runtime services such as:
- **Web container** (Servlet/JSP)
- **Security** (LDAP/AD, SSO, roles)
- **Connection pooling** (datasources)
- **Transactions** (JTA / distributed transactions)
- **Naming** (JNDI)
- **Messaging** (JMS)
- **Clustering + High Availability**
- **Centralized administration + monitoring**

✅ Your app focuses on business features; WAS helps operate it reliably at scale.

---

## 3) WebSphere Architecture (must-know concepts)

### A) Standalone vs Network Deployment (ND)
- **Standalone WAS:** One server runtime (simple setup).
- **WAS ND:** Enterprise setup managing multiple machines/servers via a central manager.

### B) Key terms (ND Edition)

#### 1) Cell
Top-level boundary for an environment (like the “whole WAS domain”).

#### 2) Node
A machine/VM where WAS components run.

#### 3) Server
A JVM process that hosts and runs your application.

#### 4) Profile
A configured WAS runtime installation (example):
- **AppSrv01** (Application Server profile)
- **Dmgr01** (Deployment Manager profile)

#### 5) Deployment Manager (DMGR)
Central controller that:
- manages configuration centrally
- deploys apps across nodes
- coordinates clusters

#### 6) Node Agent
Runs on each node and:
- communicates with DMGR
- starts/stops server JVMs
- synchronizes configuration

---

## 4) Architecture diagrams (easy view)

### A) Standalone WAS
```
Users -> (Optional Load Balancer) -> WAS Server (JVM) -> Database
                                  -> App (WAR/EAR)
```

### B) WAS Network Deployment (Enterprise)
```
                +----------------------+
                | Deployment Manager   |
                |        (DMGR)        |
                +----------+-----------+
                           |
                      config sync
                           |
        +------------------+------------------+
        |                                     |
+-------+--------+                     +------+--------+
|   Node Agent   |                     |  Node Agent   |
| (Machine A)    |                     | (Machine B)   |
+-------+--------+                     +------+--------+
        |                                     |
  +-----+-----+                         +-----+-----+
  | AppServer |                         | AppServer |
  |  JVM #1   |                         |  JVM #2   |
  +-----+-----+                         +-----+-----+
        |                                     |
        +------------> Database <-------------+
```

---

## 5) End-to-End request flow (how an API call works)

When a client calls your API:
1. **Client** sends HTTP request (browser/mobile/Postman)
2. **Load balancer** (if used) routes to one WAS server in the cluster
3. WAS **web container** receives the request (Servlet pipeline)
4. Spring MVC (Dispatcher) calls **Controller → Service**
5. JPA/Hibernate uses **Datasource** configured in WAS (connection pool)
6. Transaction may be handled/coordinated (especially if multiple resources are involved)
7. Response returns to client
8. Logs/metrics/tracing can capture performance and errors

---

## 6) Deployment formats: WAR vs EAR

### WAR (Web Archive)
- Used for web apps / REST APIs
- Common for Spring MVC apps packaged for external containers

### EAR (Enterprise Archive)
- Can contain multiple modules (WAR + EJB + shared libs)
- Used in large enterprise apps that follow modular Java EE packaging

✅ Many enterprises still use **EAR** for governance/structure/legacy reasons.

---

## 7) Spring Boot vs WAS (important difference)

### Option A: Spring Boot standalone (common today)
- You run: `java -jar myapp.jar`
- Embedded Tomcat/Jetty runs inside your app

✅ Lightweight, cloud-native, fast to deploy.

### Option B: Deploy Spring app into WAS (WAR)
- You build a **WAR**
- Deploy it into WAS

✅ Enterprise choice because WAS provides:
- Central admin console
- LDAP/SSO integration
- Clustering + session replication
- Governance, monitoring, controlled deployments

---

## 8) What you typically configure in WAS (practical checklist)

### 1) Datasource (DB connection pool)
- JDBC driver (DB2/Oracle/SQL Server…)
- pool settings (min/max connections)
- JNDI name, e.g. `jdbc/MyAppDS`

### 2) Security
- LDAP / Active Directory integration
- roles → group mappings
- SSL certificates

### 3) JVM settings
- heap sizes, GC options
- thread settings (based on workload)

### 4) Context root
- URL base path for the app (e.g., `/orders`)

### 5) Classloading
- parent-first vs parent-last (common enterprise issue)
- fixes library version conflicts

### 6) Messaging (if used)
- JMS queues/topics
- connection factories

### 7) Clustering / HA
- horizontal scaling (multiple JVMs)
- session replication / failover strategies

---

## 9) How WAS differs from *other IBM “WebSphere” products*

IBM uses “WebSphere” as a brand name for multiple products. Don’t mix them up.

### A) WebSphere Application Server (WAS)
✅ Runs Java enterprise apps (WAR/EAR)

### B) WebSphere Liberty (Open Liberty / Liberty Profile)
- Lightweight IBM runtime
- Faster startup, microservices-friendly
- Container/cloud-native direction

**Simple view:**  
- **WAS Traditional** = heavy enterprise runtime  
- **Liberty** = modern lightweight runtime

### C) IBM HTTP Server (IHS)
- Apache-based web server from IBM
- Often placed in front of WAS
- Handles SSL termination, routing, static content

### D) WebSphere MQ (IBM MQ)
- Messaging middleware (queues)
- Not a server that hosts web apps
- Used for async communication and integration

### E) WebSphere Portal
- Portal platform for enterprise portals
- Not used to host typical Spring Boot REST APIs

✅ Summary:  
**WAS hosts your app**; **MQ transports messages**; **IHS reverse-proxies**; **Portal is a portal UI platform**.

---

## 10) WAS vs Tomcat / JBoss / WebLogic (quick compare)

### WAS vs Tomcat
| Feature | Tomcat | WebSphere (WAS) |
|---|---|---|
| Type | Servlet container | Full enterprise app server |
| Best for | Lightweight apps, microservices | Large enterprise systems |
| Transactions, JMS, advanced security | limited/external | enterprise features built-in |
| Admin console, clustering | basic/external | strong built-in |

**Summary:** Tomcat is simpler; WAS is enterprise-grade.

### WAS vs JBoss/WildFly
- Both are enterprise app servers
- JBoss is more open ecosystem
- WAS integrates deeply with IBM enterprise stack

### WAS vs Oracle WebLogic
- Both are “big enterprise servers”
- WebLogic is common in Oracle-heavy enterprises
- WAS is common in IBM-heavy enterprises

---

## 11) When companies choose WAS (real-world)

Choose WAS when:
- strict enterprise governance and auditing required
- strong **LDAP/SSO** integration is needed
- apps must run in **clusters** with **HA**
- legacy Java EE apps already built for WAS

Prefer standalone Spring Boot / Kubernetes when:
- cloud-native microservices
- fast CI/CD deployments
- container-first designs

---

## 12) Common fresher pain points (what to remember)

### 1) “Works in Boot, fails in WAS”
Common reasons:
- classloading conflicts (library version mismatch)
- datasource/JNDI not configured properly
- context root mismatch
- missing server features/modules

### 2) “WAR vs JAR confusion”
- **JAR** = runs by itself (`java -jar`)
- **WAR/EAR** = runs inside an application server

### 3) “Where DB config lives”
- Spring Boot standalone: `application.properties`
- WAS-managed: **WAS Datasource + JNDI** (pool managed by server)

---

## 13) Typical enterprise deployment flow (end-to-end)

1. Build **WAR/EAR**
2. Login to **WAS Admin Console**
3. Install application (upload WAR/EAR)
4. Map modules to server/cluster
5. Bind resources:
   - map datasource JNDI
   - map security roles to LDAP groups
6. Save configuration + sync nodes
7. Start the application
8. Validate URL / health checks
9. Monitor logs, metrics, performance

---

## Quick recap (exam-ready)
- **WAS** = IBM enterprise Java application server to deploy and manage **WAR/EAR** apps.
- Provides enterprise features: **security, pooling, transactions, JMS, clustering, admin console**.
- Different from IBM “WebSphere” products like **IBM MQ (messaging)** and **IBM HTTP Server (reverse proxy)**.
- Compared to **Spring Boot standalone**, WAS is heavier but offers centralized enterprise management and HA.
