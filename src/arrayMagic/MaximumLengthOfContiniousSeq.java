package arrayMagic;
/**
 * Sliding window continious count
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class MaximumLengthOfContiniousSeq {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(maxContCount(new int[] {0, 0, 1, 0, 1, 1, 1, 0, 1, 1 }));
	}
	static int maxContCount(int[] arr) {
		int left = 0;
		int localCount = 0;
		int maxCount = 0;
		for(int right = 0; right < arr.length; right++) {
			if(arr[left] == arr[right]) {
				localCount = right - left + 1;
			} else {
				left = right;
				localCount = 1;
			}
			maxCount = Math.max(maxCount, localCount);
		}
		return maxCount;
	}
}
