public class printAllLeafs(TreeNode root){
	if (root == null)
		return;
	if (root.left == null && root.right == null){
		System.out.println(root.val + " ");
		return;
	}
	printAllLeafs(root.left);
	printAllLeafs(root.right);
}