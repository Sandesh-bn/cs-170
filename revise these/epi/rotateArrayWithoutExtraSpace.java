public void rotate(int[] array, int k){
	/* USING EXTRA SPACE
        int[] copy = new int[nums.length];
        int N = nums.length;
        for (int i = 0; i < nums.length; i++)
            copy[i] = nums[i];
        for (int i = 0; i < nums.length; i++)
            nums[(i + k) % N] = copy[i];
            */
			
	int N = array.length;
	if (k > N)
		k = k % N;
	
	reverseArray(array, 0, N - 1);
	reverseArray(array, 0, k - 1);
	reverseArray(array, k, N - 1);
	
}

public void reverseArray(int[] array, int s, int e){
	while (s < e){
		int temp = arr[s];
		arr[s] = arr[e];
		arr[e] = temp;
		s++;
		e--;
	}
}

