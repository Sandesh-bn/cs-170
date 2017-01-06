Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target

public int closestBSTValue(int target, TreeNode root){
	if (root == null) return -1;
	int minVal = root.val;
	ListNode curr = root;
	while (curr != null){
		if (curr.val == target) return target;
		if (Math.abs(curr.val - target) < Math.abs(minVal - target)){
			minVal = curr.val;
		}
		if (curr.val < target)
			curr = curr.right;
		else
			curr = curr.left;
	}
	return -1;
}