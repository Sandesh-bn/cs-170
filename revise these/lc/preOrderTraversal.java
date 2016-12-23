Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) return result;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.right != null)stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            result.add(node.val);
        }
        return result;
    }
}