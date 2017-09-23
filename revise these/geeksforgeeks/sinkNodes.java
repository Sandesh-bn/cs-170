Given a Binary Tree having odd and even elements, sink all its odd valued nodes such that no node with odd value could be parent of node with even value. There can be multiple outputs for a given tree, we need to print one of them. It is always possible to convert a tree (Note that a node with even nodes and all odd nodes follows the rule)

Input : 
       1
    /    \
   2      3
Output
       2            2
    /    \   OR   /   \
   1      3      3     1 
  

Input : 
       1
     /    \
    5       8
  /  \     /  \
 2    4   9    10
Output :
    2                 4
  /    \            /    \     
 4       8    OR   2      8    OR .. (any tree with 
/  \    /  \      /  \   / \          same keys and 
5   1  9   10    5    1 9   10        no odd is parent
                                      of even)



we need to swap odd value of a node with even value of one of its descendants. The idea is to traverse the tree in postorder fashion. Since we process in postorder, for each odd node encountered, its left and right subtrees are already balanced (sinked), we check if it’s an odd node and its left or right child has an even value. If even value is found, we swap the node’s data with that of even child node and call the procedure on the even child to balance the subtree. If both children have odd values, that means that all its descendants are odd.



public void sink(TreeNode node){
    if (node == null || isLeaf(node))
        return;

    if (node.left != null && node.left.val % 2 == 0){
        swap(node.val, node.left.val);
        sink(node.left);
    }
    else if (node.right != null && node.right.val % 2 == 0){
        swap(node.val, node.right.val);
        sink(node.right);
    }
}