Given an array of integers which may contain duplicate elements, an element of this array is given to us, we need to tell the final position of this element in the array, if a stable sort algorithm is applied.

Examples:

Input  : arr[] = [3, 4, 3, 5, 2, 3, 4, 3, 1, 5], index = 5
Output : 4
Element initial index – 5 (third 3)
After sorting array by stable sorting algorithm, we get 
array as shown below
[1(8), 2(4), 3(0), 3(2), 3(5), 3(7), 4(1), 4(6), 5(3), 5(9)]
with their initial indices shown in parentheses next to them,
Element's index after sorting = 4
We strongly recommend you to minimize your browser and try this yourself first.

One easy way to solve this problem is to use any stable sorting algorithm like Insertion Sort, Merge Sort etc and then get the new index of given element but we can solve this problem without sorting the array.
As position of an element in a sorted array is decided by only those elements which are smaller than given element. We count all array elements smaller than given element and for those elements which are equal to given element, elements occurring before given elements’ index will be included in count of smaller elements this will insure the stability of the result’s index.
Simple code to implement above approach is implemented below:

public int positionInStableSort(int[] A, int idx){
    int finalIndex = 0;
    for (int n: A)
        if (n < A[idx])
            finalIndex++;
    i = 0;
    for (;i < idx; i++)
        if (A[i] == A[idx])
            finalIndex++;
    return finalIndex;
}