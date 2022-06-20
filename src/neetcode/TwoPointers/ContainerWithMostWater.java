package neetcode.TwoPointers;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array height of length n. There are n vertical lines drawn such that the 
 * two end-points of the ith line are (i, 0) and (i, height[i]).
 * 
 * Find two lines that together with x-axis form a container such that the container contains the most water.
 * 	
 *  Example 1:
 * 	Input: height = [1,8,6,2,5,4,8,3,7]
	Output: 49
	Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
	
	Example 2:
	Input: height = [1,1]
	Output: 1
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ContainerWithMostWater {
	private static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(containerWithMostWater(new int[] {1,8,6,2,5,4,8,3,7}));
		p(containerWithMostWater2(new int[] {1,8,6,2,5,4,8,3,7}));
	}
	public static int containerWithMostWater(int[] arr) {
		int maxSize = 0;
		int right;
		for(int left = 0; left < arr.length; left++) {
			right = arr.length - 1;
			while(right > left) {
				int width = right - left;
				int height = Math.min(arr[left], arr[right]);
				maxSize = Math.max(maxSize, width * height);
				right--;
			}
		}
		return maxSize;
	}
	// Inspired by Neetcode.io solution
	public static int containerWithMostWater2(int[] heights) {
		int maxSize = 0;
		int left = 0;
		int right = heights.length - 1;
		while(right > left) {
			int width = right - left;
			int area = Math.min(heights[left], heights[right]);
			maxSize = Math.max(maxSize, width * area);
			if(heights[left] < heights[right])
				left++;
			else right--;
		}
		return maxSize;
	}
}
