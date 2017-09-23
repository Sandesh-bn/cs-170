public boolean oneEditDistance(String s, String t){
	int i = 0, j = 0;
	while (i < s.length() && j < t.length()){
		while (i < s.length() && j < t.length()){
			if (s.charAt(i) == t.charAt(j)){
				i++;j++;
			}
				
			//s = aXc t = aBc
			if (s.length() == t.length())
				return s.substring(i + 1).equals(t.substring(j + 1));
			// s = aXbc t = abc
			else if (s.substring(i + 1).equals(t.substring(j)))
				return true;
			// s = abc t = aXbc
			else if (s.substring(i).equals(t.substring(j + 1)))
				return true;
		}
		// s = abcX t = abc
		return Math.abs(s.length() - t.length()) <= 1;
	
	
}

aXc aYc

aXbc abc

abc aXbc

abcX abc