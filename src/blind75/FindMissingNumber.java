package blind75;
/**
 * Given an array nums containing n distinct numbers in the range [0, n], 
 * return the only number in the range that is missing from the array.
	
	Example 1:
	Input: nums = [3,0,1]
	Output: 2
	Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
	
	Example 2:
	Input: nums = [0,1]
	Output: 2
	Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

	Example 3:
	Input: nums = [9,6,4,2,3,5,7,0,1]
	Output: 8
	Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class FindMissingNumber {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		int[] arr = {9,6,4,2,3,5,7,0,1};
		p(findMissing(arr));
	}
	static int findMissing(int[] nums) {
		/* naive solution:
        find min and max;
        put all in Hashset.
        loop all from min to max: that should give the solution
	    */ 
	    if(nums == null || nums.length == 0) return -1;
	    // Set<Integer> numbers = new HashSet<>();
	    // int min = Integer.MAX_VALUE;
	    // int max = Integer.MIN_VALUE;
	    // for(int num : nums) {
	    //     if(num < min) min = num;
	    //     if(num > max) max = num;
	    //     numbers.add(num);
	    // }
	    // for(int i = min; i <= max; i++) {
	    //     if(min != 0) return min - 1;
	    //     if(!numbers.contains(i))
	    //         return i;
	    //     if(i == max) return i + 1;
	    // }
	    // return -1;
	    /* can use the mathimatical formula         sum(n) = n(n+1)/2       {1, 2, 3, 4} = 4(5)/2 = 10*/
	    // sum all elements, and expectedSum - sumObtained = diff - thus the missing number
	    int sumObtained = 0;
	    for(int each : nums)
	        sumObtained += each;
	    int n = nums.length;
	    int expectedSum = (n * (n + 1))/2;
	    return expectedSum - sumObtained;
	}
}
