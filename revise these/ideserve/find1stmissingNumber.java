https://www.youtube.com/watch?v=yxYCiBja8_s
Given an increasing sequence of numbers from 1 to n with only one missing number, how can you find that missing number without traversing the sequence in linear fashion. In other words, time complexity of your algorithm must be less than O(n)?

For example, if the given sequence is 1,2,4,5,6,7,8 then the missing number is 3. If the given sequence is 1,3,4,5 then the missing number is 2. For the input 2,3,4,5 output returned should be 1 as it is the missing number.

public int firstMissing(int[] A){
    int low = 0, high = A.length - 1;

    while(low <= high){
        int mid = (low + high) / 2;
        if (A[mid] == mid + 1)
            low = mid + 1;
        else
            high = mid;
    }
    return low + 1;
}