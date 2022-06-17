package neetcode.arraysNHashing;
/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of 
 * all the elements of nums except nums[i];
 * 
 * The product of any prefix or suffix of nums is guaranteed to fin in a 32- bit integer.
 * You must write an algorithm that runs in o(n) time and without using the division operation.
 * 
 *  Example 1:
	Input: nums = [1,2,3,4]
	Output: [24,12,8,6]
	
	walking through the answer.
	doing for nums[0], meaning the product of nums excluding nums[0]
	ans[0] -> 2 * 3 * 4; 24
	ans[1] -> 1 * 3 * 4; 12
	ans[2] -> 1 * 2 * 4; 8
	ans[3] -> 1 * 2 * 3; 6
	
	Example 2:
	Input: nums = [-1,1,0,-3,3]
	Output: [0,0,9,0,0]
	
	Constraints:
	2 <= nums.length <= 105
	-30 <= nums[i] <= 30
	The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

	Follow up: Can you solve the problem in O(1) extra space complexity? 
	(The output array does not count as extra space for space complexity analysis.)
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ProductExceptSelf {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(productExceptSelf(new int[] {1, 2, 3, 4}));
		p(productExceptSelf(new int[] {-1, 1, 0, -3, 3}));
	}
	private static int[] productExceptSelf(int[] arr) {
		
		
		return null;
	}
}
