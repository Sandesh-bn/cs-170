Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

Set<<List<Integer>> res = new HashSet<>();
//List<List<Integer>> result = new ArrayList<>();
public List<List<Integer>> permuteWithoutDups(int[] num){
    permute(num, 0, num.lenght - 1);
    List<List<Integer>> result = new ArrayList<>(res);
    return result;
}

public void permute(int[] arr, int low, int high){
    if (Low == high){
        List<Integer> temp = new ArrayList<>();
        for (int num: arr)temp.add(num);
        res.add(temp);
    }

    for (int i = low; i <= high; i++){
        //if (i == 0 || arr[i] != arr[i - 1]){
            swap(arr, low, i);
            permute(arr, low + 1, high);
            swap(arr, low, i);
        //}
    }
}

O(n*n!) Note that there are n! permutations and it requires O(n) time to print a a permutation.

public void swap(int A[],  int i, int j){
    A[i] = A[i] ^ A[j];
    A[j] = A[i] ^ A[j];
    A[i] = A[i] ^ A[j];
}