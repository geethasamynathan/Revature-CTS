package com.demo1;

public class ExplicitTypeCastingDemo {
public static void main(String[] args) {
	/*
	  double distanceKM=12.89;
	
	int displayKM=(int)distanceKM;
	
	System.out.println("Actual distance :"+distanceKM);
	System.out.println("Displayed Kilometer :"+displayKM);
	*/
	
	char grade='E';
	int gradeCode=(int) grade;
	char backToChar=(char) gradeCode;
	System.out.println("Grade :"+grade);
	System.out.println("Grade code: "+gradeCode);
	System.out.println("Vack to Grade : "+backToChar);
}

}
