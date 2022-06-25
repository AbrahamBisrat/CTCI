package blind75;
/**
 * There is an integer array nums sorted in ascending order (with distinct values).
	Prior to being passed to your function, nums is possibly rotated at an 
	unknown pivot index k (1 <= k < nums.length) such that the resulting array is 
	[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] 
	(0-indexed). For example, [0,1,2,4,5,6,7] might be rotated 
	at pivot index 3 and become [4,5,6,7,0,1,2].
	
	Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
	You must write an algorithm with O(log n) runtime complexity.

	Example 1:
	Input: nums = [4,5,6,7,0,1,2], target = 0
	Output: 4

	Example 2:
	Input: nums = [4,5,6,7,0,1,2], target = 3
	Output: -1
	
	Example 3:
	Input: nums = [1], target = 0
	Output: -1
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class SearchInRotatedArray {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
//		p(searchInRotatedArray(new int [] {4,5,6,7,0,1,2}, 0));
//		p(searchInRotatedArray(new int [] {4,5,6,7,0,1,2}, 3));
		p(searchInRotatedArray(new int [] {4,5,6,7,0,1,2}, 5));
//		p(searchInRotatedArray(new int [] {1}, 0));
//		p(searchInRotatedArray(new int [] {1, 3}, 0));
	}
	static int searchInRotatedArray(int[] arr, int target) {
		if(arr.length == 0 || arr == null) return 0;
        if(arr.length == 1) return arr[0] == target ? 0 : -1;
        if(arr.length == 2) return arr[0] == target ? 0 : arr[1] == target ? 1 : -1;
        // the same as find the min in rotated array, but the mid element is target
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        while(right >= left) {
            if(arr[mid] == target) return mid;
            else if(arr[left] == target) return left;
            else if(arr[right] == target) return right;
            
            int leftD = Math.abs(arr[left] - arr[mid]);
            int rightD = Math.abs(arr[right] - arr[mid]);
            int leftToTarget = target - arr[left];
            if(leftD > rightD && arr[left] >= target) right = mid - 1;
            else left = mid + 1;
            p(arr[mid]);
            mid = (left + right) / 2;
        }
        return -1;
	}
}
