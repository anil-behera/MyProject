package org.anil.javastream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChkStream {

	public static void main(String[] args) {
		List<String> al=new ArrayList<String>();
		
		al.add("Anil");
		al.add("Litu");
		al.add("Amrita");
		al.add("Smiti");
		al.add("Linky");
		System.out.println(al);
		
		System.out.println("=========START1=============");		
		System.out.println(al.stream()
							 .filter(item->item.startsWith("A"))
							 .collect(Collectors.toList()));
		
		System.out.println("=========START2=============");
		System.out.println( al.stream()
							  .filter(item->item.startsWith("L"))
							  .reduce((con,item)->con + " + "+ item)
							  .get()
							);
		
		System.out.println("==========START3============");
		System.out.println(al.stream()
							 .filter(item->item.startsWith("A"))
							 .reduce("",(sum,item)-> sum + " + " + item)
							 
							);
		
		System.out.println("===========START4===========");
		System.out.println(al.stream()
							 .filter(item->item.startsWith("Z"))
							 .reduce((sum,item)-> sum + " + " + item)
							 .orElse("Abc")     ///If the Reduce returns null then the orElse Optional Value will be returned  ,.get() will give  java.util.NoSuchElementException: No value present
							);
		
		System.out.println("======MAP==============");
		
		Map<String,String> mp=new HashMap<>();
		mp.put("Smiti", "Anil");
		mp.put("Litu", "Linky");
		mp.put("Amrita", "Anil");
		System.out.println(mp);
		
		System.out.println("=========Stream========");
		
		System.out.println(mp.entrySet()
							 .stream()
							 .map(p->p.getKey() + "+" + p.getValue())
							 .collect(Collectors.toList())
							 
							);
				
		
		
		
	}
	

}
