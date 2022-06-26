package blind75;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
	There are two types of logs:
	Letter-logs: All words (except the identifier) consist of lowercase English letters.
	Digit-logs: All words (except the identifier) consist of digits.
	Reorder these logs so that:
	
	The letter-logs come before all digit-logs.
	The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
	The digit-logs maintain their relative ordering.
	Return the final order of the logs.
	
	Example 1:
	Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
	Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
	Explanation:
	The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
	The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
	
	Example 2:
	Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
	Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
	Constraints:
	
	1 <= logs.length <= 100
	3 <= logs[i].length <= 100
	All the tokens of logs[i] are separated by a single space.
	logs[i] is guaranteed to have an identifier and at least one word after the identifier.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ReorderDatanLogFiles {
	static void p(Object line) { System.out.println(line); }
	static void pA(Object[] arr) { p(Arrays.toString(arr)); }
	public static void main(String[] args) {
		String[] log = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		String[] desiredOrdering = {"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"};
		pA(reorderLogFiles(log));
		p("");
		pA(desiredOrdering);
	}
	/* criteria
	 * log = {id, {entries delimited by space}}
	 * letter log = all letter except id is lower case letter
	 * digit log = all letter except id is numbers
	 * 
	 * rules
	 * 1 - letter logs before digit logs
	 * 2 - all letter logs are sorted lexicographically 
	 * 3 - digit logs maintain their relative ordering
	 * 
	 */
	static String[] reorderLogFiles(String[] log) {
		Comparator<String> logSort = new Comparator<>() {
			@Override public int compare(String log1, String log2) {
				// letter before digit
				String[] log1Array = log1.split(" ", 2);
				String[] log2Array = log2.split(" ", 2);
				
				//pA(log1Array);
				
				String log1Data = log1Array[1];
				String log2Data = log2Array[1];
				
				// digit vs digit
				if(Character.isDigit(log1Data.charAt(0)) && Character.isDigit(log2Data.charAt(0)))
					return 0;
				// digit vs letter
				if(Character.isDigit(log1Data.charAt(0)) && Character.isAlphabetic(log2Data.charAt(0)))
					return 1;
				// letter vs digit
				if(Character.isDigit(log2Data.charAt(0)) && Character.isAlphabetic(log1Data.charAt(0)))
					return -1;
				// letter vs letter
				if(Character.isAlphabetic(log1Data.charAt(0)) && Character.isAlphabetic(log2Data.charAt(0))) {
					// if different content
					if(!log1Data.equals(log2Data)) {
						return log1Data.compareTo(log2Data);
					} else { // if the same content, sort them with ID
						return log1Array[0].compareTo(log2Array[0]);
					}
				}
				return 0;
			}
		};
		Arrays.sort(log, logSort);
		return log;
	}
}
