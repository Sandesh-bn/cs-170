private int maxSoFar = Integer.MIN_VALUE;
public int longestConsecutive(TreeNode root){
	if (root == null) return 0;
	dfs(root, 0, root);
	return result;
}

private void dfs(TreeNode root, int curr, TreeNode prev){
	if (root == null)
		return;
	if (root.val == prev.val + 1)
		curr++;
	else
		curr = 1;
	maxSoFar = Math.max(maxSoFar, curr);
	
	dfs(root.left, curr, root);
	dfs(root.right, curr, root);
}