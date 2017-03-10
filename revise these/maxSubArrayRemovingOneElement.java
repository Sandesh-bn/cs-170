
http://www.geeksforgeeks.org/maximum-sum-subarray-removing-one-element/
public int maxSumSubArrayRemovingOneEle(int[] A){
    int N = A.length;
    int fw[] = new int[N];
    int bw[] = new int[N];
    int currMax = A[0], maxSoFar = A[0];

    for (int i = 1; i < n; i++){
        currMax = Math.max(A[i], currMax + A[i]);
        maxSoFar = Math.max(maxSoFar, currMax);
        fw[i] = currMax;
    }

    currMax = maxSoFar = bw[N - 1] = A[n - 1];
    for (int i = N - 2; i >= 0; i--){
        currMax = Math.max(A[i], currMax + A[i]);
        maxSoFar = Math.max(maxSoFar, currMax);
        bw[i] = currMax;
    }

    int res = maxSoFar;

    for (int i = 1; i < N - 1; i++){
        res = Math.max(res, fw[i - 1] + bw[i + 1])
    }
    return res;
}