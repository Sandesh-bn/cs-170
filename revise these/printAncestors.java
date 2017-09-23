

public boolean printAncestors(TreeNode root,  int X){

    if (root == null)
        return false;

    if (root.val == X)
        return true;

    if (printAncestors(root.left, X)
        || printAncestors(root.right, X)){
            System.out.println(root.val + " ");
            return true;
        }
    return false;
}