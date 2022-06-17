package neetcode.arraysNHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Arrays and hashing from neetcode exercise package
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class Anagrams {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(isAnagram("anagram", "nagrama"));
		p(isAnagramImproved("anagram", "nagrama"));
		String[] strs = {"eaaat","tea","taaaan","atttte","nat","bat"};
		p(groupAnagrams(strs));		
		p("");
		strs = new String[]{"eat","tea","tan","ate","nat","bat","ac","bd","aac","bbd","aacc","bbdd","acc","bdd"};
		p(groupAnagrams(strs));
		p(groupAnagramsImproved(strs));
	}
	public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> seen = new HashMap<>();
        for(char each : s.toCharArray())
            seen.put(each, seen.getOrDefault(each, 0) + 1);
        for(char each : t.toCharArray()){
            if(seen.containsKey(each)) {            	
            	seen.put(each, seen.get(each) - 1);
            	if(seen.get(each) == 0)
            		seen.remove(each);
            } else return false;
        }
        p(seen);
        return seen.size() == 0;
    }
	public static boolean isAnagramImproved(String s, String t) {
		if(s.length() != t.length()) return false;
		int[] store = new int[26]; // assuming we the strings are limited to small letters alphabets
		
		for(int i = 0; i < s.length(); i++) {
			store[s.charAt(i) - 'a']++; // minus a because we want to simplify the math in the comparison to zero
			store[t.charAt(i) - 'a']--; // rather than the more un-intuitive default of 96
			p(Arrays.toString(store));
		}
		for(int n : store)
			if(n != 0)
				return false;
		return true;
	}
	/*
	 * Given an array of string strs, group the anagrams together. you can return the answer in any order.
	 * Example 1:
		Input: strs = ["eat","tea","tan","ate","nat","bat"]
		Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	 */
	@SuppressWarnings("serial")
	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
		HashMap<Character, Integer> current = new HashMap<>();

		for(String word : strs) {
			current = wordToFreqMap(word);
			p(current + " " + word);
			if(map.containsKey(current)) {
				p(current + " " + map.get(current));
				ArrayList<String> temp = new ArrayList<>(map.get(current));
				temp.add(word);
				map.put(current, temp);
			} else map.put(current, new ArrayList<>() {{add(word);}});
//			p(map);
		}
		List<List<String>> resultSet = new ArrayList<>();
		for(List<String> group : map.values())
			resultSet.add(group);
		return resultSet;
	}
	private static HashMap<Character, Integer> wordToFreqMap(String word) {
		HashMap<Character, Integer> temp = new HashMap<>();
		for(char letter : word.toCharArray())
			temp.put(letter, temp.getOrDefault(letter, 0) + 1);
		return temp;
	}
	/* This makes use of the fact that when two anagrams are in sorted order, they become the same.
	 * Thus removing the need for the char Frequency map */
	private static List<List<String>> groupAnagramsImproved(String[] words) {
		List<List<String>> resultSet = new ArrayList<>();
		Map<String, ArrayList<String>> freqMap = new HashMap<>();
		if(words.length==0) return resultSet;
		for(String word : words) {
			char[] hash = new char[26];
			for(char letter : word.toCharArray())
				hash[letter - 'a']++;
			for(char c : hash)
				System.out.print((int) c);
			p("");
			String wordKey = new String(hash);
			if(!freqMap.containsKey(wordKey))
				freqMap.put(wordKey, new ArrayList<>());
			
			freqMap.get(wordKey).add(word);
		}
		resultSet.addAll(freqMap.values());
		return resultSet;
	}
	
}




