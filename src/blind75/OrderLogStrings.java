package blind75;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 
	 You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
	
	There are two types of logs:
	
	    Letter-logs: All words (except the identifier) consist of lowercase English letters.
	    Digit-logs: All words (except the identifier) consist of digits.
	
	Reorder these logs so that:
	
	    The letter-logs come before all digit-logs.
	    The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
	    The digit-logs maintain their relative ordering.
	
	Return the final order of the logs.
	
	Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
	Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
	
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class OrderLogStrings {
	static void p(Object line) { System.out.println(line); }
	static void pA(String[] arr) { p(Arrays.toString(arr)); }
	public static void main(String[] args) {
		String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		pA(orderLogs(logs));
	}
	static String[] orderLogs(String[] logs) {
		Comparator<String> orderByLogType =(a, b) -> {
			return (a.indexOf(' ') + 1) > (b.indexOf(' ') + 1) ? 
					1 : (a.indexOf(' ') + 1) < (b.indexOf(' ') + 1) ? -1 : 0; 
		};
		Arrays.sort(logs, orderByLogType);
		return logs;
	}
}
