public class Solution {
public int jump(int[] nums) {
    // If nums.length < 2, means that we do not
    // need to move at all.
    if (nums == null || nums.length < 2) {
        return 0;
    }

    // First set up current region, which is
    // from 0 to nums[0].
    int l = 0;
    int r = nums[0];
    // Since the length of nums is greater than
    // 1, we need at least 1 step.
    int step = 1;

    // We go through all elements in the region.
    while (l <= r) {

        // If the right of current region is greater
        // than nums.length - 1, that means we are done.
        if (r >= nums.length - 1) {
            return step;
        }

        // We should know how far can we reach in current
        // region.
        int max = Integer.MIN_VALUE;
        for (; l <= r; l++) {
            max = Math.max(max, l + nums[l]);
        }

        // If we can reach far more in this round, we update
        // the boundary of current region, and also add a step.
        if (max > r) {
            l = r;
            r = max;
            step++;
        }
    }

    // We can not finish the job.
    return -1;
}
}



For each step of jump, there is a range you can reach.
Then try jumping from each position in current range, you will get a new range where the next step can reach.
Repeat this process util the range covers the last index.

public class Solution {
    public int jump(int[] nums){
        int step = 0;
        for(int l = 0, r = 0; r < nums.length - 1; step++){
        	int rNew = 0;
        	for(int i = l; i <= r; i++) rNew = Math.max(rNew, i + nums[i]);
        	l = r + 1;
        	r = rNew;
        }
        return step;
    }
}




public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        
    // init
        int reachAble = 0; // reachAble updates how far can be reached by now
        int index = 0;  // update nums index
        int step = 0;  // record current step number 
        int currStepMax = 0; // update how far can be reached by current step
        
    // if the index pass the updated furthest, we cannot move any futher
    // by this way we can also find out whether the final index is reachable or not:
    // (outside while loop to check: reachAble >= nums.length - 1)
        while (index <= reachAble) { 

    // for current step, if the index has reached the furthest reachable (currStepMax), we have no way but to take another step
    // after taking the step, the currStepMax should be updated by the furthest reachable from last step, which is (reachAble)
            if (index > currStepMax) {
                step++; 
                currStepMax = reachAble;
            }  
       
    // for each index, we always update reachAble (the furthest index can be reached)     
            if (index + nums[index] > reachAble) {
                reachAble = index + nums[index];
            } 
            
     // when reachAble exceed the last index, we find our solution       
            if (reachAble >= nums.length - 1) {
                break;
            } 
            
            index++;
        }
        
        return step + 1;  // take the last step, we reach the destination (guaranteed minimum steps)
    }
}



public int jump(int[] nums) {
    if(nums == null || nums.length == 0){
        return 0;
    }
    int lastReach = 0;
    int reach = 0;
    int step = 0;
    
    for(int i = 0; i <= reach && i <= nums.length -1 ;i++){
        if( i > lastReach){
            step++;
            lastReach = reach;
        }
        reach = Math.max(reach, nums[i] + i);
    }
    if(reach < nums.length - 1){
        return 0;
    }
    return step;
}

