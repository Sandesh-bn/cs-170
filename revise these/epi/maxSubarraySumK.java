https://segmentfault.com/a/1190000005771068
//Maximum Size Subarray Sum Equals k
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?


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