package amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
	
	Symbol       Value
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
	
	Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
	
	I can be placed before V (5) and X (10) to make 4 and 9. 
	X can be placed before L (50) and C (100) to make 40 and 90. 
	C can be placed before D (500) and M (1000) to make 400 and 900.
	Given an integer, convert it to a roman numeral.
	 
	
	Example 1:
	Input: num = 3
	Output: "III"
	Explanation: 3 is represented as 3 ones.
	
	Example 2:
	Input: num = 58
	Output: "LVIII"
	Explanation: L = 50, V = 5, III = 3.
	
	Example 3:
	Input: num = 1994
	Output: "MCMXCIV"
	Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class IntegerToRoman {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(intToRoman(12345));
	}
	/* Approach
		take the length of the number into consideration to build the respective roman equivalent
		and parse out the to which group of the roman number group it belongs to.
		and for parse out the details and add them the number of times of the 
		digit(3 on the second digit is considered as 30 and will be given XXX accordingly)
		
		example -> 58 -> LV|||
		
		take the biggest possible and think about the rest after that.
		a GREEDY approach.
		
		example 2 -> 1994
		This is 1000 + 900 + 90 + 4
		
		::
		Also another approach would be to push each digit into a stack 
		and pop them out one by one and assign the Roman letters in a greedy approach.
		
		
	 */
	static String intToRoman(int num) {
	    String inputNum = num + "";
	    String romanNum = "";
	    /* I=1, V=5, X=10, L=50, C=100, D=500, M=1000 */
	    char[] romanDigits = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
	    
	    Queue<Integer> queue = new LinkedList<>();
	    for(char digit : inputNum.toCharArray())
	    	queue.add(Integer.parseInt(digit + ""));
	    
	    int index = 1;
	    while(!queue.isEmpty()) {
	    	int currentNum = (int) queue.poll();
	    	p(currentNum);
	    }
	    
	    return  " ";
	}
}




