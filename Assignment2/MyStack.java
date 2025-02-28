package assignment2;

import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T>{

	private T[] stack;
	private int topIndex;
	private static final int DEFAULT_CAPACITY = 10;
	
	public MyStack() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public MyStack(int capacity) {
		stack = (T[]) new Object[capacity];
		topIndex = -1;
	}
	
	@Override
	// Determines if Stack is empty
	public boolean isEmpty() {
		return topIndex == -1;
	}

	@Override
	// Determines if Stack is full
	public boolean isFull() {
		return topIndex == stack.length - 1;
	}

	@Override
	// Deletes and returns the element at the top of the Stack
	public T pop() throws StackUnderflowException {
		
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		
		T top = stack[topIndex];
		stack[topIndex] = null;
		
		topIndex--;
		return top;
	}

	@Override
	// Returns the element at the top of the Stack
	public T top() throws StackUnderflowException {
		
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		
		return stack[topIndex];
	}

	@Override
	// Gets the number of elements in the Stack
	public int size() {
		return topIndex + 1;
	}

	@Override
	// Adds an element to the top of the Stack
	public boolean push(T e) throws StackOverflowException {
		
		if(isFull()) {
			throw new StackOverflowException();
		}
		
		topIndex++;
		stack[topIndex] = e;

		return true;
	}

	// Returns the String representation of the elements in the Stack
	public String toString() {

		String elements = "";
		
		for(int i = 0; i <= topIndex; i++) {
			elements += stack[i] + " ";
		}
		return elements;
	}
	
	@Override
	// Returns the String representation of the elements in the Stack
	public String toString(String delimiter) {
		String elements = "";
		
		for(int i = 0; i <= topIndex; i++) {
			elements += stack[i] + delimiter;
		}
		return elements;
	}

	@Override
	// Fills the Stack with the elements of the ArrayList
	public void fill(ArrayList<T> list) throws StackOverflowException {

		topIndex = -1;
		
		ArrayList<T> copy = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++) {
			copy.add(list.get(i));
		}
		
		for(int i = 0; i < copy.size(); i++) {
			
			stack[i] = copy.get(i);
			topIndex++;
			
			if(isFull()) {
				throw new StackOverflowException();
			}
		}
		
	}

}
