Basically, we have to find what kind of number is not valid.
After trim the string: remove all the leading space and trailing space
First of all, if there is a sign '+' or '-', it must be the first char or after a 'e' or 'E' and must be followed by number.
Secondly, if there is a 'e' or 'E', there must be no 'e' or 'E' occurred before, which means, only one scientific sign is allowed. There must be numbers before it and after it.
Thirdly, if there is a '.', must be no scientific sign before it and no dot before it. It must either follow a number or be followed by a number or scientific sign. 
Fourthly, no other character is allowed 



1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
System.out.println(validNumber.isNumber("0"));      // true
System.out.println(validNumber.isNumber(" 0.1"));   // true
System.out.println(validNumber.isNumber("abc"));    // false
System.out.println(validNumber.isNumber("1 a"));    // false
System.out.println(validNumber.isNumber("2e10"));   // true
System.out.println(validNumber.isNumber(" "));      // false
System.out.println(validNumber.isNumber(".1"));     // true
System.out.println(validNumber.isNumber("3."));     // true
System.out.println(validNumber.isNumber("."));      // false
System.out.println(validNumber.isNumber(".e1"));    // false
System.out.println(validNumber.isNumber("2.5e1.5"));// false
System.out.println(validNumber.isNumber("5e1.5"));  // false
System.out.println(validNumber.isNumber(" 005047e+6"));  // true


"3" TRUE
" 0.1 " TRUE
" .e2" FALSE
"abc" FALSE
"2e10" TRUE
".2E10" FALSE
"-2.1" TRUE
" +3321e123 " TRUE
" 0123" TRUE
" 039" TRUE
" -0x3a" FALSE
".2e81" TRUE
".2e8.1" FALSE
" +0X42 " FALSE
"e" FALSE
"." FALSE
".3" TRUE
"e2" FALSE
"2e" FALSE
"2." TRUE
" " FALSE
"+" FALSE
"-" FALSE
"46.e3" TRUE
"46e.3" FALSE
"6ee69" FALSE
" +3.2e57 " TRUE
"2E3" FALSE
"-.2e4 " TRUE
"-.2e-23" TRUE


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
                
                
                // if there is already an e or if e is the first character, return false. 
                // dot cannot appear after e, so set hasDot = true. pretend that dot has already appear.
                // -/+ can appear after e. so set hasFirst = false;
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


/*
hasE returns true if maximum number of e is 1.
if first character is +/- then hasFirst = true;
hasDot -> . cannot appear after e
hasDigit => if there is atleast one digit.



*/

