Count 1’s in a sorted binary array
Given a binary array sorted in non-increasing order, count the number of 1’s in it.
Examples:
Input: arr[] = {1, 1, 0, 0, 0, 0, 0}
Output: 2

Input: arr[] = {1, 1, 1, 1, 1, 1, 1}
Output: 7

Input: arr[] = {0, 0, 0, 0, 0, 0, 0}
Output: 0
A simple solution is to linearly traverse the array. The time complexity of the simple solution is O(n). We can use Binary Search to find count in O(Logn) time. The idea is to look for last occurrence of 1 using Binary Search. Once we find the index last occurrence, we return index + 1 as count.

int countOnes(int[] arr, int l, int h){
    if (high >= low){
        mid = low + (high - low)/2;

        // check if it is the last occurence of 1
        if ((mid == high || arr[mid + 1] == 0) && arr[mid] == 1)
            return  mid + 1;
        
        // if it is a one, recurse on right to find the last 1
        if (arr[mid] == 1)
            return countOnes(arr, mid + 1, high);
        else // otherwise recurse toward left
            return countOnes(arr, low, mid - 1);
    }
    return 0;
}

