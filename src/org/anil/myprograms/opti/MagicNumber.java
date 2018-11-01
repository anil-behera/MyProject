/*
Challenge Description:
There are two wizards, one good and one evil. The evil wizard has captured the princess. The only way to defeat the evil wizard is to recite a set of magic numbers. The good wizard has given you two numbers, A and B. Find every magic number between A and B, inclusive.
A magic number is a number that has two characteristics:
No digits repeat.
Beginning with the leftmost digit, take the value of the digit and move that number of digits to the right. Repeat the process again using the value of the current digit to move right again. Wrap back to the leftmost digit as necessary. A magic number will visit every digit exactly once and end at the leftmost digit.
For example, consider the magic number 6231.
Start with 6. Advance 6 steps to 3, wrapping around once (6->2->3->1->6->2->3).
From 3, advance to 2.
From 2, advance to 1.
From 1, advance to 6.

=======================
6231 is magic because there is no duplicate digit and:
* in position 0 there is a 6, move to position 2 -> (0 + 6) % 4 = 2
* in position 2 there is a 3, move to position 1 -> (2 + 3) % 4 = 1
* in position 1 there is a 2, move to position 3 -> (1 + 2) % 4 = 3
* in position 3 there is a 1, move to position 0 -> (3 + 1) % 4 = 0
=======================

Input sample:
The input is a file with each line representing a test case. Each test case consists of two integers A and B on a line, separated by spaces. For all test cases 1 <= A <= B <= 10000.
10 100
8382 8841
Output sample:
For each test case print all magic numbers between A and B, inclusive, on one line, separated by spaces. If there is no magic number between A and B, print -1.
13 15 17 19 31 35 37 39 51 53 57 59 71 73 75 79 91 93 95 97
-1
Constraints:
The number of test cases is 20
 */


package org.anil.myprograms.opti;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class MagicNumber {
	public static void main(String[] args) {
		int cnt=0;
		for(int i=10;i<100;i++) {
			if(checkMagicNumber(i)) {
				System.out.print(i + " ");
				cnt++;
			}
		}
		if(cnt==0) {
			System.out.println(-1);
		}
	}

	private static boolean checkMagicNumber(int n) {
		int k=n;
		int r=0,numberofDigit=0,numberofVisit=0;
		HashSet<Integer> h=new HashSet<>();
		Stack<Integer> s=new Stack<>();
		ArrayList<Integer> al=new ArrayList<>();
		
		//checking duplicate
		while(k!=0) {
			r=k%10;
			if(!h.add(r)) {
				return false;
			}
			s.push(r);
			k=k/10;
			numberofDigit++;
		}
		
		while(!s.empty()) {			
			al.add(s.pop());
		}
		int pos = 0,cur=0;
		h=new HashSet<Integer>();
		while(numberofVisit<=numberofDigit+1) {			
			cur=pos+al.get(pos);
			numberofVisit++;
			pos=cur%numberofDigit;
			if(!h.add(pos)) {
				return false;
			}
			if(numberofDigit==numberofVisit && pos==0) {
				return true;
			}
		}		
		return false;
	}

}
