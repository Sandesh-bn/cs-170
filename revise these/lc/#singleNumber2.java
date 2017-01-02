


public int singleNumber(int[] A){
    int res = 0, total = 0;

    for (int k = 0; k < 32; k++){
        total = 0;
        int kthBitSet = 1 << k;
        for (int num: A){
            if ((num % kthBitSet) == kthBitSet)
                total++;
        }
        if (total % 3 != 0)
            res |= kthBitSet;
    }
    return res;
}