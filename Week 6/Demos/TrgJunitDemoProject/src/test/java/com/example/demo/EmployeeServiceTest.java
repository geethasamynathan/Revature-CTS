package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//import static org.junit.jupiter.api.*;

//import static org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.*;
import java.util.*;
import org.mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
 
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeService employeeService;
	private Employee employee;
	
	@BeforeEach
	void setUp() {
//		MockitoAnnotations.openMocks(this);
		employee=new Employee(1,"Tina","IT",50000);		
	}
	
	@Test
	void addEmployee_validEmployee_callsSaveOnce() {
		employeeService.addEmployee(employee);
		
		
		verify(employeeRepository,times(1)).save(employee);
		
	}
	
	@Test
	void getEmployeeById_existingId_ReturnsEmployee() {
		
		//stubbing Methods (fake Behaviour)
		when(employeeRepository.findById(1)).thenReturn(employee);
		
		Employee result=employeeService.getEmployeeById(1);
		assertNotNull(result);
		assertEquals("Tina",result.getName());
		
	}
	
	
	// =====================================================
	// READ ALL
	// =====================================================


	@Test
	void getAllEmployees_returnsList() {


	List<Employee> mockList = Arrays.asList(
	employee,
	new Employee(2, "Anu", "HR", 40000)
	);


	when(employeeRepository.findAll()).thenReturn(mockList);


	List<Employee> result = employeeService.getAllEmployees();


	assertEquals(2, result.size());
	}


	// =====================================================
	// DELETE
	// =====================================================


	@Test
	void removeEmployee_validId_callsDelete() {


	employeeService.removeEmployee(1);


	verify(employeeRepository).deleteById(1);
	}
	
	// =====================================================
	// 6. Argument Matchers
	// =====================================================


	@Test
	void addEmployee_anyEmployee_shouldCallSave() {


	employeeService.addEmployee(employee);


	verify(employeeRepository).save(any(Employee.class));
	}
	
	// =====================================================
	// 7. Verification Modes
	// =====================================================


	@Test
	void verify_noMoreInteractions() {


	employeeService.addEmployee(employee);


	verify(employeeRepository).save(employee);
	verifyNoMoreInteractions(employeeRepository);
	}
	// =====================================================
	// 8. Argument Captor
	// =====================================================


	@Test
	void captureEmployeePassedToSave() {


	ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);


	employeeService.addEmployee(employee);


	verify(employeeRepository).save(captor.capture());


	Employee captured = captor.getValue();
	assertEquals("Ravi", captured.getName());
	assertEquals(50000, captured.getSalary());
	}
}
