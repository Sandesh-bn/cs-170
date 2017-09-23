import java.util.*;
class Main{
  public static void main(String[] args){
    
    TreeNode n = new TreeNode('A');
    n.left =  new TreeNode('B');
    n.right =  new TreeNode('C');
    n.left.left = new TreeNode('D');
    n.left.right = new TreeNode('E');
    n.right.right = new TreeNode('B');
    n.right.right.left = new TreeNode('D');
    n.right.right.right = new TreeNode('E');
    System.out.println(serialize(n));
    System.out.println(fun(n));
    System.out.println(s);
    System.out.println(set);
    
    if (flag)
      System.out.println("yes");


  }


  // my own serialize method is not working.
  static Set<String> s = new HashSet<>();
  static boolean flag = false;
  public static String serialize(TreeNode node){
    StringBuilder sb = new StringBuilder();
    helper(sb, node);
    return sb.toString();
  }
  
  private static void helper(StringBuilder sb, TreeNode n){
    if (n == null){
      sb.append("$");
      return;
    }
    
    sb.append(n.val );
    if (sb.length() >= 3 && s.contains(sb.toString())){
      flag = true;
      return;
    }
    s.add(sb.toString());
    helper(sb, n.left);
    helper(sb, n.right);
  }
  

  // java version of geeksforgeeks code. couldn't understand it.
  static Set<String> set = new HashSet<>();
  static String fun(TreeNode root){
    String s = "";
    if (root == null)
      return s + "$";//"null,";
      
    String lstr = fun(root.left);
    if (lstr.equals(s))
      return s;
    
    String rstr = fun(root.right);
    if (rstr.equals(s))
      return s;
      
    s = s + root.val + lstr + rstr;
    //s = s + "," + root.val + "," + lstr + "," + rstr;
    
    if (s.length() > 3 && set.contains(s))
      return "";
    set.add(s);
    return s;
  }
  

}

class TreeNode{
  TreeNode left, right;
  char val;
  public TreeNode(char v){
    this.val = v;
  }
  
  
}