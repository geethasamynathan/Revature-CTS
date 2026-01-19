//class Parent1 {
//	void property() {
//		System.out.println("money+land+house");
//	}
//
//	void marry() {
//		System.out.println("black girl"); // Overridden method
//	}
//}
//
//class Child1 extends Parent1{
//	void marry() {
//		System.out.println("white girl/red girl"); // overriding method
//	}
//
//}

class Payment {
	void pay(double amount) {
		System.out.println("Processing generic payment of ₹" + amount);
	}
}

// Child class 1: Credit Card payment overrides pay()
class CreditCardPayment extends Payment {

	void pay(double amount) {
		System.out.println("Processing Credit Card payment of ₹" + amount);
		System.out.println("Step: Validate card -> Ask OTP -> Deduct amount");
	}
}

// Child class 2: UPI payment overrides pay()
class UPIPayment extends Payment {

	void pay(double amount) {
		System.out.println("Processing UPI payment of ₹" + amount);
		System.out.println("Step: Verify UPI ID -> Enter PIN -> Transfer amount");
	}
}

// Child class 3: Cash on Delivery overrides pay()
class CashOnDelivery extends Payment {

	void pay(double amount) {
		System.out.println("Cash on Delivery selected for ₹" + amount);
		System.out.println("Step: Deliver item -> Collect cash");
	}
}

public class OverridingDemo2 {

	public static void main(String[] args) {
//		Child1 child = new Child1();
//		child.property();
//		child.marry();
//		Parent1 parent1=new Parent1();
//		parent1.property();
//		parent1.marry();

		// Polymorphism: Parent reference, child object
		Payment p1 = new CreditCardPayment();
		p1.pay(2500);

		System.out.println("---------------");

		Payment p2 = new UPIPayment();
		p2.pay(799);

		System.out.println("---------------");

		Payment p3 = new CashOnDelivery();
		p3.pay(1200);
	}

}
