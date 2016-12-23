public interface Graph{
	enum GraphType{
	DIRECTED, UNDIRECTED;
	}
	void addEdge(int v1, int v2);
	List<Integer> getAdjacentVertices(int v);
}

public class AdjacencyMatrixGraph implements Graph{
	private int[][] graph;
	private int numV;
	private GraphType gt = GrapthType.DIRECTED;
	public AdjacencyMatrixGraph(int numv, GraphType gt){
		graph = new int[numv][numv];
		this.numV = numv;
		this.gt = gt;
	}
	public void addEdge(int v1, int v2){
		if (v1 < 0 || v1 >= numV || v2 < 0 ||
		v2 >= numV) throw new runtimeException();

		graph[v1][v2] = 1;
		if (gt == GraphType.UNDIRECTED)
			graph[v2][v1] = 1;
	}

	public List<Integer> getAdjacentVertices(int v){
		List<Integer> result = new ArrayList<>();
		if (v < 0 || v >= numv) throw new RuntimeException();
		for (int i = 0; i < numV; i++)
			if (grapht[v][i] == 1)
				result.add(i);
		return result;
	}
}

public class AdjacencyList implements Graph{
	private List<Node> vertexList = new ArrayList<>();
	private GraphType gt = GraphType.DIRECTED;
	private int numVertices = 0;

	public static class Node {
		private int vertexNumber;
		private Set<Integer> adjacencySet = new HashSet<>();
		public Node(int vertexNumber){
			this.vertexNumber = vertexNumber;
		}
		public int getVertexNumber(){
			return this.vertexNumber;
		}
		public void addEdge(int vertexNumber){
			adjacencySet.add(vertexNumber);
		}
		public List<Integer> getAdjacentVertices(){
			List<Integer> sortedList = new ArrayList<>(adjacencySet);
			Collections.sort(sortedList);
			return sortedList;
		}
	}


	public AdjacencyList(int numVertices, GraphType gt){
		this.numVertices = numVertices;
		this.gt = gt;
		for (int i = 0; i < numVertices; i++)
			vertexList.add(new Node(i));
	}


	public void addEdge(int v1, int v2){
		if (v1 < 0 || v1 >= numVertices || v2 < 0 || v2 >= numVertices)
			throw new RuntimeException();
		vertexList.get(v1).addEdge(v2);

		if (gt == GraphType.UNDIRECTED)
			vertexList.get(v2).addEdge(v1);

	}

	public List<Integer> getAdjacenctVertices(int v){
		if (v < 0 || v >= numVertics)
			throw new RuntimeException("invalid vertex number");

		return vertexList.get(v).getAdjacentVertices();
	}
}