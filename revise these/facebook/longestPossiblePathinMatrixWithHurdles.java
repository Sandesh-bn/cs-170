http://www.geeksforgeeks.org/longest-possible-route-in-a-matrix-with-hurdles/
class Pair{
	boolean found;
	int value;
	public Pair(boolean isFound, int val){
		found = isFound;
		value= val;
	}
}

Pair findLongestPathHelper(int[][] mat, int i, int j, int x, int y, boolean[][] visited){
	if (i == x && j == y){
		Pair p = new Pair(true, 0);
		return p;
	}
	
	if (i < 0 || i >= mat.length ||
		j < 0 || j >= mat[0].length ||
		visited[i][j])
		{
			Pair p = new Pair(false, Integer.MAX_VALUE);
			return p;
		}
		
	visited[i][j] = true;
	
	int res = Integer.MIN_VALUE;
	
	Pair solution = findLongestPathHelper(mat, i, j - 1, x, y, visited);
	
	if (solution.found)
		res = Math.max(res, solution.value);
	
	solution = findLongestPathHelper(mat, i, j + 1, x, y, visited);
	
	if (solution.found)
		res = Math.max(res, solution.value);
	
	solution = findLongestPathHelper(mat, i - 1, j, x, y, visited);
	
	if (solution.found)
		res = Math.max(res, solution.value);
	
	
	solution = findLongestPathHelper(mat, i + 1, j , x, y, visited);
	
	if (solution.found)
		res = Math.max(res, solution.value);
	
	visited[i][j] = false;
	
	if (res != Integer.MIN_VALUE){
		Pair p = new Pair(true, 1 + res);
		return p;
	}
	else {
		Pair p = new Pair(false, Integer.MAX_VALUE);
		return p;
	}
}

public void findLongestPath(int[][] mat, int i, int j, int x, int y){
	boolean[][] visited = new boolean[mat.length][mat[0].length];
	
	Pair p = findLongestPathHelper(mat, i, j, x, y, visited);
	
	if (p.found)
		System.out.println("length " + p.value);
	else
		System.out.println("destination unreachable")
}