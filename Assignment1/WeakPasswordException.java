package assignment1;

public class WeakPasswordException extends RuntimeException{
	
	public WeakPasswordException() {}
	
	public WeakPasswordException(String message) {
		super(message);
	}
}
