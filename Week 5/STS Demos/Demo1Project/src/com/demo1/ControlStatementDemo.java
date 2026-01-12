package com.demo1;

import java.util.Scanner;

public class ControlStatementDemo {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the score");
	int score=sc.nextInt();
	if(score>=90)
	{
		System.out.println(" you obtained Excellent score");
	}
	else if(score >=80 && score<90)
	{
		System.out.println(" you obtained very good score");
	}
	else
	{
		System.out.println(" your score id Fair");
	}
	sc.close();
}
}
