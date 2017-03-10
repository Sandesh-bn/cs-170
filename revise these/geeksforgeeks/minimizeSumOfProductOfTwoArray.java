Given two arrays, A and B, of equal size n, the task is to find the minimum value of A[0] * B[0] + A[1] * B[1] +…+ A[n-1] * B[n-1]. Shuffling of elements of arrays A and B is allowed.

Examples:

Input : A[] = {3, 1, 1} and B[] = {6, 5, 4}.
Output : 23
Minimum value of S = 1*6 + 1*5 + 3*4 = 23.

Input : A[] = { 6, 1, 9, 5, 4 } and B[] = { 3, 4, 8, 2, 4 }
Output : 80.
Minimum value of S = 1*8 + 4*4 + 5*4 + 6*3 + 9*2 = 80.

sort both arrays
multiply minimum of A with max of B
public int minProd(int[] A, int[] B){
    Arrays.sort(A);
    Arrays.sort(B);
    int res = 0, N = A.length;
    for (int i = 0; i < N; i++)
        res += A[i] * B[N - i - 1];
    return res;
}