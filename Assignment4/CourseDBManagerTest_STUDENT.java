package assignment4;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
class CourseDBManagerTest_STUDENT {

	CourseDBManager m1;
	CourseDBElement e1 = new CourseDBElement("CMSC226",23156,3,"HT200","John Smith");

	@BeforeEach
	void setUp() throws Exception {
		m1 = new CourseDBManager();
		
		m1.add("CMSC226",23156,3,"HT200","John Smith");
	}

	@AfterEach
	void tearDown() throws Exception {
		m1 = null;
	}

	@Test
	void testAdd() {
		m1.add("CMSC140",23123,4,"HT160","Kevin Jones");
		assertEquals(m1.get(23123).getCredits(),4);
	}

	@Test
	void testShowAll() {
		ArrayList<String> list = m1.showAll();
		
		assertEquals(list.size(), 1);
		assertEquals(list.get(0), e1.toString() + "\n");
	}

	@Test
	void testReadFile() {
		try {
			File courses = new File("courses.txt");
			PrintWriter writer = new PrintWriter(courses);
			writer.println("CMSC140");
			writer.println(23123);
			writer.println(4);
			writer.println("HT160");
			writer.println("Kevin Jones");
						
			writer.close();

			m1.readFile(courses);
			assertEquals(m1.get(23123).getInstructor(),"Kevin Jones");
			assertEquals(m1.get(23123).getCredits(),4);
			
		}
		catch(FileNotFoundException e){
			fail("FileNotFoundException thrown!");
		}

	}

	@Test
	void testGet() {
		m1.add("CMSC140",23123,4,"HT160","Kevin Jones");

		assertEquals(m1.get(23156).getID(),"CMSC226");
		assertEquals(m1.get(23123).getID(),"CMSC140");
	}

}