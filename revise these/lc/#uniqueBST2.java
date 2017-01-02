Unique Binary Search Trees II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 71161
Total Submissions: 233381
Difficulty: Medium
Contributors: Admin
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
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