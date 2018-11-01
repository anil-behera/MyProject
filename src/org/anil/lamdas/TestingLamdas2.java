package org.anil.lamdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestingLamdas2 {

	public static void main(String[] args) {
		List<Person> al = Arrays.asList(
				new Person("Anil", "Behera", 27),
				new Person("Michal", "Jackson", 27),
				new Person("Smiti", "Mishra", 26),
				new Person("Mousumi", "Mishra", 27),
				new Person("Amrita", "Rout", 27),
				new Person("Snehamayee", "Das", 27)				
				);
		
		System.out.println("----------Before Sorting------");
		
		al.stream().filter(p->p.getFirstName().startsWith("A")).
		forEach(System.out::println)
		;
		
		al.sort((p1,p2)-> p1.getLastName().compareTo(p2.getLastName()));
		
		System.out.println("-----------All------------");
		
		printConditionally(al,p->true,System.out::println);
		
		System.out.println("-----------Starts with A------------");
		
		printConditionally(al, p->p.getFirstName().startsWith("A"),p->System.out.println(p.getFirstName()));
		
		System.out.println("-----------End with M------------");
		
		printConditionally(al, p->p.getLastName().startsWith("M"),p->System.out.println(p.getFirstName()));
	}

	private static void printConditionally(List<Person> al, Predicate<Person> con,Consumer<Person> consumer) {
		
		for(Person p: al) {
			if(con.test(p)) {
				consumer.accept(p);
			}
		}
		
	}

}

/*@FunctionalInterface
interface Condition<T>{
	boolean test(T p);
}*/
