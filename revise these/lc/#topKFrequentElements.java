Top K Frequent Elements
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

public List<Integer> topKFrequent(int[] nums, int k){
    Map<Integer, Integer> map = new HashMap<>();
    for (int n: nums){
        if (!map.containsKey(n))
            map.put(n, 0);
        map.put(n, map.get(n) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>{
        public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
            return e2.getValue() - e1.getValue();
        }
    });

    for (Map.Entry<Integer, Integer> e: map.entrySet())
        heap.offer(e);
    
    List<integers> res = new ArrayList<>();
    for (int i = 0; i < k; i++)
        res.add(heap.poll().getKey());
    return res;
}