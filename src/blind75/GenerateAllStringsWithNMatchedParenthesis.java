package blind75;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

	Example 1:
	Input: n = 3
	Output: ["((()))","(()())","(())()","()(())","()()()"]
	
	Example 2:
	Input: n = 1
	Output: ["()"]
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class GenerateAllStringsWithNMatchedParenthesis {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(generateAllN(3));
	}
	static List<String> generateAllN(int n) {
		if(n <= 0) return null;
		genAll(n, n, "", n);
		return matchedParenthesis;
	}
	
	// the states are the right and left parenthesis numbers
	// also the string that we have so far.
	// and for every step as long as we have more left than right, and left != zero,
	// we can have two steps for it, with and without the right parenthesis.
	static List<String> matchedParenthesis = new ArrayList<>();
	static void genAll(int left, int right, String result, int target) {
		if(left > 0)
			genAll(left - 1, right, result + "(", target);
		
		if(right > left)
			genAll(left, right - 1, result + ")", target);
		
		else if(right == 0 && left == 0)
			matchedParenthesis.add(result);
		return;
	}
	
	/*
	 * Recurssion format
	 * 
	 * Base case
	 * 
	 * Termination
	 * 
	 * work + work - 1
	 * 
	 * return work
	 * 
	 */
}
