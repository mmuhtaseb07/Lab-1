package assignment2;

import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T>{

	private T[] queue;
	private int size;
	private static final int DEFAULT_CAPACITY = 30;
	
	public MyQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public MyQueue(int capacity) {
		queue = (T[]) new Object[capacity];
		size = 0;
	}
	
	@Override
	// Determines if Queue is empty
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	// Determines of the Queue is Full
	public boolean isFull() {
		return size >= queue.length;
	}

	@Override
	// Deletes and returns the element at the front of the Queue
	public T dequeue() throws QueueUnderflowException {

		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		T front = queue[0];
		
		// shift elements to remove front element
		for(int i = 0; i < size - 1; i++) {
			queue[i] = queue[i + 1];
		}
		
		// set last element to null after shifting
		queue[size - 1] = null;
		size--;
		return front;
	}

	@Override
	// Returns number of elements in the Queue
	public int size() {
		return size;
	}

	@Override
	// Adds an element to the end of the Queue
	public boolean enqueue(T e) throws QueueOverflowException {

		if(isFull()) {
			throw new QueueOverflowException();
		}
		
		queue[size] = e;
		size++;
		
		return true;
	}

	// Returns the String representation of the elements in the Queue
	public String toString() {
		String elements = "";
		
		for(int i = 0; i < size; i++) {
			elements += queue[i] + " ";
		}
		return elements;
	}
	
	@Override
	// Returns the String representation of the elements in the Queue
	public String toString(String delimiter) {
		String elements = "";
		
		for(int i = 0; i < size; i++) {
			elements += queue[i] + delimiter;
		}
		return elements;
	}

	@Override
	// Fills the Queue with the elements of the ArrayList
	public void fill(ArrayList<T> list) throws QueueOverflowException {
		
		size = 0;
		
		ArrayList<T> copy = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++) {
			copy.add(list.get(i));
		}
		
		for(int i = 0; i < copy.size(); i++) {
			queue[i] = copy.get(i);
			size++; 
			
			if (isFull()) {
				throw new QueueOverflowException();
			}
		}
	}

}
