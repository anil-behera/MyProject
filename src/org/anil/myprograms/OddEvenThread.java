package org.anil.myprograms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class oddEven {
	int MAX = 20;
	int num = 1;
	boolean odd = true;

	public void printOdd() {
		synchronized (this) {
			while (num < MAX) {
				while (odd) {
					
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				System.out.println("odd: "+ num);
				num++;
				odd = true;
				notify();
			}
		}
	}

	public void printEven() {
		synchronized (this) {

			while (num < MAX) {
				while (!odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Even "+num);
				num++;
				odd = false;
				notify();
			}
		}
	}
}

public class OddEvenThread {
	
	boolean odd;
	int count = 1;
	int MAX = 20;
 
	public void printOdd() {
		synchronized (this) {
			while (count < MAX) {
				while (!odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Odd Thread :" + count);
				count++;
				odd = false;
				notify();
			}
		}
	}
 
	public void printEven() {
 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		synchronized (this) {
			while (count < MAX) { 
				while (odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Even thread :" + count);
				count++;
				odd = true;
				notify();
 
			}
		}
	}

	public static void main(String[] args) {
		OddEvenThread oddEven=new OddEvenThread();
				
		Thread t1 = new Thread(oddEven::printEven);
		Thread t2 = new Thread(oddEven::printOdd);
 
		t1.start();
		t2.start();
 
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
