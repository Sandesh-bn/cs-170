his a more likely a design question other than a algorithm question, which requires us to choose the proper data structure and implement the "get", "set" methods.

At the first glance, a queue seems enough for this problem, because of its FIFO property. However,  the questions also requires "Recently", which means both "input" and "visit" are "recent actions" for the data. If you have the data "<1,1>"  the least recently used element in the queue <1,1> <2,2><3,3>, if method "get(1)" is called, "<1,1>" is now becoming the last (recently used) element in the queue. (<2,2,><3,3,><1,1>)

Consider the basic operations we need:
(1) Insert a new <key, value> pair to the end of the list.
(2) delete a <key, value> pair (if the cache is full).
(3) move a <key, value> pair to the end. (when it is used)
(3) change the value in a <key, value> pair and move it to the end.

Therefore,  a double linked list can handle the above methods well. A map<key, node*>  is a good way tracking the position of the node according to its key.

Be careful with the following cases:
(1) List is empty
(2) List has one node
(3) Initialization
(4) Don't forget delete the element in the map when it is removed from lis


Solution : from key to get the value, the fast way to do it is using hash table. but when set, the hash table reach its capacity, how do we get the least recently used item? can we use additional information in hash table, such as time it set or get? so the hash table would be key, (value, time modified). yes, it will work, but the time takes to find the least recently used item is O(n). can we do better?

Sure, we can use double link list to store all the key, value. if item get or set, move this node in the link list to the front (the first element in the double link list). and when it reaches its capacity, delete the last element in the double link list(it is least recently used, since whenever it used, it move to the front), and add new node to the front. Get and Set takes O(1).



The problem asks for implementing a LRU cache. It should support the following operations get and set. 

The crux of the problem is of deep understanding the LRU cache. The LRU cache is least recently used. That is, when insert a new item, it will kick out the least recently used item into the next lower level memory. Suppose the top of the LRU means mostly recently used, and the tail is least recently used. When we get a value from a specific key, the item should be moved to the head as well, since it is mostly recently used. When update an item, the updated item should go to head. When insert a new item, the new item should be inserted to the head of the cache. When the cache capacity reaches, we shall first delete the tail node first before we insert a new node at head. 

Solution:
Note that all cache operations require O(1) time complexity. To achieve, we use hash map + doubly linked list. Why we use doubly linked list? Because we when delete a node or move the node to head, we shall do it in O(1) time. A singly linked list cannot achieve this.



Currently LRU Cache is among the top three least acceptance problems on leetcode, after Word Ladder II and Valid Number. It is described as follows:

“Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.”
In designing the data structure, a few ideas come to mind:

The get(key) and set(key) should support O(1) simplicity, otherwise it fails with a Time Limit Exceeded error. Therefore it is natural to utilize a hashtable, or a HashMap in Java.
To envict the least recently used entry, it is handy to utilize a doubly linked list for convenient removal of the last node. Also, to put a new <key, value> pair, doubly linked list makes it easier to add a first node. Here first node represents the most recently visited entry, and the last node represents the least recently visited entry.
Considering both, [LinkedHashMap] (http://docs.oracle.com/javase/7/docs/api/java/util/LinkedHashMap.html) will be an ideal implementation of the LRU cache. get() and set() become straightforward. To get a key, we first retrieves the value if it exists, then remove the entry to add it before the first node. Similarly, to set a <key, value>, we first get() the key. Doing this has two effects: (1) if the key does not exist, nothing happens; (2) if the key already exists, it is swapped to the first node. Whichever is the case, we use a put(key, value) afterwards to add a new <key, value> or to replace the value of the existing key. Note the <K,V> is indeed <Integer, Integer>. Autoboxing takes care of the wrapping/unwrapping between int and Integer:




Idea: Use a bi-directional linked list to store the inserted data. At the same time use a hashmap<key, node> to achieve O(1) access. Whenever a key is visited or modified, move it out of the bi-directional linked list, then insert it to the tail of the list. Whenever an insertion is required and the capacity is full, remove the node at the head.

Time: O(1) Space: O(n)

Cache should achieve the O(1) time complexity of get and set operation.
(1) To achieve the O(1) time complexity of look up operation, HashMap should be used to store the mapping relation between key and value(Node, in this solution).
(2) To achieve the O(1) time complexity of the invalidation operation of the least recently used item, double linked listed should be used. Every time, when there is a get operation, the accessed item will be moved to the head of the linked list. And the tail of the least recently used element of the cache.



public class LRUCache {
    class Node{
        int key, value;
        Node prev, next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    int capacity;
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null, end = null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            Node ret = map.get(key);
            remove(ret);
            setHead(ret);
            return ret.value;
        }
        else
            return -1;
    }
    
    private void remove(Node node){
        // if it is first node
        if (node.prev == null)
            head = head.next;
        else
            node.prev.next = node.next;
        
        // if it is last node
        if (node.next == null)
            end = node.prev;
        else
            node.next.prev = node.prev;
    }
    
    private void setHead(Node node){
        node.next = head;
        node.prev = null;
        if (head != null)
            head.prev = node;
        head = node;
        
        if (end == null) end = node;
    }
    public void set(int key, int value) {
        if (map.containsKey(key)){
            Node recentNode = map.get(key);
            recentNode.value = value;
            remove(recentNode);
            setHead(recentNode);
        }
        else {
            Node newNode = new Node(key, value);
            if (map.size() >= capacity){
                map.remove(end.key);
                remove(end);
                setHead(newNode);
            }
            else
                setHead(newNode);
                
            map.put(key, newNode);
        }
        
    }
}
