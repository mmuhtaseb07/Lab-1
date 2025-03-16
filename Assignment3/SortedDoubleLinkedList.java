package assignment3;

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{

	private Comparator<T> comparator;
	
	public SortedDoubleLinkedList(Comparator<T> comparableObject) {
		comparator = comparableObject;
	}
	
	// adds element at the correct position in the sorted list
	public void add(T data) {
		
		Node node = new Node(data);
		
		
		if(head == null) {
			head = node;
			tail = node;
		}
		else {
			Node current = head;
			int element = 0;
			
			while(element < size && comparator.compare(current.data,data) <= 0){
				current = current.next;
				element++;
			}

			if(current == head) {
				head.prev = node;
				node.next = head;
				head = node;
				head.prev = null;
			}
			else if(current == null) {
				tail.next = node;
				node.prev = tail;
				tail = node;
				tail.next = null;
			}
			else {
				current.prev.next = node;
				node.prev = current.prev;
				node.next = current;
				current.prev = node;
			}
			
		}
		size++;
	}
	
	// Invalid method for sorted list
	public void addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	// Invalid method for sorted list
	public void addToFront(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	// Implements the iterator by calling the super class iterator method
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	// Implements the remove operation by calling the super class remove method
	public BasicDoubleLinkedList<T>.Node remove(T data, Comparator<T> comparator){
		return super.remove(data, comparator);
	}
	
}
