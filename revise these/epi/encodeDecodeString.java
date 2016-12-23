encode(['abc', 'dog', 'button']) =>> "3#abc3#dog6#button"
public class Codec{
	public String encode(List<String> strs){
		
		if (strs == null || strs.size() == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		
		for (String word: strs){
			sb.append(word.length());
			sb.append(word);
		}
		return sb.toString();
	}

	public List<String> decode(String s){
		List<String> result = new ArrayList<>();
		if (s == null || s.length() == 0)
			return result;
		int i = 0;
		while (i < s.length()){
			int lenOfWord = 0;
			while (i < s.length() && s.charAt(i) != '#'){
				len = len * 10 + Character.getNumericValue(s.charAt(i));
				i++;
			}
			String word = s.substring(i + 1, i + lenOfWord + 1);
			result.add(word);
			i = i + lenOfWord + 1;
		}
		return result;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));