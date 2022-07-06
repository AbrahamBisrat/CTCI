package blind75;

import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented 
 * into a space-separated sequence of one or more dictionary words.
	Note that the same word in the dictionary may be reused multiple times in the segmentation.
	
	Example 1:
	Input: s = "leetcode", wordDict = ["leet","code"]
	Output: true
	Explanation: Return true because "leetcode" can be segmented as "leet code".
	
	Example 2:
	Input: s = "applepenapple", wordDict = ["apple","pen"]
	Output: true
	Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
	Note that you are allowed to reuse a dictionary word.
	
	Example 3:
	Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
	Output: false
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class WordBreak {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		List<String> dict = Arrays.asList("leet", "code");
		p(wordBreak("leetcode", dict));
		dict = Arrays.asList("apple","pen");
		p(wordBreak("applepenapple", dict));
		dict = Arrays.asList("cats","dog","sand","and","cat");
		p(wordBreak("catsandog", dict));
	}
	static boolean wordBreak(String word, List<String> dict) {
		int length = 0;
		for(int left = 0; left < word.length(); left++) {
			for(String eachDict : dict) {
				int dictIndex = 0;
				int right = left;
				while(dictIndex < eachDict.length() && eachDict.charAt(dictIndex++) == word.charAt(right++));
				if(right - left == eachDict.length()) length += right - left;
			}
		}
		return word.length() == length;
	}
}
