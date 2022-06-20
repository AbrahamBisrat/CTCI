package neetcode;
/**
 * Challenge: Write the most elegant fib solution ever. Why? because it is cool....
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class Fibonnacci {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(fib(10));
		p(fib(2));
		p(fib(14));
		p(fib(4));
	}
	public static int fib(int x) { return x <= 1? 1 : fib(x - 1) + fib(x - 2); }
}
