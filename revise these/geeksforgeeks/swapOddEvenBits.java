http://www.geeksforgeeks.org/swap-all-odd-and-even-bits/

https://www.youtube.com/watch?v=GWLCF808oVI
int onesInEven = 0xAAAAAAAA;
int onesInOdd = 0x55555555;
int even = num & onesInEven; // m has all even bits from num
even = even >> 1; // shift even bits to odd position.

int odd = num & onesInOdd; //odd has all odd bits from num
odd = odd << 1; // shift odd bits to even position.

res = odd | even;