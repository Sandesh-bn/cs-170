Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree? Show More Hint Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.


public boolean validTree(int n, int[][] edges) {
    boolean[] visited = new boolean[n];
    List<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < adj.length; i++) 
        adj[i] = new ArrayList<Integer>();
    for (int[] edge : edges) {
        adj[edge[0]].add(edge[1]);
        adj[edge[1]].add(edge[0]);
    }
    if (!dfs(0, -1, visited, adj)) return false;
    for (boolean b : visited)
        if (!b) return false;
    return true;
}

// p is the pointer to 'parent' node, we ignore it to avoid infinite loop
private boolean dfs(int v, int p, boolean[] visited, List<Integer>[] adj) {
    visited[v] = true;
    for (int i : adj[v]) {
        if (i == p) continue;
        if (visited[i] || !dfs(i, v, visited, adj)) return false;
    }
    return true;
}