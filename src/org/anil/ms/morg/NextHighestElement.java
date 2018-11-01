package org.anil.ms.morg;

import java.util.Arrays;
import java.util.Scanner;

/*
 Given a number n, find the smallest number that has same set of digits as n and is greater than n. If x is the greatest possible number with its set of digits, then print “not possible”.

Examples:
For simplicity of implementation, we have considered input number as a string.

Input:  n = "218765"
Output: "251678"

Input:  n = "1234"
Output: "1243"

Input: n = "4321"
Output: "Not Possible"

Input: n = "534976"
Output: "536479"
 */

public class NextHighestElement {

	public static void main(String[] args) {
		/*System.out.println("Enter Number");
		int n=new Scanner(System.in).nextInt();*/
		
		int n=534976;
		System.out.println("Input : "+ n);
		char[] car=(n+"").toCharArray();
		
		System.out.println(Arrays.toString(car));
		int i=0;
		
		for(i=car.length-1;i>0;i--) {
			if(car[i-1]<car[i]) {
				break;
			}
		}
		if(i==0) {
			System.out.println("Impossible");
		}
		else {
			int min=i-1,nextMin=car.length-1;
			//System.out.println(car[i]);
			for(int j=i+1;j<car.length;j++) {
				if(car[j]<car[i] && car[j]>car[min]) {
					nextMin=j;
				}
			}
			char temp=car[min];
			car[min]=car[nextMin];
			car[nextMin]=temp;
			
			System.out.println(Arrays.toString(car));
			
			Arrays.sort(car,min+1,car.length);
			
			System.out.println(Arrays.toString(car));
			
			System.out.println("Output : "+Integer.parseInt(new String(car)));
			
		}
	
	}

}
