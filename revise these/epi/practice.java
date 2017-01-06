5-12 // finish leetcode 4 - 8 25
// resolve all doubts in leetcode 25
// locked leetcode problems
// epi problems 25

12 - 1 apply
12-4 android app sunrise




// sedgewick
// tushar's dp 26
// ideserve videos 26
// revise on interviewbit 26
// revise on leetcode 26, 27
// geeksforgeeks problems 28
// java
//about your resume
	



We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        
        
        int l = 0, h = n;
        while (l < h){
            int mid = l + (h - l)/2;
            if (guess(mid) == 0)
                return mid;
            if (guess(mid) == -1)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}




 
 Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();


public class Solution {
    private int[] nums;
    private Random rand;
    public Solution(int[] nums) {
        rand = new Random();
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) return null;
        int[] copy = nums.clone();
        for (int i = 0; i < copy.length; i++){
            int j = rand.nextInt(copy.length);
            int temp = copy[i];
            copy[i] = copy[j];
            copy[j] = temp;
        }
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
 
 
 
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
public class Solution {
    public int firstUniqChar(String s) {
       int[] ascii = new int[128];
       for (int i = 0; i < s.length(); i++)
        ascii[s.charAt(i)]++;
       for (int i = 0; i < s.length(); i++){
           if (ascii[s.charAt(i)] == 1)
            return i;
       }
       return -1;
    }
}



public class Solution{
    int[] nums;
    public Solution(int[] nums){
        this.nums = nums;
    }

    public int pick(int t){
        Random  r = new Random(;
        int index = rand.nextInt();
        while(nums[index] != target)
            index = rand.nextInt(nums.length);
        return ndex;
    }
}



