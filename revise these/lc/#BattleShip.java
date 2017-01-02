// increment count only if cell is the first cell of battlship
// cell is the first cell of battlship iff
// there are no x above it and there are no x to the left of it.

public int countBattleShip(char[][] board){
    if (board.length == 0 || board[0].length == 0)
        return 0;
    int count = 0;
    for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board[0].length; j++){
            if (board[i][j] == '.')continue;
            if (i > 0 && board[i - 1][j] == 'X')continue;
            if (j > 0 && board[i][j - 1] == 'X')continue;
            count++;
        }
    }
}