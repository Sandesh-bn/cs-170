// tricks

// convert number to binary string
var bs = num.toString(2);

// binary string to number
var num = parseInt(bs, 2);

// intialize array 
let nums = new Array(len);
nums.fill(0);

// get index
for (let i in array){
    console.log(`index is ${i}`)
}

// get elements
for (let word of wordArray){
    console.log(`element is ${word}`);
}

// get character from ascii
let character = String.fromCharCode(asciiValue)

strings are immutable. You cannot change a character within a string with something like var myString = "abbdef"; myString[2] = 'c'. The string manipulation methods such as trim, slice return new strings.

// strinbuilder in js
https://www.sitepoint.com/javascript-fast-string-concatenation/

// insert at specific index of array
https://stackoverflow.com/questions/586182/how-to-insert-an-item-into-an-array-at-a-specific-index
arr.splice(index, 0, item);

//listnode 
function ListNode(val){
    this.val = val;
    this.next = null;
}
// add two/more numbers without using addition
// hamming distance
var hammingDistance = function(x, y){
    let xor = (x ^ y);
    let res = 0;
    for (let i of xor){
        if (i === '1')res++;
    }
    returnr res;
}

// judge route circle
// https://leetcode.com/problems/judge-route-circle/description/
var judgeCircle = function(moves){
    let v = [0, 0];
    let i = 0;
    while (i < moves.length){
        var move = moves.charAt(i);
        switch(move){
            case 'U':
                v[1]++;
                break;
            case 'D':
                v[1]--;
                break;
            case 'R':
                v[0]++;
                break;
            case 'L':
                v[0]--;
                break;
            default:
                break;
        }
        i++;
    }
    return v[0] === 0 && v[1] === 0;
}

// number complement
var findComplement = function(num){
    var str = num.toString(2);
    var res = '0';
    for (let i = 0; i < str.length; i++){
        res = res + (str.charAt(0) === '0'? '1': '0');
    }
    return parseInt(res, 2);
}

// keyboard row.

var findWords = function(word){
    let keys = ["QWERTYUIOP","ASDFGHJKL","ZXCVBNM"];
    let rowMap = {};
    for (let i = 0; i < keys.length; i++){
        for (let c of keys[i]){
            rowMap[c] = i;
        }
    }

    let res = [];
    for (word of words){
        if (word === "")
            continue;
        let first = word[0].toUpperCase();
        let index = rowMap[first];

        for (let c of word){
            c = c.toUpperCase();
            if (rowMap[c] !== index){
                index = -1;
                break;
            }
        }
        if (index !== -1){
            res.push(word);
        }
    }
    return res;
}


// reverse string
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

var reverseWords = function(s){
    return s.split(" ").reverse().join("").split(" ").reverse().join(" ");
}

input: "hello";
output: "olleh";

ver reverseString = function(s){
    var res = "";
    for (let i = s.length - 1; i >= 0; i--)
        res += s.charAt(i);
    return res;
}
var reverseString = function(s){
    return s.split('').reverse().join('');
}

// matrix reshape

var reshape = function(nums, r, c){
    if (nums.length * nums[0].length !== r * c)
        return nums;
    let res = [[]];
    let col = 0, row = 0;
    for (let i = 0; i < nums.length; i++){
        for (let j = 0; j < nums[0].length; j++){
            if (col >= c){
                col = 0;
                row++;
                res.push([]);
            }
            res[row][col] = nums[i][j];
            col++;

        }
    }
}

// island perimter
var perimeter = function(grid){
    var row = grid.length;
    var col = grid[0].length;
    for (var i = 0; i < row; i++){
        for (var j = 0; j < col; j++){
            perimeter += 4;
            if (i > 1 && grid[i - 1][j] === 1)perimeter--;
            if (j > 1 && grid[i][j - 1] === 1)perimeter--;
            if (i < row - 1 && grid[i + 1][j]) perimeter--;
            if (j < col - 1 && grid[i][j + 1]) perimeter--;
        }
    }
}


// maority element
var majorityelement = function(arr){
    let candidate = '';
    let count = 0;
    for (let i in arr){
        let ele = arr[i];
        if (count === 0){
            candidate = ele;
            count = 1;
        }
        else if (candidate === ele){
            count++;
        }
        else
        count--;
    }
    return count === 0? -1: candidate;
}

// stock market 1 as many transaction as you like
var maxProfit = function(prices){
    let profit = 0;
    for (let i = 0; i < prices.length; i++){
        if (prices[i + 1] > prices[i])
            profit += prices[i + 1] - prices[i];
    }
}

// stock market atmost one transaction(buy and sell
var maxProfit = function(prices) {
    // https://discuss.leetcode.com/topic/80970/clear-javascript-solution
    if (!prices || !prices.length)
        return 0;
    let min = prices[0], maxProfit = 0;
    for (let i = 0; i < prices.length; i++){
        min = Math.min(prices[i], min);
        maxProfit = Math.max(maxProfit, prices[i] - min);
    }
    return maxProfit;
};


retunr true if array contains duplicat
var containsDup = function(nums){
    return new Set(nums).size < nums.length;
}
// random note

var canConstruct = function(ransom, magazine){
    let ascii = {};
    for (let i = 0; i < magazine.length; i++){
        let asciiCode = magazine.charCodeAt(i);

        ascii[asciiCode] = (asciiCode || 0) + 1;
    }
    for (i = 0; i < ransom.length; i++){
        let ascii = ransome.charCodeAt(i);
        ascii[asciiCode] = (asciiCode || 0) - 1;
        if (ascii[asciiCode] < 0)
            return false;
    }
    return true;
}

min depth and maxium depth watch youtube tutorial
var maxDepth = function(root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
};

// intersection
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
given nums1 = [1], nums2 = [1, 1] return [1];

var intersection = function(nums1, nums2){
    var set = new Set();

    for (let n of nums1)
    set.add(n);

    let res = [];
    for (let n of nums2){
        if (set.has(n)){
            set.delete(n);
            res.push(n);
        }
    }
    return res;
}

// repeatedly add digits until only one digit is left
return ((num - 1) % 9 + 1);


// first unique character: 
input 'leetcode' return 'l'

var firstUniqChar = function(s) {  
    var ascii = {};
    for (var c of s){
        ascii[c] = (ascii[c] || 0) + 1;
    }
    for (var i = 0; i < s.length; i++){
        if (ascii[s.charAt(i)] === 1)
            return i;
    }
    return -1;
};


// pascall
For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

var generate = function(numRows) {
    let res = [];
    if (numRows === 0) return res;
    res = [[1]];
    if (numRows === 1) return res;
    res.push([1, 1]);
    for (let i = 2; i < numRows; i++){
        let temp = [1];
        for (let j = 0; j < res[i - 1].length - 1; j++)
            temp.push(res[i - 1][j] + res[i - 1][j + 1]);
        temp.push(1);
        res.push(temp);
    }
    return res;
};


// happy number
A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

const isHappy = function(n){
    let sum = 0;
    let hash = {};
    while(n){
        while(n !== 0){
            let d = n % 10;
            n /= 10;
            sum += (n * n);
        }
        if (sum === 1)
            return true;
        if(!hash[sum])
            hash[sum] = 1;
        else
            return false;
        n = sum;
        sum = 0;
    }
}

roman to decimal
var romanToInt = function(s){
    var hash = {
        'I': 1,
        'V': 5,
        'X': 10,
        ....
    }
    let res = 0;
    for (var i = 0; i < s.length - 1; i++){
        let c = s.charAt(i);
        let curr = hash[s.charAt(i)];
        let next = hash[s.charAt(i + 1)];

        if (curr >= next)
            res += curr;
        else
            res -= curr;
    }
    res += hash[s(-1)];
    return res;
}

anagram
var isAnagram = function(s, t){
    var hash = {};
    for (let c of s){
        hash[c] = (hash[c] || 0) + 1;
    }
    for (let c of t){
        hash[c] = (hash[c] || 0) - 1;
    }
    for (let key in hash)
        if (hash[key] !== 0) return false;
    
    return true;
}


// reverse only vowels
var reverseVowels = function(s) {
    //https://discuss.leetcode.com/topic/91987/2-line-javascript-o-n-solution-using-stack-and-regex
    let arr = s.split('');
    let vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'];
    let i = 0, j = s.length - 1;
    while(i < j){
        while(i < j && !vowels.includes(s[i]))
            i++;
        while(i < j && !vowels.includes(s[j]))
            j--;
        if (i < j){
            var t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;j--;
        }
        
    }
    return arr.join('');
};

// reversebits
var reversebits = function(n){
    var str = n.toString(2).split("").reverse().join("");
    while(str.length < 32){
        str = str + '0';
    }
    return parseInt(str, 2);
}

// longest common prefix

const longestCommonPrefix = function(strs){
    if (strs.length < 1) return '';
    let prefix = strs[0];
    for (let word of strs){
        while(word.indexOf(prefix) !== 0)
            prefix = prefix.substring(0, prefix.length - 1);
    }
    return prefix;
}

// isomorphic string
For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

const isIsomorphic = function(s, t){
    let tchar = [];
    let schar = [];
    for (let i = 0; i < 256; i++){
        thcar.push('');
        schar.push('');
    }
    let i = 0;
    while(i < s.length){
        let tc = t.charCodeAt(i);
        let sc = t.charCodeAt(i);
        if (schars[sc] === '' && tchar[tc] === ''){
            schars[sc] = tc;
            tchars[tc] = sc;
        }
        else if (schars[sc] !== tc || tchars[tc] !== sc)
            return false;
        i++;
    }
    return true;
}


determine number is palindrome

ver isPalindrome = function(x){
    let copy = x;
    let res = 0;
    while(copy > 0){
        res = (res * 10) + copy % 10;
        copy = Math.floor(copy / 10);
    }
    return res === x;
}


// count segments
var countSegment = function(s){
    let count = 0;
    let i = 0;
    let N = s.length();
    while (i < N){
        if (s.charAt(i) !== ' '){
            count++;
            while (i < N && s.charAt(i) !== ' ')
                i++;
        }
        else
            i++;
    }
    return count;
}


// frequency sort
Input:
"tree"

Output:
"eert"

Input:
"Aabb"

Output:
"bbAa"

let frequencySort = function(s){
    let ascii = [];
    for (let i = 0; i < 256; i++)
        ascii.push(0);
    
    for (let i = 0; i < s.length; i++){
        let a = s.charCodeAt(i);
        ascii[a] = (ascii[a] || 0) + 1;
    }

    let map = new Map();
    for (let i = 0; i < ascii.length; i++){
        let count = ascii[i];
        if(!map.has(count)){
            map.set(count, []);
        }
        map.get(count).push(String.fromCharCode(i))
    }

    let str = '';
    for (let i = s.length; i >= 0; i--){
        if (map.has(i)){
            let lis = map.get(i);
            for (let c of lis){
                for (let j = 0; j < i; j++)
                    str += c;
            }
        }
    }
}

max subarray 
var maxSubArray = function(nums) {
    if(!nums || nums.length == 0) return 0;
    let N = nums.length;
    let dp = new Array(N);
    dp.fill(0);
    dp[0] = nums[0];
    let max = dp[0];
    for (let i = 1;i < N; i++){
        dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        max = Math.max(max, dp[i]);
    }
    return max;
};

count primes 
var countPrimes = function(n) {
    //https://discuss.leetcode.com/topic/68809/simple-javascript-solution/2
    if (n <= 2) return 0;
    let nonprimes = new Array(n);
    nonprimes.fill(false);
    let count = 0;
    for(let i = 2; i * i <= n; i++){
        if(!nonprimes[i]){
            for (let j = i; j * i < n; j++){
                nonprimes[j * i] = true;
            }
        }
    }
    for (let i = 2; i < nonprimes.length; i++)
        if (!nonprimes[i])count++;
    
    return count;


var convertToTitle = function(n) {
    var keys = ['Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'],
        mod, string = ''
    while (n > 0) {
        mod = n % 26
        string = keys[mod] + string
        n = Math.floor((n - 1) / 26)
    }
    return string
};


queue reconstruction
var reconstructQueue = function(people) {
    people.sort((a, b) => {
      if (b[0] !== a[0])
          return b[0] - a[0];
      else
          return a[1] - b[1];
    })
    let res = [];
    for (let p of people){
        res.splice(p[1], 0, p);
    }
    return res;
};


//return top k most occuring elements;
Given [1,1,1,2,2,3] and k = 2, return [1,2].
const topK = function(nums, k){
    if (!nums || nums.length == 0 || k < 1) return;
    let map = new Map();
    let list = [];
    let res = [];
    let temp;
    for (let i = 0; i < nums.length; i++){
        if(!map.has(nums[i]))
            map.set(nums[i], 0);
        map.set(nums[i], map.get(nums[i]) + 1);
    }

    map.forEach((val, key, map) => {
        list.push([key, val])
    });
    list.sort((a, b) => b[1] - a[1]);

    for (let i = 0; i < k; i++)
        res.push(list[i][0]);
    
    return res;
}

// shuffle an array
/ Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();

var Solution = function(nums){
    this.nums = nums || [];
}

Solution.prototype.reset = () => this.nums;

Solution.prototype.shuffle = () => {
    let copy = this.nus.slice();

    let size = copy.length;
    for (let i = 0; i < size; i++){
        let rand = Math.floor(Math.random() * size);
        let temp = copy[i];
        copy[i] = copy[rand];
        copy[rand] = temp;
    }
    return copy;

}

binary tree has root to leaf path 
var hasPathSum = function(root, sum) {
    if (root === null) return false;
    if (root.left === null && root.right === null && sum === root.val)
        return true;
    sum -= root.val;
    return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
};

valid parenthesis is balanced 
var isValid = function(s) {
    let stack = [];
    if(!s || !s.length ) return true;
    if(s.length % 2 !== 0) return false;
    let map = new Map();
    map.set('(', ')');
    map.set('{', '}');
    map.set('[', ']');
    
    for (let c of s){
        if (map.has(c))
            stack.push(c);
        else if (!stack.length)
            return false;
        else if (map.get(stack[stack.length - 1]) !== c)
            return false;
        else
            stack.pop();
    }
    return stack.length === 0;
    
};

var countBattleships = function(board) {
    if (!board || !board.length) return 0;
    let count = 0;
    for (let i = 0; i < board.length; i++){
        for (let j = 0; j < board[0].length; j++){
            if (board[i][j] === '.') continue;
            if (i > 0 && board[i - 1][j] === 'X')continue;
            if (j > 0 && board[i][j - 1] === 'X') continue;
            count++;
        }
;    return count
};

var addBinary = function(a, b) {
    if(!a) return b;
    if(!b) return a;
    let carry = 0, sum = 0;
    let i = a.length - 1, j = b.length - 1;
    let res = '';
    while(i >= 0 || j >= 0 || carry > 0){
        let val1 = i >= 0? parseInt(a[i]): 0;
        let val2 = j >= 0? parseInt(b[j]): 0;
        let sum = val1 + val2 + carry;
        carry = Math.floor(sum / 2);
        res += (sum % 2);
        i--;j--;
    }
    return res.split("").reverse().join("");
};

var longestCommonPrefix = function(strs) {
    //https://discuss.leetcode.com/topic/67758/javascript-12-lines-o-n-m-vertical-scanning-solution
    // https://discuss.leetcode.com/topic/89674/javascript-solution-divide-and-conquer
    //https://discuss.leetcode.com/topic/65461/javascript-binary-search-solution
    if(strs.length < 1) return '';
    let prefix = strs[0];
    for (let word of strs){
        while(word.indexOf(prefix) !== 0)
            prefix = prefix.substring(0, prefix.length - 1);
    }
    return prefix;
};

watch youtbue maximum subarray lis
mindepth
var minDepth = function(root) {
    if (root === null) return 0;
    if (root.left === null && root.right === null) return 1;
    let leftDepth = (!root.left)?Number.MAX_VALUE: minDepth(root.left);
    let rightDepth = (!root.right)?Number.MAX_VALUE: minDepth(root.right);
    return 1 + Math.min(leftDepth, rightDepth);
};


word pattern 
var wordPattern = function(pattern, str) {
    //https://discuss.leetcode.com/topic/103443/javascript-solution
    //https://discuss.leetcode.com/topic/89439/javascript-solution
    //https://discuss.leetcode.com/topic/74914/my-easy-understand-javascript-solution
    //https://discuss.leetcode.com/topic/70934/2-maps-simple-javascript
    let map = new Map();
    let characters = pattern.split("");
    let words = str.split(" ");
    console.log(`${characters}`)
    if (characters.length !== words.length)
        return false;
    for (let i = 0; i < words.length; i++){
        if (map.has(characters[i]) && map.has(words[i])){
            if(map.get(characters[i]) !== map.get(words[i]))
            return false;    
        }
        map.set(characters[i], i);
        map.set(words[i], i)
        
    }
    return true;
};
// return kth largest element in matrixreturn matrix.reduce((arr, row) => arr.concat(row), []).sort((a,b) => a-b)[k - 1]


// Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
var removeElements = function(head, val) {
    while(head && head.val === val) head = head.next;
    let runner = head.next, tail = head;
    while(runner){
        if (runner.val === val){
            while(runner && runner.val == val)
                runner = runner.next;
            tail.next = runner;
        }
        else {
            runner = runner.next;
            tail = tail.next;
        }
    }
    return head;
};

postorder traversal 

var postorderTraversal = function(root) {
    let res = [];
    if(!root) return res;
    let stack = [];
    stack.push(root);
    while(stack.length){
        if (root){
            stack.push(root);
            res.unshift(root.val);
            root = root.right;
        }
        else 
            root = stack.pop().left;
    }
    return res;
};


preorder traversal 
var preorderTraversal = function(root) {
    let res = [];
    let stack = [];
    if (root === null) return res;
    stack.push(root);
    while(stack.length){
        let n = stack.pop();
        if (n.right !== null) stack.push(n.right);
        if (n.left !== null) stack.push(n.left);
        res.push(n.val);
    }
    return res;
};


level order traversal 2
var levelOrderBottom = function(root) {
    let res = [];
    let queue = [];
    if (!root) return res;
    queue.push(root);
    while(queue.length > 0){
        let levelSize = queue.length;
        let levelelements = [];
        for (let i = 0; i <levelSize; i++){
            let front = queue.shift();
            if (front.left !== null) queue.push(front.left);
            if (front.right !== null) queue.push(front.right);
            levelelements.push(front.val);
        }
        res.push(levelelements);
    }
    res.reverse();
    return res;
};


kth smallest element in bst 
var kthSmallest = function(root, k) {
    let stack = [];
    while(root !== null || stack.length > 0){
        while(root !== null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        if (--k == 0) return root.val;
        root = root.right;
    }
    return -1;
};


serialize and deserialize bst


const helper = function(root, sb) {
    if (root === null){
        sb += "null,";
        return;
    }
    sb += (root.val + ",");
    helper(root.left, sb);
    helper(root.right, sb);
}
var serialize = function(root) {
    let sb = '';
    helper (root, sb);
    return sb;
};

let index = 0;
var dehelper = function(tokens){
    if (index == tokens.length || tokens[index] === "null"){
        index += 1;
        return null;
    }
    let node = new TreeNode(parseInt(tokens[index]));
    index += 1;
    node.left = dehelper(tokens);
    node.right = dehelper(tokens);
    return node;
}
var deserialize = function(sb) {
    let tokens = sb.split(",");
    return dehelper(tokens);
};


generate subsets
var subsets = function(nums) {
    let res = [];
    res.push([]);
    let begin = 0;
    nums.sort((a,b) => a - b);
    for (let i = 0; i < nums.length; i++){
        if (i == 0 || nums[i] != nums[i - 1])
            begin = 0;
        let size = res.length;
        for (let j = begin; j < size; j++){
            let curr = res[j].slice();
            curr.push(nums[i]);
            res.push(curr);
        }
        begin = size;
    }
    return res;
};

binary tree right side view 
var rightSideView = function(root) {
    let res = [];
    if (root === null) return res;
    let q = [];
    q.push(root);
    while(q.length > 0){
        let levelSize = q.length;
        for (let i = 0; i < levelSize; i++){
            let node = q.shift();
            if (i === 0) res.push(node.val);
            if (node.right !== null) q.push(node.right);
            if (node.left !== null) q.push(node.left);
        }
    }
    return res;
};


level order traversal 
var levelOrder = function(root) {
    let res = [];
    if (root === null) return res;
    let q = [];
    q.push(root);
    while(q.length > 0){
        let size = q.length;
        let levelele = [];
        for (let i = 0; i < size; i++){
            let n = q.shift();
            levelele.push(n.val);
            if (n.left !== null) q.push(n.left);
            if (n.right !== null) q.push(n.right);
        }
        res.push(levelele);
    }
    return res;
};



candies
Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.

Example 1:
Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
The sister has three different kinds of candies. 
Example 2:
Input: candies = [1,1,2,3]
Output: 2
Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1]. 
The sister has two different kinds of candies, the brother has only one kind of candies. 

let val = function(candies){
    let set =  new Set();
    let mid = candies.length /2;
    for (let c of candies)set.add(c);
    return Math.min(set.size, mid);
}

Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

Example 1:
Input: "aba", "cdc"
Output: 3
Explanation: The longest uncommon subsequence is "aba" (or "cdc"), 
because "aba" is a subsequence of "aba", 
but not a subsequence of any other strings in the group of two strings. 

var fun = function(a, b) => {
    return (a === b)? -1: Math.max(a.length, b.length);
}

// odd even list
// Given 1->2->3->4->5->NULL,
//return 1->3->5->2->4->NULL.
var oddEvenList = function(head) {
    if (!head || !head.next) return head;
    
    let odd = head, even = head.next, firstEven = even;
    while(even !== null && even.next !== null){
        odd.next = even.next;
        odd = odd.next;
        even.next = odd.next;
        even = even.next;
    }
    odd.next = firstEven;
    return head;
};

pascal 2
var getRow = function(rowIndex) {
    let pascal = [];
    pascal.push([1]);
    pascal.push([1, 1]);
    if (rowIndex < 2)
        return pascal[rowIndex];
    
    for (let i = 2; i <= rowIndex; i++){
        pascal.splice(0, 1);
        let temp = [];
        temp.push(1);
        for (let j = 0; j < pascal[0].length - 1; j++)
            temp.push(pascal[0][j] + pascal[0][j + 1]);
        temp.push(1);
        pascal.push(temp);
    }
    return pascal[1];
};

var MyStack = function() {
    this.arr = [];
};

MyStack.prototype.push = function(x) {
    this.arr.push(x);
};


MyStack.prototype.pop = function() {
    return this.arr.pop();
};

MyStack.prototype.top = function() {
    return this.arr[this.arr.length - 1];
};
MyStack.prototype.empty = function() {
    return this.arr.length === 0;
};


// int to roman
var intToRoman = function(num) {
    const M = ["", "M", "MM", "MMM"];
    const C = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"];
    const X = ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"];
    const I = ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"];
    
    return M[num/1000] + C[(num%1000) / 100] + X[(num % 100) / 10] + I[num % 10];
};


// generate parentheses
For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
const helper = function(res, left, right, brackets){
    if (left === 0 && right === 0)
        res.push(brackets);
    if (left > 0)
        helper(res, left - 1, right, brackets + '(');
    if (right > 0 && right > left)
        helper(res, left, right - 1, brackets + ')');
}
var generateParenthesis = function(n) {
    let res = [];
    helper(res, n, n, "");
    return res;
};

 Non-overlapping Intervals
 var eraseOverlapping = (intervals) => {
     if (!intervals || intervals.length === 0)
        return 0;
    
    intervals.sort((a, b) => a.end - b.end);

    let count = 0;
    let en d= intervals[0].start;
    for (let interval of intervals){
        if (interval.start >= end)
            end = interval.end;
        else
            count++;
    }
    return count;
 }

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

let minpath = function(triangle){
    // if triangle is null or len == 0 return 0;
    let N = triangle.length;
    let res = new Array(N);
    res.fill(0);
    for (let i = 0; i < res.length; i++)
        res[i] = triangle[N - 1][i];
    
    for (let i = N - 1; i >= 0; i--){
        for (let j = 0; j <= i; j++)
            res[j] = triangle[i][j] + min(res[j], res[j + 1]);
    }
    return res[0];
}

var searchRange = function(nums, target) {
    let ret = [-1, -1];
    if (!nums || nums.length < 1) return ret;
    let l = 0, h = nums.length - 1;
    while (l < h){
        let mid = Math.floor(l + (h  - l) / 2);
        if (nums[mid] < target)
            l = mid + 1;
        else h = mid;
    }
    if (nums[l] !== target) return ret;
    ret[0] = l;
    h = nums.length - 1;
    while(l < h){
        let mid = Math.floor(l + (h - l)/2) + 1;
        if (nums[mid] > target)
            h = mid - 1;
        else
            l = mid;
    }
    ret[1] = h;
    return ret;
    
};


compare version number;
var compareVersion = function(version1, version2) {
    let tokens1 = version1.split(".");
    let tokens2 = version2.split(".");
    let i = 0, j = 0;
    while (i < tokens1.length || j < tokens2.length){
        let v1 = (i < tokens1.length)? parseInt(tokens1[i]):0;
        let v2 = (j < tokens2.length)? parseInt(tokens2[j]):0;
        if (v1 > v2) return 1;
        if (v2 > v1) return -1;
        i++;j++;
    }
    return 0;
};

largest number
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

var largestNumber = function(nums) {
    if (nums.length === 0)
        return "0";
    nums.sort((a, b) => {
        let s1 = a + "" + b;
        let s2 = b + "" + a;
        return parseInt(s2) - parseInt(s1);
    })
    if (nums[0] == '0')
        return "0";
    return nums.join("");
};

var simplifyPath = function(path) {
    let set = new Set();
    set.add("..");
    set.add(".");
    set.add("");
    let st = [];
    for (let dir of path.split("/")){
        if (dir === ".." && st.length > 0)
            st.pop();
        else if(!set.has(dir))
            st.push(dir);
    }
    let res = "";
    for (let dir of st)
        res += ("/" + dir);
    return res.length > 0? res: "/";
};

n queen nqueen
/**
 * @param {number} n
 * @return {string[][]}
 */

let cols = new Set();
let diag = new Set();
let antiDiag = new Set();

const dfs = function(res, board, row, n) {
    if (row == n){
        let copy = board.slice();
        console.log("found")
        res.push(copy);
        return;
    }
    for (let col = 0; col < n; col++){
        console.log(`${row - col}  ${row + col}`)
        if(cols.has(col) ||
           diag.has(row - col) ||
           antiDiag.has(row + col))
            continue;
        let currRow = new Array(n);
        currRow.fill('.');
        currRow[col] = 'Q';
        let str = currRow.join('');
        board.push(str);
        cols.add(col);
        antiDiag.add(row + col);
        diag.add(row - col);
        
        dfs(res, board, row + 1, n);
        
        cols.delete(col);
        diag.delete(row - col);
        antiDiag.delete(row + col);
        board.pop();
    }
}
var solveNQueens = function(n) {
    let res = [];
    dfs(res, [], 0, n);
    return res;
};

edit distance 
var minDistance = function(word1, word2) {
    let m = word1.length, n = word2.length;
    if (!m && !n) return 0;
    let dp = [];
    for (let i = 0; i <= m; i++){
        let row = new Array(n + 1);
        row.fill(0);
        dp.push(row);
    }
    
    for (let i = 0; i <= m; i++){
        for (let j = 0; j <= n; j++){
            if (i == 0 || j == 0)dp[i][j] = i + j;
            else if (word1[i - 1] === word2[j - 1])
                dp[i][j] = dp[i - 1][j - 1];
            else
                dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
        }
    }
    return dp[m][n];
};

// https://photos.google.com/photo/AF1QipNsLdgaLGEhnLRZU9_9AENlDpcwuPxSq8uvAZCM

sliding window maximum
var maxSlidingWindow = function(nums, k) {
    let empty = [];
    if (!nums || !nums.length) return empty;
    let list = [];
    let res = [];
    for (let i = 0; i < k; i++){
        while(list.length && nums[list[list.length - 1]] < nums[i])
            list.pop();
        
        list.push(i);
    }
    for (let i = k; i < nums.length; i++){
        res.push(nums[list[0]]);
        while(list.length && (list[0] < (i - k + 1)))
            list.shift();
        
        while(list.length && nums[list[list.length - 1]] < nums[i])
            list.pop();
        list.push(i);
    }
    
    res.push(nums[list[0]]);
    return res;
};


// valid histogram
var largestRectangleArea = function(heights) {
    if (!heights) return 0;
    let stack = [];
    let i = 0, maxArea = 0, area = 0;
    while(i < heights.length){
        if (!stack.length || heights[stack[stack.length - 1]] <= heights[i])
            stack.push(i++);
        else{
            let top = stack.pop();
        
            if(!stack.length){
                area = heights[top] * i;
            }
            else 
                area = heights[top] * (i - stack[stack.length - 1] - 1);
            maxArea = Math.max(area, maxArea);
        }
    }
    
    while(stack.length){
        let top = stack.pop();
        
        if(!stack.length){
            area = heights[top] * i;
        }
        else 
            area = heights[top] * (i - stack[stack.length - 1] - 1);
        maxArea = Math.max(area, maxArea);
    }
    return maxArea;
};

var maximalRectangle = function(matrix) {
    if(!matrix.length)
        return 0;
    let m = matrix.length, n = matrix[0].length;
    let histogram = new Array(n);
    histogram.fill(0);
    let maxArea = 0;
    for (let i = 0; i < m; i++){
        for (let j = 0; j < n; j++){
            let cell = parseInt(matrix[i][j]);
            if (cell == 0)
                histogram[j] = 0;
            else
                histogram[j] += 1;
        }
        maxArea = Math.max(maxArea, largestRectangleArea(histogram));
    }
    return maxArea;
};


candy
var candy = function(ratings) {
    let N = ratings.length;
    let candies = new Array(N);
    candies.fill(1);
    for (let i = 1; i < N; i++){
        if (ratings[i] > ratings[i - 1])
            candies[i] = 1 + candies[i - 1];
    }
    for (let i = N - 2; i >= 0; i--){
        if (ratings[i] > ratings[i + 1])
            candies[i] = Math.max(candies[i], candies[i + 1] + 1);
    }
    let count = 0;
    for (let i in candies)
        count += candies[i];
    return count;
};


shortest palindrome 
var shortestPalindrome = function(s) {
    let i = 0, end = s.length - 1;
    let j = end;
    while(i < j){
        if(s[i] === s[j]){
            i++;
            j--;
        }
        else {
            i = 0;
            end--;
            j = end;
        }
    }
    let prefix = s.substring(end + 1);
    return prefix.split('').reverse().join('') + s;
};

class ZigZagIterator{
    constructor(list1, list2){
        super();
        this.index = 0;
    }

    next(){
        this.index++;
    }

    hasNext(){
        this.index < list1.length || this.index < list2.length;
    }
}

screen fitting
http://shirleyisnotageek.blogspot.com/2016/10/sentence-screen-fitting.html
https://photos.google.com/photo/AF1QipMbJGaLxILckBuZKMZAAC5nbfW5BpbgTMU1ybHd
const worsTyping = (sentence, rows, cols){
    let all = '';
    for (let word of sentence){
        all += word + " ";
    }
    let pos = 0;
    let len = all.length;
    for (let i = 0; i < rows; i++){
        pos += cols;
        if (all.charAt(pos % len ) == ' ')
            pos++;
        else {
            while(pos > 0 && all.charAt((pos - 1) % len) != ' ')
                pos--;
        }
    }
    return pos / len;
}


var isAnagram = function(s, t) {
    //https://discuss.leetcode.com/topic/95894/a-few-javascript-solutions
    var hash = {};
    for (let c of s){
        hash[c] = (hash[c] || 0) + 1;
    }
    for (let c of t){
        hash[c] = (hash[c] || 0) - 1;
    }
    for (let key in hash)
        if (hash[key] !== 0) return false;
    
    return true;
};

var romanToInt = function(s) {
  //https://discuss.leetcode.com/topic/94598/o-n-javascript-solution-using-hash
    //https://discuss.leetcode.com/topic/14527/my-javascrip-300ms-solution
    var hash = {
        'I': 1, 
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    };
    let res = 0;
    for (var i = 0; i < s.length - 1; i++){
        let c = s.charAt(i);
        let curr = hash[s.charAt(i)];
        let next = hash[s.charAt(i + 1)];
        if (curr >= next)
            res += curr;
        else
            res -= curr;
    }
    res += hash[s.charAt(s.length - 1)];
    return res;
};


sum of left leaves
var sumOfLeftLeaves = function(root) {
    if (root === null) return 0;
    let res = 0;
    let stack = [];
    stack.push(root);
    
    while(stack.length){
        let node = stack.pop();
        if (node.left !== null){
            if (node.left.left === null && node.left.right === null)
                res += node.left.val;
            else
                stack.push(node.left);
        }
        if (node.right !== null){
            if (node.right.left !== null || node.right.right !== null)
                stack.push(node.right);
        }
    }
    return res;
};


merge 2 lists
var mergeTwoLists = function(l1, l2) {
    if (l1 === null) return l2;
    if (l2 === null) return l1;
    let dummy = new ListNode(0);
    let curr = dummy;
    while(l1 !== null && l2 !== null){
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
    curr.next = (l1)?l1: l2;
    return dummy.next;
};


issymettric
var helper = function helper(left, right){
    if (left === null || right === null) return left === right;
    return (left.val === right.val) && helper(left.left, right.right) && helper(left.right, right.left);
}
var isSymmetric = function(root) {
   return root === null || helper(root.left, root.right); 
};


root to leaf path

var dfs = function(res, path, root){
    if (root.left === null && root.right === null)
        res.push(path + root.val);
    if (root.left !== null)
        dfs(res, path + root.val + "->", root.left);
    if (root.right !== null)
        dfs(res, path + root.val + "->", root.right);
}
var binaryTreePaths = function(root) {
    let res = [];
    if (root !== null)
        dfs(res, "", root);
    return res;
};


repetead substring pattern 
var repeatedSubstringPattern = function(s) {
  //https://discuss.leetcode.com/topic/100826/javascript-solution-119ms-easy-to-understand  
    let sb = s + s;
    return sb.substring(1, sb.length - 1).indexOf(s) !== -1;
};


find mode in bst
var findMode = function(root) {
    if (!root) return [];
    let max = 0;
    let stack = [];//[root];
    let map = new Map();
    while(root !== null || stack.length){
        while(root !== null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        let val = root.val;
        if (!map.has(val))
            map.set(val, 0);
        map.set(val, map.get(val) + 1);
        max = Math.max(map.get(val), max);
        root = root.right;
    }
    let res = [];
    map.forEach(function(item, key, map) {
        if (map.get(key) === max)
            res.push(key);
    });
    return res;
};


isbalanced binary tree is balanced 
var helper = function(root){
    if (root === null) return 0;
    if (root.left === null && root.right === null)
        return 1;
    let left = helper(root.left);
    if (left === -1) return -1;
    let right = helper(root.right);
    if (right === -1) return -1;
    
    if (Math.abs(left - right) > 1)
        return -1;
    
    return 1 + Math.max(left, right);
}
var isBalanced = function(root) {
    return helper(root) !== -1;
};


linkedlist cycle
var hasCycle = function(head) {
    if (!head || !head.next) return false;
    let fast = head, slow = head;
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if (fast === slow)
            return true;
    }
    return false;
};

partition list 
var partition = function(head, x) {
    if (head == null) return null;
    let dummyLess = new ListNode(0);
    let dummyMore = new ListNode(0);
    let curr = head, more = dummyMore, less = dummyLess;
    while(curr != null){
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
};


01 matrix; memorize
https://photos.google.com/photo/AF1QipM-6nUMCMhiv8CPZeMpQ4JfpR-x0mBYLkiVG8xQ
var updateMatrix = function(matrix) {
    if (!matrix || !matrix.length) return [];
    let rows = matrix.length, cols = matrix[0].length;
    let queue = [];
    for (let i = 0; i < rows; i++){
        for (let j = 0; j < cols; j++){
            if (matrix[i][j] === 0)
                queue.push([i, j]);
            else if (matrix[i][j] === 1)
                matrix[i][j] = 100;
        }
    }
    let directions = [[-1,0], [1,0], [0, 1], [0, -1]];
    while(queue.length !== 0){
        let size = queue.length;
        for (let i = 0; i < size; i++){
            let curr = queue.shift();
            for (let i = 0; i < directions.length; i++){
                let dir = directions[i];
                let x = curr[0] + dir[0];
                let y = curr[1] + dir[1];
                console.log(`${x}  ${y}`)
                if(x < 0 || x >= rows || y < 0 || y >= cols || matrix[x][y] <= matrix[curr[0]][curr[1]]) continue;
                console.log(`${x}  ${y}`)
                matrix[x][y] = matrix[curr[0]][curr[1]] + 1;
                queue.push([x,y]);
            }
        }
    }
    return matrix;
};

var dfs = function(grid, i, j){
    if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
        return;
    if (grid[i][j] !== '1') return;
    if (grid[i][j] == '1') grid[i][j] = '2';
    dfs(grid, i, j + 1);
    dfs(grid, i + 1, j);
    dfs(grid, i, j - 1);
    dfs(grid, i - 1, j);
}
var numIslands = function(grid) {
    let count = 0;
    for (let i = 0; i < grid.length; i++){
        for (let j = 0; j < grid[0].length; j++){
            if(grid[i][j] === '1'){
                dfs(grid, i, j);
                count++;
            }
        }
    }
    return count;
};


bulls and cows 
var getHint = function(secret, guess) {
    let bull = 0, cow = 0;
    let number = new Array(10);
    number.fill(0);
    for (let i = 0; i < secret.length; i++){
        let s = parseInt(secret[i]);
        let g = parseInt(guess[i]);
        if (s === g)
            bull++;
        else {
            if (number[s] < 0) cow++;
            if (number[g] > 0) cow++;
            number[s]++;
            number[g]--;
        }
    }
    return bull + "A" + cow + "B";
};


flatten binary tree to linked list
var flatten = function(root) {
    let stack = [];
    let curr = root;
    while(stack.length > 0 || curr != null){
        if (curr.right)
            stack.push(curr.right);
        if (curr.left){
            curr.right = curr.left;
            curr.left = null;
        }
        else if (stack.length > 0)
            curr.right = stack.pop();
        curr = curr.right;
    }
};


group anagrams

var groupAnagrams = function(strs) {
    let res = [];
    let map = new Map();
    for (let word of strs){
        let sortedKey = word.split('').sort().join('');
        if (!map.has(sortedKey))
            map.set(sortedKey, []);
        map.get(sortedKey).push(word);
    }
    
    map.forEach((value, key, map) => {
        res.push(value);
    })
    return res;
};


lowest common ancestor 
var lowestCommonAncestor = function(root, p, q) {
    if (!root || root === q || root === p)
        return root;
    let left = lowestCommonAncestor(root.left, p, q);
    let right = lowestCommonAncestor(root.right, p, q);
    if(!left && !right) return null;
    if (left && right) return root;
    return (left)? left: right;
};

next permutation 
const swap = (A, i, j) => {
    let t = A[i];
    A[i] = A[j];
    A[j] = t;
}
const reverse = (A, left, right) => {
    while(left < right){
        swap(A, left, right);
        left++;
        right--;
    }
}
var nextPermutation = function(A) {
    if (!A || A.length < 2) return;
    let N = A.length;
    let i = N - 2;
    while( i >= 0 && A[i] >= A[i + 1])
        i--;
    if (i >= 0){
        let j = N - 1;
        while(A[j] <= A[i])
            j--;
        swap(A, i, j);
    }
    reverse(A, i + 1, N - 1);
};


add two numbers
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

var addTwoNumbers = function(l1, l2) {
     if (!l1) return l2;
     if (!l2) return l1;
      
    let carry = 0, sum = 0, val1 = 0, val2 = 0;
    let headA = l1, headB = l2, curr = null, head = null;
    
    while(headA != null || headB != null){
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
        carry = Math.floor((val1 + val2 + carry) / 10);
        if (!head){
            head = new ListNode(sum);
            curr = head;
        }
        else {
            curr.next = new ListNode(sum);
            curr = curr.next;
        }
    }
    if (carry > 0) curr.next = new ListNode(carry);
    return head;
};

validate BST
var isValidBST = function(root) {
    if (!root) return true;
    let stack = [];
    let prev = null, curr = null;
    while(root || stack.length){
        while(root){
          stack.push(root);
          root = root.left;
        }
        root = stack.pop();
        if (prev && prev.val >= root.val)
            return false;
        prev = root;
        root = root.right;
    }
    return true;
};


rotate list
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.


var rotateRight = function(head, k) {
    if (!head || !head.next || k === 0) return head;
    let len = 1;
    let fast = head;
    while(fast.next){
        len++;
        fast = fast.next;
    }
    fast.next = head;
    if (k > len)
        k = k % len;
    for (let i = 0; i < len - k ; i++)
        fast = fast.next;
    head = fast.next;
    fast.next = null;
    return head;
};


return k smallest pairs from two array 
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
var kSmallestPairs = function(nums1, nums2, k) {
    let res = [];
    if(!nums1.length || !nums2.length) return res;
    for (let i = 0; i < nums1.length; i++){
        for (let j = 0; j < nums2.length; j++){
            res.push([nums1[i], nums2[j]]);
        }
    }
    res.sort((a, b) => (a[0] + a[1]) - (b[0] + b[1]));
    return res.slice(0, k);
};

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].


/**
 * @param {Interval[]} intervals
 * @return {Interval[]}
 */
var merge = function(intervals) {
    let res = [];
    if (!intervals.length)
        return res;
    intervals.sort((a, b) => a.start - b.start);
    
    let start = intervals[0].start;
    let end = intervals[0].end;
    
    for (let interval of intervals){
        if (interval.start <= end)
            end = Math.max(end, interval.end);
        else {
            res.push(new Interval(start, end));
            start = interval.start;
            end = interval.end;
        }
    }
    res.push(new Interval(start, end));
    return res;
};


https://leetcode.com/problems/word-break/description/
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
var wordBreak = function(s, wordDict) {
    let breakable = new Array(s.length + 1);
    breakable.fill(false);
    breakable[0] = true;
    for (let i = 1; i <= s.length; i++){
        for (let j = 0; j < i; j++){
            if (breakable[j] && wordDict.includes(s.substring(j, i))){
                breakable[i] = true;
                break;
            }
        }
    }
    return breakable[s.length];
};
https://leetcode.com/problems/mini-parser/description/
https://leetcode.com/problems/reverse-linked-list-ii/description/
var reverseBetween = function(head, m, n) {
    if(!head || !head.next) return head;
    let dummy = new ListNode(0);
    dummy.next = head;
    let pre = dummy;
    for (let i = 1; i < m; i++)
        pre = pre.next;
    
    let start = pre.next;
    let temp = start.next;
    
    for (let i = 0; i < n - m; i++){
        start.next = temp.next;
        temp.next = pre.next;
        pre.next = temp;
        temp = start.next;
    }
    return dummy.next;
};

https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
var deleteDuplicates = function(head) {
    if (!head || !head.next) return head;
    let dummy = new ListNode(0);
    dummy.next = head;
    let p = dummy, curr = head;
    while( curr && curr.next ){
        if (curr.val === curr.next.val){
            while(curr.next && curr.next.val == curr.val)
                curr = curr.next;
            curr = curr.next;
            p.next = curr;
        }
        else {
            p = p.next;
            curr = curr.next;
        }
    }
    return dummy.next;
};

https://leetcode.com/problems/clone-graph/description/
var dfs = function(map, graph){
    if (graph === null) return;
    
    for (let neighbor of graph.neighbors){
        if(!map.has(neighbor.label)){
            map.set(neighbor.label, new UndirectedGraphNode(neighbor.label));
            dfs(map, neighbor);
        }
        map.get(graph.label).neighbors.push(map.get(neighbor.label));
    }
}
var cloneGraph = function(graph) {
  if (!graph) return null;
    let map = new Map();
    map.set(graph.label, new UndirectedGraphNode(graph.label));
    dfs(map, graph);
    return map.get(graph.label);
};

snake game  
    https://discuss.leetcode.com/topic/87242/java-solution-o-n-for-every-move-since-using-queue-to-check-body-position
    https://photos.google.com/photo/AF1QipOF3hTOulKeA-Qy-v155JQCKZlkcBIacouBYiz2'

https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
    memorize 
https://leetcode.com/problems/implement-trie-prefix-tree
class TrieNode{
    constructor(){
        this.map = new Map();
        this.endOfWord = false;
    }
}
var Trie = function() {
    
    this.root = new TrieNode();
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    let curr = this.root;
    for (let c of word){
        let node = curr.map.get(c);
        if (!node){
            node = new TrieNode();
            curr.map.set(c, node);
        }
        curr = node;
    }
    curr.endOfWord = true;
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    let curr = this.root;
    for (let c of word){
        let node = curr.map.get(c);
        if (!node){
            return false;
        }
        curr = node;
    }
    return curr.endOfWord;
};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    let curr = this.root;
    for (let c of prefix){
        if (!curr.map.has(c))
            return false;
        curr = curr.map.get(c);
    }
    return true;
};


https://leetcode.com/problems/gas-station/description/
var canCompleteCircuit = function(gas, cost) {
    if (!gas || !cost || gas.length !== cost.length)
        return -1;
    let total = 0, sum = 0, start = 0;
    for (let i = 0; i < gas.length; i++){
        total += gas[i] - cost[i];
        sum += gas[i] - cost[i];
        if (sum < 0){
            sum = 0;
            start = i + 1;
        }
    }
    return total < 0 ? -1: start;
};

https://leetcode.com/problems/kth-largest-element-in-an-array/description/
This is an optimization over method 1 if QuickSort is used as a sorting algorithm in first step. In QuickSort, we pick a pivot element, then move the pivot element to its correct position and partition the array around it. The idea is, not to do complete quicksort, but stop at the point where pivot itself is k’th smallest element. Also, not to recur for both left and right sides of pivot, but recur for one of them according to the position of pivot. The worst case time complexity of this method is O(n2), but it works in O(n) on average.
var partition = function(nums, low, high){
    let i = low + 1, j = high, pivotElement = nums[low];
    while(true){
        while(nums[i] < pivotElement){
            i++;
            if (i >= high) break;
        }
        while(nums[j] >= pivotElement){
            j--;
            if (j <= low) break;
        }
        if (i >= j) break;
        if (i < j){
            let t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
    let t2 = nums[j];
    nums[j] = nums[low];
    nums[low] = t2;
    return j;
}
var helper = function(nums, low, high, k){
    if (low >= high) return nums[low];
    let pivotIndex = partition(nums, low, high);
    if (pivotIndex === k) return nums[k];
    if (pivotIndex < k) return helper(nums, pivotIndex + 1, high, k);
    else return helper(nums, low, pivotIndex - 1, k);
}
var findKthLargest = function(nums, k) {
    if(!nums.length) return 0;
    return helper(nums, 0, nums.length - 1, nums.length - k);
};
https://leetcode.com/problems/surrounded-regions
var bfs = function(board, i, j) {
    let rows = board.length, cols = board[0].length;
        if (i < 0 || j < 0 ||
            i >= rows || j >= cols
            || board[i][j] != 'O')
            return;
            
        board[i][j] = 'U';
        
        if (i + 1 < rows)
            bfs(board, i + 1, j);
        if (i - 1 > 0)
            bfs(board, i - 1, j);
        if (j + 1 < cols)
            bfs(board, i, j + 1);
        if (j - 1> 0)
            bfs(board, i, j - 1);
}

var solve = function(board) {
    if (board.length === 0) return;
    let rows = board.length, cols = board[0].length;
    for (let i = 0; i < rows; i++){
        for (let j = 0; j < cols; j++){
            if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1){
                if (board[i][j] == 'O')
                    bfs(board, i,j);
            }
        }
    }
    
     for (let i = 0; i < rows; i++){
          for (let j = 0; j < cols; j++){
              if (board[i][j] == 'O')
                board[i][j] = 'X';
              else if (board[i][j] == 'U')
                board[i][j] = 'O';
          }
      }
};
https://leetcode.com/problems/recover-binary-search-tree
var recoverTree = function(root) {
    
    if(!root) return;
    let stack = [];
    let prev = null, firstSwap = null, lastSwap = null;
    while(root || stack.length){
        while(root){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        if (prev && prev.val > root.val){
            if (!firstSwap)
                firstSwap = prev;
            lastSwap = root;
        }
        prev = root;
        root = root.right;
    }
    let t = firstSwap.val;
    firstSwap.val = lastSwap.val;
    lastSwap.val = t;
};

https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
var connect = function(root) {
    let dummy = new TreeNode(0);
    let pre = dummy;
    while(root){
        if (root.left){
            pre.next = root.left;
            pre = pre.next;
        }
        if (root.right){
            pre.next = root.right;
            pre = pre.next;
        }
        root = root.next;
        if (root === null){
            pre = dummy;
            root = dummy.next;
            dummy.next = null;
        }
    }
};

https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
var largestValues = function(root) {
    let res = [];
    if(!root) return res;
    let q = [root];
    while(q.length){
        
        let size = q.length;
        let max = q[0].val;
        for (let i = 0; i < size; i++){
            let v = q.shift();
            if (v.left)q.push(v.left);
            if (v.right)q.push(v.right);
            max = Math.max(max, v.val);
        }
        res.push(max);
    }
    return res;
};
https://leetcode.com/problems/merge-two-binary-trees/description/
 if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;

https://leetcode.com/problems/binary-tree-tilt/description/

https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
var findSecondMinimumValue = function(curr) {
    let firstMin  = Number.MAX_VALUE;
        let stack = [];
        let root = curr;
        while(root || stack.length){
            while(root){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            firstMin = Math.min(firstMin, root.val);
            root = root.right;
        }
        let stack2 = [];
        root = curr;
        //console.log(firstMin)
        
        let res = Number.MAX_VALUE;
        while(root || stack2.length){
            while(root){
                stack2.push(root);
                root = root.left;
            }
            root = stack2.pop();
            if (root.val > firstMin)
                res = Math.min(res, root.val);
            root = root.right;
        }
        return res === firstMin || res == Number.MAX_VALUE? -1: res;
};
https://leetcode.com/problems/subtree-of-another-tree/description/
memorize
 public boolean isSubtree(TreeNode s, TreeNode t){
        if (s == null || t == null) return s == t;
        return s.val == t.val && helper(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean helper(TreeNode t, TreeNode t2){
        if (t == null || t2 == null) return t == t2;
        return t.val == t2.val && helper(t.left, t2.left) && helper(t.right, t2.right);
    }

coin change
var coinChange = function(coins, amount) {
    if(!coins || coins.length === 0) return 0;
    let dp = new Array(amount + 1);
    dp.fill(Number.MAX_VALUE);
    dp[0] = 0;
    for (let j = 0; j < coins.length; j++){
        for (let i = coins[j]; i < dp.length; i++){
            dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
        }
    }
    return dp[amount] === Number.MAX_VALUE? -1: dp[amount];
};

hose robber 3
var postOrder = function(root){
    let temp = [0, 0];
    if (!root) return temp;
    let left = postOrder(root.left);
    let right = postOrder(root.right);
    
    temp[0] = root.val + left[1] + right[1];
    temp[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    return temp;
};

var rob = function(root) {
    if(!root) return 0;
    let res = postOrder(root);
    return Math.max(res[0], res[1]);
};

remove invalid parenthesis 
var isValid = function( s){
        let count = 0;
        for (let i = 0; i < s.length; i++){
            let c = s.charAt(i);
            if (c == '(')count++;
            if (c == ')' && count-- == 0) return false;
        }
        return count == 0;
}
var removeInvalidParentheses = function(s) {
    let res = [];
    if(!s || !s.length) return [""];
    let q = [];
    q.push(s);
    let visited = new Set();
    visited.add(s);
    let found = false;
    
    while(q.length){
        let f = q.shift();
        if (isValid(f)){
            found = true;
            res.push(f);
        }
        if (found) continue;
        for (let i = 0; i < s.length; i++){
            if(f[i] != '(' && f[i] != ')') continue;
            let sub = f.substring(0, i) + f.substring(i + 1);
            if(!visited.has(sub)){
                visited.add(sub);
                q.push(sub);
            }
        }
    }
    return res;
};

construct tree from preorder and inorder
https://photos.google.com/photo/AF1QipOJyfOHaHHnPKdqTpJNGXju6uVFGkwclcqDzPuS
let map = new Map();
let pIndex = 0;
var helper = function(preorder, s, e){
    if (s > e) return null;
    let i = map.get(preorder[pIndex]);
    let node = new TreeNode(preorder[pIndex]);
    pIndex++;
    node.left = helper(preorder, s, i - 1);
    node.right = helper(preorder, i + 1, e);
    return node;
};


var buildTree = function(preorder, inorder) {
    for (let i = 0; i < inorder.length; i++)
        map.set(inorder[i], i);
    return helper(preorder, 0, inorder.length - 1);
};


postorder and inorder memorize
https://photos.google.com/photo/AF1QipMECarFGInyYqk66ZjX-rTara-wifeNCLMfvpKG

max product subarray
https://photos.google.com/photo/AF1QipOMFqu8iPYWR1Ip38L4kEfL9H4tz4_Xf54hia2A
var maxProduct = function(nums) {
    let max = nums[0], min = nums[0], res = nums[0];
    for (let i = 1; i < nums.length; i++){
        let tempMax = nums[i] * max;
        let tempMin = nums[i] * min;
        max = Math.max(nums[i], Math.max(tempMax, tempMin));
        min = Math.min(nums[i], Math.min(tempMax, tempMin));
        res = Math.max(max, res);
    }
    return res;
};


most frequent subtree sum
https://photos.google.com/photo/AF1QipP2Qibc6wdV7vOq_kNW1wNGG0mUeAbpjrXOCuzj
let max = 0;
var add = function(root, sumCount){
    if (!root) return 0;
    let left = add (root.left, sumCount);
    let right = add(root.right, sumCount);
    let sum = root.val + left + right;
    
    if (!sumCount.has(sum))
        sumCount.set(sum, 0);
    sumCount.set(sum, sumCount.get(sum) + 1);
    max = Math.max(max, sumCount.get(sum));
    return sum;
}
var findFrequentTreeSum = function(root) {
    let sumCount = new Map();
    add(root, sumCount);
    let res = [];
    sumCount.forEach((v, k, sumCount) => {
        if (v == max)
        res.push(k);
    })
    return res;
};



https://leetcode.com/problems/find-right-interval/description/
https://leetcode.com/problems/unique-binary-search-trees/description/

interval problems
course schedule
https://leetcode.com/problems/subarray-sum-equals-k/description/
memorize 
var subarraySum = function(nums, k) {
    let map = new Map();
    map.set(0, 1);
    let sum = 0, res = 0;
    for (let i in nums){
        sum += nums[i];
        if (map.has(sum - k))
            res += map.get(sum - k);
        if(!map.has(sum))
            map.set(sum, 0);
        map.set(sum, map.get(sum) + 1);
    }
    return res;
};

https://leetcode.com/problems/diameter-of-binary-tree/description/
https://leetcode.com/problems/add-one-row-to-tree/description/
memorize: 

var addOneRow = function(root, v, d) {
    if (d === 1){
        let newRoot = new TreeNode(v);
        newRoot.left = root;
        return newRoot;
    }
    let q = [];
    q.push(root);
    for (let row = 1; row < d - 1; row++){
        let size = q.length;
        for (let j = 0; j < size; j++){
            let n = q.shift();
            if(n.left)q.push(n.left);
            if(n.right)q.push(n.right);
        }
    }
    while(q.length){
        let n = q.shift();
        let right = n.right;
        let left = n.left;
        let newLeft = new TreeNode(v);
        let newRight = new TreeNode(v);
        n.left = newLeft;
        n.right = newRight;
        newRight.right = right;
        newLeft.left = left;
    }
    return root;
};


https://leetcode.com/problems/excel-sheet-column-number/description/
var titleToNumber = function(s) {
    let res = 0;
    let N = s.length;
    if (!s || !N) return res;
    let x = 0;
    for (let i = N - 1; i >= 0; i--){
        let c = s[i];
        res += (Math.pow(26, x) * (c.charCodeAt() - 'a'.charCodeAt() + 1));
        x++;
    }
    return res;
};


https://leetcode.com/problems/dungeon-game
https://leetcode.com/problems/copy-list-with-random-pointer
easy memorize

var copyRandomList = function(head) {
    if(!head) return head;
    let map = new Map();
    let curr = head;
    while(curr){
        map.set(curr, new RandomListNode(curr.label));
        curr = curr.next;
    }
    map.forEach((value, key, map) => {
        let copy = value;
        copy.next = map.get(key.next);
        copy.random = map.get(key.random);
    })
    return map.get(head);
};



https://leetcode.com/problems/reorder-list
https://leetcode.com/problems/add-and-search-word-data-structure-design
memorize: 
/**
 * Initialize your data structure here.
 */
var TrieNode = function(){
    this.map = new Map();
    this.endOfWord = false;
}
var WordDictionary = function() {
    this.root = new TrieNode();
};

/**
 * Adds a word into the data structure. 
 * @param {string} word
 * @return {void}
 */
WordDictionary.prototype.addWord = function(word) {
    let curr = this.root;
    for (let c of word){
        let n = curr.map.get(c);
        if (!n){
            n = new TrieNode();
            curr.map.set(c, n);
        }
        curr = n;
        
    }
    curr.endOfWord = true;
};

/**
 * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. 
 * @param {string} word
 * @return {boolean}
 */
var searchDFS = function(word, pos, root){
    if (pos === word.length)
        return root.endOfWord;
    let c = word[pos];
    
    root.map.forEach((v, k, root.map) =>  {
        let trieCh = k;
        let n = v;
        if (trieCh == c || c == '.'){
            if(searchDFS(word, pos + 1, n))
                return true;
        }
    })
    return false;
}

WordDictionary.prototype.search = function(word) {
    return searchDFS(word, 0, this.root);
};
https://leetcode.com/problems/reverse-nodes-in-k-group
https://leetcode.com/problems/design-search-autocomplete-system

all problems that begin with word: word break word pattern,, and so on
https://photos.google.com/photo/AF1QipNVVQgLPjQsgWXkGjl7L1rTORXn-Pt5UHODQLvz
https://photos.google.com/photo/AF1QipMLpI0IkZHHHF8d9UHli09QoyaojfQGX4847GlS
https://photos.google.com/photo/AF1QipMsebnRFESezwute43KP6r9FilThzOVCZutzcr_
https://photos.google.com/photo/AF1QipNmK_Dzt6PHDB6LZ_A-WcEJyRI71gsdqXTH29C6
https://photos.google.com/photo/AF1QipOuRoNahfKowAPQz7eTphk_Mwtrz2uR-gGkjODu
https://photos.google.com/photo/AF1QipNtAJj-1kGjVqAOmuRnmDcrOBIBNDmZXGUeLfgX
https://photos.google.com/photo/AF1QipN5fnNHbvmlbnVDDP8wZsVQDlUmBIQb7UvzC0yw


https://leetcode.com/problems/continuous-subarray-sum/description/
memorize: 
 for (int i = 0; i < nums.length; i++){
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++){
                sum += nums[j];
                if (sum == 0)
                    return true;
                if (k != 0 && ( sum >= k && sum % k == 0)) // k should not be 0 for mod
                    return true;
            }
        }
        return false;

https://leetcode.com/problems/russian-doll-envelopes/description/


https://leetcode.com/problems/insert-delete-getrandom-o1/description/

memorize: 
var RandomizedSet = function() {
    this.list = [];
    this.map = new Map();
};

/**
 * Inserts a value to the set. Returns true if the set did not already contain the specified element. 
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.insert = function(val) {
    if(this.map.has(val)) return false;
    this.map.set(val, this.list.length);
    this.list.push(val);
    return true;
};

/**
 * Removes a value from the set. Returns true if the set contained the specified element. 
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.remove = function(val) {
    if(!this.map.has(val)) return false;
    let index = this.map.get(val);
    this.map.delete(val);
    let lastEle = this.list[this.list.length - 1];
    this.list.splice(this.list.length - 1);
    this.list[index] = lastEle;
    this.map.set(lastEle, index);
    return true;
    
};

/**
 * Get a random element from the set.
 * @return {number}
 */
RandomizedSet.prototype.getRandom = function() {
    let index = Math.floor((Math.random() * this.list.length));
    return this.list[index];
};




https://leetcode.com/problems/delete-node-in-a-bst/description/
memorize java solution

https://leetcode.com/problems/palindrome-partitioning/description/
memorize java solution

https://leetcode.com/problems/house-robber-ii/description/
    https://discuss.leetcode.com/topic/81350/same-as-house-robber-i-but-2-more-if


https://leetcode.com/problems/implement-queue-using-stacks/description/
var MyQueue = function() {
    this.stack1 = [];
    this.stack2 = [];
};

/**
 * Push element x to the back of queue. 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    this.stack1.push(x);
};

/**
 * Removes the element from in front of queue and returns that element.
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    while(this.stack1.length)
        this.stack2.push(this.stack1.pop());
    let ret = this.stack2.pop();
    while(this.stack2.length)
        this.stack1.push(this.stack2.pop());
    return ret;
};

/**
 * Get the front element.
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    while(this.stack1.length)
        this.stack2.push(this.stack1.pop());
    let ret = this.stack2[this.stack2.length - 1];;
    while(this.stack2.length)
        this.stack1.push(this.stack2.pop());
    return ret;
};

/**
 * Returns whether the queue is empty.
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
   return !this.stack1.length && !this.stack2.length 
};


https://leetcode.com/problems/path-sum-iii/description/

scramble string memorize
    If you get this question, tell you have already seen it and just spit out the explanation
    https://photos.google.com/photo/AF1QipNuXoFVQUUfGuklL3A9um8Hr9-a5mJBHEQKF2HI

https://leetcode.com/problems/wiggle-sort-ii/description/
var wiggleSort = function(nums) {
    let copy = nums.slice();
    copy.sort((a, b) => a - b);
    let N = nums.length;
    let i = 1, j = N - 1;
    while(i < N){
        nums[i] = copy[j--];
        i += 2;
    }
    i = 0; 
    while(i < N){
        nums[i] = copy[j--];
        i += 2;
    }
};


https://leetcode.com/problems/powx-n/description/
var myPow = function(x, n) {
    if (n === 0) return 1;
    if (n === 1) return x;
    if (n < 0){
        n = -n;
        x = (1/x);
    }
    let half = myPow(x, Math.floor(n/2));
    return (n % 2)?half * half * x: half * half;
};


https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
var letterCombinations = function(digits) {
    let mapping = ["0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs","tuv", "wxyz"];
    let list = [];
    if (digits.length === 0) 
        return list;
    list.push("");
    for (let i = 0; i < digits.length; i++){
        let digit = parseInt(digits[i]);
        let size = list.length;
        for (let j = 0; j < size; j++){
            let f = list.shift();
            for (let c of mapping[digit])
                list.push(f + c);
        }
    }
    return list;
};

atoi in js
median of 2 sorted array in javas
jump game 2
lru cache 
text justification
pacific atlantic water flow
convert tree form other traversals
search in rotated sorted array
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii
memorize 
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
int firstBuy = Integer.MAX_VALUE;
       int afterFirstSell = 0;
       int afterSecondBuy = Integer.MIN_VALUE ;
       int afterSecondSell = 0;
       
       for (int currPrice: prices){
           firstBuy = Math.min(firstBuy, currPrice);
           
           afterFirstSell = Math.max(afterFirstSell, currPrice - firstBuy); // profit after first sell. we should maximize profit
           
           afterSecondBuy = Math.max(afterSecondBuy, afterFirstSell - currPrice); // profit after second buy. we should maximize profit
           
           afterSecondSell = Math.max(afterSecondSell, afterSecondBuy + currPrice); // profit after second sell. we should maximize profit
       }
       return afterSecondSell;
       
       
       
       /*
       First assume that we have no money, so firstBuy means that we have to borrow money from others, we want to borrow less so that we have to make our balance as max as we can(because this is negative).

        sell1 means we decide to sell the stock, after selling it we have price[i] money and we have to give back the money we owed, so we have price[i] - |buy1| = prices[i ] + buy1, we want to make this max.
        
        buy2 means we want to buy another stock, we already have sell1 money, so after buying stock2 we have buy2 = sell1 - price[i] money left, we want more money left, so we make it max
        
        sell2 means we want to sell stock2, we can have price[i] money after selling it, and we have buy2 money left before, so sell2 = buy2 + prices[i], we make this max.
        
        So sell2 is the most money we can have.
        */

    

https://leetcode.com/problems/continuous-subarray-sum/description/
for (int i = 0; i < nums.length; i++){
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++){
                sum += nums[j];
                if (sum == 0)
                    return true;
                if (k != 0 && ( sum >= k && sum % k == 0)) // k should not be 0 for mod
                    return true;
            }
        }
        return false;

https://leetcode.com/problems/add-and-search-word-data-structure-design/description/

https://leetcode.com/problems/single-number-ii/description/
int ones = 0;
	for (int i = 0; i < countSetBit.length; i++)
		countSetBit[i] %= 3;
	
	
	// ones has the decimal representation of the number that occurs once.
	for (int i =  countSetBit.length - 1; i >= 0; i--)
		ones = ones + ((int)Math.pow(2, i) * countSetBit[i]);
	
	//return (ones < 0)? ones + 1:ones;
	if (ones == Integer.MAX_VALUE)
	    return ones;
	if (ones < 0 )
	    return ones + 1;
	 return ones ;


https://leetcode.com/problems/find-median-from-data-stream/description/ in java


https://leetcode.com/problems/maximum-gap/description/
int max = 0;
        if (nums.length < 2 || nums == null) return 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            max = Math.max(max, nums[i + 1] - nums[i]);
        }
        return max;

https://leetcode.com/problems/sliding-window-median/description/ java 


https://leetcode.com/problems/frog-jump/description/

https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/

https://leetcode.com/problems/word-ladder-ii/description/
    find the solution in your video tutorial

https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/


https://leetcode.com/problems/integer-to-english-words/description/


let oneToNine = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"];
let TenToNineteen = ["Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"];
let Tens[] = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"];

var convert = function(num){
    let result = "";
    if (num < 10)
        result = oneToNine[num];
    else if (num < 20)
        result = TenToNineTeen[num - 10];
    else if (num < 100)
        result = Tens[num/10] + " " + oneToNine[num % 10];
    else if (num < 1000)
        result = oneToNine[num / 100] + " Hundred " + convert(num % 100);
    else if (num < 1000000)
        result = convert(num / 1000) + " Thousand " + convert(num % 1000);
    else if (num < 1000000000)
        result = convert(num / 1000000) + " MIllion " + convert(num % 1000000);
    return result.trim();
}
var numberToWords = function(num){
    if (num == 0) return "Zero";
    return convert(num);
}

https://leetcode.com/problems/longest-valid-parentheses/description/
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
                count = 0;
        }
        return longest * 2;

    }
https://leetcode.com/problems/decode-ways-ii/description
/
https://leetcode.com/problems/word-break-ii/description/

https://leetcode.com/problems/minimum-window-substring/description/
    https://discuss.leetcode.com/topic/45432/simple-javascript-solution-with-comments
    https://photos.google.com/photo/AF1QipOkfGUW6CHlfZWsx5sk7OygiGcaz8_jTi46SSkD

https://leetcode.com/problems/tag-validator/description/
https://leetcode.com/problems/max-points-on-a-line/description/
https://leetcode.com/problems/word-ladder/description/
https://leetcode.com/problems/contains-duplicate-iii/description/
https://leetcode.com/problems/decode-ways/description/
https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
        int i = 0;
        for (int num: nums){
            if (i < 2 || nums[i] > nums[i - 2])
                nums[i++] = num;
        }
        return i;

https://leetcode.com/problems/total-hamming-distance/description/
https://leetcode.com/problems/different-ways-to-add-parentheses/description/\
https://leetcode.com/problems/non-decreasing-array/description/
https://leetcode.com/problems/maximum-average-subarray-i/description/
  let max = -Infinity;
    for (let i = 0, sum = 0; i < nums.length; i++) {
        sum += nums[i] - (nums[i - k] || 0);
        if (i >= k - 1) max = Math.max(max, sum);
    }
    return max / k;

https://leetcode.com/problems/contiguous-array/description/

var findMaxLength = function(nums) {
    for (let i = 0; i < nums.length; i++){
        if (nums[i] == 0)
            nums[i] = -1;
    }
    let sumIndex = new Map();
    sumIndex.set(0, -1);
    let sum = 0, maxLen = 0;
    for (let i = 0; i < nums.length; i++){
        sum += nums[i];
        if (sumIndex.has(sum))
            maxLen = Math.max(maxLen, i  - sumIndex.get(sum));
        else
            sumIndex.set(sum, i);
    }
    return maxLen;
};


https://leetcode.com/problems/longest-increasing-subsequence/description/
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
https://leetcode.com/problems/find-k-closest-elements/description/
https://leetcode.com/problems/matchsticks-to-square
https://leetcode.com/problems/interleaving-string
    // memorize
    //https://photos.google.com/photo/AF1QipMwTligcVm8W5JTmWkdlB4tYOcxSxFNr31mkC8J

https://leetcode.com/problems/interleaving-string
https://leetcode.com/problems/lfu-cache
histogram
largest rectangel
https://leetcode.com/problems/elimination-game/description/
https://discuss.leetcode.com/topic/83371/javascript-easy-recursion-o-logn-solution


https://leetcode.com/problems/longest-repeating-character-replacement/description/

https://leetcode.com/problems/longest-palindromic-subsequence/description/
watch this first: https://www.youtube.com/results?search_query=longest+common+subsequence tushars
var longestPalindromeSubseq = function(s) {
    let N = s.length;
    if (N < 2) return N;
    let dp = [];
    for (let i = 0; i <= N; i++){
        let row = new Array(N + 1);
        row.fill(0);
        dp.push(row);
    }
    let revers = s.split("").reverse().join("");
    for (let i = 1; i <= N; i++){
        for (let j = 1; j <= N; j++){
            if (s[i - 1] === revers[j - 1])
                dp[i][j] = dp[i - 1][j - 1] + 1;
            else
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
    }
    return dp[N][N];
};

https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
var findLongestWord = function(s, d) {
    let longest = "";
    for (let dict of d){
        let len = 0;
        for (let c of s){
            if (len < dict.length && c == dict[len])len++;
        }
        if (len == dict.length && dict.length >= longest.length){
            if (dict.length > longest.length || dict.localeCompare(longest) < 0)
                longest = dict;
        }
    }
    return longest;
};

https://leetcode.com/problems/target-sum/description/
https://leetcode.com/problems/shopping-offers/description/
https://leetcode.com/problems/find-the-duplicate-number/description/
      for (int num: nums){
            int val = Math.abs(num);
            if (nums[val] < 0) return val;
            nums[val] = -nums[val];
        }
        return nums[nums.length - 1];


https://leetcode.com/problems/longest-increasing-subsequence/description/
watch youtube video and sovle it



https://leetcode.com/problems/increasing-subsequences/description/
https://leetcode.com/problems/partition-equal-subset-sum/description/
 int N = nums.length;
        if (N == 0)
            return false;
        int sum =  0;
        for (int n: nums)
            sum += n;
        if (sum % 2 != 0)
            return false; // if total sum is not even we cannot partition into two equal halfs
        sum /= 2;
        
        boolean[] sums = new boolean[sum + 1];
        sums[0] = true;
        for (int n: nums){
            for (int i = sum; i >= n; i--)
                sums[i] |= sums[i - n];
        }
        return sums[sum];


https://leetcode.com/problems/valid-square/description/
var updateDistance = (a, b, distMap) => {
    let dist = ((a[0]-b[0]) * (a[0]-b[0])) + ((a[1] - b[1]) * (a[1]-b[1]));
    if(!distMap.has(dist))
        distMap.set(dist, 0);
    distMap.set(dist, distMap.get(dist) + 1);
}

var validSquare = function(p1, p2, p3, p4) {
    let distMap = new Map();
    updateDistance(p1, p2, distMap);
    updateDistance(p1, p3, distMap);
    updateDistance(p1, p4, distMap);
    updateDistance(p2, p3, distMap);
    updateDistance(p2, p4, distMap);
    updateDistance(p3, p4, distMap);
    
    if (distMap.size != 2) return false;
    distMap.forEach((value, key, distMap) => {
        if (value == 2 || value == 4) 
            return true;
        else
            return false;
    })
    return true;
};


https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
watch youtube video
 int low = 0, high = nums.length - 1;
       while(low < high){
            int mid = (low + high)/2;
            if (nums[mid] > nums[high])
                low = mid + 1;
            else if (nums[mid] < nums[high])
                high = mid; // if you set mid - 1 it will faile for [3, 1, 3]
            else
                high--;// if they are equal then shift high to left
        }
        return nums[low];


https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
watch youtube video and memorize
if (nums == null || nums.length == 0) return false;
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target) return true;
            
            if (nums[start] < nums[mid]){
                if (nums[start] <= target && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else if (nums[start] > nums[mid]){
                if (nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else 
                    end = mid - 1;
            }
            else //[1, 3, 1, 1, 1]//3
                start++;
        }
        return false;

https://leetcode.com/problems/rectangle-area/description/
refer notes
int areaOfSquareA = (C - A) * (D - B);
        int areaOfSquareB = (G - E) * (H - F);
        
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);
        
        int overlap = 0;
        if (right > left && top > bottom)
            overlap = (right - left) * (top - bottom);
        return areaOfSquareA + areaOfSquareB - overlap;


https://leetcode.com/problems/palindrome-partitioning/description/

https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 if (nums.length < 2) return nums.length;
        int count = 1, curr = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (curr != nums[i]){
                nums[count++] = nums[i];
                curr = nums[i];
            }
        }
        return count;


https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
int plen = p.length();
        int slen = s.length();
        for (int i = 0; i < slen - plen + 1; i++){
            if (isAnagram(s.substring(i, i + plen), p))
                res.add(i);
        }
        return res;

        
https://leetcode.com/problems/sum-of-square-numbers/description/
var judgeSquareSum = function(c) {
    for(var i=Math.floor(Math.sqrt(c));i>=0;i--){
        if(Number.isInteger(Math.sqrt(c-i*i)))
            return true        
    }
    return false
};

https://leetcode.com/problems/range-sum-query-immutable/description/
var NumArray = function(nums) {
    this.dp = nums.slice();
    for (let i = 1; i < this.dp.length; i++)
        this.dp[i] = this.dp[i - 1] + nums[i];
};

/** 
 * @param {number} i 
 * @param {number} j
 * @return {number}
 */
NumArray.prototype.sumRange = function(i, j) {
    return i === 0? this.dp[j]: this.dp[j] - this.dp[i - 1];
};

https://leetcode.com/problems/can-place-flowers/description/
 int placed = 0, i = 0, N = flowerbed.length;
        while(i < N && placed < n){
            if (flowerbed[i] == 0){
                int next = (i == N - 1)?0:flowerbed[i + 1];
                int prev = (i == 0)?0:flowerbed[i - 1];
                if (next == 0 && prev == 0){
                    flowerbed[i] = 1;
                    placed++;
                }
            }
            i++;
        }
        return placed >= n;

https://leetcode.com/problems/min-stack/description/
var MinStack = function() {
    this.mainStack = [];
    this.minStack = [];
};

/** 
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
  if (this.minStack.length == 0 || this.minStack[this.minStack.length - 1] > x)
      this.minStack.push(x);
  this.mainStack.push(x);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    let top = this.mainStack.pop();
    if (top == this.minStack[this.minStack.length - 1])
        this.minStack.pop();
    //return top;
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.mainStack[this.mainStack.length - 1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
     return this.minStack[this.minStack.length - 1];
};


https://leetcode.com/problems/plus-one/description/
var plusOne = function(digits) {
    let sum = [];
    let carry = 1;
    for (let i = digits.length - 1; i >= 0; i--){
        let val = digits[i] + carry;
        sum.unshift(val % 10);
        carry = Math.floor(val / 10);
    }
    if (carry > 0) sum.unshift(carry);
    return sum;
};


https://leetcode.com/problems/valid-perfect-square/description/
 int i = 1;
        while(num > 0){
            num -= i;
            i += 2;
        }
        return num == 0;
        
https://leetcode.com/problems/repeated-substring-pattern/description/

https://leetcode.com/problems/reverse-string-ii/description/
https://leetcode.com/problems/set-mismatch/description/
https://discuss.leetcode.com/topic/97505/javascript-o-n-time-and-o-1-space-using-swaps
https://leetcode.com/problems/count-primes/description/
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


https://leetcode.com/problems/rotate-array/description/
        k = k % N
        reverse(arr, 0, N - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, N - 1);

https://leetcode.com/problems/single-element-in-a-sorted-array/description/
    memorize
     int l = 0, h = nums.length - 1;
        while(l < h){
            int mid = l + (h - l)/2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            if (nums[mid] == nums[mid + 1] && mid % 2 == 0)
                l = mid + 1;
            else if (nums[mid] == nums[mid - 1] && mid % 2 == 1)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return nums[l];


https://leetcode.com/problems/bulb-switcher-ii/description/
https://leetcode.com/problems/integer-break/description/
https://leetcode.com/problems/diagonal-traverse/description/
memorize


https://leetcode.com/problems/minimum-time-difference/description/
https://leetcode.com/problems/predict-the-winner/description/

https://leetcode.com/problems/delete-operation-for-two-strings/description/
https://discuss.leetcode.com/topic/78273/js-solution-using-min-heap
https://leetcode.com/problems/next-greater-element-ii/description/
memorize 
int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--)
            st.push(i);
        for (int i = n - 1; i >= 0; i--){
            res[i] = -1;
            while(!st.isEmpty() && nums[st.peek()] <= nums[i])
                st.pop();
            if(!st.isEmpty())
                res[i] = nums[st.peek()];
            st.push(i);
        }
        return res;
    }
    
    // undrestand using [3, 5, 2, 6, 4]

https://leetcode.com/problems/total-hamming-distance/description/
https://leetcode.com/problems/sqrtx/description/
memorize
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

https://leetcode.com/problems/palindromic-substrings/description/
https://leetcode.com/problems/subarray-sum-equals-k/description/
var subarraySum = function(nums, k) {
    let map = new Map();
    map.set(0, 1);
    let sum = 0, res = 0;
    for (let i in nums){
        sum += nums[i];
        if (map.has(sum - k))
            res += map.get(sum - k);
        if(!map.has(sum))
            map.set(sum, 0);
        map.set(sum, map.get(sum) + 1);
    }
    return res;
};


https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

        // explanation here: https://discuss.leetcode.com/topic/32836/o-n-java-solution-3ms/2
        // alternate solution: https://discuss.leetcode.com/topic/75005/share-my-java-accepted-dp-solution
        if (prices.length < 2) return 0;
        int afterBuy = -prices[0];//amount left after buy
        int sell = 0;
        int cooldown = 0;
        for (int i = 1; i < prices.length; i++){
            int amountAfterPrevBuy = afterBuy;
            afterBuy = Math.max(afterBuy, cooldown - prices[i]); // if we want to buy today, then i-1th day should be cooldown. if cooldown[i-1] -prices[i] < buy, we dont buy.
            cooldown = Math.max(sell, cooldown); // if we want to cooldown, prev day must be cooldown, or prev day must be sell. we choose maximum value
            sell = Math.max(sell, amountAfterPrevBuy + prices[i]); // if we want to sell, previous day is buy. so we must maximize the amount we get after selling today. we can choose to sell or not sell
        }
        return Math.max(sell, cooldown);
    }
}
// at every day, we have 3 choices, buy, sell or cooldown.
// if we decie to buy, then we have to maximize the amount left after buy
//if we decide to sell, then we have to maximize amount after the sale


https://leetcode.com/problems/valid-triangle-number/description/


https://leetcode.com/problems/subsets/description/
https://leetcode.com/problems/course-schedule/description/
https://leetcode.com/problems/different-ways-to-add-parentheses/description/
calculator
https://leetcode.com/problems/water-and-jug-problem/description/
https://leetcode.com/problems/gas-station/description/
design twitter
reconstruct itinerary learn java code
lfu java
skyline memorize java code
https://photos.google.com/photo/AF1QipNTCpFBY60yqb_WPk6rlr-CioKKTkpz-W62ktWq

https://leetcode.com/problems/word-break/description/
https://leetcode.com/problems/design-search-autocomplete-system
https://discuss.leetcode.com/topic/69456/top-5-email-recipients/6
merge interval
fibonacii dp explanation
detect cycle
https://photos.google.com/photo/AF1QipM4ujeEq0PwoV5iOKL_jfB4JYYb7D1UbO4o8rtb

all o one no js code