given n 
count the number of digits in range 1.. N that doesn't 
have consecutive 1s in their binary representation

nput:  N = 2
Output: 3
// The 3 strings are 00, 01, 10

Input: N = 3
Output: 5
// The 5 strings are 000, 001, 010, 100, 101

this is a dp problem
let a[i] be number of  binary strings of length i which has no
consecutive 1s and ends with 0
let b[i] be number of binary strings of length i which has noconsecutive 1s and ends with 1

we can append 0 or 1 to a string that ends with 0
but we can only append 0 to a string that ends with 1

a[i] = a[i - 1] + b[i - 1]
b[i] = a[i - 1]


public static int countStrings(int n){
    int[] a = new int[n];
    int[] b = new int[n];
    a[0] = b[0] = 1;
    for (int i = 1; i < n; i++){
        a[i] = a[i - 1] + b[i - 1];
        b[i] = a[i - 1];
    }
    return a[n - 1] + b[n - 1];
}