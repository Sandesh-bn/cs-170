Design an O(n) time algorithm to compute the k elements closest to
the median of an array A.
Solution 10.7: There exists two standard algorithms for computing the median in
O(n) time-one uses randomized partitioning of the array; the other uses divide and
conquer, specifically,it computes the median of the medians of rn/51 subarrays.
Assuming that we have computed the median 11 in O(n) time, we can compute
the k elements closest to 11 by maintaining a max-heap H of elements of the array.
The value associated with the i-th element A[i] is its distance to the median, i.e.,
III- A[lll. Westart by adding the first k elements of the array to H. Now we process
the remaining elements. For j = k to n - I, if median- A[j]!is larger than the maximum
value stored in the heap, we ignore it; otherwise, we remove the maximum element
of H, and insert A[j] in its place. When all elements are processed, the heap contains
the k elements dosest to the median.

public List<Integer> kSmallest(int[] A){
    int median = getMedian(A);
    PriorityQueue<Integer> heap = new PriorityQueue<>(Collectons.reverseOrder());
    for (int i = 0; i < k; i++)
        heap.offer(A[i]);
    for (int i = k; i < N; i++){
        if (median - A[i] > heap.peek()){
            heap.poll();
            heap.offer(A[i]);
        }

    }

}