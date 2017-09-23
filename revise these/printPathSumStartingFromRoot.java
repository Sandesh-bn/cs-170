import java.util.*;
class Main{
  
  public static void main(String[] args){
    TreeNode n = new TreeNode(10);
    n.left = new TreeNode(28);
    n.right = new TreeNode(13);
    n.right.left = new TreeNode(14);
    n.right.left.left = new TreeNode(21);
    n.right.left.right = new TreeNode(22);
    n.right.right = new TreeNode(15);
    n.right.right.left = new TreeNode(23);
    n.right.right.right = new TreeNode(24);
    pathSum(n, 38);
    
  }
  
  
   public static void pathSum(TreeNode root, int sum){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return;// result;
        dfs(root, result, new ArrayList<Integer>(), sum);
        return;// result;
    }
    
    public static void dfs(TreeNode root, List<List<Integer>> result, List<Integer> path, int sum){
        if (root == null) return;
        sum -= root.val;
        path.add(root.val);
        
        //if (root.left == null && root.right == null && sum == 0)
        if (sum == 0)
            System.out.println((path));
        dfs(root.left, result, path, sum);
        dfs(root.right, result, path, sum);
        path.remove(path.size() - 1);
    }
}

class TreeNode{
  TreeNode left, right;
  int val;
  public TreeNode(int v){
    this.val = v;
  }
}