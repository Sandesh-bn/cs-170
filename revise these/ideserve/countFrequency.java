

Given an array of length n having integers 1 to n with some elements being repeated. Count frequencies of all elements from 1 to n.

Example:
Input Array: {2, 3, 3, 2, 5}
Output:
1 0
2 2
3 2
4 0
5 1

public void printFrequence(int[] A){
    int N = A.length;
    for (int i = 0; i < N; i++)
        A[i]--;
    
    for (int i = 0; i < N; i++){
        int idx = A[i] % N;
        A[idx] += N;
    }

    int count = 0;
    for (int i = 0; i < N; i++){
        int count = A[i] / N;
        System.out.println(i + 1 + " " + count);
        A[i] = A[i] % N + 1;
    }
}