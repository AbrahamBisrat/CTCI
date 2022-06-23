package neetcode.dynamicProgramming;
/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
	Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
	
	Example 1:
	Input: nums = [1,2,3,1]
	Output: 4
	Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
	Total amount you can rob = 1 + 3 = 4.
	
	Example 2:
	Input: nums = [2,7,9,3,1]
	Output: 12
	Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
	Total amount you can rob = 2 + 9 + 1 = 12.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class HouseRobber {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(houseRobberDp(new int[] {1, 2, 3, 1}));
		p(houseRobberDp(new int[] {2,7,9,3,1}));
		p(houseRobberDp(new int[] {2, 1, 1, 2}));
	}
	/* The approach with dynamic programming
	 * dp[i] = max(dp[i-3], dp[i-2]) + houses[i]
	 * where dp[0] = houses[0] and dp[1] = houses[1]
	 */
	private static int houseRobberDp(int[] houses) {
		if(houses.length == 0 || houses == null) return 0;
		else if(houses.length == 1) return houses[0];
		else if(houses.length == 2) return houses[1] > houses[0] ? houses[1] : houses[0];
		else if(houses.length == 3) {
			int temp = houses[0] + houses[2];
			if(temp > houses[1]) return temp;
			else return houses[1];
		}
		int[] dp = new int[houses.length];
		dp[0] = houses[0];
		dp[1] = houses[1];
		dp[2] = dp[0] + houses[2];
		for(int i = 3; i < houses.length; i++)
			dp[i] = Math.max(dp[i-2], dp[i-3]) + houses[i];
		int last = houses.length - 1;
		return dp[last] > dp[last - 1] ? dp[last] : dp[last - 1];
	}
}
