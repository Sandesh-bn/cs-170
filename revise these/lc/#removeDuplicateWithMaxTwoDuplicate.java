
Remove Duplicates from Sorted Array II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 98712
Total Submissions: 284142
Difficulty: Medium
Contributors: Admin
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter wha


public int removedups(int[] nums){
    int i = 0;
    for (int num: nums){
        if (i < 2 || num > nums[i - 2]){
            nums[i] = num;
            i++;
        }
    }
    return i;
}