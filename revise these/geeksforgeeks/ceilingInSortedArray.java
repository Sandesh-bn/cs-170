


given a sorted array, return the smallest element
which is greater than or equal to X

O(n) algorithm
public int celing(int[] A, int x){

    if (x <= A[low])
        return low;

    for (int i = 0; i < N - 1; i++){
        if (A[i] == X)
            return i;
        
        if (A[i] < X && A[i + 1] >= X)
            return i + 1;
    }
    return -1;
}

O(n log n)
 
public int ceiling(int[] A, int low, int high, int X){
    if (X <= A[low])
        return low;
    if (X > A[high])
        return -1;
    
    mid = (low + high) / 2;

    if (A[mid] == X)
        return mid;


  /* If x is greater than arr[mid], then either arr[mid + 1]
    is ceiling of x or ceiling lies in arr[mid+1...high] */ 
    else if (A[mid] < X){
        if (mid + 1 <= high && X <= A[mid + 1])
            return mid + 1;
        else
            return ceiling(A, mid + 1, high, X);
    }


/* If x is smaller than arr[mid], then either arr[mid] 
     is ceiling of x or ceiling lies in arr[mid-1...high] */   
    else {
        if (mid - 1 >= low && X > A[mid - 1])
            return mid;
        else
            return ceiling(A, low, mid - 1, X);
    }
}