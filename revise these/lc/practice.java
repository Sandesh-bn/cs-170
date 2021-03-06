// ALL COMBNATION
public List<List<Integer>> csum(int[] A, int x){
    List<List<Integer>> res = new ArrayList<>();
    if (A == null) return res;
    dfs(res, new ArrayLIst<>(), A, x, 0);
    return res;
}

public void dfs(LIst<List<Integer>> res, List<Itneger> path, int[] A, int rem, int index){
    if (rem <= 0){
        if (rem == 0)res.add(path);
        return;
    }

    for (Int i = index; i < A.length; i++){
        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(A[i]);
        dfs(res, newPath, A, rem - A[i], i);
    }

}

public List<List<Integer>> csum(int[] A, int x){
    List<List<Integer>> res = new ArrayList<>();
    if (A == null) return res;
    dfs(res, new ArrayList<>(), A, x, 0);
    return res;
}

public void dfs(List<List<Integer>> res, List<Integer> path, int[] A, int rem, int index){
    if (rem <= 0){
        if (rem == 0)res.add(path);
        return;
    }
    for (int i = index; i < A.length; i++){
        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(A[i]);
        dfs(res, newPath, A, rem - A[i], i + 1);
    }
}


public List<List<Integer>> c(int n, int k){
    List<list<Integer>> res = new ArrayList<>();
    if (n == 0) return res;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
        arr[i] = i + 1;
    dfs(res, new ArrayList<>(), arr, 0, k);
    return res;
}

public void dfs(List<List<Integer>> res, List<Integer> path, int[] A, int index, int k){
    if (path.size() >= k){
        if (path.size() == k) res.add(path);
        return;
    }
    for (int i = index ; i < A.length(); i++){
        if (i > index || A[i] == A[i - 1])continue;
        List<Integer> newPath = new ArrayList<>();
        newPath.add(A[i]);
        dfs(res, newPath, A, i+ 1, k);
    }
}
// ALL PERJUTATION
public List<List<Integer>> permute(Int[] nums){
    List<List<Integer>> res = new ArrayList<>();
    permute(res, nums, 0, nums.length -1);
    return res;
}

public void permute(List<List<Integer>> res, int[] nums, int l, int h){
    if (l == h){
        List<Integer> temp = new ArrayList<>();
        for (int num: nums)
        temp.add(num);
        res.add(temp);
    }
    else {
        for (int i = low; i <= high; i++){
            swap(A, i, low);
            permute(A, low + 1, high);
            swap(A, i, low);
        }
    }
}


public List<String> permute(String val){
    List<String> res = new ArrayList<>();
    permute(res, val.toCharArray(), 0, val.length());
    return res;
}

public void permute(List<String> res, char[] A, int low, int high){
    if (low == high){
        StringBuilder sb = new StringBuilder();
        for (char ch: A)sb.append(ch);
        res.add(sb.toString());
    }
    else {
        for (int i = low; i <= high; i++){
            swap(A, i, low);
            permute(A, low + 1, high);
            swap(A, i, low);
        }
    }
}
// SUBSET
public List<List<Integer>> sub(int[] nums){
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> empty = new ArrayList<>();
    res.add(empty);
    int begin = 0;
    for (int i = 0; i < nums.length; i++){
        if (i == 0 || nums[i] == nums[i - 1])
            begin = 0;
        int size = res.size();
        for (int j = begin; j < size;j ++){
            List<Integer> temp = new ArrayList<>(res.get(j));
            temp.add(nums[i])
            resa.dd(temp);
        }
        begin  size;
    }
}

public List<List<Integer>> sub(int[] nums){
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());
    int begin = 0;
    for (int i = 0; i < nums.length; i++){
        if (i == 0 || nums[i] == nums[i - 1])
            begin = 0;
        int size = res.size();
        for (int j = begin; j < size; j++){
            List<Integer> curr = new ArrayList<>(res.get(j));
            curr.add(nums[i]);
            res.add(curr);
        }
        begin = size;
    }
}

// TRIE
class TrieNode{
 Map<Character, TrieNode> map;
 boolean endOfWord;
}

class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode;
    }

    public void add(String word){
        TrieNode curr = root;
        for (char c: word.toCharArray()){
            TrieNode n = curr.map.get(ch);
            if (n == null){
                n = new TrieNode();
                curr.map.put(ch, n);
            }
            curr = n;
        }
        curr.endOfWord = true;
    }

    public booelan search(String word){
        TrieNode curr = root;
        for (char ch: word.toCharArray()){
            if (!curr.map.containsKey(ch))
                return false;
            curr = curr.map.get(ch);
        }
        retunr curr.endOfWord;
    }

    public booelan startsWith(String p){
        TrieNode curr = root;
        for (char ch: p.toCharArray()){
            if (!curr.map.containskey(ch))
                return false;
            curr = curr.map.get(ch);
        }
        return true;
    }
}
// ADD AND SEARCH WORD
public boolean serch(String word){
    return searchDFS(word, 0, root);
}

public boolean searchDFS(String word, int i, TrieNode root){
    if (pos == word.length()) return root.endOfWord;
    Character c = word.charAt(pos);
    for (map.entry<character, trieNode> entry: root.map.enrySet()){
        Character trieCh = entry.getCh();
        if (trieCh == ch || trieCh == '.'){
            if (searchDFS(word, i + 1, trieNode))
            return true;
        }
    }
}
// KTH LARGEST ELEMENT
public int kthlargest(int[] arr, int k){
    return helper(arr, 0, arr.length - 1, arr.length - k);
}

public int helper(int[] arr, int low, int high, int k){
    if (low >= high) return arr[low];
    int pivotIndex = partition(arr, low, high);
    if (pivotIndex == k) return arr[k];
    else if (pivotIndex > k)
        returnn helper(arr, low, pivotIndex - 1, k);
    else
        return helper(arr, pivotIndex + 1, high, k);
}

public int partition(int[] arr, int low, int high){
    int i = low + 1, j = high, pivot = arr[low];
    while(true){
        while(arr[i] < pivot){
            i++;
            if (i >= high)break;
        }
        while(arr[j] >= pivot){
            j--;
            if (j <= low)break;
        }
        if (i >= j)break;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temmp;
        i++;j--;
    }
    int temp2 = arr[low];
    arr[low] = arr[j];
    arr[j] = temp2;
}
//REORDER LIST


// BST ITERATOR
public class BSTIterator{
    Deque<TreeNode> stack;
    TreeNode curr;
    public BSTIterator(TreeNode root){
        curr = root;
        stack = new LInekdList<>();
    }

    public boolean hasNext(){
        return curr != null || !stack.isEmpty();
    }

    public int next(){
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        Treenode temp = stack.pop();
        int ret = temp.val;
        curr =t emp.right;
        return return;
    }
}

public class BSTIterator{
    Stack<TreeeNode> st;
    TreeNode curr;
    BSTIterator(TreeNode root){
        curr = root;
        st = new Stack<>();
    }

    public boolean hasNext(){
        return curr != null || !stack.isEmpty();
    }

    public int next(){
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        TreeNode n =stack.pop();
        int ret = n.val;
        curr =n.right;
        return ret;
    }
    
}
//LARGEST NUMBER


// ROTATE ARRAY
1234567 k = 3 5671234
1234567

7654321
5671234
public void rotate(int[] arr, int k){
    reverse(arr, 0, arr.length - 1);
    reverse(arr, 0, k - 1);
    reverse(arr, k, arr.length - 1);
}

public void reverse(int[] arr, int s, int e){
    while(s  < e){
        int temp = arr[s];arr[s] = arr[e];arr[e] = temp;
        s++;e--;
    }
}

// MAX PRODUCT SUBARRAY


// NUMBER OF ISLAND
public int numIslands(char[][] grid){
    int count = 0;
    for (nt i = 0; i < grid.length; i++){
        for (int j = 0; j < grid[0].length; j++){
            if (grid[i][j] == '1'){
                dfs(grid, i, j);
                count++;
            }
        }
    }
    return count;
}


public void dfs(char[][] grid, int i, int j){
    if (i < 0 || j < 0 ||  i >= grid.length || j >= grid[0].length ||
    grid[i][j] != '1') return;
    if (grid[i][j] == '1')grid[i][j] = 'X';
    dfs(grid, i - 1, j);
    dfs(grid, i + 1, j);
    dfs(grid, i, j - 1);
    dfs(grid, i, j + 1);
}
// ISOMORPHI
public boolean isIso(String s, String t){
    char[] sch = new char[256];
    char[] tch = new char[256];
    for (int i = 0; i < s.length(); i++){
        char sc = s.charAt(i), tc = t.charAt(i);

        if (sch[sc] == 0 && tch[tc] == 0){
            sch[sc] = tc;
            tch[tc] = sc;
        }
        else if (sch[sc] != tc || tch[tc] != sc)
            return false;
    }
    return true;
}

// COUNT NUMBER OFP RIME
publci int countPrime(int n){
    boolean[] notPrime = new boolean[n];
    for (int i = 2; i * i <= n; i++){
        if(!notPrime[i]){
            for (int j = i; j * i < n; j++)
                notPrime[j * i] = true;
        }
    }
}

/// LCA

public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
    if (root == null) return null;
    if (root.val > p.val && root.val > q.val) return lca(root.left, p, q);
    if (root.val < p.val && root.val < q.val) return lca(root.right, p, q);
    return root;
}


publci TreeNode lcaNONBST(TreeNode root, TreeNode p, TreeNode q){
    if (root == null || root == p || root == q) return root;
    TreeNOde lst = lcaNONBST(root.left, p, q);
    TreeNode rst = lcaNONBST(root.right, p, q);
    if (lst == null && rst == null) return null;
    if (lst != null && rst != null)return root;
    return (lst == null)?rst: lst;
}


public int longestValidparentheses(string s){
    if (s == null || s.length() < 2) return 0;
    Stack<Integer> st = new Stack<>();
    int longestSoFar = 0, count = 0;
    for (char ch: s.toCharArray()){
        if (ch == '('){
            stack.push(count);
            count = 0;
        }
        else if (!stack.isEmpty()){
            count += stack.pop() + 1;
            longestSoFar = Math.max(longestSoFar, count);
        }
        else{
            count = 0;
            stack.clear();
        }
    }
    return longestSoFar * 2;
}

public int lengtOfLongestUniqueSubstring(String s){
    if (s.length() == 0) return 0;
    Map<Character, Integer> map = new HashMap<>();
    int maxSoFar = 0, i = 0, j = 0;
    while(i < s.length()){
        char ch = s.charAt(i);
        if (map.containsKey(ch))
            j = Math.max(j, map.get(ch) + 1);
        map.put(ch, i);
        maxSoFar = Math.max(maxSoFar, i - j + 1);
        i++;
    }
    return maxSoFar;
}

class RandomizedSet{
    Map<Integer, Integer> map;
    List<Integer> list;
    public RandomizedSet(){
        map = new HashMap<>();
        list = new ArrayLIst<>();
    }

    public boolean insert(int val){
        if(map.containsKey(val))return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val){
        i(!map.containsKey(val))
            return false;
        int index = map.remove(val);
        int lastElement = list.remove(list.size() - 1);
        if (lastElement == val)
            return true;
        list.set(index, lastElement);
        return true;
    }

    public int getRandom(){
        R
    }
}


class RandomizedSet{
    List<Integer> list;
    Map<Integer, LinkedHashSet<Integer>> map;
    public RandomizedSet(){
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val){
        boolean exist = map.containsKey(val);
        if (!exist){
            map.put(val, new LinkedHashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !exist;
    }

    public boolean remove(int val){
        if (!map.containsKey(val))
            return false;

        LinkedHashSet<Integer> valSet = map.get(val);
        int indexToReplace = valSet.iterator.next();
        int lastElement = list.get(list.size() - 1);
        LinkedHashSet<Integer> replaceSet = map.get(lastElement);

        valSet.remove(indexToReplace);
        list.set(indexToReplace, lastElement);

        if (lastElement != val){
            replaceSet.remove(list.size() - 1);
            replaceSet.add(indexToReplace);
        }

        list.remove(list.size() - 1);
        if (valSet.isEmpty())
            map.remove(val);
        return true;
    }
}


class Graph{
    private int V;

    private HashSet<Integer> adj[];
    public Graph(int v){
        this.v = v;
        adj = new HashSet[v];
        for (int i = 0; i < v; i++)
            adj[i] = new HashSet<>();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void bfs(int source){
        boolean visited[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        visited[source] = true;
        queue.offer(source);

        qhile(!q.isEmpty()){
            int n = q.poll();
            for (Integer neighbor: adj[n]){
                if (!visited[neighbor]){
                    q.offer(neighbor);
                }
            }
        }
    }
}

public TreeNode deletNode(TreeNode n, int k){
    if (n == null) return null;
    TreeNode temp = n, parent = n;
    boolean isLeftChild = true;

    while(temp.value != k){
        parent = temp;
        if (temp.value < k){
      
            temp = temp.left;
            isLeftchild = true;
        }
        if (temp.value > k){
            temp = temp.right;
            isLeftChild = false;
        }
        if (temp == null) 
            return null;
    }

    if (temp.left == null && temp.right == null){
        if (temp == root)
            return null;
        else if (isLeftchild)
            parent.left = null;
        else
            parent.right = null;
    }

    else if (temp.left == null){
        if (temp == root)
            root = temp.right;
        else if (isLeftChild)
            parent.left = temp.right;
        else if (isRightChild)
            parent.right = temp.right;
    }

    else if (temp.right == null){
        if (temp == root)
            root = temp.left;
        else if(isLeftchild)
            parent.left = temp.left;
        else if (isRightChild)
            parent.right = temp.right;
    }

    else {
        TreeNode succ = getSucc(temp);

        if (temp == root)
            root = succ;
        if (isLeftchild)
            parent.left = succ;
        if (isRightChidl)
            parent.right = succ;
    }
    return root;
}
public TreeNode getSucc(TreeNode delNode){
    TreeNode succ = delNode, succParent = delNode, temp = delNode.right;
    while(temp != null){
        succParent = succ;
        succ = temp; 
        temp = temp.left;
    }
    if (delNode.right!= null)[
        succParent.left = succ.left;
        succ.right = delNode.right;
    ]
    return succ;
}

public int kthLargest(int[] A, int k){
    int start = 0, end = A.length - 1;
    while(start < end){
        int pivot = partiotn(A, start, end);
        if (pivot == k)return A[k];
        if (pivot < k) start = pivot + 1;
        else 
            end = pivot - 1;
    }
    return A[start];
}



public List<String> letterComb(String digits){
    String[] mapping = {"0", "1", "abc", "def", "ghi"};
    LinkedList<String> list = new LinkedList<>();
    list.add("");
    for (int i = 0; i < digits.length(); i++){
        int digit = digits.charAt(i) - '0';
        int size = list.size();
        for (int j = 0; j < size; j++){
            String f = list.remove();
            for (char c: mapping[digit].toCharArray()){
                list.add(f + s);
            }
        }
    }
}



public void populate(TreeNode root){
    TreeNode dummy = new TreeNode(0);
    TreeNode prev = dummy;
    while(root != null){
        if (root.left != null){
            prev.next = root.left;
            prev = prev.next;
        }
        if (root.right != null){
            prev.next = root.right;
            prev = prev.next;
        }
        root = root.next;
        if (root == null){
            root = dummy.next;
            prev = dummy;
            dummy = null;
        }
    }
}


public boolean isUgly(int n){
    while(n % 2 == 0)
        n /= 2;
    while(n % 3 == 0)
        n /= 3;
    while(n % 5 == 0)
        n/= 5;
    return n == 1;
}


public int nthUgly(int n){
    int i2 = 0, i3 = 0, i5 = 0;
    int m2  = 2, m3 =  3, m5 = 5;
    int dp[] = new int[n];
    dp[0] = 1;
    for (Int i = 1; i < n; i++){
        int min = Math.min(m2, m3, m5);
        dp[i] = min;
        if (m2 == min){
            i2++;
            m2 = 2 * dp[i2];
        }
        if (m3 == min){
            i3++;
            m3 = 3 * dp[i3];
        }
        if (m5 == min){
            i5++;
            m5 = 5 * dp[i5];
        }
    }

}

public int[] searchRange(int[] A, int x){
    int start = 0, high = N - 1;
    int[] ret = {-1, -1};
    while(start < high){
        int mid = (start + high)/2;
        if (A[mid] < x)
            low = mid + 1;
        else
            h = mid;
    }
    if (A[low] != x)
        return ret;
    ret[0] = l;
    high = N - 1;
    while(start < high){
        int id = (start + end)/2 + 1;

        if (A[mid] > x)
            high = mid - 1;
        else
            low = mid;
    }
    ret[1] = 

}