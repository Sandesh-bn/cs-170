public int aToI(String str){
	if (str == null || str.length() == 0)
		return 0;
	
	// trim all spaces
	
	
	// deal with overflowing integers
	long number = 0;
	boolean isNegative = false;
	int i = 0, N = str.length();
	
	if (str.charAt(0) == '+'){
		i++;
	}
	else if (str.charAt(0) == '-'){
		isNegative = true;
		i++;
	}
	
	while (i < N){
		char ch = str.charAt(i);
		
		// if it's not a digit, return immediately
		if (!Character.isDigit(ch))
			return (isNegative)?-(int)number:(int)number;
		
		number = number * 10  + ch - '0';
		
		// check overflow
		if (isNegative && -sum < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		if (!isNegative && sum > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	}
	return (isNegative)?-(int)number: (int)number;
		
}

/*
input type
will it contain spacese
will it contain spaces in the middle
will it contain alphabets?
range of number
*/

test cases '               -123'
test cases '         +123 45'