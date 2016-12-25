Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

public static List<List<Integer>> combinationSum3(int k, int n){
		 List<List<Integer>> result = new ArrayList<>();
		 int[] arr = new int[9];
		 for (int i = 0; i < 9; i++)
			 arr[i] = i + 1;
		 dfs(result, new ArrayList<>(), arr,  n, 0, k);
		 return result;
	 }
	 public static void dfs(List<List<Integer>> result, List<Integer> path, int[] candidates, int remaining, int index, int k){
		 if (remaining <= 0){
			 if (remaining == 0 && path.size() == k)
				 result.add(path);
			 return;
		 }
		 for (int i = index; i < candidates.length; i++){
			 if (i > index && candidates[i] == candidates[i - 1])continue;
			 List<Integer> newPath = new ArrayList<>(path);
			 newPath.add(candidates[i]);
			 dfs(result, newPath, candidates, remaining - candidates[i], i + 1, k);
		 }
	 }