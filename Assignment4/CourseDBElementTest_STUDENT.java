package assignment4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBElementTest_STUDENT {

	CourseDBElement e1, e2;
	
	@BeforeEach
	void setUp() throws Exception {
		e1 = new CourseDBElement("CMSC226",23156,3,"HT200","John Smith");
		e2 = new CourseDBElement("CMSC140",23123,4,"HT160","Kevin Jones");
	}

	@AfterEach
	void tearDown() throws Exception {
		e1 = e2 = null;
	}

	@Test
	void testHashCode() {
		assertEquals(e1.hashCode(),5);
		assertEquals(e2.hashCode(),8);
	}

	@Test
	void testGetId() {
		assertEquals(e2.getID(),"CMSC140");
		assertEquals(e2.getID(),"CMSC140");
	}

	@Test
	void testGetCrn() {
		assertEquals(e1.getCRN(),23156);
		assertEquals(e2.getCRN(),23123);
	}

	@Test
	void testGetCredits() {
		assertEquals(e1.getCredits(),3);
		assertEquals(e2.getCredits(),4);
	}

	@Test
	void testGetRoomNum() {
		assertEquals(e1.getRoomNum(),"HT200");
		assertEquals(e2.getRoomNum(),"HT160");	
	}

	@Test
	void testGetInstructor() {
		assertEquals(e1.getInstructor(),"John Smith");
		assertEquals(e2.getInstructor(),"Kevin Jones");	
	}
	
	@Test
	void testEqualsObject() {
		assertFalse(e1.equals(e2));
		assertTrue(e1.equals(e1));
	}

	@Test
	void testCompareTo() {
		assertEquals(e1.compareTo(e2),1);
		assertEquals(e2.compareTo(e1),-1);
		assertEquals(e1.compareTo(e1),0);
	}
}