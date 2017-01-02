Permutation Sequence   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 71036
Total Submissions: 263545
Difficulty: Medium
Contributors: Admin
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.

public class Solution {
    public String getPermutation(int n, int k) {
 List<Integer> nums = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
        nums.add(i);
    }
    //String ret = "";
    StringBuilder sb = new StringBuilder();
    k--;
    while (!nums.isEmpty()) {
        int f = fact(n-1);
        int i = k / f;
        //ret += nums.get(i).toString();
        sb.append(nums.get(i).toString());
        nums.remove(i);
        k -= k/f*f;
        n--;
    }
    return sb.toString();

}
private int fact(int n) {
    int ret = 1;
    for (int i = 1; i <= n; i++) {
        ret *= i;
    }
    return ret;
}
}
