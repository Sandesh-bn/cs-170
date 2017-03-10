Count number of bits to be flipped to convert A to BCount number of bits to be flipped to convert A to B


public int countBits(int A, int B){
    int diff = A ^ B;
    return countBits(diff);
}

public int countBits(int A){
    int count = 0;
    while(A != 0){
        count++;
        A = (A & (A - 1));
    }
    return count;
}