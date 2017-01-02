Jump Game   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 103038
Total Submissions: 354031
Difficulty: Medium
Contributors: Admin
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false

public boolean canJump(int[] nums){
    int maxSoFar = 0;
    for (int i = 0; i < nums; i++){
        if (i > maxSoFar)return false;
        maxSoFar = Math.max(maxSoFar, i + nums[i]);
    }
    return maxSoFar;
}



JUMP GAME 2

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

public int minJump(int[] A){
    int N = A.length;
    if (N == 0 || N == 1)   // A = [0], [1], [4] no jumps are required to reach the end
        return 0;
    
    if (A[0] == 0) // if first distance is 0, we cannot jump forward. A=[0, 13, 45, 8], A= [0, 3, 2, 1]
        return -1;

    int maxReachable = 0, jumpCount = 0, jumpIndex = 0;
    for (int i = 0; i < A.length; i++){
        if (i > jumpIndex){
            jumpIndex = maxReachable;
            jumpCount++;
        }
        maxReachable = Math.max(maxReachable, i + A[i]);
    }

    return (maxReachable >= N - 1)?jumpCount: -1;

    // trace for [2, 3, 1, 1, 4], [3, 2, 1, 0, 4]
}