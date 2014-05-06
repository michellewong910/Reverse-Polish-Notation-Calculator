package com.example.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class RPNCalculatorTest {

	private final RPNCalculator calc = new RPNCalculator();

	@Test
	public void testSingleNumberInput() {
		String input = "5";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 5", 5, solution);
	}

	@Test
	public void testPlusZero() {
		String input = "5 0 +";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 5", 5, solution);
	}

	@Test
	public void testPlusOne() {
		String input = "5 1 +";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 6", 6, solution);
	}

	@Test
	public void testMinusOne() {
		String input = "5 1 -";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 4", 4, solution);
	}

	@Test
	public void testTwoOperations() {
		String input = "5 1 - 4 +";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 8", 8, solution);
	}

	@Test
	public void testTwoOperationsInARow() {
		String input = "5 1 4 - +";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 2", 2, solution);
	}

	@Test
	public void testMultiplication() {
		String input = "5 4 *";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 20", 20, solution);
	}

	@Test
	public void testDivision() {
		String input = "8 4 /";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 2", 2, solution);
	}

	@Test
	public void testNegativeDivision() {
		String input = "-5 1 /";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal -5", -5, solution);
	}

	@Test
	public void testFactorial() {
		String input = "5 !";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 120", 120, solution);
	}

	@Test
	public void testFactorial1() {
		String input = "1 !";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 1", 1, solution);
	}

	@Test
	public void testPositiveAbsoluteValue() {
		String input = "1 ABS";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 1", 1, solution);
	}

	@Test
	public void testCaseInsensitiveAbsoluteValue() {
		String input = "1 AbS";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 1", 1, solution);
	}

	@Test
	public void testFactorial0() {
		String input = "0 !";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 1", 1, solution);
	}

	@Test
	public void testPi() {
		String input = "PI";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 3", (int) Math.PI, solution);
	}

	@Test
	public void testNegativeAbsoluteValue() {
		String input = "-1 ABS";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 1", 1, solution);
	}

	@Test
	public void testExponent() {
		String input = "-1 2 ^";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 1", 1, solution);
	}

	@Test
	public void testSquareRoot9() {
		String input = "9 SQRT";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 3", 3, solution);
	}

	@Test
	public void testSquareRoot1() {
		String input = "1 SQRT";

		int solution = calc.solveEquation(input);

		assertEquals(input + " should equal 1", 1, solution);
	}
}
