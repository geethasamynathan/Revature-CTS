package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeCreateRequest;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService)
	{
		this.employeeService=employeeService;
	}
	
//	  // Create employee+profile
//  @PostMapping("/create")
//  public Employee create(@RequestParam String name,@RequestParam String email,
//		  @RequestParam String phone,@RequestParam  String address) {
//	  System.out.println("Name : "+name+"- "+email+"-"+phone+"- "+address);
//      return employeeService.createEmoployeeWithProfile(
//              name,email,phone,address
//      );
//  }
  @PostMapping("/create")
  public Employee create(@RequestBody EmployeeCreateRequest employeeProfile) {
	  
      return employeeService.createEmoployeeWithProfile(
              employeeProfile.getName(),
              employeeProfile.getEmail(),
              employeeProfile.getProfile().getPhone(),
              employeeProfile.getProfile().getAddress()
      );
  }
	
	@GetMapping
	public List<Employee> all(){
		return employeeService.getAll();
	}
	  @GetMapping("/{id}")
	    public Employee byId(@PathVariable Long id) {
	        return employeeService.getById(id);
	    }

	    @DeleteMapping("/{id}")
	    public String delete(@PathVariable Long id) {
	        employeeService.deleteById(id);
	        return "Deleted employee id = " + id;
	    }
}
