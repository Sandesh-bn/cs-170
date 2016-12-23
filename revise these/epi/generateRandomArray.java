Write a method to randomly generate a set of m integers from an array of size n. Each
element must have equal probability of being chosen.
public int[] generateRandomArray(int[] original, int m){
	int[] randomArray = new int[m];
	for (int i = 0; i < m; i++)
		randomArray[i] = original[i];
	
	for (int i = m; i < original.length; i++){
		int k = Math.rand(0, i);
		if (k < m)
			randomArray[k] = original[i];
	}
	return randomArray;
}	