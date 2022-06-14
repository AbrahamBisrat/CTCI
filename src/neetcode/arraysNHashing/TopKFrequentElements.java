package neetcode.arraysNHashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array numbers and an integer k, return the k most frequent elements.
 * You may return the answer in any order
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class TopKFrequentElements {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(topKFrequent(new int[] {1, 1, 1, 2, 2, 3, 3, 3, 3}, 2));
	}
	/* make a frequency map
	 * go through the sizes and append them to minHeap,
	 * if the size of the heap is greater than k, remove */
	private static List<Integer> topKFrequent(int[] numbers, int k) {
		if(k >= numbers.length) return new ArrayList<>();
		Map<Integer, Integer> freqMap = new HashMap<>();
		
		for(int number : numbers)
			freqMap.put(number, freqMap.getOrDefault(number, 0) + 1);
		
		/* go through all numbers of map and push them in a minHeap which will have a top k elements 
		 * If at any time it has > k elements, then remove the smallest element. */
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			minHeap.add(entry);
			if(minHeap.size() > k)
				minHeap.poll();
			p(minHeap);
		}
		// Create a list of k elements
		List<Integer> topKResults = new ArrayList<>();
		while(!minHeap.isEmpty())
			topKResults.add(minHeap.poll().getKey());
		return topKResults;
	}
}
