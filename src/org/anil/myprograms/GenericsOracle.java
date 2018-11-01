package org.anil.myprograms;

import java.util.ArrayList;
import java.util.List;

public class GenericsOracle {

	public static void main(String[] args) {
		List<Integer> al=new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		//al.add("Inte");
		addto(al);
		
		System.out.println(al.size());
		
		for(Object i:al) {
			System.out.println(i);
		}
	}
	
	static void addto(List al) {
		al.add("abc");
		al.add("element");
	}

}
