Input : a[][] = {{2, 3, 3},
                 {2, 3, 3},
                 {2, 2, 2}}
Output : 2
Explanation: A 2x2 matrix is formed from index
A0,1 to A1,2

Input : a[][]  = {{9, 9, 9, 8},
                  {9, 9, 9, 6},
                  {9, 9, 9, 3},
                  {2, 2, 2, 2}
Output : 3
Explanation : A 3x3 matrix is formed from index
A0,0 to A2,2


public int maxSquareWithEqualElements(int[][] A){
    int R = A.length;
    int C = A[0].length;

    int[][] dp = new int[R][C];

    for (int i = 0; i < R; i++){
        for (int j = 0; j < C; j++){

            // first row/ first col there can only be square of size 1
            if (i == 0 || j == 0)
                dp[i][j] = 1;

            // if cell to right, up, left-diagonal-up are equal    
            else if (
                A[i][j] == A[i - 1][j] &&
                A[i][j] == A[i - 1][j - 1] &&
                A[i][j] == A[i][j - 1]
                )
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j - 1], dp[i - 1][j]) + 1;

            }
            else
                dp[i][j] = 1; // since they are not equal
            
            max = Math.max(dp[i][j], max);
        }
        
    }
    return max;
}