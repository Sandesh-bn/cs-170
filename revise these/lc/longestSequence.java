Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.


public class Solution {
    public int longestConsecutive(int[] nums) {
    
        
        if (nums == null || nums.length == 0) return 0;
        int maxLen = 1;
        Set<Integer> set = new HashSet<>();
        for (int num: nums)
            set.add(num);
        
        while (!set.isEmpty()){
            int longestSeq = 0;
            int value = set.iterator().next();
            int nextValue = value;
            int prevValue = value - 1;
            while (set.contains(nextValue)){
                longestSeq++;
                set.remove(nextValue);
                nextValue++;
                
            }
            while (set.contains(prevValue)){
                longestSeq++;
                set.remove(prevValue);
                prevValue--;
                
            }
            maxLen = Math.max(maxLen, longestSeq);
        }
        return maxLen;
    }
}