class TwoSum{
	List<Integer> list;
	public void add(int number){
		list.add(number);
	}
	public boolean find(int value){
		Set<Integer> set = new HashSet<>();
		for (int n: list){
			if (set.contains(value - n))
				return true;
			set.add(n);
		}
		return false;
	}
}
//here add is O(1) and find is O(n)
//https://discuss.leetcode.com/topic/32449/trade-off-in-this-problem-should-be-considered
//to make find O(n) and find O(1)
public class TwoSum{
	Set<Integer> sum;
	Set<Integer> numbers;
	TwoSum(){
		sum = new HashSet<>();
		numbers = new HashSet<>();
	}
	
	public void add(int num){
		if (numbers.contains(num))
			sum.add(num * 2)
		else{
			Iterator<Integer> iter = numbers.iterator();
			while (iter.hasNext())
				sum.add(iter.next() + num);
			numbers.add(num);
		}
	}
	
	public boolean find(int value){
		return sum.contains(value);
	}
}

