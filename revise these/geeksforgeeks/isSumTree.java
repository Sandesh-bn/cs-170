

public boolean isSumTree(TreeNode root){

    if (root == null || isLeaf(root))
        return true;

    int lsum = 0, rsum = 0;

    if (root.left != null)
        lsum = isLeaf(root.left)? root.left.data: 2 * root.left.data;
    
    
    if (root.right != null)
        lsum = isLeaf(root.right)? root.right.data: 2 * root.right.data;

    return root.val == lsum + rsum &&
          isSumTree(root.left) && isSumTree(root.right);
}