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

first push the right child to stakc if right chid is valid.
if left child is not null then make it  the rich child and set left child = null
otherwise pop from stack and make it the right child

set current pointer to right child

O(n) space, O(logn) time

almost sorted
how would you sort a almost sorted array

what is big o for insertion based algo
O(nk)
what is big o for heap based algo
O(nlogk)

public void sort(int[] arr, int k){
	 PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	  for (int i = 0; i < k; i++) {
		minHeap.add(nums[i]);
	  }

	  for (int i = 0; i < nums.length; i++) {
			if(i + k < nums.length) {
				minHeap.add(nums[i + k]);
			}
			nums[i] = minHeap.remove();
	  }
}


use the ordinary insertion sort and it makes max k swaps at a time
O(nk)
if we use heap it will be O(nlgk) we perform insertion n times and each insertion int o heap is lgk
and O(k) space.
[1 2 3 4 5 6 7 8] k = 3
[2 3 1 5 7 8 6 7 10 9]


find 1s in binary representation

public int numberOnes(int n){
    int count = 0;
    while(n != 0){
        if ((n & 1) == 1)
            count++;
        n >>= 1;
    }
    return count;
}

if you can use extra space then str = Integer.toBinaryString(num)
scan thrgouth the string and find the number of 1 characters
repeatedly shift the digit to the right an AND it with 1 to get 
the LSB(1 or 0) if it is 1-> count++


print firstMax and secondmax in each level

perform breadth first traversal and print first and second max at each level
what about the first level.
what if there are duplicates at each level
public void disp(TreeNode node){
    if (node == null) return;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(node);
    while(!q.isEmpty()){
        List<Integer> levelElements = new ArrayList<>();
        int levelSize = q.size();
        for (int i = 0; i < levelsize; i++){
            TreeNode front = q.poll();
            if (node.left != null)q.offer(node.left);
            if (node.right != null)q.offer(node.right);
            levelElemnts.add(node.val);
        }
        Integer firstMax = null, secondMax = null;
        for (int num: levelElements)
            if (firstMax == null || num > firstMax)
                firstMax = num;
            else if (secondMax == null || num > secondMax)
                secondMax = num;
        System.out.println("first: " + firstMax);
        if (secondMax != null)
            System.out.println("second: " + secondMax);
        
    }

}


word ladder



time : min(26^L, size(dic)) we may end up searching all possible 
strings of length L.

public int ladderLength(String begin, String end, Set<String> wordList){
    Queue<String> q = new LinkedList<>();
    q.add(begin);
    int level = 0;

    while(!q.isEmpty()){
        int size = q.size();
        for (int i = 0; i < size; i++){
            String curr = q.remove();
            if (curr.equals(end))
                return level + 1;

            

            for (int j = 0; j < curr.length; j++){
                char[] word = cur.toCharArray();

                for (char ch = 'a'; ch < 'z'; ch++){
                    word[j] = ch;
                    String check = new String(word);
                    if(!check.eqauls(curr) && wordList.contains(curr)){
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

8You have an unsorted array of integers and a function........string getCategory(integer)........
which deterministically returns 1 of three possible strings: "low", "medium", or "high", depending 
on the input integer. You need to output an array with all the "low" numbers at the bottom, all the 
"medium" numbers in the middle, and all the "high" numbers at the top. 
This is basically a partial sort. Within each category, the order of the numbers does not matter...
For example, you might be give the array [5,7,2,9,1,14,12,10,5,3]. 
For input integers 1 - 3, getCategory(integer) returns "low", for 4 - 10 it returns "medium," 
and for 11 - 15 it returns "high". You could output an array (or modify the given array) that looks like this: [3,1,2,5,5,9,7,10,14,12] 

first use two pointers i and j. i from the beginning, j from the end.
public void sort(int[] nums){
    if (nums.length < 1) return;
    int i = 0, j = N - 1;
    
    //get low values to front and medium to bacck
    while (true){
        while(i < j && getCategory(nums[i]) != MEDIUM)
            i++;
        while(i < j && getCategory(nums[j]) != LOW)
            j--;
        if (i >= j) break;
        if (i < j)
            swap(nums[i], nums[j])
        i++;j--;
    }

    // swap medium with high values;
    i = 0, j = N - 1;
    while(true){
        while(i < j && getCategory(nums[i]) != HIGH)
            i++;
        while(i < j && getCategory(nums[j]) != MEDIUM)
            j--;
        if (i >= j) break;
        if (i < j)
            swap(nums[i], nums[j])
        i++;j--;
    }
}



sliding window max\
public int[] maxSlidingWindow(int[] nums, int k) {
    int empty[] = {};
    if (nums.length == 0) return empty;
    LinkedList<Integer> list = new LinkedList<>();
    List<Integer> maxElements = new ArrayList<>();

    // add first k elements and by the end of 
    // this for loop only retain useful indices
    // all elements which are smaller elements
    // to the left of largest element is removed
    for (int i = 0; i < k; i++){

        // remove useless elements at the end of list
        // if they are smaller than current element
        while(list.size() > 0 && nums[list.getLast()] < nums[i])
            list.removeLast();

        // add current element
        list.add(i);
    }

    for (int i = k; i < nums.length; i++){
        //first element present in the list is the greatest element for the last 'k' sized sub-array
        maxElements.add(array[list.getFirst()]);

        // now remove all indices of elements from the list which do not belong to current window
        while (list.size() > 0 && (list.getFirst() < (i-k+1)))
                list.removeFirst();
        
        // now again remove all useless elements present at the front of the list
        // remove all useless elements present at the front of the list
        while(list.size() > 0 && && nums[list.getLast()] < nums[i])
            list.removeLast();
        
        // add current element
        list.add(i);
    }
    copy element from maxElement to an array and return it.


}


// COMPLEX SOLUTION
public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0)
            return new int[0];
        int N = nums.length;
        int[] res = new int[N - k + 1];
        int resI = 0;
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; i++){
            
            // make sure dq has atmost k elements
            while (!dq.isEmpty() && dq.peek() < i - k + 1)
                dq.poll();
                
            // if rightmost element in dq is less than nums[i], keep removing it.
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
                
            dq.offer(i);
            
            // copy the maximum element for that window into result
            if (i >= k - 1)
                res[resI++] = nums[dq.peek()];
        }
        return res;
    }


longesst substring without repeating characters
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestSoFar = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        while (i < s.length()){
            char ch = s.charAt(i);
            
            if (!map.containsKey(ch)){
                map.put(ch, i);
                i++;
            }
            else{
                i = map.get(ch) + 1;
                map.clear();
            }
            longestSoFar = Math.max(map.size(), longestSoFar);
        }
        return longestSoFar;
    }
}

// this fails for large inputs but the below algo works for all cases
public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxSoFar = 0, i = 0, j = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if (map.containsKey(ch))
                j = Math.max(j, map.get(ch) + 1);
            map.put(ch, i);
            maxSoFar = Math.max(maxSoFar, i - j + 1);
            i++;
        }
        return maxSoFar;
    }
}



//Implement queue using circular buffer
class CircularQueue{
    private int[] q;
    private int front, rear, size;
    public CircularQueue(int cap){
        this.size = cap;
        q = new int[cap];
        front = rear = 0;
    }

    public int size(){
        return size;
    }

    public void enqueue(int ele){
        if (size == q.length)
            throw an exception
        q[rear] = ele;
        rear++;
        size++;
        if (rear == q.length)
         rear = 0;
    }

    public int deque(){
        if size == 0
            throw an exception();
        int ele = q[front];
        front++;
        size--;
        if (front == q.length)
            front = 0;
        return ele;
    }
}

front == rear when queue is completely full and completly empty
use size variable to differentiate between these two states
special conditions:
first 3 elements were removed and a, b, c, d, e, f were added
| d | e | f | a | b | c |
         r f

first a and b were added
| a | b |  |  |  |   |
  f       r
next a and b are removed
|   |   |  |   |  |  |
         fr


LinkedList with randompointer

public ListNodeRanom copy(ListNodeRanom node){
    if (node == null) return null;

    Map<ListNodeRanom, ListNodeRanom> map = new HashMap<>();
    ListNodeRanom curr = node;
    while(curr != null){
        map.put(curr.label, new ListNodeRanom(curr.label));
        curr = curr.next;
    }

    for (Map.Entry<ListNodeRanom, ListNodeRanom> entry: map.entrySet()){
        ListNodeRanom copy = entry.getValue();
        copy.next = map.get(entry.getKey().next());
        copy.random = map.get(entry.getKey().random());
    }
    return map.get(node);
}

SERIALIZE AND DESERIALIZE

public String serialize(TreeNode root){
    StringBuilder sb = new StringBuilder();
    preOrder(root, sb);
    return sb.toString();
}

public void preOrder(TreeNode root, StringBuilder sb){
    if (root == null){
        sb.append("null,");
        return;
    }
    sb.append(root.val + ",");
    preOrder(root.left, sb);
    preOrder(root.right, sb);
}

int index = 0;
public TreeNode deserialize(String value){
    if (value == null) return null;
    String[] tokens = value.split(",");
    return helper(tokens);
}

public TreeNode helper(String[] tokens){
    if (index == token.length || tokens[index] == "null"){
        index+= 1;
        return null;
    }
    TreeNode node = new TreeNode(integer.parseInt(tokens[index]));
    index += 1;
    node.left = helper(token);
    node.right = helper(token);
    return node;
}



decode ways
Problem Description
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.
For example,

Given encoded message “12”, it could be decoded as “AB” (1 2) or “L” (12).
The number of ways decoding “12” is 2.
Idea
When seeing the number of ways required, we come up with the solution of using dp.
According to the conditions, ways[i] = ways[i-2]+ways[i-1], this is the same idea with the problem:
A positive integer n can be represented as summation of 1,2,5, list the number of all different summations.
And the formula is: dp[n] = dp[n-1]+dp[n-2]+dp[n-5]
However, we also need to consider about the corner cases in this problem. ways[i-2] can be added only when s.substring(i-2,i) is valid. Similarly, ways[i-1] can be added only when s.substring(i-1,i) is valid. For a double-char substring, it is valid when 10<=Integer.parseInt(s.substring(i-2,i))<=26. For a single-char substring, it is valid when s.substring(i-1,i) is not 0.
Note that we can quit the iteration by checking if dp[i] is zero, if yes, then there is no valid decoding ways, we can directly return 0;


