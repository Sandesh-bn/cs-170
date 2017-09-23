given an array print the balance point. balance point is 
the index where the cumulative sum to the left of it is 
equal to cumulative sum to the right;

public void printBalance(int[] A){
    int N = A.length;
    int forwardSum[] = new int[N];
    forwardSum[0] = A[0];
    for (int i = 1; i < N; i++)
        forwardSum[i] = A[i] + forwardSum[i - 1];

    int backwardSum[] = new int[N];
    backwardSum[N - 1] = A[N - 1];

    for (int i = N - 2; i >= 0; i--)
        backwardSum[i] = A[i] + backwardSum[i + 1];

    for (int i = 0; i < N; i++){
        if (backwardSum[i] == forwardSum[i])
            System.out.println("balance point index is " + i);
            return;
    }
    System.out.println("Not found");
}