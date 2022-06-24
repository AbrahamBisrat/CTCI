package neetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * Given a grid find a string in any direction
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class WordSearch {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(wordSearch(new char[][] { {'A','B','C','E'},
									{'S','F','C','S'},
									{'A','D','E','E'}}, "ABCCED"));
		p(wordSearch(new char[][] { {'A','B','C','E'},
									{'S','F','C','S'},
									{'A','D','E','E'}}, "ABCB"));
		p(wordSearch(new char[][] { {'A','B','C','E'},
									{'S','F','C','S'},
									{'A','D','E','E'}}, "SEE"));
		
	}
	static boolean wordSearch(char[][] grid, String target) {
		int col = grid.length;
		int row = grid[0].length;
		for(int i = 0; i < col; i++)
			for(int j = 0; j < row; j++)
				if(grid[i][j] == target.charAt(0) && searchWord(grid, i, j, 0, target))
					return true;
		return false;
	}
	static boolean searchWord(char[][] grid, int i, int j, int index, String target) {
		if(index == target.length()) return true;
		
		// termination cases;
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length 
				|| grid[i][j] != target.charAt(index)) {
			return false;
		}
		int temp = grid[i][j];
		grid[i][j] = ' ';
		// go to all cardinal directions, return true if found
		boolean found = searchWord(grid, i+1, j, index+1, target) || // left
					    searchWord(grid, i-1, j, index+1, target) || // right
					    searchWord(grid, i, j+1, index+1, target) || // up
					    searchWord(grid, i, j-1, index+1, target); //down
		// set it to not visited
		grid[i][j] = (char)temp;
		return found;
	}
}
