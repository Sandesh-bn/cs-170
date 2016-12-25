
// i am performing dfs and i pass the longestpath so far obtained in the current cell to the next cell and also the current cell's value.
// so in the next cell(in next recursive call) if the value in this cell is less than/equal to prev cell value then we know this is end of 
increasing path, we return 0, otherwise we add 1 to current path and send the current value to next recursive call

public int longestIncreasingPath(int[][] matrix){
	
}