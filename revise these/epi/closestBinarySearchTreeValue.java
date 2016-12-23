public int closestBSTValue(int target, TreeNode root){
	if (root == null) return -1;
	int minVal = root.val;
	ListNode curr = root;
	while (curr != null){
		minVal = Math.min(Math.abs(target - curr.val), Math.abs(target - min));
		if (curr.val < target)
			curr = curr.right;
		else
			curr = curr.left;
	}
	return -1;
}