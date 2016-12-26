Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".


public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        //https://discuss.leetcode.com/topic/24821/same-as-dp-my-explanation-and-python-sample-code
        boolean [] breakable = new boolean[s.length()+1];
        breakable[0] = true;

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(breakable[j]&&dict.contains(s.substring(j,i))){
                    breakable[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(breakable));
        return breakable[s.length()];   
    }
}