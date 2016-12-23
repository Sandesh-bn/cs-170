
public class QueueUsingLinkedList<Item> {
	private class Node{
		Item item;
		Node next;
	}
	private Node first;
	private Node last;
	private int N;
	
	public QueueUsingLinkedList(){
		first = null;
		last = null;
		N = 0;
	}
	public void enqueue(Item item){
		if (isEmpty()){
			first = new Node();
			first.item = item;
			last = first;
		}
		else{
			last.next = new Node();
			last.next.item = item;
			last = last.next;
		}
		N++;
	}
	
	public Item dequeue(){
		if (isEmpty())
			throw new RuntimeException("No items to dequeue.");
		Item ret = first.item;
		first = first.next;
		if (first == null)
			last = null;
		N--;
		return ret;
		
	}
	
	public int size(){
		return N;
	}
	
	
	
	public boolean isEmpty(){
		return N == 0;
	}
}
