design a datastructure for phone directory

PhoneDirectory pd = new PhoneDirectory(3); intializes directory with 0, 1, 2
get() returns -1 if not numbers are free. otherwise returns a number.

check(int num) returns true if number is available

release(int num) release the number. ie make it available


public class PhoneDirectory(){
	int max; // count of numbers
	Set<Integer> set; // if number is given to someone add it to set to keep track of unavailable numbers
	LinkedList<Integer> queue; // if number is available add it to queue.
	
	public PhoneDirectory(int maxNumbers){
		this.max = maxNumbers - 1;
		set = new HashSet<>();
		queue = new LinkedList<>();
		for (int i = 0; i < maxNumbers; i++)
			queue.offer(i);
		
	}
	
	public int get(){
		if (queue.isEmpty())
			return -1;
		int number = queue.poll();
		set.add(number);// mark it unavailable
		return number;
	}
	
	public boolean check(int number){
		return !set.contains(number) && number <= max;
		// check if it's marked unavailable && if number is within range
	}
	
	public void relase(int number){
		if (set.contains(number)){
			set.remove(number);
			queue.offer(number);
		}
			
	}
}