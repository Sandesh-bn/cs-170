knapsack

https://www.youtube.com/watch?v=8LusJS5-AGo
http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
public int maxValue(int val[], int wt[], int W){
    int m = val.length + 1, n = W + 1;
    int dp[][] = new int[m][n];

    for (int i = 0; i < m; i++){

        for (int j = 0; j < n; j++){

            if (i == 0 || j == 0)
                dp[i][j] = 0;
            
            else if (j >= wt[i - 1])
                dp[i][j] = Math.max(dp[i - 1][j], 
                                    dp[i - 1][j - wt[i - 1]] + val[i - 1]);
            else
                dp[i][j] = dp[i - 1][j];
        }
    }
    return dp[m - 1][n - 1];
}