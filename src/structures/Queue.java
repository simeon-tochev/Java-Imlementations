package structures;

import java.util.Arrays;
import java.util.Iterator;

public class Queue<T> implements Cloneable,Iterable<T> {

	T[] arr;
	private int size;
	private int head;
	private int tail;
	private int capacity;
	
	// Public methods
	
	@SuppressWarnings("unchecked")
	/** Create an empty queue */
	public Queue() {
		capacity = 10;
		arr = (T[])new Object[capacity];
		size = 0;
		head = -1;
		tail = -1;
	}
	
	/** Add an element to the tail of the queue */
	public void enqueue(T element) {
		printinf();
		if (empty()) {
			arr[0] = element;
			head = 0;
			tail = 0;
		} else {
			if(full()) {enlarge();}
			if(overflow()) {tail = 0;}
			else {tail++;}
			arr[tail] = element;
		}
		size++;
	}
	
	/** Returns the element at the head of the queue and removes it */
	public T dequeue() {
		printinf();
		if(empty()) {
			System.out.println("Queue is empty");
			return null;
		} else if(head == tail) {
			int temp = head;
			head = -1;
			tail = -1;
			size--;
			return (arr[temp]);
		} else {
			size--;
			if(underflow()) {head = 0; return arr[capacity-1];}
			else {head++; return arr[head-1];}
		}
	}
	
	/** Returns the element at the head of the queue without removing it */
	public T peek() {
		if(empty()) {
			System.out.println("Queue is empty");
			return null;
		} else {
			return arr[head];
		}
	}
	
	/** Returns true if the queue has no elements */
	public boolean empty() {
		return size == 0;
	}
	
	/** Returns the number of elements in the queue */
	public int getSize() {
		return size;
	}

	
	// Overridden methods
	
	@Override
	/** Returns a new queue with the same elements */
	public Object clone() {
		Queue<T> qu = new Queue<T>();
		Queue<T> copyQueue = new Queue<T>();
		for(T el: this) {
			copyQueue.enqueue(el);
		}
		for(T el: copyQueue) {
			qu.enqueue(el);
			enqueue(el);
		}
		return qu;
	}

	@Override
	public Iterator<T> iterator() {
		return new QueueIterator<T>();
	}
	
	// Private methods
	
	private boolean full() {
		return size == capacity;
	}
	
	private boolean overflow() {
		return tail == capacity - 1;
	}
	
	private boolean underflow() {
		return head == capacity - 1;
	}
	
	@SuppressWarnings("unchecked")
	private void relocate() {
		T[] arr2 = (T[])new Object[capacity];
		int j = 0;
		for(int i = head; i != tail; i++) {
			arr2[j] = arr[i];
			j++;
			if(i == capacity - 1) {i = 0;}
		}
		head = 0;
		tail = j;
		arr = arr2;
	}
	
	private void enlarge() {
		if(tail <= head) {relocate();}
		capacity += 10;
		arr = Arrays.copyOf(arr, capacity);
	}
	
	
	@SuppressWarnings("hiding")
	private class QueueIterator<T> implements Iterator<T>{
		@Override
		public boolean hasNext() {
			return !empty();
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			return (T) dequeue();
		}
	}
	
	public void printinf() {
		System.out.println("Head - " + Integer.toString(head) + ", Tail - " + Integer.toString(tail) + ", Size - " + Integer.toString(size) + ", Capacity - " + Integer.toString(capacity));
	}
}
