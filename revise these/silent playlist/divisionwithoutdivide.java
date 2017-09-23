



public int naiveDiv(int a, int b){
    int quotient = 0;

    while( a >= b){
        a -= b;
        quotient++;
    }
    return quotient;
}

// perform same algo but this time, subtract at a faster rate
public int optimizedDiv(int a, int b){
    int quotient = 0;
    int base = 1;
    int currDiv = b;

    while(a >= b){
        if (a >= currDiv){
            a -= currDiv;
            quotient += base;

            // double base and currDiv for faster division
            currDiv *= 2;
            base *= 2;
        }
        // if currDiv is too large halve both currDiva and base
        else {
            currDiv /= 2;
            base /= 2;
        }
    }
}