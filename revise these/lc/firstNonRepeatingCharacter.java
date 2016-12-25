
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
