You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. Find the longest chain which can be formed from a given set of pairs.

Examples:

Input:  (5, 24), (39, 60), (15, 28), (27, 40), (50, 90)
Output: (5, 24), (27, 40), (50, 90)

Input:  (11, 20), {10, 40), (45, 60), (39, 40)
Output: (11, 20), (39, 40), (45, 60) 


public int maxPairs(Interval[] intervals){
    int res = 0;

    Arrays.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval a, Interval b){
            if (a.start < b.start)
                return -1;
            return 1;
        }
    });

    int[] dp = new int[N];
    Arrays.fill(dp, 1);
    
    for (int i = 1; i < N; i++){
        for (int j = 0; j < i; j++){
            if (intervals[i].start > intervals[j].end)
                dp[i] = dp[j] + 1;
            res = Math.max(res, dp[i]);
        }
    }
}