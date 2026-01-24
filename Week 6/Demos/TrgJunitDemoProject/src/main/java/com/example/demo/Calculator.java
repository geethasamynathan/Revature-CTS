package com.example.demo;

public class Calculator {
	
	 public int add(int a, int b) {
	        return a + b;
	    }
	 
	 public int subtract(int a, int b) {
	        return a - b;
	    }
	 
	 public int multiply(int a, int b) {
	        return a * b;
	    }
//	 public int divide(int a, int b) {
//	        return a / b;
//	    }
	 
	 public double divide(int a, int b) {
	        if (b == 0) {
	            throw new ArithmeticException("Division by zero not allowed");
	        }
	        return (double) a / b;
	    }
	 
	 public double powerOfTwo(int side) {
		 return side*2;
	 }
}
