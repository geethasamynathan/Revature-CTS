import java.util.*;

public class QueueLinkedListDemo {

	public static void main(String[] args) {
		Queue<String> supportQueue = new LinkedList<>();

        // add / offer
        supportQueue.add("TKT1001");
        supportQueue.offer("TKT1002");
        supportQueue.offer("TKT1003");

        System.out.println("Queue: " + supportQueue);

        // peek / element
        System.out.println("peek(): " + supportQueue.peek());       // head
        System.out.println("element(): " + supportQueue.element()); // head
        // poll / remove
        System.out.println("poll(): " + supportQueue.poll());   // removes head
        System.out.println("remove(): " + supportQueue.remove());// removes head

        System.out.println("After removals: " + supportQueue);

        // size / contains / isEmpty
        System.out.println("size(): " + supportQueue.size());
        System.out.println("contains TKT1003? " + supportQueue.contains("TKT1003"));
        System.out.println("isEmpty(): " + supportQueue.isEmpty());

        // iterator traversal
        System.out.println("Traverse:");
        for (String t : supportQueue) {
            System.out.println(t);
        }

     // clear
        supportQueue.clear();
        System.out.println("After clear(): " + supportQueue);
	}

}
