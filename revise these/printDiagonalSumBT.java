

public void computeDiagSum(TreeNode root){
    Map<Integer, Integer> sumMap = new HashMap<>();
    
    helper(root, 0, sumMap);

    for ()
}

public void helper(TreeNode root, int currDiag,Map<Integer, Integer> sumMap){
    if (root == null)
        return;
    
    helper(root.left, currDiag + 1, sumMap);


    if (!sumMap.containsKey(currDiag))
        sumMap.put(currDiag, 0);
    sumMap.put(currDiag, sumMap.get(currDiag) + root.val);

    helper(root.right, currDiag, sumMap);
}