 Design an algorithm to find the smallest K numbers in an array. 

 // you can sort it and return the first k elements(O(n log n))
 // maintain a heap of size k and keep iterate through the array and insert the elemets
 // into the heap O(nlogk)
 
 
 int[] smallestK(int[] array, int k){
	 if (k < 0 || k > array.length)
		 throw new RuntimeException();
	 
	 PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
	 
	 for (int a: array){
		 if (heap.size() < k)
			 heap.offer(a);
		 else if (a < heap.peek()){
			 heap.poll();
			 heap.offer(a);
		 }
	 }
	 
	 int[] array = new int[heap.size()];
	 while (!heap.isEmpty())
		 array[heap.size() - 1] = heap.poll();
	 
	 return array;
 }