package neetcode.arraysNHashing;

import java.util.ArrayList;
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
		if(numbers.length==0) return new ArrayList<>();
		Map<Integer, Integer> freqMap = new HashMap<>();
		
		for(int number : numbers)
			freqMap.put(number, freqMap.getOrDefault(number, 0) + 1);
		p(freqMap);
		
		/* Here I am going to use a bit of magic.
		 * PriorityQueue but rather sorting it via the key */
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
				new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			minHeap.add(entry);
			if(minHeap.size() > k)
				minHeap.remove();
		}
		p(minHeap);
		List<Integer> resultSet = new ArrayList<>();
		while(!minHeap.isEmpty())
			resultSet.add(minHeap.poll().getKey());
		return resultSet;
	}
	private static List<Integer> topKFrequentCondensed(int[] numbers, int k) {
		if(numbers.length==0) return new ArrayList<>();
		Map<Integer, Integer> freqMap = new HashMap<>();
		for(int number : numbers) freqMap.put(number, freqMap.getOrDefault(number, 0) + 1);
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			minHeap.add(entry);
			if(minHeap.size() > k) minHeap.remove();
		}
		List<Integer> resultSet = new ArrayList<>();
		while(!minHeap.isEmpty()) resultSet.add(minHeap.poll().getKey());
		return resultSet;
	}
}
