boolean rootToLeafSequence(TreeNode root, int arr[], int n, int index){

    if (root == null)
        return n == 0;

    // if leaf node's value matches last value in the array, return true'
    if ((root.left == null && root.right == null) &&
        (root.val == arr[index]) && (index == n - 1))
        return true;

    return (index < n) &&
           (root.val == arr[index]) &&
           ( rootToLeafSequence(root.left, arr, n, index + 1)
           ||( rootToLeftSequence(root.right, arr, n, index + 1)));
    
}