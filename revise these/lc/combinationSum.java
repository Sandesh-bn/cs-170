public List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);// avoid generating duplicates
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, result, new ArrayList<>(), target, 0);
        return result;
    }
    
    public void dfs(int[] candidates, List<List<Integer>> result, List<Integer> path, int remaining, int begin){
        if (remaining <= 0){
            if (remaining == 0) result.add(path);// result found add it to result
            return;// prune the tree
        }
        for (int i = begin; i < candidates.length; i++ ){
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(candidates[i]);
            dfs(candidates, result, newPath, remaining - candidates[i], i);
			
			//dfs (candidates, result, newPath, remaining - candidates[i], i + 1); will prevent adding duplicates in the path
			
			/*
			ie if arr is [1, 2, 3] = the path will not have duplicates of 1/2/3
			at every level we exclude the the element that was added in prev level
			
			
			if we use i then the path can have duplicates of 1, 2, 3
			At every level we have all elements avaialbe
			*/
        }
    }
	
	
	/*
	the given array should not contain duplicats
	but the path can contain duplicates
	at every level all the elements are available for forming a combination 
	so duplicates are allowed within the path
	*/