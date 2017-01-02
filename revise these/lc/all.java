Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]


public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int index){
        if (target <= 0){
            if (target == 0)result.add(path);
            return;
        }
        for (int i = index; i < candidates.length; i++ ){
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            List<Integer> pat = new ArrayList<>(path);
            pat.add(candidates[i]);
            dfs(result, pat, candidates, target - candidates[i], i + 1);
        }
    }
}



Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]


public class Solution {
  
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);// avoid generating duplicates
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, result, new ArrayList<>(), target, 0);
        return result;
    }
    
    public void dfs(int[] candidates, List<List<Integer>> result, List<Integer> path, int remaining, int begin){
        if (remaining <= 0){
            if (remaining == 0) result.add(path);// result found add it to result
            return;// prune the tree
        }
        for (int i = begin; i < candidates.length; i++ ){
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(candidates[i]);
            dfs(candidates, result, newPath, remaining - candidates[i], i);
        }
    }
    
   
}



valid sudoku
public class Solution {
    public boolean isValidSudoku(char[][] board) {
       
        
        Set<Character> rows[] = new HashSet[9];
        Set<Character> cols[] = new HashSet[9];
        Set<Character> subMatrix[] = new HashSet[9];
        
        for (int i = 0; i < 9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            subMatrix[i] = new HashSet<>();
        }
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                char cell = board[i][j];
                if (cell != '.'){
                    if (!rows[i].add(cell)) return false;
                    if (!cols[j].add(cell)) return false;
                    if (!subMatrix[(i/3) * 3 + (j/3)].add(cell)) return false;
                }
            }
        }
        return true;
        
       
    }
}



35. Search Insert Position   Add to List 
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) low = mid + 1;
            else
                high = mid - 1;
        } 
        return low;
        
        
    }
}


searc for a range
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
public class Solution {
    public int[] searchRange(int[] nums, int target) {
    
        int[] ret = {-1, -1};
        if (nums.length < 1)
            return ret;
        int l = 0, h = nums.length - 1;
        while (l < h){
            int mid = l + (h - l)/2;
            if (nums[mid] < target)
                l = mid + 1;
            else
                h = mid;
        }
        
        if (nums[l] != target) return ret;
        ret[0] = l;
        h = nums.length - 1;
        while (l < h){
            int mid = l + (h - l)/2 + 1;
            if (nums[mid] > target)
                h = mid - 1;
            else
                l = mid;
        }
        ret[1] = h;
        return ret;
        
        int[] ret = {-1, -1};
        if (nums.length < 1) return ret;
        int l = 0, h = nums.length - 1;
        while (l < h){
            int mid = l + (h - l)/2;
            if (nums[mid] < target)
                l = mid + 1;
            else
                h = mid;
        }
        
        if (nums[l] != target)return ret;
        ret[0] = l;
        h = nums.length - 1;
        while (l < h){
            int mid = l + (h - l)/2 + 1;
            if (nums[mid] > target)
                h = mid - 1;
            else
                l = mid;
        }
    }
}



search in rotated array

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

public class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            
            if (nums[low] <= nums[mid]){
                if (target >= nums[low] && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else {
                if (target >= nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
}
    }


Longest Valid Parentheses
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.



public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        Deque<Integer> stack = new LinkedList<>();
        int longest = 0, count = 0;
        for (char ch: s.toCharArray()){
            if (ch == '('){
                stack.push(count);
                count = 0;
            }
            else if (!stack.isEmpty()){
                count += stack.poll() + 1;
                longest = (count > longest)?count:longest;
            }
            else 
                count = 0
        }
        return longest * 2;
    }
}


next permutation
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

public void nextPermutation(int[] A){
    if (A == null || N < 2)return;
    int i = N - 2;
    while (i >= 0 && A[i] >= A[i + 1])
        i--;
    if (i >= 0){
        int j = N - 1;
        while(A[j] <= A[i])
            j--;
        swap(A, i, j);
    }
    reverse(A, i + 1, N - 1);
}

public class Solution {
    public void nextPermutation(int[] A) {
        if(A == null || A.length <= 1)
            return;
        int i = A.length - 2;
        
        while(i >= 0 && A[i] >= A[i + 1])
            i--; // Find 1st id i that breaks descending order
            
            
        if(i >= 0) {                           // If not entirely descending
            int j = A.length - 1;              // Start from the end
            while(A[j] <= A[i])
                j--;           // Find rightmost first larger id j
            swap(A, i, j);                     // Switch i and j
        }
        
        reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public void reverse(int[] A, int i, int j) {
        while(i < j){ 
            swap(A, i, j);
            i++;
            j--;
        }
    }
}



$

remove element
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

public class Solution {
    public int removeElement(int[] nums, int val) {
        
        int i = 0, j = nums.length - 1, count = 0;
        while (i < j){
            while (i < j && nums[i] != val)
                i++;
            while (i < j && nums[j] == val)
                j--;
            if (i >= j) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;j--;
        }
        i = 0;
        while (i < nums.length && nums[i++] != val)
            count++;
        return count;
       
        
    }
}



Remove Duplicates from Sorted Array

public class Solution {
    public int removeDuplicates(int[] nums) {
      
        
        if (nums.length < 2) return nums.length;
        int count = 1, curr = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (curr != nums[i]){
                nums[count++] = nums[i];
                curr = nums[i];
            }
        }
        return count;
        
    }
    
}



 





Merge Two Sorted Lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 == null)?l2:l1;
        return dummy.next;
    }
}


Valid Parentheses   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 154917
Total Submissions: 486535
Difficulty: Easy
Contributors: Admin
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (map.containsKey(ch))
                stack.push(ch);
            else {
                if (stack.isEmpty())
                    return false;
                if (ch == map.get(stack.peek()))
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
        
       
    }
}


Remove Nth Node From End of List   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 148940
Total Submissions: 466083
Difficulty: Easy
Contributors: Admin
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) return head;
        ListNode curr = head, target = head, tail = null;
        for (int i = 0; i < n; i++)
            curr = curr.next;
        while(curr != null){
            tail = target;
            target = target.next;
            curr = curr.next;
        }
        if (target == head)
            return head.next;
        tail.next = target.next;
        return head;
        
    }
}




4sum
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4)
            return result;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++){
            if (i == 0 || nums[i] != nums[i - 1]){
                
                for (int j = i + 1; j < nums.length - 2; j++){
                    
                    if (j == i + 1 || nums[j] != nums[j - 1]){
                        int low = j + 1, high = nums.length - 1;
                        
                        while (low < high){
                            int sum = nums[i] + nums[j] + nums[low] + nums[high];
                            if (sum == target){
                                List<Integer> quad = new ArrayList<>();
                                quad.add(nums[i]);quad.add(nums[j]);quad.add(nums[low]);quad.add(nums[high]);
                                result.add(quad);
                                
                                //skip duplicates
                                while (low < high && nums[low] == nums[low + 1])low++;
                                while (low < high && nums[high] == nums[high - 1])high--;
                                low++;
                                high--;
                            }
                            
                            else if (sum > target)
                                high--;
                            else
                                low++;
                        }
                    }
                }
            }
        }
        return result;
    }
}


Letter Combinations of a Phone Number   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 116415
Total Submissions: 362430
Difficulty: Medium
Contributors: Admin
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.


Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

public class Solution {
    public List<String> letterCombinations(String digits) {
       String[] mapping = {"", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list =  new LinkedList<>();
        if (digits == null || digits.length() == 0)
            return list;
        list.add("");
        for (int i = 0; i < digits.length(); i++){
            int digit = digits.charAt(i) - '0';
            while(list.get(0).length() == i){
                String t = list.remove(0);
                for (char c: mapping[digit].toCharArray()){
                    list.add(t + c);
                }
            }
        }
        return list;
        
        // THIS IS BFS AND TIME COMPLEXITY IS O(m ^ n) = O(3 ^ n) n is len(digits)
    }
}


16. 3Sum Closest   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 105504
Total Submissions: 346568
Difficulty: Medium
Contributors: Admin
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	
	public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int minDiff = nums[0] + nums[1] + nums[2], N = nums.length;
        ;
        for (int i = 0; i < nums.length - 2; i++){
            int left = i + 1, right = N - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return target;
                if (Math.abs(target - sum) < Math.abs(target - minDiff))
                    minDiff = sum;
                if (sum > target)
                    right--;
                else
                    left++;
            }
        }
        return minDiff;
        
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int minDiff = nums[0] + nums[1] + nums[2];
        int N = nums.length;
        for (int i = 0; i < nums.length - 2; i++){
            int left = i + 1, right = N - 1;
            while (left < right){
                int sum = nums[l] + nums[left] + nums[right];
                if (sum == target) return target;
                if (Math.abs(target - sum) < Math.abs(target - minDiff)) 
                    minDiff =s um;
                if (sum > target)
                    right--;
                else
                    left++;
            }
        }
    }
}


3Sum   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 168440
Total Submissions: 812901
Difficulty: Medium
Contributors: Admin
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (i == 0 || nums[i] > nums[i - 1]){
                int left = i + 1, right = nums.length - 1;
                while (left < right){
                    
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0){
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        result.add(triplet);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                            
                    }
                    else if (sum < 0)
                        left++;
                    else
                        right--;
                }
            }
        }
        return result;
       
    }
}


Longest Common Prefix   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 139706
Total Submissions: 459604
Difficulty: Easy
Contributors: Admin
Write a function to find the longest common prefix string amongst an array of strin

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0)
                prefix = prefix.substring(0, prefix.length() - 1);
        }
        return prefix;
       
    }
}

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++){
            char curr = s.charAt(i);
            char next = s.charAt(i + 1);
            if (map.get(curr) >= map.get(next))
                result += map.get(curr);
            else
                result -= map.get(curr);
        }
        result += map.get(s.charAt(s.length() - 1));
        return result;
        
    }
}

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.


public class Solution {
    public String intToRoman(int num) {
     String M[] = {"", "M", "MM", "MMM" };
     String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
     String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
     String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
     return M[num/1000] + C[(num % 1000)/100] + X[(num % 100)/10] + I[num % 10];
    }
}



Regular Expression Matching   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 112550
Total Submissions: 480345
Difficulty: Hard
Contributors: Admin
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

public class Solution {
    public boolean isMatch(String s, String p) {
        int R = s.length(), C = p.length();
        boolean[][] dp = new boolean[R + 1][C + 1];
        dp[0][0] = true;
        if (p.length() > 0 && p.charAt(0) == '*') return false;
        for (int j = 1; j < dp[0].length; j++)
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];
                
        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                
                if ((p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.'))
                    dp[i][j] = dp[i - 1][j - 1];
                else if (j > 0 && p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
            }
        }
        return dp[R][C];
    }
}

 
 Determine whether an integer is a palindrome. Do this without extra space.
 
 public class Solution {
    public boolean isPalindrome(int x){ 
        if (x < 0)
          return false;
         
        int div = 1;
        while (x / div >= 10){
            div *= 10;
        }
        
        while (x != 0){
            int l = x / div;
            int r = x % 10;
            
            if (l != r)
                return false;
            
            x = (x % div)/10;
            div = div / 100;
                
        }
        return true;
        
    }
}


 String to Integer (atoi)
 
 
public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        str = str.trim();
        int sign = 1, start = 0, N = str.length();
        long sum = 0;
        if (str.charAt(0) == '+'){
            sign = 1;
            start++;
        }
        else if (str.charAt(0) == '-'){
            sign = -1;
            start++;
        }
        for (int i = start; i < N; i++){
            if (!Character.isDigit(str.charAt(i)))
                return (int) sum * sign;
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && -sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int) sum * sign;
     
     
    }
}


Longest Palindromic Substring   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 157610
Total Submissions: 647214
Difficulty: Medium
Contributors: Admin
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"

public class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++){
            String palindrome = createPalindrome(s, i, i);
            
            if (palindrome.length() > result.length())
                result = palindrome;
            
            palindrome = createPalindrome(s, i, i + 1);
            
            if (palindrome.length() > result.length())
                result = palindrome;
        }
        return result;
    }
    
    public String createPalindrome(String text, int left, int right){
        while (left >= 0 && right < text.length() && text.charAt(left) == text.charAt(right)){
            left--;
            right++;
        }
        return text.substring(left + 1, right);
    }
}

Median of Two Sorted Arrays of size m and n
Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = (nums1.length / 2 )+ (nums2.length / 2) + 2;
        
        /*
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(size, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(size, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i1 - i2;
            }
        });
        */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(size, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(size);
        
        int pA = 0, pB = 0;
        while (pA < nums1.length || pB < nums2.length){
            if (pA < nums1.length){
                if (maxHeap.isEmpty() || nums1[pA] <= maxHeap.peek())
                    maxHeap.offer(nums1[pA]);
                else
                    minHeap.offer(nums1[pA]);
            }
            
            if (pB < nums2.length ){
                if (maxHeap.isEmpty() || nums2[pB] <= maxHeap.peek())
                    maxHeap.offer(nums2[pB]);
                else
                    minHeap.offer(nums2[pB]);
            }
            
            if (maxHeap.size() - minHeap.size() > 1)
                minHeap.offer(maxHeap.poll());
            else if (minHeap.size() - maxHeap.size() > 1)
                maxHeap.offer(minHeap.poll());
            pA++; pB++;
        }
        
        if (maxHeap.size() == minHeap.size()) return (maxHeap.peek() + minHeap.peek())/ 2.0;
        if (maxHeap.size() > minHeap.size()) return maxHeap.poll();
        else return minHeap.poll();
        
       
    }
}

 Longest Substring Without Repeating Characters   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 225533
Total Submissions: 956174
Difficulty: Medium
Contributors: Admin
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subseque

public class Solution {
    public int lengthOfLongestSubstring(String s) {
             if (s.length() <= 1)
            return s.length();
        int prev = 0;
        boolean[] letter = new boolean[256];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!letter[s.charAt(i)])
                letter[s.charAt(i)] = true;
            else {
                while (s.charAt(prev) != s.charAt(i)) {
                    letter[s.charAt(prev)] = false;
                    prev++;
                }
                prev++;
            }
            max = Math.max(max, i - prev + 1);
        }
        return max;
    }
}

Add Two Numbers   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 221199
Total Submissions: 849132
Difficulty: Medium
Contributors: Admin
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int carry = 0, sum = 0, val1 = 0, val2 = 0;
        ListNode headA = l1, headB = l2, curr = null, head = null;
        while (headA != null || headB != null){
            if (headA != null){
                val1 = headA.val;
                headA = headA.next;
            }
            else
                val1 = 0;
            if (headB != null){
                val2 = headB.val;
                headB = headB.next;
            }
            else
                val2 = 0;
            sum = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            if (head == null){
                head = new ListNode(sum);
                curr = head;
            }
            else {
                curr.next = new ListNode(sum);
                curr = curr.next;
            }
        }
        if (carry > 0)curr.next = new ListNode(carry);
        return head;
    }
    
    
}










Jump Game II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 80416
Total Submissions: 309526
Difficulty: Hard
Contributors: Admin
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.

public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int i = 0;
        while (i + nums[i] < nums.length - 1) {
            int maxVal = 0;
            int maxValIndex = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (nums[j + i] + j > maxVal) {
                    maxVal = nums[j + i] + j;
                    maxValIndex = i + j;
                }
            }
            i = maxValIndex;
            count++;
        }
        return count + 1;
    }
}



Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0, nums.length - 1);
        return result;
    }
    
    public void permute(int[] arr, int low, int high){
        if (low == high){
            List<Integer> temp = new ArrayList<>();
            for (int num: arr)temp.add(num);
            result.add(temp);
        }
        else {
            for (int i = low; i <= high; i++){
                swap(arr, low, i);
                permute(arr, low + 1, high);
                swap(arr, low, i);
                
            }
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}



Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]




public class Solution {
    //List<List<Integer>> result = new ArrayList<>();
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        permute(nums, 0, nums.length - 1);
        List<List<Integer>> ret = new ArrayList<>(result);
        return ret;
    }
    
    public void permute(int[] arr, int low, int high){
        if (low == high){
            List<Integer> temp = new ArrayList<>();
            for (int num: arr)temp.add(num);
            result.add(temp);
        }
        else {
            for (int i = low; i <= high; i++){
                //if (i == 0 || arr[i] != arr[i - 1]){
                swap(arr, low, i);
                permute(arr, low + 1, high);
                swap(arr, low, i);
                //}
                
            }
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


Rotate Image   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 90800
Total Submissions: 246102
Difficulty: Medium
Contributors: Admin
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

public class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        swapAlongVerticalAxis(matrix);
    }
    
    public void transpose(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (j > i){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }        
    }
    
    public void swapAlongVerticalAxis(int[][] matrix){
        int N = matrix.length;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - j - 1];
                matrix[i][N - j - 1] = temp;
            }
        }
    }
    
    
}


Group Anagrams   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 106646
Total Submissions: 338760
Difficulty: Medium
Contributors: Admin
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map =  new HashMap<>();
        for (String word: strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);
            if (!map.containsKey(sortedKey))
                map.put(sortedKey, new ArrayList<>());
            map.get(sortedKey).add(word);
        }
        for (Map.Entry<String, List<String>> entry: map.entrySet())
            result.add(entry.getValue());
        return result;
        
        
    }
}

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


 N-Queens   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 68488
Total Submissions: 238034
Difficulty: Hard
Contributors: Admin
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

review this



Maximum Subarray   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 154434
Total Submissions: 400331
Difficulty: Medium
Contributors: Admin
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < dp.length; i++){
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
        
        
    }
}

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return result;
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        
        while(true){
            for (int j = left; j <= right; j++)
                result.add(matrix[top][j]);
            top++;
            if (left > right || top > bottom) break;
            
            for (int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--;
            
            if (left > right || top > bottom) break;
            
            for (int j = right; j >= left; j--)
                result.add(matrix[bottom][j]);
            bottom--;
            
            if (left > right || top > bottom) break;
            
            for (int i = bottom; i >= top; i--)
                result.add(matrix[i][left]);
            left++;
            
            if (left > right || top > bottom) break;
        }
        return result;
    }
}



Jump Game   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 103038
Total Submissions: 354031
Difficulty: Medium
Contributors: Admin
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false


public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > max) return false;
            max = Math.max(max, nums[i] + i);
        }
        return true;
        
    }
}


Merge Intervals   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 96604
Total Submissions: 343074
Difficulty: Hard
Contributors: Admin
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        
        List<Interval> result = new ArrayList<>();
        if (intervals.size() < 1) return result;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            } 
        });
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval val: intervals){
            if (val.start <= end)
                end = Math.max(end, val.end);
            else {
                result.add(new Interval(start, end));
                start = val.start;
                end = val.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
        
    }
}


Insert Interval   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 78350
Total Submissions: 299711
Difficulty: Hard
Contributors: Admin
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        intervals.add(newInterval);
        if (intervals.size() < 1) return result;
        //System.out.println("he");
        // sort based on start values;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval ele: intervals){
            if (ele.start <= end)
                end = Math.max(end, ele.end);
            else{
                result.add(new Interval(start, end));
                start = ele.start;
                end = ele.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}

length of last word
public class Solution {
    public int lengthOfLastWord(String s) {
       
        
        int i = s.length() - 1;
        while (i >= 0 && Character.isWhitespace(s.charAt(i)))
            i--;
        int count = 0;
        while (i >= 0 && !Character.isWhitespace(s.charAt(i--)))
            count++;
        return count;
        
        
    }
}



 Spiral Matrix II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 69270
Total Submissions: 183510
Difficulty: Medium
Contributors: Admin
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

public class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        if (n == 0) return matrix;
        int value = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (true){
            for(int j = left; j <= right; j++)
                matrix[top][j] = value++;
            top++;
            if (left > right || top > bottom) break;
            
            for (int i = top; i <= bottom; i++)
                matrix[i][right] = value++;
            right--;
            if (left > right || top > bottom) break;
            
            for (int j = right; j >= left; j--)
                matrix[bottom][j] = value++;
            bottom--;
            if (left > right || top > bottom) break;
            
            
            for (int i = bottom; i >= top; i--)
                matrix[i][left] = value++;
            left++;
            if (left > right || top > bottom) break;
        }
        return matrix;
    }
}


Permutation Sequence   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 71036
Total Submissions: 263545
Difficulty: Medium
Contributors: Admin
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.

public class Solution {
    public String getPermutation(int n, int k) {
 List<Integer> nums = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
        nums.add(i);
    }
    //String ret = "";
    StringBuilder sb = new StringBuilder();
    k--;
    while (!nums.isEmpty()) {
        int f = fact(n-1);
        int i = k / f;
        //ret += nums.get(i).toString();
        sb.append(nums.get(i).toString());
        nums.remove(i);
        k -= k/f*f;
        n--;
    }
    return sb.toString();

}
private int fact(int n) {
    int ret = 1;
    for (int i = 1; i <= n; i++) {
        ret *= i;
    }
    return ret;
}
}


Rotate List   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 90748
Total Submissions: 378824
Difficulty: Medium
Contributors: Admin
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
       /*
        if (head == null || head.next == null || k == 0)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode lastNode = head;
        int length = 1;
        while (lastNode.next != null){
            length += 1;
            lastNode = lastNode.next;
        }

        for(int i = 0; i < (length - k % length); i++)
            tail = tail.next;
        
        
        lastNode.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
        */
        if (head == null || head.next == null || k == 0)
            return head;
        int len = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head, slow = dummy;
        while (fast.next != null){
            len++;
            fast = fast.next;
        }
        fast.next = head;
        k = k % len;
        for (int i = 0; i < len - k; i++)
            fast = fast.next;
       
        head = fast.next;
        fast.next = null;
        return head;
    }
}


Unique Paths   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 116217
Total Submissions: 298129
Difficulty: Medium
Contributors: Admin
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

public class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
        
       
    }
}

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       
        if (obstacleGrid == null || obstacleGrid.length == 0 ||
            obstacleGrid[0][0] == 1)
            return 0;
        int M = obstacleGrid.length, N = obstacleGrid[0].length;
        int dp[][] = new int[M][N];
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else if (i == 0 && j == 0) dp[i][j] = 1;
                else if (i == 0) dp[i][j] = dp[i][j - 1];
                else if (j == 0) dp[i][j] = dp[i - 1][j];
                else 
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[M - 1][N - 1];
        
      
        
    }
}



Minimum Path Sum   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 94455
Total Submissions: 255255
Difficulty: Medium
Contributors: Admin
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

public class Solution {
    public int minPathSum(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else if (i == 0) dp[i][j] = grid[i][j] + dp[i][j - 1];
                else if (j == 0) dp[i][j] = grid[i][j] + dp[i - 1][j];
                else dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[M - 1][N - 1];
    }
    
    }
}

Valid Number   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 58964
Total Submissions: 468001
Difficulty: Hard
Contributors: Admin
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        int N = s.length();
        if (N == 0) return false;
        
        boolean hasE, hasFirst, hasDot, hasDigit;
        hasE = hasFirst = hasDot = hasDigit = false;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                hasFirst = true;
                hasDigit = true;
                continue;
            }
            
            switch (ch){
                
                case 'e': if (hasE || !hasDigit)
                             return false;
                           hasE = true;
                           hasDigit = false;
                           hasFirst = false;
                           hasDot = true;
                           
                           continue;
                case '+':
                case '-':
                        if (hasFirst) return false;
                        hasFirst = true;
                        continue;
                case '.': if (hasDot) return false;
                        hasDot = true;
                        hasFirst = true;
                        continue;
                default: return false;
            }
        }
        return hasDigit;
    }
}




Plus One   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 139988
Total Submissions: 381822
Difficulty: Easy
Contributors: Admin
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the lis
public class Solution {
    public int[] plusOne(int[] digits) {
        
        List<Integer> sum = new ArrayList<>();
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--){
            int val = digits[i] + carry;
            sum.add(0, val % 10);
            carry = val / 10;
        }
        if (carry > 0) sum.add(0, carry);
        int[] result = new int[sum.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = sum.get(i);
        return result;70
        
        
        
        
    }
}



Add Binary   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 116865
Total Submissions: 386658
Difficulty: Easy
Contributors: Admin
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100"


public class Solution {
    public String addBinary(String a, String b) {
       
       
       if (a.length() < 1) return b;
       if (b.length() < 1) return a;
       StringBuilder res = new StringBuilder();
       int i = a.length() - 1, j = b.length() - 1, valA = 0, valB = 0, digit = 0, carry = 0;
       while (i >= 0 || j >= 0){
           valA = (i >= 0)?a.charAt(i) - '0':0;
           valB = (j >= 0)?b.charAt(j) - '0':0;
           digit = valA + valB + carry;
           carry = (digit > 1)?1:0;
           res.append(digit % 2);
           i--;
           j--;
       }
       if (carry > 0)res.append(carry);
       return res.reverse().toString();
      
    }
}

mplement int sqrt(int x).


public class Solution {
    public int mySqrt(int x) {
                if (x == 0 || x == 1)
            return x;
 
        // Do Binary Search for floor(sqrt(x))
        long start = 1, end = x, ans=0;
        while (start <= end)
        {
            long mid = (start + end) / 2;
 
            // If x is a perfect square
            if (mid*mid == x)
                return (int)mid;
 
            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (mid*mid < x)
            {
                start = mid + 1;
                ans = mid;
            }
            else   // If mid*mid is greater than x
                end = mid - 1;
        }
        return (int)ans;
    }
}


Climbing Stairs   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 145407
Total Submissions: 377542
Difficulty: Easy
Contributors: Admin
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class Solution {
    public int climbStairs(int n) {
        if (n < 3) return n;
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
}


Simplify Path   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 70844
Total Submissions: 297083
Difficulty: Medium
Contributors: Admin
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
public class Solution {
    public String simplifyPath(String path) {
        Set<String> skip = new HashSet<>();
        skip.add("..");skip.add(".");skip.add("");
        Deque<String> stack = new LinkedList<>();
        for (String dir: path.split("/")){
            if (dir.equals("..") && !stack.isEmpty())
                stack.pop();
            else if (!skip.contains(dir))
                stack.push(dir);
        }
        StringBuilder sb = new StringBuilder();
        for (String dir: stack)
            sb.insert(0, "/" + dir);
        return (sb.length() > 0)?sb.toString():"/";
    }
}


Edit Distance   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 74938
Total Submissions: 246085
Difficulty: Hard
Contributors: Admin
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                if (i == 0 || j == 0) 
                    dp[i][j] = i + j;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }
        return dp[len1][len2];
    }
}

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in pla

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false, firstCol = false;
        int M = matrix.length, N = matrix[0].length;
        
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (matrix[i][j] == 0){
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < M; i++){
            for (int j = 1; j < N; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if (firstRow)
            for (int j = 0; j < N; j++)
                matrix[0][j] = 0;
        
        if (firstCol)
            for (int i = 0; i < M; i++)
                matrix[i][0] = 0;
       
    }
}


Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]


review this


Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

public class Solution {
    public void sortColors(int[] nums) {
        
        int[] count = new int[3];
        for (int num: nums)
            count[num]++;
        int k = 0;
        for (int i = 0; i < count.length; i++){
            for (int j = 0; j < count[i]; j++)
                nums[k++] = i;
        }
        
    }
}


Minimum Window Substring   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 83038
Total Submissions: 351914
Difficulty: Hard
Contributors: Admin
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

public class Solution {
    boolean sContainsT(int mapS[], int mapT[]) {// Runtime = O(256) = O(1)
    for (int i = 0; i < mapT.length; i++) {// s should cover all characters in t
        if (mapT[i] > mapS[i])
            return false; 
    }           
    return true;
}

public String minWindow(String s, String t) {   
    int mapS[] = new int[256];// Count characters in s
    int mapT[] = new int[256];// Count characters in t      
    for (char ch : t.toCharArray())
        mapT[ch]++;

    String res = "";
    int right = 0, min = Integer.MAX_VALUE;         
    for (int i = 0; i < s.length(); i++) {// Two pointers of the sliding window: i(left), right
        while (right < s.length() && !sContainsT(mapS, mapT)) {// Extend the right pointer of the sliding window
            mapS[s.charAt(right)]++;
            right++;
        }
        if (sContainsT(mapS, mapT) && min > right - i + 1) {
            res = s.substring(i, right);
            min = right - i + 1;
        }
        mapS[s.charAt(i)]--;// Shrink the left pointer from i to i + 1
    }
    return res;
}
}


 Subsets   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 131739
Total Submissions: 363777
Difficulty: Medium
Contributors: Admin
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       /*
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        res.add(temp);
        int begin = 0;
        
        for (int i = 0; i < nums.length; i++){
            if (i == 0) begin = 0;
            int size = res.size();
            for (int j = begin; j < size; j++){
                List<Integer> curr = new ArrayList<>(res.get(j));
                curr.add(nums[i]);
                res.add(curr);
            }
            //begin = size;
        }
        return res;
        */
        
        // code for subset 2 works here. in subset 2 the given array contains duplicate element
         List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        res.add(temp);
        int begin = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (i == 0 || nums[i] != nums[i - 1]) 
                begin = 0;
            int size = res.size();
            for (int j = begin; j < size; j++){
                List<Integer> curr = new ArrayList<>(res.get(j));
                curr.add(nums[i]);
                res.add(curr);
            }
            begin = size;
        }
        return res;
    }
}



Word Search   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 102859
Total Submissions: 408459
Difficulty: Medium
Contributors: Admin
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

public class Solution {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word){
        int row = board.length, col = board[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if ((word.charAt(0) == board[i][j]) && dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index){
        if (index == word.length())
            return true;
        if (i >= board.length || i < 0 ||
            j >= board[0].length || j < 0 ||
            visited[i][j]||
            board[i][j] != word.charAt(index))
            return false;
        visited[i][j] = true;
        
        if (dfs(board, word, i - 1, j, index + 1) ||
            dfs(board, word, i + 1, j, index + 1) ||
            dfs(board, word, i, j - 1, index + 1) ||
            dfs(board, word, i, j + 1, index + 1))
            return true;
        visited[i][j] = false;
        return false;
    }
    
    
}


Remove Duplicates from Sorted Array II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 98712
Total Submissions: 284142
Difficulty: Medium
Contributors: Admin
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter wha
public class Solution {
    public int removeDuplicates(int[] nums) {
           
            
            int i = 0;
            for (int num: nums){
                if (i < 2 || num > nums[i - 2]){
                    nums[i] = num;
                    i++;
                }
            }
            return i;
    }
}

Search in Rotated Sorted Array II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 79910
Total Submissions: 243072
Difficulty: Medium
Contributors: Admin
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int last = nums.length - 1;
        
        boolean isFound = false;
        
        while (start <= last && !isFound){
            int mid = (start + last)/2;
            if (nums[mid] == target)
               isFound = true;
             
            else if(nums[mid] > target)
               last = mid - 1;
            else
               start = mid + 1;
        }
        return isFound;
    }
}



Remove Duplicates from Sorted List II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 92867
Total Submissions: 325619
Difficulty: Medium
Contributors: Admin
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (head != null && head.next != null){
            if (head.val == head.next.val){
                while (head.next != null && head.val == head.next.val)
                    head = head.next;
                head = head.next;
                p.next = head;
            }
            else {
                p = p.next;
                head = head.next;
            }
        }
        return dummy.next;
        
    }
}

Remove Duplicates from Sorted List   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 153756
Total Submissions: 397418
Difficulty: Easy
Contributors: Admin
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = head, runner = head.next;
        while (runner != null){
            if (runner.val == tail.val){
                while(runner != null && runner.val == tail.val)
                    runner = runner.next;
                tail.next = runner;
            }
            else {
                tail = tail.next;
                runner = runner.next;
            }
        }
        return head;
        
      
    }
}


 Largest Rectangle in Histogram   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 77391
Total Submissions: 303102
Difficulty: Hard
Contributors: Admin
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int i = 0, max = 0, p = 0, h = 0, w = 0;
        Deque<Integer> stack = new LinkedList<>();
        while(i < heights.length){
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()])
                stack.push(i++);
            else {
                p = stack.pop();
                h = heights[p];
                w = (stack.isEmpty())?i: i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }
        }
        while (!stack.isEmpty()){
            p = stack.pop();
            h = heights[p];
            w = (stack.isEmpty())?i: i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }
        return max;
    }
}


Maximal Rectangle   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 55494
Total Submissions: 214806
Difficulty: Hard
Contributors: Admin
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

review this



Partition List   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 84693
Total Submissions: 269874
Difficulty: Medium
Contributors: Admin
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode dummyLess = new ListNode(0);
        ListNode dummyMore = new ListNode(0);
        ListNode curr = head, more = dummyMore, less = dummyLess;
        while (curr != null){
            if (curr.val < x){
                less.next = curr;
                less = less.next;
            }
            else {
                more.next = curr;
                more = more.next;
            }
            curr = curr.next;
        }
        less.next = dummyMore.next;
        more.next = null;
        return dummyLess.next;
        
        
    }
}


Merge Sorted Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 134834
Total Submissions: 431226
Difficulty: Easy
Contributors: Admin
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.


public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       
        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (i >= 0 && j >= 0){
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        while (i >= 0)
            nums1[k--] = nums1[i--];
        while (j >= 0)
            nums1[k--] = nums2[j--];
            
        
        
    }
}


Subsets II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 90670
Total Submissions: 270081
Difficulty: Medium
Contributors: Admin
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        res.add(temp);
        int begin = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (i == 0 || nums[i] != nums[i - 1]) 
                begin = 0;
            int size = res.size();
            for (int j = begin; j < size; j++){
                List<Integer> curr = new ArrayList<>(res.get(j));
                curr.add(nums[i]);
                res.add(curr);
            }
            begin = size;
        }
        return res;
        
    }
}


Decode Ways   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 97539
Total Submissions: 519995
Difficulty: Medium
Contributors: Admin
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

public class Solution {
    public int numDecodings(String s) {
      if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
      int[] dp = new int[s.length() + 1];
      dp[0] = 1;
      dp[1] = 1;
      
      for (int i = 2; i < dp.length; i++){
          if (isValid(s.substring(i - 1, i)))
             dp[i] += dp[i - 1];
          if (isValid(s.substring(i - 2, i)))
             dp[i] += dp[i - 2];
          if (dp[i] == 0) 
            return 0;
      }
      return dp[dp.length - 1];
    }
    
    private static boolean isValid(String s){
        if (s.charAt(0) == '0') return false;
        int val = Integer.parseInt(s);
        return val >= 1 && val <= 26;
    }
}


100. Same Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 171778
Total Submissions: 381049
Difficulty: Easy
Contributors: Admin
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
}


Recover Binary Search Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 64578
Total Submissions: 226266
Difficulty: Hard
Contributors: Admin
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode firstSwap = null, lastSwap = null, prevNode = null;
        
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prevNode != null && prevNode.val > root.val){
                if (firstSwap == null) firstSwap = prevNode;
                lastSwap = root;
            }
            prevNode = root;
            root = root.right;
        }
        int temp = firstSwap.val;
        firstSwap.val = lastSwap.val;
        lastSwap.val = temp;
    }
    
}


Validate Binary Search Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 130316
Total Submissions: 586443
Difficulty: Medium
Contributors: Admin
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = null, prev = null;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }
}

 Interleaving String   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 61768
Total Submissions: 258873
Difficulty: Hard
Contributors: Admin
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.


public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if ((s1.length() + s2.length()) != s3.length()) return false;
        boolean dp[][] = new boolean[s2.length()+1][s1.length()+1];
        dp[0][0] = true;
        for (int j = 1; j < dp[0].length; j++)
            dp[0][j] = dp[0][j - 1] && (s1.charAt(j - 1) == s3.charAt(j - 1));
        for (int i = 1; i < dp.length; i++)
            dp[i][0] = dp[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        
        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                dp[i][j] = (dp[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1)))
                       || (dp[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }
        return dp[s2.length()][s1.length()];
    }
}


Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.


   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 0; j < i; j++)
                dp[i] += dp[j] * dp[i - j  - 1];
        }
        return dp[n];
    }
}

Unique Binary Search Trees II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 71161
Total Submissions: 233381
Difficulty: Medium
Contributors: Admin
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return (n == 0)?new ArrayList<>():generateTrees(1, n);
    }
    
    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end){
            result.add(null);
            return result;
        }
        
        for (int i = start; i <= end; i++){
            List<TreeNode> leftSubTrees = generateTrees(start, i - 1);
            List<TreeNode> rightSubTrees = generateTrees(i + 1, end);
            for (TreeNode leftSubTree: leftSubTrees){
                for (TreeNode rightSubTree: rightSubTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubTree;
                    root.right = rightSubTree;
                    result.add(root);
                }
            }
        }
        return result;
    }
    
    public List<TreeNode> generateTrees(int n){
        return (n == 0)?new ArrayList<>():genearateTrees(1, n);
    }
    
    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if (start > end){
            result.add(null);
            return result;
        }
        
        for (int i = 1; i <= n; i++){
            List<TreeNode> leftSubtrees = generateTrees(1, i - 1);
            List<TreeNode> rightSubTrees = generateTrees(i + 1, n);
            for (Tree leftSubtree: leftSubtrees){
                for (Tree rightSubtree: rightSubTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubTree;
                    root.right = rightSubtree;
                    result.add(root);
                }
            }
        }
    }
    
    
}

Binary Tree Inorder Traversal   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 166680
Total Submissions: 383406
Difficulty: Medium
Contributors: Admin
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2]


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)return result;
        Deque<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}



119. Pascal's Triangle II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 97743
Total Submissions: 281034
Difficulty: Easy
Contributors: Admin
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?


public class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        
        List<List<Integer>> pascal = new ArrayList<>();
        
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        pascal.add(temp);
        temp = new ArrayList<>();
        temp.add(1);
        temp.add(1);
        pascal.add(temp);
        if (rowIndex < 2)
            return pascal.get(rowIndex);
            
        for (int i = 2; i <= rowIndex; i++){
            pascal.remove(0);
            temp = new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < pascal.get(0).size() - 1; j++)
                temp.add(pascal.get(0).get(j) + pascal.get(0).get(j + 1));
                
            temp.add(1);
            pascal.add(temp);
        }
        return pascal.get(1);
    
    }
}


Pascal's Triangle   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 110215
Total Submissions: 302497
Difficulty: Easy
Contributors: Admin
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (numRows > 0){
            temp = new ArrayList<>();
            temp.add(1);
            result.add(temp);
        }
        if (numRows > 1){
            temp = new ArrayList<>();
            temp.add(1);temp.add(1);
            result.add(temp);
        }
        for (int i = 2; i < numRows; i++){
            temp = new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < result.get(i - 1).size() - 1; j++){
                temp.add(result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
        
     
    }
}



restore ip address
review


 Reverse Linked List II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 92612
Total Submissions: 311576
Difficulty: Medium
Contributors: Admin
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of listing

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        for (int i = 1; i < m; i++) // for (int i = 0; i < m - 1; i++)
            pre = pre.next;
        
        ListNode start = pre.next;
        ListNode temp = start.next;
        
        for (int i = 0; i < n - m; i++){
            start.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            temp = start.next;
        }
        return dummy.next;
        
    }
    
  
}


Sum Root to Leaf Numbers   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 96735
Total Submissions: 276520
Difficulty: Medium
Contributors: Admin
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
     int result = 0;
     if (root == null) return result;
     Deque<TreeNode> stack = new LinkedList<>();
     stack.offer(root);
     while(!stack.isEmpty()){
         TreeNode node = stack.pop();
         if (node.right != null){
             node.right.val = 10 * node.val + node.right.val;
             stack.push(node.right);
         }
         if (node.left != null){
             node.left.val = 10 * node.val + node.left.val;
             stack.push(node.left);
         }
         if (node.right == null && node.left == null)
            result += node.val;
     }
     return result;
    }
}

Palindrome Partitioning   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 82179
Total Submissions: 269087
Difficulty: Medium
Contributors: Admin
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> solution = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        dfs(result, solution, 0, s);
        return result;
    }
    public void dfs(List<List<String>> result, List<String> solution, int start, String s){
        if (start == s.length()){
            result.add(new ArrayList<String>(solution));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++){
            if (isPalindrome(s.substring(start, i))){
                solution.add(s.substring(start, i));
                dfs(result, solution, i, s);
                solution.remove(solution.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s){
        if (s.length() < 2) return true;
        int i = 0, j = s.length() - 1;
        while(i < j){
            if (s.charAt(i) != s.charAt(j))
               return false;
            else {
                i++;j--;
            }
        }
        return true;
    }
}

/*
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        ArrayList<String> sol = new ArrayList<String>();
        if(s == null || s.length() == 0) return ret;
        dfs(ret, sol, 0, s);
        return ret;
    }
    public void dfs(ArrayList<ArrayList<String>> ret, ArrayList<String> sol, int start, String s){
        if(start == s.length()){
            ret.add(new ArrayList<String>(sol));
            return;
        }
        for(int i = start+1; i <= s.length(); i++){
            if(check(s.substring(start, i))){
                sol.add(s.substring(start, i));
                dfs(ret, sol, i, s);
                sol.remove(sol.size()-1);
            }
        }
    }
    public boolean check(String s){
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}*/


Clone Graph   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 91052
Total Submissions: 364261
Difficulty: Medium
Contributors: Admin
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
		 
		 
		 
	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        map.put(node.label, new UndirectedGraphNode(node.label));
        dfs(map, node);
        return map.get(node.label);
    }
    
    private void dfs(Map<Integer, UndirectedGraphNode> map, UndirectedGraphNode node){
        if (node == null) return;
        
        for (UndirectedGraphNode neighbor: node.neighbors){
            if (!map.containsKey(neighbor.label)){
                map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                dfs(map, neighbor);
            }
            map.get(node.label).neighbors.add(map.get(neighbor.label));
        }
    }

 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 
 
 Gas Station   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 74867
Total Submissions: 262802
Difficulty: Medium
Contributors: Admin
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int amount = 0;
        boolean isPos = true;
        
        int i = 0;
        
        
        
        while (i < gas.length && isPos){
            amount += gas[i];
            amount -= cost[i];
            
            if (amount < 0)
               isPos = false;
            else
               i++;
        }
        return (isPos)?1:0;
    }
}


Candy   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 62076
Total Submissions: 260558
Difficulty: Hard
Contributors: Admin
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++){
            if (ratings[i] > ratings[i - 1])
                candies[i] = 1 + candies[i - 1];
        }
        
        for (int i = ratings.length - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        int count = 0;
        for (int candy: candies)
            count += candy;
        return count;
    }
}


Longest Consecutive Sequence   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 87281
Total Submissions: 248768
Difficulty: Hard
Contributors: Admin
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.


public class Solution {
    public int longestConsecutive(int[] nums) {
    
        
        if (nums == null || nums.length == 0) return 0;
        int maxLen = 1;
        Set<Integer> set = new HashSet<>();
        for (int num: nums)
            set.add(num);
        
        while (!set.isEmpty()){
            int longestSeq = 0;
            int value = set.iterator().next();
            int nextValue = value;
            int prevValue = value - 1;
            while (set.contains(nextValue)){
                longestSeq++;
                set.remove(nextValue);
                nextValue++;
                
            }
            while (set.contains(prevValue)){
                longestSeq++;
                set.remove(prevValue);
                prevValue--;
                
            }
            maxLen = Math.max(maxLen, longestSeq);
        }
        return maxLen;
    }
}



Word Ladder   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 104142
Total Submissions: 539639
Difficulty: Medium
Contributors: Admin
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
          queue.add(beginWord);
        
        int level = 0;
        
        while(!queue.isEmpty()){
        
            int size = queue.size();
            for(int i = 0; i < size; i++){
                
                
                String cur = queue.remove();
                if(cur.equals(endWord)){ return level + 1;}
                for(int j = 0; j < cur.length(); j++){
                    char[] word = cur.toCharArray();
                    
                    
                    for(char ch = 'a'; ch < 'z'; ch++){
                        word[j] = ch;
                        String check = new String(word);
                        if(!check.equals(cur) && wordList.contains(check)){
                            queue.add(check);
                            wordList.remove(check);
                        }
                    }
                    
                    
                }
                
                
            }
            level++;
        }
        return 0;
        
    }
}


Binary Tree Maximum Path Sum   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 82417
Total Submissions: 331187
Difficulty: Hard
Contributors: Admin
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.`

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
    
    public int helper(TreeNode curr){
        if (curr == null) 
            return 0;
        int leftSubTreeSum = Math.max(helper(curr.left), 0);
        int rightSubTreeSum = Math.max(helper(curr.right), 0);
        maxSum = Math.max(maxSum, curr.val + leftSubTreeSum + rightSubTreeSum);
        
        return curr.val + Math.max(leftSubTreeSum, rightSubTreeSum);
    }
}


best time to buy and sell stock 
review them all

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.



public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /* trace the algo
        */
       
        
        
        int[] result = new int[triangle.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = triangle.get(triangle.size() - 1).get(i);
        
        for (int i = (triangle.size() - 2); i >= 0; i--){
            for (int j = 0; j <= i; j++){
                result[j] = triangle.get(i).get(j) + Math.min(result[j], result[j + 1]);
            }
        }
        return result[0];
       
    }
}


Populating Next Right Pointers in Each Node II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 79187
Total Submissions: 237014
Difficulty: Hard
Contributors: Admin
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
	
	
	/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode leftMost = root;
        TreeLinkNode nextLevel = null, current = null;
        
        while(leftMost != null){
            current = leftMost;
            leftMost = null;
            nextLevel = null;
            
            while (current != null){
                if (current.left != null){
                    if (nextLevel == null){
                        nextLevel = current.left;
                        leftMost = current.left;
                    }
                    else {
                        nextLevel.next = current.left;
                        nextLevel = nextLevel.next;
                    }
                }
                if (current.right != null){
                    if (nextLevel == null){
                        nextLevel = current.right;
                        leftMost = current.right;
                    }
                    else {
                        nextLevel.next = current.right;
                        nextLevel = nextLevel.next;
                    }
                }
                current = current.next;
            }
            
        }
    }
}



Populating Next Right Pointers in Each Node   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 112140
Total Submissions: 304625
Difficulty: Medium
Contributors: Admin
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
	
	
	/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode node = root;
        TreeLinkNode leftMost = null;
        while (node.left != null){
            leftMost = node.left;
            while (node != null){
                node.left.next = node.right;
                node.right.next = (node.next == null)?null:node.next.left;
                node = node.next;
            }
            node = leftMost;
        }
        
       
    }
}



Flatten Binary Tree to Linked List   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 107023
Total Submissions: 320586
Difficulty: Medium
Contributors: Admin
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
			 
			 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null){
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null){
                curr.right = curr.left;
                curr.left = null;
            }
            else if (!stack.isEmpty())
                curr.right = stack.pop();
            curr = curr.right;
        }
    }
}



Path Sum II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 106613
Total Submissions: 342077
Difficulty: Medium
Contributors: Admin
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, result, new ArrayList<Integer>(), sum);
        return result;
    }
    
    public void dfs(TreeNode root, List<List<Integer>> result, List<Integer> path, int sum){
        if (root == null) return;
        sum -= root.val;
        path.add(root.val);
        
        if (root.left == null && root.right == null && sum == 0)
            result.add(new ArrayList<>(path));
        dfs(root.left, result, path, sum);
        dfs(root.right, result, path, sum);
        path.remove(path.size() - 1);
    }
}


 Path Sum   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 136431
Total Submissions: 415843
Difficulty: Easy
Contributors: Admin
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Subscribe to see which companies asked this question

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null)
            return root.val == sum;
        else{
            int remaining = sum - root.val;
            return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
        }
    }
    
}


Minimum Depth of Binary Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 140572
Total Submissions: 437342
Difficulty: Easy
Contributors: Admin
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftDepth = (root.left == null)?Integer.MAX_VALUE:minDepth(root.left);
        int rightDepth = (root.right == null)?Integer.MAX_VALUE:minDepth(root.right);
        return 1 + Math.min(leftDepth, rightDepth);
        
        
    }
}


Balanced Binary Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 146750
Total Submissions: 406920
Difficulty: Easy
Contributors: Admin
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    
    public int helper(TreeNode root){
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return 1;
        int leftHeight = helper(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = helper(root.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
  
}


Convert Sorted List to Binary Search Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 90233
Total Submissions: 277131
Difficulty: Medium
Contributors: Admin
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST2(ListNode head) {
        List<Integer> ls = new ArrayList<>();
        ListNode curr = head;
        while (curr != null){
            ls.add(curr.val);
            curr = curr.next;
        }
        return helper(ls, 0, ls.size() - 1);
    }
    public TreeNode helper(List<Integer> ls, int low, int high){
        if (low > high) return null;
        int mid = (low + high)/2;
        TreeNode root = new TreeNode(ls.get(mid));
        root.left = helper(ls, low, mid - 1);
        root.right = helper(ls, mid + 1, high);
        return root;
    }
    
    
    public TreeNode sortedListToBST(ListNode head){
        if (head == null) return null;
        if (head.next == null) 
            return new TreeNode(head.val);
            
        ListNode slow = head, fast = head, pre_mid = null;
        while (fast != null && fast.next != null){
            pre_mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre_mid != null)
            pre_mid.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
    
    
}


 Convert Sorted Array to Binary Search Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 99060
Total Submissions: 246513
Difficulty: Medium
Contributors: Admin
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    public TreeNode helper(int[] nums, int low, int high){
        if (low > high) return null;
        int mid = (low + high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, low, mid - 1);
        root.right = helper(nums, mid + 1, high);
        return root;
    }
    
    
}


 Binary Tree Level Order Traversal II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 107577
Total Submissions: 286987
Difficulty: Easy
Contributors: Admin
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)return result;
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelElements = new ArrayList<>();
            for (int i = 0; i < levelSize; i++){
                TreeNode front = queue.poll();
                if (front.left != null) queue.offer(front.left);
                if (front.right != null) queue.offer(front.right);
                levelElements.add(front.val);   
            }
            result.add(levelElements);
        }
        Collections.reverse(result);
        return result;
        
      
    }
}


Maximum Depth of Binary Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 199736
Total Submissions: 394727
Difficulty: Easy
Contributors: Admin
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        
    }
}


Maximum Depth of Binary Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 199736
Total Submissions: 394727
Difficulty: Easy
Contributors: Admin
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        
    }
}



Binary Tree Zigzag Level Order Traversal   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 82270
Total Submissions: 257505
Difficulty: Medium
Contributors: Admin
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean shouldReverse = false;
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelElements = new ArrayList<>();
            for (int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                levelElements.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (shouldReverse) Collections.reverse(levelElements);
            result.add(levelElements);
            shouldReverse = !shouldReverse;
        }
        return result;
     
    }
}


Symmetric Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 145753
Total Submissions: 397147
Difficulty: Easy
Contributors: Admin
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
   
   
   /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode left, TreeNode right){
        if (left == null || right == null) return left == right;
        return (left.val == right.val) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
    
}


138. Copy List with Random Pointer   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 88673
Total Submissions: 334544
Difficulty: Hard
Contributors: Admin
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = head;
        while(curr != null){
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }
        for (Map.Entry<RandomListNode, RandomListNode> entry: map.entrySet()){
            RandomListNode duplicateNode = entry.getValue();
            duplicateNode.next = map.get(entry.getKey().next);
            duplicateNode.random = map.get(entry.getKey().random);
        }
        return map.get(head);
    }
}

139. Word Break   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 118971
Total Submissions: 425758
Difficulty: Medium
Contributors: Admin
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code"


public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        //https://discuss.leetcode.com/topic/24821/same-as-dp-my-explanation-and-python-sample-code
        boolean [] breakable = new boolean[s.length()+1];
        breakable[0] = true;

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(breakable[j]&&dict.contains(s.substring(j,i))){
                    breakable[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(breakable));
        return breakable[s.length()];   
    }
}


Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)return true;
        }
        return false;
        
       
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class Solution{
    public boolean hasCycle(ListNode head){
        if (head == null || head.next == null) return false;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}



Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                while(fast != head){
                    c++;
                    head = head.next;
                    fast = fast.next;
                }
                
                return head;
            }
        }
        return null;
    }
}


Reorder List   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 80765
Total Submissions: 329661
Difficulty: Medium
Contributors: Admin
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        
        ListNode fast = head.next;
        ListNode slow = head;
        
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode temp = slow.next;
        slow.next = null; // break the link
        ListNode prev = null;
        ListNode front = null;
        
        while (temp != null){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        
        ListNode fw = null;
        ListNode bw = null;
        ListNode tail = prev;
        ListNode curr = head;
        
        while (tail != null){
            fw = curr.next;
            bw = tail.next;
            
            curr.next = tail;
            tail.next = fw;
            
            curr = fw;
            tail = bw;
        }
    }
}


Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) return result;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.right != null)stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            result.add(node.val);
        }
        return result;
    }
}

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1]


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)return result;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            if(root != null){
              stack.push(root);
              result.add(0, root.val);
              root = root.right;
            }
            else
             root = stack.pop().left;
        }
        return result;
    }
}


 LRU Cache   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 102747
Total Submissions: 643536
Difficulty: Hard
Contributors: Admin
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

public class LRUCache {
    class Node{
        int key, value;
        Node prev, next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    int capacity;
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null, end = null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            Node ret = map.get(key);
            remove(ret);
            setHead(ret);
            return ret.value;
        }
        else
            return -1;
    }
    
    private void remove(Node node){
        // if it is first node
        if (node.prev == null)
            head = head.next;
        else
            node.prev.next = node.next;
        
        // if it is last node
        if (node.next == null)
            end = node.prev;
        else
            node.next.prev = node.prev;
    }
    
    private void setHead(Node node){
        node.next = head;
        node.prev = null;
        if (head != null)
            head.prev = node;
        head = node;
        
        if (end == null) end = node;
    }
    public void set(int key, int value) {
        if (map.containsKey(key)){
            Node recentNode = map.get(key);
            recentNode.value = value;
            remove(recentNode);
            setHead(recentNode);
        }
        else {
            Node newNode = new Node(key, value);
            if (map.size() >= capacity){
                map.remove(end.key);
                remove(end);
                setHead(newNode);
            }
            else
                setHead(newNode);
                
            map.put(key, newNode);
        }
        
    }
}




Sort a linked list in O(n log n) time using constant space complexity.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head){
        if (head == null || head.next == null)
            return head;
        
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = sortList(slow.next);
        slow.next = null;
        ListNode firstHalf = sortList(head);
        return merge(firstHalf, secondHalf);
    }
    
    
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        curr.next = (l1 == null)?l2: l1;
        return dummy.next;
    }
   
   
   
}


Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  
  
  public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int first = 0, second = 0;
        for (String token: tokens){
            switch(token){
                case "+":stack.push(stack.pop() + stack.pop());
                         break;
                case "-":first = stack.pop();second = stack.pop();
                         stack.push(second - first);
                         break;
                case "*":stack.push(stack.pop() * stack.pop());
                         break;
                case "/":first = stack.pop();second = stack.pop();
                         stack.push(second / first);
                         break;
                default: stack.push(Integer.parseInt(token));
                         break;
            }
        }
        return stack.pop();
    }
}



Binary Search Tree Iterator   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 71761
Total Submissions: 185704
Difficulty: Medium
Contributors: Admin
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Deque<TreeNode> stack;
    TreeNode curr;
    public BSTIterator(TreeNode root) {
        curr = root;
        stack = new LinkedList<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || curr != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        TreeNode temp = stack.pop();
        int returnValue = temp.val;
        curr = temp.right;
        return returnValue;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
 
 Largest Number   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 62289
Total Submissions: 293143
Difficulty: Medium
Contributors: Admin
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

public class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0)
          return "0";
        
        String s_val[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            s_val[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s_val, new StringComparator());
        System.out.println(Arrays.toString(s_val));
        /** happens when all elements are zero. 
         * after sorting in descending order, the first 
         * element will be 0 . Return 0*/
        if (s_val[0].charAt(0) == '0')
           return "0";
        
        StringBuilder ret = new StringBuilder();
        for (String num: s_val)
          ret.append(num);
          
        return ret.toString();
    }
}

class StringComparator implements Comparator<String>{
    public int compare(String num1, String num2){
        String s1 = num1 + num2;
        String s2 = num2 + num1;
        return s2.compareTo(s1); // sort in descending order.
    }
}

Repeated DNA Sequences   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 62621
Total Submissions: 213544
Difficulty: Medium
Contributors: Admin
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set firstOccurence = new HashSet<>();
        Set repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++){
            String sub = s.substring(i, i + 10);
            if (!firstOccurence.add(sub))
                repeated.add(sub);
        }
        return new ArrayList<>(repeated);
    }
}



Rotate Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 103433
Total Submissions: 443236
Difficulty: Easy
Contributors: Admin
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

public class Solution {
    public void rotate(int[] arr, int k) {
        /* USING EXTRA SPACE
        int[] copy = new int[nums.length];
        int N = nums.length;
        for (int i = 0; i < nums.length; i++)
            copy[i] = nums[i];
        for (int i = 0; i < nums.length; i++)
            nums[(i + k) % N] = copy[i];
            */
            
        int N = arr.length;
        if (k > N) 
            k = k % N;
        reverse(arr, 0, N - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, N - 1);
            
    }
    public void reverse(int[] arr, int s, int e){
        while (s < e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
   
}

Majority Element   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 161390
Total Submissions: 362180
Difficulty: Easyg
Contributors: Admin
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

public class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 1, candidate = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == candidate)
                count++;
            else if (count == 0){
                candidate = nums[i];
                count = 1;
            }
            else
                count--;
        }
        return candidate;
        
      
    }
}




Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

public class Solution {
    // you need treat n as an unsigned value

    
    public int reverseBitss(int n){
        int res = 0;
        for (int i = 0; i < 32; i++){
            res = res << 1; // shift left 1 bit
            res |= (n & 1); // append left most bit of given number to result;
            n >>= 1; // shift right the given number to get the next bit.
        }
        return res;
    }
    
    public int reverseBits(int n){
        int res = 0;
        for (int i = 0; i < 32; i++){
            res <<= 1;
            res |= (n & 1);
            n >>>= 1;
        }
        return res;
    }
}

Given an integer n, return the number of trailing zeroes in n!.

  public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0){
            n /= 5;
            count += n;
        }
        return count;
		
		
 Excel Sheet Column Number   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 110530
Total Submissions: 245587
Difficulty: Easy
Contributors: Admin
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
	
public class Solution {
    public int titleToNumber(String s) {
        int res = 0, N = s.length();
        for (int i = 0; i < N; i++)
            res += Math.pow(26, N - 1 - i) * (s.charAt(i) - 'A' + 1);
        return res;
    }
}



Two Sum II - Input array is sorted   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 42146
Total Submissions: 87975
Difficulty: Medium
Contributors: Admin
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        
        int[] ret = {-1, -1};
        int i = 0, j = numbers.length - 1;
        while (i < j){
            int sum = numbers[i] + numbers[j];
            if (sum == target){
                ret[0] = i + 1;
                ret[1] = j + 1;
                return ret;
            }
            else if (sum < target)
                i++;
            else
                j--;
                
                
        }
        return ret;
    }
}


Fraction to Recurring Decimal   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 43201
Total Submissions: 259110
Difficulty: Medium
Contributors: Admin
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".


public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (denominator == 0) return "NaN";
        StringBuilder ret = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
            ret.append("-");
            
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        ret.append(num / den);
        
        if (num % den == 0) return ret.toString();
        else ret.append(".");
        
        long rem = num % den;
        HashMap<Long, Integer> recu = new HashMap<>();
        
        while (rem > 0){
            if (recu.containsKey(rem)){
               ret.insert(recu.get(rem), "("); 
               ret.append(")");
               break;
            } 
            recu.put(rem, ret.length());
            rem *= 10;
            ret.append(Long.toString(rem / den));
            rem %= den;
        }
        return ret.toString();
        /*
        //check if numerator is zero. return 0
        if (numerator == 0) return "0";
        
        //if denominator == 0, reutnr NAN
        if (denominator == 0) return "NaN";
        
        StringBuilder ret = new StringBuilder();
        
        // if numeroator or denominator is negative add - to ret
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
            ret.append("-");
            
            
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // add the digits to the left of decimal point. i.e num /den
        ret.append(Long.toString(num / den));
        
        // if numerator is multiple of denominator return ret.
        long rem = num % den;
        
        if (rem == 0) return ret.toString();
        
        // otherwise num / den produces digits after decimal point
        else ret.append(".");
        
        
        // handle the digits after decimal point
        HashMap<Long, Integer> map = new HashMap<>();
        
        while (rem > 0){
            if (map.containsKey(rem)){
                ret.insert(map.get(rem), "(");
                ret.append(")");
                break;
            }
            map.put(rem, ret.length());
            rem = rem * 10;
            ret.append(Long.toString(rem / den));
            rem = rem % den;
        }
        return ret.toString();
        */
    }
}


Compare Version Numbers   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 73522
Total Submissions: 384732
Difficulty: Easy
Contributors: Admin
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37


public class Solution {
    public int compareVersion(String version1, String version2) {
       
        String[] tokens1 = version1.split("\\.");
        String[] tokens2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < tokens1.length || j < tokens2.length){
            int v1 = (i < tokens1.length)?Integer.parseInt(tokens1[i]):0;
            int v2 = (j < tokens2.length)?Integer.parseInt(tokens2[j]):0;
            if (v1 > v2) return 1;
            if (v2 > v1) return -1;
            i++;j++;
        }
        return 0;
      
    }
}


Find Peak Element   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 92760
Total Submissions: 260679
Difficulty: Medium
Contributors: Admin
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

public class Solution {
    public int findPeakElement(int[] nums) {
       
        int low = 0, high = nums.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1]))
                return mid;
            if (mid > 0 && nums[mid] < nums[mid - 1])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
     
    }
}



Intersection of Two Linked Lists   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 103940
Total Submissions: 346694
Difficulty: Easy
Contributors: Admin
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
Credits:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode currA = headA, currB = headB;
        while (currA != null){
            lenA++;
            currA = currA.next;
        }
        while (currB != null){
            lenB++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        if (lenA > lenB){
            for (int i = 0; i < (lenA - lenB); i++)
                currA = currA.next;
        }
        if (lenB > lenA){
            for (int i = 0; i < (lenB - lenA); i++)
                currB = currB.next;
        }
        while (currA != null && currB != null){
            if (currA == currB) return currA;
            currA = currA.next;
            currB = currB.next;
        }
        return null;
      
    }
}


 Find Minimum in Rotated Sorted Array II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 66723
Total Submissions: 185211
Difficulty: Hard
Contributors: Admin
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates



public class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (nums[i] < min)min = nums[i];
        //System.out.println("e");
        return min;
    }
}


Find Minimum in Rotated Sorted Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 124578
Total Submissions: 324094
Difficulty: Medium
Contributors: Admin
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

public class Solution {
    public int findMin(int[] nums) {
      
       
       if (nums == null || nums.length == 0) return 0;
       if (nums.length == 1) return nums[0];
       int low = 0, high = nums.length - 1;
       while (low < high){
           int mid = (low + high)  / 2;
           if (mid > 0 && nums[mid] < nums[mid - 1])
            return nums[mid];
           if (nums[mid] >= nums[low] && nums[mid] > nums[high])
            low = mid + 1;
           else
            high = mid - 1;
       }
       return nums[low];
       
       
       
    }
}


Maximum Product Subarray   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 82255
Total Submissions: 338872
Difficulty: Medium
Contributors: Admin
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

public class Solution {
    public int maxProduct(int[] nums) {
        /* trace the algo on a sheet of paper */
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++){
            int tempMax = nums[i] * max;
            int tempMin = nums[i] * min;
            max = Math.max(nums[i], Math.max(tempMax, tempMin));
            min = Math.min(nums[i], Math.min(tempMax, tempMin));
            result = Math.max(max, result);
        }
        return result;
       
    }
}

Reverse Words in a String   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 133067
Total Submissions: 847052
Difficulty: Medium
Contributors: Admin
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() < 1)
              continue;
            if (words[i].length() > 0)
               sb.append(words[i]);
               
            if (i > 0)
              sb.append(" ");
        }
        return sb.toString().trim();
        
    }
}

Number of 1 Bits   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 125676
Total Submissions: 327693
Difficulty: Easy
Contributors: Admin
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            if ((n & 1) == 1) 
                count++;
            n >>>= 1;
        }
        return count;
    }
}




Combination Sum III   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 52962
Total Submissions: 127657
Difficulty: Medium
Contributors: Admin
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[] = new int[9];
        
        for (int i = 1; i <= 9; i++)
            arr[i - 1] = i;
        return combinationSum3(arr, n, k);
    }
    
    public List<List<Integer>> combinationSum3(int[] candidates, int target, int k) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), candidates, target, 0, k);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int index, int k){
        System.out.println(path);
        
        if (target <= 0){
            if (target == 0 && path.size() == k){
                result.add(path);
            }
            return;
        }
        for (int i = index; i < candidates.length; i++ ){
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            List<Integer> pat = new ArrayList<>(path);
            pat.add(candidates[i]);
            dfs(result, pat, candidates, target - candidates[i], i + 1, k);
        }
    }
}


House Robber   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 107941
Total Submissions: 290120
Difficulty: Easy
Contributors: Admin
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
public class Solution {
    public int rob(int[] nums) {
        
        int N = nums.length;
        if (N == 0) return 0;
        if (N == 1) return nums[0];
        int[] dp = new int[N];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i  = 2; i < N; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        return dp[N - 1];
    }
}


Binary Tree Right Side View   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 63714
Total Submissions: 165820
Difficulty: Medium
Contributors: Admin
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

Credits:


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                if (i == 0)result.add(node.val);
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
            }
        }
        return result;
    }
}



Number of Islands   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 78886
Total Submissions: 246752
Difficulty: Medium
Contributors: Admin
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

Credits:



public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j){
        if (i < 0 || j < 0 ||
            i>= grid.length || j >= grid[0].length ||
            grid[i][j] != '1')
            return;
        if (grid[i][j] == '1')grid[i][j] = '2';
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
    }
    
    public int numIslands(char[][] grid){
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
    }
    
    public void dfs(char[][] grid, int i, int j){
        if (i < 0 || j < 0||
            i >= grid.length || j >= grid[0].length
            || grid[i][j] != '1')
            return;
        grid[i][j] = '2';
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1,j);
    }
}

201. Bitwise AND of Numbers Range   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 47365
Total Submissions: 143574
Difficulty: Medium
Contributors: Admin
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m)
            n &= (n - 1);
        return n & m;
    }
}



 Happy Number   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 100968
Total Submissions: 258821
Difficulty: Easy
Contributors: Admin
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Credits:

public class Solution {
    public boolean isHappy(int n) {
       
        
        Set<Integer> uniq = new HashSet<>();
        while (n != 1){
            if (!uniq.add(n))
                return false;
            int sum = 0;
            while(n > 0){
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
        }
        return true;
        
        
    }
}


Remove Linked List Elements   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 91634
Total Submissions: 297352
Difficulty: Easy
Contributors: Admin
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
       
        
        while (head != null && head.val == val)
            head = head.next;
        if (head == null || head.next == null)
            return head;
        ListNode runner = head.next, tail = head;
        
        while (runner != null){
            if (runner.val == val){
                while (runner != null && runner.val == val)
                    runner = runner.next;
                tail.next = runner;
            }
            else {
                tail = tail.next;
                runner = runner.next;
            }
        }
        return head;
    }
    
}

Count the number of prime numbers less than a non-negative number, n.
public class Solution {
    public int countPrimes(int n) {
       
        
         boolean[] isNotPrime = new boolean[n ];
        int count = 0;
        for (int i = 2; i * i <= n; i++){// < Math.sqrt(n); i++){ // test numbers only within range 2 - sqrt(n) 
            if (isNotPrime[i] == false){
                //count++;
                for (int j = i; i * j < n; j++)
                    isNotPrime[j * i] = true;
            }
        }
        for (int i = 2; i < isNotPrime.length; i++)
            if (!isNotPrime[i])count++;
        return count;
       
    }
}


Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.


public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        char sChars[] = new char[256];
        char tChars[] = new char[256];
        int i = 0;
        while (i < s.length()){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (sChars[sc] == 0 && tChars[tc] == 0){
                sChars[sc] = tc;
                tChars[tc] = sc;
            }
            else if (sChars[sc] != tc || tChars[tc] != sc)
                return false;
            i++;
        }
        return true;
    }
}


Reverse a singly linked list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        if (curr == null || curr.next == null) return curr;
        ListNode front = null, prev = null;
        while (curr != null){
            front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
        
    }
}

Implement a trie with insert, search, and startsWith methods.



class TrieNode{
    Map<Character, TrieNode> map;
    boolean endOfWord;
    public TrieNode(){
        map = new HashMap<>();
        endOfWord = false;
    }
}

public class Trie{
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode curr = root;
        for (char ch: word.toCharArray()){
            TrieNode node = curr.map.get(ch);
            if (node == null){
                node = new TrieNode();
                curr.map.put(ch, node);
            }
            curr = node;
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word){
        TrieNode curr = root;
        for (char ch: word.toCharArray()){
            TrieNode node = curr.map.get(ch);
            if (node == null)
                return false;
            curr = node;
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix){
        TrieNode curr = root;
        for (char ch: prefix.toCharArray()){
            if (!curr.map.containsKey(ch))
                return false;
            curr = curr.map.get(ch);
        }
        return true;
    }
}


// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");


Minimum Size Subarray Sum   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 62788
Total Submissions: 221373
Difficulty: Medium
Contributors: Admin
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        /*
        tricky problem 
        practice it on a sheet of paper
        */
        int minLen = Integer.MAX_VALUE;
        int low = 0;
        int high = 0;
        
        int sum = 0;
        int N = nums.length;
        
        while (high < N){
            while (high < N && sum < s){
                sum += nums[high];
                high++;
            }    
            
            while (low <= high && sum >= s){
                minLen = Math.min(minLen, high - low);
                sum -= nums[low];
                low++;
            }
        }
        
        return (minLen == Integer.MAX_VALUE)?0:minLen;
        
       
    }
}

Course Schedule II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 46998
Total Submissions: 186033
Difficulty: Medium
Contributors: Admin
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.


public class Solution {
 public int[] findOrder(int numCourses,int[][] prerequisites){
       List<List<Integer>> list = new ArrayList<>();
       for (int i = 0; i < numCourses; i++)
        list.add(new ArrayList<>());
      
       int inDegree[] = new int[numCourses];
       for (int[] p: prerequisites){
           int to = p[0];
           int from = p[1];
           inDegree[to]++;
           list.get(from).add(to);
       }
       Queue<Integer> queue = new LinkedList<>();
       List<Integer> result = new ArrayList<>();
       
       
       for (int i = 0; i < numCourses; i++){
         if (inDegree[i] == 0) {
             queue.add(i);
             result.add(i);
         }    
       }
       while (!queue.isEmpty()){
           int node = queue.poll();
           for (int to: list.get(node)){
               inDegree[to]--;
               if (inDegree[to] == 0){
                   queue.offer(to);
                   result.add(to);
               }
           }
       }
       
       if (result.size() < numCourses)
        return new int[0];
        
       int ret[] = new int[result.size()];
       for (int i = 0; i < ret.length; i++)
        ret[i] = result.get(i);
    
       return ret;
    }
}



 Add and Search Word - Data structure design   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 41012
Total Submissions: 204141
Difficulty: Medium
Contributors: Admin
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

use trie for this

public class WordDictionary {
    public class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        boolean endOfWord = false;
    }
    TrieNode root;
    public WordDictionary(){
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch: word.toCharArray()){
            if (curr.map.containsKey(ch))
                curr = curr.map.get(ch);
            else {
                TrieNode newNode = new TrieNode();
                curr.map.put(ch, newNode);
                curr = newNode;
            }
        }
        curr.endOfWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchDFS(word, 0, root);
    }
    private boolean searchDFS(String word, int pos, TrieNode root){
        if (pos == word.length())
            return root.endOfWord;
        Character c = word.charAt(pos);
        
        for (Map.Entry<Character, TrieNode> entry: root.map.entrySet()){
            Character trieCh = entry.getKey();
            TrieNode trieNode = entry.getValue();
            if (trieCh == c || c == '.'){
                if (searchDFS(word, pos + 1, trieNode))
                    return true;
            }
        }
        return false;         
    }
}
//https://discuss.leetcode.com/topic/45512/easy-java-solution

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");


 Shortest Palindrome   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 31906
Total Submissions: 140416
Difficulty: Hard
Contributors: Admin
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd"


public class Solution {
    public String shortestPalindrome(String s) {
         int i = 0, end = s.length() - 1, j = end;
        char[] chars = s.toCharArray();
        
        while (i < j){
            if (s.charAt(i) == s.charAt(j)) {
            //if (chars[i] == chars[j]){
                i++;j--;
            }
            else {
                i = 0;
                end--;
                j = end;
            }
            
        }
        StringBuilder prefix = new StringBuilder(s.substring(end + 1));
        return prefix.reverse().toString() + s;
    }
}

 Kth Largest Element in an Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 97555
Total Submissions: 262277
Difficulty: Medium
Contributors: Admin
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.


public class Solution {
    public int findKthLargest(int[] nums, int k) {
      /*PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length, Collections.reverseOrder());
      for (int num: nums)
        maxHeap.offer(num);
        
      int result = 0;
      for (int i = 0; i < k; i++)
        result = maxHeap.poll();
    
      return result;*/
      PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
      int i = 0;
      while (i < k)
        minHeap.offer(nums[i++]);
     
      while(i < nums.length){
          if (minHeap.peek() < nums[i]){
            minHeap.poll();
            minHeap.offer(nums[i]);
          }
          i++;
      }
      return minHeap.peek();
    }
}

/* using quick select
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1, nums.length - k);
    }
    public int helper(int[] nums, int low, int high, int k){
        if (low >= high) return nums[low];
        int pivotIndex = partition(nums, low, high);
        
        if (pivotIndex == k) return nums[k];
        if (pivotIndex < k) return helper(nums, pivotIndex + 1, high, k);
        else return helper(nums, low, pivotIndex - 1, k);
    }
    
    public int partition(int[] nums, int low, int high){
        int i = low + 1, j = high, pivotElement = nums[low];
        while (true){
            while (nums[i] < pivotElement){
                i++;
                if (i >= high) break;
            }
            while (nums[j] >= pivotElement){
                j--;
                if (j <= low) break;
            }
            if (i >= j) break;
            
            if (i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp2 = nums[j];
        nums[j] = nums[low];
        nums[low] = temp2;
        return j;
    }
    
   
}
*/

$$$
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniq = new HashSet<>();
        for (int num: nums)
            if(!uniq.add(num))return true;
        return false;
    }
}

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
     
     
     Map<Integer, Integer> map = new HashMap<>();
     for (int i = 0; i < nums.length; i++){
         if (map.containsKey(nums[i]) && (Math.abs(map.get(nums[i]) - i) <= k))
            return true;
        map.put(nums[i], i);
     }
     return false;
     
    
   
}



In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);
        
        if (leftHeight == rightHeight)
            return (2 << (leftHeight - 1)) - 1; // you will get TLE if you use Math.pow(2, leftHeight);
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    public int findLeftHeight(TreeNode root){
        if (root == null)
            return 0;
        int leftHeight = 1;
        while (root.left != null){
            leftHeight++;
            root = root.left;
        }
        return leftHeight;
    }
    
    public int findRightHeight(TreeNode root){
        if (root == null)
            return 0;
        int rightHeight = 1;
        while (root.right != null){
            rightHeight++;
            root = root.right;
        }
        return rightHeight;
    }
}

/*
public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
         
        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);
         
        if (leftHeight == rightHeight) {
            return (2 << (leftHeight - 1)) - 1;
        }
         
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
     
    private int findLeftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
         
        int height = 1;
         
        while (root.left != null) {
            height++;
            root = root.left;
        }
         
        return height;
    }
     
    private int findRightHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
         
        int height = 1;
         
        while (root.right != null) {
            height++;
            root = root.right;
        }
         
        return height;
    }
}
*/



rectangle area
review


maximal area
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int M = matrix.length;
        if (M == 0) return 0;
        int N = matrix[0].length;
        int result = 0;
        int dp[][] = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++){
            for (int j = 1; j <= N; j++){
              
                
                // if matrix has 1 in that slot, dp =  minimum of all the surround 3 slots + 1
                if (matrix[i - 1][j - 1] == '1'){
                    int temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(temp, dp[i - 1][j - 1]) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result * result;
    }
}



mplement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
public class Solution {
    public int calculate(String s) {
     Deque<Integer> stack = new LinkedList<>();
     int result = 0, sign = 1;
     stack.push(1);
     for (int i = 0; i < s.length(); i++){
         char ch = s.charAt(i);
         
         if (ch == ' ')continue;
         else if (ch == '('){
             stack.push(stack.peek() * sign);
             sign = 1;
         }
         else if (ch == ')')
            stack.pop();
         else if (ch == '+')
            sign = 1;
         else if (ch == '-')
            sign = -1;
         else {
             int temp = ch - '0';
             //i += 1;
             //while (i < s.length() && Character.isDigit(s.charAt(i)))
               // temp = temp * 10 + s.charAt(i++) - '0';
             while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
                temp = temp * 10 + s.charAt(++i) - '0';
             result += sign * stack.peek() *  temp;
         }
     }
     return result;
    }
}


Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
Update (2015-06-11):
The class name of the Java function had been updated to MyStack instead of Stack

class MyStack {
    // Push element x onto stack.
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public void push(int x) {
        q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(q1.size() > 1) q2.offer(q1.poll());
        q1.poll();
        while(!q2.isEmpty()) q1.offer(q2.poll());
    }

    // Get the top element.
    public int top() {
        while(q1.size() > 1) q2.offer(q1.poll());
        int ret = q1.poll();
        q2.offer(ret);
       while(!q2.isEmpty()) q1.offer(q2.poll());
        return ret;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}


Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tempRight = root.right;
        root.right = root.left;
        root.left = tempRight;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    
    
}



Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5

public class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char sign = '+';
        for (char ch: s.toCharArray()){
            if (ch == ' ')
                continue;
            if(Character.isDigit(ch))
                num = num * 10 + (ch - '0');
            else {
                if (sign == '+')
                    stack.push(num);
                else if (sign == '-')
                    stack.push(-num);
                else if (sign == '*')
                    stack.push(stack.pop() * num);
                else
                    stack.push(stack.pop() / num);
                num = 0;
                sign = ch;
            }
        }
        if (sign == '+')
            stack.push(num);
        else if (sign == '-')
            stack.push(-num);
        else if (sign == '*')
            stack.push(stack.pop() * num);
        else
            stack.push(stack.pop() / num);
        
        
        int result = 0;
        while (!stack.isEmpty())
            result += stack.pop();
        return result;
    }
}



Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        /*
        if (head == null || head.next == null)return true;
        int len = 0;
        
        ListNode curr = head;
        while (curr != null){
            len += 1;
            curr = curr.next;
        }
        curr = head;
        ListNode prev = null, front = null;
        for (int i = 0; i < len / 2; i++){
            front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        if (len % 2 != 0)
            curr = curr.next;
        
        while (curr != null){
            if (curr.val != prev.val)
                return false;
            curr = curr.next;
            prev = prev.next;
        }
        return true;
        */
        
        
        // DOESN'T MODIFY THE LIST. IE DOESN NOT REVERSE THE FIRST HALF
        if (head == null || head.next == null)return true;
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head, tail = null;
        int len = 0;
        while (curr != null){
            len++;
            curr = curr.next;
        }
        curr = head;
        for (int i = 0; i < len / 2; i++){
            stack.push(curr.val);
            tail = curr;
            curr = curr.next;
        }
        if (curr == head)  // handle the case [1, 2]
            stack.push(curr.val);
        if (len % 2 != 0)
            curr = curr.next;
        while (curr != null && !stack.isEmpty()){
            if (stack.pop() != curr.val) return false;
            curr = curr.next;
        }
        return true;
        
       
    }
}




Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
Subscribe to see which companies asked this question

class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!s1.isEmpty())
            s2.push(s1.pop());
        s2.pop();
        while(!s2.isEmpty())
            s1.push(s2.pop());
    }

    // Get the front element.
    public int peek() {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int ret = s2.peek();
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return ret;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty();
    }
}


Given an integer, write a function to determine if it is a power of two.

public class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}


Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 sma
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Show Hint 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
        return -1;
     
    }
}

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.


public class Solution {
    public List<Integer> majorityElement(int[] nums) {
       
        
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 0;
        for (int num: nums){
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
            else if (count1 == 0){
                count1 = 1;
                candidate1 = num;
            }
            else if (count2 == 0){
                count2 = 1;
                candidate2 = num;
            }
            else {
                count1--;count2--;
            }
        }
        count1 = 0;count2 = 0;
        List<Integer> result = new ArrayList<>();
        for (int num: nums){
            if (num == candidate1)count1++;
            else if (num == candidate2)count2++;
        }
        if (count1 > nums.length/3)result.add(candidate1);
        if (count2 > nums.length/3)result.add(candidate2);
        return result;
       
       
    }
}



Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.

 if (num < 1)
         return false;
         
       while (num % 2 == 0)
          num /= 2;
    
       while (num % 3 == 0)
          num /= 3;
          
       while (num % 5 == 0)
          num /= 5;
          
       return (num == 1);
	   
	   
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

public class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> uniq = new HashSet<>();
        for (int num: nums)
            if (!uniq.add(num))
                uniq.remove(num);
        int[] ret = new int[2];
        Iterator iter = uniq.iterator();
        int i = 0;
        while(iter.hasNext())
            ret[i++] = (int)iter.next();
        return ret;
    }
}

public class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> uniq = new HashSet<>();
        for (int num: nums)
            if (!uniq.add(num))
                uniq.remove(num);
        
        Object[] arr = uniq.toArray();
        int[] ret = new int[arr.length];
        ret[0] =(int)arr[0];
        ret[1] = (int)arr[1];
        return ret;
    }
}


Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?

 int sum = 0;
        
        boolean isValid = true;
        HashSet<Integer> sumValue = new HashSet<Integer>();
        
        while (num > 9 && isValid){
            sum = 0;
            
            while (num > 0){
                sum += num % 10;
                num /= 10;
            }
            
            if (sumValue.contains(sum))
                isValid = false;
            num = sum;
        }
        
        return (isValid)?num:Integer.MIN_VALUE;
        
		
		
	Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
   
    
    public List<String> binaryTreePaths(TreeNode root){
        List<String> result = new ArrayList<>();
        if (root != null)
            dfs(result, "", root);
        return result;
    }
    
    public void dfs(List<String> result, String path, TreeNode root){
        if (root.left == null && root.right == null)
            result.add(path + root.val);
        if (root.left != null)
            dfs(result, path + root.val + "->", root.left);
        if (root.right != null)
            dfs(result, path + root.val + "->", root.right);
    }
    
    
    
}


Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.


public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0){
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }
}



Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

public class Solution {
    public int[] productExceptSelf(int[] nums) {
       /* trace this
       */
       
       
       
       int[] result = new int[nums.length];
       int temp = 1;
       for (int i = 0; i < result.length; i++){
           result[i] = temp;
           temp *= nums[i];
       }
       temp = 1;
       for (int i = nums.length - 1; i >= 0; i--){
           result[i] *= temp;
           temp *= nums[i];
       }
       return result;
       
   
    }
}


Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}


Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null;
        if (left != null && right != null) return root;
        return (left != null)?left:right;
        
    }
}


Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
        
      
    }
}




Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

public class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int num: nums) res ^= num;
        for (int i = 0; i <= nums.length; i++)
            res ^= i;
        return res;
    }
}

Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"


public class Solution {
   // another more challenging way: https://discuss.leetcode.com/topic/27315/6ms-java-solution
    
    private final String[] oneToNine = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    
    private final String[] TenToNineteen = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    private final String[] Tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num){
        if (num == 0)return "Zero"; // base case
        return convert(num);
    }
    
    public String convert(int num){
        String result = new String();
        if (num < 10)
            result = oneToNine[num];// 1 - 9
        else if (num < 20) 
            result = TenToNineteen[num - 10]; // 10 - 19
        else if (num < 100)
            result = Tens[num / 10] + " " + oneToNine[num % 10];//20 - 30 .. break it into tens + units
        else if (num < 1000)
            result = oneToNine[num / 100] + " Hundred " + convert(num % 100); // break it into hundreds + fun(last two digits). since the above two lines handle the situation for numbers < 100, call fun recursively on last two digits.
        else if (num < 1000000)
            result = convert(num / 1000) + " Thousand " + convert(num % 1000);// break it into thousands + fun(last 3 digits)
        else if (num < 1000000000)
            result = convert(num / 1000000) + " Million " + convert(num  % 1000000);
        else
            result = convert(num / 1000000000) + " Billion " + convert(num % 1000000000);
        
        return result.trim();
            
    }
}

Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

public class Solution {
    public int hIndex(int[] citations) {
     int N = citations.length;
     int[] temp = new int[N + 1];
     for (int num: citations){
         if (num > N)
            temp[N]++;
        else
           temp[num]++;
     }
     
     int i = N;
     int ret = 0;
     while (i >= 0){
         ret += temp[i];
         if (ret >= i)
           return i;
         else 
           i--;
     }
     return ret;
    }
}


You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 0, end = n;
        while (start < end){
            int mid = start + (end - start)/2;
            if (isBadVersion(mid))
                end = mid;
            else
                start = mid + 1;
        }
        return start;
       
    }
}


Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

public class Solution {
    public int numSquares(int n) {
        if(n <= 0){
		return 0;
	}
	
	int[] dp = new int[n+1];
	Arrays.fill(dp, Integer.MAX_VALUE);
	dp[0] = 0;
	dp[1] = 1;
	
	//to compute least perfect for n we compute top down for each 
	//possible value sum from 2 to n
	for(int i = 2; i<=n; i++){
		//for a particular value i we can break it as sum of a perfect square j*j and 
		//all perfect squares from solution of the remainder (i-j*j)
		for(int j = 1; j*j<=i; j++){
			dp[i] = Math.min(dp[i], 1+dp[i-j*j]);
		}
	}
	
	return dp[n];
    }
}


Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
Credits:

public class Solution {
    public void moveZeroes(int[] nums) {
       /*
        int i = 0, j = nums.length - 1;
        while (i < j){
            while (i < j && nums[i] != 0)
                i++;
            while (i < j && nums[j] == 0)
                j--;
            if (i >= j)break;
            if (i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        */
        for (int i = 0; i < nums.length; i++){
            int j = i;
            while (j > 0 && nums[j] != 0 && nums[j - 1] == 0){
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
        }
        
        
    }
}

iven an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.


public class Solution {
    public int findDuplicate(int[] nums) {
        for (int num: nums){
            int val = Math.abs(num);
            if (nums[val] < 0) return val;
            nums[val] = -nums[val];
        }
        return nums[nums.length - 1];
    }
}


Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        
        Map map = new HashMap();
        char[] characters = pattern.toCharArray();
        String[] words = str.split(" ");
        if (characters.length != words.length) 
            return false;
        for (Integer i = 0; i < characters.length; i++){
            if (map.put(characters[i], i) != map.put(words[i], i))
                return false;
        }
        return true;
    }
}



You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be remove, the last stone will always be removed by your friend.

Show Hint 


public class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}



Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2

public class MedianFinder {
    PriorityQueue<Integer> minHeap, maxHeap;
    // Adds a number into the data structure.
    public MedianFinder(){
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num){
        if (minHeap.isEmpty() || num >= minHeap.peek())
            minHeap.offer(num);
        else
            maxHeap.offer(num);
            
        if (minHeap.size() - maxHeap.size() > 1) maxHeap.offer(minHeap.poll());
        else if (maxHeap.size() - minHeap.size() > 1) minHeap.offer(maxHeap.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) return (minHeap.peek() + maxHeap.peek())/2.0;
        if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
        else
            return minHeap.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();


Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.



Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serializedString = new StringBuilder();
        helper(root, serializedString);
        return serializedString.toString();
    }
    
    public void helper(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        helper(root.left, sb);
        helper(root.right, sb);
    }
    int index = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        return deHelper(tokens);
    }
    
    public TreeNode deHelper(String[] token){
        if (index == token.length || token[index].equals("null")){
            index += 1;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(token[index]));
        index += 1;
        node.left = deHelper(token);
        node.right = deHelper(token);
        return node;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));



You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate digits, for example:

Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.

public class Solution {
    public String getHint(String secret, String guess) {
     int bull = 0, cow = 0;
     int[] number = new int[10];
     for (int i = 0; i < secret.length(); i++){
         int s = Character.getNumericValue(secret.charAt(i));
         int g = Character.getNumericValue(guess.charAt(i));
         
         if (s == g) // position and value match
            bull++;
        
        else {
            if (number[s] < 0) // is it encountered in guess?
                cow++;
            if (number[g] > 0) // is it encountered in secret?
                cow++;
            number[s]++;// encounterd in s
            number[g]--;// encountered in g
        }
     }
     return bull + "A" + cow + "B";
    }
}


Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)return 0;
        //if (nums.length < 2) return 1;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i])
                  dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num: dp)
            if (num > max) max = num;
        return max;
    }
}


range sum query -immutable
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.

public class NumArray {
    int[] dp;
    public NumArray(int[] nums) {
        dp = nums;
        for (int i = 1; i < dp.length; i++)
            dp[i] = dp[i - 1] + nums[i];
    }

    public int sumRange(int i, int j) {
        return (i == 0)?dp[j]:dp[j] - dp[i - 1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);


You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> rst = new ArrayList<>(nums.length);
     for (int i = 0; i < nums.length; i++)
         rst.add(0);
     List<Integer> sorted = new ArrayList<>();
      
     for (int i = nums.length - 1; i >= 0; i--) {
         int left = 0, right = sorted.size();
         while (left < right) {
             int mid = (left + right) / 2;
             if (sorted.get(mid) < nums[i]) {
                 left = mid + 1;
             } else {
                 right = mid;
             }
         }
         rst.set(i, right);
         sorted.add(right, nums[i]);
     }
     
     return rst;
    }
}

Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"

public class Solution {
    public String removeDuplicateLetters(String s) {
          int[] count = new int[26];
  boolean[] used = new boolean[26];
  Stack<Character> stack = new Stack<Character>();
  
  for (char letter : s.toCharArray())
    count[letter - 'a']++;
 
  for (char letter : s.toCharArray()) {
    count[letter - 'a']--;
    if (used[letter - 'a'])
      continue;
    while (!stack.isEmpty() && stack.peek() > letter && count[stack.peek() - 'a'] > 0)
      used[stack.pop() - 'a'] = false;
 
    stack.push(letter);
    used[letter - 'a'] = true;
  }
 
  String finalstr = "";
  while (!stack.isEmpty()) {
      finalstr = stack.pop() + finalstr;
  }
 
  return finalstr;
}
}




Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.

public class Solution {
    public int maxProduct(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++){
            for (int j = i + 1; j < words.length; j++)
                if (isUnique(words[i], words[j]))
                    result = Math.max(result, words[i].length() * words[j].length());
        }
        return result;
    }
    
    private boolean isUnique(String val1, String val2){
        int[] ascii = new int[128];
        for (int i = 0; i < val1.length(); i++)
            ascii[val1.charAt(i)] = 1;
        for (int i = 0; i < val2.length(); i++)
            if (ascii[val2.charAt(i)] == 1)
                return false;
        return true;
    }
}


There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

Example:

Given n = 3. 

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.

public class Solution {
    public int bulbSwitch(int n) {
        //return (int)Math.sqrt(n);
        int count = 0;
        for (int i = 1; i * i <= n; i++)
            count++;
        return count;
    }
}


Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?

public class Solution {
    public void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int i = 1, j = nums.length - 1;
        while (i < nums.length){
            nums[i] = copy[j--];
            i += 2;
        }
        i = 0;
        while (i < nums.length){
            nums[i] = copy[j--];
            i += 2;
        }
    }
}



Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?


public class Solution {
    public boolean isPowerOfThree(int num) {
        if (num < 1) return false;
        if (num == 1) return true;
        while (num > 2){
            if (num % 3 != 0)
                return false;
            num /= 3;
        }
        return num == 1;
    }
}


Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = head, even = head.next, firstEven = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = firstEven;
        return head;
        
    }
}




Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

public class Solution {
    // IDEA: KEEP TRACK OF LONGEST STRICTLY INCREASING PATH  ORIGINATING FROM EVERY CELL
    // USE CACHE TO KEEP TRACK OF LONGEST STRICTLY INCREASING PATH
    public int longestIncreasingPath(int[][] matrix) {
        	if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
			return 0;

		int max = 0, n = matrix.length, m = matrix[0].length;

		// create a cache matrix
		int[][] cache = new int[n][m];

		// dfs search on every element in matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(dfs(matrix, Integer.MIN_VALUE, i, j, n, m, cache), max);
			}	
		}
		return max;
    }
    
    public int dfs(int[][] matrix, int min, int i, int j, int n, int m, int[][] cache) {

		// check boundary limits
		if (i < 0 || j < 0 || i >= n || j >= m)
			return 0;

		// check min condition
		if (matrix[i][j] <= min)
			return 0;

		// check into cache
		if (cache[i][j] != 0)
			return cache[i][j];

		// update min
		min = matrix[i][j];

		// run dfs in all four directions
		int a = dfs(matrix, min, i - 1, j, n, m, cache) + 1;
		int b = dfs(matrix, min, i + 1, j, n, m, cache) + 1;
		int c = dfs(matrix, min, i, j - 1, n, m, cache) + 1;
		int d = dfs(matrix, min, i, j + 1, n, m, cache) + 1;
        
		// find max and update cache
		int max = Math.max(a, Math.max(b, Math.max(c, d)));
		cache[i][j] = max;

		return max;
	}
}


One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false

public class Solution {
    public boolean isValidSerialization(String preorder) {
        Deque<String> stack = new LinkedList<>();
        stack.push("#");
        String[] tokens = preorder.split("\\,");
        if (tokens.length == 1 && tokens[0].equals("#"))
            return true;
        for (String s: tokens){
            if (stack.isEmpty())
                return false;
            stack.pop();
            if(!s.equals("#")){
                stack.push("#");
                stack.push("#");
            }
        }
        return stack.isEmpty();
    }
}


Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

Credits:

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket: tickets){
            if (!map.containsKey(ticket[0]))
                map.put(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).offer(ticket[1]);
        }
        Deque<String> stack = new LinkedList<>();
        stack.push("JFK");
        while(!stack.isEmpty()){
            String nextAirport = stack.peek();
            if (map.containsKey(nextAirport) && map.get(nextAirport).size() > 0)
                stack.push(map.get(nextAirport).poll());
            else
                result.add(0,stack.pop());
        }
        return result;
    }
}



Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num: nums){
            if (num <= min) min = num;
            else if(num < secondMin) secondMin = num;
            else if(num > secondMin) return true;
        }
        return false;
    }
}

Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        int n = words.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
              
                if (isPalindrome(words[i] + words[j])) {
                    ArrayList<Integer> pair = new ArrayList<Integer>();
                    if (i != j){
                        pair.add(i);
                        pair.add(j);
                        res.add(pair);
                    }
                }
              
            }
        }
        
        return res;
    }
    
    public boolean isPalindrome(String word){
        if (word.length() < 2)
            return true;
        
        int i = 0;
        boolean isPal = true;
        int n = word.length();
        
        while (i < n / 2 && isPal){
            if (word.charAt(i) != word.charAt(n - i - 1))
                isPal = false;
            else 
                i++;
        }
        
        return isPal;
    }
}



Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

public class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i] = (i % 2 == 0)?dp[i / 2]:dp[i / 2] + 1;
        return dp;
    }
}


Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

public class Solution {
    public boolean isPowerOfFour(int num) {
      return (num > 0) && ((num & (num - 1)) == 0) && ((num - 1) % 3 == 0);
    }
}

Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).


public class Solution {
    public int integerBreak(int n) {
        if (n == 2 || n == 3) return n - 1;
        if (n == 4) return n;
        int sum = 1;
        while (n > 4){
            n -= 3;
            sum *= 3;
        }
        return sum * n;
    }
}

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
public class Solution {
    public String reverseString(String s) {
        StringBuilder ret = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
           ret.append(s.charAt(i));
           
        return ret.toString();
        
    }
}

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

public class Solution {
    public String reverseVowels(String s) {
        
        
        if (s.length() < 2) return s;
        char[] chars = s.toCharArray();
        Set<Character> vowels = new HashSet<>();
        char[] vow = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char v: vow)
            vowels.add(v);
        int i = 0, j = chars.length - 1;
        while (i < j){
            while (i < j && !vowels.contains(chars[i]))
                i++;
            while (i < j && !vowels.contains(chars[j]))
                j--;
            if (i < j){
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;j--;
            }
        }
        return new String(chars);
     
    }
}



Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //  WHATE ARE THE CORNER CASES FOR THIS
        Map<Integer, Integer> map = new HashMap<>();
        for (int key: nums){
            if (!map.containsKey(key))
                map.put(key, 1);
            else
                map.put(key, map.get(key) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                return e2.getValue() - e1.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry: map.entrySet())
            heap.offer(entry);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++)
            result.add(heap.poll().getKey());
        return result;
       
       
       
       
    }
    
  
}


Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       /* Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        HashSet<Integer> intersect = new HashSet<>();
        while(i < nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]){
                intersect.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        int[] result = new int[intersect.size()];
        i = 0;
        for (int num: intersect){
            result[i] = num;
            i++;
        }
        return result;*/
        HashSet<Integer> intersect = new HashSet<>();
        for (int num: nums1)
            intersect.add(num);
        List<Integer> temp = new ArrayList<>();
        for (int num: nums2){
            if (intersect.contains(num)){
                temp.add(num);
                intersect.remove(num);
            }
                
        }
        int[] ret = new int[temp.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = temp.get(i);
        return ret;
        
        
       
    }
}


Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?


public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        /*Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]){
                temp.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j])
              i++;
            else
              j++;
        }
        int[] result = new int[temp.size()];
        int k = 0;
        for (int num: temp){
            result[k] = num;
            k++;
        }
        return result;
        */
       
       
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums1)
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
                
        List<Integer> lis = new ArrayList<>();
        for (int num: nums2){
            if (map.containsKey(num)){
                if (map.get(num) > 0)
                    lis.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] ret = new int[lis.size()];
        for (int i = 0; i < lis.size(); i++)
            ret[i] = lis.get(i);
            
        return ret;
        
        
        //THIS DOESN'T WORK FOR : [1] [1,1]. the output should be [1]
        /*
        Set<Integer> one = new HashSet<>();
        for (int num: nums1)
            one.add(num);
        List<Integer> both = new ArrayList<>();
        for (int num: nums2){
            if (one.contains(num))
                both.add(num);
        }
        int[] ret = new int[both.size()];
        for (int i = 0; i < both.size(); i++)
            ret[i] = both.get(i);
        return ret;
        */
    }
}


You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Example:
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // SORT ENVELOPES IN ASCENDING ORDER OF WIDTH AND IF WIDTH ARE EQUAL, DESCENDING ORDER OF HEIGHT
        // then find longest common subsequence
        if (envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               if (a[0] == b[0])
                return b[1] - a[1];
               else
                return a[0] - b[0];
           } 
        });
        
        int[] arr = new int[envelopes.length];
        int max = Integer.MIN_VALUE;
        Arrays.fill(arr, 1);
        for(int i=1; i<envelopes.length; i++){
            for(int j= 0; j < i; j++){
                if(envelopes[j][0]<envelopes[i][0]&&envelopes[j][1]<envelopes[i][1]){
                    arr[i]=Math.max(arr[i], arr[j]+1);
                }
            }
            
        }
        for (int num: arr)
            max = Math.max(num, max);
        return max;
 
    }
}


Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);




public class Twitter {
    
    private class Tweet{
        int tweetId, userId;
        Tweet(int tweetId, int userId){
            this.tweetId = tweetId;
            this.userId = userId;
        }
    }
    
    private static final int NEWS_FEED_SIZE = 10;
    private Deque<Tweet> tweets = new ArrayDeque<>();
    private Map<Integer, Set<Integer>> followerFolloweeMap = new HashMap<>();
    
    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(tweetId, userId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>(NEWS_FEED_SIZE);
        Set<Integer> followees = followerFolloweeMap.get(userId);
        Iterator it = tweets.descendingIterator();
        
        while (it.hasNext() && newsFeed.size() < NEWS_FEED_SIZE){
            Tweet tweet = (Tweet)it.next();
            if (tweet.userId == userId || (followees != null && followees.contains(tweet.userId)))
                newsFeed.add(tweet.tweetId);
        }
        return newsFeed;
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!followerFolloweeMap.containsKey(followerId))
            followerFolloweeMap.put(followerId, new HashSet<>());
        followerFolloweeMap.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerFolloweeMap.containsKey(followerId)){
            Set<Integer> followees = followerFolloweeMap.get(followerId);
            if (followees.contains(followeeId))
                followees.remove(followeeId);
        }
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
 
 
 
 Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 

public class Solution {
    public int countNumbersWithUniqueDigits(int n){
        if (n == 0) return 1;
        int ans = 10;
        int base = 9;
        for (int i = 2; i <= n; i++){
            base = base * (9 - i + 2);
            ans += base;
        }
        return ans;
    }
}



Water and Jug Problem   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 10073
Total Submissions: 38843
Difficulty: Medium
Contributors: Admin
You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.

If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.

Operations allowed:

Fill any of the jugs completely with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
Example 1: (From the famous "Die Hard" example)

Input: x = 3, y = 5, z = 4
Output: True
Example 2:

Input: x = 2, y = 6, z = 5
Output: False

public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == z || y == z || x + y == z)
            return true;
        return z % GCD(x, y) == 0;
    }
    
    public int GCD(int a, int b){
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}


Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False

public class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0){
            num -= i;
            i += 2;
        }
        return num == 0;
        int i = 1;
        while (num > 0){
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}


add without + and -
public class Solution {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0){
            int AND = a & b, XOR = a ^ b;
            a = XOR;
            b = AND << 1;
        }
        return a;
    }
}




A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

Examples:
Input: [1,7,4,9,2,5]
Output: 6
The entire sequence is a wiggle sequence.

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
Follow up:
Can you do it in O(n) time?

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int index = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i - 1]){
                    nums[index] = nums[i];
                    index++;
            }
        }
        
        int count = (index >= 2)? 2: index;
        for (int i = 2; i < index; i++){
            if ((nums[i - 1] - nums[i - 2]) * (nums[i] - nums[i - 1]) < 0)
                count++;
        }
        return count;
    }
}


 Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 1 is the only number in the set, getRandom always return 1.
randomSet.getRandom();

public class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) 
            return false;
        int index = map.remove(val);
        int lastElement = list.remove(list.size() - 1);
        if (lastElement == val) return true;
        map.put(lastElement, index);//IMPORTANT
        list.set(index, lastElement);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
 
 
 
 Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();

public class RandomizedCollection {
    ArrayList<Integer> list;
    Map<Integer, LinkedHashSet<Integer>> map;
    
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    public boolean insert(int val){
        boolean exists = map.containsKey(val);
        if (!exists)
            map.put(val, new LinkedHashSet<Integer>());
        map.get(val).add(list.size());
        list.add(val);
        return !exists;
    }
    
    public boolean remove(int val){
        if (!map.containsKey(val))
            return false;
        LinkedHashSet<Integer> valSet = map.get(val);
        int indexToReplace = valSet.iterator().next();
        
        int eleAtLastPlace = list.get(list.size() - 1);
        LinkedHashSet<Integer> replace = map.get(eleAtLastPlace);
        
        list.set(indexToReplace, eleAtLastPlace);
        valSet.remove(indexToReplace);
        
        if (indexToReplace != list.size() - 1){
            replace.remove(list.size() - 1);
            replace.add(indexToReplace);
        }
        list.remove(list.size() - 1);
        
        if (valSet.isEmpty())
            map.remove(val);
        return true;
    }
    
    public int getRandom(){
        return list.get((int)(Math.random() * list.size()));
    }
}



 
 
 

 Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stackBase = new Stack<>();
        for (int i = 1; i <= 9 && i <= n; i++){
            stackBase.push(i);
            while (!stackBase.isEmpty()){
                int baseMsb = stackBase.pop();
                list.add(baseMsb);
                for (int j = 9; j >= 0; j--){
                    int nextNumber = 10 * baseMsb + j;
                    if (nextNumber > n)
                        continue;
                    stackBase.push(nextNumber);
                }
            }
        }
        return list;
    }
    
    
}





Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int pS = 0, pT = 0;
        while (pS < s.length() && pT < t.length()){
            if (s.charAt(pS) == t.charAt(pT))
                pS++;
            pT++;
        }
        return pS == s.length();
       
    }
}

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

public class Solution {
    public String decodeString(String s) {
        
        Stack<String> phraseStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        phraseStack.push("");
        for (char ch: s.toCharArray()){
            
            if (Character.isDigit(ch))
                num = num * 10 + (ch - '0');
            else if (ch == '['){
                numStack.push(num);
                num = 0;
                phraseStack.push("");
            }
            else if (ch == ']'){
                StringBuilder sb = new StringBuilder();
                String phrase = phraseStack.pop();
                int times = numStack.pop();
                for (int i = 0; i < times; i++)
                    sb.append(phrase);
                String finalString = phraseStack.pop() + sb.toString();
                phraseStack.push(finalString);
                
            }
            else {
                phraseStack.push(phraseStack.pop() + ch);
            }
        }
        
        return phraseStack.pop();
        
        
        
    }
}

Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);


public class Solution {
    //o(n) time o(1) space
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        Random rand = new Random();
        int index = rand.nextInt(nums.length);
        while (nums[index] != target)
            index = rand.nextInt(nums.length);
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
 
 
 A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 12; i++){
            for (int j = 0; j < 60; j++){
                if (Integer.bitCount(i) + Integer.bitCount(j) == num)
                    result.add(String.format("%d:%02d", i, j));
            }
        }
        return result;
    }
}


Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

public class Solution {
    //logic here;
    //https://discuss.leetcode.com/topic/60621/simple-java-solution
    //https://discuss.leetcode.com/topic/69558/one-pass-o-n-java-solution-no-stack-needed
    //https://discuss.leetcode.com/topic/59334/my-simple-o-n-idea
    
    public String removeKdigits(String num, int k) {
        if (num.length() < 2)
            return "0";
        StringBuilder sb = new StringBuilder(num);
        int count = 0, idx = 0;
        while (count < k && idx < sb.length() - 1) {
            if (sb.charAt(idx) > sb.charAt(idx + 1)) {
                sb.deleteCharAt(idx);
                count++;
                idx = Math.max(idx - 1, 0);
            } else {
                idx++;
            }
        }
        
        System.out.println(count + " k: " + k);
        
        // if the digits are in ascending order and we haven't
        // deleted k digits, remove digits from the end.
        while (count < k) {
            System.out.println("yes");
            sb.deleteCharAt(sb.length() - 1);
            count++;
        }
        int i = 0;
        
        String re = sb.toString();
        System.out.println(re);
        
        // delete trailing zeroes
        while (i < re.length() && re.charAt(i) == '0')
            i++;
        if (i == re.length())
            return "0";
        return re.substring(i);
        //return sb.toString();
    }
}



Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)return 0;
        Deque<TreeNode> stack = new LinkedList<>();
        int result = 0;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left != null){
                if (node.left.left == null && node.left.right == null)
                    result += node.left.val;
                else
                    stack.push(node.left);
            }
            if (node.right != null){
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }
        return result;
    }
}



Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
         List<int[]> list = new ArrayList<int[]>();
        /*
        for (int i = 0; i < people.length; i++){
            for (int j =0; j < people[0].length; j++)
                System.out.print(people[i][j] + ",");
            System.out.print("][");
        }
        */
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] array1,int[] array2){
                if(array1[0]!=array2[0]){
                    return array2[0]-array1[0];
                }else{
                    return array1[1]-array2[1];
                }
            }
        });
        /*
        System.out.println("\n");
        for (int i = 0; i < people.length; i++){
            for (int j =0; j < people[0].length; j++)
                System.out.print(people[i][j] + ",");
            System.out.print("][");
        }
        */
        
        for(int[] a:people){
            list.add(a[1],a);
        }
        
        /*
        System.out.println("\n");
        for (int i = 0; i < list.size(); i++){
            for (int j =0; j < list.get(i).length; j++)
                System.out.print(list.get(i)[j] + ",");
            System.out.print("][");
        }
        */
        
        
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[0].length; j++)
                result[i][j] = list.get(i)[j];
        }
        return result;
    }
}


Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

public class Solution {
    public int longestPalindrome(String s) {
        
        // add characters to set
        // every time we find a second occurence of a character, we remove it and incrmeent count
        // count = number of times a character occurs twice
        // if set is empty, all characters occur even number of times. and hence the length of 
        // longest palindrome = lenght of string eg: abacbc =>   baccab
        // if set is not empty then length of longest palindrome = count * 2 + 1
        // effggcc     cgfefgc
        // + 1 because we can add utmost one character that doesn't have a pair.
        Set<Character> set = new HashSet<>();
        int countOfPairs = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (set.contains(ch)){
                set.remove(ch);
                countOfPairs++;
            }
            else
                set.add(ch);
        }
        
        if (set.isEmpty()) return countOfPairs * 2;
        else
            return (countOfPairs * 2) + 1;
    }
}


Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.


public class Solution {
    public int thirdMax(int[] nums) {
        
        Integer firstMax = nums[0], secondMax = null, thirdMax = null;
        for (int num: nums)
         firstMax = Math.max(firstMax, num);
        
        for (int num: nums)
            if (num < firstMax)
                secondMax = (secondMax == null)?num: Math.max(secondMax, num);
                
        if (secondMax == null) return firstMax;
        for (int num: nums)
            if (num < secondMax)
                thirdMax = (thirdMax == null)?num: Math.max(num, thirdMax);
        return (thirdMax == null)?firstMax:thirdMax;
        
        
    }
}


Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0){
            int num1Digit = i >= 0? num1.charAt(i) - '0':0;
            int num2Digit = j >= 0? num2.charAt(j) - '0':0;
            sb.append((num1Digit + num2Digit + carry) % 10);
            carry = (num1Digit + num2Digit + carry)/ 10;
            i--;j--;
        }
        return sb.reverse().toString();
    }
}



Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:
Input: "owoztneoer"

Output: "012"
Example 2:
Input: "fviefuro"

Output: "45"


public class Solution {
    public String originalDigits(String s) {
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            // consider digits with unique characters
            if (ch == 'z')count[0]++;
            if (ch == 'w')count[2]++;
            if (ch == 'u')count[4]++;
            if (ch == 'x')count[6]++;
            if (ch == 'g')count[8]++;
            
            // common character
            
            if (ch == 'h')count[3]++; // 3, 8
            if (ch == 'f')count[5]++; // 4, 5
            if (ch == 's')count[7]++; // 6, 7
            if (ch == 'o')count[1]++; // 0, 1, 2, 4
            if (ch == 'i')count[9]++; // 5, 6, 8, 9
            
            
        }
        
        /*count[3] =*/ count[3] -= count[8];
        /*count[5] =*/ count[5] -= (count[4]);
        /*count[7] =*/ count[7] -= count[6];
        /*count[1] =*/ count[1] -= (count[0] + count[2] + count[4]);
        /*count[9] =*/ count[9] -= (count[5] + count[6] + count[8] );
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < count[i]; j++)
                sb.append(i);
        }
        return sb.toString();
    }
}


Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5


public class Solution {
    public int countSegments(String s) {
        int count = 0;
        int i = 0;
        int N = s.length();
        while (i < N){
            if (!Character.isWhitespace(s.charAt(i))){
                count++;
                while (i < N && !Character.isWhitespace(s.charAt(i)))
                    i++;
            }
            else
                i++;
        }
        return count;
    }
}


Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note:
You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:
Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:
Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2){
              
              
                return i1.end - i2.end;
           } 
        });
        
        int end = Integer.MIN_VALUE;
        int count = 0;
        for (Interval in: intervals){
            if (in.start >= end)
                end = in.end;
            else
                count++;
        }
        return count;
    }
}


Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:
You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
Example 1:
Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:
Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
Example 3:
Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
        return new int[0];
        
        if (intervals.length == 1)
        return new int[]{-1};
        
        Map<Interval, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++)
            map.put(intervals[i], i);
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        int[] res = new int[intervals.length];
        int i = 0;
        while (i < intervals.length){
            Interval temp = intervals[i];
            int j = i + 1;
            while (j < intervals.length && temp.end > intervals[j].start)
                j++;
            if (j == intervals.length)
                res[map.get(temp)] = -1;
            else
                res[map.get(temp)] = map.get(intervals[j]);
            i++;
        }
        return res;
    }
}


You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root != null){
            continueFromTheseNode(root, sum);
            pathSum(root.left, sum);
            pathSum(root.right, sum);
        }
        return count;
    }
    
    public void continueFromTheseNode(TreeNode root, int sum){
        if (root != null){
            if (sum - root.val == 0)
                count++;
            continueFromTheseNode(root.left, sum - root.val);
            continueFromTheseNode(root.right, sum - root.val);
        }
    }
}


Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int slen = s.length(), plen = p.length();
        if (slen < plen) return res;
        for (int i = 0; i < slen - plen + 1; i++){
            if (isAn(s.substring(i, i + plen ), p))
                res.add(i);
        }
        return res;
    }
    
    public boolean isAn(String a, String b){
        int[] ascii = new int[256];
        for (int i = 0; i < a.length(); i++){
            ascii[a.charAt(i)]++;
            ascii[b.charAt(i)]--;
        }
        for (int n: ascii)
            if (n != 0) return false;
        return true;
    }
}

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]


public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        /* whenever you come across element num
           set array[num - 1] as negative. indicating num as been encountered.
           if array[num - 1] is already negative add num to result
           */
        List<Integer> result = new ArrayList<>();
        for (int num: nums){
            num = Math.abs(num);
            if (nums[num - 1] < 0)
                result.add(num);
            else
                nums[num - 1] = -nums[num - 1];
        }
        // convert array to its original form
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);
        return result;
        
       
    }
}


You are given two linked lists representing two non-negative numbers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null || l2 != null){
            if (l1 != null){
                s1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null){
                s2.push(l2.val);
                l2 = l2.next;
            }
        }
        
        ListNode curr = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0){
            int d1 = (s1.isEmpty())?0:s1.pop();
            int d2 = (s2.isEmpty())?0:s2.pop();
            int sum = d1 + d2 + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            node.next = curr;
            curr = node;
        }
        return curr;
    }
}

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]


public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int ele = Math.abs(nums[i]);
            if (nums[ele - 1] > 0)
                nums[ele - 1] = -nums[ele - 1];
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0)
                missing.add(i + 1);
        }
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);
        return missing;
    }
}


Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together

Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

public class Solution {
    public String frequencySort(String s) {
        // maintain character count
        int[] ascii = new int[256];
        for (char ch: s.toCharArray())
            ascii[ch]++;
        
        
        // map of count->[list of characters that occurs count number of times]
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < ascii.length; i++){
            int count = ascii[i];
            if (!map.containsKey(count))
                map.put(count, new ArrayList<Character>());
            map.get(count).add((char)i);
        }
        
        StringBuilder result = new StringBuilder();
        
        
        for (int i = s.length(); i > 0; i--){
            if (map.containsKey(i)){
                List<Character> chars = map.get(i); 
                for (char ch: chars){
                    for (int c = 0; c < i; c++)
                        result.append(ch);
                }
            }
        }
        return result.toString();
    }
}


Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

public class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0)return 0;
        int minValue = Integer.MAX_VALUE;
        for (int num: nums)minValue = Math.min(minValue, num);
        int res = 0;
        for (int num: nums) res += (num - minValue);
        return res;
        
        //https://discuss.leetcode.com/topic/66557/java-o-n-solution-short
        Adding 1 to n - 1 elements is the same as subtracting 1 from one element, w.r.t goal of making the elements in the array equal.
So, best way to do this is make all the elements in the array equal to the min element.
sum(array) - n * minimum
    }
}


Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0


public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> allPossibleABSum = new HashMap<>();
        int count = 0;
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                int sum = A[i] + B[j];
                
                if (allPossibleABSum.containsKey(sum))
                    allPossibleABSum.put(sum, allPossibleABSum.get(sum) + 1);
                else
                    allPossibleABSum.put(sum, 1);
            }
        }
        
        for (int i = 0; i < C.length; i++){
            for (int j = 0; j < D.length; j++){
                int sum = C[i] + D[j];
                sum *= -1;
                
                if (allPossibleABSum.containsKey(sum))
                    count += allPossibleABSum.get(sum);
            }
        }
        return count;
    }
}


Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

Note:
You may assume the greed factor is always positive. 
You cannot assign more than one cookie to one child.

Example 1:
Input: [1,2,3], [1,1]

Output: 1

Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.
Example 2:
Input: [1,2], [1,2,3]

Output: 2

Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.


public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length){
            if (g[i] <= s[j])i++;
            j++;
        }
        return i;
    }
}


Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

Note: n will be less than 15,000.

Example 1:
Input: [1, 2, 3, 4]

Output: False

Explanation: There is no 132 pattern in the sequence.
Example 2:
Input: [3, 1, 4, 2]

Output: True

Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:
Input: [-1, 3, 2, 0]

Output: True

Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

public class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3)
	return false;
	
for (int i = 0; i < nums.length-1; i++) {
	int max = nums[i];
	for (int j = i+1; j < nums.length; j++) {
		if(nums[j] > max)
			max = nums[j];
		
		if(nums[j] < max && nums[j] > nums[i] )
			return true;				
	}
}
	
return false;
    }
}


Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int N = str.length();
        for (int i = N/2; i >= 1; i--){
            if (N % i == 0){
                int times = N / i;
                String sub = str.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < times; j++)
                    sb.append(sub);
                if (sb.toString().equals(str))
                    return true;
            }
        }
        return false;
    }
}


Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]

public class Solution {
    
    /* nlogn 
    public int minMoves2(int[] nums) {
        int moves = 0;
        int i = 0, j = nums.length - 1;
        Arrays.sort(nums);
        while (i < j){
            moves += nums[j--] - nums[i++];
        }
        return moves;
    }
    */
    public int minMoves2(int[] nums){
        int moves = 0;
        int N = nums.length, median = 0;
        if (nums.length == 1)return 0;
        if (N % 2 == 0){
            int lowM = findKthLargest(nums, (N/2) );
            int highM = findKthLargest(nums, (N/2)-1);
            median = (highM + lowM)/2;
        }
        else {
            median = findKthLargest(nums, (N/2) + 1);
        }
        System.out.println(median + "$");
        for (int num: nums)
            moves += Math.abs(median - num);
        return moves;
    }
    
    public int findKthLargest(int[] nums, int k){
        if (nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1, nums.length - k);
    }
    
    public int helper(int[] nums, int low, int high, int k){
        if (low >= high) return low;
        int pivotIndex = partition(nums, low, high);
        if (pivotIndex == k)
            return nums[k];
        if (pivotIndex > k)
            return helper(nums, low, pivotIndex - 1, k);
        else
            return helper(nums, pivotIndex + 1, high, k);
    }
    public int partition(int[] nums, int low, int high){
        int i = low + 1, j = high, pivotElement = nums[low];
        
        while (true){
            while (nums[i] < pivotElement){
                i++;
                if (i >= high)break;
            }
            while (nums[j] >= pivotElement){
                j--;
                if (j <= low) break;
            }
            if (i >= j) break;
            if (i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp2 = nums[low];
        nums[low] = nums[j];
        nums[j] = temp2;
        return j;
    }
}





Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int N = nums.length;
        if (N == 0) return result;
        
        int pre = nums[0];
        String startString = "";
        for (int i = 1; i < N; i++){
            if (pre + 1 == nums[i]){
                if (startString.equals(""))
                    startString = pre + "->";
            }
            else {
                result.add(startString + pre);
                startString = "";
            }
            pre = nums[i];
        }
        result.add(startString + pre);
        return result;
        
        
    }
}


 Substring with Concatenation of All Words
 
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).


 public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> ans = new ArrayList<>();
	if (s == null || words.length == 0) return ans;
	int n = words.length, wordLen = words[0].length();
    Map<String, Integer> hist = new HashMap<>();
    for (String w : words) {
    	hist.put(w, hist.getOrDefault(w, 0)+1);
    }
	Map<String, Integer> curHist = new HashMap<>();
    for (int i = 0; i <= s.length() - n*wordLen; i++) {
    	if (hist.containsKey(s.substring(i, i+wordLen))) {
    		curHist.clear();
    		for (int j = 0; j < n; j++) {
    			String word = s.substring(i + j*wordLen, i+(j+1)*wordLen);
    			if (hist.containsKey(word)) {
    				curHist.put(word, curHist.getOrDefault(word, 0) + 1);
    				if (curHist.get(word) > hist.get(word))
    					break;
    			} else 
    				break;
    		}
    		if (hist.equals(curHist)) ans.add(i);
    	}
    }
    return ans;
    }
}


Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.


public class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long result = 0;
        while(absDividend >= absDivisor){
            long tmp = absDivisor, count = 1;
            while(tmp <= absDividend){
                tmp <<= 1;
                count <<= 1;
            }
            result += count >> 1;
            absDividend -= tmp >> 1;
        }
        return  isNegative ? (int) ~result + 1 : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
    
    // EXPLANATION: https://discuss.leetcode.com/topic/45980/very-detailed-step-by-step-explanation-java-solution
}



















 








 



 
 
 
 












Given [5, 4, 3, 2, 1],
return false.















	








































	
	



 




























			 


	












 
	






   
   




































































































 









