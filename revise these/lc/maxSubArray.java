Maximum Subarray   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 154434
Total Submissions: 400331
Difficulty: Medium
Contributors: Admin
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

public int maxSubArraySum(int[] nums){
    if (nums == null || nums.length == 0)
        return 0;
    int N = nums.length;
    int[] dp = new int[N];
    dp[0] = nums[0];
    for (int i = 1; i < N; i++){
        dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
    }
    int maxSoFar = Integer.MIN_VALUE;
    for (int num: dp)
        maxSoFar = Math.max(maxSoFar, num);
    return maxSoFar;
}