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
	static int minCoinChange(int[] coins, int amount) {
		// [sum, amount of coins required]
		int[][] dp = new int[amount + 1][coins.length + 1];
		
		for(int i = 1; i < amount; i++) {
			for(int j = 0; j < coins.length; j++) {
				dp[i][1] = Math.min(dp[i - 1][1], coins[j]);
			}
		}
		printArray(dp);
		return 0;
	}
	private static void printArray(int[][] dp) {
		for(int[] eachArr : dp)
			pA(eachArr);
	}
}