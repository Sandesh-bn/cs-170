

public int helper(TreeNode node, int data, int level){
    if (node == null)
        return 0;

    if (node.val == data)
        return level;

    int childLevel = helper(node.left, data, level + 1);
    if (childLevel != 0)
        return childLevel;

    childLevel = helper(node.right, data, level + 1);
    return childLevel;

    
}

public int getLevel(TreeNode node, int data){
    return helper(node, data, 1);
    }