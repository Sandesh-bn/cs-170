public int maxSumSubmatrix(int[][] matrix, int k) {
        
        if(matrix.length == 0) return 0;
        int maxSoFar = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        int temp[] = new int[m];
        
        for (int j = 0; j < n; j++){
            for (int i = 0; i < m; i++){
                temp[i] = temp[i] + matrix[i][j];
            }
            int sum = kadanes(temp);
            System.out.println(Arrays.toString(temp));
            System.out.println(sum);
            if (sum > maxSoFar && sum <= k)
                maxSoFar = sum;
        }
        return maxSoFar;
        
    }
    
    public int kadanes(int[] matrix){
        if (matrix.length == 0) return 0;
        int N = matrix.length;
        int[] dp = new int[N];
        dp[0] = matrix[0];
        int max = dp[0];
        for (int i = 1; i < N; i++){
            dp[i] = Math.max(matrix[i], matrix[i] + dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
            
        return max;
    }