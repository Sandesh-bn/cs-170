public static int[] searchRange(int[] nums, int target){
int[] ret = {-1, -1};
        int N = nums.length; 
        int l = 0, h = N - 1;
        while(l < h){
            int mid = (l + h)/2;
            if (nums[mid] < target)
                l = mid + 1;
            else
                h = mid;
        }
        if (nums[l] != target) return ret;
        ret[0] = l;
        
        h = N - 1;
        
        while(l < h){
            int mid = (l + h)/2 + 1;
            if (nums[mid] > target)
                h = mid - 1;
            else
                l = mid;
        }
        ret[1] = h;
        return ret;
    }
	
/* remember it has to be while(low < high) not while (low <= high). say that you are skewing the search towards the right in the second while loop
*/