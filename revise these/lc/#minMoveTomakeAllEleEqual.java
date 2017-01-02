Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

public class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0)return 0;
        int minValue = Integer.MAX_VALUE;
        for (int num: nums)minValue = Math.min(minValue, num);
        int res = 0;
        for (int num: nums) res += (num - minValue);
        return res;
        
        
        
    }
}


Adding 1 to n - 1 elements is the same as subtracting 1 from one element, w.r.t goal of making the elements in the array equal.
So, best way to do this is make all the elements in the array equal to the min element.
sum(array) - n * minimum
//https://discuss.leetcode.com/topic/66557/java-o-n-solution-short


PROBLEM 2

Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]

This solution relies on the fact that if we increment/decrement each element to the median of all the elements, the optimal number of moves is necessary. The median of all elements can be found in expected O(n) time using QuickSelect (or O(n) time using deterministic select).

public class Solution {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int median = findMedian(nums);
        int res = 0;
        for (int n: nums)
            res += Math.abs(n - median);
        return res;
    }
    
    public int findMedian(int[] nums){
        return findKthElement(nums, 0, nums.length - 1, nums.length/2 );
    }
    
    public int findKthElement(int A[], int low, int high, int k){
        if (low >= high) return A[low];
        int pivotIndex = partition(A, low, high);
        if (pivotIndex == k) return A[k];
        if (pivotIndex > k) return findKthElement(A, low, pivotIndex - 1, k);
        else
            return findKthElement(A, pivotIndex + 1, high, k);
    }
    
    public int partition(int[] A, int low, int high){
        int i = low + 1, j = high, pivot = A[low];
        while(true){
            while(A[i] < pivot){
                i++;
                if (i >= high)break;
            }
            while(A[j] >= pivot){
                j--;
                if (j <= low)break;
            }
            if (i >= j) break;
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;j--;
        }
        int temp2 = A[low];
        A[low] = A[j];
        A[j] = temp2;
        return j;
    }
}