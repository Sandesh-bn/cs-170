Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


 public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null ||p.length() == 0)
            return res;
        if (s.length() < p.length())
            return res;
        
        int plen = p.length();
        int slen = s.length();
        for (int i = 0; i < slen - plen + 1; i++){
            if (isAnagram(s.substring(i, i + plen), p))
                res.add(i);
        }
        return res;
    }
    public boolean isAnagram(String s, String p){
        int[] ascii = new int[128];
        for (int i = 0; i < s.length(); i++)
            ascii[s.charAt(i)]++;
        for (int i = 0; i < s.length();i++)
            ascii[p.charAt(i)]--;
        for (int n: ascii)
            if (n != 0)return false;
        return true;
    }
    