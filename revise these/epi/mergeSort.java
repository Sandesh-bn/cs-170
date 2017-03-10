import java.util.Arrays;

/*
 * performs merge sort in an efficient way. Whenever sub-array size is < 7 it performs insertion sort instead of dividing and performing merge sort.
 */
public class MergeSortEfficient {
	public static void main(String[] args){
		int[] test = {3, 5, -1, 0, 2, -1, 3, 2, 0};
		mergeSortEff(test);
		System.out.println(Arrays.toString(test));
	}
	
	public static void mergeSortEff(int[] test){
		mergeSortEff(test, 0, test.length - 1);
	}
	
	private static void mergeSortEff(int[] test, int low, int high){
		if (high - low < 10){
			insertionSort(test, low, high);
			return;
		}
		
		if (low < high){
			int mid = (low + high)/2;
			mergeSortEff(test, low, mid);
			mergeSortEff(test, mid + 1, high);
			merge(test, low, mid, high);
		}
	}
	

	private static void merge(int[] arr, int low, int mid, int high){
		int size = (high - low) + 1;
		int[] temp = new  int[size];
		int left = low, right = mid + 1, k = 0;
		while(left <= mid && right <= high){
			if (arr[left] < arr[right])
				temp[k++] = arr[left++];
			else
				temp[k++] = arr[right++];
		}

		while(left <= mid)
			temp[k++] = arr[left++];
		while(right <= high)
			temp[k++] = arr[right++];
		
		for (int j = 0; j < temp.length; j++)
			arr[low + j] = temp[j];
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