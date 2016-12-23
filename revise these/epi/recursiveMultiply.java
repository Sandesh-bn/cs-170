public static int multiply(int a, int b){
	int result = multiplyAbs(Math.abs(a), Math.abs(b));
	if (a < 0 && b < 0)
		return result;
	else if (a < 0 || b < 0)
		return -result;
	return result;
}

public static int multiplyAbs(int a, int b){
    if (a == 0 || b == 0) return 0;
	if (a == 1) return b;
    return multiplyAbs(a - 1, b) + b;
  }