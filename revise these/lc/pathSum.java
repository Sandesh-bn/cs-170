Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

contiguous array

public int findMaxLen(int[] A){
	for (int i = 0; i < N; i++)
		if (A[i] == 0)
			A[i] = -1;
	Map<Integer, Integer> sumIndex = new Hashmap<>();
	sumIndex.put(0, -1);
	int sum = 0, maxLen = 0;
	for (int i = 0; i < N; i++){
		sum += A[i];

		if (sumIndex.containsKey(sum))
			maxLen = Math.max(maxLen, i - sumInde.get(i));
		else
			sumIndex.put(sum, i);
	}
	return maxLen;
}

 I 

public LIst<List<Integer>> subset(Int[] arr){
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> temp = new ArrayList<>();
	res.add(temp);
	int begin = 0;
	Arrays.sort(nums);
	for (int i = 0; i < N; i++){
		if (i == 0 || nums[i] != nums[i - 1])
			begin = 0;
		size = res.size();
		for (int j = begin;j < size; j++){
			List<Integer> temp = new ArrayList<>(res.get(j));
			temp.add(nums[i]);
			res.add(temp);
		}
		begin = size;
	}
	return res;
}
public List<List<Integer>> pathSum(TreeNode root, int target){
	List<List<Integer>> result = new ArrayList<>();
	if (root == null)
		return result;;
	dfs(root, result, new ArrayList<>(), int target);
	return result;
}

public void dfs(TreeNode curr, List<List<Integer>> result, List<Integer> path, int remaining){
	if (curr == null) return;
	remaining -= curr.val;
	
	if (curr.left == null && curr.right == null && remaining == 0)
		result.add(new ArrayList<>(path)); 
	// IMPORTANT ^^^^^^^^^^^^^^^^^^^^^^^   #########################################################################
	
	dfs(curr.left, result, path, remaining);
	dfs(curr.right, result, path, remaining);
	path.remove(path.size() - 1);
	
}
