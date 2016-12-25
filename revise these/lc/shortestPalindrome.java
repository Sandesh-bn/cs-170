public String pal(String val){
	int i = 0, j = val.length() - 1;
	int end = j;
	while (i < j){
		if (val.charAt(i) == val.charAt(j)){
			i++;j--;
		}
		else {
			i = 0;
			end--;
			j = end;
		}
	}
	StringBuilder prefix = new StringBuilder(val.substring(end + 1));
	return prefix.reverse().toString() + val;
}