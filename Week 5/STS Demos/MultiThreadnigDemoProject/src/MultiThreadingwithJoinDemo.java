class PaymentTask extends Thread {
	public void run() {
		System.out.println("Payment started ...");
		try {
			Thread.sleep(2000);
		} catch (Exception e) 
		{
		}
			System.out.println("Payment Completed ...");		
	}
}

class InvoiceTask extends Thread {
	public void run() {
		System.out.println("Invoice Generated!... ");
	}
}

public class MultiThreadingwithJoinDemo {
	public static void main(String[] args) throws InterruptedException {
		PaymentTask payment= new PaymentTask();
		InvoiceTask invoice=new InvoiceTask();
		
		payment.start();
		
		//ait until payment finishes
		payment.join();
		
		invoice.start();
		
	}
}
