package org.anil.ms.morg;

import java.util.PriorityQueue;

public class KthSmallestElement {
	
	public static void main(String[] args) {
		int[] ar= {10,20,3,40,5,60,7,80,9};
		
		int k=5;// 4th Smallest
		int j=1;
		
		PriorityQueue<Integer> p=new PriorityQueue<>();
		for(int i=0;i<ar.length;i++) {
			p.offer(ar[i]);
		}
		System.out.println(p);
		while(j<k) {
			p.poll();
			j++;
		}
		System.out.println(p.peek());
	}

}
