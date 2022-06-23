package neetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class MaximumAlternatingSubSequenceSum {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(alternateSum(new int[] {6,20,1,2,4,5}));
	}
	static int alternateSum(int[] nums) {
		int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        
        for(int i = 2; i < nums.length; i++)
            if(i % 2 == 0) 
            	dp[i] = Math.max(Math.max(dp[i - 2], dp[i-2] + nums[i]), nums[i]);
//            else 
//            	dp[i] = Math.min(dp[i - 2], dp[i] + nums[i]);
        
        p(Arrays.toString(nums));
        p(Arrays.toString(dp));
        int last = nums.length - 1;
        if(last % 2 == 1) return dp[last - 1] - dp[last];
        else return dp[last] - dp[last - 1];
	}
}
