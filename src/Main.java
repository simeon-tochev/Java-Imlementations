import java.util.Arrays;

import algorithms.sorting.*;

public class Main {
	
	static int[] bigarr = new int[] {338, 107, 347, 993, 189, 2, 304, 57, 4, 745, 219, 596, 607, 429, 183, 552, 981, 161, 510, 518, 169, 868, 460, 345, 815, 597, 747, 635, 102, 801, 432, 132, 475, 973, 812, 248, 235, 652, 228, 488, 262, 923, 811, 858, 135, 180, 155, 995, 998, 645, 10, 225, 565, 231, 90, 296, 960, 141, 50, 403, 630, 266, 210, 373, 397, 509, 874, 361, 752, 152, 318, 440, 867, 215, 828, 239, 533, 446, 5, 171, 260, 139, 583, 305, 322, 690, 896, 47, 937, 546, 382, 945, 300, 989, 350, 360, 449, 703, 232, 855};
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(CocktailShakerSort.sort(bigarr)));
		System.out.println(Arrays.toString(InsertionSort.sort(bigarr)));
		System.out.println(Arrays.toString(BubbleSort.sort(bigarr)));
		System.out.println(Arrays.toString(SelectionSort.sort(bigarr)));
	}

}
