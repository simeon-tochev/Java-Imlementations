package structures;

import java.util.Arrays;
import java.util.Iterator;

public class Stack<T> implements Cloneable, Iterable<T>{
	
	private T[] arr;
	private int size;
	private int capacity;
	
	// Public methods
	
	@SuppressWarnings("unchecked")
	/** Creates an empty stack */
	public Stack(){
		capacity = 10;
		arr = (T[])new Object[capacity];
		size = 0;
	}
	
	/** Add an element to the top of the stack */	
	public void push(T element) {
		if(full()) {expand();} 
		
		arr[size] = element;
		size++;
	}
	
	/** Returns the top element of the stack and removes it */
	public T pop() {
		if(empty()) {
			System.out.println("Stack is empty");
			return null;
		} else {
			size--;
			return arr[size];
		}
	}
	
	/** Returns the top element of the stack without removing it */
	public T peek() {
		if(empty()) {
			System.out.println("Stack is empty");
			return null;
		} else {
			return arr[size-1];
		}
	}
	
	/** Returns true if the stack has no elements */
	public boolean empty() {
		return size == 0;
	}
	
	/** Returns the number of elements in the stack */
	public int getSize() {
		return size;
	}
	
	// Overridden methods
	
	@Override
	/** Returns a new stack with the same elements */
	public Object clone() {
		Stack<T> st = new Stack<T>();
		Stack<T> copyStack = new Stack<T>();
		for(T el: this) {
			copyStack.push(el);
		}
		for(T el: copyStack) {
			st.push(el);
			push(el);
		}
		return st;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new StackIterator<T>();
	}
	
	
	// Private methods
	private void expand() {
		capacity += 10;
		arr = Arrays.copyOf(arr, capacity);
	}
	
	private boolean full() {
		return size == capacity;
	}

	@SuppressWarnings("hiding")
	private class StackIterator<T> implements Iterator<T>{

		@Override
		public boolean hasNext() {
			return !empty();
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			return (T) pop();
		}
		
	}
	
	
}
