 You are to implement methods to analyze log file data to find the
most visited pages. Specifically, implement the following methods:
- void add (Entry p)-add p.page to the set of visited pages. It is guaranteed
that if add(q) is called after add(p) then q. timestamp is greater than or equal
to p. timestamp.
- List<String> common(k)-return a listof the k most common pages.

class Log{
	int data;
	int timeStamp;
	public Log(int data, int timestamp){
		this.data = data;
		this.timeStamp = timestamp;
	}
}

class LogEntries{
	int time = 0;
	Map<Log, Integer> map;
	public void LogEntries(Log[] logs){
		for (Log log: logs){
			log.timeStamp = time;
			if (!map.containsKey(log))
				map.put(log, 1);
			else
				map.put(log, map.get(log) + 1);
		}
	}
	
	public List<Log> getMostK(int k){
		PriorityQueue<Log> pq = new PriorityQueue<>(k, new Comparator<Log>(){
			public int compare(Log l1, Log l2){
				return map.get(l2) - map.get(l1);
			}
		})
		
		for (Map.Entry<Log, Integer> entry: map.entrySet())
			pq.offer(entry.getKey());
	List<Log> result = new ArrayList<>();
	for (Log log: pq)
		result.add(log);
	return result;
	}
}