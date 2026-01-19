
abstract class Test {
	abstract void m1();

	abstract void m2();

	abstract void m3();
}

abstract class AbstractDemo1 extends Test {
	void m1() {
		System.out.println("m1-method");
	}

	void m2() {
		System.out.println("m2-method");
	}
//	void m3() {
//		System.out.println("m2-method");
//	}
};

class AbstractDemo extends AbstractDemo1 {
	void m3() {
		System.out.println("m3-method");
	}
	
	
}

public class AbstractClassDemo {

	public static void main(String[] args) {
		AbstractDemo ad = new AbstractDemo();
		ad.m1();
		ad.m2();
		ad.m3();

	}

}
