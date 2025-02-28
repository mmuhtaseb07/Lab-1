package assignment2;

/**
 * This class contains the test case methods that students must implement
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackTest_STUDENT {

	MyStack<Integer> stack = new MyStack<>(5);
	MyStack<String> stack2 = new MyStack<>(2);
	MyStack<Double> stack3 = new MyStack<>(1);

	ArrayList<Integer> arr = new ArrayList<>();
	ArrayList<String> arr2 = new ArrayList<>();

	
	@BeforeEach
	void setUp() throws Exception {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack2.push("Hi");
		stack2.push("Hello");
	}

	@AfterEach
	void tearDown() throws Exception {
		while (!stack.isEmpty()) {
			stack.pop();
		}
		while (!stack2.isEmpty()) {
			stack2.pop();
		}
	}

	@Test
	void testIsEmpty() {
		assertFalse(stack.isEmpty());
		assertFalse(stack2.isEmpty());
		assertTrue(stack3.isEmpty());
	}

	@Test
	void testIsFull() {
		assertFalse(stack.isFull());
		assertTrue(stack2.isFull());
		assertFalse(stack3.isFull());
	}

	@Test
	void testPop() {
		assertEquals(stack.pop(),3);
		assertEquals(stack2.pop(),"Hello");
		
		try {
			stack3.pop();
			fail("Exception wasn't thrown!");
		}
		catch(StackUnderflowException e) {}
	}

	@Test
	void testTop() {
		assertEquals(stack.top(), 3);
		assertEquals(stack2.top(), "Hello");
		
		try {
			stack3.top();
			fail("Exception wasn't thrown!");
		}
		catch(StackUnderflowException e) {}
	}

	@Test
	void testSize() {
		assertEquals(stack.size(), 3);
		assertEquals(stack2.size(), 2);
		assertEquals(stack3.size(), 0);
	}

	@Test
	void testPush() {
		
		assertTrue(stack.push(4));
		assertTrue(stack.push(5));
				
		try {
			stack.push(6);
			fail("Exception wasn't thrown!");
		}
		catch(StackOverflowException e) {}
		
		assertTrue(stack3.push(5.0));
	}

	@Test
	void testToString() {
		assertEquals(stack.toString(),"1 2 3 ");
		
		stack.pop();
		
		assertEquals(stack.toString(),"1 2 ");
		
		stack.push(6);
		
		assertEquals(stack.toString(),"1 2 6 ");

		assertEquals(stack3.toString(),"");
	}

	@Test
	void testToStringString() {
		assertEquals(stack.toString("-"),"1-2-3-");
		assertEquals(stack.toString(","),"1,2,3,");
		assertEquals(stack2.toString(" "),"Hi Hello ");
		assertEquals(stack3.toString("!"),"");
	}

	@Test
	void testFill() {

		arr.add(1);
		arr.add(2);
		arr.add(3);

		stack.fill(arr);
		assertEquals(stack.top(),3);
		assertEquals(stack.size(),3);
		
		arr2.add("Bye");
		arr2.add("Hey");
		arr2.add("Hello");
		
		try {
			stack2.fill(arr2);
			fail("Exception wasn't thrown!");
		}
		catch(StackOverflowException e) {}
		
		assertEquals(stack2.top(), "Hey");
	}

}