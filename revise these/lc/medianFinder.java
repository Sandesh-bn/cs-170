Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2



class MedianFinder{
	PriorityQueue<Integer> minHeap, maxHeap;
	public MedianFinder(){
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	}
	
	public void addNum(int num){
		if (minHeap.isEmpty() || num >= minHeap.peek())
			minHeap.offer(num);
		else 
			maxHeap.offer(num);
		
		if (minHeap.size() - maxHeap.size() > 1)
			maxHeap.offer(minHeap.poll());
		else if (maxHeap.size() - minHeap.size() > 1)
			minHeap.offer(maxHeap.poll());
	}
	
	public double findMedian(){
		if (minHeap.size() > maxHeap.size())
			return minHeap.peek();
		else if (maxHeap.size() > minHeap.size())
			return maxHeap.peek();
		else
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
	}
}

MedianFinder obj = new MedianFinder();
obj.addNum(1);
obj.findMedian();