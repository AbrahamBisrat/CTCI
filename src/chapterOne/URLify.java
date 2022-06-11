package chapterOne;

/**
 * replace all spaces in a string with %20.
 * Example: 'hey there' -> 'hey%20there'
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class URLify {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(urlify("hey there"));
		p(urlify("Mr John Smith   "));
		
		p(urlify("hey there   ", 9));
		p(urlify("Mr John Smith   ", 13));
		
		p(urlifyBook("hey there   ", 9));
		p(urlifyBook("Mr John Smith    ", 13));		
	}
	private static String urlify(String string) {
		String url = "";
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i)==' ')
				url += "%20";
			else url += string.charAt(i);
		}
		return url;
	}
	private static String urlify(String string, int size) {
		char[] input = string.substring(0, size).toCharArray();
		String temp = "";
		for(char each : input) {
			if(each == ' ')
				temp+="%20";
			else temp+=each;
		}
		return temp;
	}
	// Solution from the book
	private static String urlifyBook(String str, int trueLength) {
		char[] string = str.toCharArray();
		int numberOfSpaces = countOfChar(string, 0, trueLength, ' ');
		int newIndex = trueLength - 1 + numberOfSpaces * 2; // the new size of the char array that will replace current string
		/* If there are excess spaces, add a null character. This indicates that the 
		 * spaces after that point have not been replaced with %20; */
		if(newIndex + 1 < string.length) string[newIndex + 1] = '\0';
		for(int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex -= 1) {
			if(string[oldIndex] == ' ') {	/* Insert %20 */
				string[newIndex]='0';
				string[newIndex-1]='2';
				string[newIndex-2]='%';
				newIndex-=3;/* Replace the spaces from the back */
			} else {
				string[newIndex] = string[oldIndex];
				newIndex--;
			}
		}
		return new String(string);
	}
	/** Count occurrences of target between start(inclusive) and end(exclusive)
	 * @param str 
	 * @param start
	 * @param end
	 * @param target -> could be any char value: for space ' ' will compute to its representation
	 * @return count of the desired output */
	private static int countOfChar(char[] str, int start, int end, int target) {
		int count = 0;
		for(int i = start; i < end; i++)
			if(str[i] == target)
				count++;
		return count;
	}
}
