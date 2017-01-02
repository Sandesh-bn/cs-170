Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

class TreeNode{
    int val;
    TreeNode left, right;
    public TreeNode(int v){
        val = v;
    }
}

public int sumOfLeftLeaves(TreeNode root){
    if (root == null) return 0;
    Deque<TreeNode> stack = new LinkedList<>();
    int res = 0;
    stack.push(root);
    while(!stack.isEmpty()){
        TreeNode n = stack.pop();
        if (n.left != null){
            if (n.left.left == null && n.left.right == null)
                res += n.left.val;
            else
                stack.push(n.left);
        }
        if (n.right != null){
            if (n.right.left != null || n.right.right != null)//##BE CAREFUL
                stack.push(n.right);
        }
    }
    return res;
}

// for every node you pop, if the left child is a leaf node, add its value to res
if the left child is not a leaf node and not null add left child to stack
if right child is not null  
    if right child has atleast one child add it to stack