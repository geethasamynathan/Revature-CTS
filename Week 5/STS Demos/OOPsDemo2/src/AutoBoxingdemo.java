
public class AutoBoxingdemo {
public static void main(String[] args) {
	Integer a = new Integer (15); // Wrapper class object
	int i= a; // Unboxing will occur internally.
	int y=900;
	Integer yObj=y;
	System.out.println( "a value : "+a);
	System.out.println(a.getClass().getName());	
	System.out.println("y datatype (boxed): " + yObj.getClass().getName());
	System.out.println( "I value : "+i);
	System.out.println(((Object) i).getClass().getName());
	float f=10.7f;
	Float f1=new Float(f);
	System.out.println(f1);
	Float f2=new Float("10");
	System.out.println(f2);
	Float f3=new Float("ten");
	System.out.println(f3);//NumberFormatException
	Integer i1=new Integer(2);
	System.out.println(i1);
	Integer i2=new Integer("two");
	System.out.println(i2);//NumberFormatException

}
}
