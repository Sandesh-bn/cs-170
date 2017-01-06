Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.

watch ideserve vvideo


public int maxArea(char[][] board){
    if (board == null || board.length == 0)
        return 0;
    int maxArea = 0, m = board.length, n = board[0].length;

    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){
            int cell = matrix[i][j] - '0';

            if (i == 0 || j == 0)
                dp[i][j] = cell;
            else if (cell == 0)
                dp[i][j] = 0;
            
            else   
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);

            maxArea = Math.max(maxArea, dp[i][j]);
        }
    }

    return maxArea ^ 2;
}