package org.anil.myprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAna {

	public static void main(String[] args) {
		String[] ar= {"cat","tac","tacc","act"};
		int count=0;
		
		Arrays.sort(ar);
		
		for(int i=0;i<ar.length-1;i++) {
			for(int j=1;j<ar.length-1;j++) {
				if(!checkAna(ar[i], ar[j])) {	
					count++;
				}
			}
		}
		
		System.out.println(count);
		
		//new ArrayList<Integer>().trimToSize();

	}
	
	private static boolean checkAna(String s1,String s2) {
		boolean status=true;
		if(s1.length()!=s2.length())
			return false;
		else {
			char[] car=s1.toLowerCase().toCharArray();
			StringBuilder sb=new StringBuilder(s2.toLowerCase());
			int index=-2;
			for(char c: car) {
				index=sb.indexOf(""+c);
				
				if(index!=-1) {
					sb.deleteCharAt(index);
				}
				else {
					status=false;
					break;
				}
			}
			return status;
		}
	}

}
