// This is from ctci, check other sites.
public void printAllPermutations(String str, String prefix){
	if (str.length() == 0)
		System.out.println(prefix);
	else {
		for (int i = 0; i < str.length(); i++){
			String rem = str.substring(0, i) + str.substring(i + 1);
			printAllPermutations(rem, prefix + str.charAt(i));
		}
	}
}