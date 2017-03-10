

public int LCS(String s1, String s2){
    int R = s1.length() + 1;
    int C = s2.length() + 1;
    int[][] dp = new int[R][C];

    for (int i = 1; i < R; i++){
        for (int j = 1; j < C; j++){
            if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                dp[i][j] = dp[i - 1][j - 1] + 1;
            }
            else
                dp[i][j] = Math.max(dp[i][j- 1], dp[i - 1][j]);
        }
    }
    return dp[R - 1][C - 1];
}