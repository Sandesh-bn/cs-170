
http://www.geeksforgeeks.org/depth-deepest-odd-level-node-binary-tree/
Input : 10
       /     \
     28       13
            /     \
          14       15
                  /  \
                 23   24
Output : 3


Here is my approach,correct me if i am wrong.

Find out depth, consider it as n, if n is even return n-1 else return n.
 
But what if the (n-1)th level which is odd has no leaf i.e. it may be a full binary tree..
 
Well ,I assumed deepest odd level node because the heading of the problem is "Depth of the deepest odd level node in Binary Tree", but missed the description where they mentioned it as odd level leaf.

Thank you for letting me know .


boolean isLeaf(TreeNode n){
    return (n.left == null && n.right == null);
}

public int deepestOddLevelDepth(Node n, int currLevel){

    if (n == null)
        return 0;

    currLevel += 1;

    if ( currLevel % 2 != 0 && isLeaf(n) )
        return currLevel;
    
    return Math.max(deepestOddLevelDepth(n.left, currLevel),
                    deepestOddLevelDepth(n.right, currLevel));
}

public deepestOddLevelDepth(Node root){
    return deepestOddLevelDepth(root, 0);
}