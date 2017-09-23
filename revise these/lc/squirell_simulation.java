There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid. Your goal is to find the minimal distance for the squirrel to collect all the nuts and put them under the tree one by one. The squirrel can only take at most one nut at one time and can move in four directions - up, down, left and right, to the adjacent cell. The distance is represented by the number of moves.
Example 1:
Input: 
Height : 5
Width : 7
Tree position : [2,2]
Squirrel : [4,4]
Nuts : [[3,0], [2,5]]
Output: 12

'
 public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
     int totalDistance = 0;
     int nutsToTree[i] = new int[N];
     int nutsToSquirell[i] = new int[N];

     for (int i = 0; i < N; i++){
         nutsToTree[i] = Math.abs(tree[i][0] - nuts[i][0]) + Math.abs(tree[i][1] - nuts[i][1]);
         totalDistance += nutsToTree[i] * 2;
         nutsToSquirell[i] = Math.abs(squirell[i][0] - nuts[i][0]) + Math.abs(squirell[i][1] - nuts[i][1]);
     }

     int minDistance = Integer.MAX_VALUE;

     for (int i = 0; i < N; i++){
         distance = totalDistance + nutsToSquirell[i] - nutsToTree[i];
         minDistance = min(distance, minDistance);
     }
     return minDistance;
 }