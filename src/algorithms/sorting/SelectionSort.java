package algorithms.sorting;

public class SelectionSort {
	public static int[] sort(int[] arr) {
		int len = arr.length;
		for(int i = 0; i < len; i++) {
			int min = arr[i];
			for(int j = i; j < len; j++) {
				if(arr[j] < min) { min = arr[j]; }
			}
			arr[i] = min;
		}
		return arr;
	}
}
