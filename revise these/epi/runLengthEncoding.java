given a string, return the run length encoding
'aaaabcccaa' => '4a1b3c2a'

public String encode(String s){
	StringBuilder sb = new StringBuilder();
	int count = 1;
	for (int i = 1; i <= s.length(); i++){
		if (i == s.length() || !s.charAt(i) != s.charAt(i - 1)){
			sb.append(count);
			sb.append(s.charAt(i - 1));
			count = 1;
		}
		else
			count++;
	}
	return sb.toString();
}

public String decode(String s){
	int count = 0;
	StringBuilders sb = new StringBuilder();
	for (int i = 0; i < s.length(); i++){
		char ch = s.charAt(i);
		if (Character.isDigit(ch))
			count = count * 10 + ch - '0';
		else {
			while (count > 0){
				result.append(ch);
				count--;
			}
		}
	}
	return sb.toString();
}


  public static void main(String[] args) {
    if (args.length == 2) {
      System.out.println(encoding(args[0]) + ' ' + decoding(args[1]));
    }

    assert("4a1b3c2a".equals(encoding("aaaabcccaa")));
    assert("eeeffffee".equals(decoding("3e4f2e")));
    assert("aaaaaaaaaaffffee".equals(decoding("10a4f2e")));
  }