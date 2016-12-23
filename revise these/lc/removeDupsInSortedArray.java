public class Solution {
    public int removeDuplicates(int[] nums) {
      
        
        if (nums.length < 2) return nums.length;
        int unique = 1, curr = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (curr != nums[i]){
                nums[unique++] = nums[i];
                curr = nums[i];
            }
        }
        return unique;
        
    }
    
}

/*
curr holds the value that has already been enuniqueered.
if nums[i] == curr, then nums[i] is a duplicate we increment i

if nums[i] != curr, we copy nums[i] to nums[unique] and increment i and unique
we set curr = nums[i]; since nums[i] has been enuniqueerd for the first time.
*/