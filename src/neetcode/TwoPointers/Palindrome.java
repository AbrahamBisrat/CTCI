package neetcode.TwoPointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A phrase is a palindrome if, after converting all uppercase letters and removing
 * all non-alphanumeric characters, it reads the same forward and backward;
 * 
 * 	Example 1:
	Input: s = "A man, a plan, a canal: Panama"
	Output: true
	Explanation: "amanaplanacanalpanama" is a palindrome.
	
	Example 2:
	Input: s = "race a car"
	Output: false
	Explanation: "raceacar" is not a palindrome.
	
	Example 3:
	Input: s = " "
	Output: true
	Explanation: s is an empty string "" after removing non-alphanumeric characters.
	Since an empty string reads the same forward and backward, it is a palindrome.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class Palindrome {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(isPalindrome("A man, a plan, a canal: Panama"));
		p(isPalindrome("race a car"));
		p(isPalindrome(" "));
		p(isPalindrome("0P"));
		p(isPalindrome("0002342aabcba00a"));
	}
	public static boolean isPalindrome(String str) {
		if(str.length() == 0 || str == null) return false;
		String input = strip(str.toLowerCase());
		for(int i = 0; i < input.length() / 2; i++)
			if(input.charAt(i) != input.charAt(input.length() - i - 1))
				return false;
		return true;
	}
	private static String strip(String input) {
		String temp = "";
		for(char each : input.toCharArray()) {
			if(each < 96 || each > 96 + 26) continue;
			temp+=each;
		}
		return temp;
	}
}
