public boolean powerOfThree(int num){
	if (num < 1) return false;
	if (num == 1) return true;
	while (num > 2){
		if (num % 3 != 0)
			return false;
		num /= 3;
	}
	return num == 1;
}