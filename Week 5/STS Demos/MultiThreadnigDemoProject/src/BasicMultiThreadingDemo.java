class LoadMenu implements Runnable {

	public void run() {
		for (int i = 1; i <= 3; i++) {
			System.out.println(" Menu Loading ... step " + i + "| " + Thread.currentThread().getName());
		}
	}
}

class LoadOffers implements Runnable {

	public void run() {
		for (int i = 1; i <= 3; i++) {
			System.out.println("Offers Loading ... step " + i + "| " + Thread.currentThread().getName());
		}
	}
}

public class BasicMultiThreadingDemo {

	public static void main(String[] args) {
		Thread t1=new Thread(new LoadMenu(),"Menu-Thread");
		Thread t2=new Thread(new LoadOffers(),"Offers-Thread");
		t1.start();
		t2.start();
		
	}

}
