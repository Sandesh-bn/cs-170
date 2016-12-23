public static int binarySearch(int[] arr, int x){
	int low = 0, high = arr.length - 1, mid = 0;
	while (low <= high){
		mid = (low + high) / 2;
		if (arr[mid] == x)
			return mid;
		if (arr[mid] < x)
			low = mid + 1;
		else
			high = mid - 1;
	}
	return -1;
}

public static int binarySearchRecursive(int[] arr, int x, int low, int high){
	if (low > high) 
		return -1;
	int mid = (low + high) / 2;
	
	if (arr[mid] == x)
		return mid;
	if (arr[mid] < x)
		return binarySearchRecursive(arr, x, mid + 1, high);
	else
		return binarySearchRecursive(arr, x, low, mid - 1);
}