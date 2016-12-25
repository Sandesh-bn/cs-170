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

