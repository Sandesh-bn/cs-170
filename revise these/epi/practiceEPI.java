@@DOUBLE LINKED LIST

class DLL{
    class Node{
        Node next, prev;
        Node(String val){
            this(val, null, null);
        }
        Node(String val, Node next, Node prev){
            value = val;
            next = next;
            prev = prev;
        }
    }

    private Node first, last;
    int count;
    public DLL(){
        first = null;
        last = null;
        count = 0;
    }

    public int size(){
        return count;
    }

    public void add(String s){
        if (first == null){
            first = new Node(0);
            last = first;
        }
        else {
            last.next = new Node(s, null, last);
            last = alst.next;
        }
        count++;
    }
    public void insert(int index, String s){
        if (index < 0 || index > size) throw else
        if (index == 0){
            if (first == null)
                add(s);
            else {
                Node p = first;
                first = new Node(s, p, null);
            }
        }
        else if (index == count){
            add(s);
        }
        else {
            Node pred = first;
            for (int i = 0; i < index - 1; i++)
                pred = pred.next;
            Node succ = pred.next;
            pred.next = new Node(s, succ, pred);
            if (succ == null)
                last = pred.next;
            else    
                succ.prev = pred.next;
        }
        count++;
    }
    public void remove(int index){
        if (count == 0 || index < 0 || index >= count) throw else
        if (index == 0){
            first = first.next;
            if (first == null)
                last = null;
        } 
        Node t = first;
        for (int i = index; i <= index; i++)
            t = t.next;
        Node pred = t.prev;
        Node succ = t.next;
        if (pred == null)
            first = t.next;
        else
            pre.next = succ;
        if (succ == null)  
            last = prev;
        else
            last.prev = pred;
        count--;
    }

    public boolean remove(String ele){
        if (count == 0) return false;
        Node t = first;
        while(t != null && !t.value.equals(ele))
            t = t.neext;
        Node pred = t.prev;
        Node suc = t.next;
        if (pred == null)
            first = succ;
        else
            pred.next = succ;
        if (succ = null)
            last = pred;
        else
            succ.prev = pred;
    }
}
// ENCODE DECODE STRING

public String decode(String value){
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (i < value.length()){
        int num = 0;
        while(Character.isDigit(value.charAt(i))){
            num = num * 10 + value.charAt(i) - '0';
            i++;
        }
        i++;
        result.append(value.substring(i, i + num + 1));
        i = i + num + 1;
    }
}
// FIND COMMON IN 3 ARRAYS
public void findCommong(int[] a1, int[] a2, int[] a3){
    int i = 0, j = 0, k = 0;
    while(i < a1.length && j < a2.length && k < a3.length){
        if (a1[i] == a2[j] == a3[k]){
            print i, j, k
            i++;j++;k++;
        }
        if (a1[i] < a2[j])
            i++;
        if (a2[j] < a3[k])
            j++;
        else
            k++;
    }
}


// FIRST ELEMENT LARGER THAN TARGET

public int leftMost(int[] A, int x){
    int l = 0, high = A.length - 1, res = -1;
    while(l <= high){
        int mid = (l + high)/2;
        if (A[mid] > x)
            high  = mid - 1;
        if (A[mid] == x)[
            high = mid - 1;
            res = mid;
        ]
        else
            low = mid + 1;
    }
}


public class Vec2d{
    List<Integer> lsit = new ArrayList<>();
    int i = 0;
    public Vec2d(List<List<Integer>> l){
        for (List ele: l)
            list.addAll(ele);
    }
    public int next(){
        return list.get(i++);
    }
    public boolean hasNext(){
        return i < list.size();
    }
}
// PRINT ALL LEAFb

public void printAllLeafs(TreeNode r){
    if (r == null) return;
    if (r.left == null && r.right == null) {}
        sysout(r.val + " ");
        return;
    }
    printAllLeafs(r.left);
}

///QUEUE USING HEAP
class QUsingHeap{
    class Element{
        int priority, item;
    }
    
}
//FLIP BIT

public static int maxBit(int num){
    int curr_run = 0, prev_run = 0, max = 1;
    while(num != 0){
        int bit = num & 1;
        num >>= 1;
        if (bit == 1)
            curr_run++;
        else{
            prev_run = curr_run;
            curr_run = 0;
        }
        max = Math.max(max, curr_run + prev_run + 1)
    }
}

// RANDOM ARRAY

// K SMALLEST PAIRS
public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k){
    List<int[]> pairs = new ArrayList<>();
    for (int i = 0; i < nums1.length; i++){
        for (int j = 0; j < nums2.length; j++){
            int[] pair = {nums1[i], nums2[j]};
            list.add(pair);
        }
    }
    Collections.sort(pairs, new Comparator<int[]>{
        public int compare(int[] e1, int[] e2){
            return (e1[0] + e1[1]) - (e2[0] + e2[1]);
        }
    })
}

// LEXICAL ORDER



//LIST LEAVES 
public static List<Integer> createList(TreeNode root){
    List<Integer> leaves = new ArrayList<>();
    addLeaves(root, leaves);
    return leaves;
}

public void addLeaves(TreeNode node, List<Integer> leaves){
    if (node != null){
        if (n.left == null && n.right == null)
            leaves.add(n.value);
        else {
            addLeaves(n.left, leaves);
            addLeaves(n.right, leaves);
        }
    }
}

// MAGI);C INDEX
public static int findIndex(int[] arr){
    return findIndex(arr, 0, arr.length - 1)
}

public int findIndex(int[] arr, int low, int high){
    if (low > high) return -1;
    int mid = (low + high)/2;
    if (arr[mid] == mid)return mid;
    else if (arr[mid} > mid)
        return findIndex(arr, lwo mid - 1);
    else   
        rturn findIndex(arr, mid + 1, high);
}

public int findIndex(int[] arr, int low, int high){
    if (low > hig)return -1;
    int mid = (low + high)/2;
    if (arr[mid] == mid) return mid;

    int leftIndex = Math.min(mid - 1, midVAlue);
    int left  = findIndexx(arr, low, leftIndex);
    int rightINdex = Math.max(mid + 1 mideValue);
    int fiht = findIndex(arr, rightIndex, high);
    return right;
}

// LOGGER RATE LIMITER

// SUB ARRAY SUM K// 


// MEETING ROOM\

public boolean canAttent(Interval[] interval){
    if (intervals == null) return false;
    Arrays.sort(interval, new Comparator<Interval>(){
        public int compare(interval i1, Interval i2){
            return i1.start = i2.start;
        }
    })

    for (int i = 1; i < interval.length; i++){
        if (interval[i - 1].end > interval[i].start)
            return false;

    }
    return true;
}

public int minMeetinRoom(Interval[] intervals){
    if (null == intervals || intervals.length == 0)
        return 0;
    Arrays.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2){
            return i1.start = i2.start;
        }
    });

    priorityQueue<Integer> pq = new PiroityQueue<>();
    int minRoom = 1;
    pq.offer(intervals[0].end);
    for (int i = 1; i < intervals.length; i++){
        if (intervals[i].start < queue.peek())
            minRoom++;
        else
            queue.poll();
        queuu.offer(nterva[i].end);
    }
}
//MERGE SORT
public static void merge(int[] test){
    ms(test, 0, test.length - 1);
}

public void ms(int[] test, int low, int high){
    if(high - low < 10){
        insertionSort(test, low, high);
        return;
    }
    if (low < high){
        int mid = (low + high)/2;
        ms(test, low, mid - 1);
        ms(test, mid + 1, high);
        merge(test, low, mid, high);
    }
}

publci void merge(int[] arr, int l, int m, int h){
    left = low, right = m + 1;
    int size = (high - low) + 1;
    int temp[] = new int[size];
    int k = 0;
    while(left <= mid && right <= high){
        if (arr[left] < arr[right])
            temp[k++] = arr[left++];
        else
            temp[k++] = arr[right++];
    }
    while (left <= mid)
        temp[k++] = arr[left++];
    while(right <= high)
        temp[k++] = arr[right++];
    for (int i = 0; i < temp.lenfth; i++)
        arr[low + i] = temp[i];
}

// MIN BATTERY CAPACITY
public int minCap(int[] Z){
    if (Z == null || Z.length == 0) return 0;
    int minH = Z[0], maxDiff = 0;
    for (int i = 1; i < Z.length; i++){
        maxDiff = Math.max(maxDiff, Z[i] - minH);
        minH = Math.min(Z[i], minH);
    } 
    return maxDiff;
}

// MIN MOVES TO MAKE ELEMENT EQUAL

public int minMooves(int[] nums){
    Arrays.sort(nums);
    int i = 0, j = nums.length - 1;
    int minM = 0;
    while (i < j){
        minM = nums[j--] - nums[i++];
    }
    return minM;
}
// MISSING RANGES


// MOVING AVERAGE


// MULTI SEARCH


// ONE EDIT DISTANCE

sXabcd  sYabcd
sXabcd sabcd
sa
public boolean oneEditDistance(String s, String t){{
    i = 0, j = 0;
    while (i < s.lengh() && j < t.length()){
        if (s.charAt(i) == t.charAt(j))
            i++;j++;
        if (s.substring(i + 1).equals(s.substring(j + 1)))
            return true;
        else if (s.substring(i).equals(s.substring(j + 1)))
            return true;
        else if (s.substring(i + 1).equals(s.substring(j)))
            return true;
    }
    return Math.abs(s.elngth() - t.length() ) <= 1;
}}
// PAIRWISE SWAP


// PRINT ALL LEAFS


// QUUEUE USING HEAP

// QUEUEU USING LL

class QueueUsingLL{
    class Node{
        String value;
        Node next;
        Node(String val, Node next){
            this.value = val;
            this.next = next;
        }
    }

    Node front = null, rear = null;

    public void enqueue(String val){
        if (front == null){
            front = new Node(val);
            rear = front;
        }
        else {
            rear.next = new Node(val);
            rear = rear.next;
        }
    }

    public String dequeu(){
        if (Front == null) throw ex
        String val = front.val;
        front = front.next;
        if (front == null)
            end = null;
        return val;
    }

    public String peek(){
        if (Front == null) return null;
        return front.val;
    }
}
// REPLACE AND REMOVE


// STACK ARRAY

/// REVERSE AWORDS
public void reverse(char[] s){
    if (s.length < 2) return;
    int last = 0;
    reverse(s, 0, s.length() - 1);
    for (int i = 0; i < s.length; i++){
        if (s[i] == ' '){
            reverse(s, last, i - 1);
            last = i + 1;
        }
    }
}
// RUN LENTH ENCODING


// RUNNING MEDIAN
class RunningMedian{
    PriorityQueue<Integer> maxHeap, minHeap;
    public RunningMedian(){
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void add(int num){
        if (minHeap.isEmpty() || num >= minHeap.peek())
            minHeap.offe(num);
        else
            maxHeap.ooffer(num);
        
        if (minHeap.size() - maxHeap.size() > 1)
            maxHeap.offer(minHeap.poll());
        else if (maxHeap.size() - minHeap.size() > 1)
            minHeap.offer(maxHeap.poll());
    }
}

// SHUFFLE CARDS
public void shuffleCards(int[] cards){
    for (int i = 0; i < cards.length; i++){
        int rand = Math.random(0, cards.length);
        cards[rand] = cards[i];
    }
}

// ALL ELEMENTS APPEAR THRICE


// SMALLEST DIFFERENCE


// SORT STACK


// SPARSE SEARCH

// STACK USING LL

// STACK ARRAY


// TWO SUM DATA STRUCUTRE

// WELL AND GATE
public void wallsAndGates(int[][] rooms){
    for (int i = 0; i < rooms.length; i++){
        for (int j = 0; j < rooms[0]].length; j++){
            if (rooms[i][j] == 0)
                dfs(rooms, i, j, 0);
        }
    }
}

public void dfs(int[][] rooms, int i, int j, int distance){
    if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length < rooms[i][j] < distance)
        return;
    rooms[i][j] = distance;
    dfs(rooms, i - 1, j, distance + 1);
    dfs(rooms, i + 1, j, distance + 1);
    dfs(rooms, i, j + 1, distance + 1);
    dfs(rooms, i, j - 1, distance + 1);

}
// ZIG ZAG ITERATOR



public boolean isValidTree(int n, int[][] edges){
    boolean[] visited = new boolean[n];
    List<Integer> adj[] = neew ArrayList<>();
    for (int i = 0; i < adj.length; i++){
        adj[i] = new ArrayList<>();
    }

    for (int[] edge: edges){
        adj[edge[0]].add(edge[1]);
        adj[edge[1]].add(edge[0]);
    }
    if (!dfs(0, -1, visited, adj)) return false;
    for (boolean b: visited)
        if(!b) return false;
    return true;
}

private boolean dfs(int v, int p, boolean[] visited, List<Integer>[] adj){
    visited[v] = true;
    for (int i: adj[v]){
        if (i == p) continue;

    }
}


public int diameter(TreeNode r){
    if (r == null) return 0;
    leftHeight = height(r.left);

    rightHeight = height(r.right);
    leftdiamger = diamgter(r.left);
    rightdiamget = diameter(r.right);

    return Max(leftHeigth + rightHeight + 1, leftdiamger, rgihtDiamger);
}

public int getHeigt(TreeNode n){
    if (n == null) return 0;
    return 1 + math.max(getHieght(n.left), getHeight(n.right));
}

public String decode(String v){
    if (v == null) return "";
    int i = 0;
    StringBuilder sb = new StringBuilder();
    while (i < v.length()){
        int len = 0;
        while(i < v.length() && s.charAt(i) != '#')
            len = len * 10 + v.charAt(i) - '0';
        String word = v.substring(i + 1, i + 1 + len );
        i = i + len + 1;
    }
}

public int getLeaf(TreeNode r){
    if (r == null) return 0;
    if (r.left == null && r.right == null) return 1;
    return getLeaf(r.left) + getLeaf(r.gith);
}