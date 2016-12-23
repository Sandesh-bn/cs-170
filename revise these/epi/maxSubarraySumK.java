https://segmentfault.com/a/1190000005771068
//Maximum Size Subarray Sum Equals k
 public int maxSubArrayLen(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        final int N = nums.length;
        // do sum
        for(int i=1; i<N; i++){
            nums[i] += nums[i-1];
        }
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>(); // sum : index
        // in case sum[i]==0
        map.put(0, -1);
        for(int i=0; i<N; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
            Integer j = map.get(nums[i]-k);
            if(j != null){
                max = Math.max(max, i-j);
            }
        }
        return max;