Trapping Rain Water   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 92692
Total Submissions: 264220
Difficulty: Hard
Contributors: Admin
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


revise this

Multiply Strings   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 84540
Total Submissions: 328200
Difficulty: Medium
Contributors: Admin
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length() - 1, n = num2.length() - 1, carry = 0;
        StringBuilder product = new StringBuilder();
        
        int i = 0;
        while (i <= (m + n) || carry > 0){
            for (int j = Math.max(0, i - n); j <= Math.min(i, m); j++)
                carry += (num1.charAt(m - j) - '0') * (num2.charAt(n - i + j) - '0');
            product.append(carry % 10);
            carry /= 10;
            i++;
        }
        return product.reverse().toString();
    }
}
