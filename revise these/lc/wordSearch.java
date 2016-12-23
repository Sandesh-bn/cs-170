Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

public class Solution {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word){
        int row = board.length, col = board[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if ((word.charAt(0) == board[i][j]) && dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index){
        if (index == word.length())
            return true;
        if (i >= board.length || i < 0 ||
            j >= board[0].length || j < 0 ||
            visited[i][j]||
            board[i][j] != word.charAt(index))
            return false;
        visited[i][j] = true;
        
        if (dfs(board, word, i - 1, j, index + 1) ||
            dfs(board, word, i + 1, j, index + 1) ||
            dfs(board, word, i, j - 1, index + 1) ||
            dfs(board, word, i, j + 1, index + 1))
            return true;
        visited[i][j] = false;
        return false;
    }
    
    
}