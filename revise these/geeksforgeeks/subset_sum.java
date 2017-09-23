


// refer to tushar video



public boolean subsetSum(int[] input, int X){
    int C = X + 1;
    int R = input.length;

    boolean dp[][] = new boolean[R][C];

    for (int i = 0; i < R; i++){

        for (int j = 0; j < C; j++){

            if (j == 0)
                dp[i][j] = true;

            else if (input[i] < j)
                dp[i][j] = dp[i - 1][j];
            else if (input[i] == j)
                dp[i][j] = true;
            else
                dp[i][j] = dp[i - 1][j - input[i]];
        }
    }
}