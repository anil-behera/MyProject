package org.anil.ms.morg;
/*Largest even number possible by using one swap operation in given number

Input : 1235785
Output :1535782
Swap 2 and 5.

Input :  536425
Output :  536524
Swap 4 and 5 to make the largest even number.

Find the first even number less than or equal to the odd number at last index.
If found, swap both values. Else swap with the last even value in the string.
If not possible to make even, print the given string.

 * */

public class MakeLargestEven implements Cloneable{

	public static void main(String[] args) {
		String s="536425";
		System.out.println(changetoEven(s));
	}

	private static String changetoEven(String s) {
		int even;
		char ch;
		char odd=s.charAt(s.length()-1);
		StringBuilder myName = new StringBuilder(s);
		
		//System.out.println(odd);
		
		for(int i=0;i<s.length();i++) {
			even=Integer.parseInt(s.charAt(i)+"");
			if(even%2==0) {
				ch=s.charAt(i);
				if(even<Integer.parseInt(odd+"")) {
					myName.setCharAt(i, odd);
					myName.setCharAt(s.length()-1, ch);
					break;
				}
			}
		}
		
		return myName.toString();
		
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
