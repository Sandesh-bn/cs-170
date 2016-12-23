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
		if (high <= low + 10 - 1){
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
	
	private static void merge(int[] test, int low, int mid, int high){
		int size = (high - low) + 1;
		int[] temp = new int[size];
		int left = low;
		int right = mid + 1;
		int k = 0;
		
		while (left <= mid && right <= high){
			if (test[left] < test[right]){
				temp[k] = test[left];
				k++;
				left++;
			}
			else {
				temp[k] = test[right];
				k++;
				right++;
			}
		}
		
		if (left <= mid){
			while (left <= mid){
				temp[k] = test[left];
				k++;
				left++;
			}
		}
		if (right <= high){
			while (right <= high){
				temp[k] = test[right];
				k++;
				right++;
			}
		}
		
		for (int j = 0; j < temp.length; j++){
			test[low + j] = temp[j];
		}
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