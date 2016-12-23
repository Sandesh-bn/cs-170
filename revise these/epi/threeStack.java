// implement three stack using a single array
public class ThreeStack{
	private int[] st;
	private int top[] = {0, 0, 0, 0};
	private int DEFAULT_SIZE = 5;
	private int size;
	ThreeStack(){
		this(DEFAULT_SIZE);
	}
	ThreeStack(int size){
		this.size = size;
		st = new int[3 * this.size];
	}
	
	public void push(int n, int item){
		if (n < 1 || n > 3)
			throw new RuntimeException();
		if (top[n] == size)
			throw new StackOverflowException();
		int index = (n - 1) * size + top[n];
		st[index] = item;
		top[n]++;
		
		
	}
	
	public int pop(int n){
		if (n < 1 || n > 3) throw new RuntimeException();
		if (top[n] == 0)
			throw new StackEmptyException();
		int index = ((n - 1) * size) + top[n - 1];
		int ret = st[index];
		st[index] = Integer.MAX_VALUE;
		top[n]--;
		return ret;
	}
	
	public int peek(int n){
		if (n < 1 || n > 3)throw new RuntimeException();
		if (top[n] == 0)
			throw new StackEmptyException();
		int index = ((n - 1) * size) + top[n - 1];
		return st[index];
	}
	
	public boolean isEmpty(int n){
		if (n < 1 || n > 3)
			return top[n] == 0;
	}
}

class StackEmptyException extends Exception{
	public StackEmptyException(){
		super("Stack is empty");
	}
}