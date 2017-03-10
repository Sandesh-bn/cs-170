Given an array of integers, print the leaders in the array. A leader is an element which is larger than all the elements in the array to its right.
For example:
Input Array:
{ 98, 23, 54, 12, 20, 7, 27 }
Output:
Leaders- 27 54 98

  public static void printLeaders(int[] A){
    int N = A.length;
    int currLeader = A[N - 1];
    System.out.print(" " + currLeader);
    int i = N - 2;
    while (i >= 0){
        if (A[i] > currLeader){
            currLeader = A[i];
            System.out.print(" " + currLeader);
        }
        i--;
    }