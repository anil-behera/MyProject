package org.anil.lamdas;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AdditionUsingThread {
	static int a, b, c, d;

	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in)) {
			
			System.out.println("Enter a");
			a=sc.nextInt();
			
			System.out.println("Enter b");
			b=sc.nextInt();
			
			System.out.println("Enter c ");
			c=sc.nextInt();
			
			System.out.println("Enter d");
			d=sc.nextInt();
		}
		ExecutorService executor=Executors.newFixedThreadPool(2);
		
		Future<Integer> f1=executor.submit(()->a+b);
		Future<Integer> f2=executor.submit(()->c+d);
		
		try {
			System.out.println("sum = " +(f1.get()+f2.get()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}