longestWord
 Given a list of words, write a program to find the longest word made of other words 
in the list. 
EXAMPLE 
lnput:cat,  banana,  dog,  nana,  walk,  walker,  dogwalker 
Output: dogwalker 

add each word to map.
maintain maxso far
for each word. split it into all possible pairs and check if the pairs exist in the map.

String getLongestWord(String[] list){
	Set<String> set = new HashSet<>();
	for (String word: list)
		set.add(word);
	
	for (String word: list){
		for (int i = 1; i < word.length(); i++){
			String left = word.substring(0, i);
			String right = word.substring(i);
			if (set.contains(left) && set.contains(right))
				return s;
		}
	}
	return whatever you want.
}

works well if the string can be formed only by two words.
if it could be formed by any number of words, you have to use dp approach
the solution is in CTCI boook