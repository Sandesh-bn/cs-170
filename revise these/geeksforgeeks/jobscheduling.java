class Job{
    int id;
    int deadline;
    int profit;
}

void printJobSchedule(Job[] jobs){
    Arrays.sort(jobs, new Comparator<Job>(){
        public int compare(Job a, Job b){
            return b.profit - a.profit;
        }
    });

    int result = new int[N];
    boolean slot = new boolean[N];

    for (int i = 0; i < N; i++){

        for (int j = Math.min(N, jobs[i].dead) - 1; j >= 0; j--){
            if (!slot[j]){
                slot[j] = true;
                result[j] = i;
                break;
            }
        }
    }

    for (int i = 0; i < n; i++)
        if(slot[i])
            System.out.println(job[result[i]].id + " ");
}