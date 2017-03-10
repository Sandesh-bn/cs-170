http://www.geeksforgeeks.org/weighted-job-scheduling/

https://www.youtube.com/watch?v=cr6Ip0J9izc

public int maxProfit(Job[] jobs){
    int N = jobs.length;
    int dp[] = new int[N];
    Arrays.sort(jobs, new Comparator<Job>(){
        public int compare(Job j1, Job j2){
            return j1.end - j2.end;
        }
    });

    dp[0] = jobs[0].profit;
    for (int i = 1; i < jobs.length; i++){
        dp[i] = Math.max(jobs[i].profit, dp[i - 1]);

        for (int j = i - 1; j >= 0; j--){
            // if jobs do not overlap
            if (jobs[j].end <= jobs[i].start){
                dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
                break;
            }
        }
    }

    for (int val: dp)
        max = (val > max)?val:max;
    return max;
}