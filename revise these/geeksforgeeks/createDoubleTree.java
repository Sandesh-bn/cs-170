So the tree…

    2
   / \
  1   3
is changed to…

       2
      / \
     2   3
    /   /
   1   3
  /
 1
And the tree

            1
          /   \
        2      3
      /  \
    4     5
is changed to

               1
             /   \
           1      3
          /      /
        2       3
      /  \
     2    5
    /    /
   4   5
  /   
 4  

public void doubleTree(TreeNode node){
    Node oldLeft;

    if (node == null)
        return;
    
    doubleTree(node.left);
    doubleTree(node.right);

    oldLeft = node.left;
    node.left = new Node(node.val);
    node.left.left = oldLeft;
}