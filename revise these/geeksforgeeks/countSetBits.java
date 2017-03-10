http://www.geeksforgeeks.org/count-set-bits-in-an-integer/

public int countSetBits(int n){
    int count = 0;
    while(n != 0){
        n = (n & (n - 1));
        count++;
    }
    return count;
}