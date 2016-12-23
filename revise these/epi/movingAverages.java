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