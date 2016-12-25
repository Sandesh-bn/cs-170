Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?

public int sum(int num){
	sum = 0;
	Set<Integer> sumValues = new HashSet<>();
	while (num > 9){
		int sum = 0;
		while (sum > 0){
			sum += (num % 10);
			num /= 10;
		}
		if (!sumValues.add(sum))
			return Integer.MIN_VALUE;
		num = sum;
	}
	return num;
}