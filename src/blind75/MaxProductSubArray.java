package blind75;
/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

	The test cases are generated so that the answer will fit in a 32-bit integer.
	A subarray is a contiguous subsequence of the array.
	
	Example 1:
	Input: nums = [2,3,-2,4]
	Output: 6
	Explanation: [2,3] has the largest product 6.
	
	Example 2:
	Input: nums = [-2,0,-1]
	Output: 0
	Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class MaxProductSubArray {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(maxProductSubArray(new int[] {2,3,-2,4}));
		p(maxProductSubArray(new int[] {-2,0,-1}));
	}
	// sliding window
	// keep currentMax non negative when becomes
	// devide by the the left element and negative move the left++
	static int maxProductSubArray(int[] arr) {
		if(arr.length == 0 || arr == null) return 0;
		if(arr.length == 1) return arr[0];
		int maxProduct = Integer.MIN_VALUE;
		int currentMax = 1;
		int left = 0;
		for(int right = 1; right < arr.length; right++) {
			while(currentMax < 0 && right > left) currentMax /= arr[left++];
			currentMax *= arr[right];
			maxProduct = Math.max(currentMax, maxProduct);
		}
		return maxProduct;
	}
	static int maxProductSubArray2(int[] arr) { 			//O(N^2)
		if(arr.length == 0 || arr == null) return 0;
		else if(arr.length == 1) return arr[0];
		int maxProduct = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			int currentProduct = 1; // product identity;
			for(int j = i; j < arr.length; j++) {
				currentProduct *= arr[j];
				maxProduct = Math.max(maxProduct, currentProduct);
			}
		}
		return maxProduct;
	}
}





