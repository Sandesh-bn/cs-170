class StackArray<T>{
	private T[] st;
	private int top;
	
	public StackArray(int capacity){
		st = (T[])new Object[capacity];
		top =  0;
	}
		
	public boolean isEmpty(){
		return top == 0;
	}
	
	public void push(T x){
		if (top == s.length)
			throw new StackOverFlowException();
		else
			s[top++] = x;
	}
	public T pop(){
		if (top == 0)
			throw new StackEmptyException();
		else
			return s[--top];
	}
	
	public T peek(){
		if (top == 0)
			throw new StackEmptyException();
		else
			return s[top - 1];
	}
}

//* 

StackArray<String st = new StackArray<>(5);
st.push("A");st.push("B");
System.out.println(st.pop());

*//



class StackOverFlowException extends Exception{
	public StackOverFlowException(){
		super("No more elements can be inserted.");
	}
}

class StackEmptyException extends Exception{
	public StackEmptyException(){
		super("Stack is empty.");
	}
}

