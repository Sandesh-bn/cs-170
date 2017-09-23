You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.
Example:

Consider the following 6 activities. 
     start[]  =  {1, 3, 0, 5, 8, 5};
     finish[] =  {2, 4, 6, 7, 9, 9};
The maximum set of activities that can be executed 
by a single person is {0, 1, 3, 4}

0 1
public void maxAcitivitie(int[] s, int[] f, int n){
    List<Activity> list = new ArrayList<>();
    for (int i = 0; i < s.length; i++){
        list.add(new Activity(s[i], f[i]));
    }
    Collections.sort(list, new Comparator<Activity>(){
        public int compare(Activity a, Activity b){
            return a.end - b.end;
        }
    })

    int end = list.get(0).end;
    /// always choose the first activity
    // for the remaining activity if start >= end of previously selected activity
    // choose it
    List<Activity> res = new ArrayList<>();
    res.add(Activity.get(0));
    for (int i = 1; i < N; i++){
        if (list.get(i).start >= end){
            res.add(list.get(i));
            end = list.get(i).end;
        }
    }
    
}

The greedy choice is to always pick the next activity whose finish time is least among the remaining activities and the start time is more than or equal to the finish time of previously selected activity. We can sort the activities according to their finishing time so that we always consider the next activity as minimum finishing time activity.

1) Sort the activities according to their finishing time
2) Select the first activity from the sorted array and print it.
3) Do following for remaining activities in the sorted array.
…….a),  If the start time of this activity is greater than the finish time of previously selected activity then select this activity and print it.


// activites are sorted according to finish time.
public static void printMaxActivities(int[] s, int[] f, int n){
    int i = 0, j = 0;
    print(i + " "); // always choose the first activity

    for every other activity , if start time is gretar than 
    or equal to finish time of previously selected activity, 
    choose it.
    for (j = 1; j < n; j++){
        if (s[j] >= f[i]){
            System.out.println(j + " ");
            i = j;
        }
    }
}