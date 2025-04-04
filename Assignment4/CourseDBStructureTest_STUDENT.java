package assignment4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test template provided to students
 * Students must implement the methods
 * 
 * @author Farnaz Eivazi
 * @version 1/31/2024
 *
 */

class CourseDBStructureTest_STUDENT {

	CourseDBStructure s1, s2;
	CourseDBElement e1 = new CourseDBElement("CMSC226",23156,3,"HT200","John Smith");
	CourseDBElement e2 = new CourseDBElement("CMSC140",23123,4,"HT160","Kevin Jones");
	
	@BeforeEach
	void setUp() throws Exception {
		s1 = new CourseDBStructure("Testing",5);
		s2 = new CourseDBStructure(500);
		
		s1.add(e1);
		s1.add(e2);
		
		s2.add(e1);
		s2.add(e2);
	}

	@AfterEach
	void tearDown() throws Exception {
		s1 = s2 = null;
	}

	@Test
	void testCourseDBStructureStringInt() {
		assertEquals(s1.getTableSize(),5);
	}

	@Test
	void testCourseDBStructureInt() {
		assertEquals(s2.getTableSize(),347);
	}

	@Test
	void testAdd() {
		assertEquals(s1.get(23156), e1);
		assertEquals(s1.get(23123), e2);
	}

	@Test
	void testShowAll() {
	
		ArrayList<String> arr = s1.showAll();
		
		assertEquals(arr.get(0),e1.toString() + "\n");
		assertEquals(arr.get(1),e2.toString() + "\n");
	}

	@Test
	void testGet() {	
		assertEquals(s2.get(23156), e1);
		assertEquals(s2.get(23123), e2);	
	}

	@Test
	void testGetTableSize() {
		assertEquals(s1.getTableSize(),5);
		assertEquals(s2.getTableSize(),347);
	}

	@Test
	void testGet4KPrime() {
		assertEquals(CourseDBStructure.get4KPRIME(333),347);
	}
}