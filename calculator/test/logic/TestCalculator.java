package logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalculator {
	Calculator calc = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calc = new CalculatorImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAdd() {
		assertEquals(4.0, calc.add(2.0, 2.0), 0.00000001);
		assertEquals(0.0, calc.add(-2.0, 2.0), 0.00000001);
	}

	@Test
	void testSubtract() {
		fail("Not yet implemented");
	}

	@Test
	void testMultiply() {
		fail("Not yet implemented");
	}

	@Test
	void testDivide() {
		assertEquals(3.33333333, calc.divide(10.0, 3.0), 0.00000001);

	}

	@Test
	void testSqrt() {
		fail("Not yet implemented");
	}

	@Test
	void testClear() {
		assertEquals(0.0, calc.clear(), 0.00000001);
	}

}
