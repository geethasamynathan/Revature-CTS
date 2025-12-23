# Real-World Examples of File and Folder Permissions in Linux

This document gives **clean, working, real-world examples** of how to use file and folder permissions in Linux.  
You can run all of these in WSL or any Linux system.

We’ll cover:

1. Securing a **sensitive config file** (DB password)  
2. Creating a **shared project folder** for a dev team  

---

## 🔐 Scenario 1: Protect a Sensitive Config File (DB Password)

**Real world use case:**  
You have an app with a file that stores DB credentials: `db_passwords.env`.  
Only **you** (the owner) should be able to read/write it. No other users on the system should see it.

### Step 1: Create the folder & file

```bash
cd ~
mkdir -p secure_app
cd secure_app

echo "DB_USER=appuser"   >  db_passwords.env
echo "DB_PASS=SuperSecret123" >> db_passwords.env
```

Check the content:

```bash
cat db_passwords.env
```

### Step 2: See current permissions

```bash
ls -l db_passwords.env
```

You’ll see something like:

```text
-rw-r--r-- 1 youruser youruser  60 Dec 11 14:30 db_passwords.env
```

Breakdown of `-rw-r--r--`:

- `-`   → regular file  
- `rw-` → **user** (owner) can read & write  
- `r--` → **group** can only read  
- `r--` → **others** can only read  

This is **not secure** for secrets because everyone can read the file.

### Step 3: Restrict it to owner only

We want:

- user: **read + write**
- group: **no access**
- others: **no access**

That’s `600` in numeric form → `rw-------`.

```bash
chmod 600 db_passwords.env
ls -l db_passwords.env
```

Now you should see:

```text
-rw------- 1 youruser youruser  60 Dec 11 14:30 db_passwords.env
```

✅ Now **only you** (the owner) can read/write this file.

### Step 4: Why this matters

On a multi-user server:

- Other users trying:
  ```bash
  cat /home/youruser/secure_app/db_passwords.env
  ```
  would get: `Permission denied`.

- Your application (running as your user or as a dedicated service user with access) can still read it.

> **Takeaway (file permissions):**  
> Use `chmod 600` for sensitive files like:
> - SSH private keys (`~/.ssh/id_rsa`)  
> - `.env` files with passwords  
> - API keys, tokens, etc.

---

## 👥 Scenario 2: Shared Project Folder for a Dev Team

**Real world use case:**  
You have a project folder where **only your dev team** should be able to read/write.  
Other users on the server shouldn’t even be able to open it.

We’ll use:

- A **group**: `devteam`  
- A **project folder**: `/home/youruser/dev_team_project`  
- Permissions: `2770` (rwxrws---) →  
  - full access for owner & group  
  - no access for others  
  - `2` = **setgid bit** so new files inherit the group automatically

> You can run this on WSL too (you’ll use `sudo` to create sample users).

### Step 1: Create a group for the dev team

```bash
sudo groupadd devteam
```

(If you get “group already exists”, that’s fine.)

### Step 2: Create two sample dev users

```bash
sudo useradd -m -G devteam devuser1
sudo useradd -m -G devteam devuser2
```

- `-m` → create home directory (`/home/devuser1`, `/home/devuser2`)  
- `-G devteam` → add them to `devteam` group

(Optional) Set passwords if you want to log in as them:

```bash
sudo passwd devuser1
sudo passwd devuser2
```

### Step 3: Create the shared project folder

Back as your normal user (`youruser`):

```bash
cd ~
mkdir dev_team_project
```

Check owner/group:

```bash
ls -ld dev_team_project
```

You’ll see something like:

```text
drwxr-xr-x 2 youruser youruser 4096 Dec 11 14:45 dev_team_project
```

### Step 4: Assign the folder to the `devteam` group

```bash
sudo chgrp devteam dev_team_project
ls -ld dev_team_project
```

Now you should see:

```text
drwxr-xr-x 2 youruser devteam 4096 Dec 11 14:45 dev_team_project
```

Group is now `devteam`.

### Step 5: Set proper permissions (770 + setgid)

We want:

- user (youruser): read/write/execute  
- group (devteam): read/write/execute  
- others: no access  
- setgid bit so **all new files inherit group `devteam`**.

```bash
sudo chmod 2770 dev_team_project
ls -ld dev_team_project
```

You should see something like:

```text
drwxrws--- 2 youruser devteam 4096 Dec 11 14:45 dev_team_project
```

Notice `rws` for group → the `s` is the setgid bit.

### Step 6: Test as devuser1 (should access)

Create a file as `devuser1`:

```bash
sudo -u devuser1 touch /home/youruser/dev_team_project/code1.py
sudo -u devuser1 ls -l /home/youruser/dev_team_project
```

You’ll see something like:

```text
-rw-r--r-- 1 devuser1 devteam 0 Dec 11 14:50 code1.py
```

Group is `devteam` (thanks to setgid).

### Step 7: Test as devuser2 (should also access & edit)

```bash
sudo -u devuser2 echo "print('Hello from devuser2')" >> /home/youruser/dev_team_project/code1.py
sudo -u devuser2 cat /home/youruser/dev_team_project/code1.py
```

They **can** read and write, because they’re in the `devteam` group.

### Step 8: Test as some other user (should be blocked)

Create a third user with no `devteam` access:

```bash
sudo useradd -m outsider
sudo -u outsider ls -l /home/youruser/dev_team_project
```

You should get:

```text
ls: cannot open directory '/home/youruser/dev_team_project': Permission denied
```

✅ This proves:

- Dev team members (`youruser`, `devuser1`, `devuser2`) have full access.  
- Others (like `outsider`) **cannot even list** the folder.

> **Takeaway (folder permissions):**  
> - `r` on a **directory** → can list files  
> - `w` on a **directory** → can create/delete files inside  
> - `x` on a **directory** → can `cd` into it  
> - Use `770` or `2770` for **team-only** folders  
> - Use `755` for **publicly readable** folders (e.g., web root)  
> - Use `700` for **private** personal folders

---

## Quick Summary Table

| Use case                           | Example               | Recommended mode | Meaning            |
|------------------------------------|-----------------------|------------------|--------------------|
| Secret config / password file      | `db_passwords.env`    | `600`            | `rw-------`        |
| Private folder                     | `~/secure_app`        | `700`            | `rwx------`        |
| Shared dev team project            | `dev_team_project`    | `2770`           | `rwxrws---` (setgid)|
| Public web root (read-only users)  | `/var/www/html`       | `755`            | `rwxr-xr-x`        |

You can use this as a lab sheet for students or as a quick reference while teaching Linux permissions.
