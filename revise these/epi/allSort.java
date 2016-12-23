
public class SortingAllDemo {
	public void sort(Comparable[] a){
		
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	private static void exchange(Comparable[] a, int i, int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp; 
	}
	
	private static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
	public static boolean isSorted(Comparable[] a){
		for (int i = 1; i < a.length; i++){
			//if (less(a[i], a[i - 1]))
			if (a[i].compareTo(a[i - 1]) < 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		String arr[] = {"x","a", "z", "c", "b","e", "f", "h", "x"};
		//insertionSort((String[])arr);
		quickSort((String[]) arr);
		show(arr);
		
	}
	
	public static void selectionSort(Comparable[] a){
		int N = a.length;
		
		for (int i = 0; i < N; i++){
			int min = i;
			for (int j = i + 1; j < N; j++)
				if (a[j].compareTo(a[min]) < 0)
					min = j;
			exchange(a, i, min);
		}
	}
	
	public static void insertionSort(Comparable[] a){
		int N = a.length;
		for (int i = 1; i < N; i++){
			int j = i;
			while (j > 0 && (a[j].compareTo(a[j - 1]) < 0)){
				exchange(a, j, j - 1);
				j = j - 1;
			}
		}
	}
	

	
	public static void shellSort(int[] a){
		int N = a.length;
		int gap = N / 2;
		
		while (gap > 0){
			for (int i = 0; i < N - gap; i++){
				int j = i + gap;
				int temp = a[j];
				
				while (j >= gap && temp < a[j - gap]){
					a[j] = a[j - gap];
					j -= gap;
				}
				a[j] = temp;
			}
			gap = (gap == 2)?1: (int)(gap * (5.0 / 11));
		}
	}
	
	public static void quickSort(Comparable[] a){
		quickSort(a, 0, a.length - 1);
	}
	
	private static void quickSort(Comparable[] a, int low, int high){
		if (high <= low)
			return;
		int j = partition(a, low, high);
		quickSort(a, low, j - 1);
		quickSort(a, j + 1, high);
	}
	
	private static int partition(Comparable[] a, int low, int high){
		int i = low + 1; 
		int j = high; 
		Comparable pivotElement = a[low];
		
		while (true){
			while (a[i].compareTo(pivotElement) < 0) {
				i++;
				if (i == high)
					break;
			}
			while (a[j].compareTo(pivotElement) > 0){
				j--;
				if (j == low)
					break;
			}
			if (i >= j)
				break;
			
			Comparable temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		Comparable temp2 = a[low];
		a[low] = a[j];
		a[j] = temp2;
		return j;
		
	}
}
