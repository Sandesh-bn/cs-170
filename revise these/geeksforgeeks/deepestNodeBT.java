


int deepestLevel;
int value;

public int deepestNode(TreeNode root){
    helper(root, 0);
    return value;
}

public void helper(TreeNode root, int level){
    if (root != null){

        level++;
        helper(root.left, level);

        if (level > deepestLevel){
            value = root.data;
            deepestNode = level;
        }

        helper(root.right, level);
    }
}