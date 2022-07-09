package amazon;

import java.util.PriorityQueue;

/**
 * Given a string ‘str’ of digits and an integer ‘n’, build the lowest possible number 
 * by removing ‘n’ digits from the string and not changing the order of input digits.
	Examples: 
	
	Input: str = "4325043", n = 3
	Output: "2043"
	
	Input: str = "765028321", n = 5
	Output: "0221"
	
	Input: str = "121198", n = 2
	Output: "1118"
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class RemoveKDigits {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
//		p(buildPossibleLowestNumber("4325043", 3));
//		p(buildPossibleLowestNumber2("4325043", 3));
//		p(buildPossibleLowestNumber2("10", 2));
		p(buildPossibleLowestNumber2("112", 2));
//		p(buildPossibleLowestNumber2("10010", 1));
	}
	static String buildPossibleLowestNumber(String str, int target) {
		if(str.length() <= 1 || str == null || target <= 0) return "";
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		
		for(char digit : str.toCharArray())
			maxHeap.add(Integer.parseInt(digit + ""));
	
		while(target-- > 0) maxHeap.remove();
		
		return "";
	}
	/* 
	 * Or a completely different approach would be to compare the leading digit against the one before and decide
	 * which to keep;
	 */
	static String buildPossibleLowestNumber2(String str, int target) {
		if(str.length() < 1 || str == null || target <= 0) return "";
		while(target-- > 0 && str.length() > target) {
			int leading = val(str, 0);
			int following = val(str, 1);
			
			int index = 1;
			
			// making sure leading and following are distinct
			while(leading == following && index < str.length()) {
				following = val(str, index++);
			}
			
			if(str.length() > 1) {
				if(leading > following)
					str = str.substring(index);
				else str = str.substring(0, 1) + str.substring(index + 1);
			} else str = "";
			p(str);
		}
		return str.length() == 0 ? "0" : Integer.parseInt(str) + ""; // to remove leading zeros.
	}
	private static int val(String num, int index) { return Integer.parseInt(num.charAt(index)+""); }
}
