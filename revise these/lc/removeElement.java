public int removeElement(int[] arr, int x){
	if (arr.length == 0)
		return 0;
	int i = 0, j = arr.length - 1;
	int count = 0;
	
	while (i < j){
		while (i < j && arr[i] != x)
			i++;
		while (i < j && arr[j] == x)
			j--;
		if (i >= j)
			break;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		i++;j--;
		count++;//whenever swap occurs increment count.
	}
	return count;
}