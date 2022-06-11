package chapterOne;

import java.util.HashMap;
import java.util.Map;

/**
 * There are three types of edits that can be performed on an array
 * insert char, replace char or remove char
 * 
 * Given two strings a and b: write an alg that checks if they are ;one away;
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class OneAway {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(oneAway("pale", "ple"));
		p(oneAway("pales", "pale"));
		p(oneAway("bale", "bale"));
		p(oneAway("pale", "bake"));
	}
	/* find the different element, try three operations while checking 
	 * If the difference is less than or equal to one. one of the operations will inevitably work.
	 * otherwise return false; */
	private static boolean oneAway(String x, String y) {
		// put x and y into a map, and if the difference in length is more than one return false;
		Map<Character, Integer> seen  = new HashMap<>();
		for(char each : x.toCharArray())
			seen.put(each, seen.getOrDefault(each, 0) + 1);
		for(char each : y.toCharArray()) {
			if(seen.containsKey(each)) {
				seen.put(each, seen.get(each) - 1);
				if(seen.get(each)==0)
					seen.remove(each);
			}
			p(seen);
		}	
		return seen.size() <= 1;
	}
}
