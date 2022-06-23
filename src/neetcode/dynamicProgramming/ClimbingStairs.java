package neetcode.dynamicProgramming;

/**
 * 	You are climbing a staircase. It takes n steps to reach the top.
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	 
	Example 1:
	Input: n = 2
	Output: 2
	Explanation: There are two ways to climb to the top.
	1. 1 step + 1 step
	2. 2 steps

	Example 2:
	Input: n = 3
	Output: 3
	Explanation: There are three ways to climb to the top.
	1. 1 step + 1 step + 1 step
	2. 1 step + 2 steps
	3. 2 steps + 1 step
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ClimbingStairs {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(climbingStairsDP(3));
	}
	/* approach using dynamic programming 
	 * dp[i] = dp[i-1] + dp[i-2] with the base cases of dp[0] = 1 and dp[1] = 2 */
	static int climbingStairsDP(int n) {
		int[] dp = new int [n];
		dp[0] = 1;
		dp[1] = 2;
		for(int i = 2; i < n; i++)
			dp[i] = dp[i-1] + dp[i-2];
		return dp[n - 1];
	}
}
