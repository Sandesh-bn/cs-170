
int currSum;
boolean subTreeSum(TreeNode n, int sum){
    currSum = 0;

    return helper(n, sum);
}

boolean helper(TreeNode n, int sum){
    if (n == null){
        currSum = 0;
        return false;
    }

    int sumLeft = 0, rightSum = 0;

    return (helper(n.left, ))
}