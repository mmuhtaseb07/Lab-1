package assignment2;

public class StackUnderflowException extends RuntimeException{

	public StackUnderflowException() {
		super("Stack is empty");
	}
	
	public StackUnderflowException(String msg) {
		super(msg);
	}
}
