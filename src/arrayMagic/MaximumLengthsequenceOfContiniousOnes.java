package arrayMagic;
/**
 *  Given a binary array, find the index of 0 to be replaced with 1 to get a maximum length 
 *  sequence of continuous ones.
	For example, consider array { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 }. 
	The index to be replaced is 7 to get a continuous sequence of length 6 containing all 1’s.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class MaximumLengthsequenceOfContiniousOnes {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(max(new int[] {0, 0, 1, 0, 1, 1, 1, 0, 1, 1}));
	}
	static int max(int[] arr) {
		if(arr == null || arr.length == 0) throw new IllegalArgumentException("Invalid input");
		// find the longest sub array of ones with a max of one zero in it
		// flags are zeroIncluded and index of that position - will later be returned to replace
		int maxCount = 0;
		int localCount = 0;
		int zeroIndexToReplace = -1;
		boolean zeroIncluded = false;
		int left = 0;
		
		for(int right = 0; right < arr.length; right++) {
			if(arr[right] == 0) {
				// first time zero index assig
				if(zeroIndexToReplace == - 1) {
					zeroIndexToReplace = right;
					zeroIncluded = true;
				}
				if(!zeroIncluded) {
					zeroIncluded = true;
					localCount = right - left;
				} else if(zeroIncluded) {
					zeroIncluded = false;
					left = right;
					localCount = 0;
				}
			} else if(arr[right] == 1) {
				// when encountering 1;
				
			}
			maxCount = Math.max(maxCount, localCount);
		}
		
		return 0;
	}
}
