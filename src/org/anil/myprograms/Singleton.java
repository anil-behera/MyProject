package org.anil.myprograms;

import java.util.HashMap;

public class Singleton {
	public static volatile Singleton obj;
	HashMap<String, Integer> h=new HashMap<>();
	
	private Singleton() {}
	
	static Singleton getInstance() {
		if(obj==null) {
			synchronized (Singleton.class) {
				if(obj==null) {
					obj =new Singleton();
				}
			}
		}
		return obj;
	}

}
