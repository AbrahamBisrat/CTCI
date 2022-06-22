package neetcode;

public class RemoveAdjacentDuplicate {
	public static void main(String[] args) {
		System.out.println(solution("100101010"));
	}
	static int solution(String s) {
		
	    for(int i = 0; i < s.length() - 1; i++) {
	    	char prev = s.charAt(i);
	    	char next = s.charAt(i + 1);
	    	
	    	if(prev == '1' && next == '0' || prev == '0' && next == '1') {
	    		s = s.substring(i - 1, i + 1);
	    		System.out.println(s);
	    		
	    	}
	    }
		
		return s.length();
	}
}