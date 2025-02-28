package assignment2;

public class QueueUnderflowException extends RuntimeException{
	
	public QueueUnderflowException() {
		super("Queue is empty");
	}
	
	public QueueUnderflowException(String msg) {
		super(msg);
	}
}
