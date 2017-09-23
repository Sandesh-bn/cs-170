
// use code from ideserve find pivot in an array

// this code is from silent playlist. https://www.youtube.com/watch?v=gPt2BFU92dI
// doesn't work with one of the inputs

 public static  int numRotate(int[] A){
    int start = 0, end = A.length - 1;
    
    while(start < end){
      if (A[start] < A[end])
        //return end + 1;
        return start;
      
      else {
        int mid = (start + end)/2;
        
        if (A[start] <= A[mid]  && A[mid + 1] <= A[end])
          return mid + 1;
        else if (A[start] <= A[mid])
          start = mid + 1;
        else
          end = mid - 1;
      }
    }
    return 0;
  }


  // DOESNT WORK WITH DUPLCIATES