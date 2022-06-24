package neetcode.dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

/**
 * Sodoku solver
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class SodokuSolver {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
//		p(new int[][] {{123});
	}
	static boolean sodoku(int[][] grid) {
		for(int i = 0; i < grid.length; i++) 
			for(int j = 0; j < grid[0].length; j+=3)
				if(!checkThreeByThree(grid, j, i))
					return false;

		if(!checkSet(grid)) return false;
		for(int i = 0; i < grid.length; i++)
			if(!checkColumn(grid, i))
				return false;
		return true; 
	}
	static boolean checkColumn(int[][] grid, int c) {
		int target = grid[0][c] + grid[1][c] + grid[2][c]
					+ grid[3][c] + grid[4][c] + grid[5][c]
					+ grid[6][c] + grid[7][c] + grid[8][c];
		return target == 45;
	}
	static boolean checkThreeByThree(int[][] grid, int x, int y) {
		int target = grid[x][y] + grid[x+1][y] + grid[x+2][y] 
				+ grid[x][y+1] + grid[x+1][y+1] + grid[x+2][y+1]
				+ grid[x][y+2] + grid[x+1][y+2] + grid[x+2][y+2];
		return target == 45;
	}
	static boolean checkSet(int[][] grid) {
		for(int i = 0; i < 9; i++) {
			Set<Integer> xSet = new HashSet<>();
			Set<Integer> ySet = new HashSet<>();
			for(int j = 0; j < 9; j++) {
				xSet.add(grid[i][j]);
				ySet.add(grid[i][j]);
			}
			if(xSet.size() != 9 || ySet.size() != 9)
				return false;
		}
		return true;
	}
}
