ar1[] = {1, 5, 10, 20, 40, 80}
ar2[] = {6, 7, 20, 80, 100}
ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20, 80

ar1[] = {1, 5, 5}
ar2[] = {3, 4, 5, 5, 10}
ar3[] = {5, 5, 10, 20}
Output: 5, 5

let x by a pointer for arr1
    y be a pointer for arr2
    z be a pointer for arr3

    move x if arr1[x] < arr1[y]
    move y if arr2[y] < arr3[z]

    otherwise arr3[z] is lesser than arr1[x] and arr2[y] move z

    when all of them are equal x++, y++, z++

public void findCommon(int[] arr1, int[] arr2, int arr3[]){
    int i = 0, j = 0, k = 0;
    while (i < arr1.len && j < arr2.len && k < arr3.len){
        if (arr[i] == x && arr2[j] == x && arr3[z] == x){
            print (arr[i])
            i++; j++; k++;
        }
        else if (arr[i] < arr[j])
            i++;
        
        else if (arr2[j] < arr3[k])
            j++;
    }
}