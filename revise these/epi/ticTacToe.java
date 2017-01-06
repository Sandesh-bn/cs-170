// http://buttercola.blogspot.com/2016/06/leetcode-348-design-tic-tac-toe.html
public class Solution{
	int[] rows;
	int[] cols;
	int diagonal, antiDiagonals, target;
	public TicTacToe(int num){
		rows = new int[num];
		cols = new int[cols];
		diagonal = 0;
		antiDiagonals = 0;
		target = num;
	}
	
	// if player is '0' it is 1 if player is 'X' it is -1
	// result is 3 for '0' player and -3 for 'X' player
	// we use 1 dimensional array to keep track of rows and 1 dimensional for columns
	// since there is only one diagonal one variable is enough for diangoanl.
	// this arrangement avoids n*n space
	// if any of the rows/cols/diagonal has value of 3 after '0' plays, '0' wins
	public int move(int row, int col, int player){
		int sign = (player == 1)?1: -1;
		int res = sign * target;
		
		rows[row] += sign;
		cols[col] += sign;
		
		if (row == col)
			diagonal += sign;
		
		if (row == target - 1 - col)
			antiDiagonals += sign;
		
		// one of them won
		if (rows[row] == res ||
			cols[col] == res ||
			diagonal == res ||
			antiDiagonals == res)
			return player;
		
		else 
			return 0; //
	}
}