public class abc {

	public static void main(String[] args) {
		int x=0x000F;
		int y=0x2222;
		System.out.println(x& y);
		
		int i=0;
		do {
			i++;
		}while(i<0);
			System.out.println(i);
			
			divide(4,1);
	}
	
	static private int divide(int a,int b) {
		int c=-1;
		try {
			c=a/b;
		} catch (Exception e) {
			System.out.println("error");
		}
		finally {
			System.out.println("erfinaror");
		}
		
		return c;
	}

}
