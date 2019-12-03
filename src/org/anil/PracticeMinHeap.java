package org.anil;

import org.anil.ms.morg.CustomHeap;

public class PracticeMinHeap {

	private int ar[];
	int size;

	public PracticeMinHeap(final int CAPACITY) {
		ar = new int[CAPACITY + 1];
		size = 0;
	}

	public void insertToHeap(int v) {
		ar[++size] = v;
		bubbleUp(size);
	}

	public int extractMin() {
		int min = ar[1];
		ar[1] = ar[size];
		ar[size] = 0;
		bubbleDown(1);
		size--;
		return min;
	}

	private void bubbleUp(int pos) {
		int parent = pos / 2;
		int loc = pos;
		while (loc > 0 && ar[loc] < ar[parent]) {
			swap(loc, parent);
			loc = parent;
			parent = loc / 2;
		}
	}

	private void swap(int loc, int parent) {
		int tmp = ar[loc];
		ar[loc] = ar[parent];
		ar[parent] = tmp;
	}

	private void bubbleDown(int root) {
		int small = root;
		int left = 2 * root;
		int right = 2 * root + 1;
		if (left < size && ar[small] > ar[left]) {
			small = left;
		}
		if (right < size && ar[small] > ar[right]) {
			small = right;
		}
		if (small != root) {
			swap(root, small);
			bubbleDown(small);
		}
	}
	
	public void displayHeap() {
		for (int i = 1; i <= size; i++) {
			System.out.print("  " + ar[i]);
		}
	}

	public static void main(String[] args) {

		System.out.println("Output Expected : \nOriginal Array :   3  2  1  7  8  4  10  16  12\r\n"
				+ "Min-Heap :  1 3 2 7 8 4 10 16 12\r\n" + "Extract Min :  1  2  3  4  7  8  10  12  16");
		System.out.println("====================");
		int arrA[] = { 3, 2, 1, 7, 8, 4, 10, 16, 12 };
		PracticeMinHeap c = new PracticeMinHeap(arrA.length);
		System.out.print("Original Array : ");
		System.out.println();
		for (int i = 0; i < arrA.length; i++) {
			System.out.print("  " + arrA[i]);
			c.insertToHeap(arrA[i]);
		}

		System.out.println();
		c.displayHeap();

		System.out.println();

		for (int i = 0; i < arrA.length; i++) {
			System.out.print("  " + c.extractMin());
		}

	}

}
