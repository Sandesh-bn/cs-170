Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


public List<List<Integer>> permute(int[] nums){
    List<List<Integer>> result = new ArrayList<>();
    permute(result, nums, 0, nums.length - 1);
    return result;
}

public void permute(List<List<Integer>> result, int[] nums, int low, int high){
    if (low == high){
        Lis<Integer> temp = new ArrayList<>();
        for (int num: nums)
            temp.add(num);
        result.add(temp);
    }
    else {
        for (int i = low; i <= high; i++){
            swap(arr, low, i );
            permute(result, arr, low + 1, high);
            swap(arr, low, i );
        }
    }
}

O(n*n!) Note that there are n! permutations and it requires O(n) time to print a a permutation.
public void swap(int[] A, int l, int r){
    A[l] = A[l] ^ A[r];
    A[r] = A[l] ^ A[r];
    A[l] = A[l] ^ A[r];
}