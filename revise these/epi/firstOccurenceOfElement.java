Write a method that takes a sorted array A and a key k and returns the
index of the first occurrence ofk in A. Return -1ifk does not appear in A.

public int searchFirst(int[] arr, int x){
	int low = 0, high = arr.length - 1, result = -1;
	while(low <= high){
		int mid = low + ((high - low)/2);
		if (arr[mid] > x){
			high = mid - 1;
		}
		else if (arr[mid] == k){
			result = mid;
			// nothing to right of mid can be the first occurence
			right = mid - 1;
		}
		else
			low = mid + 1;
	}
	return result;
}