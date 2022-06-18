package neetcode.arraysNHashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive
 * elements sequence.
 * 
 * It must run on O(n) time complexity.
 * 
 * 	Example 1:
	Input: nums = [100,4,200,1,3,2]
	Output: 4
	Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
	
	Example 2:
	Input: nums = [0,3,7,2,5,8,4,6,0,1]
	Output: 9
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class logestConsquetive {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(int[] arr) { p(Arrays.toString(arr)); }
	public static void main(String[] args) {
		p(longestCons(new int[] {100, 4, 200, 1, 3, 2}));
		p(longestCons(new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
		p(longestCons(new int[] {9,1,-3,2,4,8,3,-1,6,-2,-4,7}));
	}
	/** keep moving until you find the left most 
	 * and then go as far as you can to the right while counting **/
	private static int longestCons(int[] arr) {
		if(arr.length ==0 || arr == null) return 0;
		Set<Integer> map = new HashSet<>();
		for(int num : arr)
			map.add(num);
		
		int longest = 0;
		int current;
		int right;
		for(int num : map) {
			if(map.contains(num - 1)) continue;
			current = 1;
			right = num + 1;
			while(map.contains(right)) {
				current++;
				right++;
			}
			longest = Math.max(longest, current);
		}
		return longest;
	}
}





