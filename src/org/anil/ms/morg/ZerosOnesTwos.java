package org.anil.ms.morg;

import java.util.Arrays;

public class ZerosOnesTwos {
	
	public static void main(String[] args) {
		int[] ar= {2,2,2,2,1,1,0,2};
		System.out.println(Arrays.toString(sortZeros1s2s(ar)));
	}
	
	static int[] sortZeros1s2s(int[] ar){
		int c0=0,c1=0,c2=ar.length-1,temp=0;
		
		while(c1<=c2) {
			if(ar[c1]==0) {
				temp=ar[c0];
				ar[c0]=ar[c1];
				ar[c1]=temp;
				c0++;
				c1++;
			}
			else if(ar[c1]==1) {
				c1++;
			}
			else if(ar[c1]==2) {
				temp=ar[c2];
				ar[c2]=ar[c1];
				ar[c1]=temp;
				c2--;
			}
		}
		
		return ar;
	}
}
