# exponentiation
val = x ** n 

# minimum value
[a, b].min

# unique elements
require 'set'
arr = [2, 3, 1, 2]
uniqueEle = Set.new(arr)

# iterate through characters of string 
s = 'ABCDEFG'
for pos in 0..s.length - 1
    puts s[pos].chr
end

# reverse backward iterate 
for i in (n - 1).downto(0)
    p array[i]
end
# map and dictionary of counts
counts = Hash.new 0
# check if hash has key 
hash.key?(some_key)


https://www.ruby-forum.com/topic/159272
https://stackoverflow.com/questions/6184697/how-to-get-a-substring-of-text/6184729
https://gistpages.com/posts/ruby_arrays_insert_append_length_index_remove
https://stackoverflow.com/questions/198460/how-to-get-a-random-number-in-ruby

# print variable to 
name = 'Vlad'
lname = 'putin'
p "#{name} #{lname}

# continue in ruby is next

check nil / null
obj.nil?
http://lukaszwrobel.pl/blog/ruby-is-nil

avoid ++ and --

words.each do |word|
  counts[word] += 1
end

intitalize an array
ar = Array.new(5, 666)

intialize 2d array
2dar = Array.new(3){Array.new(4, 0)}
3 * 4 matrix all intialized to 0


min stack 
class MinStack

=begin
    initialize your data structure here.
=end
    def initialize()
        @st = []
        @min_st = []
    end


=begin
    :type x: Integer
    :rtype: Void
=end
    def push(x)
        @st.push(x)
        if @min_st.length == 0 || @min_st[-1] >= x
            @min_st.push(x)
        end
    end


=begin
    :rtype: Void
=end
    def pop()
        v = @st.pop()
        if v == @min_st[-1]
            @min_st.pop()
        end
    end


=begin
    :rtype: Integer
=end
    def top()
        @st[-1]
    end


=begin
    :rtype: Integer
=end
    def get_min()
        @min_st[-1]
    end


end


single element in sorted array 
Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10

def single_non_duplicate(nums)
    l , h = 0, nums.length - 1
    while l < h
       mid = l + (h - l)/2
       return nums[mid] if (nums[mid] != nums[mid - 1] and nums[mid] != nums[mid + 1])
       if (nums[mid] == nums[mid + 1] and mid % 2 == 0)
           l = mid + 1 
       elsif (nums[mid] == nums[mid - 1] and mid % 2 == 1)
           l = mid + 1 
       else
           h = mid - 1
       end

    end
    nums[l]
end

class Solution

=begin
    :type nums: Integer[]
=end
    def initialize(nums)
        @array = nums
    end


=begin
    Resets the array to its original configuration and return it.
    :rtype: Integer[]
=end
    def reset()
        @array
    end


=begin
    Returns a random shuffling of the array.
    :rtype: Integer[]
=end
    def shuffle()
        copy = @array.clone
        for i in 0...copy.length 
            rand = rand(copy.length)
            t = copy[i]
            copy[i] = copy[rand]
            copy[rand] = t
        end
        copy
    end
end


Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

def add_two_numbers(l1, l2)
   return l2 if l1.nil? 
   return l1 if l2.nil?
   
   st1, st2 = [], []
   h1, h2 = l1, l2
   while !h1.nil?
       st1.push(h1.val)
       h1 = h1.next
   end
   while !h2.nil?
       st2.push(h2.val)
       h2 = h2.next
   end

   carry, sum = 0, 0
   curr, temp = nil, nil
   while st1.length > 0 || st2.length > 0 || carry > 0
      val1 = st1.length > 0? st1.pop(): 0
      val2 = st2.length > 0? st2.pop(): 0
      sum = (val1 + val2 + carry)
      carry =  sum / 10
      
      node = ListNode.new(sum % 10)
      node.next = curr
      curr = node
   end
   curr
end


integer to roman 
def int_to_roman(num)
    m = ["", "M", "MM", "MMM" ]
    c = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"]
    x = ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"]
    i = ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"]
    return m[num / 1000] << c[(num % 1000) / 100] << x[(num % 100)/10] << i[num % 10]
end

preorder 
def preorder_traversal(root)
    res = []
    return res if root.nil?
    st = [root]
    while(st.length > 0)
        n = st.pop()
        res << n.val
        st.push(n.right) if !n.right.nil?
        st.push(n.left) if !n.left.nil?
    end
    res
end


generate parentheses 
def helper(res, left, right, curr)
    res << curr if (left == 0 and right == 0)
    helper(res, left - 1, right, curr + "(") if left > 0
    helper(res, left, right - 1, curr + ")") if (right > 0 and right > left)
end

def generate_parenthesis(n)
    res = []
    helper(res, n, n, "")
    res
end


queue reconstruction by height
def reconstruct_queue(people)
   people.sort!{ |x,y| x[0] == y[0] ? x[1] <=> y[1] : y[0] <=> x[0] }
   res = []
   for i in 0...people.length
       res.insert(people[i][1], people[i])
   end
   res
end

frequency sort 
def frequency_sort(s)
    ascii = Array.new(256, 0)
    for i in 0...s.length
       ascii[s[i].ord] += 1 
    end
    map = Hash.new 
    for i in 0...ascii.length
        count = ascii[i]
        if (!map.key?(count))
            map[count] = []
        end
        map[count] << i.chr
    end
       
    str = ''
    p map
    for count in s.length.downto(1)
        if (map.key?(count))
            lis = map[count]
            for i in 0...lis.length
                for j in 0...count
                   str <<  lis[i]
                end
            end
        end
    end
    
    str
end

longest increasing subsequence 
def length_of_lis(nums)
    return 0 if nums.nil? or nums.length == 0
    n = nums.length
    dp = Array.new(n, 1)
    max_v = 1
    for i in 1...n
        for j in 0...i
            if nums[i] > nums[j]
                dp[i] = [dp[j] + 1, dp[i]].max
                max_v = [dp[i], max_v].max
            end
        end
    end
    max_v
end


swap nodes in pair
def swap_pairs(head)
    return head if head.nil? or head.next.nil?
    dummy = ListNode.new(0)
    dummy.next = head
    curr = dummy
    while !curr.next.nil? and !curr.next.next.nil?
        first = curr.next
        second = curr.next.next
        first.next = second.next
        second.next = first
        curr.next = second
        curr = first
    end
    dummy.next
end


letter combination of phone number 
def letter_combinations(digits)
    mapping = ["", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
    list = []
    return list if digits.nil? or digits.length == 0
    list << ""
    
    for i in 0...digits.length 
        digit = digits[i].to_i
        size = list.length
        for j in 0...size
           f = list.delete_at(0) 
            for k in 0...(mapping[digit].length)
                list << (f + mapping[digit][k])
            end
        end
    end
    list
end


flatten tree to list 
def flatten(root)
    return if root.nil?
    curr = root
    st = []
    while st.length > 0 || !curr.nil?
       st.push curr.right if !curr.right.nil?
       if !curr.left.nil?
           curr.right = curr.left
           curr.left = nil
       elsif st.length > 0
           curr.right = st.pop()
       end
       curr = curr.right
        
    end
end


sum root to leaf
def sum_numbers(root)
    return 0 if root.nil?
    st = []
    st << root
    res = 0
    while st.length > 0
       n = st.pop()
       if !n.right.nil?
           n.right.val += (n.val * 10)
           st << n.right
       end
       if !n.left.nil?
           n.left.val += (n.val * 10)
           st << n.left
       end
       res += n.val if n.left.nil? and n.right.nil?
           
    end
    res
    
end


set matrix zeroes
def set_zeroes(matrix)
    return matrix if matrix.nil? or matrix.length == 0
    first_row, first_col = false, false
    for i in 0...matrix.length
        for j in 0...matrix[0].length
            if matrix[i][j] == 0
                first_row = true if i == 0
                first_col = true if j == 0
                matrix[i][0] = 0
                matrix[0][j] = 0
            end
        end
    end
    
    for i in 1...matrix.length
        for j in 1...matrix[0].length
            matrix[i][j] = 0 if matrix[i][0] == 0 || matrix[0][j] == 0
        end
    end
    
    if first_row
        for i in 0...matrix[0].length
            matrix[0][i] = 0
        end
    end
    if first_col
        for i in 0...matrix.length
            matrix[i][0] = 0
        end
    end
end


find all duplciates in array 
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

def find_duplicates(nums)
    res = []
    return res if nums.nil? or nums.length < 2
    for i in 0...nums.length
       val = nums[i].abs
       res << val if (nums[val - 1] < 0)
       nums[val - 1] *= -1 if nums[val - 1] > 0
    end
    res
end

top k frequent elements 
def top_k_frequent(nums, k)
    return [] if nums.nil? || nums.length == 0
    list, res = [], []
    map = Hash.new 0
    
    for i in 0...nums.length
        map[nums[i]] += 1
    end
    
    map.each do |key, value|
       list << [key, value] 
    end
    
    list.sort!{|x, y| y[1] <=> x[1]}
    for i in 0...k 
        res << list[i][0]
    end
    res
    
end

non-overlapping interval 
def erase_overlap_intervals(intervals)
    return 0 if intervals.nil? or intervals.length == 0
    intervals.sort!{|a, b| a.end - b.end}
    end_v = intervals[0].end
    count = 0
    for i in 1...intervals.length
        if intervals[i].start >= end_v
            end_v = intervals[i].end
        else
            count += 1
        end
    end
    count
end


binary tree right side view
def right_side_view(root)
    res = []
    return res if root.nil?
    q = []
    q.push(root)
    while(q.length > 0)
       size = q.length
       for i in 0...size
           n = q.delete_at(0)
           res << n.val if i == 0
           q << n.right if !n.right.nil?
           q << n.left if !n.left.nil?
       end
    end
    res
end


level order traversal 
def level_order(root)
    res = []
    return res if root.nil?
    q = []
    q.push(root)
    while(q.length > 0)
       size = q.length
       eles = []
       for i in 0...size
           n = q.delete_at(0)
           eles << n.val
           q.push n.left if !n.left.nil?
           q.push n.right if !n.right.nil?
       end
       res << eles
    end
    res
end


spiral matrix 
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

def generate_matrix(n)
    res = Array.new(n){Array.new(n)}
    val = 1
    left, right, top, bottom = 0, n - 1, 0, n - 1
    while true
        for i in left..right
            res[top][i] = val
            val += 1
        end
        top += 1
        break if top > bottom || left > right
        
        
        for i in top..bottom
            res[i][right] = val
            val += 1
        end
        right -= 1
        break if top > bottom || left > right
        
        
        for i in right.downto(left)
            res[bottom][i] = val
            val += 1
        end
        bottom -= 1
        break if top > bottom || left > right
        
        
        for i in bottom.downto(top)
            res[i][left] = val
            val += 1
        end
        left += 1
        break if top > bottom || left > right
        
    end
    res
end


add one row
def add_one_row(root, v, d)
    if d == 1
        newRoot = TreeNode.new(v)
        newRoot.left = root
        return newRoot
    end
    
    q = []
    q << root
    
    for row in 1...(d - 1)
       size = q.length
       for j in 0...size
          n = q.delete_at(0)
          q << n.left if !n.left.nil?
          q << n.right if !n.right.nil?
       end
    end
    
    while q.length > 0
       n = q.delete_at(0)
       right = n.right
       left = n.left
       new_right = TreeNode.new(v)
       new_left = TreeNode.new(v)
       n.right = new_right
       n.left = new_left
       new_right.right = right
       new_left.left = left
    end
    
    root
end

product of array except self 
def product_except_self(nums)
    return [] if nums.nil?
    n = nums.length
    temp = 1
    res = Array.new(n, 0)
    for i in 0...n
        res[i] = temp
        temp *= nums[i]
    end
    temp = 1
    
    for i in (n - 1).downto(0)
        res[i] *= temp
        temp *= nums[i]
    end
    res
    
end

inorder traversal 
def inorder_traversal(root)
    return [] if root.nil?
    st = []
    res = []
    while(!root.nil? || st.length > 0)
        while(!root.nil?)
            st << root
            root = root.left
        end
        root = st.pop()
        res << root.val
        root = root.right
    end
    res
end

most frequent subtree sum
$maxval = 0
def add(root, sumCount)
   return 0 if root.nil? 
   left = add(root.left, sumCount)
   right = add(root.right, sumCount)
   sum = root.val + left + right
   if !sumCount.key?(sum)
       sumCount[sum] = 0
   end
    
   sumCount[sum] += 1
   $maxval = [$maxval, sumCount[sum]].max
   return sum
    
end
def find_frequent_tree_sum(root)
    sumCount = Hash.new
    $maxval = 0
    add(root, sumCount)
    res = []
    puts sumCount
    sumCount.each do |key, value|
       if value == $maxval
           res << key
       end
    end
    return res
end

friends circle
def dfs(m, visited, i)
   for j in 0...m.length
      if m[i][j] ==1 and visited[j] == 0
         visited[j] = 1
          dfs(m, visited, j)
      end
   end
end
def find_circle_num(m)
    visited = Array.new(m.length, 0)
    count = 0
    for i in 0...m.length
       if visited[i] == 0
          dfs(m, visited, i)
          count += 1 
       end
    end
    count
end

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

def remove_elements(head, val)
    return head if head.nil?
    while !head.nil? and head.val == val
        head = head.next
    end
    return head if head.nil?
    
    p = head
    runner = head.next
    while !runner.nil?
        if runner.val == val
            while !runner.nil? and runner.val == val
                runner = runner.next
            end
            p.next = runner
        else
            p = p.next
            runner = runner.next
        end
    end
    head
end


def longest_common_prefix(strs)
    if strs.nil? or strs.length == 0
        return ''
    end
    
    prefix = strs[0]
    for i in 1...strs.length do
        while !prefix.nil? && strs[i].index(prefix) != 0
            prefix = prefix[0...-1]
        end
    end
    prefix
end

valid parentheses
def is_valid(s)
    st = []
    if s.length % 2 == 1
        return false
    end
    h = Hash.new
    h['('] = ')'
    h['{'] = '}'
    h['['] = ']'
    for i in 0...s.length
       ch = s[i]
       if h.key?(ch)
          st << ch 
       else
           if st.length == 0
               p ch
               return false
           elsif h[st[-1]] != ch
               p 'h2'
               return false
           else
               st.pop
           end
       end
        
    end
    st.length == 0
end


two sum
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

def two_sum(nums, target)
    map = Hash.new -1
    for i in 0...nums.length
        x = nums[i]
        if map[target - x] != -1
            return [i, map[target - x]]
        else
            map[x] = i
        end
    end
    return false
end


battleship
def count_battleships(board)
    if board.nil? or board.length == 0
        return 0
    end
    count = 0
    for i in 0...board.length
        for j in 0...board[0].length
            next if board[i][j] == '.' 
            next if i > 0 and board[i - 1][j] == 'X'
            next if j > 0 and board[i][j - 1] == 'X'
            count += 1
        end
    end
    count          
end


def hamming_distance(x, y)
    # convert to string
    # count the number of ones
    xor_chars = (x ^ y).to_s(2).split('')
    
    res = 0
    puts xor_chars
    xor_chars.each{ |c|
        puts c
        if (c == '1')
            res += 1
        end
    }
    res
end

# best time to buy and sell stock 
# only one transaction
def max_profit(prices)
    if prices.length == 0
        return 0
    end
    min_val = prices[0]
    max_profit = 0
    for i in 0...prices.length
        min_val = [min_val, prices[i]].min
        max_profit = [max_profit, prices[i] - min_val].max
    end
    max_profit
end

# find the difference
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.
def find_the_difference(s, t)
    h = Hash.new 0
    for pos in 0...s.length
        h[s[pos]] += 1
    end
    for pos in 0...t.length
        h[t[pos]] -= 1
        if h[t[pos]] < 0
            return t[pos]
        end
    end
    

end

climbing stars
def climb_stairs(n)
    if n == 0
        return 0
    end
    dp = Array.new(n + 1, 0)
    dp[0] = 1
    dp[1] = 1
    for i in 2..n
        dp[i] = dp[i - 1] + dp[i - 2]
    end
    dp[n]
end

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
def move_zeroes(nums)
    for i in 0...nums.length
        j = i
        while j > 0 and nums[j - 1] == 0 and nums[j] != 0
            nums[j - 1], nums[j] = nums[j], nums[j - 1]
            j -= 1
        end
    end
end

#merge trees
def merge_trees(t1, t2)
    if t1.nil?
        t2
    elsif t2.nil?
        t1
    else
        t1.val += t2.val
        t1.left = merge_trees t1.left, t2.left
        t1.right = merge_trees t1.right, t2.right
        t1
    end
end


add binary
def add_binary(a, b)
    if a.nil?
        return b
    end
    if b.nil?
        return a
    end
    res = ''
    carry = 0
    sum = 0
    i = a.length - 1
    j = b.length - 1
    while i >= 0 || j >= 0 || carry > 0
       val1 = (i >= 0)? a[i].to_i: 0
       val2 = (j >= 0)? b[j].to_i: 0
       sum = val1 + val2 + carry
       carry = sum / 2
       res << ( sum % 2).to_s
       i -= 1
       j -= 1
    end
    p res
    res.reverse!
    return res
end

#first bad version
def first_bad_version(n)
    i = 0
    j = n
    while (i < j)
       mid = i + (j - i)/2
       if (is_bad_version(mid))
           j = mid
       else
           i = mid + 1
       end
    end
    i
end


def find_words(words)
    # create a map
    h = Hash.new
    keys = ["QWERTYUIOP","ASDFGHJKL","ZXCVBNM"]
    keys.each_with_index do |val, i|
        for pos in 0..val.length - 1 do
            h[val[pos]] = i
        end
    end
    
    res = []
    words.each do |word|
        index = h[word[0].upcase]
        for pos in 0..word.length - 1 do
           if index != h[word[pos].upcase] 
               index = -1
               break
           end
        end
        if index != -1
            res.push(word)
        end
    end
    res
end

is tree balanced
def helper(root)
    if root.nil?
        return 0
    elsif root.left.nil? and root.right.nil?
        return 1
    end
    left = helper(root.left)
    if left == -1
        return -1
    end
    right = helper(root.right)
    if right == -1
        return -1
    end
    if (left - right).abs > 1
        return -1
    end
    return 1 + [left, right].max
end
def is_balanced(root)
    helper(root) != -1
end


remove duplicates from sorted array 
def remove_duplicates(nums)
    if nums.length < 2
        return nums.length
    end
    count = 1
    curr = nums[0]
    for i in 1...nums.length
       if curr != nums[i]
           nums[count] = nums[i]
           count += 1
           curr = nums[i]
       end
    end
    return count
end



Distribute candies
requrie 'set'
def distribute_candies(candies)
    # min(set.size, candies.length/2)
    uniqueEle = Set.new(candies)
    [uniqueEle.length, candies.length/2].min
end


reverse string
Given s = "hello", return "olleh".
def reverse_string(s)
    i = s.length - 1
    result = ""
    while i >= 0 do
       result << s[i]
       i -= 1
    end
    result
end

maximum subarray
# @param {Integer[]} nums
# @return {Integer}
def max_sub_array(nums)
    if nums.length == 0
        return 0
    end
    dp = Array.new(nums.length, 0)
    maxval = nums[0]
    dp[0] = nums[0]
    for i in 1...nums.length
        dp[i] = [nums[i], nums[i] + dp[i - 1]].max
        maxval = [maxval, dp[i]].max
    end
    return maxval
end


fizzbuzz
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

def fizz_buzz(n)
    res = []
    (1...n + 1).each do |n|
        if n % 15 == 0
            res << "FizzBuzz"
        elsif n % 5 == 0
            res << "Buzz"
        elsif n % 3 == 0
            res << "Fizz"
        else
            res << n.to_s
        end
    end
    res
end


reverse vowels
def reverse_vowels(s)
    set = Set.new(['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'])
    i = 0
    j = s.length - 1
    while (i < j)
        while (i < j && !set.include?(s[i]))    
            i += 1
        end
        while (i < j && !set.include?(s[j]))
            j -= 1
        end
        if (i < j)
            s[i], s[j] = s[j], s[i]
            i += 1
            j -= 1
        end
    end
    s
end

rotate array by key
def reverse(nums, i, j)
   while(i < j)
      nums[i], nums[j] = nums[j], nums[i]
      i += 1
      j -= 1
   end
end

def rotate(nums, k)
    n = nums.length
    k = k % n
    reverse(nums, 0, n - 1)
    reverse(nums, 0, k - 1)
    reverse(nums, k, n - 1)
end

length of last word
def length_of_last_word(s)
    i = s.length - 1
    count = 0
    while i >= 0 && s[i] == ' '
        i -= 1
    end
    while i >= 0 && s[i] != ' '
        count += 1
        i -= 1
    end
    count
end


reverse string 3
https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
https://discuss.leetcode.com/topic/85882/1-line-ruby-python

https://leetcode.com/problems/next-greater-element-i/description/
https://leetcode.com/problems/island-perimeter/description/
https://leetcode.com/problems/island-perimeter/description/