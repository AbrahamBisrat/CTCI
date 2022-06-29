package graph;

import java.util.Arrays;
import java.util.HashSet;

public class GenerateNumbersInSpiral {
	static void p(Object line) { System.out.println(line); }
	static void pA(int[][] arr) { for(int[] row : arr) p(Arrays.toString(row)); }
	public static void main(String[] args) {
		pA(generateSpiral(3));
	}
	public static  int[][] generateSpiral(int n) {
        int[][] result = new int[n][n];
        if(n <= 0) return result;
        
        genSpiral(result, 0, 0, 1, new HashSet<>());
        return result;
    }
    static void genSpiral(int[][] grid, int x, int y, int currentVal, HashSet<String> seen) {
        String key = x + ":" + y + ":" + currentVal;
        if(x < 0 || x >= grid[y].length || y < 0 || y >= grid.length || seen.contains(key))
            return;
        p(key);
        pA(grid);
        grid[y][x] = currentVal;
        
        if(x < grid[y].length && (y == 0 || !seen.contains(key)))
            genSpiral(grid, x + 1, y, currentVal + 1, seen);
        if(y < grid.length)
            genSpiral(grid, x, y + 1, currentVal + 1, seen);
        if(x >= 0)
            genSpiral(grid, x - 1, y, currentVal + 1, seen);
        if(y >= 0)
            genSpiral(grid, x, y - 1, currentVal + 1, seen);
        
        seen.add(key);
    }
}
