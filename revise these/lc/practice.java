public void rotate(int[] arr, int k){
	int N = arr.length;
	k = k % N;
	reverse(arr, 0, N - 1);
	reverse(arr, 0, k - 1);
	reverse(arr, k, N - 1);
}

public void reverse(int[] arr, int s, int e){
	while (s < e){
		arr[s] = arr[s] ^ arr[e];
		arr[e] = arr[s] ^ arr[e];
		arr[s] = arr[s] ^ arr[e];
		s++;e--;
	}
}