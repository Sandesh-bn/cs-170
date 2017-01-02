/// moving averages of liding window
public class MovingAverage{
	Queue<Integer> queue = new LinkedList<>();
	int sum, size;
	
	public MovingAverage(int size){
		this.size = size;
		this.sum = 0;
	}
	
	public double next(int value){
		if (queue.size() >= size){
		   int front = queue.poll();
		   queue.offer(value);
		   sum -= head;
		   sum += value;
		   return sum / queue.size();
		}
		else {
			queue.offer(value);
			sum += value;
			return sum / queue.size();
		}
	}
}

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

Solution:
Use a Queue serve as a sliding window, and also maintain the current sum inside of the window. 

