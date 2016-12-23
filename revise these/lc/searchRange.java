public static int[] searchRange(int[] nums, int target){
		int[] ret = {-1, -1};
        int low = 0, high = nums.length - 1;
        while (low < high){
        	int mid = (low + high) / 2;
        	if (nums[mid] >= target)
        		high = mid;
        	else
        		low = mid + 1;
        		
        }
        if (nums[low] != target)
        	return ret;
		ret[0] = low;
		high = nums.length - 1;
		
		while (low < high){
			int mid = (low + high)/2 + 1;
			if (nums[mid] <= target)
				low = mid;
			else
				high = mid - 1;
				
				
		}
        ret[1] = high;
        
        return ret;
    }
	
/* remember it has to be while(low < high) not while (low <= high). say that you are skewing the search towards the right in the second while loop
*/