package assignment3;

/**
 * You must implement the following test case methods
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import assignment3.BasicDoubleLinkedList.Node;

class BasicDoubleLinkedListTest_STUDENT {

	BasicDoubleLinkedList<Integer> numList;
	IntegerComparator comparator = new IntegerComparator();
	
	@BeforeEach
	void setUp() throws Exception {
		numList = new BasicDoubleLinkedList<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		numList = null;
	}

	@Test
	void testGetSize() {
		assertEquals(numList.getSize(),0);
		
		numList.addToFront(1);
		numList.addToEnd(2);

		assertEquals(numList.getSize(),2);
	}

	
	@Test
	void testAddToEnd() {
		numList.addToEnd(50);
		assertEquals(50, numList.getLast());
		
		numList.addToEnd(100);
		assertEquals(100, numList.getLast());
	}

	
	@Test
	void testAddToFront() {
		numList.addToFront(5);
		assertEquals(5, numList.getFirst());
		
		numList.addToFront(15);
		assertEquals(15, numList.getFirst());
	}

	
	@Test
	void testGetFirst() {
		numList.addToFront(20);
		assertEquals(numList.getFirst(),20);
		
		numList.addToFront(30);
		assertEquals(numList.getFirst(),30);
	}

	@Test
	void testGetLast() {
		numList.addToEnd(25);
		assertEquals(numList.getLast(),25);
		
		numList.addToEnd(35);
		assertEquals(numList.getLast(),35);
	}

	@Test
	void testIterator() {
		numList.addToFront(4);
		numList.addToFront(3);
		numList.addToFront(2);
		numList.addToFront(1);

		ListIterator<Integer> iterator = numList.iterator();
		
		assertFalse(iterator.hasPrevious());
		assertTrue(iterator.hasNext());
		
		assertEquals(iterator.next(),1);
		try {
			iterator.previous();
			fail("Exception wasn't thrown");
		}
		catch(NoSuchElementException e) {}

	}

	@Test
	void testRemove() {
		numList.addToFront(25);
		numList.addToFront(4);
		numList.addToEnd(2);

		Node node = numList.head.next;

		assertEquals(numList.remove(25, comparator),node);
	}

	@Test
	void testRetrieveFirstElement() {
		numList.addToFront(1);
		numList.addToFront(2);
		numList.addToFront(3);
		assertEquals(numList.retrieveFirstElement(),3);	
	}

	@Test
	void testRetrieveLastElement() {
		numList.addToEnd(3);
		numList.addToEnd(2);
		numList.addToEnd(1);
		assertEquals(numList.retrieveLastElement(),1);	
	}

	@Test
	void testToArrayList() {
		numList.addToFront(8);
		numList.addToEnd(6);
		numList.addToEnd(7);
		
		ArrayList<Integer> nums = numList.toArrayList();
		
		String numString = "";
		
		for(int i = 0; i < nums.size(); i++) {
			numString += nums.get(i) + ",";
		}
		
		assertEquals(numString, "8,6,7,");
	}

}
