package org.anil.lamdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicate {

	public static void main(String[] args) {
		List<Character> car=Arrays.asList('A','N','I','L' ,'B','E','H','E','R','A');
		StringBuilder sb=new StringBuilder();
		
		car.forEach(c->sb.append(c));

		System.out.println(sb);
		
		StringBuilder sbc=new StringBuilder();
		
		car.stream()
			.filter(c->(sbc.indexOf(c.toString())==-1))
			.forEach(c->sbc.append(c));
		
		System.out.println(sbc);
		
		/*String s="Anil Behera";
		char[] car=s.toLowerCase().toCharArray();
		StringBuilder sbc=new StringBuilder();
		
		Arrays.stream(car)
		.filter(c->(c!='a'))
		.forEach(c->sbc.append(c));
		
		System.out.println(sbc);*/
			
		
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
