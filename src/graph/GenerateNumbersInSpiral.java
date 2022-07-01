package graph;

import java.util.Arrays;
import java.util.HashSet;

public class GenerateNumbersInSpiral {
	static void p(Object line) { System.out.println(line); }
	static void pA(int[][] arr) { for(int[] row : arr) p(Arrays.toString(row)); }
	public static void main(String[] args) {
//		pA(generateSpiral(3));
//		pA(generateSpiral(4));
		pA(generateSpiral(5));
	}
	public static  int[][] generateSpiral(int n) {
        int[][] result = new int[n][n];
        if(n <= 0) return result;
        
        genSpiral(result, 0, 0, 1, new boolean[n][n]);
        return result;
    }
    static void genSpiral(int[][] grid, int x, int y, int currentVal, boolean[][] seen) {
        if(x < 0 || x >= grid[y].length || y < 0 || y >= grid.length || seen[y][x])
            return;
        
        seen[y][x] = true;
        grid[y][x] = currentVal;
        
        if(x + 1 < grid[y].length && (y == 0 || seen[y - 1][x])) // if top key has been seen before
        	genSpiral(grid, x + 1, y, currentVal + 1, seen);
        if(y + 1 < grid.length)
            genSpiral(grid, x, y + 1, currentVal + 1, seen);
        if(x - 1 >= 0)
            genSpiral(grid, x - 1, y, currentVal + 1, seen);
        if(y - 1 >= 0)
            genSpiral(grid, x, y - 1, currentVal + 1, seen);
    }
}
