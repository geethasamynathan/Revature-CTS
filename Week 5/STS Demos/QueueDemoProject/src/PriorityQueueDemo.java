import java.util.*;
public class PriorityQueueDemo {

	public static void main(String[] args) {
		PriorityQueue < String > queue = new PriorityQueue < String > ();
		queue.add ("Amit");
		queue.add ("Vijay");
		queue.add ("Karan");
		queue.add ("Jai");
		queue.add ("Rahul");
		System.out.println ("head:" + queue.element ());
		System.out.println ("head:" + queue.peek ());
		System.out.println ("Iterating the queue elements:");
		Iterator itr = queue.iterator ();
		while (itr.hasNext ())
		{
		System.out.println (itr.next ());
		}
		queue.remove ();
		//Removes and returns the head element.
		//If the queue is empty → ❌ throws Exception: NoSuchElementException
		queue.poll ();
		//Removes and returns the head element.
		//If the queue is empty → ✅ returns null (no exception)
		System.out.println ("After removing two elements:");
		Iterator < String > itr2 = queue.iterator ();
		while (itr2.hasNext ())
		{
		System.out.println (itr2.next ());
		}


	}

}
