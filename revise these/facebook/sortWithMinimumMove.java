You have an array of unique integer numbers and only one operation: MoveToFront(x) that moves given number to the beginning of the array. 
Write a program to sort the array using the minimum possible number of MoveToFront() calls.

1. Find the largest number (I called it A) from the array and remember its index.
2. Find the next largest number (I called it B) from the array. If B comes before A, we're good, otherwise move B to the front, MoveToFront(B). 
3. A = B, and repeat (2). it needs to loop n-2 times to check all other numbers.

It's not the fastest algorithm, but it should be very easy to understand. The time complexity is O(n^2).



void sortArray(int[] array){
	if(array==null){
                    return;
	}
          
	for(int start = 0; start < array.lenth; start++){
		int max = 0;
           	for(int i = start; i < array.lenth; i++){
          			if(array[i]>max){
				max=array[i];
			}
		}
	
		MoveToFront(array, max);
	}
}