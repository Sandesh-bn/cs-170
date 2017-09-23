
http://www.geeksforgeeks.org/find-distance-two-given-nodes/
https://gist.github.com/kanrourou/7c39c5af15bf20946e3b

Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca) 
'n1' and 'n2' are the two given keys
'root' is root of given Binary Tree.
'lca' is lowest common ancestor of n1 and n2
Dist(n1, n2) is the distance between n1 and n2.

class Main{
  public static void main(String[] ar){
    TreeNode n = new TreeNode(1);
    n.left = new TreeNode(2);
    n.right =new TreeNode(3);
    n.left.left = new TreeNode(4);
    n.left.right = new TreeNode(5);
    n.right.left = new TreeNode(6);
    n.right.right = new TreeNode(7);
    n.right.left.right = new TreeNode(8);
    System.out.println(findDistanceBwNodes(n, n.left.left, n.left.right));
    System.out.println(findDistanceBwNodes(n, n.left.left, n.right.left));
    System.out.println(findDistanceBwNodes(n, n.right, n.left.left));
    System.out.println(findDistanceBwNodes(n, n.left, n.left.left));
    System.out.println(findDistanceBwNodes(n, n.right.left.right, n.left.right));
    
  }
  
  public static int findDistanceBwNodes(TreeNode root, TreeNode node1, TreeNode node2) {

		if (root == null || node1 == null || node2 == null)
			return -1;
		TreeNode ancestor = lca(root, node1, node2);
		int depth1 = getDepth(root, ancestor); 
		int depth2 = getDepth(root, node1); 
		int depth3 = getDepth(root, node2); 
		return depth2 + depth3 - 2 * depth1;

	}

	static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
     if (p == root || q == root || root == null) return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left == null && right == null) return null;
        if (left != null && right != null) return root;
        return (left != null)?left:right;
  }

	private static int getDepth(TreeNode curr, TreeNode target) {
		if (curr == null)
			return -1;
		if (curr == target)
			return 0;
		int left = getDepth(curr.left, target);
		int right = getDepth(curr.right, target);
		if (left == -1 && right == -1)
			return -1;
		return left == -1? right + 1: left + 1;

	}
}


class TreeNode{
  TreeNode right, left;
  int val;
  public TreeNode(int v){
    this.val = v;
  }
}