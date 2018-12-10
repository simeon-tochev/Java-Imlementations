package algorithms.sorting;

public class CocktailShakerSort {
	
	public static int[] sort(int[] arr) {
		int len = arr.length;
		
		for(int i = 0; i <= len/2; i++) {
			for(int j = i; j < len - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int x = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = x;
				}
			}
			for(int j = len - i - 2; j > i; j--) {
				if(arr[j] < arr[j-1]) {
					int x = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = x;
				}
			}
		} return arr;
	}
}
