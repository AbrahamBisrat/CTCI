package neetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations 
 * and an integer amount representing a total amount of money.
	Return the fewest number of coins that you need to make up that amount.
	If that amount of money cannot be made up by any combination of the coins, return -1.
	You may assume that you have an infinite number of each kind of coin.
	
	Example 1:
	Input: coins = [1,2,5], amount = 11
	Output: 3
	Explanation: 11 = 5 + 5 + 1
	
	Example 2:
	Input: coins = [2], amount = 3
	Output: -1
	
	Example 3:
	Input: coins = [1], amount = 0
	Output: 0
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class MinCoinChange {
	static void p(Object line) { System.out.println(line); }
	static void pA(int[] arr) { p(Arrays.toString(arr)); }
	public static void main(String[] args) {
		p(minCoinChange(new int[] {1, 2, 5}, 11));
	}
	/* The choice to either take more coins or not take any more any coins 
	 * dp[i] = Math.min(dp[i], 1 + dp[i - c]
	 * 
	 * Using a single dimenstional array
	 */
	static int minCoinChange(int[] coins, int amount) {
		if(amount <= 0) return 0;
		
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		
		for(int desired = 1; desired < amount + 1; desired++) {
			for(int change : coins) {
				if(desired >= change) {
					dp[desired] = Math.min(dp[desired], 1 + dp[desired - change]);
					// dp[currCoin] is filled with amount + 1 by default
				}
			}
		}
		p(Arrays.toString(dp));
		return dp[amount] > amount ? -1 : dp[amount];
    }
	private static void printArray(int[][] dp) {
		for(int[] eachArr : dp)
			pA(eachArr);
	}
}