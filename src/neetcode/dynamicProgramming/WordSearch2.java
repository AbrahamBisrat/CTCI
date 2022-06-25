package neetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'}};
		String[] words = {"oath", "pea", "etae", "rain"};
//		p(findWords(board, words));
		char[][] board2 = {{'a', 'b'}};
		String[] word = {"ba"};
		p(findWords(board2, word));
	}
	static List<String> findWords(char[][] board, String[] words) {
		List<String> foundWords = new ArrayList<>();
		for(String word : words)
			if(search(board, word))
				foundWords.add(word);
		return foundWords;
	}
	static boolean search(char[][] board, String word) {
		if(board.length == 1) {
			for(int i = 0; i < board[0].length; i++) {
				if(board[0][i] == word.charAt(0) && dfs(board, word, 0, i, 0))
					return true;
			}
		}
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(word.charAt(0) == board[i][j] && dfs(board, word, i, j, 0))
					return true;
			}
		}
		return false;
	}
	static boolean dfs(char[][] board, String word, int i, int j, int count) {
		if(count == word.length()) return true;
		
		// check overflows and equality
		if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || word.charAt(count) != board[i][j])
			return false;
		
		char temp = board[i][j];
		board[i][j] = ' ';
		// search left
		boolean left = dfs(board, word, i - 1, j, count + 1);
		// search right
		boolean right = dfs(board, word, i + 1, j, count + 1);
		// search top
		boolean top = board.length > 0 ? dfs(board, word, i, j + 1, count + 1) : false;
		// search bottom
		boolean bottom = board.length > 0 ? dfs(board, word, i, j - 1, count + 1) : false;
		
		board[i][j] = temp;
		if(left || right || top || bottom) return true;
		return false;
	}
}
