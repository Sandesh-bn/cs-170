public List<Interval> merge(List<Interval> in){
	List<Interval> result = new ArrayList<>();
	if (in.size() < 1)return result;
	Collections.sort(intervals, new Comparator<Interval>(){
		public int compare(Interval i1, Interval i2){
			return i1.start - i2.start;
		}
	})
	
	int start = intervals.get(0).start;
	int end = intervals.get(0).end;
	for (Interval val: intervals){
		if (val.start <= end)
			end = Math.max(end, val.end);
		else {
			result.add(new Interval(start, end));
			start = val.start;
			end = val.end;
		}
	}
	result.add(new Interval(start, end));
	return result;
}