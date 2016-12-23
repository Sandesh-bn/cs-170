public String addBinary(String a, String b){
	if (a.length() < 1) return b;
	if (b.length() < 1) return a;
	StringBuilder sb = new StringBuilder();
	int i = a.length() - 1, j  = b.length() - 1, valA = 0, valB = 0, carry = 0;
	while (i >= 0 || j >= 0){
		valA = (i >= 0)?a.charAt(i) - '0':0;
		valB = (j >= 0)?b.charAt(j) - '0':0;
		int sumDigit = valA + valB + carry;
		carry = (sumDigit > 1)?1:0;
		sb.append(sumDigit % 2);
		i--;j--;
	}
	if (carry > 0)
		sb.append(carry);
	return sb.reverse().toString();
}