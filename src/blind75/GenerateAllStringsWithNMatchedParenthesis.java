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
		return genAll(n, n, "", new ArrayList<>());
	}
	/*
	 * 	for every iteration Go two valid ways till base case:
	 *  when base case, add it to the list and return;
	 *  
	 *  This is in fact DFS via recursion:
	 *  First go all the way to the base "(((" and back track from there. 
	 */
	static List<String> genAll(int left, int right, String result, List<String> list) {
		
		if(left > 0) genAll(left - 1, right, result + "(", list);
		
		if(right > left) genAll(left, right - 1, result + ")", list);
		
		if(right == 0 && left == 0) list.add(result);
		
		return list;
	}
}
