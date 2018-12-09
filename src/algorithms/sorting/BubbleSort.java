package algorithms.sorting;

public class BubbleSort {
	
	public static int[] sort(int[] arr) {
		int len = arr.length;
		
		for(int i = len - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[j+1]) {
					int x = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = x;
				}
			}
		}
		
		return arr;
	}
}
