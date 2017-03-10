 A popular masseuse receives a sequence of back-to-back appointment requests 
and is debating which ones to accept. She needs a 15-minute break between appointments and 
therefore she cannot  accept  any  adjacent  requests.  Given  a sequence  of  back-to-back appoint­
ment requests (all multiples of 15 minutes, none overlap, and none can be moved), fi nd the optimal 
(highest total booked minutes) set the masseuse can honor. Return the number of minutes. 
EXAMPLE 
Input:  {30,  15,  60,  75,  45,  15,  15,  45} 
Output:180  minutes  ({30,  60,  45,  45}).

check out the solution approach in the hard solution in ctci. only consider the iterative dp approache. it is 
very simple

public int maxMinutes(int[] arr){
    int even = 0, odd = 0;
    for (int i = arr.length - 1; i >= 0; i--){
        int bestWith = arr[i] + even;
        int bestWithout = odd;
        even = odd;
        odd = Math.max(bestWith, bestWithout);
    }
    return odd;

}