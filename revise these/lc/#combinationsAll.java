Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]

combination 1

public List<List<Integer>> combination(int[] can, int x){
    Arrays.sort(can);
    List<List<Integer>> res = new ArrayList<>();
    dfs(res, new Arrays<>(), can, x, 0);
    return res;
}
public void dfs(List<List<Integer>> res, List<Integer> path, int[] A, int remaining, int index){
    if (remaining <= 0){
        if (remaining == 0)res.add(path);
        return;//prune
    }
    for (int i = index; i < A.length; i++){
        List<Integer> newPath = new Arrays<>(path);
        newPath.add(A[i]);
        dfs(res, newPath, A, remaining - A[i], i);
    }
}


//dfs (candidates, result, newPath, remaining - candidates[i], i + 1); will prevent adding duplicates in the path
			
/*
ie if arr is [1, 2, 3] = the path will not have duplicates of 1/2/3
at every level we exclude the the element that was added in prev level


if we use i then the path can have duplicates of 1, 2, 3
At every level we have all elements avaialbe
*/

/*
the given array should not contain duplicats
but the path can contain duplicates
at every level all the elements are available for forming a combination 
so duplicates are allowed within the path
*/

TC: O(nlogn) + O(Branch(n) ^ Depth(n) ) space: O(number of elements in the array)


COMBINATION SUM 2

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

public List<List<Integer>> cSum(int[] A, int x){
    List<List<Integer>> res = new ArrayList<>();
    if (A == null) return res;
    dfs(res, new ArrayList<>(),A, x, 0);
    return res;
}

public void dfs(List<List<Integer>> res, List<Integer> path, int[] A, int remaining, int index){
    if (remaining <= 0){
        if (remaining == 0) res.add(path);
        return;
    }
    for (int i = index; i < A.length; i++){
        if (i == index || A[i] != A[i - 1]){
            List<Integer> newPath = new ArrayList<>>(path);
            newPath.add(A[i]);
            dfs(res, newPath, A, remaining - A[i], i + 1);
        }
            
    }
}


combinationsGiven two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

public List<List<Integer>> combinations(int n, int k){
    List<List<Integer>> res = new ArrayList<>();
    if (n  == 0) return res;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
        arr[i] = i + 1;
    dfs(res, new ArrayList<>(), arr, 0, k);
    return res;
}

public void dfs(List<List<Integer>> res, List<Integer> path, int[] A, int index, int k){
    if (path.size() >= k){
        if (path.size() == k)
            res.add(path);
        return;
    }
    for (int i = index; i < A.length; i++){
        if (i > index || A[i] == A[i - 1]) continue;
        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(A[i]);
        dfs(res, newPath, A, i + , k);
    }
}