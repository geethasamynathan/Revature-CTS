# SQL*Plus Working Commands Notes (Oracle 21c XE)

## 1) SQL*Plus Login & Connection (What you see on screen)
When you open SQL*Plus and login successfully (example: `system` user), SQL*Plus shows:

- **SQL*Plus Release / Version**  
  This is the SQL*Plus client version installed on your machine.
- **Connected to: Oracle Database 21c Express Edition (XE)**  
  Confirms you are connected to the Oracle XE database.
- **SQL>** prompt  
  Means SQL*Plus is ready to accept SQL commands.

✅ You are connected and can run SQL queries.

---

## 2) `DUAL` Table (Why we use it)
`DUAL` is a special **one-row, one-column** dummy table in Oracle.

We use it when:
- We want to call functions (like `SYSDATE`, `ADD_MONTHS`)  
- We don’t need real table data

Example:
```sql
SELECT SYSDATE FROM DUAL;
```

---

## 3) Get Current Database Date & Time: `SYSDATE`
### ✅ Command
```sql
SELECT SYSDATE FROM DUAL;
```

### ✅ What it does
- Returns the **current date & time of the database server**
- Output format depends on `NLS_DATE_FORMAT`

### ✅ Your Output (example)
`06-JAN-26`

> Note: Time is also present internally, but SQL*Plus may display only date depending on session settings.

---

## 4) Add Days to a Date (Date Arithmetic): `SYSDATE + number`
### ✅ Command (add 10 days)
```sql
SELECT SYSDATE + 10 FROM DUAL;
```

### ✅ What it does
- In Oracle, **adding a number to a DATE adds days**
  - `+1` = add 1 day
  - `+10` = add 10 days

### ✅ Your Output (example)
`16-JAN-26`

**More examples**
```sql
-- Yesterday
SELECT SYSDATE - 1 FROM DUAL;

-- After 2.5 days (2 days + 12 hours)
SELECT SYSDATE + 2.5 FROM DUAL;
```

---

## 5) Display Date/Time in Your Format: `TO_CHAR`
### ✅ Command
```sql
SELECT TO_CHAR(SYSDATE,'MM-DD-YYYY HH:MI:SS') "NOW" FROM DUAL;
```

### ✅ What it does
Converts a DATE to formatted text.

### ✅ Important format parts
- `MM` = Month (01-12)
- `DD` = Day (01-31)
- `YYYY` = 4-digit year
- `HH` = hour (1–12)
- `HH24` = hour (0–23) ✅ (recommended for 24-hour format)
- `MI` = minutes ✅ (many people confuse `MI` with month)
- `SS` = seconds

### ✅ Your Output (example)
`01-06-2026 08:02:47`

**Better (24-hour) version**
```sql
SELECT TO_CHAR(SYSDATE,'DD-MM-YYYY HH24:MI:SS') AS NOW FROM DUAL;
```

---

## 6) Add Months to a Date: `ADD_MONTHS(date, n)`
### ✅ Command (add 2 months)
```sql
SELECT ADD_MONTHS(SYSDATE, 2) FROM DUAL;
```

### ✅ What it does
- Adds **n months** to the given date
- Handles month-end logic automatically

### ✅ Your Output (example)
`06-MAR-26`

**More examples**
```sql
-- 6 months back
SELECT ADD_MONTHS(SYSDATE, -6) FROM DUAL;
```

---

## 7) Find Last Day of the Month: `LAST_DAY(date)`
### ✅ Command
```sql
SELECT LAST_DAY(SYSDATE) FROM DUAL;
```

### ✅ What it does
- Returns the **last date of the month** for the given date

### ✅ Your Output (example)
`31-JAN-26`

**Example use-case (salary / month-end reports)**
- “Give me the month-end date for current month”
- “Calculate monthly deadlines”

---

## 8) Using `LAST_DAY` With a Specific Date (Correct Working Style)
When you pass a *date literal as text*, always convert it using `TO_DATE` with a format model.

✅ Working Examples:
```sql
-- If your input is DD-MM-YYYY
SELECT LAST_DAY(TO_DATE('10-04-2026','DD-MM-YYYY')) FROM DUAL;

-- If your input is MM-DD-YYYY
SELECT LAST_DAY(TO_DATE('10-04-2026','MM-DD-YYYY')) FROM DUAL;
```

> Tip: The correct format depends on how you typed the date string and your session’s `NLS_DATE_FORMAT`.

---

## Quick Summary (Cheat Sheet)
| Task | Function / Syntax | Example |
|------|--------------------|---------|
| Current date/time | `SYSDATE` | `SELECT SYSDATE FROM DUAL;` |
| Add days | `date + n` | `SELECT SYSDATE + 10 FROM DUAL;` |
| Format date/time | `TO_CHAR(date,'fmt')` | `TO_CHAR(SYSDATE,'DD-MM-YYYY HH24:MI:SS')` |
| Add months | `ADD_MONTHS(date,n)` | `ADD_MONTHS(SYSDATE,2)` |
| Last day of month | `LAST_DAY(date)` | `LAST_DAY(SYSDATE)` |
| Convert string to date | `TO_DATE('str','fmt')` | `TO_DATE('10-04-2026','DD-MM-YYYY')` |

---


# Oracle `LAST_DAY` Queries – Difference

## Query 1: Using `TO_DATE` (String → DATE conversion)
```sql
SELECT LAST_DAY(TO_DATE('10-04-2026','DD-MM-YYYY')) AS last_day
FROM DUAL;
```

### What it does
- `'10-04-2026'` is a **string** (text).
- `TO_DATE('10-04-2026','DD-MM-YYYY')` **parses the string** into a **DATE**.
- `LAST_DAY()` returns the **last date of that month**.

### When to use
- When the date is coming as **text** (CSV/file/UI/API input).

### Notes / Risks
- If the string doesn’t match the format mask, you may get errors like:
  - `ORA-01861: literal does not match format string`
- Safe from NLS issues **because you explicitly gave the format mask**.

---

## Query 2: Using DATE literal (Direct DATE value)
```sql
SELECT LAST_DAY(DATE '2026-04-10') AS last_day
FROM DUAL;
```

### What it does
- `DATE '2026-04-10'` is an Oracle **DATE literal** (already a DATE, not a string).
- No parsing is needed.
- `LAST_DAY()` returns the **last date of that month**.

### When to use
- When you want to hardcode a date in SQL in the **cleanest and safest way**.

### Benefits
- No string conversion
- No format-mask mismatch
- No dependency on `NLS_DATE_FORMAT`

---

## Key Difference (One Line)
- **Query 1:** Converts **string → DATE** using a format mask  
- **Query 2:** Uses a **native DATE literal** directly (no conversion)

✅ Both queries return the same result for April 2026: **30-APR-2026**  
(Display depends on your session date format)

-----

`SELECT SYSDATE, LAST_DAY(SYSDATE) "Last", LAST_DAY(SYSDATE) - SYSDATE "Days Left" FROM DUAL;`