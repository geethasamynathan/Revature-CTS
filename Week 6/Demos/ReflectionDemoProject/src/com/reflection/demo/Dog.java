package com.reflection.demo;


public class Dog extends Animal {
	
	public String type;
	
	// public constructor without parameter
	  public Dog() {

	  }

	  public Dog(String name)
	  {
		  
	  }
	  // private constructor with a single parameter
	  private Dog(int age) {

	  }

	// methods of the class
	  public void display() {
	    System.out.println("I am a dog.");
	  }

	  private void makeSound() {
	    System.out.println("Bark Bark");
	  }

}