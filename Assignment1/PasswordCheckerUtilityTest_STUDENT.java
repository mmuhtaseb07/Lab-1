package assignment1;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
* STUDENT tests for the methods of PasswordChecker
* @author
*
*/
public class PasswordCheckerUtilityTest_STUDENT {
	ArrayList<String> passwords = new ArrayList<String>();
	
	@Before
	public void setUp() throws Exception {
		passwords.add("hello");	// index 0
		passwords.add("hello");	// index 1
		passwords.add("HELLO1@"); // index 2
		passwords.add("Hello1@@@"); // index 3
		passwords.add("hEllo2@"); // index 4
		passwords.add("hEllo234@!"); // index 5
	}
	@After
	public void tearDown() throws Exception {
		passwords = null;
	}
	/**
	 * Test if the pass1 is equal to pass2.
	 * This test should throw an UnmatchedException for second case.
	 */
	@Test
	public void testComparePasswords()
	{
		String pass1 = passwords.get(0);
		String pass2 = passwords.get(1);
		
		try {
			PasswordCheckerUtility.comparePasswords(pass1,pass2);
		}
		catch(UnmatchedException e) {
			fail("Shouldn't throw UnmatchedException!");
		}
		
		String pass3 = passwords.get(1);
		String pass4 = passwords.get(2);
		
		try {
			PasswordCheckerUtility.comparePasswords(pass3,pass4);
			fail("Didn't throw UnmatchedException!");
		}
		catch(UnmatchedException e) {}
	}
	
	/**
	 * Test if the pass1 is equal to pass2.
	 */
	@Test
	public void testComparePasswordsWithReturn()
	{
		String pass1 = passwords.get(0);
		String pass2 = passwords.get(1);
		
		assertTrue(PasswordCheckerUtility.comparePasswordsWithReturn(pass1,pass2));
		String pass3 = passwords.get(1);
		String pass4 = passwords.get(2);
		
		assertFalse(PasswordCheckerUtility.comparePasswordsWithReturn(pass3,pass4));
	}
	
	/**
	 * Test if the password has between six and nine chars
	 */
	@Test
	public void testHasBetweenSixAndNineChars()
	{
		String pass1 = passwords.get(4);
		
		assertTrue(PasswordCheckerUtility.hasBetweenSixAndNineChars(pass1));
		String pass2 = passwords.get(0);
		
		assertFalse(PasswordCheckerUtility.hasBetweenSixAndNineChars(pass2));
	}
	
	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		String pass1 = passwords.get(3);
		assertTrue(PasswordCheckerUtility.isValidLength(pass1));
		String pass2 = passwords.get(0);
		
		try {
			PasswordCheckerUtility.isValidLength(pass2);
			fail("Didn't throw LengthException!");
		}
		catch(LengthException e) {}
	}
	
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		String pass1 = passwords.get(3);
		assertTrue(PasswordCheckerUtility.hasUpperAlpha(pass1));
		
		String pass2 = passwords.get(0);
		
		try {
			PasswordCheckerUtility.hasUpperAlpha(pass2);
			fail("Didn't throw NoUpperAlphaException!");
		}
		catch(NoUpperAlphaException e) {}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		String pass1 = passwords.get(0);
		assertTrue(PasswordCheckerUtility.hasLowerAlpha(pass1));
		
		String pass2 = passwords.get(2);
		
		try {
			PasswordCheckerUtility.hasLowerAlpha(pass2);
			fail("Didn't throw NoLowerAlphaException!");
		}
		catch(NoLowerAlphaException e) {}
	}
	
	/**
	 * Test if the password has at least one special character
	 * This test should throw a NoSpecialCharacterException for second case
	 */
	@Test
	public void testIsValidPasswordNoSpecialCharacter()
	{
		String pass1 = passwords.get(2);
		assertTrue(PasswordCheckerUtility.hasSpecialChar(pass1));
		
		String pass2 = passwords.get(0);
		
		try {
			PasswordCheckerUtility.hasSpecialChar(pass2);
			fail("Didn't throw NoSpecialCharacterException!");
		}
		catch(NoSpecialCharacterException e) {}
	}
	
	/**
	 * Test if the password is valid but has less than 10 characters
	 * This test should throw a WeakPasswordException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		String pass1 = passwords.get(5);
		assertFalse(PasswordCheckerUtility.isWeakPassword(pass1));
		
		String pass2 = passwords.get(4);
		
		try {
			PasswordCheckerUtility.isWeakPassword(pass2);
			fail("Didn't throw WeakPasswordException!");
		}
		catch(WeakPasswordException e) {}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		String pass1 = passwords.get(0);
		assertFalse(PasswordCheckerUtility.noSameCharInSequence(pass1));
		
		String pass2 = passwords.get(3);
		
		try {
			PasswordCheckerUtility.noSameCharInSequence(pass2);
			fail("Didn't throw InvalidSequenceException!");
		}
		catch(InvalidSequenceException e) {}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		String pass1 = passwords.get(2);
		assertTrue(PasswordCheckerUtility.hasDigit(pass1));
		
		String pass2 = passwords.get(0);
		try {
			PasswordCheckerUtility.hasDigit(pass2);
			fail("Didn't throw NoDigitException!");
		}
		catch(NoDigitException e) {}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		
		String pass1 = passwords.get(4);
		assertTrue(PasswordCheckerUtility.isValidPassword(pass1));
		
		String pass2 = passwords.get(5);
		assertTrue(PasswordCheckerUtility.isValidPassword(pass2));
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the invalidPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> invalidPass = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertEquals(invalidPass.get(0),"hello");
		assertEquals(invalidPass.get(1),"hello");
		assertEquals(invalidPass.get(2),"HELLO1@");
		assertEquals(invalidPass.get(3),"Hello1@@@");
	}
	
}
