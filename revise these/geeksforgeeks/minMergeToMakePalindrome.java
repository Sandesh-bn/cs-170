http://www.geeksforgeeks.org/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/

public int minimumMergeToMakePal(int[] A){
    int i = 0, j = N - 1;
    int mergeCount = 0;

    while(i <= j){
        if (A[i] == A[j]){
            i++;
            j--;
        }
        else if (A[i] < A[j]){
                i++;
                A[i] += A[i - 1];
                mergeCount++;
        }
        else {
            j--;
            A[j] += A[j + 1];
            mergeCount++;
            
        }
    }
}