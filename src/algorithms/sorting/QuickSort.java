package algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
	
	private static int[] concat(int[] a1, int[] a2, int[] a3) {
		int l1 = a1.length;
		int l2 = a2.length;
		int l3 = a3.length;
		int l = l1 + l2 + l3;
		
		int[] arr = new int[l];
		
		for(int i = 0; i < l; i++) {
			if(i < l1) {
				arr[i] = a1[i];
			} else if (i < l1 + l2) {
				arr[i] = a2[i-l1];
			} else {
				arr[i] = a3[i-l1-l2];
			}
		}
		return arr;
	}
	
	public static int[] sort(int[] arr) {
		int len = arr.length;
		if(len < 2) { return arr;}
		
		int[] highs = new int[len];
		int[] lows = new int[len];
		int[] equals = new int[len];
		int h = 0, l = 0, e = 0;
		
		int pivot = arr[0];
		
		for(int i = 0; i < len; i++){
			if(arr[i] > pivot) {
				highs[h] = arr[i]; h++;
			} else if (arr[i] < pivot) {
				lows[l] = arr[i]; l++;
			} else {
				equals[e] = arr[i]; e++;
			}
		}
		highs = Arrays.copyOf(highs, h);
		lows = Arrays.copyOf(lows, l);
		equals = Arrays.copyOf(equals, e);
		return concat(sort(lows),equals,sort(highs));
	}
	
	
}


