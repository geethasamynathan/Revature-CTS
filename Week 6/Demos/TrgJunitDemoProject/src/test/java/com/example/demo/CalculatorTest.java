package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class CalculatorTest {
	Calculator calculator;

	@BeforeAll
	static void beforeAllTests() {
		System.out.println(" ⏺️ Calculator Test Suites Started ");
	}

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@Test
	@DisplayName("Addition Test")
	void testAdd() {
		int result = calculator.add(10, 20);
		assertEquals(30, result);
	}
	@Test
	void testSubtract() {
		
		int result = calculator.subtract(10, 20);
		assertEquals(-10, result);
	}

	@Test
	void testMultiply() {		
		int result = calculator.multiply(10, 20);
		assertEquals(200, result);
	}

	@Test
	@Disabled("Feature under Development")
	void testDivide() {		
		int result = calculator.divide(100, 20);
		assertEquals(5, result);
	}

	
	@AfterEach
	void tearDown() {
		calculator=null;
		System.out.println("calculator object Destroyed");
	}
	
	@AfterAll
	static void afterAllTests() {
		System.out.println(" ⛔ Calculator test Suite Finished");
	}
}
