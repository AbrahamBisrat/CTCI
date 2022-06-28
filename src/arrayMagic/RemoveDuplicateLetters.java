package arrayMagic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once. 
 * You must make sure your result is the smallest in lexicographical order among all possible results.
	
	Example 1:
	Input: s = "bcabc"
	Output: "abc"
	
	Example 2:
	Input: s = "cbacdcbc"
	Output: "acdb"
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class RemoveDuplicateLetters {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(removeDupsAndLexOrder("bcabc"));			// abc
		p(removeDupsAndLexOrder("cbacdcbc"));		// acdb
	}
	static String removeDupsAndLexOrder(String input) {
		if(input.length() == 0 || input == null) return "";
		
		// have a char map for last Ocurrences
		// have a stack to make sure what's on hand is the best combination
		
		Map<Character, Integer> lastOcc = new HashMap<>();
		for(int i = 0; i < input.length(); i++)
			lastOcc.put(input.charAt(i), i);
		
		Stack<Character> stack = new Stack<>();
		Set<Character> seen = new HashSet<>();
		
		for(int i = 0; i < input.length(); i++) {
		}
		
		return "";
	}
}
