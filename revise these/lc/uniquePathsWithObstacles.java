public int uniquepath(int ob[][]){
	if (ob == null || ob.length == 0 ||
	ob[0][0] ==1 )return 0;
	int m = ob.length, n = ob[0].length;
	int dp[][] = new int[m][n];
	for (int i = 0; i < m; i++){
		for (int j = 0; j < n; j++){
			if (ob[i][j] == 1)dp[i][j] = 0;
			else if (i == 0 && j == 0)dp[i][j] = 1;
			else if (i == 0)
				dp[i][j] = dp[i][j - 1];
			else if (j == 0)
				dp[i][j] = dp[i - 1][j];
			else
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
		}
	}
	return dp[m - 1][n - 1];
}