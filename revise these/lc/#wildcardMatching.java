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