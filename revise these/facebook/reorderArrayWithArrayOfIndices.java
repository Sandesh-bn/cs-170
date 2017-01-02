Input:  arr[]   = [10, 11, 12];
        index[] = [1, 0, 2];
Output: arr[]   = [11, 10, 12]
        index[] = [0,  1,  2] 

Input:  arr[]   = [50, 40, 70, 60, 90]
        index[] = [3,  0,  4,  1,  2]
Output: arr[]   = [40, 60, 90, 50, 70]
        index[] = [0,  1,  2,  3,   4] 
		
		

example:


var A = [C, D, E, F, G];
var B = [3, 0, 4, 1, 2];

sort(A, B);
// A is now [D, F, G, C, E];



public void reorder(int[] arr, int index[], int n){
	for (int i = 0; i < n; i++){
		while (index[i] != i){
			int oldTarget = index[index[i]];
			int index = arr[index[i]];
			
			arr[index[i]] = arr[i];
			index[index[i]] = index[i];
			
			index[i] = oldTarget;
			arr[i] = index;
		}
	}
}