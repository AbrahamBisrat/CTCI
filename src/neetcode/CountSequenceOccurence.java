package neetcode;

import java.util.Arrays;

/**
 * Find the count of a given sequence that appears in an array.
 *	->>>> There can be any amount of characters between the numbers 
 * of the sequence. ex 4,5,6,2 would have a count of 1.
	sequence 4,6,2
	array [ 3, 4, 4, 6, 7, 8 , 2, 6, 9, 2]
	count of sequences: 6
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class CountSequenceOccurence {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		int[] nums1 = {4,5,6,2};
		int[] pattern1 = {4,6,2};
//		p(countSeqOccurence(nums1, pattern1));
		
		int[] nums2 = {3, 4, 4, 6, 7, 8 , 2, 6, 9, 2};
		int[] pattern2 = {4,6,2};
//		p(countSeqOccurence(nums2, pattern2));
		
		int[] nums3 = {3, 4, 4, 6, 7, 6, 2, 2, 2};
		int[] pattern3 = {4,6,2};
		p(countSeqOccurence(nums3, pattern3));
	}
	static int countSeqOccurence(int[] nums, int[] pattern) {
		int[][] dp = new int[nums.length + 1][pattern.length + 1];
		
		for(int i = 1; i < nums.length; i++)
			dp[i][0] = 1;
		
		
		for(int i=1;i<=nums.length;i++) {
		printDp(dp, nums[i - 1]);
			for(int j=1;j<=pattern.length;j++) {
				dp[i][j] += dp[i-1][j];
				if(nums[i-1] == pattern[j-1]) {
					dp[i][j] += dp[i-1][j-1];
				}
			}
		}
		printDp(dp);
		return dp[nums.length][pattern.length];
	}
	private static void printDp(int[][] dp, int index) {
		p("index : " + index);
		printDp(dp);
	}
	private static void printDp(int[][] dp) {
		for(int[] each : dp)
			p(Arrays.toString(each));
	}
}
