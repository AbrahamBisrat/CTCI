package chapterOne;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Cracking the coding interview	- 	Chapter one
 * Arrays and Strings in depth
 *  
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ISUNIQUE {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		String[] testString = {"abcdef", "ggabcdefa", "abccdef"};//, new String()};
		isUniqueWithMapTest(testString);p("\n");
		isUniqueNoMapTest(testString);
		isUniqueAsciiTest(testString);
	}
	private static void isUniqueAsciiTest(String[] testString) {
		for(String each : testString)
			p(isUniqueAscii(each));
	}
	private static void isUniqueNoMapTest(String[] testString) {
		for(String each : testString)
			p(isUniqueNoMap(each));
	}
	private static void isUniqueWithMapTest(String[] testArr) {
		for(String each : testArr)
			p(isUniqueWithMap(each));
	}
	// determine if the string has all unique characters
	private static boolean isUniqueWithMap(String string) {
		if(string.length()==0) throw new IllegalArgumentException("invalid input");
		Set<Character> seen = new HashSet<>();
		for(char each : string.toCharArray()) {
			if(seen.contains(each))
				return false;
			seen.add(each);
		}
		return true;
	}
	// No additional data-structures used
	private static boolean isUniqueNoMap(String string) {
		if(string.length()==0) throw new IllegalArgumentException("Invalid argument");
		char[] input = string.toCharArray();
		Arrays.sort(input);
		char prev = input[0];
//		p(Arrays.toString(input));
		for(int i = 1; i < string.length(); i++){
			if(prev == input[i])
				return false;
			prev = string.charAt(i);
		}
		return true;
	}
	// Nifty solution via ASCII interpretation - Map the entire spectrum into an array of 128 bits
	// Example: a - map[96] ...
	private static boolean isUniqueAscii(String input) {
		if(input.length() > 128) return false;
		boolean[] charSet = new boolean[128];
		for(int i = 0; i < input.length(); i++) {
			int val = input.charAt(i);
			if(charSet[val]) return false;
			charSet[val] = true;
		}
		return true;	
	}
	
}
