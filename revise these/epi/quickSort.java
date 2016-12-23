import java.util.Arrays;

/*
 * Modification of quicksort that reduces the number of recursive call by
 * performing insertion sort whenever the subarray size < 10
 */
public class QuickSortEfficient {
	public static void main(String[] args){
		int[] test = {8, 3, 0, -1, 2, 8, -1, 7, 1, 0, 8};
		
		quickSortEff(test);
		System.out.println(Arrays.toString(test));
	}

	public static void quickSortEff(int[] test){
		quickSortEff(test, 0, test.length - 1);
	}
	
	
	private static void quickSortEff(int[] test, int low, int high){
		if (high <= low)
			return;
		if (high <= low + 10)
			insertionSort(test, low, high);
		
		int pivotIndex = partition(test, low, high);
		quickSortEff(test, low, pivotIndex - 1);
		quickSortEff(test, pivotIndex + 1, high);
	}
	
	private static int partition(int[] test, int low, int high){
		int pivotElement = test[low];
		int i = low + 1;
		int j = high;
		
		while (true){
			while(test[i] < pivotElement){
				i++;
				if (i == high)
					break;
			}
			
			while(test[j] >= pivotElement){
				j--;
				if (j == low)
					break;
			}
			
			if (i >= j)
				break;
			
			int temp = test[i];
			test[i] = test[j];
			test[j] = temp;
		}
		int temp2 = test[j];
		test[j] = test[low];
		test[low] = temp2;
		return j;		
	}
	
	
	private static void insertionSort(int[] a, int low, int high){
		for (int i = low; i < high; i++){
			int j = i + 1;
			
			while (j > low && a[j] < a[j - 1]){
				int temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
				j--;
			}
		}
	}
	
}
