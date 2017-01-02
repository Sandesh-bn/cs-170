Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same lengt


public boolean isIsomorphic(String s, String t) {
        char schars[] = new char[256];
        char tchars[] = new char[256];
        for (int i = 0; i < s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (schars[sc] == 0 && tchars[tc] == 0){
                schars[sc] = tc;
                tchars[tc] = sc;
            }
            else if (schars[sc] != tc || tchars[tc] != sc)
                return false;
        }
        return true;
    }