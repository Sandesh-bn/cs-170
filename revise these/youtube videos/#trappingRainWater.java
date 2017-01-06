// Trapping rain water

public static int getMaxRainWater(int[] heights){
    int maxRainWater = 0;
    if (heights == null)
        return maxRainWater;
    int N = heights.length;
    int[] maxSeenRight = new int[N];
    int[] maxSeenLeft = new int[N];

    for (int i = N - 1; i >= 0; i--){
        if (heights[i] > maxSeenSoFar){
            maxSeenSoFar = heights[i];
        }
        maxSeenRight[i] = maxSeenSoFar;
    }

    maxSeenSoFar = 0;
    for (int i = 0; i < N; i++){
        if (heights[i] > maxSeenSoFar)
            maxSeenSoFar = heights[i];
        maxSeenLeft[i] = maxSeenSoFar;
    }

    for (int i = 0; i < N; i++){
        maxRainWater += Math.max(0,
                                    Math.min(maxSeenLeft[i], maxSeenRight[i]) - heights[i]);

    }
    return maxRainWater;
}