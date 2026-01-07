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
