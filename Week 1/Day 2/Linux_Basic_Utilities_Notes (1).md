# Basic Utilities in Linux (Quick Notes + Examples)

These are the most commonly used **Linux utilities (commands)** for everyday work: navigation, files, searching, permissions, monitoring, and networking.

---

## 1) Navigation & Listing

### `pwd` — Print working directory
```bash
pwd
```

### `ls` — List files and folders
```bash
ls
ls -l        # long listing
ls -la       # include hidden files
ls -lh       # human readable sizes
```

### `cd` — Change directory
```bash
cd /var/log
cd ..        # go up one level
cd ~         # go to home directory
cd -         # go back to previous directory
```

---

## 2) Create / Copy / Move / Delete

### `mkdir` — Create folder
```bash
mkdir projects
mkdir -p a/b/c     # create nested folders
```

### `touch` — Create empty file / update timestamp
```bash
touch notes.txt
```

### `cp` — Copy files/folders
```bash
cp a.txt b.txt
cp -r folder1 folder2
```

### `mv` — Move or rename
```bash
mv oldname.txt newname.txt
mv file.txt /tmp/
```

### `rm` — Remove files/folders (careful!)
```bash
rm file.txt
rm -r folder/       # remove folder recursively
rm -rf folder/      # force remove (VERY dangerous)
```

---

## 3) View File Content

### `cat` — Print full content
```bash
cat file.txt
```

### `head` — First lines
```bash
head file.txt
head -n 20 file.txt
```

### `tail` — Last lines / follow logs
```bash
tail file.txt
tail -n 50 file.txt
tail -f app.log     # live log watching
```

### `less` — Scroll large files safely
```bash
less /var/log/syslog
# Keys: Space (next page), b (back), /word (search), q (quit)
```

---

## 4) Search Utilities

### `grep` — Search text inside files
```bash
grep "ERROR" app.log
grep -n "ERROR" app.log          # show line number
grep -i "error" app.log          # ignore case
grep -R "connection" ./src       # recursive search
```

### `find` — Find files/folders by name/type/time/size
```bash
find . -name "*.log"
find /var/log -type f -name "*.log"
find . -type f -size +10M        # larger than 10 MB
```

### `wc` — Count lines/words/chars
```bash
wc file.txt
wc -l file.txt    # number of lines
```

---

## 5) Permissions & Ownership

### `chmod` — Change permissions
Common numeric meanings:
- `r=4`, `w=2`, `x=1`
- `755` → owner: rwx, group: rx, others: rx
- `644` → owner: rw, group: r, others: r

```bash
chmod 644 notes.txt
chmod 755 script.sh
chmod +x script.sh               # make executable
```

### `chown` — Change owner (often needs sudo)
```bash
sudo chown user:user notes.txt
sudo chown -R user:user folder/
```

### `whoami` / `id` — Check current user & groups
```bash
whoami
id
```

---

## 6) Disk & Memory

### `df` — Disk usage by filesystem
```bash
df -h
```

### `du` — Folder/file size
```bash
du -sh folder/
du -ah . | head -n 20
```

### `free` — RAM usage
```bash
free -h
```

---

## 7) Processes & Monitoring

### `ps` — Process list
```bash
ps -ef
ps -ef | grep nginx
```

### `top` / `htop` — Live system monitoring
```bash
top
# (htop is nicer if installed)
htop
```

### `kill` — Stop a process
```bash
kill <pid>
kill -9 <pid>     # force kill (last option)
```

---

## 8) Networking Basics

### `ip` — Network details
```bash
ip a
ip r
```

### `ping` — Connectivity test
```bash
ping google.com
```

### `curl` / `wget` — Fetch URLs
```bash
curl -I https://example.com
wget https://example.com/file.zip
```

### `ssh` — Remote login
```bash
ssh user@server_ip
```

---

## 9) Archives & Compression

### `tar` — Create/extract tar.gz archives
```bash
tar -czf backup.tar.gz folder/
tar -xzf backup.tar.gz
```

### `zip` / `unzip`
```bash
zip -r files.zip folder/
unzip files.zip
```

---

## 10) Help (Must-know)

### `man` — Manual pages
```bash
man grep
```

### `--help` — Quick help
```bash
ls --help
grep --help
```

---

# Practice Mini-Lab (10 minutes)

Run these commands in a safe folder (like your home directory):

```bash
mkdir -p linux_lab/logs
cd linux_lab

# Create sample files
echo "INFO: App started" > logs/app.log
echo "ERROR: DB not reachable" >> logs/app.log
echo "INFO: Retry success" >> logs/app.log

# View content
cat logs/app.log
tail -n 2 logs/app.log

# Search
grep "ERROR" logs/app.log

# Permissions
touch script.sh
echo -e '#!/bin/bash
echo "Hello Linux"' > script.sh
chmod +x script.sh
./script.sh

# Archive the lab
cd ..
tar -czf linux_lab_backup.tar.gz linux_lab
ls -lh linux_lab_backup.tar.gz
```

✅ If all works, you’ve practiced: folders, files, echo, redirection, viewing logs, grep search, chmod, running scripts, and tar backup.
