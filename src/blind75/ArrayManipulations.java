package blind75;

import java.util.Arrays;

/**
 * Basics revisions
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ArrayManipulations {
	static void p(Object line) { System.out.println(line); }
	static void pA(int[] arr) { p(Arrays.toString(arr)); }
	public static void main(String[] args) {
		pA(alternateVersion(new int[] {1, 2, 3, 4, 5, 6, 7}));
	}
	static int[] alternateVersion(int[] arr) {
		pA(arr);
		for(int i = 1; i < arr.length; i+=2) {
			if(arr[i] > arr[i - 1]) 
				swap(arr, i, i - 1);
//			if(i + 1 > arr.length && arr[i + 1] > arr[i])
//				swap(arr, i + 1, i);
		}
		return arr;
	}
	private static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
