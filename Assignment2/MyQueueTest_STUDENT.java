package assignment2;


/**
 * This class contains the test case methods that students must implement
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyQueueTest_STUDENT {

	MyQueue<Integer> queue = new MyQueue<>(3);
	MyQueue<String> queue2 = new MyQueue<>(5);

	ArrayList<Integer> arr = new ArrayList<>();
	ArrayList<String> arr2 = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

	}

	@AfterEach
	void tearDown() throws Exception {
		while (!queue.isEmpty()) {
			queue.dequeue();
		}
	}

	@Test
	void testIsEmpty() {
		assertFalse(queue.isEmpty());
		assertTrue(queue2.isEmpty());
	}

	@Test
	void testDequeue() {
		assertEquals(queue.dequeue(),1);
		assertEquals(queue.dequeue(),2);

		try {
			queue2.dequeue();
			fail("Exception wasn't thrown!");
		}
		catch(QueueUnderflowException e) {}

	}

	@Test
	void testSize() {
		assertEquals(queue.size(),3);
		assertEquals(queue2.size(),0);
	}

	@Test
	void testEnqueue() {
		
		try {
			queue.enqueue(4);
			fail("Exception wasn't thrown!");
		}
		catch(QueueOverflowException e) {}
		
		assertTrue(queue2.enqueue("Hello"));
		assertTrue(queue2.enqueue("Hi"));

	}

	@Test
	void testIsFull() {
		assertTrue(queue.isFull());
		assertFalse(queue2.isFull());
	}

	@Test
	void testToString() {
		assertEquals(queue.toString(),"1 2 3 ");
	    assertEquals(queue2.toString(),"");
	}

	@Test
	void testToStringString() {
		assertEquals(queue.toString(","),"1,2,3,");
		assertEquals(queue2.toString("-"),"");	

	}
	@Test
	void testFill() {
		arr.add(4);
		arr.add(5);
		arr.add(6);
		arr.add(7);

		try {
			queue.fill(arr);
			fail("Exception wasn't thrown!");
		}
		catch(QueueOverflowException e) {}
		
		assertEquals(queue.toString(), "4 5 6 ");
		
		arr2.add("Hello");
		arr2.add("Hi");
		arr2.add("Hey");

		queue2.fill(arr2);
		assertEquals(queue2.size(),3);
		
	}

}
