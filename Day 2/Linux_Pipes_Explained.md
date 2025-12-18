# Linux Pipes (`|`) – Real-World Examples Explained

A **pipe (`|`)** sends the **output of one command** as the **input to the next command**.

General pattern:
```bash
command1 | command2 | command3
```

Rule: Each command does **one job**, pipes combine them into a workflow.

---

## 1) Count How Many `ERROR` Lines Are in a Log

**Goal:** How many errors happened?

```bash
grep "ERROR" app.log | wc -l
```

**Explanation:**
- `grep "ERROR" app.log` filters only lines containing `ERROR`
- `|` passes those lines to the next command
- `wc -l` counts the number of lines

**Meaning:** Total number of error entries in the log.

---

## 2) Show Last 2 Errors (Recent)

```bash
grep "ERROR" app.log | tail -n 2
```

**Meaning:** View the most recent errors for quick debugging.

---

## 3) Unique Error Codes from the Log

```bash
grep "ERROR" app.log | grep -o "code=[A-Z0-9]*" | sort | uniq
```

**Meaning:** Lists all distinct error codes.

---

## 4) Top Users Who Caused Errors (Frequency)

```bash
grep "ERROR" app.log | grep -o "user=[a-z]*" | sort | uniq -c | sort -nr
```

**Meaning:** Identifies users responsible for the most errors.

---

## 5) Top IPs from Access Logs (Traffic / Security)

```bash
cut -d' ' -f1 access.log | sort | uniq -c | sort -nr | head -n 5
```

**Meaning:** Shows the most active IP addresses.

---

## 6) Count Failing HTTP Status Codes (500 / 502)

```bash
grep -E ' (500|502) ' access.log | awk '{print $9}' | sort | uniq -c | sort -nr
```

**Meaning:** Counts server-side failures by status code.

---

## 7) Watch Errors Live (Real-Time)

```bash
tail -f app.log | grep --line-buffered "ERROR"
```

**Meaning:** Live monitoring of errors as they occur.

---

## 8) Extract City from CSV and Uppercase It

```bash
cut -d',' -f3 sales.csv | tail -n +2 | tr 'a-z' 'A-Z'
```

**Meaning:** Prepares clean city names for reporting.

---

## 9) Total Amount of PAID Orders (CSV Sum)

```bash
tail -n +2 sales.csv | grep ",PAID$" | awk -F',' '{sum += $4} END {print sum}'
```

**Meaning:** Calculates total revenue from paid orders.

---

## 10) Count Endpoints Hit in Access Log

```bash
awk -F'"' '{print $2}' access.log | awk '{print $2}' | sort | uniq -c | sort -nr
```

**Meaning:** Identifies most-used APIs or pages.

---

## 11) Normalize Spaces (Clean Text)

```bash
tr -s ' ' < app.log
```

**Meaning:** Makes logs more readable and parse-friendly.

---

## 12) Top 10 Largest Files in a Folder

```bash
du -ah . | sort -hr | head -n 10
```

**Meaning:** Finds files consuming the most disk space.

---

## 13) Extract Usernames from `/etc/passwd`

```bash
cut -d: -f1 /etc/passwd | sort | head
```

**Meaning:** Lists system users.

---

## 14) Find All `.log` Files and Count Lines

```bash
find . -name "*.log" | xargs wc -l
```

**Safer version:**
```bash
find . -name "*.log" -print0 | xargs -0 wc -l
```

**Meaning:** Measures log sizes efficiently.

---

## 15) Save Pipeline Output into a Report File

```bash
grep "ERROR" app.log | grep -o "code=[A-Z0-9]*" | sort | uniq -c | sort -nr > error_report.txt
cat error_report.txt
```

**Meaning:** Generates reusable audit reports.

---

## Quick Cheat Sheet

| Command | Purpose |
|------|------|
| `grep` | filter lines |
| `sort` | sort output |
| `uniq -c` | unique + count |
| `head` / `tail` | top / bottom |
| `cut` | column extraction |
| `tr` | text conversion |
| `awk` | calculations |
| `sed` | text editing |

---

## What a Pipe (`|`) Really Does

The pipe passes the **output of one command** directly as **input to another**.

```
Command A → | → Command B
```

Example:
```bash
grep "ERROR" app.log | wc -l
```

**Tip:** Prefer  
```bash
grep "ERROR" app.log
```  
over  
```bash
cat app.log | grep "ERROR"
```
