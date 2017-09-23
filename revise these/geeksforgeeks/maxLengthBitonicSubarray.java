http://www.geeksforgeeks.org/maximum-length-bitonic-subarray/

public int maxLengthBitonic(int[] A){
    
    int[] forward = new int[N];
    Arrays.fill(forward, 1);

    for (int i = 1; i < N; i++){

        if (A[i] > A[i - 1])
            forward[i] = forward[i - 1] + 1;
    }

    int[] bacward = new int[N];
    Arrays.fill(backward, 1);

    for (int i = N - 2; i >= 0; i--){
        if(A[i] > A[i + 1])
            backward[i] = backward[i + 1] + 1;
    }

    int max = forward[0] + backward[0] - 1;

    for (int i = 1; i < N; i++){
        max = Math.max(max, forward[i] + backward[i] - 1);
    }
    return max;
}

https://www.youtube.com/watch?v=TWHytKnOPaQ
maximum bitonic subsequence
create fw[] which will hold longest increasing subsequence for each i in forward direction
create bw[] which will hold longest increasing subsequence for each i in backward direction

iterate from 1 to N  and calculate max(fw[i] + bw[i] - 1)

public int maxLenghBitonicSubSequence(int[] A){
    int[] forward = new int[N];
    int[] backward = new int[N];
    Arrays.fill(forward, 1);
    for (int i = 1; i < N; i++){
        for (int j = 0; j < i; j++){
            
            if (A[i] > A[j])
                forward[i] = Math.max(forward[i], forward[j] + 1);
        }
    }


    for (int i = N - 2; i >= 0; i--){
        for (int j = N - 1; j > i; j--){
            if (bacward[i] > bacward[j])
                backward[i] = Math.max(backward[i], bacward[j] + 1);
        }
    }

    int max = 0;

    for (int i = 0; i < N; i++){
        max = Math.max(forward[i] + backward[i] - 1, max);
    }
}


to get the max sum of bitonic subsequence

We construct two array increasing[] and decreasing[]. increasing[i] stores the sum of the Increasing subsequence ending with arr[i]. decreasing[i] stores the sum of the Decreasing subsequence starting from arr[i]. Finally, we need to return the max sum of increasing[i] + decreasing[i] – Arr[i].


Input : arr[] = {1, 15, 51, 45, 33, 
                   100, 12, 18, 9}
Output : 194

Input : arr[] = {80, 60, 30, 40, 20, 10} 
Output : 210  


 public static int maxBitonicSubSequenceSum(int[] A){
    int max = Integer.MIN_VALUE;
    int N = A.length;
    int increasing[] = new int[N];
    int decreasing[] = new int[N];
    for (int i = 0; i < N; i++){
      increasing[i] = A[i];
      decreasing[i] = A[i];
    }
    
    for (int i = 1; i < N; i++){
      for (int j = 0; j < i; j++){
        if (A[i] > A[j]){
          increasing[i] = Math.max(increasing[i], increasing[j] + A[i]);
        }
      }
    }
    
     
    for (int i = N - 2; i >= 0; i--){
      for (int j = N - 1; j > i; j--){
        if (A[i] > A[j])
          decreasing[i] = Math.max(decreasing[j] + A[i], decreasing[i]);
      }
    }
    
    for (int i = 0; i < N; i++)
      max = Math.max(max, increasing[i] + decreasing[i] - A[i]);
    return max;
  }
  
  