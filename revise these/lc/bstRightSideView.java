// I perform breadth first traversal and if it's the first item that was 
// added into the queue at every level then i add it to result list
// but i add the elements into the queue in reverse order 

public List<List<Integer>> rightSideView(TreeNode root){
	List<Integer> result = new ArrayList<>();
	if (root == null) return result;
	Queue<TreeNode> q = new LinkedList<>();
	q.offer(root);
	while (!q.isEmpty()){
		int size = q.size();
		for (Int i = 0; i < size; i++){
			TreeNode frontNode = q.poll();
			if (i == 0)result.add(frontNode.value);
			if (frontNode.right != null)q.offer(frontNode.right);
			if (frontNode.left != null)q.offer(frontNode.left);
		}
	}
	return result;
}