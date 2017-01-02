Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 32      
Output:  1 and 30

Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 50      
Output:  7 and 40


public void printClosest(int[] arr1, int[] arr2, int m, int n, int x){
	int minDiff = Integer.MAX_VALUE;
	int leftIndex = 0, rightIndex = 0;
	 
	 // Start from left side of ar1[] and right side of ar2[]
	int l = 0, r = n - 1;
	
	while (l < m && r >= 0){
		int value = Math.abs(arr1[l] + arr2[r] - x)
		
		if (value < minDiff){
			rightIndex = r;
			leftIndex = l;
			minDiff = value;
		}
		if (arr1[l] + arr2[r] > x)
			r--;
		else
			l++;
	}
	System.out.println("Closest pair " + arr1[leftIndex] + " " + arr2[rightIndex]);
}