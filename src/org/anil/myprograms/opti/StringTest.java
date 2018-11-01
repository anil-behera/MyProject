package org.anil.myprograms.opti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StringTest {

	public static void main(String[] args) {
		String s2=null;
		System.out.println("Enter the String");
		try(Scanner sc=new Scanner(System.in)){
			s2=sc.next();
		}
		stringformat(s2);
	}
	private static void stringformat(String s2){		

		String s="Beginning with the leftmost digit take the value of the digit and move that number of digits to the right Repeat the process again using the value of the current digit to move right again Wrap back to the leftmost digit as necessary A magic number will visit every digit exactly once and end at the leftmost digit";
		String[] s1=s.split(" ");
		HashMap<String, Integer> h=new HashMap<>();
		int cnt=0,totalnumb=0;
		
		for(int i=0;i<s1.length-1;i++) {
			if(s1[i].equals(s2)) {
				totalnumb++;
			if(h.containsKey(s1[i+1])) {
				cnt=h.get(s1[i+1]);
				h.put(s1[i+1],cnt+1);
			}
			else {
				h.put(s1[i+1],1);
			}
		}
		}
		
		Set<Map.Entry<String, Integer>> set = h.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
            	if(o2.getValue()== o1.getValue()) {
            		return o1.getKey().compareTo(o2.getKey());
            	}
            	else {
            		return (o2.getValue()).compareTo( o1.getValue() );
            	}
            }
        } );
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<String, Integer> entry:list){
            sb.append(entry.getKey() +"="+ String.format("%.3f", (double)entry.getValue()/totalnumb)+";");
        }
        System.out.println(sb.substring(0,sb.length()-1));
	}

		
}
