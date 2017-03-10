
https://www.youtube.com/watch?v=qjD-CmuC0MQ
public void printAllAncestor(TreeNode root, TreeNode x){
    helper(root, x);
}

public int helper(TreeNode curr, TreeNode x){
    if (curr == null)
        return 0;

    if (curr.val == x.val)
        return 1;
    
    if (helper(curr.left, x) || helper(curr.right, x)){
        System.out.println(curr.val);
        return 1;
    }
    return 0;
}