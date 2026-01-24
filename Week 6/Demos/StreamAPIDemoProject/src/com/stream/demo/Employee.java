package com.stream.demo;

public class Employee {
	int id;
    String name;
    String department;
    String role;
    double salary;
    int experience;
    String city;
    boolean active;
    int age;
    char grade;
    
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getRole() { return role; }
    public double getSalary() { return salary; }
    public int getExperience() { return experience; }
    public String getCity() { return city; }
    public boolean isActive() { return active; }

    public Employee(int id, String name, String department, String role,
                    double salary, int experience, String city,
                    boolean active, int age, char grade) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.experience = experience;
        this.city = city;
        this.active = active;
        this.age = age;
        this.grade = grade;
    }

    public String toString() {
        return name + " | " + department + " | ₹" + salary;
    }

}
