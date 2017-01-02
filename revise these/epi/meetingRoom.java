
// given an array of intervals of meeting time return if a 
// person can attend all meetings
//[0, 30], [5, 10], [15, 20] return false;

public boolean canAttend(Interval[] intervals){
	if (intervals == null) return false;
	Arrays.sort(intervals, new Comparator<Interval>(){
		public int compare(Interval i1, Interval i2){
			return i1.start - i2.start;
		}
	});
	for (int i = 1; i < intervals.length; i++)
		if (intervals[i - 1].end > intervals[i].start)
			return false;
	return true;
}



public boolean isStrobogrammatic(String num) {
    Map<Character, Character> map = new HashMap<Character, Character>();
    map.put('6', '9');
    map.put('9', '6');
    map.put('0', '0');
    map.put('1', '1');
    map.put('8', '8');
   
    int l = 0, r = num.length() - 1;
    while (l <= r) {
        if (!map.containsKey(num.charAt(l))) return false;
        if (map.get(num.charAt(l)) != num.charAt(r))
            return false;
        l++;
        r--;
    }
    
    return true;
}


Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.


With O(1) space complexity

using priorityQueue to store the end times, then we sort the intervals by its start time.

then iterate the Interval array,

if the current star time is less than the earliest end time, minRoom++
Else, remove the earliest end time from PriorityQueue

public int minMeetingRoomsWithConstantSpace(Interval[] intervals) {
    if (null == intervals || intervals.length == 0) {
        return 0;
    }
    Arrays.sort(intervals, new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    });
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    int minRoom = 1;
    queue.offer(intervals[0].end);
    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i].start < queue.peek()) {
            minRoom++;
        } else {
            queue.poll();
        }
        queue.offer(intervals[i].end);
    }
    return minRoom;
}