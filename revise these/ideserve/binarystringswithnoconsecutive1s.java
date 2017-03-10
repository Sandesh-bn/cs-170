http://www.ideserve.co.in/learn/distinct-binary-strings-of-length-n-with-no-consecutive-1s

public int consecutiveOnes(int N){
    if (N < 0)
        return 0;
    int c0 = 1;
    int c1 = 1;

    for (int i = 1; i < N; i++){
        int temp = c1;
        c1 = c0;
        c0 = c0 + temp;
    }
    return c0 + c1;
}


