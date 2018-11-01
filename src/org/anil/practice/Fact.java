package org.anil.practice;

public class Fact {

	public static void main(String[] args) {
		System.out.println(factorial(5));
	}

	private static String factorial(int n) {
		int[] res=new int[n*10];
		res[0]=1;
		int size=1;
		
		for(int i=2;i<=n;i++) {
			size=multiply(i,res,size);
		}
		StringBuilder sb=new StringBuilder();
		for(int i=size-1;i>=0;i--) {
			sb.append(res[i]);
		}
		
		return sb==null?null:sb.toString();
	}

	private static int multiply(int i, int[] res, int size) {
		int carry=0,val=0;
		for(int k=0;k<size;k++) {
			val=res[k]*i+carry;
			res[k]=val%10;
			carry=val/10;
		}
		while (carry!=0) {
			res[size++]=carry%10;
			carry=carry/10;
		}
		return size;
	}

}
