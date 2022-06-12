package chapterOne;

import java.util.Arrays;

/**
 * Rotate matrix: 
 * Given an image represented by an N x N matrix, where each pixel in the image is represented
 * by an integer, write a method to rotate the image by 90 degrees;
 * 
 * Can you do this in place? aka - no extra memory - aka - swap?
 * 
 * solution: 
 * Example:  so the rotation by 90 degrees would mean swapping of the i and j terms
 * 			but this would convert axb matrix to bxa:
 * 
 * Therefore in-place swapping would only work for matrix size of nxn 
 * In other words the length and height should be same to do the rotation in place.		
 * 	++++++
 *  |1010|
 *  |1010|
 *  |1010|
 * 	++++++
 * 
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class RotateMatrix {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		int[][] grid = new int[3][3];
		int count=1;
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				grid[i][j]=count++;
		for(int[] column : grid)
			p(Arrays.toString(column));
		p("\n\n");
		
		for(int[] column : rotate90(grid))
			p(Arrays.toString(column));
	}
	private static int[][] rotate90(int[][] matrix){
		for(int i=0; i< matrix.length; i++)
			for(int j = 0; j < matrix[1].length; j++)
				swap(matrix, i, j);
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
				matrix[i][matrix[0].length - 1 - j] = temp;
			}
		}
		return matrix;
	}
	private static void swap(int[][] matrix, int i, int j) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[j][i];
		matrix[j][i] = temp;
	}
}
