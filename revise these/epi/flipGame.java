// flip game
public class Solution{
	public List<String> generateFlips(String value){
		List<String> result = new ArrayList<>();
		if (value == null || value.length() < 2)
			return result;
		for (int i = 0; i < value.length() - 1; i++){
			if (value.charAt(i) == '+' && value.charAt(i + 1)== '+'){
				/*String s1 = value.substring(0, i);
				String s2 = "--";
				String s3 = s.substring(i + 2);*/
				result.add(value.substring(0, i) +
						   "--" +
						   value.substring(i + 2));
			}
		}
		return result;
	}
}