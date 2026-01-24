package com.example.demo;

import java.util.List;

public class EmployeeApp {

    public static void main(String[] args) {

        // Step 1: Create repository (FAKE DB)
        EmployeeRepository repository = new EmployeeRepositoryImpl();

        // Step 2: Create service and inject repository
        EmployeeServiceImplementation service =
                new EmployeeServiceImplementation(repository);

        // Step 3: CREATE employees
        System.out.println("---- ADD EMPLOYEES ----");
        service.addEmployee(new Employee(1, "Ravi", "IT", 50000));
        service.addEmployee(new Employee(2, "Anu", "HR", 40000));
        service.addEmployee(new Employee(3, "John", "Finance", 60000));

        // Step 4: READ ALL
        System.out.println("\n---- ALL EMPLOYEES ----");
        List<Employee> employees = service.getAllEmployees();
        employees.forEach(System.out::println);

        // Step 5: READ BY ID
        System.out.println("\n---- GET EMPLOYEE BY ID (2) ----");
        Employee emp = service.getEmployeeById(2);
        System.out.println(emp);

        // Step 6: DELETE
        System.out.println("\n---- DELETE EMPLOYEE ID 1 ----");
        service.removeEmployee(1);

        // Step 7: READ ALL AGAIN
        System.out.println("\n---- EMPLOYEES AFTER DELETE ----");
        service.getAllEmployees().forEach(System.out::println);

        System.out.println("\n✅ Application Finished Successfully");
    }
}