// walls and gates
//http://buttercola.blogspot.com/2015/09/leetcode-walls-and-gates.html
You are given a m x n 2D grid initialized with these three possible values.
-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4

  
boolean[][] visited;
public void wallsAndGates(int[][] rooms) {
    visited = new visited[rooms.length][rooms[0].length];

    for (int i = 0; i < rooms.length; i++)
        for (int j = 0; j < rooms[0].length; j++)
            if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
}

private void dfs(int[][] rooms, int i, int j, int d) {
    if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d || visited[i][j]) return;
    
    //skip wall
    if (rooms[i][j] == -1)return;

    visited[i][j] = true;

    rooms[i][j] = d;
    dfs(rooms, i - 1, j, d + 1);
    dfs(rooms, i + 1, j, d + 1);
    dfs(rooms, i, j - 1, d + 1);
    dfs(rooms, i, j + 1, d + 1);

    visited[i][j] = false;
}


EXECUTE THIS CODE TO UNDERSTAND HOW DFS WORKS
/*
class Main {
  public static void main(String[] args) {
    System.out.println("hello world");
    int f = Integer.MAX_VALUE;
    int[][] arr = {
                    {1000, -1, 0, 99},
                    {4, 5, 6, -1},
                    {7, -1, 8, -1},
                    {0, -1, 9, 10}
                  };
    for (int i = 0; i < arr.length; i++){
      for (int j = 0; j < arr[0].length; j++){
        if (arr[i][j] == 0)
        dfs(arr, i, j,0);
      }
    }
  }
  
  private static void dfs(int[][] rooms, int i, int j, int d) {
    if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) return;
    //System.out.println(rooms[i][j]);
    disp(rooms);
    rooms[i][j] = d;
    dfs(rooms, i - 1, j, d + 1);
    dfs(rooms, i + 1, j, d + 1);
    dfs(rooms, i, j - 1, d + 1);
    dfs(rooms, i, j + 1, d + 1);
}
private static void disp(int[][] nums){
  for (int i = 0; i < nums.length; i++){
    for (int j = 0; j < nums[0].length; j++){
      System.out.print(String.format("%02d ", nums[i][j]));
    }
    System.out.println();
  }
  System.out.println();
}
}
*/