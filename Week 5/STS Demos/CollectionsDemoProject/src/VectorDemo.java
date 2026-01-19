import java.util.*;

public class VectorDemo {

	public static void main(String[] args) {
		        // 1) Create Vector (Ticket IDs)
		        Vector<String> tickets = new Vector<>();

		        // add() - Add new tickets (like new customer requests)
		        tickets.add("TKT1001");
		        tickets.add("TKT1002");
		        tickets.add("TKT1003");

		        System.out.println("Initial Tickets: " + tickets);

		        // add(index, element) - Insert high priority ticket at a specific position
		        tickets.add(1, "TKT9999"); // high priority inserted at index 1
		        System.out.println("After inserting high priority: " + tickets);

		        // size() - Total number of tickets
		        System.out.println("Total tickets: " + tickets.size());

		        // contains() - Check if a ticket exists
		        System.out.println("Contains TKT1002? " + tickets.contains("TKT1002"));

		        // get(index) - Fetch ticket at a position (ticket assignment)
		        System.out.println("Ticket at index 2: " + tickets.get(2));

		        // set(index, element) - Update ticket ID (example: ticket got merged/renamed)
		        tickets.set(2, "TKT2002");
		        System.out.println("After updating index 2: " + tickets);

		        // indexOf() - Find position of a ticket
		        System.out.println("Index of TKT1003: " + tickets.indexOf("TKT1003"));

		        // remove(element) - Remove ticket if resolved
		        tickets.remove("TKT1001");
		        System.out.println("After resolving TKT1001: " + tickets);

		        // remove(index) - Remove ticket at specific index
		        tickets.remove(0);
		        System.out.println("After removing ticket at index 0: " + tickets);

		        // addAll(collection) - Add tickets from another department/team
		        Vector<String> escalatedTickets = new Vector<>();
		        escalatedTickets.add("ESC5001");
		        escalatedTickets.add("ESC5002");

		        tickets.addAll(escalatedTickets);
		        System.out.println("After adding escalated tickets: " + tickets);

		        // addAll(index, collection) - Insert tickets at a specific position
		        Vector<String> urgentTickets = new Vector<>();
		        urgentTickets.add("URG7001");
		        urgentTickets.add("URG7002");

		        tickets.addAll(1, urgentTickets);
		        System.out.println("After inserting urgent tickets at index 1: " + tickets);

		        // firstElement() and lastElement()
		        System.out.println("First Ticket: " + tickets.firstElement());
		        System.out.println("Last Ticket: " + tickets.lastElement());

		        // elementAt(index) - Old style method (similar to get)
		        System.out.println("elementAt(2): " + tickets.elementAt(2));

		        // removeAll(collection) - Remove all escalated tickets after transfer
		        tickets.removeAll(escalatedTickets);
		        System.out.println("After removing escalated tickets: " + tickets);

		        // isEmpty() - Check if queue is empty
		        System.out.println("Is ticket queue empty? " + tickets.isEmpty());

		        // iterator() - Traverse tickets (agent views all assigned tickets)
		        System.out.println("\nTickets using Iterator:");
		        Iterator<String> it = tickets.iterator();
		        while (it.hasNext()) {
		            System.out.println("Ticket -> " + it.next());
		        }

		        // Enumeration - Legacy traversal (Vector supports it)
		        System.out.println("\nTickets using Enumeration:");
		        Enumeration<String> e = tickets.elements();
		        while (e.hasMoreElements()) {
		            System.out.println("Ticket => " + e.nextElement());
		        }

		        // capacity() - Internal storage capacity
		        System.out.println("\nCapacity (internal size): " + tickets.capacity());

		        // ensureCapacity(min) - Pre-allocate to avoid frequent resizing (performance)
		        tickets.ensureCapacity(20);
		        System.out.println("Capacity after ensureCapacity(20): " + tickets.capacity());

		        // trimToSize() - Reduce unused capacity (memory optimization)
		        tickets.trimToSize();
		        System.out.println("Capacity after trimToSize(): " + tickets.capacity());

		        // clear() - Clear all tickets (end of day reset)
		        tickets.clear();
		        System.out.println("\nAfter clear(): " + tickets);
		        System.out.println("Is empty after clear? " + tickets.isEmpty());
		    }
		}


	


