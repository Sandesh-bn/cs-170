public class Solution {
    public int islandPerimeter(int[][] grid) {
      if (grid == null || grid[0].length == 0 || grid.length == 0)
        return 0;
      int perimeter = 0;
      
      for (int i = 0; i < grid.length; i++){
          for (int j = 0; j < grid[0].length; j++){
              if (grid[i][j] == 1){
                  perimeter += 4; // add all the edges of the square
                  
                  // if it's top neighbor or left neighbor is an island, decrmenet 2 for each common edge
                  if (i > 0 && grid[i - 1][j] == 1) 
                    perimeter -= 2; // we have to ignore the common edge twice
                  if (j > 0 && grid[i][j - 1] == 1)
                   perimeter -= 2;
              }
          }
      }
      return perimeter;
        
    }
}