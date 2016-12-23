/*
 Implementing stack using linkedlist
 
 */
class LinkedStack{
	private class Node{
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
	private Node top = null;
	public boolean empty(){
		return top == null;
	}
	
	public void push(String s){
		top = new Node(s, top);
	}
	
	public String pop(){
		if (empty())
			throw new EmptyStackException();
		else {
			String ret = top.value;
			top = top.next;
			return ret;
		}
	}
	
	public String peek(){
		if (empty())
			throw new EmptyStackException();
		else
			return top.value;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Node p = top;
		while (p != null){
			sb.append(p.value + " ");
			p = p.next;
		}
		return sb.toString();
	}
}