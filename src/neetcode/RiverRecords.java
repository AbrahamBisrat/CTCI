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
        int maxDiff = levels.get(1) - levels.get(0);
        int minElement = levels.get(0);

        for (int i = 1; i < levels.size(); i++) {
            int current = levels.get(i);
            maxDiff = Math.max(maxDiff, current - minElement);
            
            if(current < minElement) minElement = current;
        }
        return maxDiff <= 0 ? -1 : maxDiff;
	}
}
