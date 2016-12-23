public int[] plusOne(int[] sumArr){
	int[] res;
	List<Integer> result = new ArrayList<>();
	int carry = 1;
	for (int i = sumArr.length - 1; i >= 0; i--){
		result.add(0, (sumArr[i] + carry) % 10);
		carry = (sumArr[i] + carry)/10;
	}
	if (carry > 0)result.add(0, carry);
	res = new int[result.size()];
	for (int i = 0; i < res.length; i++)
		res[i] = result.get(i);
	return res;
}