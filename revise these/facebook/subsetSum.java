https://www.youtube.com/watch?v=s6FhG--P7z0
https://www.youtube.com/watch?v=5td2QH-x5ck

public boolean subsetSum(int input[], int total){
    boolean dp[][] = new boolean[input.length][total + 1];
    for (int i = 0; i <= input.length; i++){
        dp[i][0] = true;
    }

    for (int i = 1; i < dp.length; i++){
        for (int j = 1; j < dp[0].length; j++){

            if (input[i - 1] > j)
                dp[i][j] = dp[i - 1][j];
            else
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - input[i - 1]];
        }
    }
    return dp[dp.length - 1][dp[0].length];
}


time complexity is O(sum * n)

http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/