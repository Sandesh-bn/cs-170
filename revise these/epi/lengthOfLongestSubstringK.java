/*

 
    String s = "aabbcc"; 
	k = 1  [aa, bb, cc];
	k = 2 [aabb, bbcc]
	k = 3 [aabbcc]
    String s2 = "eceba";
    System.out.println(lengthOfLongestSubstringTwoDistinct(s, 3));
    System.out.println(lengthOfLongestSubstringTwoDistinct(s2, 2));
	
	*/

public static int lengthOfLongestSubstringKDistinct(String s, int k){
		Map<Character, Integer> map = new HashMap<>();
        int j = 0, n = s.length(), best = 0;
        for(int i = 0; i < n; i++) {
            while(j < n && map.size() <= k) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if(map.size() <= k) {
                    best = Math.max(best, j-i+1);
                }
                j++;
            }
            int count = map.get(s.charAt(i));
            if(count == 1) {
                map.remove(s.charAt(i));
            } else {
                map.put(s.charAt(i), count - 1);
            }
        }
        return best
        /*
        int[] map = new int[128];
        int count = 0, start = 0, end = 0;
        int res = 0;
        while (end < s.length()) {
            if (map[s.charAt(end++)]++ == 0)
              count++;
            
            while (count > k) if (map[s.charAt(start++)]-- == 1) count--;
            res = Math.max(res, end - start);
        }
        return res;
        */
        
}