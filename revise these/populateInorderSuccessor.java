


// algorithm is just reverse inorder traversal


class TreeNode{
    TreeNode left, right, next;
    int val;
    public TreeNode(int v){
        this.val = v;
    }
}

TreeNode succesor = null;

public void populateNext(TreeNode node){
    if (node != null){
        populateNext(node.right);

        node.next = succesor;
        succesor = node;

        populateNext(node.left);
    }
}