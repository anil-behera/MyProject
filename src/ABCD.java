import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

import org.anil.myprograms.opti.MagicNumber;
import org.anil.myprograms.serialization.models.Employee;

public class ABCD {

	public static void main(String[] args) {
		/*if(1==1) {
			System.out.println("A");
		}
		System.out.println(Integer.MAX_VALUE);
		
		PriorityQueue<Employee> p=new PriorityQueue<>(7,(x,y)-> x.getId()-y.getId());
		*/
		int i=0;
		ArrayList<Integer> al=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		while(i<5) {
			al.add(sc.nextInt());
			findMedian(al);
			i++;
		}
	}

	private static void findMedian(ArrayList<Integer> al) {
		int s=al.stream().reduce(0, (sum,item)->sum+item);
		System.out.println((double)s/al.size());
	}

}
