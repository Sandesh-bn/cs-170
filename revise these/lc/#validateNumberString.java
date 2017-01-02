Valid Number   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 58964
Total Submissions: 468001
Difficulty: Hard
Contributors: Admin
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        int N = s.length();
        if (N == 0) return false;
        
        boolean hasE, hasFirst, hasDot, hasDigit;
        hasE = hasFirst = hasDot = hasDigit = false;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                hasFirst = true;
                hasDigit = true;
                continue;
            }
            
            switch (ch){
                
                case 'e': if (hasE || !hasDigit)
                             return false;
                           hasE = true;
                           hasDigit = false;
                           hasFirst = false;
                           hasDot = true;
                           
                           continue;
                case '+':
                case '-':
                        if (hasFirst) return false;
                        hasFirst = true;
                        continue;
                case '.': if (hasDot) return false;
                        hasDot = true;
                        hasFirst = true;
                        continue;
                default: return false;
            }
        }
        return hasDigit;
    }
}