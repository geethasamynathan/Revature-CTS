# Linux `rm` (Delete) — File & Folder Commands (Based on Your `~/projects/python` Screenshot)

> ⚠️ **Warning:** `rm` deletes permanently (no Recycle Bin).  
> While learning, prefer **`-i`** or **`-I`** first.

---

## 0) Confirm location + list items
```bash
pwd
ls
```

From your screenshot, you have files like:
- `demo1.txt`, `demo2.txt`, `demo3.txt`
- `log1.txt` … `log5.txt`
- `app_dev.yml`, `app_qa.yml`, `app_prod.yml`
- `mergefile.txt`

And folders like:
- `backup`, `archived_ackup`, `logs`, `dir1`, `dir3`, `di2`, `dev_team_project`, `secure_app`

---

# A) Delete FILES

## 1) Delete one file
```bash
rm demo1.txt
```

## 2) Delete multiple files
```bash
rm demo2.txt demo3.txt mergefile.txt
```

## 3) Delete files using wildcards
Delete all demo files:
```bash
rm demo*.txt
```

Delete all log files:
```bash
rm log*.txt
```

Delete all yml files:
```bash
rm *.yml
```

## 4) Delete using brace expansion (your env files)
```bash
rm app_{dev,qa,prod}.yml
```

## 5) Safe delete (ask before removing)
Ask for each file:
```bash
rm -i log1.txt
rm -i log*.txt
```

Ask once if deleting many files:
```bash
rm -I log*.txt
```

## 6) Force delete (no prompts, ignores missing)
```bash
rm -f log10.txt
rm -f log*.txt
```

## 7) Verbose delete (shows what was removed)
```bash
rm -v demo2.txt
rm -v log*.txt
```

## 8) Special case: filename starts with `-`
If any file name starts with a dash (example: `-badname.txt`), use `--`:
```bash
rm -- -badname.txt
```

---

# B) Delete FOLDERS (Directories)

## 1) Delete an empty folder (recommended for empty dirs)
```bash
rmdir dir1
```

## 2) Delete a folder with contents (recursive)
```bash
rm -r dir1
rm -r logs
```

## 3) Delete folder + force (most used, but dangerous)
```bash
rm -rf dir3
rm -rf di2
```

## 4) Interactive folder delete (best for learning)
```bash
rm -ri logs
```

## 5) Verbose recursive delete (see every deletion)
```bash
rm -rv logs
```

---

# C) Delete ONLY folder contents (keep the folder)

## 1) Clear `logs/` but keep `logs/` folder
```bash
rm -rf logs/*
```

## 2) Clear `logs/` including hidden files
```bash
rm -rf logs/* logs/.[!.]* logs/..?*
```

---

# D) Preview (Dry Run) before deleting — best safety habit

## 1) Preview what a wildcard will match
```bash
echo rm log*.txt
echo rm demo*.txt
```

## 2) Preview files inside a folder before clearing it
```bash
ls -la logs
```

---

# E) Real-world cleanup using `find` + `rm`

## 1) Delete `.txt` files older than 7 days (safe preview first)
Preview:
```bash
find . -maxdepth 1 -type f -name "*.txt" -mtime +7 -print
```

Delete after verifying:
```bash
find . -maxdepth 1 -type f -name "*.txt" -mtime +7 -exec rm -v {} \;
```

## 2) Delete empty folders inside current directory
Preview:
```bash
find . -type d -empty -print
```

Delete:
```bash
find . -type d -empty -delete
```

---

# F) Quick “Your Exact” Copy‑Paste Commands

Delete all `log*.txt` and `demo*.txt` (ask once):
```bash
rm -I log*.txt demo*.txt
```

Delete all environment yml files:
```bash
rm app_{dev,qa,prod}.yml
```

Delete the `backup` folder safely (asks once):
```bash
rm -rI backup
```

Clear `logs/` content but keep `logs/` folder:
```bash
rm -rf logs/* logs/.[!.]* logs/..?*
```

---

## Quick Reminder
- `rm file` → delete file  
- `rm -i file` → ask confirmation  
- `rm -r folder` → delete folder with contents  
- `rm -rf folder` → force delete folder with contents (**danger**)  
- `rm -v ...` → show what is deleted  

If you tell me *exactly* what you want to keep/delete, I can give you the safest single command for it.
