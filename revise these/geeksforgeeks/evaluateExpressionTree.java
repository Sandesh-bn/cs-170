
http://www.geeksforgeeks.org/evaluation-of-expression-tree/

double evaluateExpression(TreeNode root){
    if (root == null)
        return 0;

    if (root.left == null && root.right == null)
        return root.data;

    leftVal = evaluateExpression(root.left);

    rightVal = evaluateExpression(root.right);

    if (root.data == '+')
        return leftVal + rightVal;

    else if (root.data == '-')
        return leftVal - rightVal;
    
    else if (root.data == '*')
        return leftVal * rightVal;

    else 
        reutrn leftVal / rightVal;
    
}