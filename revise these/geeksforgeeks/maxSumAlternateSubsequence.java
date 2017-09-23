

public int maxAlternateSum(int[] A){
    
    int N = A.length;
    int dec[] = new int[N];
    int inc[] = new int[N];

    dec[0] = inc[0] = A[0];
    int flag = 0;

    for (int i = 1; i < N; i++){
        for (int j = 0; j < i; j++){

            if (A[j] > A[i]) {
                dec[i] = Math.max(dec[i], inc[j] + A[i]);
                flag = 1;
            }

            else if (A[j] < A[i] && flag == 1)
                inc[i] = Math.max(inc[i], dec[j] + A[i]);
        }
    }

    for (int i = 0; i < N; i++){
        res = Math.max(result, dec[i], inc[i]);
    }
}