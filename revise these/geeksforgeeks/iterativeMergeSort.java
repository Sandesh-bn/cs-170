import java.util.*;
class Main {
  public static void main(String[] args) {
    System.out.println("hello world");
    int[] arr = {3, -2, 1, 0, 8, 7, 9, -2};
    mergeSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  
  
  public static int min(int x, int y){
    return x > y?y:x;
  }
  public static void mergeSort(int arr[]){
       int curr_size, left_start;
       int N = arr.length;

        // Merge subarrays in bottom up manner.  First merge subarrays of
   // size 1 to create sorted subarrays of size 2, then merge subarrays
   // of size 2 to create sorted subarrays of size 4, and so on.
       for (curr_size = 1; curr_size < N; curr_size *= 2){
        for (left_start = 0; left_start < N - 1; left_start += 2 * curr_size){
            int mid = left_start + curr_size - 1;
            int right_end = Math.min(left_start + 2 * curr_size - 1, N - 1);
            merge(arr, left_start, mid, right_end);
   }

 }
}

public static void merge(int[] arr, int low, int mid, int high){
    int size = (high - low) + 1;
		int[] temp = new int[size];
		int left = low;
		int right = mid + 1;
		int k = 0;
		
		while (left <= mid && right <= high){
			if (test[left] < test[right]){
				temp[k++] = test[left++];
			}
			else {
				temp[k++] = test[right++];
			}
		}
		
		
        while (left <= mid){
            temp[k++] = test[left++];
        }
    
    
        while (right <= high){
            temp[k++] = test[right++];
        }
		
		
		for (int j = 0; j < temp.length; j++){
			test[low + j] = temp[j];
		}

}

how sorting happens

[3, -2, 1, 0, 8, 7, 9, -2]
[-2, 3, 1, 0, 8, 7, 9, -2]
[-2, 3, 0, 1, 8, 7, 9, -2]
[-2, 3, 0, 1, 7, 8, 9, -2]
[-2, 3, 0, 1, 7, 8, -2, 9]
[-2, 0, 1, 3, 7, 8, -2, 9]
[-2, 0, 1, 3, -2, 7, 8, 9]
[-2, -2, 0, 1, 3, 7, 8, 9]