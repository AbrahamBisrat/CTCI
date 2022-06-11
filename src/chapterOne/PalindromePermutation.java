package chapterOne;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome
 * 
 * ** is the input a permutation of some palindrome value?
 * caca -> is a permutaiton of a palindrome of 'caac' yada, yada, yada . . .
 * 
 * In simple words -> Does it contain a permutation which is a palindrome?
 * 
 * Example: 'Tact Coa' -> True
 * Explanation: permutations: 'taco cat', 'ataco cta', etc...
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class PalindromePermutation {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(palindromePermutationCheck("Tact Coa"));
	}
	private static boolean palindromePermutationCheck(String input) {
		Set<Character> seen = new HashSet<>();
		for(char each : input.toLowerCase().toCharArray()) {
			if(seen.contains(each))
				seen.remove(each);
			else seen.add(each);
			p(seen);
		}
		seen.remove(' ');
		return seen.size() <= 1;
	}
	// generate permutations
	// check if it is a palindrome?
}
