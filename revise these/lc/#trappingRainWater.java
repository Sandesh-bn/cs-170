Trapping Rain Water   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 92692
Total Submissions: 264220
Difficulty: Hard
Contributors: Admin
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


public int maxRainWater(int[] heights){
    if (heights == null || heights.length == 0)
        return 0;
    
    int maxWater = 0, maxSeenSoFar = 0;
    int N = heights.length;

    int maxSeenRight[] = new int[N];
    int maxSeenLeft[] = new int[N];

    for (int i = N - 1; i >= 0; i--){
        if (heights[i] > maxSeenSoFar)
            maxSeenSoFar = heights[i];
        maxSeenRight[i] = maxSeenSoFar;
    }

    maxSeenSoFar = 0;

    for (int i = 0; i < N; i++){
        if (heights[i] > maxSeenSoFar)
            maxSeenSoFar = heights[i];
        maxSeenLeft[i] = maxSeenSoFar;
    }

    for (int i = 0; i < N; i++){
        maxWater += Math.max(0,
                                Math.min(maxSeenLeft[i], maxSeenRight[i]) - heights[i]);
    }

    return maxWater;
}