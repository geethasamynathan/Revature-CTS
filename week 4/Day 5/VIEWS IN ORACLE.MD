# Oracle SQL: DEPT + EMP Tables and Complex View Demo (SQL\*Plus Ready)

## Project: Databricks & SQL Assessment Banks

This Markdown contains a complete **SQL\*Plus script** to:

- Create **DEPT** and **EMP** tables
- Insert sample records
- Create **Complex Views**:
  - JOIN-based view
  - Aggregation (GROUP BY) summary view
- Test queries
- Demonstrate that aggregate views are not directly updatable

---

## 1) Drop Objects (Optional)

> Run this to clean up old objects. Errors are handled and ignored if objects don’t exist.

```sql
BEGIN
  EXECUTE IMMEDIATE 'DROP VIEW v_emp_dept';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP VIEW v_dept_salary_summary';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE emp';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE dept';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
```

---

## 2) Create DEPT Table

```sql
CREATE TABLE dept (
  dept_id    NUMBER PRIMARY KEY,
  dept_name  VARCHAR2(30) NOT NULL,
  location   VARCHAR2(30)
);
```

---

## 3) Create EMP Table (with Foreign Key)

```sql
CREATE TABLE emp (
  emp_id     NUMBER PRIMARY KEY,
  emp_name   VARCHAR2(30) NOT NULL,
  job        VARCHAR2(30),
  salary     NUMBER(10,2),
  dept_id    NUMBER,
  CONSTRAINT fk_emp_dept FOREIGN KEY (dept_id) REFERENCES dept(dept_id)
);
```

---

## 4) Insert Records into DEPT

```sql
INSERT INTO dept (dept_id, dept_name, location) VALUES (10, 'IT',       'Chennai');
INSERT INTO dept (dept_id, dept_name, location) VALUES (20, 'HR',       'Bangalore');
INSERT INTO dept (dept_id, dept_name, location) VALUES (30, 'Payroll',  'Hyderabad');
INSERT INTO dept (dept_id, dept_name, location) VALUES (40, 'Sales',    'Mumbai');

COMMIT;
```

---

## 5) Insert Records into EMP

```sql
INSERT INTO emp VALUES (1001, 'Sambit',   'Developer',     15500, 10);
INSERT INTO emp VALUES (1002, 'Santosh',  'Senior Dev',    35000, 10);
INSERT INTO emp VALUES (1003, 'Manoj',    'HR Executive',  17000, 20);
INSERT INTO emp VALUES (1004, 'Rakesh',   'Payroll Exec',  37000, 30);
INSERT INTO emp VALUES (1005, 'Hina',     'Developer',     42000, 10);
INSERT INTO emp VALUES (1006, 'Bikash',   'HR Executive',  15000, 20);
INSERT INTO emp VALUES (1007, 'Priya',    'HR Manager',    67000, 20);
INSERT INTO emp VALUES (1008, 'Preety',   'Payroll Lead',  67000, 30);
INSERT INTO emp VALUES (1009, 'Priyanka', 'Payroll Mgr',   55000, 30);
INSERT INTO emp VALUES (1010, 'Anurag',   'Sales Exec',    15000, 40);
INSERT INTO emp VALUES (1011, 'Rishav',   'Sales Lead',    55000, 40);
INSERT INTO emp VALUES (1012, 'Ram',      'Sales Exec',    12000, 40);

COMMIT;
```

---

# ✅ Complex View Demo

## 6) Complex View 1: JOIN View (EMP + DEPT)

This is a **complex view** because it uses **multiple tables** (JOIN).

```sql
CREATE OR REPLACE VIEW v_emp_dept AS
SELECT 
  e.emp_id,
  e.emp_name,
  e.job,
  e.salary,
  d.dept_name,
  d.location
FROM emp e
JOIN dept d ON d.dept_id = e.dept_id;
```

### Test the JOIN view

```sql
SELECT * FROM v_emp_dept
ORDER BY dept_name, salary DESC;
```

---

## 7) Complex View 2: GROUP BY Summary View

This is a **complex view** because it uses:

- Aggregates (`SUM`, `AVG`, `MAX`, `MIN`, `COUNT`)
- `GROUP BY`
- `LEFT JOIN` to include departments even if they have no employees

```sql
CREATE OR REPLACE VIEW v_dept_salary_summary AS
SELECT
  d.dept_id,
  d.dept_name,
  COUNT(e.emp_id) AS total_emps,
  SUM(e.salary)   AS total_salary,
  AVG(e.salary)   AS avg_salary,
  MAX(e.salary)   AS max_salary,
  MIN(e.salary)   AS min_salary
FROM dept d
LEFT JOIN emp e ON e.dept_id = d.dept_id
GROUP BY d.dept_id, d.dept_name;
```

### Test the summary view

```sql
SELECT * FROM v_dept_salary_summary
ORDER BY dept_id;
```

---

## 8) Show that GROUP BY Views are NOT Directly Updatable

This update should fail because an aggregate view is not updatable:

```sql
UPDATE v_dept_salary_summary
SET total_emps = 99
WHERE dept_id = 10;
```

---

## Extra: Quick Checks

### See all tables in your schema

```sql
SELECT table_name FROM user_tables ORDER BY table_name;
```

### See all views in your schema

```sql
SELECT view_name FROM user_views ORDER BY view_name;
```

### See the view SQL (definition)

```sql
SELECT text
FROM user_views
WHERE view_name IN ('V_EMP_DEPT', 'V_DEPT_SALARY_SUMMARY');
```

---

✅ End of lab.
