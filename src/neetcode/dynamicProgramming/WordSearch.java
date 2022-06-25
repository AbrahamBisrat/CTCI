package neetcode.dynamicProgramming;

/**
 * Given a grid find a string in any direction
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class WordSearch {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},
						  {'S','F','C','S'},
						  {'A','D','E','E'}};
		p(wordSearch(board, "ABCCED"));
		p(wordSearch(board, "ABCB"));
		p(wordSearch(board, "SEE"));
		
	}
	static boolean wordSearch(char[][] grid, String target) {
		for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(target.charAt(0) == grid[i][j] && wordSearch(grid, target, i, j, 0))
                    return true;
            }
        }
        return false;
	}
	static boolean wordSearch(char[][] board, String word, int i, int j, int count) {
        if(word.length() == count) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count))
            return false;
        char temp = board[i][j];
        board[i][j] = ' ';
        
        // search to left
        boolean left = wordSearch(board, word, i - 1, j, count+1);
        // search to the right
        boolean right = wordSearch(board, word, i + 1, j, count+1);
        // search top
        boolean top = wordSearch(board, word, i, j + 1, count+1);
        // search bottom
        boolean bottom = wordSearch(board, word, i, j - 1, count+1);
        
        board[i][j] = temp;
        if(left || right || top || bottom) return true;
        return false;
    }
}
