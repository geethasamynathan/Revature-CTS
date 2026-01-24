package com.example.demo;

import java.util.*;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private Map<Integer, Employee> db = new HashMap<>();

   
    public void save(Employee employee) {
        db.put(employee.getId(), employee);
    }

  
    public Employee findById(int id) {
        return db.get(id);
    }

   
    public List<Employee> findAll() {
        return new ArrayList<>(db.values());
    }


    public void deleteById(int id) {
        db.remove(id);
    }
}