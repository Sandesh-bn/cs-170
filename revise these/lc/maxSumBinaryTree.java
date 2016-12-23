Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


int maxSum = Integer.MIN_VALUE;

public int maxSum(TreeNode root){
	helper(root);
	return maxSum;
}
public int helper(TreeNode curr){
	if (curr == null) return 0; // base case
	
	int leftSubTreeSum = Math.max(helper(curr.left), 0);
	int rightSubTreeSum = Math.max(helper(curr.right), 0);
	
	maxSum = Math.max(maxSum, curr.value + leftSubTreeSum + rightSubTreeSum);
	
	return curr.value + Math.max(leftSubTreeSum, rightSubTreeSum);
}

