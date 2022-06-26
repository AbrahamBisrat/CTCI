package blind75;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/**
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
	Return any possible rearrangement of s or return "" if not possible.
	
	Example 1:
	Input: s = "aab"
	Output: "aba"

	Example 2:
	Input: s = "aaab"
	Output: ""
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ReorganizeStringToRemoveDupAdj {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(reorganizeString("aab"));
	}
	public static String reorganizeString(String s) {
        if(s == null || s.length() == 0) return "";
        // build a freq map
        // put the map to a max heap
        // take max and sandwich it between the next smallest element, if it works good, if not return false;
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char letter : s.toCharArray())
            freqMap.put(letter, freqMap.getOrDefault(letter, 0) + 1);
        
        p(freqMap);
        
        PriorityQueue<Character> maxHeap = 
        		new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));
        maxHeap.addAll(freqMap.keySet());
        p(maxHeap);
        
        String result = "";
        while(maxHeap.size() > 1) {
        	char current = maxHeap.remove();
        	char next = maxHeap.remove();
        	result += current + "" + next;
        	freqMap.put(current, freqMap.get(current) - 1);
        	freqMap.put(next, freqMap.get(next) - 1);
        	if(freqMap.get(current) > 0) maxHeap.add(current);
        	if(freqMap.get(next) > 0) maxHeap.add(next);
        }
        if(!maxHeap.isEmpty()) {
        	char last = maxHeap.remove();
        	if(freqMap.get(last) > 1) return "";
        	result += last;
        	p("last : "  + last);
        }
        return result;
    }
}
