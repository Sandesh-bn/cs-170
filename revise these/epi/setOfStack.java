/*
:  Imagine a (literal) stack of plates.  If  the stack gets too high,  it might topple. 
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some 
thre shold. Implement a data structure SetOfStacks that mimics this. SetO-f Stacks  should be 
composed of several stacks and should create a new stack once the previous one exceeds capacity. 
SetOfStacks. push()  and SetOfStacks. pop()  should behave identically to a single stack 
(that is, pop () should return the same values as it would if there were just a single stack). 
*/

class SetOfStacks{
	private List<Stack> myStack = new ArrayList<>();
	private int size;
	private int top;
	private final static int DEFAULT_SIZE = 5;
	public SetOfStacks(){
		this(DEFAULT_SIZE);
	}
	
	public SetOfStacks(int size){
		this.size = size;
		Stack<Integer> temp = new Stack<>();
		myStack.add(temp);
		top = 0;
	}
	
	public void push(int item){
		if (top == size){
			Stack<Integer> temp = new Stack<>();
			temp.push(item);
			top = 1;
			myStack.add(temp);
		}
		else {
			top++;
			myStack.get(myStack.size() - 1).push(item);
		}
	}
	
	public int pop(){
		if (myStack.size() < 1 && top == 0)
			throw new EmptyStackException();
		int item = (int)myStack.get(myStack.size() - 1).pop();
		top--;
		if (top == 0){
			myStack.remove(myStack.size() - 1);
			top = size;
		}
		return item;
	}
	
	public int peek(){
		if (myStack.size() < 1 && top == 0)
			throw new EmptyStackException();
		return (int)myStack.get(myStack.size() - 1).peek();
	}
	
	public boolean isEmpty(){
		return (myStack.size() < 1 && top == 0);
	}
	
	public String toString(){
		StringBuilder ret = new StringBuilder();
		for (Stack stack: myStack){
			for (Object ele: stack)
				ret.append(ele + " ");
			ret.append("|");
		}
		return ret.toString();
	}
	
}