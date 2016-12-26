public TreeNode upsideDown(TreeNode root){
	Deque<TreeNode> stack = new Stack<>();
	while(root != null){
		stack.push(root);
		root = root.left;
	}
	TreeNode curr = new TreeNode(0);
	TreeNode head = curr;
	
	while (!stack.isEmpty()){
		TreeNode node = stack.pop();
		curr.right = node;
		if (!stack.isEmpty())
			node.left = stack.peek().right;
		curr = curr.right;
	}
	return head.right;
}