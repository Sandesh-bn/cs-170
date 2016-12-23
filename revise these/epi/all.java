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
            else {
                count = 0;
                stack.clear();
            }
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



 Reverse Nodes in k-Group
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy, tail = curr;
        dummy.next = head;
        
        while (tail != null){
            int i = 0;
            while (i < k && tail.next != null){
                i++;
                tail = tail.next;
            }
            if (i < k) return dummy.next; // we have reversed all groups of k. This group does not have k elements return head
            ListNode nextCurr = null;
            while (curr.next != tail){
                ListNode temp = curr.next;
                if (nextCurr == null) nextCurr = temp;
                curr.next = temp.next;
                temp.next = tail.next;
                tail.next = temp;
            }
            curr = nextCurr;
            tail = curr;
        }
        return dummy.next;
    }
}


Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        
       if (head == null || head.next == null) return head;
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode curr = dummy;
       while (curr.next != null && curr.next.next != null){
           ListNode first = curr.next;
           ListNode second = curr.next.next;
           first.next = second.next;
           curr.next = second;
           second.next = first;
           curr = first;
           //curr.next.next = first;
           //curr = curr.next.next;
       }
       return dummy.next;
    }
}



Merge k Sorted Lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       
        
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
           public int compare(ListNode l1, ListNode l2){
               return l1.val - l2.val;
           } 
        });
        for (ListNode head: lists)
            if (head != null)
                heap.offer(head);
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!heap.isEmpty()){
            curr.next = heap.poll();
            curr = curr.next;
            if (curr.next != null)
                heap.offer(curr.next);
        }
        return dummy.next;
    }
}


 Generate Parentheses   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 120516
Total Submissions: 290825
Difficulty: Medium
Contributors: Admin
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]



public class Solution {
   
   
    
    public List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        helper(result, n, n, "");
        return result;
    }
    
    public void helper(List<String> result, int left, int right, String brackets){
        if (left == 0 && right == 0)
            result.add(brackets);
        if (left > 0)
            helper(result, left - 1, right, brackets + "(");
        if (right > 0 && right > left)
            helper(result, left, right - 1, brackets + ")");
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
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs","tuv", "wxyz"};
        LinkedList<String> list = new LinkedList<>();
        if (digits.length() == 0)
            return list;
        list.add("");
        for (int i = 0; i < digits.length(); i++){
            int digit = Character.getNumericValue(digits.charAt(i));
            while (list.peek().length() == i){
                String t = list.remove();
                System.out.println(t);
                for (char s: mapping[digit].toCharArray())
                    list.add(t + s);
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





Trapping Rain Water   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 92692
Total Submissions: 264220
Difficulty: Hard
Contributors: Admin
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


revise this

Multiply Strings   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 84540
Total Submissions: 328200
Difficulty: Medium
Contributors: Admin
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length() - 1, n = num2.length() - 1, carry = 0;
        StringBuilder product = new StringBuilder();
        
        int i = 0;
        while (i <= (m + n) || carry > 0){
            for (int j = Math.max(0, i - n); j <= Math.min(i, m); j++)
                carry += (num1.charAt(m - j) - '0') * (num2.charAt(n - i + j) - '0');
            product.append(carry % 10);
            carry /= 10;
            i++;
        }
        return product.reverse().toString();
    }
}


Wildcard Matching   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 77812
Total Submissions: 412936
Difficulty: Hard
Contributors: Admin
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

public class Solution {
    public boolean isMatch(String s, String p) {
        int R = s.length();
        int C = p.length();
        boolean[][] dp = new boolean[R + 1][C + 1];
        dp[0][0] = true;
        // fill first row;
        for (int j = 1; j <= C; j++)
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];
        
        for (int i = 1; i <= R; i++){
            for (int j = 1; j <= C; j++){
                
                if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                else if (s.charAt(i - 1) == p.charAt(j - 1) || 
                        p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
            }
        }
        return dp[R][C];
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

You must do this in-place without altering the nodes' values.

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









































	
	



 




























			 


	












 
	






   
   




































































































 









