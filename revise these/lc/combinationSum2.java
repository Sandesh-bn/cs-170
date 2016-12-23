public static List<List<Integer>> combinationSum2(int[] candidates, int target){
		Arrays.sort(candidates);;
		List<List<Integer>> result = new ArrayList<>();
		dfs(result, new ArrayList<>(), candidates, target, 0);
		return result;
	}
	
	public static void dfs(List<List<Integer>> result, List<Integer> prevPath, int[] candidates, int target, int index){
		System.out.println(path);
		if (target <= 0){
			if (target == 0) result.add(prevPath);
			return;
		}
		
		for (int i = index; i < candidates.length; i++){
			if (i > index && candidates[i] == candidates[i - 1])
				continue;
			List<Integer> newPath = new ArrayList<>(prevPath);
			newPath.add(candidates[i]);
			dfs(result, newPath, candidates, target- candidates[i], i + 1);
		}
	}
	
	/*
	we have to use new arralist in every recursive call, otherwise there will be one list to which  elements of all the recursive calls will be added. we want separate list for each path and we should also be able to back track to a previous level.
	
	the if condition inside for loop prevents indexout of bountds and using duplicates
	*/
	
	TC: O(nlogn) + O(Branch(n) ^ Depth(n) ) space: O(number of elements in the array)
	