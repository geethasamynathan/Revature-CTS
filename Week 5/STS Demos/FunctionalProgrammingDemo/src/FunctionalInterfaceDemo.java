
interface  DiscountRule{
	double apply(double cartAmount);
}

class DiscountService
{
	public double finalAmount(double cartAmount , DiscountRule rule)
	{
		return cartAmount-rule.apply(cartAmount);
	}
}
public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		DiscountService service=new DiscountService();
		
		DiscountRule festivalDiscount= amount -> amount*0.10;
		DiscountRule premiumDiscount= amount -> amount*0.15;
		
		System.out.println("After Festival discount final Amount "+service.finalAmount(2000, festivalDiscount));
		System.out.println("After  Premium discount final Amount "+service.finalAmount(2000, premiumDiscount));
	}

}

