class DisjointSet{
	private Map<Long, Node> map = new HashMap<>();
	class Node{
		long data;
		Node parent;
		int rank;
	}
	
	public void makeSet(long data){
		Node node = new Node();
		node.data = data;
		node.parent = node;
		node.rank = 0;
		map.put(data, node);
	}
	
	public boolean union(long value1, long value2){
		Node node1 = map.get(value1);
		Node node2 = map.get(value2);
		
		Node parentOf1 = findSet(node1);
		Node parentOf2 = findSet(node2);
		
		// value belong to same set
		if (parentOf1.data == parentOf2.data)
			return false;
		
		// set parent of the lower rank to a higher rank parent
		if (parentOf1.rank >=  parentOf2.rank){
			if (parentOf1.rank == parentOf2.rank)
				parentOf1.rank += 1;
			parentOf2.parent = parentOf1;
				
		}
		else
			parentOf1.parent = parentOf2;
		
		return true;
	}
	
	public long findSet(long data){
		return findSetHelper(map.get(data)).data;
	}
	
	public Node findSetHelper(Node node){
		Node parent = node.parent;
		if (parent == node)
			return node;
		node.parent = findSetHelper(node.parent);
		return node.parent;
		
	}
}