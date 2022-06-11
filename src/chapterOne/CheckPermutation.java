package chapterOne;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings, write a method to decide if one is a permutation of another
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class CheckPermutation {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		String a = "abc";
		String b = "bac";
		String c = "xyz";
		p(checkPermutation(a, c));
		p(checkPermutation(a, b));
		
		p(checkPermutationSortAndComp(a, c));
		p(checkPermutationSortAndComp(a, b));
		
	}
	// O(N) with extra space
	private static boolean checkPermutation(String a, String b) {
		if(a.length() != b.length()) throw new UnsupportedOperationException("unsupported sized input");
		Map<Character, Integer> charMapA = new HashMap<>();
		for(char each : a.toCharArray())
			charMapA.put(each, charMapA.getOrDefault(each, 0) + 1);
		for(char each : b.toCharArray()) {
			if(!charMapA.containsKey(each))
				return false;
			charMapA.put(each, charMapA.get(each) - 1);
		}
		return true;
	}
	// O(NlogN); sort and evaluate equality
	private static boolean checkPermutationSortAndComp(String a, String b) {
		if(a.length() != b.length()) throw new UnsupportedOperationException("unsupported arguments");
		char[] first = a.toCharArray();
		Arrays.sort(first);
		char[] second = b.toCharArray();
		Arrays.sort(second);
		for(int i = 0; i < first.length; i++)
			if(first[i] != second[i])
				return false;
		return true;
	}
}
