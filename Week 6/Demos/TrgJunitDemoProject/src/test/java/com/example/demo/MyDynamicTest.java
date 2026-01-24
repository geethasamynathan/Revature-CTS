package com.example.demo;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;
import java.util.List;

public class MyDynamicTest {
	
	@Test
	 void add_executesWithinTimeLimit() {
	    Calculator calc = new Calculator();

	    assertTimeout(Duration.ofMillis(10), () -> {
	  //  Thread.sleep(50);
	        calc.add(100, 200);
	    });
	}
	
//	
//	@Test
//	void testDivideByZeroException() {
//	    Calculator calc = new Calculator();
//
//	    Exception ex = assertThrows(ArithmeticException.class, () -> {
//	        calc.divide(10, 5);
//	    });
//
//	    assertEquals("Division by zero not allowed", ex.getMessage());
//	}
	
	@TestFactory
	List<DynamicTest> dynamicAdditionTests() {
	    Calculator calc = new Calculator();

	    return List.of(
	        DynamicTest.dynamicTest("10 + 5", () ->
	            assertEquals(15.0, calc.add(10, 5))
	        ),
	        DynamicTest.dynamicTest("20 -10", () ->
	            assertEquals(10, calc.subtract(20, 10))
	        ),
	        DynamicTest.dynamicTest("20 /10", () ->
            assertEquals(2.0, calc.divide(20, 10))
        )
	    );
	}
}
