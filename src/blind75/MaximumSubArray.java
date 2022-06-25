package blind75;
/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 *  which has the largest sum and return its sum.

	A subarray is a contiguous part of an array.
	
	Example 1:
	Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
	Output: 6
	Explanation: [4,-1,2,1] has the largest sum = 6.
	
	Example 2:
	Input: nums = [1]
	Output: 1

	Example 3:
	Input: nums = [5,4,-1,7,8]
	Output: 23
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class MaximumSubArray {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
		p(maxSubArray(new int[] {-2,-1}));
		p(maxSubArrayBetter(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
		p(maxSubArrayBetter(new int[] {-2,-1}));
		p(maxSubArrayBest(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
		p(maxSubArrayBest(new int[] {-2,-1}));
	}
	// dynamic programming - compute max sum for each prefix
	static int maxSubArray(int[] arr) {					// O(N^3) -> Time limit exceeded
		if(arr.length == 0 || arr == null) return 0;
        if(arr.length == 1) return arr[0];
        int maxSum = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j < arr.length; j++) {
				int currentSum = 0;
				for(int k = i; k <= j; k++) {
					currentSum += arr[k];
					if(currentSum > maxSum) maxSum = currentSum;
				}
			}
		}
		return maxSum;
	}
	static int maxSubArrayBetter(int[] arr) { // O(N^2) 	-> Time limit exceeded
		if(arr.length == 0 || arr == null) return 0;
		if(arr.length == 1) return arr[0];
		int maxSum = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			int currentSum = 0;
			for(int j = i; j < arr.length; j++) {
				currentSum += arr[j];
				if(currentSum > maxSum) maxSum = currentSum;
			}
		}
		return maxSum;
	}
	/* Sliding window pattern : 
	 */
	static int maxSubArrayBest(int[] arr) { // O(N)
		int maxSum = arr[0];
		int currentSum = 0;
		for(int num : arr) {
			if(currentSum < 0) currentSum = 0;
			currentSum += num;
			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
	}
}
