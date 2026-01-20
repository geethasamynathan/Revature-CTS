class PrintNumbers extends Thread{
	public void run() {
		for (int i=1;i<=5;i++) {
			System.out.println(getName() + " -> "+ i);
		}
	}
}
public class MultiThreadingWithThreadClass {

	public static void main(String[] args) {
		PrintNumbers t1=new PrintNumbers();
		t1.setName("Worker Thread 1 ");
		t1.start();
		

	}

}
