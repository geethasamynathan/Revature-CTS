package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class PrototypeScopeDemoApplication {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(PrototypeScopeDemoApplication.class, args);
	
	EmployeeService obj1=context.getBean(EmployeeService.class);
	EmployeeService obj2=context.getBean(EmployeeService.class);
	
	System.out.println(" Obj1 hashCode : "+obj1.hashCode());
	System.out.println(" Obj2 hashCode : "+obj2.hashCode());
	if(obj1==obj2)
	{
		System.out.println(" Same Object ");
	}
	else
	{
		System.out.println("Different Object");
	}
	}

}
