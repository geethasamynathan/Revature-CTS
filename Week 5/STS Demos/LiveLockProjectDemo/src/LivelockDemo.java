import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
    String name;
    int balance;
    Lock lock = new ReentrantLock();

    Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
}

public class LivelockDemo {

    static boolean transfer(Account from, Account to, int amount) {
        // Try to get both locks
        if (from.lock.tryLock()) {
            try {
                if (to.lock.tryLock()) {
                    try {
                        from.balance -= amount;
                        to.balance += amount;
                        System.out.println(Thread.currentThread().getName() +
                                " SUCCESS: " + amount + " transferred from " + from.name + " to " + to.name);
                        return true;
                    } finally {
                        to.lock.unlock();
                    }
                }
            } finally {
                from.lock.unlock();
            }
        }

        // If failed, we politely retry
        System.out.println(Thread.currentThread().getName() + " could not get locks, retrying...");
        return false;
    }

    public static void main(String[] args) {

        Account a = new Account("A", 1000);
        Account b = new Account("B", 1000);

        Thread t1 = new Thread(() -> {
            while (!transfer(a, b, 100)) {
                try { Thread.sleep(10); } catch (Exception e) {}
            }
        }, "T1");

        Thread t2 = new Thread(() -> {
            while (!transfer(b, a, 200)) {
                try { Thread.sleep(10); } catch (Exception e) {}
            }
        }, "T2");

        t1.start();
        t2.start();
    }
}
