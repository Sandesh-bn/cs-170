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

int magicFast(int[] arrayDup){
	return magicFast(arrayDup, 0, arrayDup.length - 1);
}

int magicFast(int[] arrayDup, int low, int high){
	if (high < low) return -1;//base case
	
	int mid = (low + high)/2;
	int midValue = arrayDup[mid];
	if(midValue == mid)
		return mid;
	
	int leftIndex = Math.min(mid - 1, midValue);
	int left = magicFast(array, start, leftIndex);
	if (left >= 0)
		return left;
	
	int rightIndex = Math.max(mid + 1, midValue);
	int right = magicFast(arary, rightIndex, high);
	return right;
}