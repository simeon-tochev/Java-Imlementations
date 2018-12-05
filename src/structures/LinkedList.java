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
		if(isEmpty()) {
			head = new Node<T>(el);
			size ++;
			return;
		}
		getLastNode().next = new Node<T>(el);
		size++;
	}
	
	public void addAt(T el, int index) {
		if(index == 0) {
			Node<T> n = new Node<T>(el, head);
			head = n;
			size++;
			return;
		}
		Node<T> curr = head;
		for(int i = 1; i < index; i++) {
			if(curr.next == null) {
				return;
			}
			curr = curr.next;
		}
		Node<T> n = new Node<T>(el, curr.next);
		curr.next = n;
		size++;
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
	
	public void removeLast() {
		if(head == null) {
			return;
		} else if (head.next == null) {
			head = null;
			return;
		}
		Node<T> curr = head;
		while(curr.next.next != null) {
			curr = curr.next;
		}
		curr.next = null;
		size--;
		
	}
	
	public boolean contains(T el) {
		return false;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int getSize() {
		return size;
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
		private Node<T> curr = (Node<T>) head;
		
		@Override
		public boolean hasNext() {
			return curr != null;
		}
		
		@Override
		public T next() {
			T el = curr.data;
			curr = curr.next;
			return el;
		}
		
	}
	
}
