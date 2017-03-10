Given a sorted array and a number x, find the pair in array whose sum is closest to x
Given a sorted array and a number x, find a pair in array whose sum is closest to x.
Examples:
Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
Output: 22 and 30

Input: arr[] = {1, 3, 4, 7, 10}, x = 15
Output: 4 and 10
A simple solution is to consider every pair and keep track of closest pair (absolute difference between pair sum and x is minimum). Finally print the closest pair. Time complexity of this solution is O(n2)
An efficient solution can find the pair in O(n) time. The idea is similar to method 2 of this post. Following is detailed algorithm.


while l < r
    sum = arr(l) + arr[r]
    if  abs(sum - diff) < minDiff
        minDiff = abs
        ele1 = arr[l]; ele2 = arr[r];
    else if abs(sum < x)
        l++;
    else   
        r--;

public static void printClosest(int[] arr, int n, int x){
    ele1 = 0, ele2 = 0;//indice of the tow pairs

    int l = 0, r = n - 1, diff = Integer.MAX_VALUE;

    while (l <= r){
        int sum = arr[l] + arr[r];
        if (abs(sum - x) < minDiff){
            minDiff = abs(sum - x);
            ele1 = arr[l];
            ele2 = arr[r];
        }
        if (sum > x)
            r--;
        else
            l++;
        
    }
}