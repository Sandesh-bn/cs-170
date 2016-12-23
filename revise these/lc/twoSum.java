
Two Sum   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 376197
Total Submissions: 1280611
Difficulty: Easy
Contributors: Admin
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].


public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ret = {-1, -1};
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                ret[0] = map.get(target - nums[i]);
                ret[1] = i;
                return ret;
            }
            else
                map.put(nums[i], i);
        }
        return ret;
        
    }
}