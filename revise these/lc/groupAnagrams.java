public List<List<String>> groupAnagrams(String words[]){
	List<List<String>>  result = new ArrayList<>();
	if (words == null || words.length == 0)
		return result;
	Map<String, List<String>> map = new HashMap<>();
	for (String word: words){
		// sort character in words.
		// if the sorted string is not in  map. add it with a value of new List
		// add the word to that list
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		String sortedKey = new String(chars);
		if (!map.containsKey(sortedKey))
			map.put(sortedKey, new ArrayList<>());
		map.get(sortedKey).add(word);
	}
	
	for (Map.Entry<String, List<String>> entry: map.entrySet())
		result.add(entry.getValue());
	return result;
}