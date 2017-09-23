http://www.geeksforgeeks.org/maximize-arrj-arri-arrl-arrk-such-that-i-j-k-l/

Maximize arr[l] – arr[k] + arr[j] – arr[i], such that i < j < k < l. Find the maximum value of arr[l] – arr[k] + arr[j] – arr[i], such that i < j < k < l

Example:

Let us say our array is {4, 8, 9, 2, 20}
Then the maximum such value is 23 (9 - 4 + 20 - 2)
We strongly recommend that you click here and practice it, before moving on to the solution.

Efficient Method (Dynamic Programming):
We will use Dynamic Programming to solve this problem. For this we create four 1-Dimensional DP tables.

Let us say there are four DP tables as – table1[], table2[], table3[], table4[]

Then to find the maximum value of arr[l] – arr[k] + arr[j] – arr[i], such that i < j < k < l

table1[] should store the maximum value of arr[l]
table2[] should store the maximum value of arr[l] – arr[k]
table3[] should store the maximum value of arr[l] – arr[k] + arr[j]
table4[] should store the maximum value of arr[l] – arr[k] + arr[j] – arr[i]
public int findMaxValue(int A[]){
    int N = A.length;

    int dp1[] = new int[N + 1];
    int dp2[] = new int[N + 1];
    int dp3[] = new int[N + 1];
    int dp4[] = new int[N + 1];

    for (int i = 0; i <= N; i++){
        dp1[i] = Integer.MIN_VALUE;
        dp2[i] = Integer.MIN_VALUE;
        dp3[i] = Integer.MIN_VALUE;
        dp4[i] = Integer.MIN_VALUE;
    }

    for (int i = N - 1; i >= 0; i--)
        dp1[i] = Math.max(dp1[i + 1], A[i]);

    for (int i = N - 2; i >= 0; i--)
        dp2[i] = Math.max(dp2[i + 1], dp1[i + 1] - A[i]);

    for (int i = N - 3; i >= 0; i--)
        dp3[i] = Math.max(dp3[i + 1], dp2[i + 1] + A[i]);

    for (int i = N - 4; i >= 0; i--)
        dp4[i] = Math.max(dp4[i + 1], dp3[i + 1] - A[i]);

    return dp4[0];
}