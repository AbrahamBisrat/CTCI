package neetcode.dynamicProgramming;
/**
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class FindXInSortedArray {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(binSearch(new int[] {1, 3, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 20}, 5));
		p(binSearch(new int[] {1, 3, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 20}, 17));
	}
	static boolean binSearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		while(end >= start) {
			int mid = (start + end)/2;
			if(arr[mid] == target) return true;
			else if(arr[mid] > target) end = mid - 1;
			else start = mid + 1;
		}
		return false;
	}
}
