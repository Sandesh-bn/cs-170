ar1[] = {1, 5, 10, 20, 40, 80}
ar2[] = {6, 7, 20, 80, 100}
ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20, 80

ar1[] = {1, 5, 5}
ar2[] = {3, 4, 5, 5, 10}
ar3[] = {5, 5, 10, 20}
Output: 5, 5

public void findCommon(int[] arr1, int[] arr2, int[] arr3){
	int i = 0, j = 0, k = 0;
	
	while (i < arr1.length && j < arr2.length && k < arr3.length){
		if (arr1[i] == arr2[j] == arr3[k]){
			System.out.println(arr[i] + ": " );
			i++;j++;k++;
		}
		else if (arr1[i] < arr2[j])
			i++;
		else if (arr2[j] < arr3[k])
			j++;
		// We reach here when x > y and z < y, i.e., z is smallest
		else
			k++;
	}
}