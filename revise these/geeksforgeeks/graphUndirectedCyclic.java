https://www.youtube.com/watch?v=6ZRhq2oFCuo

class Graph{
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v){
        this.V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList();

    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    boolean isCyclic(){
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++){
            if (!visited[i])
                if (dfsHelper(i, visited, -1))
                    return true;
        }
        return false;
    }

    boolean dfsHelper(int v, boolean[] visited, int parent){
        visited[v] = true;
        

        for (int k: adj[v] ){

            // visit all of it's unvisited neighbors
            if (!visited[k]){
                if (dfsHelper(k, visited, v))
                    return true;
            }

            // If an adjacent is visited and not parent of current
            // vertex, then there is a cycle.
            else if (k != parent)
                return true;
        }
        return false;
    }
}