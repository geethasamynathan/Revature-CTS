class Parent {
	void m1() {
		System.out.println("parent class method");
	}
}

class Child extends Parent {
	void m1() {
		System.out.println("child class method m1");
	}

	void m2() {
		this.m1();
		System.out.println("child class method m2");
		super.m1();
	}

}

public class SuperKeywordDemo {
	public static void main(String[] arhs) {
		Child c = new Child();
		c.m2();
	}
}
