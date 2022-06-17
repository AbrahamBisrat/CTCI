package neetcode.arraysNHashing;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of 
 * all the elements of nums except nums[i]
 * 
 * 	Example 1:
	Input: nums = [1,2,3,4]
	Output: [24,12,8,6]
	
	Example 2:
	Input: nums = [-1,1,0,-3,3]
	Output: [0,0,9,0,0]
	
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ProductOfArrayExceptItself {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(int[] arr) { p(Arrays.toString(arr)); }
	public static void main(String[] args) {
		pA(productExceptSelf(new int[] {1, 2, 3, 4}));
		pA(productExceptSelfNeetCode(new int[] {1, 2, 3, 4}));
	}
	/* Time Complexity O(N)
	 * Space Complexity O(N)
	 */
	private static int[] productExceptSelf(int[] arr) {
		if(arr.length == 0 || arr == null) return null;
		int length = arr.length;
		int[] preffix = new int[length];
		int[] suffix = new int[length];
		int[] result = new int[length];
		preffix[0]=arr[0];
		suffix[length - 1] = arr[length - 1];
		
		for(int i = 1; i < length; i++)
			preffix[i] = arr[i] * preffix[i-1];

		for(int j = length - 2; j >= 0; j--)
			suffix[j] = arr[j] * suffix[j+1];
		
		for(int i = 0; i < length; i++) {
			if(i == 0) result[i] = suffix[i+1]; 					// left bound
			else if(i == length - 1 ) result[i] = preffix[i-1];		// center - both
			else result[i] = preffix[i-1] * suffix[i+1];			// right bound
		}
		
		return result;
	}
	/** Interesting approach from NeetCode */
	public static int[] productExceptSelfNeetCode(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Perform Prefix product operation by traversing Left -> Right
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        pA(result);

        // Perform Postfix product operation by traversing Right -> Left
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }
}
