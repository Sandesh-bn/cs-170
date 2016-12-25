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
