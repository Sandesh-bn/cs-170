http://www.ideserve.co.in/learn/find-minimum-length-sub-array-with-sum-k

public void minLengthSubArray(int[] A, int k){
    int start = -1, end = -1, min = Integer.MAX_VALUE;
    
    for (int i = 0; i < N; i++){
        currSum = 0;
        j = i;

        whiel(j < N && (j - i + 1) < min){
            currSum += A[i];
            if (currSum == k){
                start = i;
                end = j;
                min = end - start + 1;
                break;
            }
            j++;
        }
        if (start == -1 || end == -1)
            System.out.println("no subarray exists");
        else{
            while(start <= end)
                Sop(A[start++]);
        }
    }
}