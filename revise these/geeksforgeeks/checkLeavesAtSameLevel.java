

public boolean isLeavesSameLevel(TreeNode node){

    int height = getHeight(node);
    return checkSameLevel(node, height, 1);
}

public boolean checkSameLevel(TreeNode root, int height, int currLevel){

    if (root == null)
        return true;
    
    if (root.left == null && root.right == null){
        if (currLevel == height)
            return true;
        else
            return false;
    }

    return checkSameLevel(root.left, height, currLevel + 1) &&
        checkSameLevel(root.right, height, currLevel + 1);
}

public int getHeight(TreeNode n){
    if (n == null)
        return 0;
    return 1 + Math.max(getHeight(n.left), getHeight(n.right));
}