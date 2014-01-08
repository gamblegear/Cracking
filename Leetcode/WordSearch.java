/*
The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        //boolean[][] visited = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[row][col];
                    visited[i][j] = true;
                    if(search(board, visited, word.substring(1), i, j))
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean search(char[][] board, boolean[][] visited,
                            String word, int row, int col) {
        if(word.length() == 0)
            return true;
        
        char first = word.charAt(0);
        for(int p = -1; p < 2; p++) {
            for(int q = -1; q < 2; q++) {
                if(row + p >= 0 && row + p <= board.length
                    && col + q >= 0 && col + q <= board[0].length
                    && (Math.abs(p))*(Math.abs(q)) != 0
                    && (Math.abs(p))+(Math.abs(q)) <= 1)
                    if(board[row+p][col+q] == first
                        && visited[row+p][col+q] == false)
                        visited[row+p][col+q] = true;
                        if(search(board, visited, word.substring(1), row+p, col+q))
                            return true;
                        visited[row+p][col+q] = false;
            }
        }
        return false;
    }
}