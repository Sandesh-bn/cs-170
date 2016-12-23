/*
Pairwise Swap: Write a program to swap odd and even bits in an integer with as few instructions as 
possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
*/

public static void pairWiseBitSwap(int val){
    	System.out.println(Integer.toBinaryString(val));
    	int odd = (val & 0Xaaaaaaaa); //  0Xaaaaaaaa => 10101010 odd contains all odd bits of val
    	int even = (val & 0x55555555); // 0x55555555 => 01010101 even contains all the even bits of val.
    	System.out.println(Integer.toBinaryString(odd));
    	System.out.println(Integer.toBinaryString(even));
    	
    	int oddShifted = odd >>> 1;  // perform logical right shift to fill sign bit with 0
    	int evenShifted = even << 1;
    	System.out.println(Integer.toBinaryString(oddShifted));
    	System.out.println(Integer.toBinaryString(evenShifted));
    	
    	int res = oddShifted | evenShifted;
    	System.out.println(Integer.toBinaryString(res));
  }