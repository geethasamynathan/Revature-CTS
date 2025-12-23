# Git Tutorial (Beginner → Advanced)

**Current Project:** Databricks & SQL Assessment Banks  
**Date:** 2025-12-19 (Asia/Kolkata)

---

## 1) What is Git?

**Git** is a **distributed version control system (DVCS)** used to track changes in source code and other files. It helps you:

- Keep a complete **history** of changes
- Work safely with **branches**
- **Collaborate** with teammates and merge work
- Recover from mistakes (restore old versions)

**Key idea:** Your local machine contains the repo history, so you can work offline and operations are fast.

---

## 2) Git vs GitHub / GitLab / Bitbucket

- **Git**: The version control tool installed on your machine.
- **GitHub/GitLab/Bitbucket**: Hosting platforms for Git repositories (remote repos, PR/MR, issues, CI/CD).

---

## 3) “Different versions” of Git and why they matter

Git is released in versions (e.g., 2.x series). Newer versions can introduce:

- New commands (e.g., `git switch`, `git restore`)
- Behavior improvements / bug fixes
- Performance enhancements

### Check your installed Git version

```bash
git --version
```

---

## 4) Installing Git (High-level)

### Windows
- Install Git for Windows (includes Git Bash).

### macOS
- Install via Xcode Command Line Tools or package manager (like Homebrew).

### Linux
- Install via your distro package manager.

> If you tell me your OS (Windows/macOS/Ubuntu/WSL), I can give exact step-by-step install commands for your setup.

---

## 5) First-time configuration (Must-do)

### A) Set your identity (required for commits)

```bash
git config --global user.name  "Your Name"
git config --global user.email "you@email.com"
```

### B) Verify config

```bash
git config --global --list
```

### C) Set default editor (recommended)

**VS Code** example:

```bash
git config --global core.editor "code --wait"
```

### D) Set default branch name (recommended)

```bash
git config --global init.defaultBranch main
```

### E) Line endings (important for Windows ↔ Linux teams)

- **Windows**:
```bash
git config --global core.autocrlf true
```

- **macOS/Linux**:
```bash
git config --global core.autocrlf input
```

### F) Show config with file locations (great for debugging)

```bash
git config --list --show-origin
```

---

## 6) Git concepts you must understand (Simple mental model)

Git works mainly with these areas:

1. **Working Directory** – your actual files you edit
2. **Staging Area (Index)** – the “ready to commit” area
3. **Repository (.git)** – committed history

**Typical flow:**
1) Edit files → 2) Stage changes → 3) Commit → 4) Push to remote

---

## 7) Core Git workflow (Real-world)

### A) Start a new repo and push to remote

```bash
mkdir myapp && cd myapp
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin <REMOTE_URL>
git push -u origin main
```

### B) Typical feature work (branch → commit → push → PR)

```bash
git checkout -b feature/login
# edit files
git add .
git commit -m "Add login UI"
git push -u origin feature/login
```

---

## 8) All major Git commands (Grouped by purpose)

### 8.1 Create / download repositories

- `git init` → Create a new Git repo in the current folder.
- `git clone <url>` → Download an existing repo (history + files).

Examples:

```bash
git init
git clone https://github.com/org/repo.git
```

---

### 8.2 Check status and history

- `git status` → Shows what changed, staged/untracked files.
- `git log` → Commit history
- `git log --oneline --graph --decorate --all` → Pretty history view

Examples:

```bash
git status
git log
git log --oneline --graph --decorate --all
```

---

### 8.3 Compare changes

- `git diff` → Unstaged changes
- `git diff --staged` → Staged changes

Examples:

```bash
git diff
git diff --staged
```

---

### 8.4 Stage and commit

- `git add <file>` → Stage a file
- `git add .` → Stage changes in current directory
- `git add -A` → Stage **all changes** in repo (including deletions)
- `git commit -m "msg"` → Commit staged changes
- `git commit -am "msg"` → Stage+commit tracked files (skips new files)

Examples:

```bash
git add app.js
git add .
git add -A
git commit -m "Fix login validation"
git commit -am "Quick fix (tracked files only)"
```

---

### 8.5 Branching

- `git branch` → List branches
- `git branch <name>` → Create branch
- `git checkout <branch>` → Switch branch (classic)
- `git switch <branch>` → Switch branch (newer, clearer)
- `git switch -c <name>` → Create + switch
- `git branch -d <name>` → Delete merged branch
- `git branch -D <name>` → Force delete

Examples:

```bash
git branch
git switch -c feature/payment
git switch main
git branch -d feature/payment
```

---

### 8.6 Merging and rebasing

- `git merge <branch>` → Merge another branch into current branch
- `git rebase <branch>` → Replay your commits onto another base
- `git rebase -i HEAD~N` → Interactive rebase (squash/reorder/edit messages)

Examples:

```bash
git switch main
git merge feature/login

git switch feature/login
git rebase main

git rebase -i HEAD~5
```

---

### 8.7 Remote operations

- `git remote -v` → Show remotes
- `git fetch` → Download remote updates (does not merge)
- `git pull` → fetch + merge (or fetch + rebase)
- `git push` → Upload commits to remote

Examples:

```bash
git remote -v
git fetch origin
git pull origin main
git push origin feature/login
```

---

### 8.8 Undo / Fix mistakes (Very important)

#### A) Restore file changes

- `git restore <file>` → Discard working directory changes to a file
- `git restore --staged <file>` → Unstage a file

Examples:

```bash
git restore app.js
git restore --staged app.js
```

#### B) Reset (powerful; be careful)

- `git reset --soft HEAD~1` → Undo last commit, keep staged changes
- `git reset --mixed HEAD~1` → Undo last commit, keep unstaged changes (default)
- `git reset --hard HEAD~1` → Undo last commit, discard changes (dangerous)

Examples:

```bash
git reset --soft HEAD~1
git reset --mixed HEAD~1
git reset --hard HEAD~1
```

#### C) Revert (safe for shared branches)

- `git revert <commit>` → Creates a new commit that undoes an earlier commit

Example:

```bash
git revert a1b2c3d
```

---

### 8.9 Stash (temporary shelf)

- `git stash` → Save uncommitted work temporarily
- `git stash list` → List stashes
- `git stash pop` → Apply the stash and remove it
- `git stash apply` → Apply but keep stash

Examples:

```bash
git stash
git stash list
git stash pop
```

---

### 8.10 Tags (releases)

- `git tag` → List tags
- `git tag v1.0.0` → Create tag
- `git push origin v1.0.0` → Push a tag
- `git push --tags` → Push all tags

Examples:

```bash
git tag v1.0.0
git push origin v1.0.0
```

---

### 8.11 Inspection / troubleshooting

- `git show <commit>` → Show a commit’s changes
- `git blame <file>` → Who changed each line
- `git reflog` → Recover lost commits after reset/checkout
- `git bisect` → Find which commit introduced a bug

Examples:

```bash
git show HEAD
git blame app.js
git reflog
git bisect start
```

---

## 9) Differences between similar Git commands (Common interview + real usage)

### 9.1 `git clone` vs `git init`
- **clone**: Download an existing repository from remote
- **init**: Create a new repository in a folder

### 9.2 `git fetch` vs `git pull`
- **fetch**: Download updates only (safe)
- **pull**: Download + merge/rebase into current branch

### 9.3 `git merge` vs `git rebase`
- **merge**: Preserves branch history; may create merge commit
- **rebase**: Makes history linear; rewrites commits (be careful if already pushed)

### 9.4 `git reset` vs `git revert`
- **reset**: Moves branch pointer; can remove commits locally (unsafe if pushed)
- **revert**: Creates a new commit that undoes old commit (safe for shared branch)

### 9.5 `git checkout` vs `git switch` vs `git restore`
- **checkout**: old multi-purpose command (switch branch + restore files)
- **switch**: branch switching
- **restore**: restore file content / unstage

### 9.6 `git add .` vs `git add -A`
- **add .**: stage changes in current directory
- **add -A**: stage all changes in repo including deletions everywhere

### 9.7 `git commit -m` vs `git commit -am`
- **-m**: commits staged changes
- **-am**: stages+commits tracked files only (new files still need `git add`)

### 9.8 `rm file` vs `git rm file`
- `rm` removes file from disk, but deletion may not be staged
- `git rm` removes file and stages the deletion

---

## 10) Recommended “safe” settings for beginners

```bash
git config --global init.defaultBranch main
git config --global pull.rebase false
git config --global fetch.prune true
```

---

## 11) Quick cheat commands (Daily use)

```bash
git status
git add .
git commit -m "message"
git push

git switch -c feature/new-feature
git switch main
git pull
git merge feature/new-feature
```

---

## 12) Next step (Optional)
If you want, I can create:
- A **1-page Git Cheat Sheet** (print-ready)
- A **hands-on mini lab** with conflicts + stash + revert + rebase, including expected outputs
- A **Git interview Q&A set** (beginner → advanced)
