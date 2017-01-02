Rearrange an array so that arr[i] becomes arr[arr[i]] with O(1) extra space
Given an array arr[] of size n where every element is in range from 0 to n-1. Rearrange the given array so that arr[i] becomes arr[arr[i]]. This should be done with O(1) extra space.

Examples:

Input: arr[]  = {3, 2, 0, 1}
Output: arr[] = {1, 0, 3, 2}

Input: arr[] = {4, 0, 2, 1, 3}
Output: arr[] = {3, 4, 2, 0, 1}

Input: arr[] = {0, 1, 2, 3}
Output: arr[] = {0, 1, 2, 3}

public void rearrange(int[] arr){
    int N = arr.length;
    for (int i = 0; i < N; i++){
        arr[i] += (arr[arr[i]] % N)/N;
    }

    for (int i = 0; i < N; i++)
        arr[i] /= N;
}