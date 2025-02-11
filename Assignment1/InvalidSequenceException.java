package assignment1;

public class InvalidSequenceException extends RuntimeException{
	
	public InvalidSequenceException() {}
	
	public InvalidSequenceException(String message) {
		super(message);
	}
}
