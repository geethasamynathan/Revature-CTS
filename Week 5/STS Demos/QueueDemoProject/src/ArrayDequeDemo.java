import java.util.*;
public class ArrayDequeDemo {

	public static void main(String[] args) {
		Deque<String> browserHistory=new ArrayDeque<>();
		browserHistory.offer("google.com");
		browserHistory.offer("java2s.com");
		browserHistory.offer("Gemini.com");
		
		System.out.println(" Deque : "+browserHistory);
		
		//peek 
		
		System.out.println(" peek () : "+browserHistory.peek());
		System.out.println(" poll ()  : "+browserHistory.poll());
		
		  System.out.println("After poll: " + browserHistory);
		  
		  // Deque special methods (both ends)
	        browserHistory.addFirst("startpage.com");
	        browserHistory.addLast("stackoverflow.com");

	        System.out.println("After addFirst/addLast: " + browserHistory);

	        System.out.println("peekFirst(): " + browserHistory.peekFirst());
	        System.out.println("peekLast(): " + browserHistory.peekLast());

	        System.out.println("pollFirst(): " + browserHistory.pollFirst());
	        System.out.println("pollLast(): " + browserHistory.pollLast());

	        System.out.println("Final: " + browserHistory);

	        // Stack-like using Deque
	        browserHistory.push("login-page");   // addFirst
	        System.out.println("After push: " + browserHistory);
	        System.out.println("pop(): " + browserHistory.pop()); // removeFirst
	}

}
