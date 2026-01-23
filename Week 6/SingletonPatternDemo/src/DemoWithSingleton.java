class TrafficSignal {

    //  single object reference
    private static TrafficSignal instance;

    // private constructor
    private TrafficSignal() {
        System.out.println("Traffic Signal Controller Created");
    }

    //  public method to get object
    public static TrafficSignal getInstance() {

        if (instance == null) {
            instance = new TrafficSignal();
        }
        return instance;
    }

    public void control() {
        System.out.println("Controlling traffic...");
    }
}

public class DemoWithSingleton {

	public static void main(String[] args) {
		 TrafficSignal t1 = TrafficSignal.getInstance();
	        TrafficSignal t2 = TrafficSignal.getInstance();
	        TrafficSignal t3 = TrafficSignal.getInstance();

	        System.out.println(t1 == t2);
	        System.out.println(t2 == t3);

	}

}
