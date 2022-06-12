package chapterOne;

import java.util.Arrays;

/**
 * Write an algorithm such that if an element in an M x N matrix is 0, 
 * its entire row and column are set to 0
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class ZeroMatrix {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		int[][] grid = new int[3][3];
		int counter=0;
		for(int i = 0; i < grid.length; i++)
			for(int j = 0; j < grid[i].length; j++)
				grid[i][j]=counter++;
		for(int[] column : grid)
			p(Arrays.toString(column));
		grid = zeroMatrix(grid); p("");
		for(int[] column : grid)
			p(Arrays.toString(column));
	}
	public static int[][] zeroMatrix(int[][] grid) {
		for(int i = 0; i < grid.length; i++)
			for(int j = 0; j < grid[i].length; j++)
				if(grid[i][j]==0)
					grid = nullifyCardinalElements(grid, i, j);
		return grid;
	}
	private static boolean onceFlag = true;
	public static int[][] nullifyCardinalElements(int[][] grid, int i, int j) {
		if(onceFlag) {
			int[][] temp = grid;
			for(int x = 0; x < grid[i].length; x++)
				grid[x][j]*=0;
			for(int y = 0; y < grid[j].length; y++)
				temp[i][y]*=0;
			onceFlag=!onceFlag;
		}
		return grid;
	}
}
