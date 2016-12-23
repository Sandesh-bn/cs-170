Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

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
    public int sumNumbers(TreeNode root) {
     int result = 0;
     if (root == null) return result;
     Deque<TreeNode> stack = new LinkedList<>();
     stack.offer(root);
     while(!stack.isEmpty()){
         TreeNode node = stack.pop();
         if (node.right != null){
             node.right.val = 10 * node.val + node.right.val;
             stack.push(node.right);
         }
         if (node.left != null){
             node.left.val = 10 * node.val + node.left.val;
             stack.push(node.left);
         }
         if (node.right == null && node.left == null)
            result += node.val;
     }
     return result;
    }
}