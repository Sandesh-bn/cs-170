Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).


Recursively find the node that has the same value as the key, while setting the left/right nodes equal to the returned subtree
Once the node is found, have to handle the below 4 cases
node doesn't have left or right - return null
node only has left subtree- return the left subtree
node only has right subtree- return the right subtree
node has both left and right - find the minimum value in the right subtree, set that value to the currently found node, then recursively delete the minimum value in the right subtree#


public TreeNode deleteNode(TreeNode root, int key){
    if (root == null) return null;
    if (key < root.val)
        root.left = deleteNode(root.left, key);
    else if (key > root.val)
        root.right = deleteNode(root.right, key);
    else {

        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
            
        root.val = findMin(root.right);
        root.right = deleteNode(root.right, root.val);
    }
    return root;
}

private int findMin(TreeNode n){
    while(n.left != null)
        n = n.left;
    return n.val;
}