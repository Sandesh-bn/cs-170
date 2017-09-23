http://www.geeksforgeeks.org/count-number-of-ways-to-cover-a-distance/

Given a distance ‘dist, count total number of ways to cover the distance with 1, 2 and 3 steps.

Examples:

Input:  n = 3
Output: 4
Below are the four ways
 1 step + 1 step + 1 step
 1 step + 2 step
 2 step + 1 step
 3 step

Input:  n = 4
Output: 7

int printCoundDP(int d){
    int dp[] = new int[d + 1];
    dp[0] = 1, dp[1] = 1, dp[2] = 2;

    for (int i = 3; i <= d; i++)
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    return dp[d];
}