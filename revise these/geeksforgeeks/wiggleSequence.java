

public void wiggle(int[] A){

    boolean isLesser = true; // "<" first two integers should be ascending

    for (int i = 0; i < N - 1; i++){
        
        if (isLesser){

            if (A[i] > A[i + 1])
               swap(A[i], A[i + 1]);
        }

        else {

            if (A[i] < A[i + 1])
                swap(A[i], A[i + 1]);
        }

        isLesser = !isLesser;
    }

    
}