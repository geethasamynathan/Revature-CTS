# Core Java — Functional Programming Notes
*(Functional Interfaces, Lambdas, Method References, Optional)*

> Trainer-style notes with: **Definition**, **Real-world scenario**, **Example code**, **Explanation**

---

## 1) Functional Interfaces

### ✅ Definition
A **Functional Interface** is an interface that has **exactly one abstract method** (SAM — Single Abstract Method).  
It may still contain:
- `default` methods
- `static` methods  
…but only **one abstract** method is allowed.

Java provides many built-in functional interfaces in `java.util.function`, such as:
- **Predicate<T>** → takes `T`, returns `boolean`
- **Function<T, R>** → takes `T`, returns `R`
- **Consumer<T>** → takes `T`, returns nothing
- **Supplier<T>** → takes nothing, returns `T`
- **BiFunction<T, U, R>** → takes `T` and `U`, returns `R`

✅ Functional interfaces are used to pass **behavior (logic)** as input.

---

### 🌍 Real-world scenario
**E-commerce discount rules**: Different discount logic for different customers (Festival, Premium, Coupon, etc.).  
Instead of writing multiple `if/else`, pass a rule as a functional interface.

### 💻 Example (Custom Functional Interface)
```java
@FunctionalInterface
interface DiscountRule {
    double apply(double cartAmount);   // only 1 abstract method
}

class DiscountService {
    public double finalAmount(double cartAmount, DiscountRule rule) {
        return cartAmount - rule.apply(cartAmount);
    }
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        DiscountService service = new DiscountService();

        DiscountRule festivalDiscount = amount -> amount * 0.10;  // 10% off
        DiscountRule premiumDiscount  = amount -> amount * 0.15;  // 15% off

        System.out.println("Festival Final: " + service.finalAmount(1000, festivalDiscount));
        System.out.println("Premium Final : " + service.finalAmount(1000, premiumDiscount));
    }
}
```

### 🧠 Explanation
- `DiscountRule` is a functional interface (only one abstract method: `apply`).
- We pass different discount logic using lambdas.
- `finalAmount()` becomes reusable for any discount rule.

---

## 2) Lambdas

### ✅ Definition
A **Lambda expression** is a short way to write an **anonymous function** (function without a name).  
It provides the implementation for a **functional interface**.

### ✅ Syntax
```java
(parameters) -> { body }
```

Examples:
- `(x) -> x * 2`
- `(a, b) -> a + b`
- `name -> System.out.println(name)`

✅ Lambdas reduce boilerplate code, especially with collections and streams.

---

### 🌍 Real-world scenario
**HR System**: Find employees eligible for a bonus (salary > 50,000).

### 💻 Example (Using `Predicate`)
```java
import java.util.*;
import java.util.function.Predicate;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id; this.name = name; this.salary = salary;
    }

    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}

public class LambdaDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(101, "Arun", 45000),
            new Employee(102, "Divya", 60000),
            new Employee(103, "Ravi", 75000)
        );

        Predicate<Employee> bonusEligible = e -> e.salary > 50000;

        for (Employee e : employees) {
            if (bonusEligible.test(e)) {
                System.out.println("Bonus Eligible: " + e);
            }
        }
    }
}
```

### 🧠 Explanation
- `Predicate<Employee>` is a functional interface with method `boolean test(T t)`.
- Lambda `e -> e.salary > 50000` becomes the rule.
- `bonusEligible.test(e)` applies the rule safely and cleanly.

---

## 3) Method Reference Syntax

### ✅ Definition
A **Method Reference** is a shorter form of a lambda when the lambda **only calls an existing method**.

### ✅ Types of Method References
1. **Static method** → `ClassName::staticMethod`
2. **Instance method of an object** → `obj::instanceMethod`
3. **Instance method of an arbitrary object of a class** → `ClassName::instanceMethod`
4. **Constructor reference** → `ClassName::new`

---

### 🌍 Real-world scenario
Print customer names from a list.

### 💻 Example (Lambda vs Method Reference)
```java
import java.util.*;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Arun", "Divya", "Ravi");

        // Lambda
        names.forEach(n -> System.out.println(n));

        // Method reference (same meaning)
        names.forEach(System.out::println);
    }
}
```

### 🧠 Explanation
- `forEach(...)` expects a `Consumer<String>`.
- `System.out::println` is a direct reference to `println(String)`.
- It’s cleaner and more readable than the lambda.

---

### ✅ Real-world example: Sorting products using method reference
```java
import java.util.*;

class Product {
    int id;
    String name;

    Product(int id, String name) { this.id = id; this.name = name; }

    public String getName() { return name; }

    public String toString() { return id + "-" + name; }
}

public class SortMethodRefDemo {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product(3, "Mouse"),
            new Product(1, "Keyboard"),
            new Product(2, "Monitor")
        );

        // Lambda
        products.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));

        // Method reference (cleaner)
        products.sort(Comparator.comparing(Product::getName));

        System.out.println(products);
    }
}
```

---

## 4) Optional Class

### ✅ Definition
`Optional<T>` is a container that may or may not contain a value.  
It helps avoid:
- `NullPointerException`
- multiple `if (x != null)` checks

✅ Instead of returning `null`, return `Optional<T>`.

---

### 🌍 Real-world scenario
**Login / user lookup**: Find user by email. If not found, return `Optional.empty()` rather than `null`.

### 💻 Example (User Repository with Optional)
```java
import java.util.*;

class User {
    int id;
    String email;

    User(int id, String email) { this.id = id; this.email = email; }

    public String toString() { return id + "-" + email; }
}

class UserRepository {
    private final List<User> users = Arrays.asList(
        new User(1, "arun@gmail.com"),
        new User(2, "divya@gmail.com")
    );

    public Optional<User> findByEmail(String email) {
        for (User u : users) {
            if (u.email.equalsIgnoreCase(email)) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }
}

public class OptionalDemo {
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();

        Optional<User> userOpt = repo.findByEmail("ravi@gmail.com");

        // 1) ifPresent
        userOpt.ifPresent(u -> System.out.println("User Found: " + u));

        // 2) Provide default user
        User user = userOpt.orElse(new User(0, "guest@demo.com"));
        System.out.println("Final User: " + user);

        // 3) Throw custom exception if needed
        // User user2 = userOpt.orElseThrow(() -> new RuntimeException("User not found"));
    }
}
```

### 🧠 Explanation
- If user exists → `Optional.of(user)`
- If user doesn’t exist → `Optional.empty()`
- We safely handle both cases using:
  - `ifPresent(...)`
  - `orElse(...)`
  - `orElseThrow(...)`

---

### ✅ Common Optional Methods (Very Important)

#### Creating Optional
- `Optional.of(value)` → value must NOT be null
- `Optional.ofNullable(value)` → safe even if null
- `Optional.empty()` → no value

#### Reading value safely
- `isPresent()`
- `ifPresent()`
- `orElse(defaultValue)`
- `orElseGet(() -> defaultValue)` *(lazy)*
- `orElseThrow(...)`

#### Transforming value
- `map()`
- `filter()`
- `flatMap()`

---

### ❌ Common Mistake
```java
userOpt.get(); // can throw NoSuchElementException if empty
```
✅ Prefer `orElse`, `orElseThrow`, `ifPresent`, etc.

---

## Quick Revision Summary
- **Functional Interface**: One abstract method, used to pass behavior
- **Lambda**: Short implementation of a functional interface
- **Method Reference**: Shorter lambda that calls an existing method
- **Optional**: Prevents null issues by representing “value may or may not exist”

---
**End of Notes**
