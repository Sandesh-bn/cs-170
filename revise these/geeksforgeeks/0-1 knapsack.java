

public int knapsack(int val[], int wt[], int X){
    
    int R = val.length + 1;
    int C = X + 1;

    for (int i = 0; i < R; i++){
        for (int j = 0; j < C; j++){

            if (i == 0 || j == 0)
                dp[i][j] = 0;
            else if (j >= wt[i - 1])
                dp[i][j] = Math.max(dp[i - 1][j], 
                                    dp[i- 1][j - wt[i - 1]] + val[i - 1]);
            else
                dp[i][j] = dp[i - 1][j];
        }
    }

    return dp[R - 1][C - 1];
}