// revivew the stack trace for iterative and recursive algos in CTCI
int fibonacci(int n){
	return fibonacci(n, new int[n + 1]);
}

int fibonacci(int i, int[] dp){
	if (i == 0 || i == 1) return i;
	
	if (dp[i] == 0){
		dp[i] = fibonacci(i - 1, dp) + fibonacci(i - 2, dp);
	}
	return dp[i];
}

int fibonacciIterative(int n){
	int[] fibo = new int[n + 1];
	fibo[0] = 0;
	fibo[1] = 1;
	for (int i = 2; i <= n; i++)
		fibo[i] = fibo[i - 1] + fibo[i - 2];
	return fibo[n];
}