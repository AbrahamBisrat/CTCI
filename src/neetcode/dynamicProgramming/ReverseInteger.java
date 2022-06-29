package neetcode.dynamicProgramming;
/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

	Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

	Example 1:
	Input: x = 123
	Output: 321

	Example 2:
	Input: x = -123
	Output: -321

	Example 3:
	Input: x = 120
	Output: 21
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ReverseInteger {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(reverse(123));
		p(reverse(-321));
		p(reverse(120));
	}
	static int reverse(int x) {
        // take the last element and add it a string.
        // remove last element - and treat the whole thing as a string.
        if(x == 0) return 0;
        boolean negative = false;
        if(x < 0) {
            negative = true;
            x *= -1;
        }
        int result = Integer.parseInt(reverse(x + ""));
        return negative ? result * -1 : result;
    }
    static String reverse(String result) {
        if(result.length() == 2) return result.charAt(1) + "" + result.charAt(0);
        
        String minusLastDigit = result.substring(1, result.length() - 1);
        return result.charAt(result.length() - 1) + reverse(minusLastDigit) + result.charAt(0);
    }
}
