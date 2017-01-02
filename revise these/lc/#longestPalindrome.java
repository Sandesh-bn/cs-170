Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.


public int longestPalindrome(String s){
    // add characters to set
        // every time we find a second occurence of a character, we remove it and incrmeent count
        // count = number of times a character occurs twice
        // if set is empty, all characters occur even number of times. and hence the length of 
        // longest palindrome = lenght of string eg: abacbc =>   baccab
        // if set is not empty then length of longest palindrome = count * 2 + 1
        // effggcc     cgfefgc
        // + 1 because we can add utmost one character that doesn't have a pair.
    Set<Character> set = new HashSet<>();
    int pairCount = 0;
    for (char ch: word.toCharArray()){
        if(set.contains(ch)){
            set.remove(ch);
            pairCount++;
        }
        else
            set.add(ch);
    }
    if (set.isEmpty())
        return pairCount * 2;
    else   
        return pairCount * 2 + 1;

}