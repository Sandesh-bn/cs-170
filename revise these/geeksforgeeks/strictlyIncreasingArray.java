https://www.youtube.com/watch?v=eMuC2LCoMvU

http://www.geeksforgeeks.org/count-strictly-increasing-subarrays/

O(M) m = number of increasing subarray
not efficient. since if it is an increasing sequence. it will be O(n ^ 3)

public int countIncreasingSubArray(int[] A){
    int count = 0;

    for (int i = 0; i < N; i++){

        for (int j = i + 1; j < N; j++){

            if (A[j] > A[j - 1])
                count++;
            
            else
                break;
        }
    }
    return count;
}

O(n) time. The idea is based on fact that a sorted subarray of length ‘len’ adds len*(len-1)/2 to result. For example, {10, 20, 30, 40} adds 6 to the result.

public int countIncreasingSubArray(int[] A){
    int count = 0;

    for (int i = 0; i < N - 1; i++){

        if (A[i + 1] > A[i])
            len++; 

        else {
            count += ((len * (len - 1))/2);
            len = 1;
        }
    }

    if (len > 1)
        count += ((len * (len - 1))/2);
    return count;
}