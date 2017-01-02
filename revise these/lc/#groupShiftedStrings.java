Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz".

Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence, return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]


ublic class Solution {
public List<List<String>> groupStrings(String[] strings) {
    HashMap<String,List<String>> map=new HashMap<>();
    Arrays.sort(strings);
    for(String s:strings){
        String key=pattern(s);
        if(map.containsKey(key)) map.get(key).add(s);
        else map.put(key,new LinkedList<String>(Arrays.asList(s)));
    }
    return new LinkedList<List<String>>(map.values());
}
public String pattern(String s){
    StringBuilder ss=new StringBuilder();
    ss.append(0);
    for(int i=0;i<s.length()-1;i++){
       if(s.charAt(i)<s.charAt(i+1)){
           ss.append(s.charAt(i)-s.charAt(i+1)+26);
       }
       else ss.append(s.charAt(i)-s.charAt(i+1));
    }
    return ss.toString();
}


public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strings) {
            String k = getKey(s);
            if (!map.containsKey(k))
                map.put(k, new ArrayList<>());
            map.get(k).add(s);
        }
        for (String k: map.keySet()) {
            Collections.sort(map.get(k));
            res.add(map.get(k));
        }
        return res;
    }
    
    private String getKey(String s) {
        StringBuilder sb  = new StringBuilder();
        int diff = (int)('a' - s.charAt(0));
        for (int i=1; i<s.length(); i++) {
            char c = s.charAt(i);
            sb.append((char)((int)(c+diff-'a'+26)%26 + 'a'));
        }
        return sb.toString();
    }
}