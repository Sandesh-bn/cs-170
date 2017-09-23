For example, if the array is {16, 17, 4, 3, 5, 2}, then it should be modified to {17, 5, 5, 5, 2, -1}.

public void replaceWithNextLargest(int[] A){
    int N = A.length;

    int nextMax = A[N - 1];
    A[N - 1] = -1; // since no max elements can exist to right of last element

    for (int i = N - 2; i >= 0; i--){
        int temp = A[i];

        A[i] = nextMax;

        nextMax = Math.max(nextMax, temp);
    }
}

http://www.geeksforgeeks.org/replace-every-element-with-the-greatest-on-right-side/