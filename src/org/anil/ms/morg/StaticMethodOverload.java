package org.anil.ms.morg;

class A{
	static public void print(int x) {
		System.out.println("A : "+x);
	}
}

public class StaticMethodOverload extends A {
	
	static public void print(int x) {
		System.out.println("child : "+x);
	}
	
	/*public void print(int x) {
		System.out.println("A : "+x);
	}*/

	public static void main(String[] args) {
		A a=new StaticMethodOverload();
		a.print(2);
	}

}
