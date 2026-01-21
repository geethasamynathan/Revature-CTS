# Deadlock in Java — Notes (with Examples)

Source: CodeSignal Learn — *Deadlocks and Lock Mechanisms*  
(Use this as learner-friendly notes: definition, causes, example, problem, and fixes)

---

## 1) Definition: What is a Deadlock?

A **deadlock** occurs when **two or more threads are blocked forever**, where **each thread is waiting for a resource (lock) held by another thread**. The program appears to “hang” because no thread can proceed.  
This is similar to **two people holding keys that the other needs**—both wait forever.  
Reference concept: CodeSignal lesson explains this situation and why it halts the program.

---

## 2) Why Deadlock Happens (4 conditions)

Deadlock happens when all these four conditions occur at the same time:

1. **Mutual Exclusion**  
   A lock/resource is **non-shareable** (only one thread can hold it at a time).

2. **Hold and Wait**  
   A thread **holds one lock** and **waits** for another lock.

3. **No Preemption**  
   You **cannot forcefully take** a lock from a thread. A thread must release it voluntarily.

4. **Circular Wait**  
   A cycle forms: **T1 waits for T2** and **T2 waits for T1** (or bigger cycles).

✅ If you break even *one* of these conditions, you can prevent deadlock.

---

## 3) Locks in Java (quick recap)

### a) Intrinsic Locks (`synchronized`)
Java provides built-in locking using `synchronized`. Every object has an **intrinsic lock** (monitor).
Example styles:
- **Object Lock**: `synchronized(this)` or `synchronized(someObject)`
- **Class Lock**: `synchronized(ClassName.class)`

### b) Explicit Locks (`ReentrantLock`)
`ReentrantLock` (from `java.util.concurrent.locks`) gives more control:
- manual `lock()` / `unlock()`
- `tryLock()` (avoid waiting forever)
- can support interruptible lock attempts

---

## 4) Deadlock Example (Real-world scenario: Booking + Payment)

### Scenario
You have two shared resources:
- `roomLock` (room allocation system)
- `paymentLock` (payment gateway system)

Two operations:
- Operation A: lock **room → payment**
- Operation B: lock **payment → room**

If both run at the same time, they can deadlock.

### Deadlock code

```java
class BookingSystem {
    private final Object roomLock = new Object();
    private final Object paymentLock = new Object();

    public void bookRoomThenPay() {
        synchronized (roomLock) {
            sleep(50); // increases chance of deadlock
            synchronized (paymentLock) {
                System.out.println("Booked room & paid");
            }
        }
    }

    public void payThenBookRoom() {
        synchronized (paymentLock) {
            sleep(50);
            synchronized (roomLock) {
                System.out.println("Paid & booked room");
            }
        }
    }

    private void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}

public class DeadlockDemo {
    public static void main(String[] args) {
        BookingSystem bs = new BookingSystem();

        Thread t1 = new Thread(bs::bookRoomThenPay, "T1");
        Thread t2 = new Thread(bs::payThenBookRoom, "T2");

        t1.start();
        t2.start();
    }
}
```

---

## 5) What is the Problem Here?

### What happens step-by-step

- **T1** enters `bookRoomThenPay()`  
  ✅ locks `roomLock`  
  ⏳ tries to lock `paymentLock` (but may be held by T2)

- **T2** enters `payThenBookRoom()`  
  ✅ locks `paymentLock`  
  ⏳ tries to lock `roomLock` (but is held by T1)

Now:
- T1 is waiting for paymentLock
- T2 is waiting for roomLock

✅ This is **circular wait** → **deadlock** → both threads stuck forever.

---

## 6) How to Resolve Deadlock

### Fix 1 (Most common): Consistent Lock Ordering (Lock Reordering)

**Rule:** Always acquire multiple locks in the **same order** everywhere in your code.

For example, decide:
✅ Always lock `roomLock` first, then `paymentLock`.

#### Fixed code

```java
class BookingSystemSafe {
    private final Object roomLock = new Object();
    private final Object paymentLock = new Object();

    public void bookRoomThenPay() {
        synchronized (roomLock) {
            synchronized (paymentLock) {
                System.out.println("Booked room & paid");
            }
        }
    }

    public void payThenBookRoom() {
        // IMPORTANT: same order (roomLock -> paymentLock)
        synchronized (roomLock) {
            synchronized (paymentLock) {
                System.out.println("Paid & booked room");
            }
        }
    }
}
```

#### How this resolves the problem
Because both methods follow the same lock order:
- If T1 gets `roomLock`, T2 must wait **before it holds paymentLock**.
- The waiting thread is not holding the “other” lock → no cycle forms.

✅ This breaks the **circular wait** condition, so deadlock cannot occur.

---

### Fix 2 (Advanced): Use `ReentrantLock` + `tryLock()` to avoid waiting forever

If you want threads to **avoid indefinite waiting**, use `tryLock()`.

#### Example (tryLock with timeout)

```java
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class BookingSystemTryLock {
    private final ReentrantLock roomLock = new ReentrantLock();
    private final ReentrantLock paymentLock = new ReentrantLock();

    public void book() {
        try {
            if (roomLock.tryLock(200, TimeUnit.MILLISECONDS)) {
                try {
                    if (paymentLock.tryLock(200, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println(Thread.currentThread().getName() + ": booking success");
                        } finally {
                            paymentLock.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + ": payment busy, retry later");
                    }
                } finally {
                    roomLock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ": room busy, retry later");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
```

#### How this resolves the problem
- `tryLock()` attempts to acquire a lock **without blocking forever**.
- If it can’t get the second lock quickly, it **backs off** and releases what it holds.
- That prevents circular waiting from becoming permanent.

✅ In short: It avoids the “wait forever” behavior.

---

## 7) Deadlock Prevention Checklist (Easy to remember)

- ✅ Acquire multiple locks in a **fixed order** (lock reordering)
- ✅ Keep lock scope small (don’t lock more code than needed)
- ✅ Avoid nested locks when possible
- ✅ Prefer `ReentrantLock.tryLock()` when “never wait forever” is required
- ✅ Use high-level concurrency utilities when possible (Executors, concurrent collections)

---

## 8) Mini Interview Q&A (Quick revision)

**Q1: What is deadlock?**  
A: Threads wait forever because each holds a lock the other needs.

**Q2: Why it is hard to debug?**  
A: Program freezes without an exception; threads are blocked.

**Q3: Best prevention method?**  
A: Acquire locks in consistent order everywhere (lock ordering).

**Q4: Alternative to synchronized?**  
A: `ReentrantLock`, especially with `tryLock()` to avoid infinite waiting.

---

### End of Notes
