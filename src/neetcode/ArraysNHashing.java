package neetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Arrays and hashing from neetcode exercise package
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ArraysNHashing {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(isAnagram("anagram", "nagrama"));
	}
	public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> seen = new HashMap<>();
        for(char each : s.toCharArray())
            seen.put(each, seen.getOrDefault(each, 0) + 1);
        for(char each : t.toCharArray()){
            if(seen.containsKey(each)) 
                seen.put(each, seen.get(each) - 1);
            if(seen.get(each) == 0)
                seen.remove(each);
        }
        p(seen);
        return seen.size() == 0;
    }
}
