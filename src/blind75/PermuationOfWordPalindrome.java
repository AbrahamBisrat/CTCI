package blind75;

import java.util.HashSet;
import java.util.Set;

public class PermuationOfWordPalindrome {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(permutationPalindrome("code"));
		p(permutationPalindrome("aab"));
		p(permutationPalindrome("carerac"));
	}
	static boolean permutationPalindrome(String s) {
		Set<Character> unique = new HashSet<>();
		for(char letter : s.toCharArray()) {
			if(unique.contains(letter)) unique.remove(letter);
			else unique.add(letter);
		}
		return unique.size() <= 1;
	}
}
