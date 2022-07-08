package amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of distinct elements and a number x, find if there is a pair with product equal to x.
 *  
 *  Input: arr[] = {1, 5, 3, 4, 2}, K = 3 
	Output: 1 
	Explanation: 
	There is only one pair (1, 3) with product = K = 3.
	
	Input: arr[] = {1, 2, 16, 4, 4}, K = 16 
	Output: 2 
	Explanation: 
	There are two pairs (1, 16) and (4, 4) with product = K = 16.
	
	** Distinct **
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class FindPairSum {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(findPairProductCount(new int[] {1, 5, 3, 4, 2}, 3));
		p(findPairProductCount(new int[] {1, 2, 16, 4, 4}, 16));
	}
	static int findPairProductCount(int[] arr, int target) {
		// build a frequency map, and look for matches and remove them and continue
		Set<Integer> uniqueSet = new HashSet<>();
		for(int i = 0; i < arr.length; i++)
			uniqueSet.add(arr[i]);
		
		int count = 0;
		for(int each : arr) {
			int current = target / each;
			if(uniqueSet.contains(current)) {
				uniqueSet.remove(current);
				uniqueSet.remove(each);
				count++;
			}
		}
		return count;
	}
}
