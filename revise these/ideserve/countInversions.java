


int count = 0;

public static int countInversions(int[] arr){
    mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    return count;
}

public static void merge(int[] arr, int[] temp, int low, int mid, int high){
    for (int i = low; i <= high; i++)
        temp[i] = arr[i];

    int i = low, j = mid + 1, k = low;

    while(i <= mid && j <= high){
        if (temp[i] <= temp[j])
            arr[k++] = temp[i++];
        else {
            arr[k++] = temp[j++];
            count += (mid - i) + 1;
        }
    }

    while(i <= mid)
        arr[k++] = temp[i++];
}