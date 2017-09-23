Given a string, find out if the string is K-Palindrome or not. A k-palindrome string transforms into a palindrome on removing at most k characters from it.

Examples :

Input : String - abcdecba, k = 1
Output : Yes
String can become palindrome by remo-
-ving 1 character i.e. either d or e)


Input  : String - abcdeca, K = 2
Output : Yes
Can become palindrome by removing
2 characters b and e.

Input : String - acdcb, K = 1
Output : No
String can not become palindrome by
removing only one character.

the problem is similar to edit distance problem. but here
we are trying to convert given string to it's reverse. but only deletion of character
is allowed.
so we are checking whether total number of deletion n <= 2 * k 
2 * k. because we are counting deletion from both string and it's reverse

eg: a b c d e c a  k = 2 Output: true
we have to remove b and d.

str:   a  b  c  d  e  c  a
rev:   a  c  e  d  c  b  a   edit distance with only delete allowed is 4
ie we have to remove 2 characters from original string




public boolean isKPalindrome(String s, int k){
    String reverse = (new StringBuilder(s)).reverse().toString();

    return editDistanceWithDeleteOnly(s, reverse) <= (2 * k);
}

public int editDistanceWithDeleteOnly(String s1, String s2){
    // handle edge cases skipped
    int R = s1.length() + 1;
    int C = s2.length() + 1;

    int dp[][] = new int[R + 1][C + 1];

    for (int i = 0; i <= R; i++){
        for (int j = 0; j <= C; j++){


            if (i == 0 || j == 0)
                dp[i][j] = i + j;

            else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                dp[i][j] = dp[i - 1][j - 1];
            // if characters are different, remove and find the minimum
            else
                dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
        }
    }

    return dp[R][C];

}

If last characters of two strings are same, we ignore last characters and get count for remaining strings. 
So we recur for lengths m-1 and n-1 where m is length of str1 and n is length of str2.
If last characters are not same, we consider remove operation on last character of first string and last character of second string, recursively compute minimum cost for the operations and take minimum of two values.
Remove last char from str1: Recur for m-1 and n.
Remove last char from str2: Recur for m and n-1.