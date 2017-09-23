http://www.geeksforgeeks.org/continuous-tree/


A tree is Continuous tree if in each root to leaf path, absolute difference between keys of two adjacent is 1. We are given a binary tree, we need to check if tree is continuous or not.

Examples:

Input :              3
                    / \
                   2   4
                  / \   \
                 1   3   5
Output: "Yes"

// 3->2->1 every two adjacent node's absolute difference is 1
// 3->2->3 every two adjacent node's absolute difference is 1
// 3->4->5 every two adjacent node's absolute difference is 1

Input :              7
                    / \
                   5   8
                  / \   \
                 6   4   10
Output: "No"

// 7->5->6 here absolute difference of 7 and 5 is not 1.
// 7->5->4 here absolute difference of 7 and 5 is not 1.
// 7->8->10 here absolute difference of 8 and 10 is not 1.


boolean isContintous(TreeNode node){
    if (node == null)
        return true;

    if (node.left == null && node.right == null)
        return true;
    
    if (node.left == null)
        return (Math.abs(node.val - node.right.val) == 1) &&
                isContinous(node.right);

    if (node.right == null)
        return (Math.abs(node.val - node.left.val) == 1) &&
            isContinous(node.left);

    return Math.abs(node.val - node.left.val) ==1 &&
           Math.abs(node.val - node.right.val) == 1 &&
           isContinous(node.left) &&
           isContinous(node.right);
}