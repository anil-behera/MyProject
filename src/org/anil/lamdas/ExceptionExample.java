package org.anil.lamdas;

import java.util.function.BiConsumer;

public class ExceptionExample {
	
	public static void main(String[] args) {
		int[] ar= {1,2,3,4};
		int key=0;
		performOperation(ar,key,wrapperLamda((v,k)->System.out.println(v/k)));
	}

	private static void performOperation(int[] ar,int k, BiConsumer<Integer, Integer> con) {
		for(int v:ar)
		con.accept( v,k);
	}
	
	static BiConsumer<Integer, Integer> wrapperLamda(BiConsumer<Integer, Integer> con){
		return (v,k)->{
			try {
			con.accept(v, k);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}};
	}
}
