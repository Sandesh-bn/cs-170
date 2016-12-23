// logger rate limiter
// question: http://www.cnblogs.com/grandyang/p/5592635.html

public class Solution {
	private Map<String, Integer> map;
	
	public Logger(){
		map = new HashMap<>();
	}
	
	public boolean shouldPrintMessage(int timestamp, String message){
		if (map.containsKey(message) && (timestamp - map.get(message) < 10))
				return false;
			map.put(message, timestamp);
			return true;
	}
}