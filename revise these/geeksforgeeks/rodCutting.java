

public int maxProfit(int[] v, int w[], int X){

    int C = X + 1;
    int R = v.length + 1;
    int[][] dp = new int[R][C];

    for (int i = 1; i < R; i++){
        for (int j = 1; j < C; j++){
            if (j >= i)
                dp[i][j]  = Math.max(dp[i - 1][j], v[i] + dp[i][j - i])
            else
                dp[i][j] = dp[i - 1][j];
        }
    } 
    return dp[R - 1][C - 1];
}