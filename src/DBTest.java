import java.util.ArrayList;

class A{
	Integer a,b;
	
	public void doSomething(Integer a,Integer b){
		a=a*10;
		b=b/2;
	}
}

public class DBTest {

	public static void main(String[] args) {
		
		A a1 =new A();
		Integer a=2,b=20;
		
		System.out.println(a +" "+b);
		
		a1.doSomething(a, b);
		
		System.out.println(a +" "+b);
		
		System.out.println("----------------");
		
		Integer x=10,y=20;
		
		
		System.out.println(x +" "+y);
		
		xyz(x, y);
		
		System.out.println(x +" "+y);
		
	}
	

	static public void xyz(Integer a,Integer b){
		Integer temp;
		temp=a;
		a=b;
		b=temp;
	}

}
