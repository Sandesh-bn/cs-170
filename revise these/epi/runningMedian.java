// calculat emedian of a data stream
One solution is to use two priority heaps: a max heap for the values below the median, and a min heap for
the values above the median. This will divide the elements roughly in half, with the middle two elements as
the top of the two heaps. This makes it trivial to find the median.
What do we mean by "roughly in half;' though? "Roughly" means that, if we have an odd number of values,
one heap will have an extra value. Observe that the following is true:
If maxHeap. size() > minHeap. si z e(), maxHeap. top() will be the median.
If maxHeap. size() == minHeap. size(), then the average of maxHeap. top() and minHeap.
top () will be the median.
By the way in which we rebalance the heaps, we will ensure that it is always maxHeap with extra element.
The algorithm works as follows. When a new value arrives, it is placed in the maxHeap if the value is less
than or equal to the median, otherwise it is placed into the min Heap. The heap sizes can be equal, or the
maxHeap may have one extra element. This constraint can easily be restored by shifting an element from
one heap to the other. The median is available in constant time, by looking at the top element(s). Updates
takeO(log(n)) time.


class RunningMedian{
	PriorityQueue<Integer> maxHeap, minHeap;
	public RunningMedian(){
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
	}
	
	public void add(int num){
		if (minHeap.isEmpty() || num >= minHeap.peek())
			minHeap.offer(num);
		else
			maxHeap.offer(num);
		if (minHeap.size() - maxHeap.size() > 1)
			maxHeap.offer(minHeap.poll()):
		else if (maxHeap.size() - minHeap.size() > 1)
			minHeap.offer(maxHeap.poll());
	}
	
	public double getMedian(){
		if (maxHeap.size() == minHeap.size())
			return (maxHeap.peek() + minHeap.peek())/2;
		if (maxHeap.size() > minHeap.size())
			return maxHeap.peek();
		else
			return minHeap.peek();
	}
}