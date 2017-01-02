Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 
public List<List<Integer>> pathSum(TreeNode root, int sum){
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    dfs(res, new ArrayList<>(), root, sum);
    return res;
}
public void dfs(List<List<Integer>> res, List<Integer> path, TreeNode curr, int sum){
    if (curr == null) return;
    sum -= curr.val;
    if (curr.left == null && curr.right == null && sum == 0)
        res.add(path);
    dfs(res, path, curr.left, sum);
    dfs(res, path, curr.right, sum);
    path.remove(path.size() - 1);
}
