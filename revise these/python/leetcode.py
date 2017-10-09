# floor division
5 // 2 = 2
# true division(default)
5 / 2 = 2.5

# check null
node is None

# Inteber.max-
min_val = 1e10

#reverse list
list.reverse() #inplace
reversecopyt = list[::-1]

# distribute candies
def distributeCandies(self, candies):
    """
    :type candies: List[int]
    :rtype: int
    """
    candies_set = set(candies)
    return (min(len(candies_set), len(candies) //2))

# reverse string 
#Given s = "hello", return "olleh".
def reverse(self, s):
    return s[::-1]


# keyboard rows
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
def find_words(self, words):
    keys = ["qwertyuiop", "asdfghjkl", "zxcvbnm"]
    char_map = {}
    for i in range(len(keys)):
        for c in keys[i]:
            char_map[c] = i 
    res = []
    for word in words:
        index = char_map[word[0].lower()]
        for c in word:
            if char_map[c.lower()] != index:
                index = -1
                break
        if index != -1:
            res.append(word)
    
    return res


ransom note magazine
 def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        char_map = {}
        for c in magazine:
            if (c not in char_map):
                char_map[c] = 0
            char_map[c] = char_map[c] + 1
        for c in ransomNote:
            if (c not in char_map):
                return False
            if (char_map[c] == 0):
                return False
            char_map[c] -= 1
            
        return True

stock as many transactions
def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        max_profit = 0
        for i in range(len(prices) - 1):
            if prices[i + 1] > prices[i]:
                max_profit += (prices[i + 1] - prices[i])
        return max_profit


invertree
def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root is None:
            return root
        if root.left is None and root.right is None:
            return root
        t = root.left
        root.left = root.right
        root.right = t
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root

anagram
def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        char_map = {}
        for c in s:
            if (c not in char_map):
                char_map[c] = 0
            char_map[c] += 1
        for c in t:
            if (c not in char_map):
                return False
            if (char_map[c] == 0):
                return False
            char_map[c] -= 1
        for c in 'abcdefghijklmnoqprstuvwxyz':
            if c in char_map and char_map[c] != 0:
                return False
        
        return True

    roman to int
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        char_map = {}
        char_map['I'] = 1
        char_map['V'] = 5
        char_map['X'] = 10
        char_map['L'] = 50
        char_map['C'] = 100
        char_map['D'] = 500
        char_map['M'] = 1000
        res = 0
        for i in range(0, len(s) - 1):
            cur = char_map[s[i]]
            next = char_map[s[i + 1]]
            if cur >= next:
                res += cur
            else:
                res -= cur
        res += char_map[s[len(s) - 1]]
        return res

    reverse linked list
     def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head
        front = None
        curr = head
        prev = None
        while curr is not None:
            front = curr.next
            curr.next = prev
            prev = curr
            curr = front
        return prev

longest palindrome
def longestPal(self, str):
     char_map = {}
        pair = 0
        for c in s:
            if c in char_map and char_map[c]:
                pair += 1
                char_map[c] = False
            else:
                char_map[c] = True
        
        if(len(s) == (pair * 2)):
            return (pair * 2)
        return pair * 2 + 1

def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        stack = [root]
        res = 0
        while len(stack) > 0:
            n = stack.pop()
            if n.left is not None:
                if n.left.left is None and n.left.right is None:
                    res += n.left.val
                else:
                    stack.append(n.left)
            if n.right is not None:
                if n.right.left is not None or n.right.right is not None:
                    stack.append(n.right)
                    
        return res

is subtree
def helper(self, s, t):
        if s is None or t is None:
            return s == t
        return s.val == t.val and self.helper(s.left, t.left) and self.helper(s.right, t.right)
    def isSubtree(self, s, t):
        """
        :type s: TreeNode
        :type t: TreeNode
        :rtype: bool
        """
        if s is None or t is None:
            return s == t
        return s.val == t.val and self.helper(s, t) or self.isSubtree(s.left, t) or self.isSubtree(s.right, t);


def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        if t1 is None or t2 is None:
            return t1 or t2
        
        t1.val += t2.val
        t1.left = self.mergeTrees(t1.left, t2.left)
        t1.right = self.mergeTrees(t1.right, t2.right)
        return t1
    
numbers complement
input: 5    101
output: 2   010

def findComplement(self, num):
    i = 0
    j = 0
    while i < num:
        i += int(math.pow(2, j))
        j += 1
    return i - num


island perimeter

def islandPerimeter(self, grid):
    """
    :type grid: List[List[int]]
    :rtype: int
    """
    res = 0
    if grid is None:
        return res
    for i in xrange(len(grid)):
        for j in xrange(len(grid[0])):
            if grid[i][j] == 1:
                res += 4
            
                if i > 0 and grid[i - 1][j] == 1:
                    res -= 1
                if j > 0 and grid[i][j - 1] == 1:
                    res -= 1
                if i < len(grid) - 1 and grid[i + 1][j] == 1:
                    res -= 1
                if j < len(grid[0]) - 1 and grid[i][j + 1] == 1:
                    res -= 1
    
    return res

single number
 def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        for n in nums:
            res ^= n
        return res

Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
def intersection(self, nums1, nums2):
    """
    :type nums1: List[int]
    :type nums2: List[int]
    :rtype: List[int]
    """
    return list(set(nums1) & set(nums2))
    
climibing stairs /
def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            return 1
        dp = []
        for i in range(n + 1):
            dp.append(0)
        dp[0] = 1
        dp[1] = 1
        for i in range(2, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n]

Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head
        runner = head.next
        p = head
        while runner is not None:
            if runner.val == p.val:
                while runner is not None and runner.val == p.val:
                    runner = runner.next
                p.next = runner
            else:
                p = p.next
                runner = runner.next
        
        return head

maximum subarray
def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        N = len(nums)
        dp = []
        for i in range(N):
            dp.append(0)
        dp[0] = nums[0]
        max_val = nums[0]
        for i in range(1, N):
            dp[i] = max(nums[i], dp[i - 1] + nums[i])
            max_val = max(max_val, dp[i])
        return max_val

def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums) == 0:
            return 0
        N = len(nums)
        dp = []
        for i in range(N):
            dp.append(0)
        dp[0] = nums[0]
        if N == 1:
            return dp[0]
        dp[1] = max(nums[0], nums[1])
        maxv = max(nums[0], nums[1])
        for i in range(2, N):
            dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])
            maxv = max(maxv, dp[i])
            
        return maxv

lca of bst
def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root is None:
            return root
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)
        if root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        return root

    
min depth
 def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return 1
        leftv = 1e10 if root.left is None else self.minDepth(root.left)
        rightv = 1e10 if root.right is None else self.minDepth(root.right)
        
        return 1 + min(leftv, rightv);

binary tree path
 def dfs(self, root, res, curr):
        if root is None:
            return
        if root.left is None and root.right is None:
            res.append(curr + str(root.val))
        if root.left is not None:
            self.dfs(root.left, res, curr + str(root.val) + "->")
        if root.right is not None:
            self.dfs(root.right, res, curr + str(root.val) + "->")
            
        
        
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        res = []
        self.dfs(root, res, "")
        return res

    mode in bt 
    def findMode(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []
        res = []
        nmap = {}
        stack = []
        maxv = 0
        while root is not None or len(stack) > 0:
            while root is not None:
                stack.append(root)
                root = root.right
            root = stack.pop()
            if (root.val not in nmap):
                nmap[root.val] = 0
            nmap[root.val] += 1
            maxv = max(maxv, nmap[root.val])
            root = root.left
        
        for key in nmap:
            if nmap[key] == maxv:
                res.append(key)
        return res

is balanced
def height(self, root):
        if root is None: return 0
        if root.left is None and root.right is None: return 1
        leftv = self.height(root.left)
        if leftv == -1: return -1
        rightv = self.height(root.right)
        if rightv == -1: return -1
        
        if abs(rightv - leftv) > 1:return -1
        return 1 + max(leftv, rightv)
    
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.height(root) != -1

queue using stacks
class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.st1 = []
        self.st2 = []
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: void
        """
        self.st1.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        while(len(self.st1) > 0):
            self.st2.append(self.st1.pop())
        ret = self.st2.pop()
        while(len(self.st2) > 0):
            self.st1.append(self.st2.pop())
        
        return ret

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        while(len(self.st1) > 0):
            self.st2.append(self.st1.pop())
        ret = self.st2[-1]
        while(len(self.st2) > 0):
            self.st1.append(self.st2.pop())
        return ret
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return len(self.st1) == 0

# reverse words in sting 
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
https://leetcode.com/problems/search-insert-position/description/
https://leetcode.com/problems/word-pattern/description
https://leetcode.com/problems/palindrome-linked-list/description/
https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
https://leetcode.com/problems/arranging-coins/description/
https://leetcode.com/problems/valid-palindrome-ii/description/
https://leetcode.com/problems/intersection-of-two-linked-lists/description/
https://leetcode.com/problems/longest-common-prefix/description/
https://leetcode.com/problems/merge-sorted-array/description/
https://leetcode.com/problems/add-binary/description/
https://leetcode.com/problems/length-of-last-word/description/
https://leetcode.com/problems/next-greater-element-i/description/
https://leetcode.com/problems/longest-uncommon-subsequence-i/description/
https://leetcode.com/problems/reshape-the-matrix/description/
https://leetcode.com/problems/max-consecutive-ones/description/
https://leetcode.com/problems/add-digits/description/
https://leetcode.com/problems/excel-sheet-column-number/description/
https://leetcode.com/problems/set-mismatch/description/






