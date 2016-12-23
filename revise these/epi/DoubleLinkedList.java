class DoubleLinkedList{
	private class Node{
		String valu;
		Node next, prev;
		public Node(String val){
			this(val, null, null));
		}
		public Node(String val, Node n, Node p){
			this.next = n;
			this.prev = p;
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
		return count;
	}
	public void add(String s){
		if (isEmpty()){
			first = new Node(s);
			last = first;
		}
		else {
			last.next = new Node(s, null, last);
			last = last.next;
		}
	}
	
	public void add(int index, String s){
		if (index < 0 || index > size())
			throw new RuntimeException();
		count++;
		if (index == 0){
			Node p = first;
			first = new Node(s, p, null);
			if (p != null)
				p.prev = first;
			else
				last = first;
		}
		else {
			Node pred = first;
			for (int k = 1; k < index; k++)
				pred = pred.next;
			
			Node succ = pre.next;
			Node middle = new Node(s, succ, pred);
			pred.next = middle;
			if (succ == null)
				last = middle;
			else
				succ.prev = middle;
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Node p = first;
		while (p != null){
			sb.append(p.value + " ");
			p = p.next;
		}
		return sb.toString();
	}
	
	public String remove(int index){
		if (index < 0 || index >= size())
			throw new RuntimeException();
		
		Node target = first;
		for (int k = 1 k <= index; k++)
			target = target.next;
		
		String element = target.value;
		Node pred = target.prev;
		Node succ = target.succ;
		
		if (pred == null)
			first = succ;
		else
			pred.next = succ;
		
		if (succ == null)
			last = pred;
		else
			succ.prev = pred;
		return element;
	}
	
	public boolean remove(String element){
		if (isEmpty())
				return false;
		Node target = first;
		while (target != null && !element.equals(target.value))
			target = target.next;
		if (target == null)
			return false;
		Node pred = target.prev;
		Node succ = target.next;
		
		if (pred == null)
			first = succ;
		else
			pred.next = succ;
		
		if (succ == null)
			last = pred;
		else
			succ.prev = pred;
	}
}