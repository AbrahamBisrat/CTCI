package neetcode.TwoPointers;

import java.util.Arrays;

/**
 * Given a 1 - indexed array of integers numbers that is already sorted in 
 * non - decreasing order, find two numbers such that they add up to a specific
 * target number. 
 * 
 *  Example 1:
	Input: numbers = [2,7,11,15], target = 9
	Output: [1,2]
	Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
	
	Example 2:
	Input: numbers = [2,3,4], target = 6
	Output: [1,3]
	Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
	
	Example 3:
	Input: numbers = [-1,0], target = -1
	Output: [1,2]
	Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class TwoSum {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(int[] arr) { p(Arrays.toString(arr)); }
	public static void main(String[] args) {
		pA(twoSum(new int[] {2, 7, 11, 15}, 9));
		pA(twoSum(new int[] {2, 3, 4}, 6));
		pA(twoSum(new int[] {-1, 0}, -1));
		
		pA(twoSumTwoPointer(new int[] {2, 7, 11, 15}, 9));
		pA(twoSumTwoPointer(new int[] {2, 3, 4}, 6));
		pA(twoSumTwoPointer(new int[] {-1, 0}, -1));
	}
	
	public static int[] twoSum(int[] arr, int k) {
		for(int i = arr.length - 1; i >= 0; i--) {
			if(arr[i] > k && k > 0) continue;
			for(int j = 0; j < i; j++) {
				if(arr[i] + arr[j] == k)
					return new int[] {j+1, i+1};
			}
		}
		return null;
	}
	/** Better with Two pointer **/
	public static int[] twoSumTwoPointer(int[] arr, int k) {
		if(arr.length<=1 || arr==null) return null;
		int left = 0;
		int right = arr.length - 1;
		while(right > left) {
			if(arr[right] > k && k > 0) {
				right--;
				continue;
			}
			if(arr[left] + arr[right] == k)
				return new int[] {left+1, right+1};
			if(arr[right] + arr[left] > k)
				right--;
			else left++;
		}
		return null;
	}
}
