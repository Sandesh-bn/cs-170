
import java.util.*;

class Graph{
  
  Map<Integer, Set<Integer>> aj;
  public Graph(){
    aj = new HashMap<>();
  }
  
  public void addEdge(int v, int w){
    if (aj.get(v) == null)
      aj.put(v, new HashSet<>());
    aj.get(v).add(w);
  }
  
  public void bfs(int s){
    Set<Integer> visited = new HashSet<>();
    visited.add(s);
    Queue<Integer> q = new LinkedList<>();
    q.offer(s);
    
    while (!q.isEmpty()){
      int node = q.poll();
      System.out.print(node + " ");
      Iterator<Integer> iter = aj.get(node).iterator();
      
      while (iter.hasNext()){
        int neigh = iter.next();
        
        if (!visited.contains(neigh)){
          visited.add(neigh);
          q.offer(neigh); 
        }
      }
      
    }
    
  }
     public void dfs(int s){
    Set<Integer> visited = new HashSet<>();
    visited.add(s);
    Stack<Integer> st = new Stack<>();
    st.push(s);
    
    while (!st.isEmpty()){
      int node = st.pop();
      System.out.print(node + " ");
      Iterator<Integer> iter = aj.get(node).iterator();
      
      while (iter.hasNext()){
        int neigh = iter.next();
        
        if (!visited.contains(neigh)){
          visited.add(neigh);
          st.push(neigh); 
        }
      }
      
    }
  }
  
  public boolean isCyclic(int s){
	  
  }
  
  
  
}


/// this is a bounded graph. we have to specify the intial size.
class Graph
{
	private int V;
		/*
	private LinkedList<Integer> adjacencyList[];
	public Graph(int V){
		this.V = V;
		adjacencyList = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adjacencyList[i] = new LinkedList();
	}
	  */
	  
	private HashSet<Integer> adjacencyList[];
	public Graph(int V){
		this.V = V;
		adjacencyList = new HashSet[V];
		for (int i = 0; i < V; i++)
			adjacencyList[i] = new HashSet();
	}
	

	void addEdge(int V, int W){
		adjacencyList[V].add(W);
	}

	void bfs(int source){
		boolean visited[] = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		visited[source] = true;
		queue.offer(source);

		while(!queue.isEmpty()){
			int node = queue.poll();
			System.out.print(node + " ");

			Iterator iter = adjacencyList[node].iterator();
			while(iter.hasNext()){
				int neighbor = (Integer)iter.next();

				if (!visited[neighbor]){
					visited[neighbor] = true;
					queue.offer(neighbor);
				}
			}
		}
	}

	void dfs(int source){
		boolean visited[] = new boolean[V];
		Deque<Integer> stack = new LinkedList<>();
		dfsHelper(source, visited);
	}

	void dfsHelper(int vertex, boolean[] visited){
		visited[vertex] = true;
		System.out.print(vertex + " ");
		for (int neighbor: adjacencyList[vertex]){
			if (!visited[neighbor]){
				
				dfsHelper(neighbor, visited);
			}
				
		}
	}
	
	void dfsIterative(int s){
			boolean visited[] = new boolean[V];
			Stack<Integer> stack = new Stack<Integer>();
			visited[s]= true;
			stack.push(s);
			while(!stack.isEmpty()){
				s = stack.pop();
				System.out.print(s+" ");
				Iterator<Integer> i = adjacencyList[s].listIterator();
				while(i.hasNext()){
					int n = i.next();
					if(!visited[n]){
						visited[n]  = true;
						stack.push(n);
					}
				}
			}
		}
		
		public void transitiveClosure(){
			int reachable[][] = new int[V][V];
			
			for (int i = 0; i < V; i++){
				for (int j = 0; j < V; j++){
					reachable[i][j] = (adjacencyList[i].contains(j))?1:0;
				}
			}
			
			for (int k = 0; k < V; i++){
				for (int i = 0; i < V; i++){
					for (int j = 0; j < V; j++){
						reachable[i][j] = (reachable[i][j] != 0) ||
										  ((reachable[i][k] != 0) && (reachable[k][j] != 0))?1:0;
					}
				}
			}
			
			for(int i = 0; i < V; i++)
				System.out.println(Arrays.toString(reachable[i]));
		}
		
		public int[][] getAdjacencyMatrix(){
				int[][] matrix = new int[V][V];
				for (int i = 0; i < V; i++){
					for (int j = 0; j < V; j++){
						matrix[i][j] = (adjacencyList[i].contains(j))?1:0;
					}
				}
				return matrix;
		}
		
		public int[][] getAdjacencyMatrix(){
				int[][] matrix = new int[V][V];
				for (int i = 0; i < V; i++){
					for (int j = 0; j < V; j++){
						matrix[i][j] = (adjacencyList[i].contains(j))?1:0;
					}
				}
				return matrix;
		}
}

class Main {
  public static void main(String[] args) {
    System.out.println("hello world");
    	Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		graph.dfs(2);
		
		
  }
}
