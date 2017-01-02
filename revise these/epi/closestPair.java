Given a sorted array and a number x, find the pair in array whose sum is closest to x

Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
Output: 22 and 30

Input: arr[] = {1, 3, 4, 7, 10}, x = 15
Output: 4 and 10


public void printClosestPair(int arr[], int x){

	int leftIndex = 0, rightIndex = 0;
	int l = 0, r = n - 1, minDiff = Integer.MAX_VALUE;
	
	while (l < r){
		int temp = Math.abs(arr[l] + arr[r] - x)
		if (temp < minDiff){
			minDiff = temp;
			leftIndex = l;
			rightIndex = r;
		}
		if (temp > x)
			r--;
		else
			l++;
	}
	
	System.out.println("Closest pair is " + arr[leftIndex] + " and " + arr[rightIndex]);
}