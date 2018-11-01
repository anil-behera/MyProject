package org.anil.ms.morg;

import java.util.HashMap;

public class BasicQntns {

	public static void main(String[] args) {
		HashMap<String, String> h=new HashMap<>();
		
		String s1="abcc";
		
		System.out.println(s1.indexOf('c'));
		System.out.println(s1.lastIndexOf('c'));
		h.put(s1, "value");
		
		System.out.println(h.get(new String("abcc")));
		
		print(null);
		
		//System.out.println(NullInteger());
	}
	
	/*static int NullInteger() {
		Integer i=null;
		return i;
	}*/
	
	/*static int withReturninTry() {
		int i;
		try {
			i=10;
		} finally {
			return i;
		}
	}*/
	
	static public void print(Object o) {
		System.out.println("In Object Method");
	}
	
	static public void print(String o) {
		System.out.println("In String Method");
	}
	
	/*static public void print(Integer o) {
		System.out.println("In Integer Method");
	}*/

}
