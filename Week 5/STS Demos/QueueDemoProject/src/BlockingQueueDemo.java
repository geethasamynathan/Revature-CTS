import java.util.concurrent.*;

public class BlockingQueueDemo {

	public static void main(String[] args) throws Exception {
		BlockingQueue<String> orders = new ArrayBlockingQueue<>(3); // fixed size

        // Producer
        System.out.println("offer Order1: " + orders.offer("Order1"));
        System.out.println("offer Order2: " + orders.offer("Order2"));

        // Queue full now (offer returns false)
       // System.out.println("offer Order3 (queue full): " + orders.offer("Order3"));

        System.out.println("Current queue: " + orders);

        // take / put (blocking style demo without threads)
        System.out.println("poll(): " + orders.poll());
        System.out.println("After poll: " + orders);
        
        // Now space is available
        orders.put("Order3"); // will not block now
        System.out.println("After put Order3: " + orders);

        
     // take removes head
        System.out.println("take(): " + orders.take());
        System.out.println("Remaining: " + orders);

        // remainingCapacity
        System.out.println("remainingCapacity(): " + orders.remainingCapacity());
	}

}
