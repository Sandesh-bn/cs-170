Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
Credits:

public class Solution {
    public void moveZeroes(int[] nums) {
       /*
        int i = 0, j = nums.length - 1;
        while (i < j){
            while (i < j && nums[i] != 0)
                i++;
            while (i < j && nums[j] == 0)
                j--;
            if (i >= j)break;
            if (i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        */
        for (int i = 0; i < nums.length; i++){
            int j = i;
            while (j > 0 && nums[j] != 0 && nums[j - 1] == 0){
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
        }
        
        
    }
}