
public class StackUsingLinkedList<Item> {
	private class Node{
		Item item;
		Node next;
	}
	
	private Node first;
	private int N;
	
	public StackUsingLinkedList(){
		first = null;
		N = 0;
	}
	public void push(Item item){
		if (first == null){
			first = new Node();
			first.item = item;
		}
		else {
			Node temp = first;
			first = new Node();
			first.item = item;
			first.next = temp;
		}
		N++;
	}
	
	public Item pop(){
		if (isEmpty())
			throw new RuntimeException();
		Item item = first.item;
		first = first.next;
		N--;
		return item;
		
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	public static void main(String[] args){
		StackUsingLinkedList<Character> chars = new StackUsingLinkedList<Character>();
		chars.push('a');
		chars.push('b');
		chars.push('c');
		chars.push('d');
		chars.push('e');
		System.out.println("Size: " + chars.size());
		
		while (!chars.isEmpty()) {
			System.out.print(chars.pop() + " ");
		}
		System.out.println(chars.size());
			
		System.out.println("popped item: " + chars.pop());
	}
}
