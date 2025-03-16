package assignment3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

public class BasicDoubleLinkedList<T> implements Iterable<T>{

	protected Node head, tail;
	protected int size;
	
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	protected class Node {
	
		protected T data;
		protected Node prev, next;
		
		public Node(T dataNode) {
			data = dataNode;
			prev = null;
			next = null;
		}
	}
	
	protected class DoubleLinkedListIterator implements ListIterator<T>{
		
		protected Node current;
		
		public DoubleLinkedListIterator() {
			current = null;
		}
		
		// checks if the list has another element
		public boolean hasNext() {
			if(current == null) {
				return head != null;
			}
			return current.next != null;
		}
		
		// iterates to the next element of the list and returns it
		public T next() throws NoSuchElementException{
			if(current == null) {
				current = head;
				return current.data;
			}
			else if(hasNext()) {
				current = current.next;
				return current.data;
			}
			
			throw new NoSuchElementException();
		}
		
		// checks if the list has a previous element
		public boolean hasPrevious() {
			if(current == null) {
				return false;
			}
			return current.prev != null;
		}
		
		// iterates to the previous element of the list and returns it
		public T previous() throws NoSuchElementException{
			if(hasPrevious()) {
				current = current.prev;
				return current.data;
			}
			
			throw new NoSuchElementException();
		}
		
		public void add(T arg0) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
		public int nextIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
		public int previousIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
		public void set(T arg0) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
	}
	
	
	// Adds an element to the end of the list
	public void addToEnd(T data) {
		
		Node node = new Node(data);

		if(head == null || tail == null){
			head = node;
			tail = node;
		}
		else {
			node.prev = tail;
			tail.next = node;
			tail = node;
			tail.next = null;
		}
		
		size++;

	}
	
	// Adds element to the front of the list 
	public void addToFront(T data) {
		
		Node node = new Node(data);

		if(head == null || tail == null){
			head = node;
			tail = node;
		}
		else {
			head.prev = node;
			node.next = head;
			head = node;
			head.prev = null;
		}
		
		size++;

	}
	
	// Returns the first element from the list
	public T getFirst() {
		
		if(head == null) {
			return null;
		}
		
		return head.data;
	}
	
	// Returns the last element from the list
	public T getLast() {
		
		if(tail == null) {
			return null;
		}
		
		return tail.data;
	}
	
	// Returns the size of the list
	public int getSize() {
		return size;
	}
	
	// Returns an object of the DoubleLinkedListIterator
	public ListIterator<T> iterator(){
		return new DoubleLinkedListIterator();
	}
	
	// Removes the first instance of the targetData from the list
	public BasicDoubleLinkedList<T>.Node remove(T targetData, Comparator<T> comparator){
				
		if(head == null) {
			return null;
		}
		
		Node current = head;
		
		for(int i = 0; i < size; i++) {
			if(comparator.compare(current.data,targetData) == 0) {
				if(current == head) {
					head = current.next;
					head.prev = null;
				}
				else if(current == tail) {
					tail = current.prev;
					tail.next = null;
				}
				else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				
				size--;
				return current;

			}
			
			current = current.next;
		}
		
		return null;
	}
	
	// Removes and returns the first element from the list
	public T retrieveFirstElement() {
		
		if(head == null) {
			return null;
		}
		
		T data = head.data;
		
		if(head.next == null) {
			head = null;
			tail = null;
		}
		else {
			head = head.next;
			head.prev = null;
		}
		
		size--;
		return data;
	}
	
	// Removes and returns the last element from the list
	public T retrieveLastElement() {

		if(tail == null) {
			return null;
		}
		
		
		T data = tail.data;
		
		if(tail.prev == null) {
			head = null;
			tail = null;
			size--;
		}
		else {
			tail = tail.prev;
			tail.next = null;
		}
		size--;
		return data;

	}
	
	// Returns an ArrayList of all the items in the Double Linked list
	public ArrayList<T> toArrayList(){
		
		ArrayList<T> items = new ArrayList<>();

		if(head == null) {
			return items;
		}
		
		Node current = head;
				
		for(int i = 0; i < size; i++) {
			items.add(current.data);
			current = current.next;
		}
		
		return items;
	}
}
