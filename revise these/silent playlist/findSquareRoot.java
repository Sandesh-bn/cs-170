

// ask for the range of number and
// also for precision.
public int squareRoot(double num){
    if (num < 0)
        return -1;


    if (num == 0 || num == 1)
        return num;
    
    double precision = 0.00001;
    
    // if a > 1 we will have 0 < sqrt(a) < a
    double start = 0;
    double end = num;

    // if a < 1 we will have 0 < a < sqrt(a)
    if (num < 1)
        end = 1;
    
    while( end - start > precision){
        double mid = (start +  end)/2;

        double midSqr = mid * mid;

        if (midSqr == a)// found exact square root
            return mid;

        else if (midSqr < a)
            start = mid;
        
        else
            end = mid;
    }

    return (start + end)/2;
}