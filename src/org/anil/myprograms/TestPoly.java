package org.anil.myprograms;

class A{
	int a =10;
	void display() {
		System.out.println("Class A");
	}
}

class B extends A{
	int a=20;
	void display() {
		System.out.println("Class B");
	}
}
public class TestPoly {

	public static void main(String[] args) {
		A ob=new B();
		System.out.println("Variable : "+ob.a);
		ob.display();
	}

}
