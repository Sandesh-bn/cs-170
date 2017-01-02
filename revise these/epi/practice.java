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
	

You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) return result;
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++){
                int temp[] = {nums1[i], nums2[j]};
                result.add(temp);
            }
        }
        Collections.sort(result, new Comparator<int[]>(){
           public int compare(int[] obj1, int[] obj2){
               return (obj1[0] + obj1[1]) - (obj2[0] + obj2[1]);
           } 
        });
        if (result.size() < k) return result;
        return result.subList(0, k);
    }
}

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



Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int size;
    private ListNode head;
    private Random rand;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        ListNode curr = head;
        this.rand = new Random();
        while (curr != null){
            this.size += 1;
            curr = curr.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int j = rand.nextInt(this.size);
        ListNode randomNode = head;
        while(j> 0){
            randomNode = randomNode.next;
            j--;
        }
        return randomNode.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
 
 
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
