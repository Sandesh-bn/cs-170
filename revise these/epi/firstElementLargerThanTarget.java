 Design an efficientalgorithm that takes a sorted array A and a key
k, and finds the index of the first occurrence an element larger than k; return -1 if
every element is less than or equal to k



public static int findFirstLarger(int[] arr, int x){
	int low = 0, high = arr.length - 1, res = -1;
	
	while (low <= high){
		int mid = low + ((high - 1) / 2);
		
		if (arr[mid] > x){
			res = mid;
			// search the left to find a larger element that is closer to x(if it exists, othwerise res already holds the index of a larger element)
			high = mid - 1;
		}
		else
			low = mid + 1;
	}
	return res;
}