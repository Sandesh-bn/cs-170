public int longestSequence(int[] arr){
    int N = arr.length;
    int[] lis = new int[N];
    int[] lds = new int[N];
    for (int i = 0; i < N; i++){
        lis[i] = lds[i] = 1;
    }

    for (int i = 1; i < N; i++){
        for (int j = 0; j < i; j++){
            if (arr[i] > arr[j])
                lis[i] = Math.max(list[i], list[j] + 1);
        }
    }

    for (int i = N - 2; i >= 0; i--){
        for (int j = N - 1; j > i; j--){
            if (arr[i] > arr[j])
                lds[i] = Math.max(lds[i], lds[j] + 1)
        }
    }

    int max = 0;
    for (int i = 0; i < N; i++){
        max = Math.max(max, lis[i] + lds[i] - 1);
    }
    return max;
}
