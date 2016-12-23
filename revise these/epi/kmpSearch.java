public int[] computeLps(char[] pattern){
	int[] lps = new int[pattern.length];
	int i = 0;
	int j = 1;
	while (j < pattern.length){
		if (pattern[i] == pattern[j]){
			lps[j] = i + 1;
			i++;j++;
		}
		else {
			if (i != 0)
				i = lps[i - 1];
			else {
				lps[j] = 0;
				j++;
			}
		}
		j++;
	}
	return lps;
}
public int KMP(char[] text, char[] pattern){
	int lps[] = computeLps(pattern);
	int i = 0, j = 0;
	
	while (i < text.length && j < pattern.length){
		if (text[i] == pattern[j]){
			i++;j++;
		}
		else {
			if (j != 0)
				j = lps[j - 1];
			else
				i++;
		}
	}
	if (j == pattern.length)
		return i - j;
	return -1;
}