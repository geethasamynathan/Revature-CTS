# Oracle SQL: FOREIGN KEY Constraint — With ON DELETE CASCADE + (Oracle note on ON UPDATE CASCADE)

## 1) Scenario (Real-world)
**Department (Parent)** → **Employee (Child)**

- One department can have many employees  
- Each employee must belong to a valid department  
- Foreign key prevents “orphan” child records

---

## 2) Case A: FOREIGN KEY **WITHOUT** `ON DELETE CASCADE` (Delete should FAIL)

### 2.1 Create tables
```sql
-- Parent table
CREATE TABLE department (
  dept_id   NUMBER PRIMARY KEY,
  dept_name VARCHAR2(30) NOT NULL
);

-- Child table (FK without cascade)
CREATE TABLE employee (
  emp_id    NUMBER PRIMARY KEY,
  emp_name  VARCHAR2(30) NOT NULL,
  dept_id   NUMBER NOT NULL,
  CONSTRAINT fk_emp_dept
    FOREIGN KEY (dept_id)
    REFERENCES department(dept_id)
);
```

### 2.2 Insert records into both tables
```sql
INSERT INTO department VALUES (10, 'IT');
INSERT INTO department VALUES (20, 'HR');

INSERT INTO employee VALUES (101, 'Arun', 10);
INSERT INTO employee VALUES (102, 'Divya', 10);
INSERT INTO employee VALUES (103, 'Kumar', 20);

COMMIT;
```

### 2.3 Try deleting a parent row (should FAIL)
```sql
DELETE FROM department WHERE dept_id = 10;
```

✅ Expected error:
- `ORA-02292: integrity constraint ... violated - child record found`

### Why it fails?
Employees **101** and **102** still reference department **10**.  
Oracle blocks the delete to keep referential integrity.

---

## 3) Case B: FOREIGN KEY **WITH** `ON DELETE CASCADE` (Delete should remove children automatically)

### 3.1 Cleanup (drop child first, then parent)
```sql
DROP TABLE employee;
DROP TABLE department;
```

### 3.2 Create tables (with ON DELETE CASCADE)
```sql
CREATE TABLE department (
  dept_id   NUMBER PRIMARY KEY,
  dept_name VARCHAR2(30) NOT NULL
);

CREATE TABLE employee (
  emp_id    NUMBER PRIMARY KEY,
  emp_name  VARCHAR2(30) NOT NULL,
  dept_id   NUMBER NOT NULL,
  CONSTRAINT fk_emp_dept
    FOREIGN KEY (dept_id)
    REFERENCES department(dept_id)
    ON DELETE CASCADE
);
```

### 3.3 Insert records again
```sql
INSERT INTO department VALUES (10, 'IT');
INSERT INTO department VALUES (20, 'HR');

INSERT INTO employee VALUES (101, 'Arun', 10);
INSERT INTO employee VALUES (102, 'Divya', 10);
INSERT INTO employee VALUES (103, 'Kumar', 20);

COMMIT;
```

### 3.4 Verify employees in dept 10 (before delete)
```sql
SELECT * FROM employee WHERE dept_id = 10;
```

### 3.5 Delete parent dept 10 (CASCADE happens)
```sql
DELETE FROM department WHERE dept_id = 10;
COMMIT;
```

### 3.6 Verify results
```sql
-- Dept 10 removed
SELECT * FROM department;

-- Employees of dept 10 automatically removed
SELECT * FROM employee;
```

### How ON DELETE CASCADE works
When you delete **department 10**, Oracle automatically deletes all rows in **employee** where `dept_id = 10`.

✅ Deleted automatically:
- Employee 101
- Employee 102

✅ Still remains:
- Employee 103 (belongs to dept 20)

---

## 4) ON UPDATE CASCADE in Oracle? (Important)

### ❌ Oracle does NOT support `ON UPDATE CASCADE` in FOREIGN KEY syntax

This is **not valid Oracle syntax**:
```sql
FOREIGN KEY (dept_id) REFERENCES department(dept_id) ON UPDATE CASCADE
```

### Why?
Oracle expects primary keys should generally **not be updated** in real production systems.

---

## 5) If you still want “Update Cascade” behavior (Trigger approach - Training Demo)

> Best practice: **avoid updating PKs**.  
> But for learning, here is how to simulate cascade update using a trigger.

### 5.1 Recreate tables (no cascade update exists)
```sql
DROP TABLE employee;
DROP TABLE department;

CREATE TABLE department (
  dept_id   NUMBER PRIMARY KEY,
  dept_name VARCHAR2(30) NOT NULL
);

CREATE TABLE employee (
  emp_id    NUMBER PRIMARY KEY,
  emp_name  VARCHAR2(30) NOT NULL,
  dept_id   NUMBER NOT NULL,
  CONSTRAINT fk_emp_dept
    FOREIGN KEY (dept_id)
    REFERENCES department(dept_id)
);
```

### 5.2 Insert sample data
```sql
INSERT INTO department VALUES (10, 'IT');
INSERT INTO employee VALUES (101, 'Arun', 10);
INSERT INTO employee VALUES (102, 'Divya', 10);
COMMIT;
```

### 5.3 Trigger to simulate ON UPDATE CASCADE
```sql
CREATE OR REPLACE TRIGGER trg_dept_id_update
AFTER UPDATE OF dept_id ON department
FOR EACH ROW
BEGIN
  UPDATE employee
  SET dept_id = :NEW.dept_id
  WHERE dept_id = :OLD.dept_id;
END;
/
```

### 5.4 Update the parent PK (demo only)
```sql
UPDATE department
SET dept_id = 11
WHERE dept_id = 10;

COMMIT;
```

### 5.5 Verify child rows updated
```sql
SELECT * FROM employee;
```

✅ Employees’ `dept_id` changes from **10 → 11**

---

## Quick Summary
- ✅ FOREIGN KEY enforces valid parent-child relationship
- ✅ ON DELETE CASCADE deletes child rows automatically when parent is deleted
- ❌ ON UPDATE CASCADE is not supported in Oracle FK syntax
- ✅ Trigger can simulate update cascade (training/demo use)
