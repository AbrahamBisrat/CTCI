package neetcode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets nums[i], nums[j], nums[k] 
 * such that all i,j,k are distinct and -> nums[i] + nums[j] + nums[k] = 0
 * 
 * 	Example 1:
	Input: nums = [-1,0,1,2,-1,-4]
	Output: [[-1,-1,2],[-1,0,1]]
	
	Example 2:
	Input: nums = []
	Output: []
	
	Example 3:
	Input: nums = [0]
	Output: []
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ThreeSum {
	private static void p(Object line) { System.out.println(line); }
	private static void pA(int[] arr) { p(Arrays.toString(arr)); }
	public static void main(String[] args) {
		p(threeSum(new int[] {-1, 0, 1, 2, -1, 4}));
		p(threeSum(new int[] {}));
		p(threeSum(new int[] {0}));
		p(threeSum(new int[] {0, 0, 0, 0}));
		p(threeSum(new int[] {1, -1, -1, 0}));
		p(threeSum(new int[] {-1,0,1,2,-1,-4}));
	}
	private static List<List<Integer>> threeSum(int[] arr) {
		List<List<Integer>> resultSet = new ArrayList<>();
		if(arr.length <= 1 || arr == null) return resultSet;
		Arrays.sort(arr);
		int target, left, right;
		List<Integer> temp;
		for(int i = 0; i < arr.length - 2; i++) {
			if(i == 0 || (i > 0 && arr[i] != arr[i - 1])) {
				target = 0 - arr[i];
				left = i + 1;
				right = arr.length - 1;
				
				while(right > left) {
					if(arr[left] + arr[right] == target) {
						temp = Arrays.asList(arr[i], arr[left], arr[right]);
//						if(!resultSet.contains(temp))	// checking is not required.
						resultSet.add(temp);
						while (left < right && arr[left] == arr[left + 1]) { // escape duplicates
                            left++;
                        }
                        while (left < right && arr[right] == arr[right - 1]) {
                            right--;
                        }
						right--;
						left++;
					} else if(arr[left] + arr[right] > target) {
						right--;
					} else {
						left++;
					}
				}
			}
		}
		return resultSet;
	}
}
