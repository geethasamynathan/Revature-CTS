package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
	Calculator calculator;

	@BeforeAll
	static void beforeAllTests_initializeTestSuite() {
		System.out.println(" ⏺️ Calculator Test Suites Started ");
	}

	@BeforeEach
	void beforeEachTest_createCalculatorInstance() {
		calculator = new Calculator();
	}

	@Test
//	@DisplayName("Addition Test")
//	void testAdd()
	@DisplayName("Add: two positive numbers")
	void add_twoPositiveNumbers_returnsCorrectSum() {
		int result = calculator.add(10, 20);
		assertEquals(30, result);

	}

	@Test
	void add_runsOnlyInDevEnvironment() {
		String environment = "DEV"; // simulate config

		assumeTrue(environment.equals("DEV"), "Skipping test: not DEV environment");

		assertEquals(20, calculator.add(10, 10));
	}

	@Test
	// void testSubtract() {
	void subtract_largerMinusSmaller_returnsPositiveResult() {
		int result = calculator.subtract(10, 3);
		// assertEquals(-10, result);
		assertTrue(result == 7); // ✔ Passes if condition is true
	}

	@Test
	void subtract_smallerMinusLarger_returnsNegativeResult() {
		int result = calculator.subtract(10, 20);
		// assertEquals(200, result); //✔ Checks expected value == actual value
		assertFalse(result == -10); // 4*5 is NOT 10 //✔ Passes if condition is false
	}

	@Test
//	@Disabled("Feature under Development")
	void divide_validNumbers_returnsQuotient() {
		double result = calculator.divide(100, 20);
		assertEquals(5.0, result); // ✔ Checks expected value == actual value
		assertNotNull(result); // ✔ Ensures value is not null
	}

	@Disabled("Pending enhancement: decimal precision handling")
	@Test
	void divide_decimalPrecision_underDevelopment() {
		calculator.divide(1, 3);
	}

	@Test
	void divide_byZero_throwsArithmeticException() {
		ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));

		assertEquals("Division by zero not allowed", exception.getMessage());
	}

	// Parameterised Test
	@ParameterizedTest
	@ValueSource(ints = { 2, 5, 8, 9 })
	// void powerofTwoTest(int value) {
	void multiply_numberWithTwo_returnsExpectedResult(int value) {
		assertEquals(value * 2, calculator.powerOfTwo(value));
	}

	@Test
	void multiply_byZero_returnsZero() {
		assertEquals(0, calculator.multiply(10, 0));
	}

	@ParameterizedTest
	@CsvSource({ "10, 5, 15", "20, 10, 30", "5, 5,10" })
	// void testAddWithCsvSource(int a, int b, int expected) {
	void add_multipleInputs_returnsCorrectSum(int a, int b, int expectedSum) {
		Calculator calc = new Calculator();
		assertEquals(expectedSum, calc.add(a, b));
	}

//	//Dynamic Test
//	@TestFactory
//	List<DynamicTest> dynamicAdditionTests() {
//	    Calculator calc = new Calculator();
//
//	    return List.of(
//	        DynamicTest.dynamicTest("10 + 5", () ->
//	            assertEquals(15, calc.add(10, 5))
//	        ),
//	        DynamicTest.dynamicTest("20 + 10", () ->
//	            assertEquals(30, calc.add(20, 10))
//	        )
//	    );
//	}
	@AfterEach
	// void tearDown() {
	void afterEachTest_destroyCalculatorInstance() {
		calculator = null;
		System.out.println("calculator object Destroyed");
	}

	@AfterAll

	// static void afterAllTests()
	static void afterAllTests_cleanupTestSuite() {
		System.out.println(" ⛔ Calculator test Suite Finished");
	}
}
