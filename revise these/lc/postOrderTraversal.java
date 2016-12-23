Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1]


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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)return result;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            if(root != null){
              stack.push(root);
              result.add(0, root.val);
              root = root.right;
            }
            else
             root = stack.pop().left;
        }
        return result;
    }
}