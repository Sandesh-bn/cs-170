

public TreeNode removeHalfNodes(TreeNode n){
    if (n == null)
        return null;
    
    n.left = removeHalfNodes(n.left);
    n.right = removeHalfNodes(n.right);

    if (n.left == null && n.right == null)
        return n;
    
    if (n.left == null) return n.right;
    
    if (n.right == null) return n.left;

    return n;
}



public static void main(String args[]) 
    {
        TreeNode tree = new TreeNode();
        TreeNode NewRoot = null;
        tree.root = new TreeNode(2);
        tree.root.left = new TreeNode(7);
        tree.root.right = new TreeNode(5);
        tree.root.left.right = new TreeNode(6);
        tree.root.left.right.left = new TreeNode(1);
        tree.root.left.right.right = new TreeNode(11);
        tree.root.right.right = new TreeNode(9);
        tree.root.right.right.left = new TreeNode(4);
  
        System.out.println("the inorder traversal of tree is ");
        tree.printInorder(tree.root);
  
        NewRoot = removeHalfNodes(tree);
  
        System.out.print("\nInorder traversal of the modified tree \n");
        tree.printInorder(NewRoot);
    }