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