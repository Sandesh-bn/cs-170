// "the sky is blue" => "blue is sky the"

public void reverseWords(char[] s){
	if (s.length == 0) return;
	reverse(s, 0, s.length - 1);
	
	int last = 0;
	for (int i = 0; i < s.length; i++){
		if (s[i] == ' '){
			reverse(s, last, i - 1);
			last = i + 1;
		}
	}
}

public void reverse(char[] s, int l, int r){
	while (l <= r){
		char temp = s[l];
		s[l] = s[r];
		s[r] = temp;
		l++;
		r--;
	}
}