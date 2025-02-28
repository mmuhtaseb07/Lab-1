package assignment2;

public class StackOverflowException extends RuntimeException{
	
	public StackOverflowException() {
		super("Stack is full");
	}
	
	public StackOverflowException(String msg) {
		super(msg);
	}
}
