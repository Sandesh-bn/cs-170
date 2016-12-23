class MyLinkedList{
	private class Node{
		String value;
		Node next;
		Node(String val){
			this(val, null);
		}
		Node(String val, Node next){
			value = val;
			this.next =  next;
		}
	}
	
	private Node first, last;
	private int count;
	public MyLinkedList(){
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return count;
	}
	public void add(String ele){
		count++;
		if (!isEmpty()){
			first = new Node(ele);
			last = first;
		}
		else {
			last.next = new Node(ele);
			last = last.next;
		}
	}
	
	public void add(int index, String ele){
		if (index < 0 || index > count)
			throw new RuntimeException();
		count++;
		if (index == 0){
			Node p = new Node(ele, first);
			first = p;
			if (last == null)
				last = first;
			return;
		}
		else {
			Node prev = first;
			for (int i = 1; i < index; i++)
				prev = prev.next;
			Node nextNode = prev.next;
			prev.next = new Node(ele, nextNode);
			if (prev.next.next == null)
				last = prev.next;
		}
	}
	
	public String toString(){
		StringBuilders ele = new StringBuilder();
		Node p = first;
		while (p != null){
			ele.append(p.value + " ");
			p = p.next;
		}
		return ele.toString();
	}
	
	public String remove(int index){
		if (index < 0 || index >= size())
			throw new RuntimeException();
		count--;
		if (index == 0){
			String ele = first.value;
			first = first.next;
			if (first == null)
				last = null;
			return ele;
		}
		Node pred = first;
		for (k = 1; k < index; k++)
			pred = pred.next;
		String ele = pred.next.value;
		pred.next = pred.next.next;
		if (pred.next == null)
			last = pred;
		return ele;
	}
	
	public boolean remove(String target){
		if (size() == 0)
			throw new RuntimeException();
		boolean wasRemoved = false;
		if (first.value.equals(target)){
			first = first.next;
			if (first == null)
				last = null;
			wasRemoved = true;
		}
		else {
			Node pred = first;
			while (pred.next != null &&
					!pred.next.value.equals(target))
					pred = pred.next;
			if (pred.next == null)
				break;
			else {
				pred.next = pred.next.next;
				wasRemoved = true;
				if (pred.next == null)
					last = pred.next;
			}
		}
		if (wasRemoved)
			count--;
		return wasRemoved;
	}
}