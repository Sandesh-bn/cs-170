//http://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-a-given-graph/
class Graph{
	private int v;
	private LinkedList<Integer> aj[];
	public Graph(int v){
		this.v = v;
		aj = new LinkedList[v];
		for(int i = 0; i < v; i++)
			aj[i] = new LinkedList<>();
	}
	
	public void addEdge(int v, int w){
		aj[v].add(w);
	}
	
	public boolean isReachable(int s, int d){
		LinkedList<Integer> temp;
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		
		while (!q.isEmpty()){
			int node = q.poll();
			for (int neighbors: aj[node]){
				if (neighbors == d)
					return true;
				if (!visited.contains(neighbors)){
					visited.add(neighbors);
					q.offer(neighbors);
				}
			}
		}
		return false;
		
	}
}