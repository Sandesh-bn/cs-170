public String intToRoman(int num){
	Map<Integer, String> thousand = new HashMap<>();
	thousand.put(0, "");
	thousand.put(1, "M");
	thousand.put(2, "MM");
	thousand.put(3, "MMM");
	
	Map<Integer, String> hundred = new HashMap<>();
	hundred.put(0, "");
	hundred.put(1, "C");
	hundred.put(2, "CC");
	hundred.put(3, "CCC");
	hundred.put(4, "CD");
	hundred.put(5, "D");
	hundred.put(6, "DC");
	hundred.put(7, "DCC");
	hundred.put(8, "DCCC");
	hundred.put(9, "CM");
	
	Map<Integer, String> tens = new HashMap<>();
	tens.put(0, "");
	tens.put(10, "X");
	tens.put(20, "XX");
	tens.put(30, "XXX");
	tens.put(40, "XL");
	tens.put(50, "L");
	tens.put(60, "LX");
	tens.put(70, "LXX");
	tens.put(80, "LXXX");
	tens.put(90, "XC");
	
	Map<Integer, String> tens = new HashMap<>();
	tens.put(0, "");
	tens.put(1, "I");
	tens.put(2, "II");
	tens.put(3, "III");
	tens.put(4, "IV");
	tens.put(5, "V");
	tens.put(6, "VI");
	tens.put(7, "VII");
	tens.put(8, "VIII");
	tens.put(9, "IX");
	
	return thousand.get(num / 1000) +
		   hundred.get((num % 1000) / 100) +
		   tens.get((num % 100)/10) +
		   ones.get((num % 10));
		   

	
}