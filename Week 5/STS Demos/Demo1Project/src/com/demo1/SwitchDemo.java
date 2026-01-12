package com.demo1;

import java.util.Scanner;
public class SwitchDemo {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the age");
	int age=sc.nextInt();
	switch(age) {
	case 13:
		System.out.println("Teen Ager");
		break;
	case 18:
		System.out.println("Eligible to drive the vehicle");
		break;
	case 21:
		System.out.println("Eligible to do Work or business");
		break;
	
	default:System.out.println("Invalid age");
	break;

			
	
	}
	sc.close();
}
}
