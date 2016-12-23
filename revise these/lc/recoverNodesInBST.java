Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

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
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode firstSwap = null, lastSwap = null, prevNode = null;
        
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prevNode != null && prevNode.val > root.val){
                if (firstSwap == null) firstSwap = prevNode;
                lastSwap = root;
            }
            prevNode = root;
            root = root.right;
        }
        int temp = firstSwap.val;
        firstSwap.val = lastSwap.val;
        lastSwap.val = temp;
    }
    
}