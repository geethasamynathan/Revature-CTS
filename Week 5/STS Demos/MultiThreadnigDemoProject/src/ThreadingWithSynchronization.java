class BookingCounter{
	int totalBookings=0;
	
	public synchronized void book() {
		totalBookings++;
	}
}
public class ThreadingWithSynchronization {

	public static void main(String[] args) throws Exception {
		BookingCounter counter=new BookingCounter();
		
		Thread t1=new Thread( ()-> {for(int i=1; i<=10000;i++) counter.book();});
		Thread t2=new Thread( ()-> {for(int i=1; i<=10000;i++) counter.book();});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println("Total Bookings "+ counter.totalBookings);
		
	}

}
