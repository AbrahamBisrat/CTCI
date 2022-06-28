package neetcode;

import java.util.HashSet;
import java.util.Set;

public class findMissingNumber {
	// [1, 2, 3, 4, 6, 7, 8]
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
//		p(findMissingNumber(new int[] {1, 2, 3, 4, 6, 7, 8}));
//		p(findMissingNumber2(new int[] {1, 2, 3, 5, 6, 7, 8}));
		primePrint(20);
	}
	
	static int findMissingNumber(int[] arr) {
		int obtainedSum = 0;
		for(int eachNum : arr)
			obtainedSum += eachNum;
		
		int length = arr.length;
		int expectedSum = length * (length + 1) / 2;

		return expectedSum - obtainedSum ;
	}
	static int findMissingNumber2(int[] arr) {
		// loop through first, find all
		if(arr == null || arr.length == 0)
			throw new IllegalArgumentException("Invalid input");
		
		Set<Integer> numSet = new HashSet<>();
		
		int min = arr[0];
		int max = arr[0];
		
		for(int num : arr) {
			min = Math.min(min, num);
			max = Math.max(max, num);
			numSet.add(num);
		}
		
		for(int i = min; i < max; i++)
			if(!numSet.contains(i))
				return i;
		return -1;
	}
	// write a program to displya the first 20 numbers
	static void primePrint(int n) {
		if(n <= 0) throw new IllegalArgumentException("invalid input");
		int counter = 0;
		
		while(counter < n) {
			for(int i = 1; i < n; i = i + 2) {
				if(checkPrime(i)) {
					counter++;
					p(i);
				}
			}
		}
	}
	static boolean checkPrime(int n) {
		// only divisible by itself and 
		for(int i = 2; i <= n; i++)
			if(i % n == 0)
				return false;
		return true;
	}
}


























