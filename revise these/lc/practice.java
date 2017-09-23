import javax.smartcardio.CardNotPresentException;

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



public int thirdMax(int[] nums){
    Integer firstMax = nums[0], secondMax = null, thirdMax = null;
    for (int num: nums)
        firstmax = Math.max(firstmax, num);
    for (int num: NUms)
        if (num < firstMax)
            secondMax = (secondMax == null)?num: 
}

reverse(A, 0, N - 1);
reverse(A, 0, k - 1);
reverse(A, k, N - 1);


public int[][] reconstruct(int[][] people){
    List<int[]> list = new ArrayList<>();
    Arrays.sort(people, new Comparator<int[]>(){
        public int compare(a[], b[]){
            if (a[0] != b[0])
                return b[0] - a[0];
            else
                return a[1] - b[1];
        }
    });
    for (int[] e: people)
        list.add(e[1], e);
}

int[] ascii = new int[256];
for (char c: s.toCharArray())
    ascii[c]++;

Map<Integer, List<Character>> map = new HashMap<>();
for (int i = 0; i < ascii.length; i++){
    int count = ascii[c];
    if (!map.containsKey(count))
        map.put(count, new);
    map.get(count).add((char)i)
}

StringBuilder sb = new StringBuilder();
for (int i = s.length(); i > 0; i--){
    if (map.containsekY(i))
        for (char c: chars)
            for (int j = 0; j < i; j++)
                sb.append(c);
}




public String serialize(TreeNode root){
    StringBuilder sb = new StringBuilder();
    helper(root, sb);
    return sb.toString();
}

public void helper(Stringbuilder sb, TreeNode root){
    if (root == null){
        sb.append("null,");
        return;
    }
    sb.append(root.val + ",");
    helper(sb, root.left);
    helper(sb, root.right);
}

int index = 0;
public TreeNode deserialize(String data){
    String[] tokens = data.split(",");
    return dehelper(tokens);
}

public TreeNode deHelper(String[] tokens){
    if (index == tokens.length || tokens[index].equals("null")){
        index++
        return null;;
    }
    TreeNode root = new TreeNode(toeksn[index++]);
    root.left = deHelper(tokens);
    root.right = deHelper(tokens);
    return root;
}

public int randpick(int ele){
    Random r = new Random();
    int idx = r.nextInt(nums.length);
    while(nums[idx] != ele)
        idx = r.nextInt(nums.length);
    return idx;
}





public List<List<String>> get(String[] words){
    Map<String, List<String>> map = new HashMap<>();

    for (String word: words){
        char chs[] = word.toCharArray();
        Arrays.sort(chs);
        String key = new String(chs);
        if (!map.containsKey(key))
            map.put(key, new ArrayList<>());
        map.get(key).add(word);
    }
    List<List<String>> res = new ArrayList<>();
    for (Map.Entry<String, List)
}

public int findPeakElement(int[] A){
    int low = 0, high == N - 1;
    while (low <= high){
        int mid = (low + high)/2;
        if ((mid == 0 || A[mid] > A[mid - 1]) && (mid == n - 1 || A[mid] > A[mid + 1]))
            return mid;
        else if (mid > 0  && A[mid] < A[mid - 1])
            high = mid - 1;
        else
            low = mid + 1;
    }
}


int[] empty = {};
if (array == null || array.length == 0)
    return empty;
LinkedList<Integer> list = new LinkedList<>();
List<INteger> res = new ArrayList<>();

for (int i = 0; i < k; i++){
    while(!list.isEmpty() && array[list.getLast()] < arr[i])
    list.removeLast();
    list.add(i);
}

for (int i = k; i < N: i++){
    res.add(array[list.getFirst()]);

    while(!list.isEmpty() && list.getFirst() < i - k + 1)
        list.removeFirst();

    while(!lit.isEmpty() && array[list.getLast()] < array[i])
        list.removeLast();

    list.add(i);
}

res.add[array[list.getFirst()]]

class LRUCache{
    class Node{
        Node prev, next;
        int key, value;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head, end;
    Map<Integer, Node> map = new HashMap<>();
    public LRU(int c){
        this.capacity = c;
        map = new HashMap<>>();
        head = null; end = null;
    }
    public void put(int key, int value){
        if (map.containsKEy(key)){
            Node n =map.get(key);
            n.value = value;
            remove(n);
            setHead(n);
        }
        else{
            Node n = new Node(key, value);
            if (map.size() == capacity){
                map.remove(end.key);
                remove(end);
            }
            map.put(key, n);
            setHead(n);
        }
    }

    public int get(int key){
        Node n = map.get(key);
        remove(n);
        setHead(n);
    }

    public void setHead(Node n){
        n.next = head;
        if (head != null)
            head.prev =  n;

        if (end == null)
            end = head;
    }
    public void remove(Node n){
        if (n.prev == null)
            head = n.next;
        else
            n.prev.next = n.next;

        
    }
}

public double median(int[] A, int[] B){
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityqEueu<Integer> maxHeap = new PrioorityQueue<>(Collection.reverseOrder());

    int i = 0, j = 0;
    while(i < A.length || j < B.length){
        if (i < A.length){
            if (maxHeap.isEmpty() || A[i] <= maxHeap.peek())
                maxHeap.offer(A[i]);
            else
                minHeap.offer(A[i]);
        }
        if (j < B.length){

        }
    }
}

Stack<Integer> stack = new Stack<>>();
int longest = 0, coutn = 0;
for (char c: s.toCharArray()){
    if (c == '('){
        st.push(count);
        count = 0;
    }
    else if (!st.isEmpty()){
        count += stack..polll() + 1;
        longest
    }
    else {
        count = 0;
        stack.clear();
    }
}


public List<List<Integer>> permute(int[] nums){
    permute(nums, 0, nums.lenght - 1);
    return result;
}

public void permute(Int[] nums, int low, int high){
    if (low == high){

    }
    else {
        for (int i = low; i <= high; i++){
            swap(arr, low, i);
            permute(nums, low + 1, high);
            swap(arr, low, i);
        }
    }
}

public void printBoundary(TreeNode root){
    preOrderLeft(root);
    inorderLeaves(root);
    postOrderRight(root);
}

privat boolean isLeaf(TreeNode root){
    if (node == null) return false;
    return node.left == null && node.right == null;
}

public void preorderLeft(){
    if (node != null && !isLeaf(node))
        sop(node.val);
    if (node.left != null)
        preorderLeft(node.left);
}



public void doubleTree(TreeNode node){
    Node oldLeft;
    if (node == null) return;
    doubleTree(node.left);
    doubleTree(ndoe.right);

    oldLeft = node.left;
    node.left = new Node(noe.)
}


{
    q.offer(root);
    boolean isNonFull = false;

    while(!q.isEmpty()){
        TreeNode n =q.poll();
        if (n.left != null){
            if(isNonFull)return false;
            q.offer(n.left);
        }
        else
            isNonFull = true;
        if (n.right != null){

        }
    }
}


int getMaxSum(TreeNode root){
    if (root == null) return 0;
    Map<TreeNode, Integer> map = new HashMap<>();
    return    getMaxSum(root, map);

}

int getMaxSum(TreeNode root, Map<Node, Integer> map){
    if (node == null)
        return 0;
    if (map.containsKey(node))
        return map.get(node);
    int inc = node.val + getGrand(node);
    int exc = getMaxSum(node.left, map) + getMaxSum(node.right, map);

    map.put(node, max(inc, exc));
    return map.get(node);
}

public void double(TreeNode root){
    if (root == null) return;
    Node oldLeft = root.left;
    root.left = new Node(root.val);
    root.left.left = oldLeft;
    doubleTree(root.left);
    doubleTree(root.right);
}


public int maxSquare(int[][] m){
    int r = m.length;
    int c = m[0].length;
    int[][] dp = new int[r][c];
    for (int i = 0; i < r; i++){
        for (int j = 0; j < c; j++){
            if (i == 0 || j == 0)
                dp[i][j] = 0;
            else if (m[i][j] == m[i - 1][j] && m[i][j] == m[i - 1][j - 1] && m[i][j] == m[i][j - 1]){
                dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1])  + 1;
            }
            else
                dp[i][j] = 1;
        }
    }
}

public int evaluate(TreeNoe root){
    if (root == null) return 0;
    if (root.left == null && root.right == null) return root.data;
    int left = evaluate(root.left);
    int right = evaluate(root.right);
    if (root.data == '+')
        return left + right;
    if (root.data == '-')
        return left - right;
    if (root.data == '/')
        return left /right;
    
}


queue.offer(root);
boolean isNonFull = false;

while(!queue.isEmpty()){
    TreeNode n = q.poll();
    if (n.left != null){
        if (isNonFull) return false;
        q.offer(n.left);
    }
    else
        isNonFull = true;
    if (n.right != null){
        if (isNonFull) return false;
        q.offer(n.right);
    }
    else
        isNonFull = true;
}

Queue<TreeNode> q = new LinkedList<>();
q.offer(root);
boolean isNonFull = false;
while(!q.isEmpty()){
    TreeNode n= q.poll();
    if (n.left != null){
        if (isNonFull) return false;
        q.offer(n.left);
    }
    else
        isNonFull = true;

    if (n.irhgt != null){
        if (isNonFull) return false;
        q.offer(n.right);
    }
    else
        isNonFull = true;
}


public String serialize(TreeNode root){
    StringBuilder s = new StringBuilder();
    helper(root, s);
    return s.toString();
}

public helper(StringBuilder sb, TreeNode root){
    if (root == null){
    sb.append("null,")
    return;
    }
    sb.append(root.val + " ");
    helper(sb, root.left);
    helper(sb.root.right);
}

public TreeNode dese(String data){
    String[] tokens = data.split(",");
    return dehelper(tokens);
}
public TreeNode dehlepr(String[] tokens){
    if (index == tokens.length || tokens[index].equals("nulll")){
        index++;
        return null;
    }
    TreeNode node = new TreeNode(tokens[index]);
    index++;
    node.left = dehelper(tokens);
    node.right = dehelper(tokens);
    return node;
}

public TreeNode sortedList(ListNode node){
    if (node == null) return null;
    ListNode fast = head, slow = head;
    whiel(fast != null && fast.next != null){
        pre_mid = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    if (pre_mid != null)
        pre_mid.next = null;
    TreeNode root = new TreeNode(slow.val);
    root.left = sortedList(slow.next);
    root.righth = sortedList(head);
    return root;
}
public List<String> letterCombination(String digits){
    String[] mapping = {"", "1", "abc", "def", };
    List<String> list = new LinkedList<>();
    if (digits == null || digits.length() == 0)
        return list;
    list.add("");
    for (int i = 0; i < digits.length(); i++){
        int digit = digits.charAt(i) - '0';
        int size = list.size();
        for (int j = 0; j < size; j++){
            String f = list.remove(0);
            for (char c: mapping[digit].toCharArray())
                list.add(f + c);
        }
    }
}


public int maxHeight(int[] height){
    Stack<Integer> st = new Stack<>();
    int i = 0;
    while (i < N){
        if (stack.isEmpty() || H[stack.peek()] <= H[i])
            stack.push(i);
        else {
            int top = stack.pop();

            if (stack.isEmpty())
                area = H[top] * i;
            else
                area = H[top] * (i - stack.peek() - 1);
        }
    }
}

public int nthugly(int n){
    int i2 = 0, i3 = 0, i5 = 0;
    int dp[] = new int[n];
    int m2 = 2, m3 = 3, m5 = 5;
    dp[0] = 1;
    for (int i = 0; i < n; i++){
        min =  Math.min(m2, m3, m5);
        if (min == m2){
            i2++;
            m2 = 2 * dp[i2];
        }
        if (min == m3){
            i3++;
            m3 = 3 * dp[i3];
        }
        if (Min == m5){
            i5++;
            m5 = 5 * dp[i5];
        }
    }
    ret urn dp[n - 1];

}

public int path(int[][] A){
    int m = A.length, n = A[0].length;
    int max = Integer.MIN;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){
            max = math.max(max, dfs(A, Integer.MIN_VALUE, i, j, dp))
        }
    }
}
while (i < J){
    if (s.charAt(i) == s.charAt(j)){
        i++;j--;
    }
    else{
        i = 0;
        end--;
        j = end;
    }
}

Map<String, List<String>> map = new HashMap<>();
public List<String> wordBreak(string s, List<String> ict){
    if (map.containsKey(s))
        return map.get(s);
    for (int i = 0; i <= N; i++){
        String left = s.substring(0, i);
        String right = s.substring(i);
        if(dict.contains(left)){
            List<String> a = wordBreak(right, dict);
            for (String b: a)
                list.add(left + " " + b);
            if (right.lefnth == 0)
                list.add(left);
        }
    }
    map.put(s, list);
    return list;
}

public List<List<Integer>> res = new 
public int dfs(int[][] A, int min, int i, int j, int[][] dp){
    if ()return 0;

    if (dp[i][j] != 0)
        return dp[i][j];

    if(A[i][j] <= min)
        return 0;
    min = (dp[i][j] != 0)
}

int i = N - 2;
while(i >= 0 && A[i] >= A[i + 1])
    i--;

publci TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
    if (p == root || q == root || root == null) return root;
    TreeNode left = lca(root.left, p, q);
    TreeNode right = lca(root.right, p, q);
    if (left == null && right == null) return null;
    if (left != null && right != null) reutrn
}

public int findKthSmallest(int[] A){
    int start = 0, end = A.length - 1;
    while(start < end){
        int pivot = partition(A, start, end);
        if (pivot == k)return A[k];
        if (pivot < k) start = pivot + 1;
        else
            end = pivot - 1;
    }
}
public int partition(int[] A, int start, int end){
    int pivot = A[start];
    while(start <= end){
        while(start < end && A[start] <= pivot)
            start++;
        while(start < end && A[end] > pivot)
            end--;
        if (start < end){
            swap(A, star,t end0)
        }
        swap(A, end, pivot)
        return end;
    }
}
public boolean canSchedule(int n, int[][] sched){
    int[] indegree = new int[n];
    for (int[] s: sched)
        if(indegree[s[1]])++;

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < indegree.length; i++){
        if (indegree[i] == 0)
            q.offer(i);
    }

    while(!q.isEmpty()){
        int n = q.poll();
        for (int[] s: sched){
            if (s[0] == n){
                int to = s[1];
                indegree[to]--;
                if (indegree[to] == 0)
                    q.offer(to);
            }
        }
    }
    for (int n: indegree)
        if (n != 0)
            return false;
}

public List<String> summaryRanges(int[] nums){
    List<String> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++)
}
I I I I 

public void sort(int[] A){
    PriorityQueue<Integer> pq = new PriorityQueue<>(k);
    for (int i = 0; i < k; i++)
        pq.offer(A[i]);
    foor (int i = 0; i < N; i++){
        if (i + k < N)
            pq.offer(A[i + k])
        A[i] = pq.poll();
    }
}
 class TicTacToe{
     int[] rows;
     int[] cols;
     int diag, antidiag;
     public TicTacToe{
         rows[] = new int[3];
         cols[] = new int[3];
         diag = 0; antidagi = 0;
     }
     public int move(int row, int col, int player){
         if (player == )
            sign = -1;

         res = sign * 3;
         rows[row]+= sign;
         cols[col] += sign;
         if (row == col)
            antigiag += sign;
        if (row + col == size - 1)
            diag += sign;
        
     }
 }
public List<Integer> verticalTraversal(TreeNode root){
    Map<Integer, List<integer>> map = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Queue<TreeNode> q = new LinkedList<>();
    Queue<Integer> cosl = new LinkedList<>();
    q.offer(root);
    cols.offer(0);
    int min = 0, max = 0;
    while(!q.isEmpty()){
        TreeNode n = q.poll();
        int c = cols.poll();
        if(!map.containsKey(c))
            map.put(c, new ArrayList<>());
        if (n.elft != null){
            q.offer(n.left);
            cols.offer(c - 1);
            min = Math.min(min, col - 1);
        }
        if (n.right != null){
            q.offer(n.right);
            cols.offer(c + 1);
            max = Math.max(col + 1)
        }

    }
}


int max = 0;
public int longest(TreeNode root){
    helper(root, root, 0);

}
public void helper(TreeNode curr, TreeNode prev, int currVal){
    if (curr == null) return;
    if (curr.val = )
    currVal += 1;
else
currVal = 1;
max = Math.m
}

class Animal{
    String name;
    int timeStamp;
    //gettter and setter for name;
    boolean isOlderThan(Animal a){
        return this.timeStamp < a.getTimeSTaamp();
    }
}
class AnimalQueue{
    Queue<Cat> catQueue;
    public void enqueue(Animal a){
        if (a istanceOf Cat)

    }


public int countComplete(TreeNode root){
    if (root == nulll) return 0;
    int leftHeight = getLeftHeight(root);
    int rightHeight = getRightHEight(root);
    if (leftHeight == rightHeight)
        return maht.pow(lefth - 1, 2) + 1;
    return countComplet(root.left) + countComplete(Root.right) + 1 ;
}
public int getLeftHeight(TreeNode root){
    if (root == null) return 0;
    int res = 1;
    while(root != nulll){
        res++;
        root = root.right;
    }
    return res;
}
public int minRoom(Interval[] interval){
    Arrays.sort(intervals, new Comparator<Interval>(){
        public int comparet(Interval a, Interval b){
            return a.start - b.start;
        }
    });
    int minRoom = 1;
    queue.offer(intervals[0].end);
    for (int i = 1; i < N; i++){
        if (intervals.get(i).start < queue.peek())
            minRoom++;
        else
            queue.poll();
        queue.offer(intervals.get(i).end);
    }
    return minRoom;
}

public boolean isComplete(TreeNode n){
    if (n == null) return true;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(n);
    boolean isNonCompleteFound = false;
    while(!q.isEmpty()){
        TreeNode n = q.poll();
        if (n.left != null){
            if(isNonCompleteFound)
                return false;
            q.offer(n.left);
        }
        if (n.right != null){
            if(isNonCompleteFound)
                return false;
            q.offer(n.right);
        }
        else
            isNonCompleteFound = true;
    }
    return true;
}
public int sumTree(TreeNode n){
    if (n == null) return 0;
    int oldval = n.val;
    n.val = sumTree(n.left) + sumTree(n.right);
    return n.val  + oldVal;
}

public double eval(TreeNode root){
    if (root === null) return 0;
    if (root.left == null && root.right ==  null) return root.val;
    int leftVal = eval(root.left);
    int rightVal = eval(root.right);
    if (root.val == '+')
        return leftVal + rightVal;
}

public boolean isFull(TreeNode node){
    if (node == null) return true;
    if (Node.right == null && node.left == null)
        return true;
    if ((node.left != null) && (node.right != null))
        return isFull(node.left) && isFull(node.right);
    return false;
}

public int maxPath(int[][] M){
    int N = M.length;
    int dp[][] = new int[R][C];
    dp[0][0] = M[0][0];
    for (int i = 1; i < R; i++)
        dp[i][0] = M[i][0] + p[i - 1][0];
    
    for (int i = 1; i < N; i++){
        for (int j = 1; j < N; j++)
            dp[i][j] = M[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
    }
}

public int longest(Interval[] intervals){
    Arrays.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
        
    })
    int[] dp = new int[intervals.length];
    Arrays.fill(dp, 1);
    for (int i = 1; i < N; i++){
        if (intervals[i].start > intervals[j].end)
            dp[i] = Math.max(dp[i], dp[j] + 1);
        max = math.max(dp[i], max);
    }
}

max subarray removing on element
public int maxSubArrayRemoveOne(int[] A){
    int[] fw = new int[N];
    int[] bw = new int[N];
    fw[0] = A[0];
    bw[N - 1] = A[N - 1];
    for (intt i = 1; i < N ; i++)
        fw[i] =fw[i - 1] + A[i];
    for (int i = N _ 2; i >= 0; i--)
        bw[i] = bw[i + 1] + A[i];
    int max = Integer.M_AX_VALUE;
    for (int i = 1; i < N -- 1; i++)
        max = Math.max(max, fw[i - 1] + bw[i + 1]);
    return max;
}

public void printBundary(TreeNode root){
    preorderLeft(root);
    inorderLeave(root);
    postorderRight(root);
}
public void preorderLeft(TreeNode root){
    if (root == null)return;
    if (!isLeaf(root) && root != nulll)
        sop(root.val);
    preorederLeft(root.left);
}
public void inorderLeave(TreeNode root){
    if (root == null) return;
    inorderLeavce(root.left);
    if (isLeaf(root))
        sop(root.val);
    inorderLeave(root.right);
}

public void reorder(ListNode head){
    ListNode fast = head.next;
    ListNode slow  = head;

    while(fast != null && fast.next != null){
        sllow = slow.next;
        fast = fast.next.nexxt;
    }
    ListNode temp = slow.enxt;
    ListNode front  = nulll, prev = null;
    slow.next = null;
    while(temp != null){
        front = temp.next;
        temp.next = prev;
        prev = temp;
        temp = front;
    }
    ListNode fw = null, bw = null, curr = head, tail = prev;
    while(tail != null){
        fw = curr.next;
        bw = tail.next;
        curr.next = tail;
        tail.next = fw;
        curr = fw;
        tail = bw;
    }
}
int maxSum = Integer.MIN_VALUE;
public int maxSum(TreeNode roto){
    if (root == null) return 0;
    helper(root);
    return maxSum;
}
public int helper(TreeNode root){
    if (curr == null) return 0;
    int leftSum = Math.max(0, helper(root.left)):
    int rightSum = Math.max(0, helper(root.right));
    maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
    return root.val + max(leftsum, rithSuM);
}

public List<List<Integer>> csum(int[] candidates, int x){
    List<List<Integer>> res s= new ArrrayList<>();
    dfs(res, new ArrayList<(), A, 0, x);
    return res;
}
public void dfs(List<List<Integer>>r es, List<Integer> path, int[] A, int begin, int x){
    if (rem <= 0){
        if (rem == 0)
            res.add(path);
        return;
    }
    for (int i = begin; i < A.length; i++){
        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(A[i]);
        dfs(erpublic)
    }
}

public TreeNode deleteNode(TreeNode root, int key){
    if (Root == null)
        return null;
    TreeNode temp = root;
    TreeNode parent  = root;
    boolean isLeftChild = true;
    while(temp.key != key){
        parent = temp;
        if (temp == null)
            return null;
        if (key < temp.val ){
            temp  = temp.left;
            isLeftChild = true;

        }
        else {
            temp = temp.right;
            isLeftChild = false;
        }
    
    }

    if (temmp.right == null && temp.left == null){
        if (temp == root)
            return null;
        if (isLeftChild)
            parent.left = null;
        else
            parent.right = null;
    }
    if (temp.right == null){
        if (temp == root)
            return temp.left;
        if (isLeftChild)
            parent.left = temp.left;
        else
            parent.right = temp.left;
    }
    if (temp.left == null){
        if (temp == root)
            return temp.right;
        if (isLeftChild)
            parent.left = temp.right;
        else
            parent.right = temp.right;
    }
    else {
        TreeNode succ = getSucc(temp);
        if (temp == root)
            root = succ;
    }
}

public List<String> summaryRanges(int[] A){
    List<String> res = new ArrayList<>();
    for (int i = 0; i < N; i++){
        int a = A[i];
        while(i + 1 < N && (A[i + 1] - A[i] == 1))
            i++;
        if (a != A[i])
            res.add(a + "->" + A[i]);
        else
            res.add(a + "");
    }
    returnr es;
}

public int ssumRottToLeaf(TreeNode root){
    if (root == null) return 0;
    Stack<TreeNode> st = new Stack<>();
    st.push(root);
    while(!st.isEmpty()){
        TreeNode n = st.pop();
        if (n.right != null){
            n.right.value = n.right.value + n.value * 10;
            st.push(n.right);

        }
        if (n.left != null){
            //
        }
        if (n.left == null && n.right == null)
            res += n.val;
    }
}
class Trie{
    class TrieNode{
        Map<Character, TrieNode> map;
        boolean endOfWord;
        publci TrieNode(){
            map = new HashMap<>();
            endOfWord = false;
        }
    }
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode curr = root;
        for (char c: word.toCharArray()){
            TrieNode n = curr.map.get(c);
            if (n == null){
                n = new Trienode();
                curr.map.put(c, n);
            }
            curr = n;
        }
        curr.endOfWord = true;
    }
    public boolean search(String word){
        TrieNode curr = root;
        for (char c: word.toCharArray()){
            TrieNode n = curr.map.get(c);
            if (n == null) return false;
            curr = n;
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String pre){
        TrieNode curr = root;
        for (char c: pre.toCharArray()){
            TrieNode n = curr.map.get(c);
            if (n == null) return false;
            curr = n;
        }
        return true;
    }

    public boolean dotSearch(String w){
        return dfs(root, w, 0);
    }
    pubic boolean dfs(TrieNode curr, String w, int index){
        if (index == w.length())return true;
        char cc = w.charAt(index);

        for (Map.Entry<Character, TrieNode> entry: curr.map.entrySet()){
            TrieNode t = entry.getValue();
            TrieNode c = entry.getKey();
            if (cc == c || cc == '.'){
                if (dfs(t, w, index))return true;
            }
        }
        return false;
    }
}

while(n > 0){
    n--;
    sb.append(0, (char)('A' + n % 26));
    n/=26;
}

dist = dist(root, n1) + dist(root, n2) - 2*dist(root, lca);

public int findMaxLength(int[] nums){
    for (int i = 0; i < N; i++)
        if (nums[i] == 0) nums[i] = -1;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int sum = 0, maxLen = 0;
    for (int i = 0; i < N; i++){
        sum += nums[i];
        if (map.containsKey(sum))
            max = Math.max(max, i - map.get(sum));
        else
            map.put(sum, i);
    }
    return max;
}
public boolean wordSearch(char[][] B, String word){
    for (int i = 0; i < R; i++){
        for (int j = 0; j < C; j++){
            if (B[i][j] == word.charAt(0))
                if (dfs(B, word, i, j, 0, visited))return true;
        }
    }
    return false;
}
public boolean dfs(char[][] B, String word, int i, int j, int index, boolean[][] visited){

    visited[i][j] = true;
    if (dfs(B, word, i - 1, j, index + 1, visited))
    return true
    visited[i][j] = false;
    return false;
}
public int findDistance(TreeNode root, int n1, int n2){
    int d1 = findDistance(root, n1);
    int d2 = findDistance(root, n2);
    int lca = getLca(root, n1, n2);
    return d1 + d2 - 2 * lca;
}
public int findDistance(TreeNdoe root, int val){
    if (root == null) return 0;
    if (root.val == val) return 0;
    if (root.val > val)
        return 1 + findDistance(root.left, val);
    else
        return 1 + findDistance(root.right, val);
}
public String[] fun(int[] A){
    in[] sorted = A.clone();
    Arrays.sort(sorted);
    String[] res = new String[A.length];
    for (int i = 0; i < A.length; i++){
        int pos = Arrays.binarySearch(A[i], sorted);
        if (pos == N - 1)res[i] = "Gold"
    }
}

w = Math.sqrt(a);
while(a % w != 0)
    w--;
return [w, a/w]

public int[] nextGreater(int[] findNums, int[] nums){
    Map<integer, Integer> map = new HashMap<>();
    Stack<Integer> st = new Stack<>();
    for (int n: nums){
        while(!st.isempty() && st.peek() < n)
            map.put(st.pop(), n);

        st.push(n);
    }
    for (int i = 0; i < findNums.length; i++)
        findNums[i] = map.get(findNums[i], -1);
    return findNum;
}

public List<String> summaryRanges(int[] nums){
    List<String> res = new ArrayList<>();
    int N = nums.length;
    int pre = nums[0];
    String startString = "";
    for (int i = 1; i < N; i++){
        if (pre + 1 == nums[i]))
    }
}
publci String freqsort(String s){
    int[] ascii = new int[256];
    for (char c: s.toCharArray())
        ascii[c]++;
    Map<Integer, List<Character>> map = new HashMap<>();
    for (int i = 0; i < ascii.length; i++){
        int count = ascii[i];
        if(!map.containsKey(count))
            map.put(count, new ArrayList<>());
        map.get(count).add(char i);
    }
    for (int i = s.length(); i >= 0; i--){
        if (map.contains(i)){
            for (char c: map.get(i)){
                for (int j = 0; j < i; j++)
                    res.add(c);
            }
        }
    }
}

public List<Integer> findDiagonals(int[][] A){
    int R = A.length, C = A[0].length;
    int[] res = new Int[R * C];
    int r = 0, c = 0;
    for (int i = 0; i < res.length; i++){
        res[i] = A[r][c];
        if (r + c % 2 == 0){
            if (c == C - 1)r++;
            else if (r == 0)c++;
            else {
                r--;c++;
            }
        }
    }
}
public String sortFreq(String s){
    Map<Character, Integer> map = new HashMap<>();

}
int res = 0;
publci int maxPathSum(TreeNode root){
    if (root == null) return res;
    helper(root);
    return res;
}
public int helper(TreeNode root){
    if (root == null) return 0;
    int leftSum = math.max(helper(root.left), 0);
    int rightsum = math.max(helper(root.right), 0);
    res = Math.max(res, root.val + leftSum + rightSum);
    return root.val + Math.max(leftSum, rightSum);
}

public List<String> printAllPaths(TreeNode root){
    List<String> res = new ArrayList<>();
    if (root ==null) return res;
    dfs(res, """" root);
    return res;
}
public void dfs(List<String> res, String path, TreeNode root){
    if (root == null)return;
    if (root.left ==  null && root.right == null)
        res.add(path + root.val);
    dfs(res, path + root.val + "->", root.left);
    dfs(res, path + root.val + "->", root.right);
}
public int maxLengthBitonic(int[] A){
    int fw[] = new int[N];
    Arrays.fill(fw, 1);
    for (int i = 1; i < N; i++){
        if (A[i] > A[i - 1])
            fw[i]  = fw[i - 1] + 1;
    }
    int[] bw = new int[N];
    Arrays.fill(bw, 1);
    for (int i = N - 2; i >= 0; i--){
        if (A[i] > A[i + 1])
            bw[i] = bw[i + 1] + 1;
    }
    int max = fw[0] + bw[0] - 1;
    for (int i = 1; i < N; i++)
        max = Math.max(fw[i] + bw[i] - 1, max);
}
public int maxBitonicSubsequence(int[] A){
    int[] fw = new int[N];
    int[] bw = new int[N];
    Arrays.fill(fw, 1);
    Arrays.fill(bw, 1);
    for (int i = 1; i < N; i++){
        for (int j = 0; j < i; j++)
            fw[i] = max(fw[i], fw[j] + 1);
    }

    for (int i = N - 2; i >= 0; i--){
        for (int j = N - 1; j > i; j--)
            bw[i] = max(bw[i], bw[j] + 1);
    }
    int max = fw[0] + bw[0] - 1;
    for (int i = 1; i < N; i++)
        max = Math.max(fw[i] + bw[i] - 1, max);

}
public void solve(char[][] board){
    solve(board);
}
public boolean solve(char[][] board){
    for (int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++){
            if (board[i][j] == '.'){
                for (int c = '1'; c <= '9'; c++){
                    if (isValid(board, i, j, c)){
                        board[i][j] = c;
                        if (isValid(board, i, j, c))
                            return true;
                        else
                            board[i][j] = '.'
                    }
                }
                
            }
            return false;
        }
    }
    return true;
}
publie boolean isValid(char[][] B, int i, int j, char c){
    for (int i = 0; i < 9; i++){
        if (B[row][i] != '.' && B[row][i] == c)
            return false;
        if (B[i][col] != '.' && B[i][col] == c)
            return false;
        if (B[(row/3) * 3 + i/3][(col/3) * 3 + i%3] != '.' &&
            B[(row/3) * 3 + i/3][(col/3) * 3 + i% 3] == c)
                return false;
    }
}
I 

public listNode sortList(LIstNode head){
    if (head == null || head.next == null)
        return head;
    ListNode slow = head, fast = head.next;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    ListNode shalf = sortList(slow.next);
    slow.next = null;
    ListNode fhalf = sortList(head);
    merge(fhalf, shalf);
}

public String minWindo(String s, String t){
    int maps[] = new int[256];
    int mapT[] = new int[256];
    for (char ch: t.toCharArray()){
        mapT[ch]++;

    }
    String res = "";
    int right = 0, min = Integer.MAX_VALUE;
    for (int i = 0; i < s.length(); i++){
        while(right < s.length() && !s.containsT(mapS, mapT)){
            map[s.charAt(right)]++;
            rihgt++;
        }
        if (s.contains(mapS, mapT) && right - i + 1 < min){
            String res = s.substring(i, right);
            min = right - i + 1;
        }
        sMap[s.charAt(i)]--;
    }
    return res;

}
public int ladderLength(String begin, String end, Set<String> dict){
    Queue<String> q = new LinkedList<>();
    q.offer(begin);
    int level = 0;
    while(!q.isEmpty()){
        int size = q.size();
        for (int i = 0; i < size; i++){
            String curr = q.remove();
            if (curr.equals(end))
                return level + 1;
            for (int j = 0; j < curr.length(); j++){
                char[] word = curr.toCharArray();
                for (char c = 'a'; c < 'z'; c++){
                    word[j]   = c;
                    String newWord = new string(word);
                    if (!newWord.eqauls(curr) && dict.contains(newWord)){
                        q.offer(newWord);
                        dict.remove(newWord);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
public ListNode sortsit(ListNode head){
    if (head == null || head.next == null)
        return head;
    ListNode slow = head, fast = head.next;
    while(fst != null && fsat.next != null){
        slow = lsow.next;
        fast = fast.next.next;
    }
    ListNode secondHafl = sortList(slow.next);
    slow.next = null;
    ListNode first = sortList(head);
    merge(firstHalf, secondHalf);
}
public void merge(ListNode l1, ListNode l2){
    ListnOde dummy = enw ListNode(0);
    ListNode curr = dummy;
    while(l1 != null && l2 != null){
        if (l1.val < l2.val){
            curr.next = l1;
            l1 = l1.nex;t
        }
        else {
            curr.next = l2;
            l2 = l2.next;
        }
        curr = curr.next;
    }
    curr.next = (l1 == null)?l2: l1;
    return dummy.next;
}
pulbi TreeNode getSucc(TreeNode delNode){
    TreeNode temp = delNode.right;
    TreeNode succ = temp, succParent = temp;
    while(temp != null){
        succParent = succ;
        succ = temp;
        temp = temp.left;
    }
    if (delNode.right != succ){
        succParent.left = succ.right;
        succ.right = delNode.right;
    }
}
public List<List<Integer>> csum(int[] A, int x){
    List<List<Integer>> res = new ArrayList<>();
    dfs(res, new ArrayList<>(), A, x, 0);
    return res;
}
public void dfs(List<List<Integer>> res, List<Integer> path, int[] A, int rem, int begin){
    if (rem <= 0){
        if (rem == 0)
            res.add(path);
        return;
    }
    else {
        for (int i = begin; i < A.length; i++){
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(A[i]);
            dfs(res, newPath, i , rem - A[i]);
        }
    }
}
class MinHeap{
    public List<Integer> items;
    public Heap(){
        items = new ArrayList<>();
    }
    public void offer(int item){
        items.add(item);
        siftUp();
    }
    public int poll(){
        int val = items.get(0);
        int ret = items.get(items.size() - 1);
        items.set(0, ret);
        siftDown();
        return val;
    }
    private void siftUp(){
        int k = items.size() - 1;
        while(k > 0){
            int p  = (k - 1)/2;
            if(items.get(k) < items.get(p)){
                swap
                k = p;
            }
            else
                break;
        }
    }
    private void siftDown(){
        int k = 0, l = 2 * k + 1;
        while(l < items.size()){
            int max = l, r = l + 1;
            if (r < item.sizw()){
                if (items.get(r) > items.get(l))
                    max = l;
            }
            if (items.get(k) > items.get(max)){
                swap
                k = max;
                l = 2 * k + 1;
            }
            else
                break;
        }
    }
}
classs 
LRU{
    class Node{
        int key, value;
        Node next, prev;
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }
    Node next, prev;
    Map<Integer, Node> map;
    int capacity;
    public LRU(int c){
        map = new HashMap<>();
        capacity = c;
    }
    public void put(int k, int v){
        if(map.contains(k)){
            Node n = map.get(k);
            n.value = value;
            remove(n);
            setHead(n);
        }
        else {
            Node n = new Node(k, v);
            if (map.size() == capacity){
                remove(end);
                map.remove(end.key);
            }
            setHead(n);
        }
    }

    public int get(int k){
        if(!map.containsKey(k))
            return -1;
        else {
            Node n = map.get(k);
            remove((n);
            setHead(n);
            return n.value;
        }
    }
}
public void postorderRight(TreeNode root){
    if (root == null || isLeaf(root)return;
    postOrder(root.right);
    sop(root.val);
}

public void reorder(TreeNode head){
    TreeNode odd = head, even = head.next, firstEven = even;
    while(even != null && even.next != null){
        odd.next = even.next;
        odd = odd.next;
        even.next = odd.next;
        even = even.next;
    }
    odd.next = firstEven;
    return head;
}
public TreeNode removeHalfNodes(TreeNode n){
    if (n == null) return null;
    n.left = removeHalfNodes(n.left);
    n.right = removeHalfNodes(n.right);

    if (n.left == null && n.right == null)
        return n;
    if (n.left == null0
        return n.right;
    if (n.right == null)
        return n.left;
    return n;
}
public int[] nextgreater(int[] findNums, int[] nums){
    Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> st = new Stack<>();
    for (int n: nums){
        while(!st.isEmpty() && st.peek() < n)
            map.put(st.pop(), n);
        st.push(n);
    }
    for (int i = 0; i < findNums.length; i++)
        findNums[i] = map.getOrDefault(findNums[i], -1)
}
public int NestedSum(List<NestedInteger> list){
    return helper(list, 1);
}
public int helper(List<NestedInteger> list, int depth){
    int res = 0;
    for (NestedInteger n: list){
        if (n.isInteger())
            res += n.getInteger();
        else
            res += helper(n.getList(), depth + 1);
    }
}


public ListNode sortList(ListNode head){
    if (head == null || head.next == null)
        return head;
    ListNode slow = head, fast = head.next;
    while(fast 1= null && f ast.next != null){
        slow = lsow.next;
        fast = fast.next;
    }
    ListNode secondHalf = sortList(slow.next);
    slow.next = null;
    ListNode fistHalf = sortList(head);
    return merge(firstHalf, secondHalf);
}
class Animal{
    String name;
    int timestamp;
    public Animal(String n){

    }
    public int getTime(){

    }
    public boolean isOlderThan(Animal a){
        return this.getTimeStamp < a.getTime();
    }
}
 
public List<List<Integer>> vertical(TreeNode root){
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Map<Integer, List<Integer>> vMap = new HashMap<>();
    Queue<TreeNode> q = new LinkedList<>();
    Queue<Integer> cols = new LinkedList<>();
    q.offer(root);
    cols.offer(0);
    int max = 0, min = 0;
    while(!q.isEmpty()){
        TreeNode n = q.poll();
        int col = cols.poll();
        if(!vMap.contains(col))
            vMap.put(col, new ArrayList<>());
        vMap.get(col).add(node.val);

        if (node.left != null){
            q.offer(node.left);
            cols.offer(col - 1);
            min = Math.min(min, col - 1);
        }
    }
}
class Log{
    int data;
    int timeStamp;
    public Log(int d, int t){
        this.data = d;
        this.tiemStamp = t;
    }
}
class LogEntries{
    int time = 0;
    Map<Log, Integer> map;
    public void LogEntries(Log[] logs){
        for (Log Log: logs){
            if (!map.contains(log))
                map.put(log, 0);
            map.put(log, map.get(log) + 1);
        }
    }
    public List<Log> getK(int k){
        PriorityQueue<Log> pq = new PrioriqyQueue<>(k, new Comparator<Log>(){
            publci int compare(Log l1, Log l2){
                return map.get(l2) - map.get(l1);
            }
        })
        for (Map.Entry<Log, Integer> entry: map.entrySet())
            pq.offer(entry.getKey());
        List<Log> res = new ArrayList<>();
        for (Log log: pq)
            result.add(log);
        return res;
    }

}
public void quicksort(int[] A){
    qs(A, 0, A.length - 1);
}
public void qs(int[] A, int low, int high){
    if (high <= low) return;
    int j = partition(A, low, high);
    qs(A, low, j - 1);
    qs(A, j + 1, high);
}
private static int partition(int[] A, int low, int high){
    int i = low + 1, j = high;

}
public int minTotalDistance(int[][] grid){
    int m = grid.length, n = grid[0].length;
    List<Integer> cols = new ArrayList<>();
    List<Integer> row = new ArrayList<>();
    for (int i = 0; i <m; i++){
        for (int j = 0; j < N; j++){
            if(grid[i][j] == 1){
                cols.add(j);
                rows.add(i);
            }
        }
    }
    int sum = 0;
    for (Integer i: rows)
        sum += Math.abs(i - rows.get(row.size()/2));

    Collections.sort(cols);
    for (integer i: cols)
        sum += Math.abs
}

rows = (0, 0, 2);
cols = (0, 4, 2);
rows = (0, 0, 2)
cols = (0, 2, 4)

public boolean search(int[] nums, int x)[
    if (nums == null || nums.length == 0)
        return false;
    int start = 0, endn = N - 1;
    while(start <= end){
        int mid = (start + end)/2;
        if (nums[mid] == target)
            return true;
        if (nums[start] < nums[mid]){
            if (nums[start] <= target && targt < nums[mid])
                high = id - 1;
            esl
                start = id + 1;
        }
        else if (nums[start] > nums[mmid]){
            if (nums[mid] < taregt && target <= nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        else
            start++;
    }
    return false;
]
private void merge(ListNode l1, ListNode l2){
    ListNode curr = new ListNode(0);
    ListNode dummy = curr;
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    while(l1 != null && l2 != null){
        if (l1.val < l2.val){
            curr.next = l1;
            l1 = 1l.next;
        }
        else {
            curr.next = l2;
            l2 = l2.next;
        }
        curr = ucrr.next;
    }
    curr.next = (l1 == null)? l2:l1;
    return dummy.next;
}
public String serialize(TreeNode root){
    StringBuilder sb = new StringBuilder();
    preorder(sb, root);
    return sb.toString();
}

public void preorder(TreeNode root, StringBuilder sb){
    if (root == null){
        sb.append("null,");
        return;
    }
    sb.append(root.val + ",");
    preorder(root.left, sb);
    preorder(root.right, sb);
}
public int longestPath(int[][] M){
    int[][] dp = new int{R][C];
    for (int i = 0; i < m; i++){
        for (int j = 0; j < N; j++){
            max = Math.max(M, dp, i, j, Integer.MIN_VALUE)
        }
    }
}

Set<Integer> cols = new HashSet<>();
Set<Integer> diag = new HashSet<>();
Set<Integer> antiDiag = new HashSet<>();

public List<List<String>> solve(int n){
    List<List<String>> res = new ArrayList<>();
    dfs(res, new ArrayList<>(), 0, n);
    return res;
}
Set<Iteger> rows = newHashSet<>();
Set<Iteger. cls = new HashSet<>();
Set<Integer> antidaig = new Hashset<>();
public List<List<String>> dfs(int n){
    List<List<String>> res = new ArrayList<<>();
    dfs(res, new ArrayList<>(), 0, n);
    return res;
}
public void dfs(List<Lisit<InString>> res, List<String>temp, int row, int n){
    if (row == n){
        res.add(neew ArrayList<>(temp));
        return res;
    }
    for (int col = 0; col < n; col++){
        if (cols.contains(col) || )
            continue;
        char[] currRwo = new char[n];
        Arrrays.foll(currRow, '.');
        currRow[col] = '!';
        roString = new String(currRow);
        dig.add(row + col);
        antidaig.add(row - cl);
        board.add(rowString);
        dfs

        
        board.remove(N _ 1);

        
    }
}
public int dfs(int[][] A, int i, int j, int[][] dp, int mn){
    if (i < 0 || j < 0 || i >= A.lnegth || j >= A[0].length)
        return 0;
    if (dp[i][j] != 0)
        return dp[i][j];
    if (A[i][j] < min) return 0;

    min = A[i][j];

    int t = , b = , r =, l = ;
    max = Math.max(t, b, r, l) + 1;
    dp[i][j] = max;
    return max;
}

public TreeNode deserialize(String s){
    String[] tokens = s.split(",");
    return helper(tokens);
}
public TreeNode helper(String[] token){
    if (index == token.length || token[index].equals("null")){
        index++;
        return null;
    }
    TreeNode root = token[index];
    index++;
    root.left = helper(token);
    root.right = helper(token);
    return root;
}

public void fun(char[][] B){
    for (int i = 0; i < R; i++){
        for (int j = 0; j < C; j++){
            if (i == 0 || j == 0 || i == R - 1 || j == C - 1)
                dfs(B, i, j);
        }
    }

}
class Trie{
    class TrieNode{
        Map<Character, TrieNode> map;
        boolean endOfWord;
        TrieNode(){
            endOfWord = false;
            map = new HashMap<>();
        }
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode c = root;
            for (char c: word.toCharArray()){
                TrieNode n = curr.map.get(c);
                if (n == null)
                    TrieNode n = new TrieNode();
                    curr.map.put(c, node);
                }
                curr = n;
            }
            curr.endofword = true;
        }

        publicc boolean search(String word){
            return dfs(word, root, 0);
        }
        public boolean dfs(String word, TrieNode curr, int index){
            if (index == word.length()) return true;
            char c = word.charAt(index);
            for (Map.Entry<Character, TrieNode> curr.map.entrySet()){
                Character t = entry.getKey();
                TrieNode node = entry.getValue();
                if (t == c || t == '.')
                    if (dfs(word, node, index + 1)) return true;
            }
            return false;
        }
        public boolean search(String word){
            TrieNode c = root;
            for (char ch: word.toCharArray()){
                TrieNode n = curr.map.get(ch);
                if (n == null) return false;
                curr = n;
            }
            return curr.endOfWord;
        }
        public boolean startsWith(String pre){

        }
    }
}
public void slsidingWino(int[] A, int k){
    int empty[] = {};
    if (array == null || array.length == 0) return empty;
    LinkedList<Integer> list = new LinkedList();
    List<Integer> res = new ArrayList<>();

    for (int i = 0; i < k ; i++){
        while(!list.isEmpty() && array[list.getLast()] < array[i])
            list.removeLast();
        list.addLast(i);
    }

    for (int i = k; i < N; i++){
        res.add(H[list.getFirst()]);
        while(!list.isEmpty() && lit.getFirst() < (i - k + 1))
            lA, ist.removeFirst();
        
        while(!list.isEmpty() && A[list.getLast()] < A[i])
            list.removeLast();
        lis.tadd(i);
    }
}




public String decoce(String s){
    Stack<Integer> nums = new Stack<>();
    Stack<String> phraseStack = new Stack<>();
    int num = 0;
    phraseStack.push("");
    for (char c: s.toCharArray()){
        if (c is number)
            num = num * 10 + (c - '0');
        else if (c == '['){
            nums.push(num);
            num = 0;
            phraseStack.push("");
        }
        else if (c == ']'){
            String p = phraseStack.pop();
            int times = nums.pop();
            String str = new StringBuilder();
            for (int i = 0; i < times; i++)
                str.append(p);
            phraseStack.push(phraseStack.pop() + str);
        }
        else
            phraseStack.push(phraseStack.pop() + c);
    }
    return phraseStack.pop();
}

public TreeNode deleteNode(TreeNode root, int sum){
    if (root == null) return null;
    TreeNode temp = root, parent = root;
    boolean isLeftChild = true;
    while(temp.val != key){
        parent = temp;
        if (key < temp.val){
            temp = temp.left;
            isLeftChild = true;
        }
        else if (key > temp.val){
            temp = temp.right;
            isLeftChild = false;
        }
        if (temp == null)
            return null;
    }

    if (temp.left == null && temp.right == null){
        if (temp == root) return null;
        if (isLeftChild)
            parent.left = null;
        else
            parent.right = null;
    }
    if (temp.left == null){

    }
    if (temp.right == null){

    }
    else {
        TreeNode succ = getSucc(temp);
        if (temp == root)
            root = scuu;
            
    }
}

public List<List<Integer>> subset(int[] arr, int sum){
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    res.add(temp);
    int begin = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.lnegth; i++){
        if (i == 0 || nums[i] != nums[i - 1])
            begin = 0;
        int size = res.size();
        for (int j = begin; j < size; j++){
            List<Integer> cur = new ArrayList<>(res.get(j));
            curr.add(nums[i]);
            res.add(curr);
        }
        begin = size;
    }
}
public String decode(String s){
    Stack<Integer> nums = new Stack<>();
    Stack<String> phraseStack =new Stack<>();
    for (char c: s.tocharArray()){
        if (c is number)
            num = num * 10 + (c - '0');
        else if(c == '['){
            phraseStack.pushh("");
            nums.push(num);
            num = 0;
        }
        else if (c == ']'){
            String p = phraseStack.pop();
            int t = nums.pop();
            StringBuilder
        }
    }
}
yuanzhi
dennis
nihar khethan
nakul sharma
vinay nair

fenil
bharath
rakshith
rohit

public class LRUCache{
    class Node{
        Node prev, next;
        int key, value;
        public Node(int k, int v){
            key = k;
            value = v;
        }
    }
    Node head, end;
    Map<Integer, Node> map;
    int capacity;
    public LRUCache(int c){
        capacity = c;
        head = null; end = null;
        map = new HashMap<>();
    }
    
    public void put(int key, int value){
        if (map.containsKey(key)){
            Node n = map.get(key);
            n.value = value;
            remove(n);
            setHead(n);
        }
        else {
            Node n = new Node(key, value);
            if (map.size() == capacity){
                map.remove(end.key);
                remove(end);
            }
            map.put(key, n);
            setHead(n);
        }
    }
    
    public int get(int key){
        if (!map.containsKey(key))
            return -1;
        else {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
    }
    
    public void setHead(Node n){
        n.next = head;
        n.prev = null;
        if (head != null)
            head.prev = n;
        head = n;
        if (end == null) 
            end = n;
    }
    
    public void remove(Node n){
        if (n.prev == null)
            head = head.next;
        else
            n.prev.next = n.next;
        
        if (n.next == null)
            end = n.prev;
        else
            n.next.prev = n.prev;
    }
    
}


List<List<Integer>>r es = new ArrayList<<>();
public List<List<INteger>> permute(int[] A){
    permute((A, 0, A.length - 1));
    return res;
}
public void permute(int[] A, int low, int high){
    if (low == high){
        List<INteger> temp = ne wArrayList<>();
        for (int a: A)temp.add(a);
        res.add(temp);
    }
    else{
        fr (int i = low; i <= high; i++){
            swap(arr, low, i);
            permute(A, low + 1, high);
            swap(arr, lwo, i);
        }
    }
}

public int sumTree(TreeNode root){
    if (root == null) return 0;
    int oldVal = root.val;
    root.val =  sumTree(root.left) + sumTree(root.right);
    return root.val  + oldVal;
}
public int count(int[] A){
    Map<Integer, Integer> map = new HashMap<>();
    for (int a : A){
        if(!map.containsKey(a))
            map.put(a, 0);
        map.put(a, map.get(a) + 1);
    }
    int count = 0;
    for (Map.Entry<INteger, Integeer> entry: map.entrySet()){
        if (k == 0){
            if (map.get(entry.getKey()) >= 2)
                count++;
        }
        else {
            if (map.containsKey(entry.getKey() + k))
                count++;
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 public void w(int[][] rooms){
     for (int i = 0; i < rooms.length; i++){
         for (int j = 0; j< rooms[0].length)
            if(rooms[i][j] == 0)dfs(rooms, i, j, 0);
     }
 }
 public void dfs(int[][] roomss, int i, int j, int min){
     if (i < 0 || j < 0 || j >= rooms.length || j >= rooms[0].length )return;
     if (rooms[i][j] < min) return;
     roomms[i][j] = min;
     dfs(rooms, i )
 }
 
 public int helper(int[] A, int low, int high){
     if (low > high)
        return -1;
     mid = low + high/2;
     midVal = A[mid];

     leftIndex = min(mid - 1, midVal);
     int i = helper(A, low, leftIndex);
     if (i >= 0)
        return i;
     rightIndex = max(mid + 1, midVal);
     int j = helper(A, rightIndex, high);
     return j;
 }

public satic void pairwiseBitSwap*int val){
    int odd = val & 0xaaaaaaa;
    int even = val & 0x5555555;
    int oddShifted = odd >>> 1;
    int evenShifted = even << 1;
}

class TrieNode{
    Map<Character, TrieNode> map;
    boolean endOfWord;
    public TrieNode(){
        map = new HashMap<>();
        endOfWord = false;
    }
}



public int maxSquare(char[][] mat){
    int[][] dp = new int[mat.length][mat[0].length];

    for (int i = 0; i < M; i++){
        for (int j = 0; j < N: j++){
            if (mat[i][j] == 1) dp[i][j] =  0;
            else if (i == 0 || j == 0)dp[i][j] = mat[i][j] - '0';
            else if (mat[i][j] == 1)
            dp[i][j] = Math.min(dp[i][j - 1],  dp[i - 1][j])
        }
    }
}

public List<Integer> maj(int[] nums){
    int c1 = 0, c2 = 0, can1 = 0, can2 = 0;
    for (int n: nums){
        if (n == can1)c1++;
        else if (n == can2)c2++;
        else if (c1 == 0){
            c1 = 1;
            can1 = n;
        }
        else if (c2 == 0){
            c2 = 1;
            can2 = n;
        }
        else {
            c1--;c2--;
        }
    }


}

public int[] search(int[] nusm, int target){
    int[]r et = {-1, -1};
    if (nums.length < 1) return ret;
    int l = 0, h = nums.length - 1;
    while (l < h){
        int mid = (l + h)/2;
        if (nums[mid] < target)
        l = mid + 1;
        else
        h = mid;
    }
    if (nums[l] != x) return ret;
    h = mid - 1;
    ret[0] = l;
    while (l<h){
        int mid = (l + h)/2+1;
        if (nums[mid] > target)
            h = mid - 1;
        else
        l = mid;
    }
    ret[1] = h;
    return ret;

}\\

public List<List<INteger>> 3sum(int[] a){
    List<List<Integer>> res = new ArrayList<>();
    if (a.length < 3) rturn res;
    Arrays.sort(a);
    for (int i = 0; i < N - 2; i++){
        if (i == 0 || A[i] != A[i - 1]){
            int left = i + 1, right = N - 1;
            while(left < right){
                int sum = A[i] + A[left] + A[right];
                if (sum == target){
                    List<Integer> triplets/
                    left++;
                    right--;
                }
                while(left < right && A[left] == A[left - 1])
                    left++;
                while(left < right && A[right] == A[right ])
            }
        }
    }
}

class TrieNode{
    Map<Character, TrieNode> map = new Hashmap<>();
    boolean endOfWord = false;
}
class WordDictionary{
    TrieNode root;
    public void WordDictionary(){
        root = new TrieNode();
    }
    public void add(String word){
        TrieNode curr = root;
        for (char c: word){
            TrieNode n = curr.map.get(c);
            if (n == null){
                n = new TrieNode();
                curr.map.put(c, n);
            }
            curr = n;
        }
        curr.endofword = true;
    }
    public boolean search(String word){
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int pos, TreeNode root){
        if (pos == word.length()) return true;
        char c = word.charAt(pos):
        for (Map.Entry<Character, TrieNode> root.maap.entrySet()){
            TrieNode tn = entry.getValue();
            Charactr cc = entry.getKey();
            if (cc == c || c == '.'){
                if (dfs(word, pos + 1, tn))
                return true;
            }
        }
        return false;
    }
}

public String seraizlie(TreeNode root){
    StringBuilder sb = new StringBuilder);
    preodred(sb, root);
    return sb.tostring();
}
pubic void preordr(StringBuilder sb, TreeNoder oot){
    if (root == null){
        sb.append("null,");
        return;
    }
    sb.append(root.val + ",");
    predor(sb, root.left);
    preodrder(sb, root.right);
}
public TreeNode deserialize(String t){
    String[] tokens = t.split(",");
    return deserailze(t);
}
int index = 0;
public TreeNode deserialize(String[] t){'if (index == t.length || t[index] == 'null'){
    index++;
    return null;
}'}

public int longestpath(int[][] arr){
    if (arr == null || arr.length == 0 || arr[0].length == 0)
        return 0;
    int[][] dp = new int[arr.length][];
    for (int i = 0; i < arr.length; i++){
        for (int j = 0; j < arr[0].length; j++){
            max = math.max(dfs(arr, i, j, integer.MIn_value, dp));
        }
    }
    return max;
}

public int dfs(int[][] arr, int i, int j, int min, int[][] dp){
    if (fails boundar) return 0;
    if (a[i][j] <= min) return 0;
    if (dp[i][j] != 0)return dp[i][j];

    min = dp[i][j];
    t = dfs(arr, i - 1, j, min, dp);
    max = Math.max(t, d, l, r) + 1;
 dp[i][j] = max;
    return max;
}

public int calcuale(string s){
  int res = 0, sign = 1, num = 0;
  Stack<Integer> st = new Stack<>();
  st.push(1);
  for (char c: s.toCharArray()){
      if (Character.isDigit(c))
        num = num * 10 + (c - '0');
      else if (c == '+' || c == '-'){
          res += (sign * num);
          num = 0;
          sign = st.peek() * 
      }
      else if (c == '(')
        st.push(sign);
      else if (c == ')')
        st.pop();
  }
  res += (sgin * num);
  return res;
}

public boolean isTree(int n, int[][] edges){ 
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++)
        map.put(i, new ArrayList<>());
    for (int edge: edges){
        map.get(edge[0]).add(edge[1]);
        map.get(edge[1]).add(edge[0]);
    }
    boolean[] visited = new boolean[n];
    Queue<Integer> q= new LinekdList<>();
    q.offer(0);
    while(!q.isEmpty()){
        int n = q.poll();
        if(visited[n]) return false;
        for (int ne: map.get(n)){
            if(!visited[ne])
                q.offer(ne);
        }
    }
    return true;

}
int maxVal = Integer.MIN_VALUE;
public int maxSum(TreeNode root){
    helper(root);
    return maxVal;
}
public int helper(TreeNode root){
    if (root == null) return 0;
    int left = helper(root.left);
    int right = helper(root.right);
    maxVal = Math.max(maxVal, left + right + root.val);
    return root.val + max(leftVal, rightVal);
}

public TreeNode upsideDown(TreeNode root){
    Stack<TreeNode> stack = new Stack<>();
    while(root != null){
        stack.push(root);
        root = root.left;
    }
}

public boolean dfs(TrieNode root, sTring word, int i){
    if (i == word.length())return true;
    char c = word.charAt(i);
    for (Map.Entry<Character, TrieNode> entry: root.map.entrySet()){
        TrieNode t = entry.getValue();
        char ch = entry.getKey();
        if (ch == c || c == '.')
            if (dfs(t, word, i + 1))
            return true;
    }
    return false;

}

class AllOne{
    class Node{
        int val;
        Node pre, next;
        Set<String> keyset;
        public Node(int v){
            this.val = v;
            keyse t= new HashSet<>();
        }
    }
    private Node head;
    private Node tail;
    private Map<String, Node> map;


public class AllOne{
    class Node{
        int val;
        Node pre, next;
        Set<String> keyset;
        public Node(int v){
            this.val = v;
            keyset = new HashSet<>();
        }
    }
    private Ndoe head;
    private Node tail;
    private Map<String, Node> map;

    public AllOne(){
        head = new Node(0);
        tail = new Node(Integer.maxVAleu);
        head.next =tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public void inc(String key){
        Node curr = map.get(key);
        if (curr == null){
            Node next = head.next;
            if (next.val == 1){
                next.keyset.add(key);
                map.put(key, next);
            }
            else {
                Node curr = new Node(1);
                curr.keyset.add(key);
                map.put(key, curr);
                curr.pre = head;
                curr.next = next;
                next.pred = curr;

            }
        }
        else {
            curr.keyset.remvove(key);
            Node next = curr.next;
            if (next.val == curr.val + 1){
                next.keyset.add(key);
                map.add(key, next);
            }
            else {
                Node newNode = new Node(curr.val + 1);
                newNode.keyset.add(key);
                newNode.prev = curr;
                newNode.next = curr.next;
                map.put(key, newNode);
                next = newNode;
            }
            if(curr.keyset.isEmpty() && currval != ){
                Node pre = curr.pre;
                pre.next = newNode;
                
            }
        }
    }
}
    public AllOne(){
     head = new Node(0);
     tail = new Node(Integer.MAX_VALUE);
     head.next = tail;
     tail.pre = head;
     map = new HashMap<>();
    }

    public void inc(String key){
        Node curr = mmap.get(key);
        if (curr == null){
            Node next = head.next;
            if (next.val == 1){
                next.keyset.add(key);
                map.put(key, next);
            }
            else {
                curr = new Node(1);
                curr.keyset.add(key);
                curr.pre = head;
                curr.next = next;
                head.next = curr;
                map.put(key, curr);
            }
        }
    }
}
class LRUCache{
    class Node{
        Node prev, next;
        int key, value;
        public Node(int k, int v){
            key = k;
            value = v;
        }
    }
    Node head, end;
    Map<Integer, Node> map;
    int capacity;
    public LRUCache(int c){
        this.capacity = c;
        head = null;
        end = null;
        map = new HashMap<>();
    }
    public void put(int k, int v){
        if(map.containsKey(k)){
            Node n = map.get(k);
            n.value = v;
            remove(n);
            setHead(n);
        
        }
        else {
            if (map.size() == capacity){
                map.remove(end.key);
                remove(end);
            }
            Node n = new Node(key, value);
            setHead(n);
        }

    }
    public int get(int key){
        if(!map.containsKey(key))
            return -1;
        else {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
    }

    public void setHead(Node n){
        n.next = head;
        n.prev = null;
        if (n.next != null)
            head.prev = n;
        head = n;
        if (end == null) end = n;
    }
    public void remove(Node n){
        if (n.prev == null)
            head = head.next;
        else
            n.prev.next = n.next;
        if (n.next == null)
            last = n.prev;
        else
            n.next.prev = n.prev;
    }
}


class DLL{
    private class Node{
        String value;
        Node next, prev;
        public Node(String val){
            this(val, null, null);
        }
        public Node(String v, Node n, node p){
            this.next = n;
            this.pre v= p;
        }
    }

    private Node first, last;
    private int count;
    public DoubleLinkedList(){
        first = null;
        last = null;
        count = 0;
    }
    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size;
    }

    public void add(Strirng val){
        if (first == null){

        }
        else{
            last.next = new Node(s, null last);
            last = last.next;
        }
    }

    public void add(Stirng v, int index){
        if (index < 0 || index > size) throw
        if (index == size)add(val);
        else if (index == 0)
            addFirst(val);
        else {
            Node prev = first;
            for (int k = 1; k < index; k++)
                prev=prev.next;
            Node succ = prev.next;
            Node mid = new Node(v, prev, succ);
            if (succ == null)last = mid;
            else
                succ.prev = mid;

        }
    }

}

public int maxValue(int[] val, int tw[], int W){
    int m = val.length + 1, n = W + 1;
    int dp[][] = new int[m][n];
    for (int i = 0; i < m; i++){
        for (intj = 0; j < n; j++){
            if (i == 0 || j == 0)
                dp[i][j] = 0;
            else if (j >= wt[i - 1])
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - tw[j-1]]+val[i-1]);
            else

        }
    }
}


public int maxGold(int[][] gold){
    int r = gold.length, c = gold[0].length;
    int[][] dp = new int[r][c];
    for (int col = c - 1; col >= 1; col--){
        for (int row = r - 1; row >= 0; row--){
            int rightUp = (row == 0 || col == c - 1)?0:dp[row - 1][col + 1];
            int right == (col == c - 1)?0:dp[row][col + 1];
            int rightDown = (row == r - 1 || col == c - 1)?0:dp[row + 1][col + 1];
            dp[i][j] = Math.max();
        }
    }

}

public boolean isComplete(TreeNode root){
    Queue<TreeNode> q = new LinkedList<>();
    if (root == ull) return true;
    q.offer(root);
    boolean isNonFullSeen = false;
    while(!q.isEmpty()){
        TreeNode n = q.poll();
        if (n.left != null){
            if (isNonFullSeen) return false;
            q.offer(n.left);
        }
        else
            isNonFullSeen = true;
        if (n.right != null)
            if (isNonFullSeen) return false;
            q.offer(n.right);
        else
            isNonFullSeen = true;
    }
}

public List<List<Integer>> subset(int[] nums){
    List<List<Integer>> res = new ArrayList<>();
    res.add(nums[i]);
    int begin = 0;
    for (int i = 0; i < nums.length; i++){
        if (i == 0 || nums[i] != nums[i - 1])
            begin = 0;
        size = res.size();
        for (int j = begin; j < size; j++){
            List<Integer> curr =nw ArrayList<>(res.get(j));
            curr.add(nums[i]);
            res.add(curr);
        }
        begin = size;
    }



}

public int searchRotated(int[] arr, int x){
    if (arr == null || arr.length == 0) return -1;
    int start = 0, end = arr.length - 1;
    while(sart <= end){
        int mid = ;
        if (arr[mid] == x) return mid;
        if (arr[start] < arr[mid]){
            if (arr[start] <= x && x < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        else if (arr[start] > arr[mid]){
            if (arr[mid] < x && x <= arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        else
            start++;
    }
}


public int maxProfit(Job[] jobs){
    int maxProfit = 0;
    Arrays.sort(jobs, new Comparator<Job>(){
        public int compare(Job a, Job b){
            return a.end - b.end;
        }
    });
    int[] dp = new int[jobs.length];
    for (int i = 0; i < dp.length; i++)
        dp[i] = jobs[i].profit;

    for (int i = 1; i < jobs.length; i++){
        for (int j = 0; j < i; j++){
            if (jobs[i].start >= jobs[j].end)
                dp[i] = Math.max(dp[i], dp[j] + dp[i]);
                
        }
    }
}

public int increasing(int[] A){
    int count = 0;
    for (int i = 0; i < N: i++){
        for (int j = i + 1; j < N;j ++)
            if (A[j] > A[j - 1])couunt_++;
            else
                break;
    }
}
public TreeNode removeHalf(TreeNode n){
    if (n == null) return n;
    n.left = removeHalf(n.left);
    n.right = removeHalf(n.right);
    if (n.left == null && n.right = null) return n;
    if (n.left == null) return n.right;
    if (n.right == null) return n.left;
    return n;
} 

public int maxProfit(int[] v, int[] w, int x){
    int R = w.length + 1;
    int C = x + 1;
    int[][] dp = new int[R][C];
    for (int i = 1; i < R; i++){
        for (Int j = 1; j < C; j++){
            if (j >= i)
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1] + v[i]);
            else
                dp[i][j] = dp[i - 1][j];
        }
    }
}
removehalfnodes
replace
roddcutting
striclyincreasing
subsetsum
weightedjob 

public int getLevel(TreeNode node, int val){
    return helper(node, val, 1);
}

public void print(TreeNdoe n, int low, int high){
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(n);
    TreeNode marker = new TreeNode("$");
    q.offer(marker);
    while(!q.isEmpty()){
        TreeNode n = q.poll();
        if (n == marker){
            level++;
            if (level >  h) break;
            q.offer(marker);
            continue;
        }
        if (l >= low)sop(n.val);
        if (n.left != null)q.offer(n.left);
        if (n.right != null)q.offer(n.right);
    }
}
1,  
public int getLevel(TreeNode node int val){
    return helper(node, val, 1);
}
public int helper(TreeNode node, int val, int level){
    if (node == null) return 0;
    if (node.val == val) return level;
    int left = helper(node.left, val, level + 1);
    if (left != 0)return left;
    int right = helper(node.right, val, level + 1);
    return right;
}
public int helper(TreeNode node, int val, int level){
    if (node == null) return 0;
    if (node.val == val) return level;
    int left = helper(node.left, val, level + 1);
    if (left != 0) return left;
    int right = helper(node.right, val, level + 1);
    if (right != 0) return left;

}
public int maxIncreasing(int[] A){
    int n = A.length;
    int[] dp = new int[n];
    for (int i = 1; i < n; i++){
        for (int j = 0; j < i; j++)
            if (Math.abs(A[i] - A[i]) == 1)
                dp[i] = Math.max(dp[i], dp[j] + 1);
    }
}

public int maxRemoveOne(int[] A){
    int N = A.length;
    int[] fw = new int[N];
    int[] bw = new int[N];
    fw[0] = A[0];
    bw[N - 1] = A[N - 1];
    for (int i = 1; i < N; i++)
        fw[i] = Math.max(A[i], fw[i-1] + A[i]);
    for (int i = N - 2; i >= 0; i--)
        bw[i] = Math.max(A[i], bw[i + 1] + A[i]);
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < N - 1; i++)
        max = Math.max(max, fw[i - 1] + bw[i + 1]);
}

public boolean isSum(TreeNode root){
    if (root == null || isLeaf(root)) return true;
    if (root.left != null)
        int left = (root.left isLeaf)?root.left.data: root.left.data * 2;
    if (root.right != null)
        int right = root.right isLeaf)?root.right.data: root.right.data * 2;
    return root.val == left + right && isSum(root.left) && isSum(root.right);
}
public boolean isFull(TreeNode root){
    if (root == null) return true;
    if (root.isLeaf) return true;
    if (root.left != null && root.right != null)
        return isFull(root.left) && isFull(root.right);
    return fale;
}
class Graph{
    int v;
    LinkedList<Integer> adj;
    public Graph(int v){
        this.v = v;
        adj[] = new LinkedList<>[v];
        for (int  i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        add[v].add(u);
    }

    public boolean isCyclic(){
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++){
            if (dfs(i, visited, -1))
                return true;
        }
        return false;
    }
    public boolean dfs(int i, boolean[] visited, int parent){
        visited[i] = true;
        for (int e: adj[i]){
            if(!visited[e])
                if (dfs(e, visited, i))
                    return true;
            else if (e != parent)
                return false;
        }
        return false;
    }
}
1, 2, 

public int helper(TreeNode root, int data, int level){
    if (root == null) return 0;
    if (orot.val == data) return 0;
    int childlevel  = helper(root.left, data, level + 1);
    if (childlevel != 0) return childlevel;
    i
}
public double eval(TreeNode root){
    if (root == null) return 0;
    if (root.isleaft) return root.val;
    double left = eval(root.left);
    double right = eval(root.right);
    if (root.val == '+')
        return left + right;

}

public int finddsitance(TreeNode root, TreeNode n1, TreeNode n2){
    if (root == null || n1 == null || n2 == null)
        return -1;
    TreeNode lca = lca(root, n1, n2);
    return finddist(root, n1) + finddist(root, n2) - 2 * finddist(root, lca);
}

public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
    if (p == root || q == root || root == null) return null;
    TreeNode left = lca(root.left p, q);
    TreeNode right = lca(root.right, p, q);
    if (left == null && right == null) return null;
    if (left != null && right != null) return rtoo;

}
public int finddist(TreeNode curr, TreeNode target){
    if (curr == null) return -1;
    if (curr.val == target)return 0;
    int left = getDetph(curr.left, target);
    int right = getDepth(curr.right, target);
    if (left == -1 && right == -1) rturn -1;
    return left == -1?right + 1: left + 1; 
}
public void doubleTree(TreeNode root){
    if (node == null) return;
    doulbeTree(root.left);
    doubleTree(root.right);
    oldLeft = root.left;
    node.left = new Node(node.val);
    node.left.left = oldLeft;
}

public boolean isContinous(TreeNode root){
    if (root ==null) return true;
    if (root.isLeaf) return true;
    if (root.left == null && root.right != null)
        return (Math.abs(rootva. = root.right.val) == 1 && isContinous(root.right));
    if (root.right == null && root.left != null)
        return (Math.abs(root.val - root.left.val == 1 && isContinous(root.left)));

    return Math.abs(root.val - root.left.val) == 1 &&
           Math.abs(root.val - root.right.val) == 1 &&
        isContinous(root.lef)
}
class LinkedStack{
    class Node{
        String value;
        Node next;
        public Node(String v){
            this(v, null)
        }

        public Node(string v, Node next){
            this.value = v;
            this.next = nenxt;
        }
    }
    private Node top = null;
    public boolean empty(){
        return top == null;
    }

    // push add first
    public void push(String s){

    }

    // pop
    // removeFirst

}

public int minCapacity(int[] Z){
    if (Z.length <= 1) return 0;
    int maxDiff = 0;
    int minHeight = Z[0];
    for (int i = 1; i < Z.length; i++){
        maxDiff = Math..max(maxDiff, Z[i] - min);
        min = Math.min(min, Z[i]);
    }
}
public List<int[]> ksmallestPiars(int[] nums1, int[] nums2, int k){
    List<int[]> res = new ArrayList<>();
    for (int i = 0; i < nums1.length; i++){
        for (int j = 0; j < nums2.length; j++){
            res.add()
        }
    }
    Collections.sort(res, new Comparator<int[]>(){
        public int compare(int[] a, int[] b){
            return a[0] + a[1] - b[0] + b[1];
        }
    })
}

public static int returnMax(int num){
 int prev = 0, curr = 0, max = 1;
 for (int n: num){
     if (n == 1)
        (int[curr += 1;
      else {
          prev = curr;
          curr = 0;
      }
      max = Math.max(max, prev + curr + 1);
 }
 return max;
}

public void displayBuildings(int[] heights){
    Stack<Integer> st = new Stack<>();
    for (int i = heights.elngth - 1; i >= 0;i--){
        int currHeight = heights[i];
        if (stack.isEmpty() || stack.peek() > currHeight)
    }
}

public int swqp(int a, int b){
    int xor = a ^ b;
    int count = 0;
    while(xor != 0){
        coount += (xor & 1);
        xor >>= 1;
    }
    return count;
}
public List<list<Integer>> vertical(TreeNdoe root){
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Queue<TreeNode> q = new LinkedLIst<>();
    Queue<Integer> cols = new LinkedList<>();
    q.offer(Root);
    cols.offer(0);
    Map<Integer, List<Integer>> map = new HashMap<>();

    while(!q.isEmpty()){
        TreeNode n = q.poll();
        int c = cols.poll();
        if (!map.containsKey(c))
            map.put(c, new ArrayList<>>());
        map.get(c).add(n.val);

        if (n.left != null){
            q.offer(n.left);
            cols.offer(col - 1);
            min = Math.min(min, col - 1);
        }
        if (n.right != null){
            q.offer(n.right);
            cols.offer(col + 1);
            max = Math.max(max, col + 1);
        }

    }
    for (int i = min; i <= max; i++)
        res.add(map.get(i));
} 


class Arraycq{
    private String[] q;
    private int front, reare, size;
    ACq(int ca){
        size = 0;
        q = new String[c];
        front = 0;
        rear = 0;
    }
    public boolean empty(){
        return size == 0;
    }
    public int capacity(){
        return q.length;
    }

    public void enque(){
        if (q.length == size)
        tthrwo execption
        size++;
        q[rear++] = ele;
        if (rear == q.legnth)
        rear = 0;
    }
    public String peek(){

    }
    pubic String dque(){
        if (size == 0)

        String ret = q[front];
        q[front] = null;
        front++;
        if (Front == q.length)
            front = 0;
        retrun rt;
    }
}


public List<String> findWords(char[][] board, String[] words){
    List<String> resul = new ArrayList<>();
    if (board == null || board.length == 0)
        return result;
    Trie trie = new Trie();
    for (String word: words)
        trie.add(word);
    
    int m = board.length, n = board[0].length;
    for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){
            search(board, i, j, trie, "", result);
        }
    }
    return result;
}

public void search(char[][] board, int i, int j, TrieNode root, String curr, List<String> result){
    if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
        return;
    char c = board[x][y];
    if (c == '#')return;
    if (root.map.containsKey(c)) && root.isEndOfWord){
        result.add(curr + c);
        root.isEndOfWord = false;
    }
    if (root.map.containsKey(c)){
        board[i][j] = '#';
        search(board, i - 1, j, root, curr + c, result);
        search(board, i +1, j, root, curr + c, result);
        search(board, i , j - 1, root, curr + c, result);
        search(board, i , j + 1, root, curr + c, result);
        
        board[i][j] = c;
    }
}



class Animal{
    private int time;
    private String name;
    //setters getters constructors
    public boolean isOlder(Animal a){
        return this.time < a.time;
    }
}
class Dog{

}
class Cat{

}
class AnimalQueue{
    private Queue<Dog> dq;
    private Queue<Cat> cq;

    public void add(Animal a){
        if(a instanceof Cat)
    }
    public Animal dequeAny(){
        if (dq.size() == 0 && cq.size() == 0)
            throw exception;
        
    }
}
public void sortalmost(int[] arr, int k){
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < k; i++){
        pq.offer(nums[i]):
    }
    for (int i = 0; i < N; i++){
        if (i + k < N)
            pq.offer(nums[i + k});
        nums[i]  =minheap.remove();
    }
}
public List<Inteeger> slidin(int[] a){
    LinkedList<Integer> list = new LinkedList<>():
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < k; i++){
        while(!list.isEmpty() && a[list.getFirst()] < a[i])
            list.removeLast();
        list.add(i);
    }

    for (int i = k; i < N; i++){
        res.add(arr[list.getFirst()]);

        while(!list.isEmpty() && list.getFirst() < (i - k + 1))
            list.removeFirst();
        
        while(!lsit.isEmpty() && arr[list.getLast()] < arr[i])
            list.removeLast();
        list.add(i);
    }
    res.add(arr[list.getFirst()]);
}
public class NQueen{
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag = new HashSet<>();
    Set<Integer> antidiag = new HashSet<>();

    public List<List<String>> solvequeens(int n){
        List<List<String>> res =new ArrayList<>();
        dfs(res, new ArrayList<>>(), 0, n);
        return res;
    }

    public void dfs(List<List<String>> res, Lisst<STring> boar, )
}
int maxLen;
public int longest(TreeNode root){
    maxLen = 0;
    if (root == null0 return maxLen;
    helper(root, root, 0);
    return maxLen;
}
public int findCeleb(int n){
    int c= 0;
    for (int i = 0; i < n; i++)
        if (knows(c, i)) c = i;
    for (int i = 0; i < c; i++)
        if(knows(c, i)) return -1;
}
public void helper(TreeNode curr, TreeNode prev, int len){
    if (curr == null) return;
    if (curr.val = prev.val + 1)
        len++;
    else
        len = 1;
    maxLen = Math.max(maxLen, len);
    helper(curr.left, curr, len);
    helper(curr.right, curr, len);
}

class TrieNode{
    Map<Character, TrieNode> map;
    boolean endOfWord;
    TrieNode(){
        map = new Hashmap<>();
        endOfWord = false;
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void add(String word){
        TrieNode curr = root;
        for (char c: word.toCharArray()){
            TrieNode n = curr.map.get(c);
            if (n == null){

            }
            c = n;
        }
        c.endOfWord = true;
    }
    public boolean search(String word){
        TrieNode curr = root;
        for (char c: word.toCharArray()){
            TrieNode n = curr.map.get(c);
            if (n == null) return false;
            curr = n;
        }
        return curr.endofword;
    }
    public boolean search(String word){
        return dfs(word, root, 0);
    }
    public boolean dfs(String word, TrieNode root, int i){
        if (i == word.length) return true;
        char wo

public int minroom(Interval[] interval){
    if (interval.length == null || interval.length == 0)
        return 0;
    Arrays.sort(intervals, new Comparator<Interval>(){
        public int compar(Interval a, Interval b){
            return a.start - b.start;
        }
    });
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.offer(interval[0].end);
    for (int i = 1; i < interval.length; i++){
        if (interval[i].start < pq.peek())
            minroom++;
        else
            pq.poll();
        pq.offer(interval[i].end);
    }
}
public int minroom(Interval[] intervals){
    if (intervals == null || intervals.legnth == 0)return 0;
    Arrays.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    })
    PriorityQueue<Interval> pq = new PriorityQueue<>();
    pq.offer(intervals[0].end);
    for (int i = 1; i < intervals.length; i++){
        if (intervals[i].start < pq.peek())
            minroom++;
        else
            pq.poll();
        pq.offer(intervals[i].end);
    }
}
1, 
public List<List<Integer>> vert(TreeNode root){
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Map<Integer, List<Integer>> vmap = new HashMap<>();
    Queue<TreeNode> q = new LinkedList<>();
    Queue<Integer> cols = new LinkedList<>();
    q.offer(root);
    cols.offer(0);
    while(!q.isEmpty()){
        TreeNode n = q.poll();
        int c = cols.poll();

        if (!vmap.containsKey(c))
            vmap.put(c, new ArrayList<>());
        vamp.get(c).add(n.val);
        if (n.left != null){
            q.offer(n.left);
            cols.offer(c - 1);
            min = Math.min(mmin, col - 1);
        }
        if (n.right != null){
            q.offer(n.right);
            cols.offer(col + 1);
            max = Math.max(max, dol + 1);
        }   
    }
    
}

1, 2, 3
publci int candies(int[] ratings){
    int[] candies == new int[ratings.length];
    Arrays.fill(candies, 1);
    for (int i = 1; i < ratings.length; i++){
        if (ratings[i] > ratings[i - 1])
            candies[i] = 1 + candies[i - 1];
    }
    for (int i = N - 2; I >= 0; i--){
        if (ratings[i] > ratins[i + 1])
            candies[i] = max(candies[i], candies[i + 1] + 1);
    }
}

TreeNode n = ne wTreeNode(Interger.parseInt(t[index]);
index++;
dserialze(t);
deserailzie(t);
return n;)
public boolean dfs(char[][] b, String word, int i, int j, int index){
    if (index == word.length()) return ture;
    if (i < 0 || j < 0 || word.charAt(index) != b[i][]j] || visited[i][j])
        return false;
    visited[i][j] = true;

    if (
        dfs(b, i)
    )
    return true;
    visited[i][j] = false;
    return false;
}
public void wiggleSort(int[] nums){
    int[] copy = nums.clone();
    Arrays.sort(copy);
    int i = 1, j = N - 1;
    while(i < N){
        nums[i] = copy[j--];
        i += 2;
    }
    i = 0;
    while(i < N){
        nums[i] = copy[j--];
        i += 2;
    }
}


public boolean canAttend(Interval[] intervals){
    Arrays.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    });
    PriroirtyQueue
}
// can attend
public boolean canAttend(Interval[] int){
    Arrays.sort(in, new Comparator<interval>(){
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    };
    for (int i = 1; i < intervals.elngth; i++)
        if(inte[i - 1].end > in[i].start) return false;
}
public String largestNumber(int[] arr){
    String[] sval = new String[N];
    for (int i = 0; i < arr.length; i++)
        sval[i] = arr[i] + "";

    Arrays.sort(sval, new comparator<String>(){
        public int compare(String a, String b){
            return (a+b).compareTo(b + a);
        }
    })
    if(sval[0].charAt(0) == '0') return "0";
    StringBuilder sb = new StringBuilder();
    for (String s: sval)sb.append(s);
    return sb.toString();
}
public void sovlve(char[][] board){
    if (board.length == 0) return;
    int rows = board.length, cols = board[0].legnth;
    for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++){
            if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1)
                bfs(board, i, j);
        }
    }
    for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++)'
            if (board[i][j] == 'M')
                board[i][j] = '0';
            else if (board[i][j] == '0')
                board[i][j] = 'X';
    }
}
public int myAToI(String str){
  if (str == null || str.length() == 0)
    return 0;
  str = str.trim();
  int sign = 1, start = 0;
  long sum = 0;
  if (str.charAt(0) == '+'){
      sign = 1;
      start++;
  }
  else if (str.charAt(0) == '-'){
      sign = -1;
      start++;
  }
  for (int i = start; i < str.length(); i++){
      char c = str.charAt(i);
      if (!Character.isDigit(c))
        return (int)(sign) * sum;
      sum = sum * 10 + (c - '0');
      if (sign == 1 && sum > Integer.MAX)
        return integer.max
      else if (sign == -1 && -sum < Integer.MIN)
        return Integer.min;
  }
}
public List<int[]> ksmallest(int[] nums1, int[] nums2, int k){
    List<int[]> res = new ArrayList<>();
    if (nums1.length == 0 || nums2.length == 0)
        return res;
    for (int i = 0; i < nums1.length; i++){
        fro (int j = 0; j < nums2.lnegth; j++){
            int[] pairs = {nums1[i], nums2[j]};
            res.add(temp);
        }
    }
    Collections.sort(res, new Comparator<int[]>(){
        public int compare(int[] a, int[] b){
            return a[0] + a[1] - b[0] + b[1];
        }
    })
    return (result.size() < k)?result: result.sublist(0, k);
}
public int eval(String[] tokens){
    Stack<Integer> stack = new Stack<>();
    int first = 0, second =0;
    for(String t: tokens){
        switch(t){
            case "+":int first = stack.pop(), second = stack.pop();
                    stac.push(first + second);
                    break;
            case "-":
        }
    }
}

public int bombEnemy(int[][] A){
    int m = A.length, n = A[0].length;
    int rowHits[] = new int[m];
    int colHits[] = new int[n];
    for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){

            if (i == 0 || A[i - 1][j] == 'W'){
                colHits[j] = 0;
                int r = i;
                while(r < row && A[r][j] != 'W'){
                    colHits[j] += (A[r][j] == 'E')?1:0;
                    r++;
                }
            }
            if (j == 0 || A[i][j - 1] == 'W'){
                rowHits[i] = 0;
                int c = j;
                while(c < col && A[i][c] == 'W'){
                    rowHits[i] += ;
                    c++;
                }
            }
            if (A[i][j] == '0')
                res = math.max(res, rows)
        }
    }
}
public ListNode reverse(ListNode head, int m, int n){
    if (head == null) return null;
    ListNode dummyy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    for (int i = 1; i < m; i++)
        pre = pre.next;
    ListNode start = pre.next, temp  = start.next;
    for (int i = 0; i < n - m; i++){
        start.next = temp.next;
        temp.next = pre.next;
        pre.next = temp;
        temp = start.next;
    }
}
https://www.amazon.jobs/en/jobs/519706
https://www.amazon.jobs/en/jobs/519883
https://www.amazon.jobs/en/jobs/518248
https://www.amazon.jobs/en/jobs/517636


https://www.amazon.jobs/en/jobs/517094
https://www.amazon.jobs/en/jobs/517095

https://sub-amazon.icims.com/jobs/458683/software-development-engineer/job?mode=job&iis=Job+Posting&iisn=LinkedIn.com
https://us-amazon.icims.com/jobs/342439/software-development-engineer-i/job?mode=job&iis=Job+Posting&iisn=LinkedIn.com&mobile=false&width=1499&height=1200&bga=true&needsRedirect=false&jan1offset=-480&jun1offset=-420

https://us-amazon.icims.com/jobs/457828/software-engineer/job?mode=job&iis=Job+Posting&iisn=LinkedIn.com
https://us-amazon.icims.com/jobs/269233/software-development-engineer/job?mode=job&iis=Job+Posting&iisn=LinkedIn.com]
https://us-amazon.icims.com/jobs/278260/software-development-engineer/job?mode=job&iis=Job+Posting&iisn=LinkedIn.com


490427 new york job
Hi , 
I am Sandesh and I am a CS graduate student at University of California, I'm on a quest for my full-time career at Amazon. My interests lies in the area of Software and Web development. I searched the career portal and I am interested in following roles. (req id: 519706, 519883, 518248, 517636)
I was told that getting referred would be the best way to seek opportunities in Amazon. As a first degree connection. would you be willing to refer me to these openings?

Of course, if there is any way I can return the favor in the future, I am happy to do so. Thanks for your time and I look forward to hearing from you soon

eric

ruby

t = 'san'
s = 'san'
t == s # true
t == 'San' #false

2.eql?(2.0) #false
2.eql?(2) # true

if conditions
if income >= 10
    # do something
end

puts "hi" if s >= 10
ss = 100 if y >= 20

case gender
when 'M'
    print 'Mr.'
when 'F'
    print 'Mrs'
end

n = 1
until n > 10 do
    puts n
    n = n + 1
end

iterator
1.upto(10){|num| do something}
10.downto(1){|num| do something}

0.step(20, 2){|num| do someting}
(0..20).step(2){|num| do someghing}

num = [1, 2, 3, 4, 5]
odd_count = num.count{|num| num % 2 != 0}
evens = num.delete_if{|num| num % 2 != 0}


var args
def subtotal(*items)
end


class ParentClass
  def put_this(msg)
    puts "Parent class: #{msg}"
  end
end

class ChildClass < ParentClass
  def put_this(stuff)
    puts "Child class #{stuff}"
    stuff *= 2
    super   # super  is automatically called ith stuf
  end
end
c = ChildClass.new
c.put_this('test')


# accessor modifier
class ClassName
    protected
    def protected_methdo1
    end
    def protected_method2
    end
end

class ClassName
    protected :method_name1, method_name2

    private :method_name3, :method_name4

end

Variables that don’t start with @ and are used within a single method are local variables. For
example, the arguments passed when a method is invoked are assigned to local variables.
Instance variables start with @, are not declared or initialized outside of any methods, but can
be used within every method. Class instance variables start with @, are declared or initialized
outside of every method, but can be used only within class methods, not within instance methods.
Class variables start with @@, are declared or initialized outside of every method, and can
be used within any method.

To change a class method’s accessibility,
use private_class_method and public_
class_method after its definition:
def self.some_method
end
private_class_method : some_method
Class methods cannot be marked as
protected.

yield, 
regex in ruby

begin
    # risky code
resuce ErrorType1 => e
    # do something
rescue ErrorType2 => e
    # do something
end

raise 'raising a runtime exception'
raise ExceptionType1, 'exception message'

One big difference is
that SQLite supports only four data types:
It has no date or time type, and it doesn’t
constrain data by type (meaning that it’ll
let you store a string in a column defined
as a real number). SQLite also has no
system for managing users and permissions:
A database is a file on the computer
and all the data is readable and writable
by any user or application (depending on
the operating system’s permissions on
that file).
SQLite mostly adheres to the SQL92 standard
and has a minimum of built-in functions.
You can do pretty much whatever
you normally do in other database applications,
with a few exceptions: support for
triggers, ALTER TABLE commands, views,
and joins are incomplete. There are also
no foreign key constraints. But for many
database needs, SQLite will do just fine


pancake sort


javascript  46 58 59 60-66, 78-80, 93, 94
call apply binf

