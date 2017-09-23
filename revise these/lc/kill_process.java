public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill){
    Map<Integer, List<Integer>> childMap = new HashMap<>();
    for (int i = 0; i < N; i++){
        int parent = ppid.get(i);
        if (parent > 0){
            if(!childMap.containsKey(parent)){
                childMap.put(parent, new ArrayList<>());
            }
            childMap.get(parent).add(pid.get(i));
        }
    }

    Queue<Integer> q = new LinkedList<>();
    List<Integer> res = new ArrayList<>();
    q.offer(kill);
    while(!q.isEmpty()){
        TreeNode f = q.poll();
        res.add(f);
        if(childMap.containsKey(f)){
            for (int child: childMap.get(f))
                q.offer(child);
        }
    }
    return q;
}