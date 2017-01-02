
 Generate Parentheses   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 120516
Total Submissions: 290825
Difficulty: Medium
Contributors: Admin
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]



public class Solution {
   
   
    
    public List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        helper(result, n, n, "");
        return result;
    }
    
    public void helper(List<String> result, int left, int right, String brackets){
        if (left == 0 && right == 0)
            result.add(brackets);
        if (left > 0)
            helper(result, left - 1, right, brackets + "(");
        if (right > 0 && right > left)
            helper(result, left, right - 1, brackets + ")");
    }
   
}
