Input:  A[] = {5, 0, 10, 6} 
        B[] = {1, 2, 4} 
Output: sum[] = {5, 10, 30, 26, 52, 24}

The first input array represents "5 + 0x^1 + 10x^2 + 6x^3"
The second array represents "1 + 2x^1 + 4x^2" 
And Output is "6 + 2x^1 + 14x^2 + 6x^3"


public int[] addTwoPoly(int[] A, int[] B){
    int m = A.length, n = B.length;
    int []sum  = new int[Math.max(m, n)];

    for (int i = 0; i < m; i++)
        sum[i] = A[i];
    
    for (int i = 0; i < n; i++)
        sum[i] += B[i];
    
    return sum;
}