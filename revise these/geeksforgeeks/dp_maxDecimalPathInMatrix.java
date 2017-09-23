Given binary square matrix [n*n]. Find maximum integer value in a path from top left to bottom right. We compute integer value using bits of traversed path. We start at index [0,0] and end at index [n-1][n-1]. from index [i, j], we can move [i, j+1] or [i+1, j].

Examples:

Input : mat[][] = {{1, 1, 0, 1},
                   {0, 1, 1, 0},
                   {1, 0, 0, 1},
                   {1, 0, 1, 1}}
Output : 111
Explanation : 
Path :   (0,0) -> (0,1) -> (1,1) -> (1,2) ->
         (2,2) -> (3,2) ->(4,4)  
Decimal value : 1*(2^0) + 1*(2^1) + 1*(2^2) + 1*(2^3) + 
                0*(2^4) + 1*(2^5) + 1*(2^6) = 111


public int maxPath(int[] A){

    int R = A.length, C = A[0].length;
    int[][] dp = new int[R][C];


    // fill first row

    for (int j = 1; j < C; j++){
        if (A[0][j] == 1)
            dp[0][j] = dp[0][j - 1] + Math.pow(2, j);
        else
            dp[0][j] = dp[0][j - 1];
    }

    // fill first col
    for (int i = 1; i < R; i++){
        if (A[i][0] == 1)
            dp[i][0] = dp[i - 1][0] + Math.pow(2, i);
        else
            dp[i][0] = dp[i - 1][0];
    }

    // fill interior cells
    for (int i = 1; i < R; i++){

        for (int j = 1; j < C; j++){

            if (A[i][j] == 1)
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + Math.pow(2, i + j);
            else
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
    }

    return dp[R - 1][C - 1];

}