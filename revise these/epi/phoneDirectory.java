//http://www.cnblogs.com/grandyang/p/5735205.html
public class PhoneDirectory{
	int upperBound; // available numbers that are not yet given
	Set<Integer> set;  // all the numbers that are given to customer and is unavaialable
	Queue<Integer> queue;
	public PhoneDirectory(int maxNumbers){
		set = new HashSet<>();
		queue = new LinkedList<>();
		upperBound = maxNumbers - 1;
		for (int i= 0; i < maxNumbers; i++)
			queue.offer(i);
	}
	
	public int get(){
		if (queue.isEmpty())
			return -1;
		int number =  queue.poll();
		set.add(number);
		return number;
	}
	
	public boolean check(int number){
		return !set.contains(number) && number <= upperBound;
	}
	
	public void release(int number){
		set.remove(number);
		queue.offer(number);
	}
}