import java.util.*;
class Main{
  public static void main(String[] a){
    String p = "abcd";
    String s = "thequickbrownfox"  ;
    System.out.println(wordPatternMatch(p, s));
  }
  
   public static boolean wordPatternMatch(String pattern, String str) {
    Map<Character, String> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    
    return isMatch(str, 0, pattern, 0, map, set);
  }
  
  static boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set) {
    // base case
    //if (i == str.length() && j == pat.length()) return true;
    //if (i == str.length() || j == pat.length()) return false;
    
    if (i == str.length()) return j == pattern.length();

    // get current pattern character
    char ch = pat.charAt(j);
    
    // if the pattern character exists
    if (map.containsKey(c)) {
      String substring = map.get(ch);
      
      // then check if we can use it to match str[i...i+s.length()]
      if (!str.startsWith(substring, i)) {
        return false;
      }
      
      // if it can match, great, continue to match the rest
      return isMatch(str, i + substring.length(), pat, j + 1, map, set);
    }
    
    // pattern character does not exist in the map
    for (int k = i; k < str.length(); k++) {
      String p = str.substring(i, k + 1);

      if (set.contains(p)) {
        continue;
      }

      // create or update it
      map.put(ch, p);
      set.add(p);
      
      // continue to match the rest
      if (isMatch(str, k + 1, pat, j + 1, map, set)) {
        return true;
      }

      // backtracking
      map.remove(ch);
      set.remove(p);
    }
    
    // we've tried our best but still no luck
    return false;
  }
  
}