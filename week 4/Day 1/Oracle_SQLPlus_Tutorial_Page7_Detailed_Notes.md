## 1) Learning Objectives

- Understand key Oracle datatypes used in table design (VARCHAR2, NUMBER, DATE, RAW/LONG RAW, LOB).
- Create tables and enforce rules using constraints (PRIMARY KEY, FOREIGN KEY, CHECK).
- Use SQL*Plus DESCRIBE to inspect table structure.
- Use CTAS ( CREATE TABLE ... AS SELECT ... ) for copies, subsets, and “structure only”.
- Alter tables (add columns, modify datatypes), and remove tables (DROP).
- Check metadata using USER_TABLES and USER_CONSTRAINTS .
- Create indexes (single-column and composite) as a performance tool.

## 2) Oracle Datatypes (as explained on Page 7)

### VARCHAR2(size)

- Stores character values (letters, digits, punctuation).
- Example: VARCHAR2(25) stores up to 25 characters.
- Trainer tip: Prefer VARCHAR2 over VARCHAR .

### NUMBER(precision, scale)

- Stores integers or decimals.
- precision : total digits; scale : digits after decimal.
- Example: NUMBER(6,2) supports values like -999.99 to 999.99.

### DATE

- Stores date and time.
- If you insert a date without a time, Oracle uses 00:00:00 by default.
- Trainer tip: date conversions often use TO_DATE and display formatting uses TO_CHAR .

### RAW / LONG RAW

- Binary data: RAW up to 255 characters; LONG RAW up to 2GB.
- Page note: RAW/LONG RAW cannot be indexed and are not shown/queried well in SQL*Plus.
- Only one RAW column per table.

### LOB (BLOB / CLOB)

- Large Object storage.
- CLOB : large text; BLOB : large binary (images/video).
- More than one LOB column is allowed in a table.

### Common selection guidance

- Names, emails, cities → VARCHAR2
- Amount, salary → NUMBER
- Join date, DOB → DATE
- Documents/images → CLOB/BLOB

## 3) NULL vs NOT NULL

You can mark a column as NULL or NOT NULL .
      If you do not mention either, Oracle treats the column as NULL allowed by default.

## 4) Naming Rules + Case Insensitivity

- Up to 255 columns in a table.
- Table/column names must start with a letter.
- No spaces; underscore is allowed.
- Oracle treats unquoted names as case-insensitive (EMPLOYEE = Employee = employee).

```sql
SELECT lname, fname, address FROM employee;
SELECT LNAME, FNAME, ADDRESS FROM EMPLOYEE;
SELECT Lname, Fname, Address FROM Employee;
```

## 5) CREATE TABLE: employee (Page 7 example)

The page creates an employee table with 10 columns and uses NOT NULL on required fields.
      SQL*Plus shows line numbers while typing (2, 3, 4...), but the tutorial later omits them to make copy/paste easier.

```sql
CREATE TABLE employee
(employeeid VARCHAR2(9) NOT NULL,
 fname VARCHAR2(8),
 minit VARCHAR2(2),
 lname VARCHAR2(8),
 bdate DATE,
 address VARCHAR2(27),
 sex VARCHAR2(1),
 salary NUMBER(7) NOT NULL,
 superempid VARCHAR2(9),
 dno NUMBER(1) NOT NULL);
```

## 6) DESCRIBE in SQL*Plus

DESCRIBE is a SQL*Plus command (not a normal SQL keyword). It prints the table structure.

```sql
DESCRIBE employee;
```

```sql
Name                                      Null?    Type
----------------------------------------- -------- -------------------------
EMPLOYEEID                                NOT NULL VARCHAR2(9)
FNAME                                              VARCHAR2(8)
MINIT                                              VARCHAR2(2)
LNAME                                              VARCHAR2(8)
BDATE                                              DATE
ADDRESS                                            VARCHAR2(27)
SEX                                                VARCHAR2(1)
SALARY                                    NOT NULL NUMBER(7)
SUPEREMPID                                         VARCHAR2(9)
DNO                                       NOT NULL NUMBER(1)
```
```sql
-- 20 sample employees (Indian names, realistic data)
-- salaries include both <=50000 and >50000
-- department numbers include multiple 1's for emp_department_1
INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000001','Arun','K','Kumar',   DATE '1992-04-12','Chennai, TN','M',48000,1,'Sures');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000002','Divya','R','Sharma', DATE '1994-09-03','Bengaluru, KA','F',52000,1,'Priya');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000003','Mubeen','A','Khan',  DATE '1990-01-20','Hyderabad, TS','M',61000,2,'Priya');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000004','Anita','S','Iyer',   DATE '1995-07-18','Coimbatore, TN','F',45000,3,'Sures');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000005','Ravi','M','Nair',    DATE '1989-11-05','Kochi, KL','M',70000,1,'Rahul');


INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000006','Karthik','P','Rao',  DATE '1991-03-28','Mysuru, KA','M',56000,2,'Rahul');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000007','Sneha','V','Gupta',  DATE '1996-12-14','Pune, MH','F',39000,4,'Sures');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000008','Vikram','J','Singh', DATE '1988-06-22','Delhi, DL','M',85000,5,'Deepak');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000009','Meena','T','Das',    DATE '1993-08-09','Kolkata, WB','F',51000,1,'Priya');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000010','Sures','N','Babu',   DATE '1985-02-01','Chennai, TN','M',95000,1,'Deepak');


INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000011','Priya','L','Menon',  DATE '1987-10-25','Thiruvananthapuram, KL','F',78000,2,'Deepak');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000012','Rahul','D','Jain',   DATE '1986-05-17','Ahmedabad, GJ','M',64000,3,'Deepak');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000013','Deepak','S','Yadav', DATE '1984-09-30','Mumbai, MH','M',105000,5,'Deepak');


INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000014','Sana','H','Ali',     DATE '1997-01-11','Lucknow, UP','F',42000,4,'Priya');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000015','Rohit','B','Patel',  DATE '1992-06-06','Surat, GJ','M',53000,1,'Rahul');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000016','Lakshmi','G','Reddy',DATE '1991-12-02','Vijayawada, AP','F',58000,2,'Priya');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000017','Naveen','R','Mishra',DATE '1990-04-19','Bhopal, MP','M',47000,3,'Sures');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000018','Ayesha','S','Begum', DATE '1995-03-07','Chennai, TN','F',62000,1,'Priya');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000019','Sanjay','K','Joshi', DATE '1989-08-15','Jaipur, RJ','M',49900,4,'Rahul');

INSERT INTO employee (employeeid, fname, minit, lname, bdate, address, sex, salary, dno, manager)
VALUES ('E00000020','Keerthi','M','N',    DATE '1996-05-23','Bengaluru, KA','F',75000,2,'Sures');

COMMIT;

```

``` sql
SELECT COUNT(*) FROM employee;
SELECT COUNT(*) FROM employee WHERE dno = 1;
SELECT COUNT(*) FROM employee WHERE salary > 50000;
```
## 7) CTAS: Create Table As Select (3 patterns from Page 7)

### 7.1 Create a table using only selected columns + rows

New table emp_department_1 uses a subset of columns and includes only employees where dno = 1 .

```sql
CREATE TABLE emp_department_1 AS
SELECT fname, minit, lname, bdate
FROM employee
WHERE dno = 1;
```

### 7.2 Create a table using all columns but filtered rows

```sql
CREATE TABLE high_pay_emp AS
SELECT *
FROM employee
WHERE salary > 50000;
```

### 7.3 Copy structure only (no data) using a false WHERE condition

The condition 3=5 is always false, so only the structure is copied.

```sql
CREATE TABLE copy_of_employee AS
SELECT *
FROM employee
WHERE 3=5;
```

## 8) Constraints: Primary Key, Foreign Key, Check (Page 7)

### 8.1 Primary Key constraint example

The page drops and re-creates the employee table, adding a named PRIMARY KEY constraint on employeeid .

```sql
DROP TABLE employee;

CREATE TABLE employee
(employeeid VARCHAR2(9) NOT NULL,
 fname      VARCHAR2(8),
 minit      VARCHAR2(2),
 lname      VARCHAR2(8),
 bdate      DATE,
 address    VARCHAR2(27),
 sex        VARCHAR2(1),
 salary     NUMBER(7) NOT NULL,
 superempid VARCHAR2(9),
 dno        NUMBER(1) NOT NULL,
 CONSTRAINT pk_employee PRIMARY KEY (employeeid));
```

### 8.2 Foreign Key + ON DELETE CASCADE example

The tutorial creates department first (parent), then creates employee (child) where employee.dno references department.dnumber .

```sql
DROP TABLE department;

CREATE TABLE department
(dnumber NUMBER(1),
 dname VARCHAR2(15),
 mgrempid VARCHAR2(9),
 mgrstartdate DATE,
 CONSTRAINT pk_department PRIMARY KEY (dnumber));

DROP TABLE employee;

CREATE TABLE employee
(employeeid VARCHAR2(9) NOT NULL,
 fname VARCHAR2(8),
 minit VARCHAR2(2),
 lname VARCHAR2(8),
 bdate DATE,
 address VARCHAR2(27),
 sex VARCHAR2(1),
 salary NUMBER(7) NOT NULL,
 superempid VARCHAR2(9),
 dno NUMBER(1) NOT NULL,
 CONSTRAINT pk_employee PRIMARY KEY (employeeid),
 CONSTRAINT fk_department FOREIGN KEY (dno)
   REFERENCES department (dnumber) ON DELETE CASCADE);
```

### 8.3 CHECK constraints example + error demo

CHECK constraints validate values during INSERT/UPDATE.
      Here, the tutorial restricts sex to 'M' or 'F' and forces salary > 10000.

```sql
CREATE TABLE employee
(employeeid VARCHAR2(9) NOT NULL,
 fname       VARCHAR2(8),
 minit       VARCHAR2(2),
 lname       VARCHAR2(8),
 bdate       DATE,
 address     VARCHAR2(27),
 sex         VARCHAR2(1) CONSTRAINT ck_sex CHECK (sex IN ('M', 'F')),
 salary      NUMBER(7) NOT NULL CONSTRAINT ck_salary CHECK (salary > 10000),
 superempid  VARCHAR2(9),
 dno         NUMBER(1) NOT NULL,
 CONSTRAINT pk_employee PRIMARY KEY (employeeid),
 CONSTRAINT fk_dno FOREIGN KEY (dno)
   REFERENCES department (dnumber)
   ON DELETE CASCADE);
```

```sql
INSERT INTO employee VALUES
('123456789', 'Joe', 'M', 'Smith', '01-JUN-45',
 '123 Smith St.', 'm', 45000, '123456789', 1);

-- ORA-02290: check constraint (HOLOWCZAK.CK_SEX) violated
```

### 8.4 Constraint naming convention used in the tutorial

| Prefix | Meaning | Example |
| --- | --- | --- |
| pk_ | Primary Key | pk_employee |
| fk_ | Foreign Key | fk_department , fk_dno |
| ck_ | Check constraint | ck_sex , ck_salary |

## 9) ALTER TABLE: ADD / MODIFY (Page 7)

Page 7 shows how to add a new column and change an existing column's datatype.

```sql
DESCRIBE emp_department_1;
```

```sql
ALTER TABLE emp_department_1
ADD (manager VARCHAR2(8));

ALTER TABLE emp_department_1
MODIFY (fname VARCHAR2(15));
```

```sql
DESCRIBE emp_department_1;
```

## 10) Change Datatype When Data Exists (Temp Table Trick)

If a table has rows and you still need to change a datatype, the tutorial suggests:
      copy rows to a temp table, clear original, alter structure, then re-insert the data.

```sql
CREATE TABLE temp AS SELECT * FROM emp_department_1;
DELETE FROM emp_department_1;

ALTER TABLE emp_department_1
MODIFY (manager VARCHAR2(15));

INSERT INTO emp_department_1
SELECT * FROM temp;

DROP TABLE temp;
```

## 11) Drop a Column (Temp Table Trick shown on Page 7)

The page demonstrates dropping a column by rebuilding the table using CTAS.
      Example goal: remove salary from Employee by not selecting it into temp.

```sql
CREATE TABLE temp AS
SELECT employeeid, fname, minit, lname, bdate, address,
sex, superssn, dno
FROM employee;

DROP TABLE employee;

CREATE TABLE employee AS
SELECT * FROM temp;
```

## 12) DROP TABLE (Page 7)

```sql
DROP TABLE emp_department_1;
```

## 13) Catalog Views: USER_TABLES / USER_CONSTRAINTS

Data dictionary views help you inspect what exists in your schema.

```sql
SELECT table_name FROM USER_TABLES;
```

```sql
SELECT constraint_name, constraint_type, table_name
FROM user_constraints;
```

### How to read CONSTRAINT_TYPE (as noted on the page)

- C → Check constraint (could include NOT NULL system checks)
- P → Primary key
- R → Referential integrity (Foreign key)

## 14) Exercise 2: Creating Indexes

The page asks you to build:

- An index on STUDENTS(StudentName)
- A composite index on COURSES(semester, year) (together)

```sql
CREATE INDEX idx_students_studentname
ON students (studentname);

CREATE INDEX idx_courses_sem_year
ON courses (semester, year);
```

```sql
SELECT index_name, table_name
FROM user_indexes
ORDER BY table_name, index_name;

SELECT index_name, column_name, column_position
FROM user_ind_columns
ORDER BY index_name, column_position;
```

## 15) Extra Trainer Notes + Common Mistakes

### 15.1 Common mistakes students make

- Forgetting parent table first: FK creation fails if department table/PK is missing.
- Case mismatch in CHECK values: CHECK uses exact match; 'm' is not 'M'.
- Not naming constraints: You later struggle to read errors and manage constraints.
- CTAS copies columns but not all rules: Primary keys, foreign keys, and indexes must often be recreated.

### 15.2 Mini practice questions

1. Why does WHERE 3=5 create a table without any rows?
2. What happens to child records when you use ON DELETE CASCADE ?
3. Why does inserting sex='m' fail with the given CHECK constraint?
4. When should you use a composite index instead of two separate indexes?
