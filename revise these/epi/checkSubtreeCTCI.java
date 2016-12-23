http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
https://www.youtube.com/watch?v=J29eAoniIsw


boolean isSubTree(TreeNode t1, TreeNode t2){
	StringBuilder t1PreOrderString = new StringBuilder();
	StringBuilder t2PreOrderString = new StringBuilder();
	
	getPreOrderString(t1, t1PreOrderString);
	getPreOrderString(t2, t2PreOrderString);
	
	return t1PreOrderString.indexOf(t2PreOrderString.toString()) != -1;
}

void getPreOrderString(TreeNode node, StringBuilder sb){
	if (node == null){
		sb.append("X");
		return;
	}
	sb.append(node.data + " ");
	getPreOrderString(node.left, sb);
	getPreOrderString(node.right, sb);
}