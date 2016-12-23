/*
 Given a positive integer, print the next smallest and the next largest number that 
have the same number of 1 bits in their binary representation.
*/

explanation here: http://pochenfullwave.ddns.net/?p=364

public class SameOnes {
	
	public static int getNextSmallest(int i) {
		int num = 0;
		String str = Integer.toBinaryString(i);
		for(int m = 0; m < str.length(); m++ ) {
			if(str.charAt(m) == '0')
				num++;
		}
		
		int tempInt = 0;
		while ( tempInt!= num) {
			tempInt = 0;
			i = i+1;
			String tempStr = Integer.toBinaryString(i);
			for(int n = 0; n < tempStr.length(); n++ ) {
				if(tempStr.charAt(n) == '0')
					tempInt++;
			}
		}
		
		return i;
	}
	
	public static int getNextLargest(int i) {
		int num = 0;
		String str = Integer.toBinaryString(i);
		for(int m = 0; m < str.length(); m++ ) {
			if(str.charAt(m) == '1')
				num++;
		}
		
		int tempInt = 0;
		while ( tempInt!= num) {
			tempInt = 0;
			i = i-1;
			String tempStr = Integer.toBinaryString(i);
			for(int n = 0; n < tempStr.length(); n++ ) {
				if(tempStr.charAt(n) == '1')
					tempInt++;
			}
		}
		
		return i;
	}
	
	public static void main(String[] args) {
		int i = 90;
		
		
		getNextSmallest(i);
		System.out.println("所输入数字i的二进制: " + Integer.toBinaryString(i));
		System.out.println("最小的大于i的数字是: " + Integer.toBinaryString(getNextSmallest(i)));
		System.out.println("最大的小于i的数字是: " + Integer.toBinaryString(getNextLargest(i)));
		
	}
	
	

}