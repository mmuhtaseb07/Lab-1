package lab1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
	GradeBook book1, book2;
	
	@Before
	public void setUp(){
		book1 = new GradeBook(5);
		
		book1.addScore(98.0);
		book1.addScore(75.9);
		
		book2 = new GradeBook(5);
		
		book2.addScore(80.5);
		book2.addScore(100.0);

	}

	@After
	public void tearDown(){
		book1 = null;
		book2 = null;
	}

	@Test
	public void addScoreTest() {
		assertTrue(book1.toString().equals("98.0 75.9 "));
		assertEquals(book1.getScoreSize(),2);
		
		assertTrue(book2.toString().equals("80.5 100.0 "));
		assertEquals(book2.getScoreSize(),2);
	}
	
	@Test
	public void testSum() {
		assertEquals(book1.sum(),173.9, .0001);
		assertEquals(book2.sum(),180.5, .0001);
	}
	
	@Test
	public void testMinimum() {
		assertEquals(book1.minimum(),75.9, .001);
		assertEquals(book2.minimum(),80.5, .001);
	}

	@Test
	public void testFinalScore() {
		assertEquals(book1.finalScore(),98.0, .001);
		assertEquals(book2.finalScore(),100.0, .001);
	}

}
