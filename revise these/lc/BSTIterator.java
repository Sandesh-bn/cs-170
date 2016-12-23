Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Deque<TreeNode> stack;
    TreeNode curr;
    public BSTIterator(TreeNode root) {
        curr = root;
        stack = new LinkedList<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || curr != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        TreeNode temp = stack.pop();
        int returnValue = temp.val;
        curr = temp.right;
        return returnValue;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
 