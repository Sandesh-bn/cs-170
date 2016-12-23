/*
given a word it's abbreviation is (first char) number (last char)
given a dictionary and a word, find if its abbreviation is unique
in the dictionary
https://discuss.leetcode.com/topic/37254/let-me-explain-the-question-with-better-examples
http://www.cnblogs.com/jcliBlogger/p/4851799.html
https://discuss.leetcode.com/topic/52019/misleading-in-every-sense-let-me-give-a-better-statement

A word is abbreviation unique in a list if and only if one of the two cases is true:
1. The word is in the dictionary, then there should be no other word with the same abbr
2. If the word is not in the dictionary, then the dictionary should have no word with the given word’s abbr

*/

/*
create a map where key is abbreviation, value is hashset with all 
words having that abbreviation
*/
public class ValidWordAbbr{
	Map<String, Set<String>> map = new HashMap<>();
	public ValidWordAbbr(String[] dictionary){
		for (int i = 0; i < dictionary.length; i++){
			String key = getAbbr(dictionary[i]);
			
			if (!map.containsKey(key))
				map.put(key, new HashSet<>());
			map.get(key)add(dictionary[i]);
		}
	}
	
	// it is unique only if abbreviation is not in 
	// map or the word is the only word for that abbreviation ie ["dog"] dog
	public boolean isUnique(String word){
		String abbrOfWord = getAbbr(word);
		
		if (!map.containsKey(abbrOfWord))
			return true;
		if (map.get(abbrOfWord).contains(word) && 
			map.get(abbrOfWord).size() == 1)
			return true;
	}
	
	public String getAbbr(String s){
		if (s.length() < 3) return s;
		
		return s.substring(0, 1) +
			   String.valueOf(s.length() - 2) + 
			   s.substring(s.length() - 1);
			   
	}
	
}