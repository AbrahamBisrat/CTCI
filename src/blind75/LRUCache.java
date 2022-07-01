package blind75;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

	Implement the LRUCache class:
	
	LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
	int get(int key) Return the value of the key if the key exists, otherwise return -1.
	void put(int key, int value) Update the value of the key if the key exists. 
	Otherwise, add the key-value pair to the cache. If the number of keys exceeds 
	the capacity from this operation, evict the least recently used key.
	The functions get and put must each run in O(1) average time complexity.
	
	Example 1:
	Input
	["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
	[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
	Output
	[null, null, null, 1, null, -1, null, -1, 3, 4]
	
	Explanation
	LRUCache lRUCache = new LRUCache(2);
	lRUCache.put(1, 1); // cache is {1=1}
	lRUCache.put(2, 2); // cache is {1=1, 2=2}
	lRUCache.get(1);    // return 1
	lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
	lRUCache.get(2);    // returns -1 (not found)
	lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
	lRUCache.get(1);    // return -1 (not found)
	lRUCache.get(3);    // return 3
	lRUCache.get(4);    // return 4
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class LRUCache {
	private Deque<Integer> doublyQueue;
	private HashMap<Integer, Integer> valueStore;
	private final int cacheSize;
	
	public LRUCache(int capacity) {
		cacheSize = capacity;
		doublyQueue = new LinkedList<>();
		valueStore = new HashMap<>();
	}
	public int get(int key) {
		if(valueStore.get(key) != null) {
			int element = valueStore.get(key);
			doublyQueue.remove(element);
			doublyQueue.addFirst(element);
			return element;
		} else return -1;
	}
	public void put(int key, int value) {
		if(doublyQueue.size() < cacheSize) {
			valueStore.put(key, value);
			doublyQueue.addFirst(key);
		} else {	// full
			int lastKey = doublyQueue.removeLast();
			valueStore.remove(lastKey);
			put(key, value);
		}
	}
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		p(lRUCache.get(1));    // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		p(lRUCache.get(2));    // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		p(lRUCache.get(1));    // return -1 (not found)
		p(lRUCache.get(3));    // return 3
		p(lRUCache.get(4));    // return 4
	}
}
