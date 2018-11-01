package org.anil.myprograms;

import java.util.LinkedList;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		List<String> l=new LinkedList<>();
		
		l.add("abc");
		l.add("Def");
		
		for(String s:l) {
			System.out.println(s);
		}
	}

}
