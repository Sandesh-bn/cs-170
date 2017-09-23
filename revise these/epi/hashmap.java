// Implement hashtable

class Hash<K, V>{
		private final int SIZE = 16;
		LinkedList<Node<K,V>> items[];
		public Hash(){
			items = new LinkedList[SIZE];
		}

		public int getIndex(K key){
			return key.hashCode() % items.length;
		}

		public void put(K key, V vlaue){
			int index = getIndex(key);
			if (items[index] == null)
				items[index] = new LinkedList<>();
			LinkedList<Node<K,V>> list = items[index];

			for (Node<K, V> node: list){
				if (node.equals(key))
					node.value = value;
					return;
				
			}
			Node<K, V> newNode = new Node<K, V>(key, value);
			list.add(newNode);
		}

		public V get(K key){
			int index = getIndex(key);
			if (items[index] == null) 
			return null;
			LinkedList<Node<K,V>> list = items[x];
			for (Node<K, V> node: list){
				if(node.key.equals(key))
					return node.value;
			}
			return null;
		}


	}

	class Node<K,V>{
		private K key;
		private V value;
		public Node(K k, V v){
			this.key = k;
			this.value = v;
		}

		public boolean equals(Node<K, V> other){
			return this.key.equals(other.getKey());
		}

		public K getKey(){return key;}
		public V getValue(){return this.value;}

		public boolean equals(K k){
			
		}
	}


http://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/


import java.util.*;
class Main {
  public static void main(String[] args) {
    System.out.println("hello world");
        Map<String, Integer>map = new Map<>();
        map.add("this",1 );
        map.add("coder",2 );
        map.add("this",4 );
        map.add("hi",5 );
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
  }
}

// Implement hashtable

//http://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/


class HashNode<K, V>{
    K key;
    V value;
    HashNode<K, V> next;
    public HashNode(K key, V value){
        this.key = key;
        this.value = value;
    }
}
class Map<K, V>{
    private List<HashNode<K, V>> buckets;

    private int capacity;

    private int currentSize;

    public Map(){
        buckets = new ArrayList<>();
        capacity = 10;
        currentSize = 0;
        for (int i = 0;  i < 10; i++)
            buckets.add(null);
    }

    public int size(){
        return currentSize;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    private int getIndex(K key){
        return key.hashCode() % capacity;
    }

    public V remove(K key){
        int index = getIndex(key);
        HashNode<K, V> head = buckets.get(index);
        HashNode<K, V> prev = null;

        while(head != null && !head.key.equals(key)){
            prev = head;
            head = head.next;
        }
        if (head == null)return null;
        currentSize--;

        if (prev != null)
            prev.next = head.next;
        else
            buckets.set(index, head.next);
        return head.value;
    }


    public V get(K key){
        int index = getIndex(key);
        HashNode<K, V> head = buckets.get(index);
        while(head != null){
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }
    
    public void add(K key, V value){
        int index = getIndex(key);
        HashNode<K, V> head = buckets.get(index);

        while(head != null){
            if (head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        currentSize++;
        head = buckets.get(index);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head;
        buckets.set(index, newNode);

        if ((currentSize) / capacity >= 0.7){
            List<HashNode<K, V>> temp = buckets;
            buckets = new ArrayList<>();
            capacity = 2 * capacity;
            for (int i = 0; i < capacity; i++)
                buckets.add(null);
            for (HashNode<K, V> node: temp){
                while(node != null){
                    add(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }
}