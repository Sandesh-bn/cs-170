http://www.geeksforgeeks.org/print-binary-tree-vertical-order/
public List<List<Integer>> vertical(TreeNode root){
	List<List<Integer>> result = new ArrayList<>();
	if (root == null) 
		return result;
	Map<Integer, List<Integer>> vMap = new HashMap<>();
	Queue<TreeNode> q = new LinkedList<>();
	Queue<Integer> cols = new LinkedList<>();
	q.offer(root);
	cols.offer(0);
	int max = 0, min = 0; //upperbound and lowerbound of columns
	while (!q.isEmpty()){
		TreeNode node = q.poll();
		int col = cols.poll();
		
		if (!vMap.contains(col))
			vMap.put(col, new ArrayList<>());
		vMap.get(col).add(node.val);
		
		if (node.left != null){
			q.offer(node.left);
			cols.offer(col - 1);
			min = Math.min(min, col - 1);
		}
		if (node.right != null){
			q.offer(node.right);
			cols.offer(col + 1);
			max = Math.max(max, col + 1);
		}
		
		
	}
	for (int i = min; i <= max; i++)
			result.add(vMap.get(i));
		return result;
}