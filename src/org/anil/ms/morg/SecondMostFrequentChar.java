package org.anil.ms.morg;

/*
 Program to find second most frequent character
 * */

import java.util.HashMap;
import java.util.Map;

public class SecondMostFrequentChar {

	public static void main(String[] args) {
		String s = "geeksforgeeks";
		Integer highest = 0, second = 0;
		// Character highestch=0,secondch=0;
		HashMap<Character, Integer> h = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (h.containsKey(s.charAt(i))) {
				h.put(s.charAt(i), h.get(s.charAt(i)) + 1);
			} else {
				h.put(s.charAt(i), 1);
			}
		}
		System.out.println(h);
		for (Map.Entry<Character, Integer> m : h.entrySet()) {
			if (m.getValue() > highest) {
				second = highest;
				// secondch=highestch;
				// highestch=m.getKey();
				highest = m.getValue();
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (h.get(s.charAt(i)) == second) {
				System.out.println(s.charAt(i));
				break;
			}
		}
	}

}
