import java.util.*;

public class PriorityQueueDemo1 {

	public static void main(String[] args) {
		Queue<Integer> priorityTasks = new PriorityQueue<>();

        priorityTasks.offer(3); // low priority
        priorityTasks.offer(1); // high priority
        priorityTasks.offer(2);

        System.out.println("PriorityQueue (internal order may look random): " + priorityTasks);

        // peek: next to execute
        System.out.println("peek(): " + priorityTasks.peek()); // 1

        // poll in priority order
        System.out.println("Processing in priority order:");
        while (!priorityTasks.isEmpty()) {
            System.out.println("poll(): " + priorityTasks.poll());
        }

        // poll on empty -> null
        System.out.println("poll() on empty: " + priorityTasks.poll());
	}

}
