# Oracle SQL: DEFAULT (Default Value) — Simple Notes

> In Oracle, **DEFAULT** is a **column default value** (not a separate constraint like PRIMARY KEY / FOREIGN KEY / CHECK).  
> It automatically inserts a value **only when you omit that column** in an `INSERT`.

---

## 1) DEFAULT with `CREATE TABLE` (Simple Example)

```sql
CREATE TABLE employee_demo (
  emp_id     NUMBER(5) PRIMARY KEY,
  emp_name   VARCHAR2(30) NOT NULL,
  status     VARCHAR2(10) DEFAULT 'ACTIVE',
  created_on DATE DEFAULT SYSDATE
);
```

### Test Insert (omit default columns)

```sql
INSERT INTO employee_demo (emp_id, emp_name)
VALUES (101, 'Arun');

SELECT * FROM employee_demo;
```

✅ Expected behavior:

- `status` becomes **ACTIVE**
- `created_on` becomes **current date/time**

---

## 2) Add/Change DEFAULT after table creation (Using `ALTER TABLE`)

✅ **Yes**, you can add or change a default later using:

### Add/Change default for an existing column

```sql
ALTER TABLE employee_demo
MODIFY (status DEFAULT 'ACTIVE');
```

### Add/Change default for another column

```sql
ALTER TABLE employee_demo
MODIFY (created_on DEFAULT SYSDATE);
```

---

## 3) Important Notes (Very Common Interview Points)

### A) DEFAULT applies only when the column is omitted

```sql
-- DEFAULT applies here (status is omitted)
INSERT INTO employee_demo (emp_id, emp_name)
VALUES (102, 'Divya');
```

### B) If you explicitly insert NULL, DEFAULT will NOT apply

```sql
-- DEFAULT does NOT apply because status is explicitly set to NULL
INSERT INTO employee_demo (emp_id, emp_name, status)
VALUES (103, 'Meena', NULL);
```

### C) DEFAULT does not update old rows automatically

- Defaults affect **future inserts**, not existing data already stored.

---

## 4) Optional: DEFAULT + NOT NULL together

```sql
CREATE TABLE user_demo (
  user_id NUMBER PRIMARY KEY,
  role    VARCHAR2(10) DEFAULT 'USER' NOT NULL
);
```

This ensures:
- If `role` is omitted → it becomes `USER`
- If someone tries to insert `NULL` → Oracle rejects it

---

## Quick Summary

- Use `DEFAULT` to auto-fill values during inserts.
- Use `ALTER TABLE ... MODIFY (col DEFAULT value)` to add/change defaults later.
- DEFAULT works only when the column is **not included** in the INSERT statement.
