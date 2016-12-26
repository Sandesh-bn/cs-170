Given: sorted array of integers 
Return: sorted array of squares of those integers 
Ex: [1,3,5] -> [1,9,25] 

Integers can be negative

sort array by abs(x) as key (e.g. [1,2,3,-4,5,-6])
2) return [x**2 for x in array]

public static void sortSquare(Integer[] ones){
	Arrays.sort(ones, new Comparator<Integer>(){
		public int compare(Integer o1, Integer o2){
			return Math.abs(o1) - Math.abs(o2);
		}
	});
	for (int i = 0; i < ones.length; i++)
		ones[i] *= ones[i];
  }
  
  O(n log n) time 
O(1) additional space




2 approach

1) do sqr for all negative and reverse list, do sqr for positive
2) merge 2 arrays like in merge sort but only 1 iteration needed

O(n) time
O(n) additional space (because of merge)

public static int[] sortSquareMerge(int[] ones){
	int pos = 0;
	int[] result = new int[ones.length];
	
	while(pos < ones.length && ones[pos] <= 0)
		pos++;
	
	int neg = 0, firstPos = pos, i = 0;
	while(neg < firstPos && pos < ones.length){
		int negativeNumberSquared = ones[neg] * ones[neg];
		int positiveNumberSquared = ones[pos] * ones[pos];
		if (negativeNumberSquared < positiveNumberSquared){
			result[i++] = negativeNumberSquared;
			neg++;
		}
		else{
			result[i++] = positiveNumberSquared;
			pos++;
		}
	}
	while (neg < firstPos){
		result[i++] = ones[neg] * ones[neg];
		neg++;
	};
	while (pos < ones.length){
		result[i++] = ones[pos] * ones[pos];
		pos++;
	}
	 System.out.println(Arrays.toString(result));
	return result;
	
	
}