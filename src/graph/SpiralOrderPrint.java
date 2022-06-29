package graph;

import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.

	Example 1:
	Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
	Output: [1,2,3,6,9,8,7,4,5]
	
	Example 2:
	Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
	Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class SpiralOrderPrint {
	public static void main(String[] args) {
		
	}
	static void dfsPrint(int[][] grid, int x, int y, List<Integer> list) {
        int seen = -111;
        if(x < 0 || x >= grid[y].length || y < 0 || y >= grid.length || grid[y][x] == seen)
        		return;
        
        int temp = grid[y][x];
        list.add(temp);
        grid[y][x] = seen;
        
        // top has been visited or there is not top
        if(x < grid[y].length && (y == 0 || grid[y - 1][x] == seen))
        		dfsPrint(grid, x + 1, y, list);
        if(y < grid.length)
        		dfsPrint(grid, x, y + 1, list);
        if(x >= 0)
        		dfsPrint(grid, x - 1, y, list);
        if(y >= 0)
        		dfsPrint(grid, x, y - 1, list);
    }
}
