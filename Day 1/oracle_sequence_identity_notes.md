# Oracle SQL: SEQUENCE (Complete Example) + IDENTITY vs SEQUENCE

## 1) What is a SEQUENCE in Oracle?
A **SEQUENCE** is an Oracle object that generates **unique numbers** (1, 2, 3, …).  
It is commonly used to create **primary key values** (surrogate keys).

---

## 2) Example: One SEQUENCE used across multiple tables (Global ID Pattern)

### Step A — Create one shared sequence
```sql
CREATE SEQUENCE global_id_seq
START WITH 1000
INCREMENT BY 1
NOCYCLE
CACHE 50;
```

### Step B — Create multiple tables that use this sequence
```sql
CREATE TABLE customers (
  customer_id   NUMBER PRIMARY KEY,
  customer_name VARCHAR2(50) NOT NULL,
  created_on    DATE DEFAULT SYSDATE
);

CREATE TABLE orders (
  order_id    NUMBER PRIMARY KEY,
  customer_id NUMBER NOT NULL,
  order_date  DATE DEFAULT SYSDATE,
  amount      NUMBER(10,2) NOT NULL,
  CONSTRAINT fk_orders_customer
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE payments (
  payment_id  NUMBER PRIMARY KEY,
  order_id    NUMBER NOT NULL,
  paid_on     DATE DEFAULT SYSDATE,
  paid_amount NUMBER(10,2) NOT NULL,
  CONSTRAINT fk_payments_order
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);
```

### Step C — Insert using `global_id_seq.NEXTVAL`
```sql
-- Insert customer
INSERT INTO customers (customer_id, customer_name)
VALUES (global_id_seq.NEXTVAL, 'Arun Kumar');

-- Insert order (sequence again for order_id)
INSERT INTO orders (order_id, customer_id, amount)
VALUES (global_id_seq.NEXTVAL,
        (SELECT MAX(customer_id) FROM customers),
        2500.00);

-- Insert payment (sequence again for payment_id)
INSERT INTO payments (payment_id, order_id, paid_amount)
VALUES (global_id_seq.NEXTVAL,
        (SELECT MAX(order_id) FROM orders),
        2500.00);

COMMIT;
```

### Step D — Verify
```sql
SELECT * FROM customers;
SELECT * FROM orders;
SELECT * FROM payments;
```

✅ You will see IDs like **1000 (customer)**, **1001 (order)**, **1002 (payment)** etc.  
This is the advantage of a **global ID sequence**.

---

## 3) Most common production pattern: One sequence per table

```sql
CREATE SEQUENCE customer_seq START WITH 1 INCREMENT BY 1 NOCYCLE CACHE 20;
CREATE SEQUENCE order_seq    START WITH 1 INCREMENT BY 1 NOCYCLE CACHE 20;
CREATE SEQUENCE payment_seq  START WITH 1 INCREMENT BY 1 NOCYCLE CACHE 20;
```

Insert:
```sql
INSERT INTO customers (customer_id, customer_name)
VALUES (customer_seq.NEXTVAL, 'Divya');

INSERT INTO orders (order_id, customer_id, amount)
VALUES (order_seq.NEXTVAL, 1, 1500);
```

✅ Each table has its own numbering series.

---

## 4) IDENTITY in Oracle (Auto increment column)

Oracle supports **IDENTITY columns** (simple auto-increment per table).

```sql
CREATE TABLE products (
  product_id   NUMBER GENERATED ALWAYS AS IDENTITY,
  product_name VARCHAR2(50) NOT NULL,
  price        NUMBER(10,2) NOT NULL,
  CONSTRAINT pk_products PRIMARY KEY (product_id)
);
```

Insert (no id required):
```sql
INSERT INTO products (product_name, price)
VALUES ('Mouse', 499);

SELECT * FROM products;
```

---

## 5) When to use IDENTITY vs SEQUENCE

### Use **IDENTITY** when:
- You want **simple auto-increment** per table
- You do not need to share ID generation across tables
- You prefer simpler inserts (no `NEXTVAL`)

### Use **SEQUENCE** when:
- You need **one sequence across multiple tables** (global IDs)
- You need more control: start, increment, cache, cycle, etc.
- You want to generate IDs **before insert** / outside table logic
- Useful for batch loads, staging tables, integrations

---

## 6) Similarities and Differences (Quick Table)

| Feature | SEQUENCE | IDENTITY |
|---|---|---|
| Generates unique numbers | ✅ Yes | ✅ Yes |
| Can be shared across multiple tables | ✅ Yes | ❌ No (tied to one column) |
| Separate object needed | ✅ `CREATE SEQUENCE` | ❌ Built into column |
| Insert style | Must use `seq.NEXTVAL` | Insert without id |
| Best for simple PK auto increment | OK but manual | ✅ Best |
| Best for advanced/global ID control | ✅ Best | Limited |

---

## 7) Important note: Gaps are normal (both SEQUENCE and IDENTITY)

You may see missing numbers due to:
- rollbacks
- cached values
- failed inserts

So **do not expect continuous numbering** (1,2,3 without gaps).

---

## Extra: Check current sequence value
```sql
SELECT global_id_seq.CURRVAL FROM dual;  -- works only after NEXTVAL has been used in your session
SELECT global_id_seq.NEXTVAL FROM dual;  -- generates the next value
```
