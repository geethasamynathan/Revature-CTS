

# Oracle PL/SQL Basics in SQL*Plus 



## 0) One-time SQL\*Plus setting (to see output)

```sql
SET SERVEROUTPUT ON;
```

---

## 1) Declare variables + print (basic)

```sql
BEGIN
  DECLARE
    v_name   VARCHAR2(20) := 'Arun';
    v_age    NUMBER := 22;
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Name: ' || v_name);
    DBMS_OUTPUT.PUT_LINE('Age : ' || v_age);
  END;
END;
/
```

---

## 2) IF / ELSIF / ELSE (control statement)

```sql
BEGIN
  DECLARE
    v_marks NUMBER := 78;
  BEGIN
    IF v_marks >= 90 THEN
      DBMS_OUTPUT.PUT_LINE('Grade: A');
    ELSIF v_marks >= 75 THEN
      DBMS_OUTPUT.PUT_LINE('Grade: B');
    ELSE
      DBMS_OUTPUT.PUT_LINE('Grade: C');
    END IF;
  END;
END;
/
```

---

## 3) CASE statement (simple)

```sql
BEGIN
  DECLARE
    v_day  NUMBER := 3;
    v_name VARCHAR2(20);
  BEGIN
    v_name :=
      CASE v_day
        WHEN 1 THEN 'Monday'
        WHEN 2 THEN 'Tuesday'
        WHEN 3 THEN 'Wednesday'
        ELSE 'Unknown'
      END;

    DBMS_OUTPUT.PUT_LINE('Day is: ' || v_name);
  END;
END;
/
```

---

## 4) Basic LOOP .. EXIT WHEN

```sql
BEGIN
  DECLARE
    v_i NUMBER := 1;
  BEGIN
    LOOP
      DBMS_OUTPUT.PUT_LINE('i = ' || v_i);
      v_i := v_i + 1;
      EXIT WHEN v_i > 5;
    END LOOP;
  END;
END;
/
```

---

## 5) WHILE loop

```sql
BEGIN
  DECLARE
    v_i NUMBER := 1;
  BEGIN
    WHILE v_i <= 5 LOOP
      DBMS_OUTPUT.PUT_LINE('WHILE i = ' || v_i);
      v_i := v_i + 1;
    END LOOP;
  END;
END;
/
```

---

## 6) FOR loop (simplest)

```sql
BEGIN
  BEGIN
    FOR i IN 1..5 LOOP
      DBMS_OUTPUT.PUT_LINE('FOR i = ' || i);
    END LOOP;
  END;
END;
/
```

---

## Quick reminder: Why `/` is required in SQL\*Plus?

- `;` ends **SQL statements**.
- `/` tells SQL\*Plus: **“Send the full PL/SQL block to Oracle now.”**
- Without `/`, SQL\*Plus keeps waiting and you may see line numbers continuing.
