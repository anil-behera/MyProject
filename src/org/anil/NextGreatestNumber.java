package org.anil;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatestNumber {

	public static void main(String[] args) {
		// int ar[] = { 1, 2, 3, 10, 23, 1, 2, 5, 6 };
		int ar[] = { 3, 2, 1, 10, 1, 2, 3, 11, 4 };
		System.out.println(Arrays.toString(ar));
		System.out.println("==================");
		Stack<Integer> s = new Stack<>();
		s.push(ar[0]);
		int top;
		for (int i = 1; i < ar.length; i++) {
			if (!s.isEmpty()) {
				top = s.pop();
				//this while loop will pop all the element and make the stack empty 
				//once we encounter the greatest element
				while (ar[i] > top) {
					System.out.println(top + " --- " + ar[i]);
					if (s.isEmpty()) {
						break;
					} else {
						top = s.pop();
					}
				}
				//we need to push the top element again coz if the while loop is not
				//executed then we will lose the top element that is popped at line 18.
				//condition should be opposite of while loop
				if (top > ar[i]) {
					s.push(top);
				}

			}
			//we need to push all the element to the stack as 
			//we are operating on the stack for our logic
			//and also for worst case scenario we need all the element in the stack
			s.push(ar[i]);
		}
		while (!s.isEmpty()) {
			System.out.println(s.pop() + " --- " + -1);
		}
	}
}
