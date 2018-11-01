package org.anil.myprograms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class MergeLink {

	public static void main(String[] args) {
		LinkedList<Integer> l1=new LinkedList<>();
		LinkedList<Integer> l2=new LinkedList<>();
		LinkedList<Integer> merged=new LinkedList<>();
		Integer a=0,b=0;
		
		l1.addAll(Arrays.asList(3,5,10,13));
		l2.addAll(Arrays.asList(12,3,15,4,9,8,7,1));
		Collections.sort(l1);
		Collections.sort(l2);
		
		System.out.println(l1);
		System.out.println(l2);
		
		
		
		//Merging the two arrays
		
		/*if(l1.size()==0) {
			merged=l2;
		}
		else if (l2.size()==0) {
			merged=l1;
		}
		else {*/
			Iterator<Integer> i1=l1.iterator();
			Iterator<Integer> i2=l2.iterator();
			if(i1.hasNext()) {
				a=i1.next();
			}
			if(i2.hasNext()) {
				b=i2.next();
			}
			while(a!=0 && b!=0) {
				if(a>=b) {
					merged.add(b);
					if(i2.hasNext()) {
						b=i2.next();
					}
					else {
						b=0;
					}
				}
				else if(b>a) {
					merged.add(a);
					if(i1.hasNext()) {
						a=i1.next();
					}
					else {
						a=0;
					}
				}
			}
			if(a==0) {
				merged.add(b);
				while(i2.hasNext()) {
					merged.add(i2.next());
				}
			}
			if(b==0) {
				merged.add(a);
				while(i1.hasNext()) {
					merged.add(i1.next());
				}
			}
		//}
		System.out.println(merged);
		
		System.out.println(l1.size() +" + " +l2.size() + " = " + merged.size());
	}

}
