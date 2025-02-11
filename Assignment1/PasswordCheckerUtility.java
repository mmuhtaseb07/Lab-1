package assignment1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;


public class PasswordCheckerUtility{
    
	// Compare equality of two passwords
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException(Exception_Messages.PWD_NO_MATCH_EXCEPTION_MSG);
		}
	}

	// Compare equality of two passwords
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		return password.equals(passwordConfirm);
	}
	
	// Accepts an ArrayList of passwords and return an ArrayList with the status of any invalid passwords 
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		
		ArrayList<String> invalid = new ArrayList<String>();
		
		for(int i = 0; i < passwords.size(); i++) {
			
			try {
				isValidPassword(passwords.get(i));
			}
			catch(Exception e){
				invalid.add(passwords.get(i));
			}
		}
		
		return invalid;
	}
	
	// Checks if the password contains 6 to 9 characters
	public static boolean hasBetweenSixAndNineChars(String password) {
		
		return (password.length() >= 6 && password.length() <= 9);
	}
	
	// Checks if password contains a numeric character
	public static boolean hasDigit(String password) throws NoDigitException{
		
		for(int i = 0; i < password.length(); i++) {
			
			char currentChar = password.charAt(i);
			
			if (Character.isDigit(currentChar)) {
				return true;
			}
		}
		throw new NoDigitException(Exception_Messages.DIGIT_EXCEPTION_MSG);
	}
	
	// Checks if password contains a lower case alpha character
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		for(int i = 0; i < password.length(); i++) {
			
			char currentChar = password.charAt(i);
			
			if (Character.isLowerCase(currentChar)) {
				return true;
			}
		}
		throw new NoLowerAlphaException(Exception_Messages.LOWER_ALPHA_EXCEPTION_MSG);
	}
	
	// Checks if password contains a special character
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if ((!matcher.matches())) {
			return true;
		}
		throw new NoSpecialCharacterException(Exception_Messages.SPECIAL_CHAR_EXCEPTION_MSG);
	}
	
	// Checks if password contains a upper case alpha character
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		for(int i = 0; i < password.length(); i++) {
			
			char currentChar = password.charAt(i);
			
			if (Character.isUpperCase(currentChar)) {
				return true;
			}
		}
		throw new NoUpperAlphaException(Exception_Messages.UPPER_ALPHA_EXCEPTION_MSG);
	}
	
	// Checks if password is at least 6 characters long
	public static boolean isValidLength(String password) throws LengthException{ 
		if (password.length() >= 6) {
			return true;
		}
		throw new LengthException(Exception_Messages.INVALID_LENGTH_EXCEPTION_MSG);	
	}
	
	// Checks if password is valid
	public static boolean isValidPassword(String password) throws LengthException,
																  NoUpperAlphaException,
																  NoLowerAlphaException,
																  NoDigitException,
																  NoSpecialCharacterException,
																  InvalidSequenceException{
		// if any method isn't true it will throw the appropriate exception
		isValidLength(password);
		hasUpperAlpha(password);  
		hasLowerAlpha(password);
		hasDigit(password);
		hasSpecialChar(password);
		noSameCharInSequence(password);
		
		// otherwise all methods are true so the password is valid
		return true;
	}
	
	// Checks if password is valid but but the length is NOT between 6-9 characters (inclusive)
	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		if(isValidPassword(password) && hasBetweenSixAndNineChars(password)) {
			throw new WeakPasswordException(Exception_Messages.WEAK_PWD_MSG); 
		}
		return false;
	}

	// Checks if password contains more than 2 of the same character in sequence
	public static boolean noSameCharInSequence(String password) throws InvalidSequenceException{
		
		char pastChar = password.charAt(0);
		int count = 1;

		for(int i = 1; i < password.length(); i++) {
									
			char currentChar = password.charAt(i);
			
			if (pastChar == currentChar) {
				count++;
				if (count > 2) {
					throw new InvalidSequenceException(Exception_Messages.INVALID_SEQUENCE_EXCEPTION_MSG);
				}
			}
			else {
				count = 1;
				pastChar = currentChar;
			}
		}
		return false;
	}

}
