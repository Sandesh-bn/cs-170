how would you sort a almost sorted array

what is big o for insertion based algo
O(nk)
what is big o for heap based algo
O(nlogk)

public void sort(int[] arr, int k){
	 PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	  for (int i = 0; i < k; i++) {
		minHeap.add(nums[i]);
	  }

	  for (int i = 0; i < nums.length; i++) {
			if(i + k < nums.length) {
				minHeap.add(nums[i + k]);
			}
			nums[i] = minHeap.remove();
	  }
} 