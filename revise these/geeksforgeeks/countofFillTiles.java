http://www.geeksforgeeks.org/count-number-of-ways-to-fill-a-n-x-4-grid-using-1-x-4-tiles/

public int count(int N){
    int[] dp = new int[N + 1];
    dp[0] = 0;

    for (int i = 1; i <= N; i++){
        // Base case
        if (i >= 1 && i <= 3)
            dp[i] = 1;
        else if (i == 4)
            dp[i] = 2;

        //Place the first tile horizontally : If we place first tile horizontally, the problem reduces to “count(n-1)”
        //Place the first tile vertically : If we place first tile vertically, then we must place 3 more tiles vertically. So the problem reduces to “count(n-4)”
        else
            dp[i] = dp[i - 1] + dp[i - 4];
    }

    return dp[N];
}