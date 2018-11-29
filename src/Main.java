import structures.Stack;
import structures.Queue;

public class Main {
	
	static Stack<Integer> testStack = new Stack<Integer>();
	static Queue<Integer> testq = new Queue<Integer>();
	
	public static void main(String[] args) {
		testq.enqueue(1);
		testq.enqueue(2);
		testq.enqueue(3);
		testq.enqueue(4);
		testq.enqueue(5);
		testq.enqueue(6);
		testq.enqueue(7);
		testq.enqueue(8);
		testq.enqueue(9);
		testq.enqueue(10);
		testq.enqueue(11);
		testq.enqueue(12);
		testq.enqueue(13);
		testq.enqueue(14);
		testq.enqueue(15);
		testq.enqueue(16);
		testq.enqueue(17);
		testq.enqueue(18);
		
		System.out.println(testq.dequeue()); 
		System.out.println(testq.dequeue()); 
		System.out.println(testq.dequeue());
		System.out.println(testq.dequeue()); 
		System.out.println(testq.dequeue()); 
		System.out.println(testq.dequeue());
		System.out.println(testq.dequeue()); 
		System.out.println(testq.dequeue()); 
		System.out.println(testq.dequeue());
		System.out.println(testq.dequeue());
		System.out.println(testq.dequeue());
	}

}
