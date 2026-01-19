
public class GarbageCollectorDemo {
	 public void finalize()
	    {
	        System.out.println ("Garbage Collection performed by JVM");
	    }
	public static void main(String[] args) {
		GarbageCollectorDemo t1 = new GarbageCollectorDemo();
		GarbageCollectorDemo t2 = new GarbageCollectorDemo();
		System.out.println(t1);
		System.out.println(t2);
		
		t1 = null;// t1 object is elgible for Garbage collector
		t2 = null;// t2 object is elgible for Garbage Collector
		System.out.println(t1);
		System.out.println(t2);
		System.gc();
	}
}

