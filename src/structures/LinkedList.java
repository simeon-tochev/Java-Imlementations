package structures;

public class LinkedList<T> {
	private class Node<T> {
		public Node(T el) {
			data = el;
			next = null;
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
		getLastNode().next = new Node(el);
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
	
}
