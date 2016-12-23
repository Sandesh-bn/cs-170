public List<List<Integer>> subset(int[] nums){
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> empty = new ArrayList<>();
	res.add(empty);
	
	// if you want subsets to be in sorted. otherwise the algorithm still produces subsets
	Arrays.sort(nums);
	int begin = 0;
	for (int i = 0; i < nums.length; i++){
		// if there are duplicates in nums, skip them
		if (i == 0 || nums[i] != nums[i - 1])
			begin = 0;
		int size = res.size();
		for (int j = begin; j < size; j++){
			
			// get each of the set from previous iteration
			List<Integer> curr = new ArrayList<>(res.get(j));
			// add nums[i] for each one of these sets to create new sets
			curr.add(nums[i]);
			
			res.add(curr);
		}
		begin = size;
	}
	return res;
}