Input:  
string a = "GeeksforGeeks"
string b = "Gks"

Output: 4

Explanation:  
The four strings are - (Check characters marked in bold)
GeeksforGeeks
GeeksforGeeks
GeeksforGeeks
GeeksforGeeks

http://www.geeksforgeeks.org/find-number-times-string-occurs-given-string/

int count(String A, String B){
    int m = A.length(), n = B.length();
    return count(A, B, m, n);
}
int count(String A, String B, int m, int n){
    

    if ((m == 0 && n == 0) || n == 0)
        return 1;
    
    if (m == 0)
        return 1;

    
    if(A.charAt(m - 1) == B.charAt(n - 1))
        return count(A, B, m - 1, n - 1) +
               count(A, B, m - 1, n);
    else
        return count(A, B, m - 1, n);
}