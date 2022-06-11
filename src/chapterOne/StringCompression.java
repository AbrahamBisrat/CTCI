package chapterOne;
/**
 * String Compression : Implement a method to perform basic string compression using
 * the counts of repeated characters;
 * 
 * Example: aabccccaaa would become a2b1c5a3
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class StringCompression {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(compress("aabccccccaaa"));
		p(compress("abcdddefgg"));
	}
	private static String compress(String input) {
		if(input.length() == 0) throw new IllegalArgumentException("Invalid input");
		// loop and compare if the previous value and the current value match if so count++;
		// otherwise write whatever value has been accumulated and slide the window to current.
		String output = "";
		char prev = input.charAt(0);
		char current = ' ';
		int count = 1;
		
		for(int i = 1; i < input.length(); i++) {
			current = input.charAt(i);
			if(prev != current) {
				output += prev + "" + count;
				count=1;// reset;
				prev=current;// catch up
			} else count++;
		}
		output+=current+""+count; // the final remaining value in the list
		return output;
	}
}
