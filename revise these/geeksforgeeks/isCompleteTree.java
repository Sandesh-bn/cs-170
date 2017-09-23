Given a Binary Tree, write a function to check whether the given Binary Tree is Complete Binary Tree or not.

A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible. See following examples.

The following trees are examples of Complete Binary Trees
    1
  /   \
 2     3
  
       1
    /    \
   2       3
  /
 4

       1
    /    \
   2      3
  /  \    /
 4    5  6
The following trees are examples of Non-Complete Binary Trees
    1
      \
       3
  
       1
    /    \
   2       3
    \     /  \   
     4   5    6

       1
    /    \
   2      3
         /  \
        4    5
Source: Write an algorithm to check if a tree is complete binary tree or not

The method 2 of level order traversal post can be easily modified to check whether a tree is Complete or not. To understand the approach, let us first define a term ‘Full Node’. A node is ‘Full Node’ if both left and right children are not empty (or not NULL).
The approach is to do a level order traversal starting from root. In the traversal, once a node is found which is NOT a Full Node, all the following nodes must be leaf nodes.
Also, one more thing needs to be checked to handle the below case: If a node has empty left child, then the right child must be empty.

    1
  /   \
 2     3
  \
   4




public boolean isComplete(TreeNode node){
    if(node == null)
        return true;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(node);

    boolean isNonFullSeen = false; // is true when we encounter a non complete node

    while(!queue.isEmpty()){
        TreeNode n = queue.poll(); 

        if (n.left != null){

            // if we already encounter a non complete node and
            // we encounter a left child
            if (isNonFullSeen)
                return false;
            q.offer(n.left);
        }
        else
            isNonFullSeen = true;// there was no left child, so current node is non full.
        
        if (n.right != null){

            if (isNonFullSeen)
                return false;
            q.offer(n.right);
        }
        else
            isNonFullSeen = true;
    }

    // entire tree has only complete nodes.
    return true;
}