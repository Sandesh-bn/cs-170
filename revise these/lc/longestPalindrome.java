public String longestPalindrome(String s){
	String res = "";
	for (int i = 0; i < s.length(); i++){
		
		// odd-length, palindrome
		String palindrome = genPalindrome(s, i, i);
		
		if (palindrome.length() > res.length())
			res = palindrome;
		
		//even-length palindrome
		palindrome = genPalindrome(s, i, i + 1);
		
		if (palindrome.length() > res.length())
			res = palindrome;
	}
	return res;
}

public String genPalindrome(String text, int left, int right){
	while (left >= 0 && right < text.length() && 
			text.charAt(left) == text.charAt(right)){
				left--;
				right++;
	}
	return text.substring(left + 1, right);
}