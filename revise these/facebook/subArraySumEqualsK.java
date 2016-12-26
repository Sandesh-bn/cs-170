Given an array of positive integers and a target total of X, find if there exists a contiguous subarray with sum = X 

[1, 3, 5, 18] X = 8 Output: True 
X = 9 Output: True 
X = 10 Output: False 
X = 40 Output :False


public boolean subArraySum(int[] arr, int n, int targetSum){
	int curr_sum = arr[0], start = 0, i = 0;
	for (i = 1; i <= n; i++){
		
		// if curr_sum > sum, then decrement arr[start]
		// and move start.
		while (curr_sum > targetSum && start < i - 1){
			curr_sum -= arr[start];
			start++;
		}
		
		if (curr_sum == targetSum){
			int p = i - 1;
			System.out.println("Sum found between indices " + start + " and " + p);
			return true;
		}
		if (i < n)
			curr_sum = curr_sum + arr[i];
	}
	return false;
}

O(n) operation