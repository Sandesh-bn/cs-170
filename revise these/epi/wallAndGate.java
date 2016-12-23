// walls and gates
//http://buttercola.blogspot.com/2015/09/leetcode-walls-and-gates.html
public void wallsAndGates(int[][] rooms) {
    for (int i = 0; i < rooms.length; i++)
        for (int j = 0; j < rooms[0].length; j++)
            if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
}

private void dfs(int[][] rooms, int i, int j, int d) {
    if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) return;
    rooms[i][j] = d;
    dfs(rooms, i - 1, j, d + 1);
    dfs(rooms, i + 1, j, d + 1);
    dfs(rooms, i, j - 1, d + 1);
    dfs(rooms, i, j + 1, d + 1);
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