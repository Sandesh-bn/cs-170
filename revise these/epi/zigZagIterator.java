public class ZigzagIterator{
	Queue<Iterator> q;
	public ZigzagIterator(List<Integer> v1, List<Integer> v2){
		q = new LinkedList<>();
		if (v1.size() > 0)
			q.offer(v1.iterator());
		if (v2.size() > 0)
			q.offer(v2.iterator());
	}
	
	public int next(){
		Iterator curr = q.poll();
		int res = (int)curr.next();
		if (curr.hasNext())
			q.offer(curr);
		return res;
	}
	
	public boolean hasNext(){
		return q.peek() != null;
	}
}