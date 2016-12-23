import java.util.*;
class Main {
  public static void main(String[] args) {
    System.out.println("hello world");
        //Graph g = new Graph(4);
    Graph g = new Graph(7);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 4);
    g.addEdge(3, 1);
    g.addEdge(5, 6);
    g.addEdge(5, 7);
 
    // For every ith element in the arr
    // find all reachable nodes from query[i]
    int arr[] = {2, 4, 5};
 
    
 
    g.findReachableNodes(arr, arr.length);
  }
}
class Graph{
  int componentNum = 0;
	private int V;
	private LinkedList<Integer> adjacencyList[];
	int[] visited;
	Map<Integer, List<Integer>> map;
	public Graph(int size){
		this.V = size + 1;
		adjacencyList = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adjacencyList[i] = new LinkedList();
		visited = new int[V];
		map = new HashMap<>();
	}
	
	public void addEdge(int v, int w){
		adjacencyList[v].add(w);
	}
	
	
	public void findReachableNodes(int[] arr, int V){
		findReachableNodes(this, arr, V);
	//	System.out.println(Arrays.toString(visited));
		//for (Map.Entry<Integer, List<Integer>> entry: map.entrySet())
		  //System.out.println(entry.getKey() + " " + entry.getValue());
	}
	
	public void findReachableNodes(Graph g, int arr[], int n){
	  List<Integer> list = new ArrayList<>();
	  
	  for (int num: arr){
	    if (visited[num] == 0){
	      componentNum++;
	      map.put(componentNum, bfs(componentNum, num) );
	    }
	    System.out.println(map.get(visited[num]));
	  }
	  
	}

	public List<Integer> bfs(int componentNum, int source){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(source);
		visited[source] = componentNum;
		List<Integer> reachableNodes = new ArrayList<>();
		

		while(!queue.isEmpty()){
			int node = queue.poll();
			reachableNodes.add(node);

			for (int  neighbor: adjacencyList[node]){
				if (visited[neighbor] == 0){
					queue.offer(neighbor);
					visited[neighbor] = componentNum;
				}

			}
		}
		//System.out.println("HI " + reachableNodes);
		return reachableNodes;
	}
}

