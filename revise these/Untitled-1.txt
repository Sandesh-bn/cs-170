http://www.geeksforgeeks.org/write-you-own-power-without-using-multiplication-and-division/


public int power(int x, int n){
    int res = 0;
    for (int i = 0; i < n; i++)
        res += x;
    return res;
}