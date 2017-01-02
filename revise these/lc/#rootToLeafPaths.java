Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

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
   
    
    public List<String> binaryTreePaths(TreeNode root){
        List<String> result = new ArrayList<>();
        if (root != null)
            dfs(result, "", root);
        return result;
    }
    
    public void dfs(List<String> result, String path, TreeNode root){
        if (root.left == null && root.right == null)
            result.add(path + root.val);
        if (root.left != null)
            dfs(result, path + root.val + "->", root.left);
        if (root.right != null)
            dfs(result, path + root.val + "->", root.right);
    }
    
    
    
}