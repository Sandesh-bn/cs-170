public List<Integer> spiralOrder(int[][] matrix){
	List<Integer> result = new ArrayList<>();
	if (matrix == null || matrix.length == 0)
		return result;
	
	int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
	
	while(true){
		for (int j = left; j <= right; j++)
			result.add(matrix[top][j]);
		top++;
		if (left > right || top > bottom)
			break;
		
		for (int i = top; i <= bottom; i++)
			result.add(matrix[i][right]);
		right--;
		if (left > right || top > bottom)
			break;
		
		for (int j = right; j >= left; j--)
			result.add(matrix[bottom][j]);
		bottom--;
		if (left > right || top > bottom)
			break;
		
		for (int i = bottom; i >= top; i--)
			result.add(matrix[i][left]);
		left++;
		if (left > right || top > bottom)
			break;		
	}
	return result;
}