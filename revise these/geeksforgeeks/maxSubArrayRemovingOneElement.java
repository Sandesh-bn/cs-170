
Input  : arr[] = {1, 2, 3, -4, 5}
Output : 11
Explanation : We can get maximum sum subarray by
removing -4.

Input  : arr[] = [-2, -3, 4, -1, -2, 1, 5, -3]
Output : 9
Explanation : We can get maximum sum subarray by
removing -2 as, [4, -1, 1, 5] summing 9, which is 
the maximum achievable sum.

If element removal condition is not applied, we can solve this problem using Kadane’s algorithm but here one element can be removed also for increasing maximum sum. This condition can be handled using two arrays, forward and backward array, these arrays store the current maximum subarray sum from starting to ith index, and from ith index to ending respectively.
In below code, two loops are written, first one stores maximum current sum in forward direction in fw[] and other loop stores the same in backward direction in bw[]. Getting current maximum and updation is same as Kadane’s algorithm.
Now when both arrays are created, we can use them for one element removal conditions as follows, at each index i, maximum subarray sum after ignoring i’th element will be fw[i-1] + bw[i+1] so we loop for all possible i values and we choose maximum among them.
Total time complexity and space complexity of solution is O(N)


public static int maxSubarrayremoveOne(int[] A){
    int N = A.length;
    int fw[] = new int[N];
    int bw[] = new int[N];
    fw[0] = A[0];
    bw[N - 1] = A[N - 1];
    
    for (int i = 1; i < N; i++){
      fw[i] = Math.max(A[i], fw[i - 1] + A[i]);
    }
    for (int i = N - 2; i >= 0; i--){
      bw[i] = Math.max(A[i], bw[i + 1] + A[i]);
    }
    
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < N - 1; i++){
      max = Math.max(max, fw[i - 1] + bw[i + 1]);
    }
    return max;
  }