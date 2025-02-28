package assignment2;

/**
 * This class contains the test case methods that students must implement
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotationTest_STUDENT {

	Notation notation;
	
	@BeforeEach
	void setUp() throws Exception {
		notation = new Notation();
	}

	@AfterEach
	void tearDown() throws Exception {
		notation = null;
	}

	@Test
	void testEvaluatePostfixExpression() {
		assertEquals(notation.evaluatePostfixExpression("5 6 2 * 3 / +"),9.0);
		assertEquals(notation.evaluatePostfixExpression("7 3 + 4 * 8 2 / - 9 /"), 4.0);
		assertEquals(notation.evaluatePostfixExpression("9 1 2 / 6 + 5 * -"),-23.5);

	}

	@Test
	void testConvertPostfixToInfix() {
		assertEquals(notation.convertPostfixToInfix("5 6 2 * 3 / +"), "(5 + ((6 * 2) / 3)) ");
		assertEquals(notation.convertPostfixToInfix("7 3 + 4 * 8 2 / - 9 /"), "((((7 + 3) * 4) - (8 / 2)) / 9) ");
		assertEquals(notation.convertPostfixToInfix("9 1 2 / 6 + 5 * -"), "(9 - (((1 / 2) + 6) * 5)) ");
	}

	@Test
	void testConvertInfixToPostfix() {
		assertEquals(notation.convertInfixToPostfix("5 + 6 * 2 / 3"), "5 6 2 * 3 / + ");
		assertEquals(notation.convertInfixToPostfix("((7 + 3) * 4 - (8 / 2)) / 9"), "7 3 + 4 * 8 2 / - 9 / ");
		assertEquals(notation.convertInfixToPostfix("9 - (1 / 2 + 6) * 5"), "9 1 2 / 6 + 5 * - ");	
	}

}