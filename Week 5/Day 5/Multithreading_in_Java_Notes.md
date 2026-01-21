# Multithreading in Java 
## 1) What is Multithreading?
**Multithreading** means running **multiple tasks (threads)** within the same Java program so work can happen **concurrently**.

- A **Thread** is the smallest unit of execution inside a process.
- Your Java program starts with one thread: the **main thread**.
- Creating additional threads allows multiple tasks to progress at the same time (CPU scheduling decides how).

**Real-world analogy:**  
A restaurant kitchen:
- One chef chops vegetables
- Another chef cooks curry
- Another prepares drinks  
All tasks happen together to serve faster.

---

## 2) Why do we use Multithreading?
### ✅ Benefits
1. **Better performance** (multi-core CPUs can run tasks in parallel)
2. **Better responsiveness** (UI doesn’t freeze while background work runs)
3. **Better resource usage** (while one thread waits for I/O, another can compute)
4. **Real-time processing** (chat, streaming, notifications, payments, monitoring)

### ⚠️ Challenges (must know)
- **Race conditions** (wrong results due to shared data updates)
- **Deadlocks** (threads waiting forever for each other’s locks)
- **Difficult debugging** (timing issues)
- **Unpredictable output order** (unless you control it)

---

## 3) States of a Thread (Lifecycle)
Java provides states in `Thread.State`:

1. **NEW**  
   Thread object created, but not started (`start()` not called yet).

2. **RUNNABLE**  
   Thread is ready to run OR running (Java groups “ready” and “running” here).

3. **BLOCKED**  
   Waiting to acquire a monitor lock to enter a `synchronized` block/method.

4. **WAITING**  
   Waiting indefinitely for another thread to act (e.g., `wait()`, `join()` without timeout).

5. **TIMED_WAITING**  
   Waiting for a specific time (e.g., `sleep(1000)`, `wait(1000)`, `join(1000)`).

6. **TERMINATED**  
   Execution finished.

**Typical flow:**  
`NEW → RUNNABLE → (BLOCKED / WAITING / TIMED_WAITING) → RUNNABLE → TERMINATED`

---

## 4) Thread Class: What it is and Common Uses
`Thread` is a Java class used to create and manage threads.

### Important methods 
**Start and execution**
- `start()` ✅ Creates a new thread and internally calls `run()`
- `run()` Contains the task (calling `run()` directly does **not** create a new thread)

**Pausing / waiting**
- `sleep(ms)` Pause current thread (TIMED_WAITING)
- `join()` Wait for another thread to finish (WAITING/TIMED_WAITING)
- `interrupt()` Request to stop waiting/sleeping (cooperative interruption)

**Info**
- `getName()`, `setName()`
- `getId()`
- `currentThread()`
- `getPriority()`, `setPriority()`

---

## 5) What is Runnable Interface?
`Runnable` is a **functional interface** with one method:

```java
public interface Runnable {
    void run();
}
```

### Why Runnable is preferred
- Java supports **single inheritance**:
  - If you `extends Thread`, you cannot extend another class.
  - If you `implements Runnable`, you can still extend another class and run tasks in threads.
- Cleaner design: task (Runnable) is separate from thread (Thread).

✅ In most real applications: **use Runnable / ExecutorService**.

---

# 6) Real-World Examples 

## Example 1 (Basic): Two tasks running in parallel using Runnable
### Scenario: Food app loads Menu + Offers at the same time

```java
class LoadMenu implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Menu loading... step " + i + " | " + Thread.currentThread().getName());
        }
    }
}

class LoadOffers implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Offers loading... step " + i + " | " + Thread.currentThread().getName());
        }
    }
}

public class BasicMultiThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new LoadMenu(), "Menu-Thread");
        Thread t2 = new Thread(new LoadOffers(), "Offers-Thread");

        t1.start();
        t2.start();
    }
}
```

### Sample output (order may vary)
```
Menu loading... step 1 | Menu-Thread
Offers loading... step 1 | Offers-Thread
Offers loading... step 2 | Offers-Thread
Menu loading... step 2 | Menu-Thread
Menu loading... step 3 | Menu-Thread
Offers loading... step 3 | Offers-Thread
```

### Why this output order?
Both threads run independently. The **CPU scheduler** decides which thread gets CPU time at each moment.  
So the order is **not guaranteed**.

---

## Example 2 (Basic): Extending Thread
```java
class PrintNumbers extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " -> " + i);
        }
    }
}

public class ThreadExtendDemo {
    public static void main(String[] args) {
        PrintNumbers t1 = new PrintNumbers();
        t1.setName("Worker-1");
        t1.start(); // ✅ creates new thread
    }
}
```

### Important note
- `start()` creates a new thread.
- Calling `run()` directly runs in the **main thread** (no new thread).

---

## Example 3  join() to enforce workflow order
### Scenario: Generate invoice only after payment is completed

```java
class PaymentTask extends Thread {
    public void run() {
        System.out.println("Payment started...");
        try { Thread.sleep(1000); } catch (Exception e) {}
        System.out.println("Payment completed.");
    }
}

class InvoiceTask extends Thread {
    public void run() {
        System.out.println("Invoice generated.");
    }
}

public class JoinDemo {
    public static void main(String[] args) throws Exception {
        PaymentTask payment = new PaymentTask();
        InvoiceTask invoice = new InvoiceTask();

        payment.start();

        // ✅ Wait until payment finishes
        payment.join();

        invoice.start();
    }
}
```

### Expected output (almost always same)
```
Payment started...
Payment completed.
Invoice generated.
```

### Why output is consistent here?
`join()` forces the main thread to **wait** until `payment` finishes.  
So invoice can only start after payment completion.

---

## Example 4 : Race Condition (problem)
### Scenario: Two threads update the same booking counter

```java
class BookingCounter {
    int totalBookings = 0;

    public void book() {
        totalBookings++; // ❌ not thread-safe
    }
}

public class RaceConditionDemo {
    public static void main(String[] args) throws Exception {
        BookingCounter counter = new BookingCounter();

        Thread t1 = new Thread(() -> { for(int i=0;i<100000;i++) counter.book(); });
        Thread t2 = new Thread(() -> { for(int i=0;i<100000;i++) counter.book(); });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Total bookings: " + counter.totalBookings);
    }
}
```

### Possible output (varies)
```
Total bookings: 178543
```

### Why wrong?
`totalBookings++` is not atomic. It internally does:
1) read value  
2) add 1  
3) write back  

Two threads can read the same value before either writes back → updates get “lost”.

---

## Example 5 : Fix with synchronized
```java
class BookingCounterSafe {
    int totalBookings = 0;

    public synchronized void book() {
        totalBookings++; // ✅ thread-safe now
    }
}

public class SynchronizedFixDemo {
    public static void main(String[] args) throws Exception {
        BookingCounterSafe counter = new BookingCounterSafe();

        Thread t1 = new Thread(() -> { for(int i=0;i<100000;i++) counter.book(); });
        Thread t2 = new Thread(() -> { for(int i=0;i<100000;i++) counter.book(); });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Total bookings: " + counter.totalBookings);
    }
}
```

### Expected output
```
Total bookings: 200000
```

### Why correct now?
`synchronized` allows only **one thread at a time** to enter `book()`, preventing lost updates.

---

## Example 6 (Advanced / Real Projects): ExecutorService (Thread Pool)
### Scenario: Helpdesk processes tickets using limited worker threads

```java
import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        Runnable ticket1 = () -> System.out.println("Processing TKT1001 by " + Thread.currentThread().getName());
        Runnable ticket2 = () -> System.out.println("Processing TKT1002 by " + Thread.currentThread().getName());
        Runnable ticket3 = () -> System.out.println("Processing TKT1003 by " + Thread.currentThread().getName());
        Runnable ticket4 = () -> System.out.println("Processing TKT1004 by " + Thread.currentThread().getName());

        pool.submit(ticket1);
        pool.submit(ticket2);
        pool.submit(ticket3);
        pool.submit(ticket4);

        pool.shutdown();
    }
}
```

### Sample output (order may vary)
```
Processing TKT1002 by pool-1-thread-2
Processing TKT1001 by pool-1-thread-1
Processing TKT1003 by pool-1-thread-3
Processing TKT1004 by pool-1-thread-1
```

### Why this output?
- Pool has **3 threads**.
- First 3 tasks run immediately.
- 4th waits until any thread becomes free.
- Scheduling determines which thread prints first.

---

## 7) Quick Summary 
- **Multithreading**: multiple threads execute tasks concurrently.
- Use it for **speed, responsiveness, parallel work**.
- Thread states: **NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED**
- Prefer **Runnable** / **ExecutorService** in real projects.
- Output can be unpredictable due to CPU scheduling unless controlled with `join()` / synchronization.

---
