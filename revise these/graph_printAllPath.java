//http://www.geeksforgeeks.org/find-paths-given-source-destination/
import java.util.*;
class Main {
  public static void main(String[] args) {
    System.out.println("hello world");
        Graph g = new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(0, 3);
    g.addEdge(2, 0);
    g.addEdge(2, 1);
    g.addEdge(1, 3);
 
    int s = 2, d = 3;
    
    g.findAllPath(s, d);
  }
}

class Graph{
	private int V;
	private LinkedList<Integer> adjacencyList[];
	boolean visited[];
	public Graph(int V){
		this.V = V;
		adjacencyList = new LinkedList[V];
		visited = new boolean[V];
		for (int i = 0; i < V; i++)
			adjacencyList[i] = new LinkedList<>();

	}

	void addEdge(int V, int W){
		adjacencyList[V].add(W);
	}

	Stack<Integer> stack = new Stack<>();
	
	public void findAllPath(int s, int d){
		findAllPath(this, s, d, visited);
	}
	public void findAllPath(Graph graph, int s, int d, boolean[] visited){
		stack.add(s);
		if (s == d)
			printStack(stack);

		visited[s] = true;
/*
		Iterator iter = adjacencyList[s].iterator();

		while (iter.hasNext()){
			int neighbor = (int)iter.next();
		}

*/
		for (int neighbor: adjacencyList[s]){
			if (!visited[neighbor])
				findAllPath(graph, neighbor, d, visited);
		}

		visited[s] = false;
		stack.pop(); // backtracking to preevious node
	}

	private void printStack(Stack<Integer> stack) {
		System.out.println("Print Path ");
		Object[] array = stack.toArray();
		System.out.println(Arrays.toString(array));
	}

}