/*

http://www.ideserve.co.in/learn/find-the-element-that-appears-once-in-an-array
*/

// all elements appear thrice except one. find that one element.
// this works only if all the elements are postivie.
// if you want this to work on any integer set 
public int findOne(int[] arr){
	int count[] = new int[32];
	
	for (int num: arr){
		for (int k = 0; k < 32; k++){
			// 1 << k => 0, 1, 10, 100, 1000, 10000, 100000....
			int kthBitSet = 1 << k;
			
			// check if arr[i] has bit = 1 at index k.
			if ((num & kthBitSet) == kthBitSet)
				count[k]++;
		}
	}
	
	int ones = 0;
	for (int i = 0; i < count.length; i++)
		count[i] %= 3;
	
	
	// ones has the decimal representation of the number that occurs once.
	for (int i =  count.length - 1; i >= 0; i--)
		ones = ones + ((int)Math.pow(2, i) * count[i]);
	
	// take care of negative numbers
	return (ones < 0)? ones + 1:ones;
}
