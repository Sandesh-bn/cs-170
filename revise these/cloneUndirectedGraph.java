
import java.util.*;

class Node{
	int value;
	LinkedList<Node> neighbors;
	public Node(int val){
		this.value = val;
		neighbors = new LinkedList<>();
	}
	
	public void addEdge(Node u){
		this.neighbors.add(u.value);
	}
}

class Graph{
	public Node cloneGraph(Node source){
		Queue<Node> q = new LinkedList<>();
		q.add(source);
		Map<Node, Node> map = new HashMap<>();
		
		map.put(source, new Node(source.val));
		
		while(!q.isEmpty()){
			Node node = q.offer();
			Node cloneNode = map.get(node);
			
			if (node.neighbors != null){
				for (Node neighbor: node.neighbors){
					Node clonedNeighbor = map.get(neighbor);
					
					if (clonedNeighbor == null){
						q.add(neighbor);
						clonedNeighbor = new Node(neighbor.value);
						map.put(neighbor, clonedNeighbor);
					}
					node.neighbors.add(clonedNeighbor);
				}
			}
			return map.get(source);
		}
	}
	
	
	public void bfs(Node source){
		Queue<Node> q = new LinkedList<>();
		q.offer(source);
		Set<Integer> visited = new HashSet<>();
		visited.add(source.val);
		
		
		while (!q.isEmpty()){
			Node node = q.poll();
			System.out.print(node.value + " ");
			
			for (Node neighbor: q.neighbors){
				if (!visited.contains(neighbor.value)){
					visited.add(neighbor);
					q.offer(neighbor);
				}
			}
		}
		System.out.println();
	}
}