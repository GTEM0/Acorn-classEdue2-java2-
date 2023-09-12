package practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	Calculator calc = new Calculator();
	@Test
	void testAdd() {
		//fail("Not yet implemented");
		assertEquals(3, calc.add(1, 2));
	}

	@Test
	void testSubtract() {
		//fail("Not yet implemented");
		assertEquals(7, calc.subtract(13, 6));
	}

	@Test
	void testMultiply() {
		//fail("Not yet implemented");
		assertEquals(3, calc.multiply(1, 3));
	}

	@Test
	void testDivide() {
		//fail("Not yet implemented");
		assertEquals(10, calc.divide(20, 2));
	}

}
