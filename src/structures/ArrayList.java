package structures;

import java.util.Arrays;
import java.util.Iterator;
import algorithms.sorting.QuickSort;

public class ArrayList<T> implements Cloneable, Iterable<T>{
	
	T[] arr;
	private int size;
	private int capacity;
	
	@SuppressWarnings("unchecked")
	public ArrayList(){
		size = 0;
		capacity = 10;
		arr = (T[])new Object[capacity];
	}
	
	public ArrayList(T[] arr) {
		size = arr.length;
		capacity = size + 10;
		this.arr = Arrays.copyOf(arr, capacity);
	}
	
	private ArrayList(T[] arr, int capacity) {
		size = arr.length;
		this.capacity = capacity;
		this.arr = Arrays.copyOf(arr, capacity);
	}
	
	public void add(T el) {
		if(isFull()) {
			enlarge();
		}
		arr[size] = el;
		size++;
	}
	
	public void add(T el, int index) {
		arr[index] = el;
	}
	
	public void remove(int index) {
		for(int i = index; i < size-1;i++) {
			arr[i] = arr[i+1];
		}
		size--;
	}
	
	public void removeLast() {
		if(isEmpty()) {
			return;
		} else {
			if(hasEmptySpace()) {
				shrink();
			}
			size--;
		}
	}
	
	public T get(int index) {
		if(index >= size) {
			return null;
		} else {
			return arr[index];
		}
	}

	public int getIndexOf(T el) {
		for(int i = 0; i < size; i++) {
			if(el == arr[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean contains(T el) {
		for(T e: arr) {
			if(el == e) {
				return true;
			}
		} return false;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		return arr.toString();
		
	}
	
	public void print() {
		System.out.println(toString());
	}
	
	
	// Private Methods
	
	private boolean isFull() {
		return size == capacity;
	}
	
	private boolean hasEmptySpace() {
		return size < capacity - 20;
	}
	
	private void enlarge() {
		capacity = size + 10;
		this.arr = Arrays.copyOf(arr, capacity);
	}
	
	private void shrink() {
		capacity = size - 10;
		this.arr = Arrays.copyOf(arr, capacity);
	}
	
	// Overridden Methods
	
	@Override
	public ArrayList<T> clone(){
		return new ArrayList<T>(arr, capacity);
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayListIterator<T>();
	}
	
	
	@SuppressWarnings("hiding")
	private class ArrayListIterator<T> implements Iterator<T>{

		int position = 0;
		
		@Override
		public boolean hasNext() {
			return position == size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			T el = (T) arr[position];
			position++;
			return el;
		}
	}
	
}
