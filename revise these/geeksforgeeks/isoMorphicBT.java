

public boolean isIsoMorphic(TreeNode n1, TreeNode n2){
    if (n1 == null || n2 == null)
        return n1 == n2;
    
    if (n1.val != n2.val )
        return false;
    return
        (isIsoMorphic(n1.left, n2.left) &&
        isIsoMorphic(n1.right, n2.right)) ||
        (isIsoMorphic(n1.left, n2.right) &&
        isIsoMorphic(n1.right, n2.left));

}