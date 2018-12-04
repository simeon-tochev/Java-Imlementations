package structures;

import java.util.Iterator;

public class LinkedList<T> implements Cloneable, Iterable<T> {
	@SuppressWarnings("hiding")
	private class Node<T> {
		public Node(T el) {
			data = el;
			next = null;
		}
		
		public Node(T el, Node<T> next) {
			data = el;
			this.next = next;
		}
		
		public T data;
		public Node<T> next;
	}
	
	Node<T> head;
	int size;
	
	public LinkedList(){
		head = null;
		size = 0;
	}
	
	public void add(T el) {
		getLastNode().next = new Node<T>(el);
	}
	
	public T get(int index) {
		Node<T> curr = head;
		for(int i = 0; i < index; i++) {
			if(curr.next == null) {
				return null;
			}
			curr = curr.next;
		} return curr.data;
	}
	
	public T getLast() {
		return getLastNode().data;
	}
	
	public boolean contains(T el) {
		return false;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	private Node<T> getLastNode(){
		Node<T> curr = head;
		while(curr.next != null) {
			curr = curr.next;
		}
		return curr;
	}
	
	// Overridden Methods
	
	@Override
	public LinkedList<T> clone(){
		LinkedList<T> list = new LinkedList<T>();
		for(T el : this) {
			list.add(el);
		}
		return list;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator<T>();
	}
	
	@SuppressWarnings("hiding")
	private class LinkedListIterator<T> implements Iterator<T> {
		
		@SuppressWarnings("unchecked")
		private Node<T> curr = new Node<T>(null, (Node<T>) head);
		
		@Override
		public boolean hasNext() {
			return curr.next != null;
		}
		
		@Override
		public T next() {
			T el = curr.data;
			curr = curr.next;
			return el;
		}
		
	}
	
}
