package neetcode;

import java.util.Stack;
/**
 * Given a string containing only ones zeros and astriks
 * remove adjacent duplicate of 10 or 01 and return the size.
 * example 1: 10*00101111 -> *11 thus the size would be 3.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class RemoveAdjacentDuplicate {
	public static void p(Object line) { System.out.println(line); }

	public static void main(String[] args) {
		p(removeAdj("10010**1010"));
	}

	private static int removeAdj(String input) {
		if (input.length() == 0 || input == null) return 0;
		Stack<Character> stack = new Stack<>();
		for (char letter : input.toCharArray())
			if (!stack.isEmpty() && (stack.peek() == '1' && letter == '0' || stack.peek() == '0' && letter == '1'))
				stack.pop();
			else stack.push(letter);
		return stack.size();
	}
}