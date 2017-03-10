Input : A[] = { 2 ,3 , 8 ,-1 ,7 ,10 }
Output : -1 , 2 , 3 , 7 , 8 , 10 

Input : A[] = {-4 , 6, 9 , -1 , 3 }
Output : -4 , -1 , 3 , 6 , 9 
// same as using merge sort
void sortTwoArrays(int[] A){

    // This does not work
    /*
    int i = 0, j = 1;
    while (j < A.length && A[j] > A[j - 1])
        j++;
    if (j == A.length) return;
    while(i < j && j < A.length){
        if (A[i] >= A[j]){
            int t = A[i];
            A[i] = A[j];
            A[j] = t;
            i++;
        }
    }
    */
    int[] temp = new int[A.length];
    int k = 0;
    int i = 0, j = 1;
    while (j < A.length && A[j] > A[j - 1])
        j++;
    int half = j;
    while (i < half && j < n){
        if (A[i] < A[j])
            temp[k++] = A[i++];
        else
            temp[k++] = A[j++];
    }
    while (i < half)
        temp[k++] = A[i++];
    while (j < N)
        temp[k++] = A[j++];
    copy temp to A
}

