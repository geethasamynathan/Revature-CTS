package com.demo1;

import java.util.Scanner;

public class PrimitiveUserInputDemo {
public static void main(String[] args) {
 Scanner sc=new Scanner(System.in);
 
 System.out.println("Enter the Years of Experience");
 byte experience=sc.nextByte();
 
 System.out.println("Enter the branch code");
 short branchCode=sc.nextShort();
 
 System.out.println("Enter the Employee Id");
 int empId=sc.nextInt();
 
 System.out.println("Enter the Account Number");
 long accountNumber=sc.nextLong();
 
 
 System.out.println("enter the discount Percentge");
 float discountPercentge=sc.nextFloat();

 System.out.println("Enter the Salary");
 double salary=sc.nextDouble();
 
 System.out.println("Enter the Grade (O,A,B,C)");
 char grade=sc.next().charAt(0);
 
 System.out.println("Enter the  status fof Permenant EMployee");
 boolean isPermanent=sc.nextBoolean();
 // Step 10: Display all values
 System.out.println("\n----- Employee Details -----");
 System.out.println("Experience (Years) : " + experience);
 System.out.println("Branch Code        : " + branchCode);
 System.out.println("Employee ID        : " + empId);
 System.out.println("Account Number     : " + accountNumber);
 System.out.println("Attendance (%)     : " + discountPercentge);
 System.out.println("Salary             : " + salary);
 System.out.println("Grade              : " + grade);
 System.out.println("Permanent Employee : " + isPermanent);
 
 sc.close();
}
}
