package org.anil.ms.morg;

/*
 https://www.programcreek.com/2015/01/leetcode-find-median-from-data-stream-java/
 
 Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 
 First of all, it seems that the best time complexity we can get for this problem is O(log(n)) of add() and O(1) of getMedian(). 
 This data structure seems highly likely to be a tree.

 We can use heap to solve this problem. In Java, the PriorityQueue class is a priority heap. 
 We can use two heaps to store the lower half and the higher half of the data stream. The size of the two heaps differs at most 1.
 * */

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfRunningInteger {

	public static void main(String[] args) {
		PriorityQueue<Integer> pmax=new PriorityQueue<>((x,y)->y.compareTo(x));//Collections.reverseOrder());
		PriorityQueue<Integer> pmin=new PriorityQueue<>();
		int[] ar= {5, 15, 1, 3};
		for(int i=0;i<ar.length;i++) {
			pmax.offer(ar[i]);
			pmin.offer(pmax.poll());
			if(pmax.size()<pmin.size()) {
				pmax.offer(pmin.poll());
			}
			if(pmax.size()==pmin.size()) {
				System.out.println((double) (pmax.peek()+pmin.peek())/2);
			}
			else {
				System.out.println(pmax.peek());
			}
		}
		
		System.out.println(pmax);
		System.out.println(pmin);
	}

}
