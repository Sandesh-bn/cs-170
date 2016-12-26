Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0)
            return new int[0];
        int N = nums.length;
        int[] res = new int[N - k + 1];
        int resI = 0;
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; i++){
            
            // make sure dq has atmost k elements
            while (!dq.isEmpty() && dq.peek() < i - k + 1)
                dq.poll();
                
            // if rightmost element in dq is less than nums[i], keep removing it. This ensures the first number is always the largest in the queue.
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
                
            dq.offer(i);
            
            if (i >= k - 1)
                res[resI++] = nums[dq.peek()];
        }
        return res;
    }
}



