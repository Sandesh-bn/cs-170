Note: The result may be very large, so you need to return a string instead of an integer.
Analysis:
An intuitive way to solve the problem is to sort the numbers by some order and then combine the numbers together by descending order.
The question is how should we sort the number? Apparently, it should not be sorted by the integer value. Given two numbers, how do we know which one is "bigger" in term of the combination results is bigger? It is pretty strait forward, just get the two string combinations and compare which one is bigger. For example, [12, 121], since 12121 is greater than 12112, 12121 is the number we want.
The code is pretty strait forward except don't forget to handle the special case of [0, 0], the result should be "0"  rather then "00" as there is no number of "00". 

We need to build a new comparator with a comparison mechanism to sort the array to 9,5,34,3,30. The mechanism is to realize the largest number so if we have two numbers, for example, 30 and 34, there are two ways to form a number, 3034 and 3430, clearly 34 30 will be larger, similarly, using this mechanism, we can sort the array, 30<<3<<34<<5<<9, after we sort the array this way, we can easily find the largest number.


The only thing needs to take care is the leading zeros in the final results. If there are leading zeros, it must be the case like 0, 0, 0, 0 ... i.e all array elements must be 0. In this case, return "0".

A simple solution that comes to our mind is to sort all numbers in descending order, but simply sorting doesn’t work. For example, 548 is greater than 60, but in output 60 comes before 548. As a second example, 98 is greater than 9, but 9 comes before 98 in output.

So how do we go about it? The idea is to use any comparison based sorting algorithm. In the used sorting algorithm, instead of using the default comparison, write a comparison function myCompare() and use it to sort numbers. Given two numbers X and Y, how should myCompare() decide which number to put first – we compare two numbers XY (Y appended at the end of X) and YX (X appended at the end of Y). If XY is larger, then X should come before Y in output, else Y should come before. For example, let X and Y be 542 and 60. To compare X and Y, we compare 54260 and 60542. Since 60542 is greater than 54260, we put Y first.


public class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0)
          return "0";
        
        String s_val[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            s_val[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s_val, new StringComparator());
        System.out.println(Arrays.toString(s_val));
        /** happens when all elements are zero. 
         * after sorting in descending order, the first 
         * element will be 0 . Return 0*/
        if (s_val[0].charAt(0) == '0')
           return "0";
        
        StringBuilder ret = new StringBuilder();
        for (String num: s_val)
          ret.append(num);
          
        return ret.toString();
    }
}

class StringComparator implements Comparator<String>{
    public int compare(String num1, String num2){
        String s1 = num1 + num2;
        String s2 = num2 + num1;
        return s2.compareTo(s1); // sort in descending order.
    }
}