package neetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Challenge: Write the most elegant fib solution ever. Why? because it is cool....
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class Fibonnacci {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		util.Analyzer.benchmark(placeholder -> fib(30));
		util.Analyzer.benchmark(placeholder -> fibFaster(30));
	}
	public static int fib(int x) { return x <= 1 ? 1 : fib(x - 1) + fib(x - 2); }
	/* A faster approach with Dynamic programming */
	public static int fibFaster(int n) {
		if(n==0) return 0;
		else if(n==1) return 1;
		if(cache.containsKey(n)) return cache.get(n);
		int temp = fib(n-1) + fib(n-2);
		return temp;
	}
	private static Map<Integer, Integer> cache = new HashMap<>();
}
