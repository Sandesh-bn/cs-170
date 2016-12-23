Word  Frequencies: Design a method to fi nd the frequency of occurrences of any given word in a 
book. What if we were running this algorithm multiple times? 

Map<String, Integer> updateMap(String[] book){
	Map<String, Integer> map = new HashMap<>();
	for (String word: book){
		word = word.toLowerCase();
		if (word.trim() != ""){
			if (!table.containsKey(word))
				table.put(word, 1);
			else
				table.put(word, table.get(word) + 1);
		}
	}
	return map;
}

int getFrequency(Map<String, Integer> map, String word){
	if (map == null || word == null)
		return -1;
	if (table.containsKey(word))
		return table.get(word);
	return 0;
}