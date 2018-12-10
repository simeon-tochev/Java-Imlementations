package algorithms.sorting;

public class InsertionSort {
	
	public static int[] sort(int[] arr) {
		int len = arr.length;
		int[] sarr = new int[len];
		int k = 0;
		for(int i = 0; i < len; i++) {
			sarr[k] = arr[i];
			for(int j = k - 1; j >= 0; j--) {
				if(sarr[j+1] < sarr[j]) {
					int x = sarr[j];
					sarr[j] = sarr[j+1];
					sarr[j+1] = x;
				} else break;
			}
			k++;
		}
		return sarr;
	}
}
