
**Expected command:**
- `chmod 600`

---

## 🔹 PART 6: Backup & File Operations (cp, mv, rm)

### 🎯 Task 11: Backup Configuration Files

- Copy all `.env` files into `backup/`
- Preserve permissions

**Expected commands:**
- `cp -p`
- `*.env`

---

### 🎯 Task 12: Archive Old Logs

- Move `app.log` to `backup/`
- Rename it with date (example: `app_2025-12-16.log`)

**Expected command:**
- `mv`

---

### 🎯 Task 13: Cleanup

1. Delete `error.log`
2. Remove `scripts/` directory if empty

**Expected commands:**
- `rm`
- `rmdir`

---

## 🔹 PART 7: Verification

### 🎯 Task 14: Verify Final Structure

Display full directory structure with permissions.

**Expected commands:**
- `ls -l`
- `ls -R`

---

## 🧠 BONUS INTERVIEW QUESTIONS

1. Why does a directory need execute (`x`) permission?
2. Why is `tail -f` used in production servers?
3. Difference between `rm` and `rmdir`
4. Why is `cp -p` important for backups?

---

