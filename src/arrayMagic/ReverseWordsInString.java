package arrayMagic;

/**
 * Given an input string s, reverse the order of the words.

	A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
	
	Return a string of the words in reverse order concatenated by a single space.
	
	Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
	
	Example 1:
	Input: s = "the sky is blue"
	Output: "blue is sky the"
	
	Example 2:
	Input: s = "  hello world  "
	Output: "world hello"
	Explanation: Your reversed string should not contain leading or trailing spaces.
	
	Example 3:
	Input: s = "a good   example"
	Output: "example good a"
	Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
	
	Constraints:
	
	1 <= s.length <= 104
	s contains English letters (upper-case and lower-case), digits, and spaces ' '.
	There is at least one word in s.
	 
	
	Follow-up: If the string data type is mutable in your language, 
	can you solve it in-place with O(1) extra space?
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ReverseWordsInString {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(reverseWords("the sky is blue"));
		p(reverseWords("   hello world"));
		p(reverseWords("a good   example"));
	}
	static String reverseWords(String s) {
		if(s == null || s.length() == 0) return "";
		// strip spaces from left and right
		s = s.strip();
        // split them via spaces n
        // create a new array with n size and put the elements there
        // reverse the indices
        String[] spaceDel = s.split(" ");
        
        String result = "";
        for(int i = spaceDel.length - 1; i >= 0; i--) {
        	String current = spaceDel[i].strip();
        	if(current.length() == 0) continue;
        	if(i != spaceDel.length - 1)
        		result += " ";
        	result += current;
        }
        
        return result;
    }
}
