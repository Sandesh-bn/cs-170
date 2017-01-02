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

Subscribe to see which companies asked this question

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 public boolean hasPathSum(TreeNode root, int sum){
     if (root == null) return null;
     if (root.left == null && root.right == null)
        return root.val == sum;
    int rem = root.val - sum;
    return hasPathSum(root.left, rem) || hasPathSum(root.right, rem);
 }