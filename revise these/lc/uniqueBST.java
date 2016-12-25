For all possible root of the trees (i.e. 1, 2, ..., n), get the list of left subtrees and list of right subtrees, recursively. Now, for every left and right subtree combination, create a new tree and add to resultant list.

Here, "start > end" becomes the base case for recursion, for which I add "null" as the only element of list, which will form the only possible left or right subtree. (To understand why this works, check with n = 1).

n = 0 is handled separately, since leetcode expects an empty list, rather than a list with a null value.

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
    public List<TreeNode> generateTrees(int n) {
        return (n == 0)?new ArrayList<>():generateTrees(1, n);
    }
    
    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end){
            result.add(null);
            return result;
        }
        
        for (int i = start; i <= end; i++){
            List<TreeNode> leftSubTrees = generateTrees(start, i - 1);
            List<TreeNode> rightSubTrees = generateTrees(i + 1, end);
            for (TreeNode leftSubTree: leftSubTrees){
                for (TreeNode rightSubTree: rightSubTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubTree;
                    root.right = rightSubTree;
                    result.add(root);
                }
            }
        }
        return result;
    }
    
    public List<TreeNode> generateTrees(int n){
        return (n == 0)?new ArrayList<>():genearateTrees(1, n);
    }
    
    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if (start > end){
            result.add(null);
            return result;
        }
        
        for (int i = 1; i <= n; i++){
            List<TreeNode> leftSubtrees = generateTrees(1, i - 1);
            List<TreeNode> rightSubTrees = generateTrees(i + 1, n);
            for (Tree leftSubtree: leftSubtrees){
                for (Tree rightSubtree: rightSubTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubTree;
                    root.right = rightSubtree;
                    result.add(root);
                }
            }
        }
    }
    
    
}



