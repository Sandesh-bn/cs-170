int multiply(int x, int y){
    if (y == 0)
        return 0;
    if (y > 0)
        returrn x + multiply(x, y - 1)
    
    // when y is negative
    if (y < 0)
        return -multiply(x, -y);


}