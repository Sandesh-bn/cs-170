public class Problem3_1 {
	
	public static void main(String[] args) throws Exception{
		ThreeArrayStack myStack = new ThreeArrayStack(3);
		myStack.push(1, 99);
		myStack.push(3,101);
		myStack.push(3,  999);
		System.out.println(myStack);
		
		myStack.push(2, 21);
		myStack.push(2, 22);
		myStack.push(2, 25);
		System.out.println(myStack);
		
		for(int i = 0; i < 3; i++)
			myStack.pop(2);
		
		System.out.println(myStack);
	}

}





class StackOverFlowException extends RuntimeException{
	public StackOverFlowException(){
		super("Stack is full");
	}
}

class StackEmptyException extends RuntimeException{
	public StackEmptyException(){
		super("Stack is empt");
	}
}

class ThreeArrayStack{
	private int[] st;
	private int size;
	private static final int MAX_SIZE = 4;
	private int pointer[] = {0, 0, 0, 0};
	private static final int INVALID = Integer.MIN_VALUE;
	
	public ThreeArrayStack(){
		this(MAX_SIZE);
	}
	
	public ThreeArrayStack(int size){
		this.size = size;
		st = new int[size * 3];
		
		for (int i = 0; i < st.length; i++)
			st[i] = INVALID;
	}
	
	public void push(int stackNum, int ele){
		if (pointer[stackNum] == size)
			throw new RuntimeException();
		
		int index = (stackNum - 1) * size + pointer[stackNum];
		st[index] = ele;
		pointer[stackNum]++;
	}
	
	public int pop(int stackNum){
		if (pointer[stackNum] == 0)
			throw new RuntimeException();
		
		int index = (stackNum - 1) * size + pointer[stackNum] - 1;
		int ret = st[index];
		st[index] = INVALID;
		pointer[stackNum]--;
		return ret;
	}
	
	public int peek(int stackNum){
		if (pointer[stackNum] == 0)
			throw new RuntimeException();
		
		int index = (stackNum - 1) * size + pointer[stackNum];
		
		return st[index];
	}
	
	public int size(int stackNum){
		return pointer[stackNum];
	}
	
	public String toString(){
		StringBuilder ret = new StringBuilder();
		
		for (int i = 0; i < st.length; i++){
			if (i % size == 0)
				ret.append(" | ");
			
			if (st[i] == INVALID)
				ret.append("? ");
			else
				ret.append(st[i] + " ");
			
			
		}
		return ret.toString();
	}
	
	
	
	
}