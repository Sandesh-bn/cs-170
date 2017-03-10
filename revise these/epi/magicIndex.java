https://github.com/wzhishen/cracking-the-coding-interview/blob/master/src/chap09/Q03.java
https://miafish.wordpress.com/2014/12/20/find-a-magic-index-in-an-array/
public static int findMagicIndex(int[] array)
{
	return findMagicIndexRecursion(array, 0, array.length - 1);
}

private static int findMagicIndexRecursion(int[] array, int low, int high)
{

	if (low > high)
	{
		return -1;
	}

	int mid = (low + high) / 2;
	if (array[mid] == mid)
	{
		return mid;
	}
	else if (array[mid] > mid)
	{
		return findMagicIndexRecursion(array, low, mid - 1);
	}
	else
	{
		return findMagicIndexRecursion(array, mid + 1, high);
	}
}
		
		
		
		
what if the values are not distinct?
if the values are not distinct, we are not sure where the magic index would be, so we need to search left and right side both.

public int magicIndex(int[] A){
	return helper(A, 0, A.length - 1);
}

public int helper(int[] A, int low, int high){
	if (low > high)
		return -1;
	
	int mid = (low + high)/2;
	int midVal = A[mid];
	if (midVal == mid)
		return A[mid];
	
	int leftIndex = min(mid - 1, midVal);
	int a = helper(A, low, leftIndex);
	if (a >= 0)
		return a;

	int rightIndex = max(mid + 1, midVal);
	int b = helper(A, rightIndex, high);
	return b;

}