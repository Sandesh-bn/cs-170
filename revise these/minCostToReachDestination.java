//http://www.geeksforgeeks.org/find-the-minimum-cost-to-reach-a-destination-where-every-station-is-connected-in-one-direction/
public int minCost(int cost[][]){
	int N = cost.length;
	int dist[] = new int[N];
	
	for (int i = 0; i < N; i++)
		dist[i] = Integer.MAX_VALUE;
	
	dist[0] = 0;
	
	for (int i = 0; i < N; i++){
		for (int j = i + 1; j < N; i++){
			dist[j] = Math.min(dist[j], dist[i] + cost[i][j]);
		}
	}
	return dist[N - 1];
}