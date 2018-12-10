import algorithms.sorting.*;

public class Main {
	
	static int[] arr = new int[] {5, 8, 12, 2, 0, 0, 16, 2, 3, -23, 4, 6};
	
	public static void main(String[] args) {
		int[] sarr = InsertionSort.sort(arr);
		for(int k: sarr) {
			System.out.println(k);
		}
	}

}
