Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down\) that is from a given cell, the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. Find out maximum amount of gold he can collect.

Examples:

Input : mat[][] = {{1, 3, 3},
                   {2, 1, 4},
                  {0, 6, 4}};
Output : 12 
{(1,0)->(2,1)->(2,2)}

Input: mat[][] = { {1, 3, 1, 5},
                   {2, 2, 4, 1},
                   {5, 0, 2, 3},
                   {0, 6, 1, 2}};
Output : 16
(2,0) -> (1,1) -> (1,2) -> (0,3) OR
(2,0) -> (3,1) -> (2,2) -> (2,3)

Input : mat[][] = {{10, 33, 13, 15},
                  {22, 21, 04, 1},
                  {5, 0, 2, 3},
                  {0, 6, 14, 2}};
Output : 83

public int maxGold(int[][] gold){
    int r = gold.length, c = gold[0].length;

    int dp[][] = new int[r][c];

    for (int col = c - 1; col >= 0; col++){
        for (int row = 0; row < m; row++){

            int rightUp = (row == 0 || col == c - 1)?0: dp[row - 1][col + 1];

            int right = (col == c - 1)? 0: dp[row][col + 1];

            int rightDown = (row == r - 1 || col == c - 1)? 0: dp[row + 1][col + 1];

            dp[row][col] = Math.max(rightUp, right, rightDown);
        }
    }

    int res = 0;
    for (int i = 0; i < r; i++)
        res = Math.max(res, dp[i][0]);

    return res;
}