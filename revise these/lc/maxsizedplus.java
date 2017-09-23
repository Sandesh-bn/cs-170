Finding biggest plus sign "+" in a sparse matrix(matrix with elements 0 and 1) 
For example, the biggest plus sign for following matrix is located at (2,2), with length 1 for each edge(Yes, each edge should have same length) 
0 0 1 0 0 1 0 
1 0 1 0 1 0 1 
1 1 1 1 1 1 1 
0 0 1 0 0 0 0 
0 0 0 0 0 0 0 


public int maxLen(int[][] mat){
    int max = 0;
    for (int i = 1; i < mat.length - 1; i++){
        for (int j = 1; j < mat[0].length - 1; j++){
            if (mat[i][j] == 1){
                int len = getLength(mat, i, j);
                if (len > max){
                    position = i + ", " + j;
                    max = len;
                }
            }
        }
    }
}

public int getLength(int[][] mat, int row, int column){
    int left = column - 1;
    int right = column + 1;
    int top = row - 1;
    int bottom = row + 1;
    int len = 0;

    if (left < 0 || top < 0 || bottom > mat.length || right > mat[0].length)
        return len;
    else {
        while(mat[row][left] == 1 && mat[row][right] == 1 &&
              mat[top][column] == 1 && mat[bottom][column] == 1){
                  len++;
                  left--;
                  right++;
                  top--;
                  bottom++;
                  if (left < 0 || top < 0 || bottom > mat.length || right > mat[0].length)
                    break;
              }
    }
    return len;
}