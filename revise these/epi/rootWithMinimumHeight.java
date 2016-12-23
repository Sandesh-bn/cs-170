http://www.geeksforgeeks.org/roots-tree-gives-minimum-height/
import java.util.*;
class Main {
 public static void main(String[] args) {
  System.out.println("hello world");
  //Graph g = new Graph(4);
  Graph g = new Graph(6);
  g.addEdge(0, 3);
  g.addEdge(1, 3);
  g.addEdge(2, 3);
  g.addEdge(4, 3);
  g.addEdge(5, 4);
  System.out.println(g.rootForMinHeight());


  //g.findReachableNodes(arr, arr.length);
 }
}
class Graph {
 private int V;
 private LinkedList < Integer > adjacencyList[];
 int[] degree;

 public Graph(int size) {
  this.V = size;
  adjacencyList = new LinkedList[V];
  for (int i = 0; i < V; i++)
   adjacencyList[i] = new LinkedList();

  degree = new int[V];
  for (int i = 0; i < V; i++)
   degree[i] = 0;
 }

 public void addEdge(int v, int w) {
  adjacencyList[v].add(w);
  adjacencyList[w].add(v);
  degree[v]++;
  degree[w]++;
 }

 public List < Integer > rootForMinHeight() {
  Queue < Integer > q = new LinkedList < > ();
  for (int i = 0; i < V; i++) {
   if (degree[i] == 1)
    q.offer(i);
  }

  while (V > 2) {
   for (int i = 0; i < q.size(); i++) {
    int node = q.poll();
    V--;
    for (int neighbor: adjacencyList[node]) {
     degree[neighbor]--;
     if (degree[neighbor] == 1)
      q.offer(neighbor);
    }
   }
  }

  List < Integer > res = new ArrayList < > ();
  while (!q.isEmpty()) {
   res.add(q.poll());
  }
  return res;
 }


}