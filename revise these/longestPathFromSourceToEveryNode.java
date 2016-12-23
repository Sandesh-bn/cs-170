//http://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/
import java.util.*;
class Node{
	int data, weight;
}

class Graph{
	int V;
	LinkedList<Node> lists[];
	public Graph(int V){
		this.V = V;
		this.lists = new LinkedList[V];
		for (int i = 0; i < V; i++)
			lists[i] = new LinkedList<>();
	}
	
	
	void printGraph() {
		int i = 0;
		for(LinkedList<Node> l : lists) {
			System.out.print(i++ + " : ");
			for(Node node : l)
				System.out.print(node.data + "(" + node.weight + ") ");
			System.out.println();
		}
	}
 
 
	public void addEdge(int u, int v, int weight){
		Node node = new Node();
		node.data = v;
		node.weight = weight;
		lists[u].add(node);
	}
	
	List<Integer> topologicalsort(){
		boolean[] visited = new boolean[V];
		LinkedList<Integer> res = new LinkedList<>();
		for (int i = 0; i < V; i++){
			if(!visited[i])
				helperTSort(i, visited, res);
		}
		return res;
	}
	
	public void helperTSort(int u, boolean[] visited, LinkedList<Integer> res){
		visited[u] = true;
		for (Node node: lists[u]){
			if (!visited[node.data])
				helperTSort(node.data, visited, res);
		}
		res.addFirst(u);
	}
	
	public void printLongestDistance(int s){
		int[] dist = new int[V];
		int[] parent = new int[V];
		
		for (int i = 0; i < V; i++){
			dist[i] = Integer.MIN_VALUE;
			parent[i] = -1;
		}
		dist[s] = 0;
		
		List<Integer> res = topologicalsort();
		
		for (int node: res){
			for (Node neighbor: lists[node]){
				if (dist[neighbor.data] < dist[node] + neighbor.weight){
					dist[neighbor.data] = dist[node] + neighbor.weight;
					parent[neighbor.data] = node;
				}
			}
		}
		
		
		for (int i = 0; i < V; i++){
			if (dist[i] == Integer.MIN_VALUE)
				System.out.println(i + ": INF\tPath: ");
			else
				System.out.println(i + " : " + dist[i] + "\tPath: ");
			
			Stack<Integer> st = new Stack<>();
			int j = i;
			while (parent[j] != -1){
				st.push(j);
				j = parent[j];
			}
			
			if (dist[i] != Integer.MIN_VALUE)
				st.push(s);
			
			while (!st.isEmpty())
				System.out.print(st.pop() + " ");
			
			System.out.println();
		}
	}
}

class Main {
  public static void main(String[] args) {
		int V = 6;
		Graph g = new Graph(V);
 
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 3, 6);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 5, 1);
		g.addEdge(3, 4, -1);
		g.addEdge(4, 5, -2);
 
		System.out.println("Graph:");
		g.printGraph();
 
		int s = 1;
		System.out.println("\nsource:" + s);
		System.out.println("Distances:");
		g.printLongestDistance(s);
	}
}

