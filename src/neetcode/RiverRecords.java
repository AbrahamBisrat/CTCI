package neetcode;

import java.util.Arrays;
import java.util.List;

public class RiverRecords {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
//		p(riverRecords(Arrays.asList(5, 3, 6, 7, 4)));
		p(riverRecords(Arrays.asList(7, 2, 3, 10, 2, 4, 8, 1)));
	}
	static int riverRecords(List<Integer> levels) {
		if(levels == null || levels.size() < 1) return -1;
        int[] arr = new int[levels.size()];
        for(int i = 0; i < arr.length; i++) arr[i] = levels.get(i);
        int maxDiff = arr[1] - arr[0];
        int minElement = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            maxDiff = Math.max(maxDiff, current - minElement);
            
            if(current < minElement) minElement = current;
        }
        return maxDiff <= 0 ? -1 : maxDiff;
	}
}
