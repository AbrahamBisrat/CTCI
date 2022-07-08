package neetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeLength {

//'dccaccd' 7
	
//bccc -> cbc, ccc,
//looping through all the characters in the string
	// build a character map
	
	
	public static int longestPalindrome(String rawInput) {
		if(rawInput == null || rawInput.length() == 0) return 0;
		
		int maxLength = 0;
		Map<Character, Integer> freqMap = new HashMap<>();
		for(char letter : rawInput.toCharArray()) {
			freqMap.put(letter, freqMap.getOrDefault(letter, 0) + 1);
		}
		// bcccdd => {b=1, d=2, c=3}
		// loop through the entire freqMap, add the even occurence
		// on the odd occurences, we woudl have
		boolean flagOdd = false;
		for(int freq : freqMap.values()){
			if(freq % 2 == 0) { // even occurence
				maxLength += freq;
			} else {        // odd occurence;
				if(!flagOdd) {
					flagOdd = true;  // you have already seen
					maxLength += freq; // your first odd occurence
				} else {
					maxLength += freq - 1;
				}
			}
		}
		// 1 + 
		return maxLength;
	}
}