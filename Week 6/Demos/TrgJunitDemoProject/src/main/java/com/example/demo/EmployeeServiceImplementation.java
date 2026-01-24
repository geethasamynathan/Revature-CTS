package com.example.demo;

import java.util.List;

public class EmployeeServiceImplementation {
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public void addEmployee(Employee employee) {
		if (employee == null)
			throw new IllegalArgumentException("Employee cannot be null");

		if (employee.getSalary() <= 0)
			throw new IllegalArgumentException("Salary must be greater than zero");
		employeeRepository.save(employee);
	}

	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public void removeEmployee(int id) {
		employeeRepository.deleteById(id);
	}
}

