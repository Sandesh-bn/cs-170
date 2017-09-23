

public boolean isFullTree(TreeNode node){
    if (node == null)
        return true;

    if (node.left == null && node.right == null)
        return true;

    if ((node.left != null) && node.right != null)
        return (isFullTree(node.left) && isFullTree(node.right));

    return false;
}