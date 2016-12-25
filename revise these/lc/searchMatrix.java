Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.


 public static boolean searchMatrix(int[][] matrix, int target) {
		int start = 0;
		int end = matrix.length*matrix[0].length-1;
		while(start<=end) {
			int middle = matrix[((start+end)/2)/matrix[0].length][((start+end)/2)%matrix[0].length];
			if(middle==target) return true;
			else if(middle<target) start=((start+end)/2)+1;
			else end=((start+end)/2)-1;
		}
		return false;
	}
we can consider the matrix as a normal sorted array and apply binary search:

the row index of the middle element will be
((start+end)/2)/matrix[0].length
the column index of the middle element will be
((start+end)/2)%matrix[0].length
if middle element < target increase start by one and recompute
middle element
if middle element > target decrease end by one and recompute middle
element





below is a O(m + n) solution
The basic idea is from right corner, if the current number greater than target col - 1 in same row, else if the current number less than target, row + 1 in same column, finally if they are same, we find it, and return return.

  public boolean searchMatrix(int[][] matrix, int target) {
            int i = 0, j = matrix[0].length - 1;
            while (i < matrix.length && j >= 0) {
                    if (matrix[i][j] == target) {
                        return true;
                    } else if (matrix[i][j] > target) {
                        j--;
                    } else {
                        i++;
                    }
                }
            
            return false;
        }
		
		
		

		
		public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return false;
    }
    int row = 0;
    int col = matrix[0].length - 1;
    while (row < matrix.length && col >= 0) {
        if (matrix[row][col] == target) {
            return true;
        } else if (matrix[row][col] < target) {
            row++;
        } else {
            col--;
        }
    }
    return false;
	
	
	if you are still not able to understand this solution there are other solutions
}