/*
 Given two arrays of integers, compute the pair of values (one value in each 
array) with the smallest (non-negative) difference. Return the difference. 
EXAMPLE 
Input: {1, 3, 15, 11, 2}, {23, 127,235, 19, 8} 
Output: 3. That is, the pair (11, 8). 
*/
brute force use two inner loops and find difference between every pair of A and B.


we have to return minDiff non-negative difference.

if we find a difference to be zero, we can immediately return, but it's still O(n ^ 2)


public int smallestDifference(int[] arrayA, int[] arrayB){
	int a = 0, b = 0, minDiff = Integer.MAX_VALUE;
	Arrays.sort(arrayA);
	Arrays.sort(arrayB);
	while (a < arrayA.length && b < arrayB.length){
		int diff = Math.abs(arrayA[a] - arrayB[b]);
		minDiff = Math.min(minDiff, diff);
		
		if (minDiff == 0)
			return minDiff;
		
		// close the gap
		if (arrayA[a] < arrayB[b])
			a++;
		else
			b++;
	}
	return minDiff;
}
