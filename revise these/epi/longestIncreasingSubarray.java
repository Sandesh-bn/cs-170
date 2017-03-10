public int longest(int[]  A){
    int[] dp =new int[A.length];
    dp[0] = 1;
    for (int i = 1; i < N; i++){
        if (A[i] > A[i - 1])
            dp[i] = dp[i - 1] + 1;
        else
            dp[i] = 1;
    }
}