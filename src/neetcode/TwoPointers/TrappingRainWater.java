package neetcode.TwoPointers;
/**
 * Given n non-negative integers representing an elevation map where the width of 
 * each bar is 1, compute how much water it can trap after raining.
	
	Example 1:
	Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
	Output: 6
	Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
	
	Example 2:
	Input: height = [4,2,0,3,2,5]
	Output: 9
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class TrappingRainWater {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		p(trap(new int[] {4,2,0,3,2,5}));
	}
	private static int trap(int[] heights) {
		int left = 0;
		int right = heights.length - 1;
		int totalArea = 0;
		while(right > left) {
			int length = right - left;
			int currentArea = Math.min(heights[left], heights[right]) * length;
			for(int i = left + 1; i < right; i++)
				currentArea -= heights[i];
			if(currentArea > 0)
				totalArea += currentArea;
			if(heights[left] < heights[right]) left++;
			else right--;
		}
		return totalArea;
	}
}
