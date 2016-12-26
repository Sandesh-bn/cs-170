Finding biggest plus sign "+" in a sparse matrix(matrix with elements 0 and 1) 
For example, the biggest plus sign for following matrix is located at (2,2), with length 1 for each edge(Yes, each edge should have same length) 
0 0 1 0 0 1 0 
1 0 1 0 1 0 1 
1 1 1 1 1 1 1 
0 0 1 0 0 0 0 
0 0 0 0 0 0 0 

class Main {
  public static void main(String[] args) {
    System.out.println("hello world");
    int[][] sparse = {
			{0,0,0,1,0,1,0},
		 	{1,0,0,1,1,0,1}, 
		 	{1,1,1,1,1,1,1},
		 	{0,0,1,1,0,0,0},
		 	{0,0,0,1,0,0,0}};
    
   int currlength=0;
		String position="";
		
		for(int i=1;i<sparse.length-1;i++){
			for(int j=1;j<sparse[0].length-1;j++){
				if(sparse[i][j]==1){
					
					int length=getLength(sparse, i, j);
					if(length>0 && length>currlength){
						position=i+","+j;
						currlength=length;
						}
				}
			}
		}
		System.out.println("Length is: "+currlength+" and position is: "+position);
		
		
	}
	
	public static int getLength(int[][]sparse,int row,int column){
		
		int left = column-1;
		int right = column+1;
		int top = row-1;
		int bottom = row+1;
		int length=0;
		
		if(left<0 || top <0 || right>sparse.length || bottom>sparse[0].length){
			return length;
		}
		else{
		while(sparse[row][left]==1 && sparse[row][right]==1 
				&& sparse[top][column]==1 && sparse[bottom][column]==1){
			
			length++;
			
			left--;
			right++;
			top--;
			bottom++;
			
			if(left<0 || top <0 || right>sparse[0].length || bottom>sparse.length){
				break;
			}
		}
		}
		
		
		return length;
	

}
}