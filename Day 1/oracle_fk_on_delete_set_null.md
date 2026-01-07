# Oracle SQL: FOREIGN KEY with `ON DELETE SET NULL` (Full Example)

## 1) What does `ON DELETE SET NULL` do?
When a **parent row** is deleted, Oracle will **NOT delete child rows**.  
Instead, it sets the child’s foreign key column to **NULL**.

✅ Use this when you want to keep child history (employees/orders) even if the parent is removed.

---

## 2) Table Creation (Parent + Child)

### Parent: `DEPARTMENT`
```sql
CREATE TABLE department (
  dept_id   NUMBER PRIMARY KEY,
  dept_name VARCHAR2(30) NOT NULL
);
```

### Child: `EMPLOYEE` (FK with `ON DELETE SET NULL`)
> **Important:** Child foreign key column (`dept_id`) must allow **NULL**, otherwise SET NULL cannot work.

```sql
CREATE TABLE employee (
  emp_id    NUMBER PRIMARY KEY,
  emp_name  VARCHAR2(30) NOT NULL,
  dept_id   NUMBER,
  CONSTRAINT fk_emp_dept
    FOREIGN KEY (dept_id)
    REFERENCES department(dept_id)
    ON DELETE SET NULL
);
```

---

## 3) Insert Records into Both Tables

```sql
-- Parent rows
INSERT INTO department VALUES (10, 'IT');
INSERT INTO department VALUES (20, 'HR');

-- Child rows
INSERT INTO employee VALUES (101, 'Arun', 10);
INSERT INTO employee VALUES (102, 'Divya', 10);
INSERT INTO employee VALUES (103, 'Kumar', 20);

COMMIT;
```

---

## 4) View Child Table BEFORE deleting parent

```sql
SELECT * FROM employee ORDER BY emp_id;
```

**Expected output (example):**

| EMP_ID | EMP_NAME | DEPT_ID |
|------:|----------|--------:|
| 101   | Arun     | 10      |
| 102   | Divya    | 10      |
| 103   | Kumar    | 20      |

---

## 5) Delete a Parent Record (dept_id = 10)

```sql
DELETE FROM department WHERE dept_id = 10;
COMMIT;
```

✅ This succeeds because Oracle automatically handles child rows using SET NULL.

---

## 6) View Child Table AFTER deleting parent

```sql
SELECT * FROM employee ORDER BY emp_id;
```

**Expected output (example):**

| EMP_ID | EMP_NAME | DEPT_ID |
|------:|----------|--------:|
| 101   | Arun     | NULL    |
| 102   | Divya    | NULL    |
| 103   | Kumar    | 20      |

---

## 7) Explanation (How it works)

### Before delete
- Employees **101** and **102** were linked to **department 10**

### After deleting department 10
- Oracle keeps employee rows (history remains)
- Oracle removes the relationship by setting:
  - `employee.dept_id = NULL` for those employees

### Employee 103 is unchanged
- Because it belongs to department **20**, which still exists

---

## Quick Comparison (When to use what)

- **ON DELETE CASCADE** → deletes child rows automatically (strict cleanup)
- **ON DELETE SET NULL** → keeps child rows, removes the parent link (history kept)
