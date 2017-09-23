Given a Binary Tree where each node has positive and negative values. Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree. The values of leaf nodes are changed to 0.

For example, the following tree

                  10
               /      \
	         -2        6
           /   \      /  \ 
	      8     -4    7    5
should be changed to

                 20(4-2+12+6)
               /      \
	        4(8-4)      12(7+5)
           /   \      /  \ 
	      0      0    0    0

public int toSumTree(TreeNode n){
    if (n == null)
        return 0;
    
    int oldVal = n.val;
    n.val = toSumTree(n.left) + toSumTree(n.right);

    return n.val + oldVal;
}