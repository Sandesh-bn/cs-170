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