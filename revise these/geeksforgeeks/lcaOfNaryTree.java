
int depth[30];
int parent[30];

List<Integer>[] list = new ArrayList[30];

void addEdge(int u, int v){
    adj[u].add(v);
    adj[v].add(u);
}

void dfs(int curr, int prev){
    parent[curr] = prev;
    

    depth[curr] = depty[prev] + 1;

    for (int i = 0; i < adj[curr].size(); i++){
        if (adj[curr].get(i) != prev)
            dfs(adj[curr].get(i), curr);
    }
}

void preProcess(){
    depth[0] = -1;
    dfs(1, 0);
}

int lca(int u, int v){
    if (u == v) return u;
    if (depth[u] > depth[v])
        swap(u, v);
    v = parent[v];
    return lca(u, v)
}

