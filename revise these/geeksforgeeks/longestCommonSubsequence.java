http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/

https://www.youtube.com/watch?v=NnD96abizww

public int lcs(char[] X, char Y[]){
    int m = X.length, y = Y.length;
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i < dp.length; i ++){
        for (int j = 0; j < dp[0].length; j++){
            if (i == 0 || j == 0)
                dp[i][j] = 0;
            else if (X[i - 1] == Y[j - 1])
                dp[i][j] = dp[i - 1][j - 1] + 1;
            else
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
    }
    return dp[dp.length - 1][dp[0].length - 1];
}