
class Test{
    TreeNode node = new TreeNode(1);
    node.left = new TreeNode(2);
    node.left.left = new TreeNode(4);
    node.left.right = new TreeNode(5);

    node.right = new TreeNode(3);
    node.right.left = new TreeNode(6);
    node.right.right = new TreeNode(7);
}


class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int k){
        this.value = k;
    }

    public void printBoundary(){
        preOrderLeft();
        inorderLeaves();
        postOrderRight();
    }

    private boolean isLeaf(TreeNode node){
        if (node == null) return false;
        if (node.left == null && node.right == null)
            return true;
        return false;
    }

    public void preOrderLeft(){
        if (this != null && !isLeaf(this))// skip leaf nodes because you are printing in inorder
            System.out.print(value + "->");
        if (left != null)
            left.preOrderLeft();
    }

    public void inorderLeaves(){
        if (this == null)return;
        if (left != null)
            left.inorderLeaves();
        if (left == null && right == null)
            System.out.print(value + "->");
        if (right != null)
            right.inorderLeaves();
    }


    public void postOrderRight(){
        if (right != null && !isLeaf(this))// skip leaf nodes because you are printing in inorder
            right.postOrderRight();
        if (this != null)
            System.out.print(value + "->");

            
        
    }
}
