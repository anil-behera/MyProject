package org.anil.javastream;

public class UsingLamdas {

	public static void main(String[] args) {
		System.out.println("Lamdas");
		AnySingleInterface si=(a,b)->{return a+b;};
		System.out.println(operation(si, 10, 20));
	}
	
	public static int operation(AnySingleInterface any,int a,int b) {
		return any.singleMethod(a, b);
	}
	
	
}

interface AnySingleInterface{
	int singleMethod(int a,int b);
}
