package org.anil.ms.morg;

public class MissingNumber {

	public static void main(String[] args) {
		int[] ar= {1,2,3,4,5,6,7,9,10};
		int num=0;
		for(int i=0;i<20;i++) {
			if(!(ar[i]==i+1)) {
				num=i+1;
				break;
			}
			
		}
		System.out.println(num);
		int n=10;
		int total=(n*(n+1))/2;
		int arraysum=0;
		
		for(int i=0;i<n-1;i++)
			arraysum+=ar[i];
		
		num=total-arraysum;
		
		System.out.println(num);
		
	}

}
