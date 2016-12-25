public boolean search(int[] nums, int target) {
    int start  = 0, end = nums.length - 1;
    
    //check each num so we will check start == end
    //We always get a sorted part and a half part
    //we can check sorted part to decide where to go next
    while(start <= end){
        int mid = start + (end - start)/2;
        if(nums[mid] == target) return true;
        
        //if left part is sorted
        if(nums[start] < nums[mid]){
            if(target < nums[start] || target > nums[mid]){
                //target is in rotated part
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }else if(nums[start] > nums[mid]){
            //right part is rotated
            
            //target is in rotated part
            if(target < nums[mid] || target > nums[end]){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }else{
            //duplicates, we know nums[mid] != target, so nums[start] != target
            //based on current information, we can only move left pointer to skip one cell
            //thus in the worest case, we would have target: 2, and array like 11111111, then
            //the running time would be O(n)
            start ++;
        }
    }
    
    return false;
}


///// ANOTHER SOLUTION
 public boolean search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
    	int mid = (left + right) / 2;
    	if (nums[mid] == target)
    		return true;
    	if (nums[mid] < nums[right]) { //right side in order.
    		if (target > nums[mid] && target <= nums[right]) {
    			left = mid + 1;
    		} else {
    			right = mid - 1;
    		}
    	} else if (nums[mid] > nums[right]){ // left side in order.
    		if (target < nums[mid] && target >= nums[left]) {
    			right = mid - 1;
    		} else {
    			left = mid + 1;
    		}
    	} else { //nums[mid] == nums[right], no idea, can only eliminate nums[right].
    		right--;
    	}
    }
    return false;
}


worst case is O(n). e.g. find 0 in 111111111110111. 

//MY SUBMISSION
public class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = low + (high - low) /2 ;
            if (nums[mid] == target)
               return true;
            else if (nums[low] < nums[mid]){
                if (nums[low] <= target && target < nums[mid])
                   high = mid - 1;
                else
                   low = mid + 1;
            }
            else if (nums[low] > nums[mid]){
                if (nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                   high = mid - 1;
            }
            else 
              low += 1;//high -= 1; will not work for case [1, 3] 3
        }
        return false;
    }
}