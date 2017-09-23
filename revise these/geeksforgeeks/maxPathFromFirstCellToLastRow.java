
Input : N = 5
        mat[5][5] = {{ 4, 2 ,3 ,4 ,1 },
                     { 2 , 9 ,1 ,10 ,5 },
                     {15, 1 ,3 , 0 ,20 },
                     {16 ,92, 41, 44 ,1},
                     {8, 142, 6, 4, 8} };
Output : 255
Path with max weight : 4 + 2 +15 + 92 + 142 = 255   

start from 0,0 and reach any cell in bottom row. what is the 
max path sum?

public int maxPath(int[][] M){
    int N = M.length;
    int[][] dp = new int[N][N];

    dp[0][0] = M[0][0];

    for (int i = 1; i < N; i++)
        dp[i][0] = M[i][0] + dp[i - 1][0];

    for (int i = 1; i < N; i++){
        for (int j = 1;  j < N; j++){
            dp[i][j] = M[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            
        }
    }

    // get max value from last row
    for (int j = 0; j < N; j++)
        res = Math.max(res, dp[N - 1][i]);
    
    return max;
}