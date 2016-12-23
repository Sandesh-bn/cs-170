public class Solution {
    public boolean isValidSudoku(char[][] board) {
       
        
        Set<Character> rows[] = new HashSet[9];
        Set<Character> cols[] = new HashSet[9];
        Set<Character> subMatrix[] = new HashSet[9];
        
        for (int i = 0; i < 9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            subMatrix[i] = new HashSet<>();
        }
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                char cell = board[i][j];
                if (cell != '.'){
                    if (!rows[i].add(cell)) return false;
                    if (!cols[j].add(cell)) return false;
                    if (!subMatrix[(i/3) * 3 + (j/3)].add(cell)) return false;
                }
            }
        }
        return true;
        
       
    }
}

// how is the subMatrix accessed?