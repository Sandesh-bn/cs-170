http://www.geeksforgeeks.org/maximum-occurred-integer-n-ranges/
Given n ranges of the form L and R, the task is to find the maximum occurred integer in all the ranges. If more than one such integer exits, print the smallest one.
0 <= Li , Ri < 1000000.
Examples:

Input : L1 = 1 R1 = 15
        L2 = 4 R2 = 8
        L3 = 3 R3 = 5
        L3 = 1 R3 = 4
Output : 4

Input : L1 = 1 R1 = 15
        L2 = 5 R2 = 8
        L3 = 9 R3 = 12
        L4 = 13 R4 = 20
        L5 = 21 R5 = 30
Output : 5
Numbers having maximum occurrence i.e 2  are 5, 6,
7, 8, 9, 10, 11, 12, 13, 14, 15. The smallest number
among all are 5.


public int maxInNRanges(int[] L, int[] R){
    int maxValueInAnyRange = Integer.MIN_VALUE;
    for (int r: R)
        maxValueInAnyRange = Math.max(r, maxValueInAnyRange);
    
    int prefixSum[] = new int[maxValueInAnyRange + 1];
    for (int i = 0; i < L.length; i++){
        prefixSum[L[i]] += 1;
        prefixSum[R[i]] -= 1;
    }

    maxPrefix = Integer.MIN_VALUE, index = 0;
    for (int i = 1; i < prefixSum.length; i++){
        if (prefixSum[i] > maxPrefix){
            index = i;
            maxPrefix = prefixSum[i];
        }
    }
    return index;
}