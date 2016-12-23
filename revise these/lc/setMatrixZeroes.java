public void setZeroes(int[][] matrix){
	boolean firstCol = false, firstRow = false;
	for (int i = 0; i < M; i++){
		for (int j = 0; j < N; j++){
			if (matrix[i][j] == 0){
				if (i == 0) firstRow = 0;
				if (j == 0) firstCol = 0;
				matrix[i][0] = 0;
				matrix[0][j]  = 0;
			}
		}
	}
	
	for (int i = 1; i < M; i++){
		for (int j = 1; j < N; j++){
			if (matrix[i][0] == 0 || matrix[0][j] == 0)
				matrix[i][j] = 0;
		}
	}
	if (firstCol)
		for (int i = 0; i < M; i++)
			matrix[i][0] = 0;
		
	if (firstCol)
		for (int j = 0; j < N; j++)
			matrix[0][j] = 0;
}