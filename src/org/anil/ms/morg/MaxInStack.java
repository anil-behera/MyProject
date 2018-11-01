package org.anil.ms.morg;

import java.util.Stack;

/*
 Tracking current Maximum Element in a Stack
Given a Stack, keep track of the maximum value in it. The maximum value may be the top element of the stack, 
but once a new element is pushed or an element is pop from the stack, the maximum element will be now from the rest of the elements.

Examples:

Input : 4 19 7 14 20
Output : Max Values in stack are 
         4 19 19 19 20

Input : 40 19 7 14 20 5
Output :  Max Values in stack are 
         40 40 40 40 40 40
 * */

public class MaxInStack {
	Stack<Integer> mainStack=new Stack<Integer>();
	Stack<Integer> max=new Stack<Integer>();
	public static void main(String[] args) {
		MaxInStack m=new MaxInStack();		
		int[] ar= {4,19,7,14,20};
		for(int i=0;i<ar.length;i++) {
			m.push(ar[i]);
			System.out.println("Max :" +m.getMaxInStack());
		}
		System.out.println("Poped : "+m.pop());
		System.out.println("Max :" +m.getMaxInStack());
		
	}
	
	public void push(int i) {
			mainStack.push(i);
			if(mainStack.size()==1) {
				max.push(i);
				return;
			}
			if(i>max.peek()) {
				max.push(i);
			}
			else {
				max.push(max.peek());
			}
	}
	
	public int pop() {
		if(mainStack.isEmpty()) {
			return 0;
		}
		max.pop();
		return mainStack.pop();
		
	}
	
	public int getMaxInStack() {
		return max.peek();
	}

}
