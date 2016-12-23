Write a method to count the number of 2s between O and n.

public static int numberOf2s(int n){
	int count = 0;
	for (int i = 2; i <= n; i++)
		count += getNumberOf2s(i);
	return count;
}

public static int getNumberOf2s(int n){
	int count = 0;
	while (n > 0){
		if (n % 10 == 2)
			count++;
		n /= 10;
	}
	return count;
}