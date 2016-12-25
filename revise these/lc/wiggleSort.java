Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?

// make a copy of array, copy
// sort copy

there are two halfs in sorted array, larger half, smaller half
fill odd indices with larger half
// iterate array through i = 1 to N -1 i += 2;ie iterate through odd indices.
// iterate copy throught j = N - 1 to len/2;
// array[i] = copy[j]

retain j value, set i = 0
// iterate array through i = 0 to N - 1 i +=2; ie iterate through even indices
// iterate copy through j = j to 0
// array[i] = copy[j]

public void wiggleSort(int[] nums){
	int[] copy = new int[nums.length];
	for (int i = 0; i < nums.length; i++)
		copy[i] = nums[i];
	int i = 1, j = nums.length - 1;
	while (i < nums.length){
		nums[i] = copy[j--];
		i += 2;
	}
	i = 0;
	
	while (i < nums.length){
		nums[i] = copy[j--];
		i += 2;
	}
	
}

