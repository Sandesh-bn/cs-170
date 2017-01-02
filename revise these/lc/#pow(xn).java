Implement pow(x, n).

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == Integer.MIN_VALUE)
            return (1/x) * myPow(x, n + 1);
        if (n < 0){
            n = -n;
            x = 1/x;
        }
        double half = myPow(x, n / 2);
        return (n % 2 == 0)?half * half:half * half * x;
       
       
    }
}