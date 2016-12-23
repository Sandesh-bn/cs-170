// Get bit
/*
This method shifts 1 over by i bits, creating a value that looks like 00010000. By performing an AND with 
num, we clear all bits other than the bit at bit i. Finally, we compare that to 0. If that new value is not zero, 
then bit i must have a 1. Otherwise, bit i is a 0. 
*/

boolean getBit(int num, int i){
	return ((num & (1 << i)) != 0);
}

// Set bit
/*
Set Bit  shifts 1 over by i  bits, creating a value like 00010000. By perfo rming an OR with num, only the 
value at bit i will change. All other bits of the mask are zero and will not affect num. 
*/
int setBit(int num, int i){
	return num | (1 << i);
}

// Clear bit
/*
This method operates in almost the reverse of setBi t. First, we create a number like 11101111 by creating 
the reverse of it (00010000) and negating it. Then, we perform an AND with num. This will clear the ith bit 
and leave the remainder unchanged. 
*/
int clearBit(int num, int i){
	int mask = ~(1 << i);
	return num & mask;
}

/*
To  clear all bits from the most signifi cant bit through i (inclusive), we create a mask with a 1 at the ith bit (1 
< <  i). Then, we subtract 1 from it, giving us a sequence of 0s followed by i ls. We then AND our number 
with this mask to leave just the last i bits. 
*/
int clearBitsMSBthroughI(int num, int i){
	int mask = (1 << i) - 1;
	return num & mask;
}


/*
To clear all bits from i through 0 (inclusive), we take a sequence of all ls (which is -1) and shift it left  by i 
+ 1 bits. This gives us a sequence of 1 s (in the most signifi cant bits) fo llowed by i 0 bits.
*/

int clearBitsMSBthrough0(int num, int i){
	int mask = (-1 << (1 + i));
	return num & mask;
}

// Update bit
/*
To clear all bits from i through 0 (inclusive), we take a sequence of all ls (which is -1) and shift it left  by i 
+ 1 bits. This gives us a sequence of 1 s (in the most signifi cant bits) fo llowed by i 0 bits.

*/

int updateBit(int num, int i, boolean bitIs1){
	int value = bitIs1 ? 1: 0;
	int mask = ~(1 << i);
	return (num & mask) | (value << i);
}