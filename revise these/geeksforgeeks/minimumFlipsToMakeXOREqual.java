Input :  p = 2, q = 2
  arr1[] = {0, 0, 1}
  arr2[] = {0, 1, 0}
  arr3[] = {0, 1, 0}
Output : 1
arr1[0] ^ arr2[0] = 0 ^ 0 = 0, which is equal 
to arr3[0], so no flip required.
arr1[1] ^ arr2[1] = 0 ^ 1 = 1, which is equal
to arr3[1], so no flip required.
arr1[2] ^ arr2[2] = 1 ^ 0 = 1, which is not 
equal to arr3[0], so one flip required.
Also p = 2 and q = 2, so flip arr1[2].

Input :  p = 2, q = 4
  arr1 = { 1, 0, 1, 1, 1, 1, 1 }
  arr2 = { 0, 1, 1, 1, 1, 0, 0 }
  arr3 = { 1, 1, 1, 1, 0, 0, 1 }
Output : 3

public int minFlips(int[] binary1, int[] binary2, int[] xor, int p, int q){
    int flips = 0;
    for (i = 0; i < 32; i++){
        if (binary1[i] ^ binary2[i] != xor[i])
            flips++;
    }
    return (flips > p + q)?-1:flips;
}