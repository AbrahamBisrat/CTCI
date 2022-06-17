package neetcode.arraysNHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded
 * back to the original list of strings.
 * 
 * 	Example 1
	Input: ["lint","code","love","you"]
	Output: ["lint","code","love","you"]
	Explanation:
	One possible encode method is: "lint:;code:;love:;you"
	
	Example 2
	Input: ["we", "say", ":", "yes"]
	Output: ["we", "say", ":", "yes"]
	Explanation:
	One possible encode method is: "we:;say:;:::;yes"
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class EncodeAndDecodeStrings {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("lint", "code", "love", "you"));
		p(encode(list));
		p(decode(encode(list)));
	}
	/* @param strs: a list of strings
     * @return: encodes a list of strings to a single string. */
    public static String encode(List<String> strs) {
    	String encoded = "\"";
    	for(String each : strs)
    		encoded += each + ":;";
    	return encoded + "\"";
    }

    /* @param str: A string
     * @return: dcodes a single string to a list of strings */
    public static List<String> decode(String str) {
        // "lint:;code:;love:;you:;"
    	List<String> decodedSet = new ArrayList<>();
    	String temp = "";
    	str = str.substring(1);
    	p(str);
    	for(char letter : str.toCharArray()) {
    		if(letter == ':') {
    			decodedSet.add(temp);
    			temp="";
    		} else if(letter != ';'){
    			temp+=letter;    			
    		}
    	}
    	return decodedSet;
    }
}





