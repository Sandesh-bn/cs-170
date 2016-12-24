Given a string band an array of smaller strings T, design a method to search b for
each small string in T.
SOLUTION
Let's start with an example:
T = {"is", "ppi", "hi", "sis", "i", "ssippi"}
b = "mississippi"

Map<String, List<Integer>> searchAll(String big, String[] smalls){
	Map<String, List<Integer>> map = new HashMap<>();
	for (String word: smalls){
		List<Integer> locations = search(big, word);
		map.put(word, locations);
	}
	return map;
}

public List<Integer> search(String big, String small){
	List<Integer> locations = new ArrayList<>();
	for (int i = 0; i <= big.length() - small.length(); i++){
		if (isSubstringLocation(big,small, i))
			locations.add(i);
	}
	return locations;
}

public boolean isSubstringLocation(String big, String small, int offset){
	for (int i = 0; i < small.length(); i++){
		if (big.charAt(offset + i) != small.charAt(i))
			return false;
	}
	return true;
}

runtime = O(kbt) k is length of longest string in smalls
b is the length of big.
t number of elements in smalls[]