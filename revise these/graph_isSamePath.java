// http://www.geeksforgeeks.org/check-if-two-nodes-are-on-same-path-in-a-tree/
2:50 video
import java.util.*;
class graph_isSamePath {
  public static void main(String[] args) {
    System.out.println("hello world");
   	
   	
   	
   	Graph graph = new Graph(7);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    
    
    graph.addEdge(4, 7);
    graph.addEdge(2, 5);
    graph.addEdge(3, 6);
    
    //dfs
    //graph.dfsRecursive(1);
    
    // same path
    graph.dfsSamePath(1);
    System.out.println(graph.check(1, 5));
    System.out.println(graph.check(1, 6));
    System.out.println(graph.check(2, 6));
  }
}

class Graph {
	private int V;
	private LinkedList<Integer> adjacencyList[];
	int inttime[] ;
	
	int outtime[] ;
	public Graph(int size){
		this.V = size + 1;
		adjacencyList = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adjacencyList[i] = new LinkedList();
			
	inttime= new int[V];
	outtime= new int[V];
	}
	
	public void addEdge(int v, int w){
		adjacencyList[v].add(w);
	}
	
	
	// Same path algorithm
	
	// Iterative dfs doesn't work
	int timer = 0;
	public void dfsSamePath(int source){
		boolean visited[] = new boolean[V];
		dfsSamePath(source, visited);
	}
	
	public void dfsSamePath(int vertex, boolean visited[]){
		visited[vertex] = true;
		timer++;
		System.out.println("v: " + vertex);
		inttime[vertex] = timer;
		
		for (int neighbor: adjacencyList[vertex]){
			if (!visited[neighbor]){
				visited[neighbor] = true;
				dfsSamePath(neighbor, visited);
			}
		}
		++timer;
		outtime[vertex] = timer;
	}
	
	public boolean check(int u, int v){
		return  ((inttime[u] < inttime[v] && outtime[u] > outtime[v]) ||
		(inttime[v] < inttime[u] && outtime[v] > outtime[u]));
	}
}