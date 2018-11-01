package org.anil.myprograms;

import java.util.function.BooleanSupplier;

public class Test {

	public static void main(String[] args) {
		/*char c='A';
		int j=(int)c;
		
		boolean a=true,b=true;
		System.out.println(b^a);
		System.out.println(0x10+10+010);
		
		int k=0,l=0;
		
		for(int i=0;i<=3;i++) {
			k++;
			if(i==2) continue;
			l++;
		}
		System.out.println(k+" "+l);
		
		System.out.println(6+5+"1"+2+3);*/
		BooleanSupplier bs=()->9>7;
		System.out.println(bs.getAsBoolean());

	}

}
