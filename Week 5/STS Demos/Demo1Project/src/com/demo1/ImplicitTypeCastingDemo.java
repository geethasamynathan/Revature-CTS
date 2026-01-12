package com.demo1;

public class ImplicitTypeCastingDemo {

	public static void main(String[] args) {
		int items =10;
		double itemsDouble=items; //implicit type cast
		
		double pricePerItem=78.50;
		double total= itemsDouble*pricePerItem;
		
		System.out.println("Items :"+items);
		System.out.println("Total bill : "+total);
		
	}
}
