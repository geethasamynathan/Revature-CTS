class TicketBooking implements Runnable {
	int tickets = 3;

	public synchronized void bookTicket(String name, int wantedTickets) {
		if (wantedTickets <= tickets) {
			System.out.println(wantedTickets + " ticket(s) booked to " + name);
			tickets = tickets - wantedTickets;
		} else {
			System.out.println("No tickets to book for " + name);
		}
	}

	public void run() {
		String name = Thread.currentThread().getName();
		if (name.equals("t1"))
			bookTicket(name, 1);
		else if (name.equals("t2"))
			bookTicket(name, 2);
		else
			bookTicket(name, 3);
	}

}

class TokenService implements Runnable {
	int token = 1;

	public void run() {
		synchronized (this) { // lock current object
			String name = Thread.currentThread().getName();
			System.out.println(token + " allotted to " + name);
			token++;
		}
	}
}

public class SynchronizationDemo {

	public static void main(String[] args) {
//        TicketBooking b = new TicketBooking();
//        Thread t1 = new Thread(b, "t1");
//        Thread t2 = new Thread(b, "t2");
//       Thread t3 = new Thread(b, "t3");
//       t1.start(); t2.start(); t3.start();
        
        
        TokenService s = new TokenService();
        new Thread(s, "t4").start();
        new Thread(s, "t5").start();
        new Thread(s, "t6").start();

	}

}
