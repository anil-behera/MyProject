package org.anil.ms.morg;

class ClassA{
	public ClassA() {
		System.out.println(this.getClass().getName());
	}
}

public class ClassB  extends ClassA{
	
	public ClassB(){
		System.out.println(this.getClass().getName());
	}

	public static void main(String[] args) {
		
		ClassA a=new ClassA();
		
		ClassA a1=new ClassB();
		
		ClassB b=new ClassB();

	}

}
