import structures.Stack;
import structures.Queue;
import structures.ArrayList;
import structures.LinkedList;

public class Main {
	
	static LinkedList<Integer> list = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(6);
		list.addAt(4, 4);
		// System.out.println(list.get(2));
		for(Integer i : list) {
			System.out.println(i);
		}
	}

}
