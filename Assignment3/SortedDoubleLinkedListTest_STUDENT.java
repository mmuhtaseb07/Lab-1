package assignment3;

import static org.junit.Assert.assertEquals;
/**
 * You must implement the following test case methods
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import assignment3.BasicDoubleLinkedList.Node;

class SortedDoubleLinkedListTest_STUDENT {

	SortedDoubleLinkedList<Integer> list;
	IntegerComparator comparator = new IntegerComparator();
	
	@BeforeEach
	void setUp() throws Exception {
		list = new SortedDoubleLinkedList<>(comparator);
	}

	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	@Test
	void testIterator() {
		list.add(1);
		list.add(2);
		list.add(3);
		
		ListIterator<Integer> iterator = list.iterator();
		
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
		list.add(1);
		list.add(2);
		list.add(3);

		Node last = list.tail;
		Node first = list.head;
		
		assertEquals(list.remove(3, comparator), last);
		assertEquals(list.remove(1, comparator), first);
	}

	@Test
	void testAdd() {
		list.add(1);
		list.add(2);
		list.add(3);
		
		assertEquals(list.getFirst(),1);
		assertEquals(list.getLast(),3);

	}

}
