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
public class ArraysNStrings {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		String[] testString = {"abcdef", "ggabcdefa", "abccdef"};//, new String()};
		isUniqueWithMapTest(testString);p("\n");
		isUniqueNoMapTest(testString);
		
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
				return true;
			seen.add(each);
		}
		return false;
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
				return true;
			prev = string.charAt(i);
		}
		return false;
	}
	
}
