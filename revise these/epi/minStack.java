// stack that has additional getMin that returns min in O(1)
import java.util.*;



class MinStack{
	   private Stack<Integer> mainStack;
	   private Stack<Integer> minStack;
	   private int top;
	   private final static int DEFAULT_SIZE = 10;
	   public MinStack(){
	      this(DEFAULT_SIZE);
	   }
	   
	   
	   public MinStack(int size){
	      mainStack = new Stack<Integer>();
	      minStack = new Stack<Integer>();
	     
	   
	   
	   }
	   
	   public void push(int item){
		if (minStack.isEmpty() || minStack.peek() > item)
			minStack.push(item);
		mainStack.push(item);
	       
	   
	   }
	   
	   public int peek(){
	      if (mainStack.isEmpty())
	        throw new RuntimeException();
	      return mainStack.peek();
	   
	   }
	   
	   public int pop(){
	      if (mainStack.isEmpty())
	         throw new RuntimeException();
	         
	      if (minStack.peek() == mainStack.peek())
	        minStack.pop();
	        
	      return mainStack.pop();
	   
	   
	   }
	   
	   public boolean isEmpty(){
	     return mainStack.isEmpty();
	   }
	   
	   public int size(){
	       return mainStack.size();
	   
	   }
	   
	   public String toString(){
		   StringBuilder st = new StringBuilder();
		   for (int item: mainStack)
			   st.append(item + "  ");
		   st.append("\n");
		   return st.toString();
	   }
	   
	   public int min(){
		   if (minStack.isEmpty())
			   throw new RuntimeException();
		   return minStack.peek();
	   }


	}

public class Problem3_2 {
	public static void main(String[] args){
		MinStack st= new MinStack();
		st.push(6);
		st.push(5);
		st.push(3);
		st.push(4);
		System.out.println(st);
		System.out.println("Min: " + st.min());
		System.out.println("top: " + st.pop());
	}
	
	
	
}



