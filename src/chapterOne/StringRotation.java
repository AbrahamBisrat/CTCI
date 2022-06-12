package chapterOne;
/**
 * Given two strings s1 and s2. check if s1 is a rotation of the s2
 * example: waterbottle -> erbottlewat = true;
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class StringRotation {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(isSubstring("waterbottle", "erbottlewat"));
		p(isSubstring("abcde", "eabcd"));
		p(isSubstring("adsf", "sd"));p("");
		p(isSubstring("abc", "cab"));
	}
	private static boolean isSubstring(String x, String y) {
		for(int i = 0; i < x.length(); i++)
			if(rotateString(x, i).equals(y))
				return true;
		return false;
	}
	private static String rotateString(String string, int pos) {
		String firstPart = string.substring(0, pos);
		String secondPart = string.substring(pos, string.length());
		return secondPart.concat(firstPart);
	}
}
