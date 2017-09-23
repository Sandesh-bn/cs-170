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

// return kth largest element in matrixreturn matrix.reduce((arr, row) => arr.concat(row), []).sort((a,b) => a-b)[k - 1]


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


https://leetcode.com/problems/single-number-ii/description/
https://leetcode.com/problems/elimination-game/description/
https://leetcode.com/problems/longest-repeating-character-replacement/description/
https://leetcode.com/problems/longest-palindromic-subsequence/description/
https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
https://leetcode.com/problems/target-sum/description/
https://leetcode.com/problems/shopping-offers/description/
https://leetcode.com/problems/find-the-duplicate-number/description/
https://leetcode.com/problems/longest-increasing-subsequence/description/
https://leetcode.com/problems/increasing-subsequences/description/
https://leetcode.com/problems/partition-equal-subset-sum/description/
https://leetcode.com/problems/insert-delete-getrandom-o1/description/
https://leetcode.com/problems/kth-largest-element-in-an-array/description/
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
https://leetcode.com/problems/sum-of-square-numbers/description/
https://leetcode.com/problems/range-sum-query-immutable/description/
https://leetcode.com/problems/can-place-flowers/description/
https://leetcode.com/problems/min-stack/description/
https://leetcode.com/problems/plus-one/description/
https://leetcode.com/problems/valid-perfect-square/description/
https://leetcode.com/problems/repeated-substring-pattern/description/
https://leetcode.com/problems/number-of-boomerangs/description/
https://leetcode.com/problems/reverse-string-ii/description/
https://leetcode.com/problems/set-mismatch/description/
https://discuss.leetcode.com/topic/97505/javascript-o-n-time-and-o-1-space-using-swaps
https://leetcode.com/problems/count-primes/description/
https://leetcode.com/problems/rotate-array/description/
https://leetcode.com/problems/single-element-in-a-sorted-array/description/
https://leetcode.com/problems/excel-sheet-column-number/description/
https://leetcode.com/problems/bulb-switcher-ii/description/
https://leetcode.com/problems/integer-break/description/
https://leetcode.com/problems/diagonal-traverse/description/
https://leetcode.com/problems/minimum-time-difference/description/
https://leetcode.com/problems/predict-the-winner/description/
https://leetcode.com/problems/different-ways-to-add-parentheses/description/
https://leetcode.com/problems/delete-operation-for-two-strings/description/
https://discuss.leetcode.com/topic/78273/js-solution-using-min-heap
https://leetcode.com/problems/replace-words/description/
https://leetcode.com/problems/next-greater-element-ii/description/
https://leetcode.com/problems/total-hamming-distance/description/
https://leetcode.com/problems/4sum-ii/description/
https://leetcode.com/problems/sqrtx/description/
https://leetcode.com/problems/palindromic-substrings/description/
https://leetcode.com/problems/subarray-sum-equals-k/description/
https://leetcode.com/problems/subarray-sum-equals-k/description/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
https://leetcode.com/problems/valid-triangle-number/description/
https://leetcode.com/problems/find-right-interval/description/
https://leetcode.com/problems/subsets/description/