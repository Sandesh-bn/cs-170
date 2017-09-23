
Given a Binary Tree, print all nodes that don’t have a sibling (a sibling is a node that has same parent. In a Binary Tree, there can be at most one sibling). Root should not be printed as root cannot have a sibling.
public void printSingleChilds(TreeNode root){
    if (root == null)
        return;
    
    if (root.left != null && root.rigth != null){
        printSingleChilds(root.left);
        printSingleChilds(root.right);
    }

    else if (root.right != null){
        System.out.println(node.right.val + " ");
        printSingleChilds(node.right);
    }

    
    else if (root.left != null){
        System.out.println(node.left.val + " ");
        printSingleChilds(node.left);
    }
}