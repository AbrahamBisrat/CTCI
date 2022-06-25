package blind75;

import java.util.PriorityQueue;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

	You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
	
	Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
	Example 1:
	Input: prices = [7,1,5,3,6,4]
	Output: 5
	Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
	Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
	
	Example 2:
	Input: prices = [7,6,4,3,1]
	Output: 0
	Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class BestTimeToBuyAndSell {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
//		p(bestTimeToBuyAndSell(new int[] {7, 1, 5, 3, 6, 4}));
		p(bestTimeToBuyAndSellOptimized(new int[] {7, 1, 5, 3, 6, 4}));
	}
	/* Choose a single day to buy the stock and choose another day to sell the stock
	 * the selling date must be later than the buying date.
	 * return the maximum profit you can achieve from the transaction.
	 */
	static int bestTimeToBuyAndSell(int[] prices) { // Time limit Exceeded!!!!
		if(prices.length == 0 || prices == null) return 0;
		// sliding window find the local min and local max
		int maxProfit = 0;
		for(int i = 0; i < prices.length; i++) {
			for(int j = i + 1; j < prices.length; j++) {
				int currentProfit = prices[j] - prices[i];
				if(currentProfit > maxProfit && currentProfit > 0)
					maxProfit = currentProfit; 
			}
		}
		return maxProfit;
	}
	// Better time complexity
	/* Two pointer, as long as left is less than right keep it, when bigger change left to right
	 * Compute the difference and put in i
	 */
	static int bestTimeToBuyAndSellOptimized(int[] prices) {
		int maxProfit = 0;
		int left = 0;
		for(int right = 1; right < prices.length; right++) {
			int currentProfit = 0;
			if(prices[left] < prices[right])
				currentProfit = prices[right] - prices[left];
			else left = right;
			if(currentProfit > maxProfit && currentProfit > 0) 
				maxProfit = currentProfit;
		}
		return maxProfit;
	}
}
