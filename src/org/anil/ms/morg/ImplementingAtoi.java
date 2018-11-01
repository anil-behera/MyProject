package org.anil.ms.morg;
/*
 Your task  is to implement the function atoi. The function takes a string(str) as argument and converts it to an integer and returns it.
 
Example(To be used only for expected output) :
Input:
2
123
21a

Output:
123
-1
 */

public class ImplementingAtoi {

	public static void main(String[] args) {
		System.out.println(atoi("-123"));

	}
	
	public static int atoi(String str) {
		if (str == null || str.length() < 1)
			return 0;
	 
		// trim white spaces
		str = str.trim();
	 
		char flag = '+';
	 
		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		double result = 0;
	 
		// calculate value
		while (str.length() > i) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			}
			else {
				return -1;
			}
			i++;
		}
	 
		if (flag == '-')
			result = -result;
	 
		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	 
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
	 
		return (int) result;
	}

}
