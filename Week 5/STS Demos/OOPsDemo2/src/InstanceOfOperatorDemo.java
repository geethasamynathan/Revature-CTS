class Fruit {
};

public class InstanceOfOperatorDemo extends Fruit {

	public static void main(String[] args) {
		InstanceOfOperatorDemo a = new InstanceOfOperatorDemo();
		Object o = new Object();
		String str = "ratan";
		Throwable t = new Throwable();
		System.out.println(a instanceof Fruit);
		System.out.println(a instanceof Object);
		System.out.println(str instanceof Object);
		System.out.println(o instanceof Throwable);
		System.out.println(t instanceof Throwable);
		// System.out.println(t instanceof InstanceOfOperatorDemo);//compilation error
	}
}
