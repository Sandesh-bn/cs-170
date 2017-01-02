Letter Combinations of a Phone Number   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 116415
Total Submissions: 362430
Difficulty: Medium
Contributors: Admin
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.


Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs","tuv", "wxyz"};
        LinkedList<String> list = new LinkedList<>();
        if (digits.length() == 0)
            return list;
        list.add("");
        for (int i = 0; i < digits.length(); i++){
            int digit = Character.getNumericValue(digits.charAt(i));
            while (list.peek().length() == i){
                String t = list.remove();
                System.out.println(t);
                for (char s: mapping[digit].toCharArray())
                    list.add(t + s);
            }
        }
        return list;
        
        // THIS IS BFS AND TIME COMPLEXITY IS O(m ^ n) = O(3 ^ n) n is len(digits)
    }
}