class QueueUsingLinkedList{
	privat class Node{
		String value;
		Node next;
		Node(String value){
			this(value, null);
		}
		Node(String value, Node next){
			this.value = value;
			this.next = next;
		}
	}
	
	private Node front = null, rear = null;
	
	public void enqueu(String s){
		if (rear != null){
			rear.next = new Node(s, null);
			rear = rear.next;
		}
		else {
			rear = new Node(s, null);
			front = rear;
		}
	}
	
	public boolean empty(){
		return front == null;
	}
	
	public String peek(){
		if (empty())
			throw new QueueEmptyException();
		else
			return front.value;
	}
	
	public String deque(){
		if (empty())
			throw new QueueEmptyException();
		String value = front.value;
		front = front.next;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Node curr = front;
		while (curr != null){
			sb.append(curr.value + " ");
			curr = curr.next;
		}
		return sb.toString();
	}
}