  static void populateAncestorMatrix(Node root, int[][] mat, int n) {
		if (root == null) {
			return;
		}
		populateAncestorMatrix(root.left, mat, n);
		populateAncestorMatrix(root.right, mat, n);
		
		if (root.left != null) {
			// set 1 for current child
			mat[root.item][root.left.item] = 1;
			// all children of current child are also children of root
			for (int j = 0; j < n; j++) {
				if (mat[root.left.item][j] == 1) {
					mat[root.item][j] = 1;
				}
			}
		}
		if (root.right != null) {
			mat[root.item][root.right.item] = 1;
			for (int j = 0; j < n; j++) {
				if (mat[root.right.item][j] == 1) {
					mat[root.item][j] = 1;
				}
			}
		}
	}




	1,2,3,4,5
	public class MinHeap{
		private List<Integer> items;
		public Heap(){
			items = new arrayList<>();
		}
		public void offer(int val){
			items.add(val);
			siftuP();
		}
		public int poll(){
			if (item.size())

			siftDown();
			return item;
		}
		public void siftUp(){
			int k = N - 1;
			int l = k-1/2;
			while(k > 0){
				int p = k - 1/2;
				if(items(k) > items(p)){
					swap(items(k), items)o
					k = parent;
				}
				else
				break;
			}
		}
		public void siftDown(){
			int k = 0, l = 2 * k + 1;
			while(L < N){
				int R = l + 1, max = l;
				if (r < N &&items(r) > items(L){
					max = r;
				})
				if (items(k) < items(max){
					swwap;
					k = max;
					l = 2 * k + 1;
				})
				else
				break;
			}
		}
	}




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