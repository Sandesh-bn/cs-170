public int maximumSumSubSequence(int[] arr){
    int[] dp = new int[N];

    for (int i = 0; i < N; i++)
        dp[i] = arr[i];
    
    for (int i = 1; i < N; i++){
        for (int j = 0; j < i; j++){
            if (arr[j] < arr[i])
                dp[i] = Math.max(dp[i], dp[j] + arr[i]);
        }
    }

    int max = dp[0];
    for (int i = 1; i < N; i++)
        max = Math.max(dp[i], max);
    return max;
}