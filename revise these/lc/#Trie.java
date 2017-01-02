class TrieNode{
    Map<Character, TrieNode> map;
    boolean endOfWord;
}

public class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode;
    }

    public void insert(String word){
        TrieNode cur = root;
        for (char ch: word.toCharArray()){
            TrieNode n = cur.map.get(ch);
            if (n == null){
                n = new TrieNode();
                cur.map.put(ch, n);
            }
            cur = n;
        }
        cur.endOfWord = true;//////$$$$$$$$ important
    }


    public boolean search(String word){
        TrieNode cur = root;
        for (char ch: word.toCharArray()){
            if (!cur.map.containsKey(ch))
                return false;
            cur = cur.map.get(ch);
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String word){
        TrieNode cur =root;
        for (char ch: word.toCharArray()){
            if (!cur.map.containsKey(ch))
                return false;
            cur = cur.map.get(ch);
        }
        return true;
    }
}