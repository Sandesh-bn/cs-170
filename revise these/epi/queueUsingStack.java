// This is an optimized version of implementing queue using
// stack where unnecessary transfer of elements from two stacks are avoided during repeated back to bakc pop/peek operation. we just allow element to sit in s2

import java.util.*;
class QueueStack<T>{
	private Stack<T> s1, s2;
	public QueueStack(int size){
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	
	public void enqueue(T value){
		s1.push(value);
	}
	
	public T dequeu(){
		if (s1.isEmpty() && s2.isEmpty())
			throw new EmptyQueueException();
		transferElements();
		return s2.pop();
	}
	
	private void transferElements(){
		if (s2.isEmpty()){
			while (s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
	}
	
	public T peek(){
		if (s1.isEmpty() && s2.isEmpty())
			throw new EmptyQueueException();
		transferElements();
		return s2.peek();
	}
	
	public String toString(){
		StringBuilder ret = new StringBuilder();
		
		if (!s2.isEmpty()){
			for (T item: s2)
				ret.append(item + " ");
			ret.reverse();
			ret.append(" ");
		}
		for (T item: s1)
			ret.append(item + " ");
		return ret.toString();
	}
	
	public static  void main(String[] args) throws Exception{
		QueueStack<Integer> qs = new QueueStack<Integer>(5);
		int[] nums = {3, 4, 5, 6};
		for (int num : nums)
			qs.enqueue(num);
		
		System.out.println(qs);
		System.out.println(qs.dequeue());
		
		qs.enqueue(7);
		qs.enqueue(8);
		System.out.println("after enqueueing 7 and 8: ");
		System.out.println(qs);
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs);
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		
	}
}