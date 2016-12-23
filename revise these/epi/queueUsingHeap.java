// implement stack using heap
//Now, as we can see this implementation takes O(log n) time for both push and pop operations.
class QueueUsingHeap{
	class Element{
		int priority,
		int elem;
		
		// define a comparator where 
	}
	MinPriorityQueue<Element> q;
	int top_priority = 0;
	void push(Key k){
		q.push(Element(top_priority, k));
		top_priority++;
	}
	
	Key pop(){
		top_priority--;
		return q.pop().elem;
	}
}