Sort an integer array with three functions: findMin(), findMedium(), findMax().
public static void sortArray(int a[]) {
 
 for (int i - 0; i < a.length; i++) {
    int min = findMin(a.length, i);
    if (min != a[i]) {
       swap(a, min, i);       
    }
 }

}