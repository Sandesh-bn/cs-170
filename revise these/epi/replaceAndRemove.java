/*
given a character array of sufficient size, remove all 'b' and replace all 'a' with 'dd'
*/
public static int replaceAndRemove(char[] s, int size){
	
	// iterate forward and shift all non-b characters by one position once b character is found.
	// update count of a
	
	int writeIndex = 0, aCount = 0;
	for (int i = 0 i < size; i++){
		if(s[i] != 'b'){
			s[writeIndex] = s[i];
			writeIndex++;
		}
		if (s[i] == 'a')
			aCount++;
	}
	
	
	// shift writeIndex towards right.
	// iterate backward and when you come across 'a' write two d's at writeIndex.
	
	int currIndex = writeIndex - 1;
	writeIndex = writeIndex + aCount - 1;
	int finalSize = writeIndex + 1;
	
	while (currIndex >= 0){
		if (s[currIndex] == 'a'){
			s[writeIndex--] = 'd';
			s[writeIndex--] = 'd';
		}
		else
			s[writeIndex--] = s[currIndex];
		currIndex--;
	}
	return finalSize;
}