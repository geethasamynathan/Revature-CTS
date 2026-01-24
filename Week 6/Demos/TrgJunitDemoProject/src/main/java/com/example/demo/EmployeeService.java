package com.example.demo;

import java.util.List;

public class EmployeeService {

    private EmployeeRepository repository;

    // constructor injection
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void addEmployee(Employee employee) {
        repository.save(employee);
    }

    public Employee getEmployeeById(int id) {
        return repository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public void removeEmployee(int id) {
        repository.deleteById(id);
    }
}