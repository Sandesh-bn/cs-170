// check if tictactoe board has a winner
// board[i][j] = 'X' or 'O'
// board[i][j] = '.' if it is blank
public class TicTacToe{
	public boolean won(char[][] board){
		if (checkDiagonal(board) ||
			checkAntiDiagonal(board))
			return true;
		
		for (int i = 0; i < board.length; i++){
			if (checkRow(i, board) ||
				checkCol(i, board))
				return true;
		}
		return false;
	}
	
	private boolean checkRow(int row, char[][] board){
		if (board[row][0] == '.')
			return false;
		for (int col = 0; col < board[0].length - 1; col++){
			if (board[row][col] != board[row][col + 1])
				return false;
		}
		return true;
		
		
	}
	
	private boolean checkCol(int col, char[][] board){
		if (board[0][col] == '.')
			return false;
		
		for (int row = 0; row < board.length - 1; row++){
			if (board[row][col] != board[row + 1][col])
				return false;
		}
		return true;

	}
	
	private boolean checkDiagonal(char[][] board){
		if (board[0][0] == '.')
			return false;
		char firstCell = board[0][0];
		for (int i = 1; i < board.length; i++)
			if (board[i][i] != firstCell)
				return false;
		return true;
	}
	
	private boolean checkAntiDiagonal(char[][] board){
		int N = board[0].length;
		char firstCell = board[0][N - 1];
		if (firstCell == '.')
			return false;
		for (int i = 1; i < board.length; i++)
			if (board[i][N - 1 - i] != firstCell)
				return false;
		return true;
	}
}