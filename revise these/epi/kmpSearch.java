public int[] computeLps(char[] pattern){
	int[] lps = new int[pattern.length];
	int j = 0;
	int i = 1;
	while (i < pattern.length){
		if (pattern[i] == pattern[j]){
			lps[i] = j + 1;
			i++;j++;
		}
		else {
			if (j != 0)
				j = lps[j - 1];
			else {
				lps[i] = 0;
				i++;
			}
		}
		i++;
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