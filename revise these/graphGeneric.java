import java.util.*;
class Main {
  public static void main(String[] args) {
    System.out.println("hello world");
		/*Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

		g.bfs(2);
		System.out.println();
		g.dfs(2);*/
		 Graph<Character> g0 = new Graph<>('a');
        Graph<Character> g1 = new Graph<>('b');
        Graph<Character> g2 = new Graph<>('c');
        Graph<Character> g3 = new Graph<>('d');

        g0.addNode(g1);
        g0.addNode(g2);

        g1.addNode(g2);

        g2.addNode(g0);
        g2.addNode(g3);

        g3.addNode(g3);

        System.out.print(g2.printBreadthFirst());
  }
}



class Graph <T>{
    private T node;
    private LinkedList<Graph> adj;

    Graph(T node) {
        this.node = node;
        adj = new LinkedList<Graph>();
    }

    public void addNode(Graph<T> item){
        adj.add(item);
    }

    public LinkedList<Graph> getAdj(){
        return adj;
    }

    public T getNode(){
        return node;
    }

    public String printBreadthFirst(){
        HashMap<Graph, Boolean> map = new HashMap<>();
        LinkedList<Graph> queue = new LinkedList<>();

        queue.add(this);
        map.put(this, true);

        StringBuilder str = new StringBuilder();
        str.append(this.getNode());

        while(!queue.isEmpty()){
            Graph popped = queue.removeFirst();
            LinkedList<Graph> connected = popped.getAdj();

            for (Graph g : connected) {
                if(!map.containsKey(g)){
                    map.put(g,true);
                    queue.add(g);
                    str.append(" -> ");
                    str.append(g.getNode());
                }
            }
        }
        return str.toString();
    }
}
