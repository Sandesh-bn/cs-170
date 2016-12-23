/*
input:
[1, 2, 3]

output:
2
[1, 2, 3] -> [2, 2, 3] -> [2, 2, 2]

find the median. for every element find out the absoulute 
difference bw element and median. add all these difference, that would be the result
*/

public class Solution {
    public int minMoves2(int[] nums) {
        int moves = 0;
        int i = 0, j = nums.length - 1;
        Arrays.sort(nums);
        while (i < j){
            moves += nums[j--] - nums[i++];
        }
        return moves;
    }
}