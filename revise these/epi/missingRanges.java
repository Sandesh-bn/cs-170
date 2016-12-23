public List<String> findMissingRanges(int[] nums, int lower, int higher){
	List<String> res = new ArrayList<>();
	int start = 0, end = 0;
	for (int i = 0; i <= nums.length; i++){
		if (i == 0)
			start = lower;
		else
			start = nums[i - 1] + 1;
		
		if (i == nums.length)
			end = upper;
		else
			end = nums[i] - 1;
		
		// when both start and end are the same
		if (start == end)
			res.add("" + start + "");
		
		// beginning of a missing range
		else if (start < end)
			res.add(start + "->" + end);
	}
	return res;
}