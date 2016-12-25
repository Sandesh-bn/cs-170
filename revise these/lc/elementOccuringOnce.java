Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

public class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> uniq = new HashSet<>();
        for (int num: nums)
            if (!uniq.add(num))
                uniq.remove(num);
        int[] ret = new int[2];
        Iterator iter = uniq.iterator();
        int i = 0;
        while(iter.hasNext())
            ret[i++] = (int)iter.next();
        return ret;
    }
}

public class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> uniq = new HashSet<>();
        for (int num: nums)
            if (!uniq.add(num))
                uniq.remove(num);
        
        Object[] arr = uniq.toArray();
        int[] ret = new int[arr.length];
        ret[0] =(int)arr[0];
        ret[1] = (int)arr[1];
        return ret;
    }
}
