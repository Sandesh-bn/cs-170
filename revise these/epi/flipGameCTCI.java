Flip Bit to Win: You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to 
fi nd the length of the longest sequence of ls you could create. 

curr_run holds the number of current adjacent sequence of 1s
previous holds the number of previous adjacent sequence of 1s

 public static int returnMax(int num){
    int prev_run = 0, current_run = 0, maxSoFar = 1;
    while (num != 0){
      int current_bit = num & 1;
      num = num >> 1;
      if (current_bit == 1)
        current_run += 1;
      else {
        prev_run = current_run;
        current_run = 0;
      }
      maxSoFar = Math.max(maxSoFar, prev_run + current_run + 1);
    }
    return maxSoFar;
  }