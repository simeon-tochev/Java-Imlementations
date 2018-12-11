package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
	
	public static int[] sort(int[] arr) {
		int len = arr.length;
		if(len < 2) {return arr;}
		return combine(Arrays.copyOfRange(arr, 0, len/2),Arrays.copyOfRange(arr, len/2, len));
	}
	
	private static int[] combine(int[] a1, int[] a2) {
		int l1 = a1.length, l2 = a2.length;
		int l = l1 + l2;
		int[] arr = new int[l];
		int i = 0, j = 0, k = 0;
		while (i < l1 && j < l2) {
			if(a1[i] < a2[j]) {
				arr[k] = a1[i];
					i++;
				} else {
					arr[k] = a2[j];
					j++;
				}
				k++;
			}
		if(i == l1) {
			for(; j < l2; j++) {
				arr[k] = a2[j];
				k++;
			}
		} else {
			for(; i < l1; i++) {
				arr[k] = a1[i];
				k++;
			}
		}
		return arr;
	}
}
