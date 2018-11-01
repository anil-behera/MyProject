package org.anil.ms.morg;

public class CustomHeap {
	
	private final int defautCapacity=16;
	private int capacity;
	private int[] m;
	private int size;
	
	public CustomHeap() {
		this.capacity=defautCapacity;
		this.m=new int[this.capacity+1];
		this.size=0;
	}
	
	public CustomHeap(int capacity) {
		this.capacity=capacity;
		this.m=new int[this.capacity+1];
		this.size=0;
	}
	public void insert(int ob) {
		if(size==capacity) {
			System.out.println("Heap Full");
			return;
		}
		m[++size]=ob;
		bubbleUp(size);
	}

	private void bubbleUp(int pos) {
		int parent=pos/2;
		int current=pos;
		while(current>0 && m[current]<m[parent]) {
			swap(current,parent);
			current=parent;
			parent =parent/2;
		}
	}

	private void swap(int current, int parent) {
		int temp=m[current];
		m[current]=m[parent];
		m[parent]=temp;
	}
	
	public int extractMin() {
		int min=m[1];
		m[1]=m[size];
		m[size]=0;
		sinkDown(1);		
		size--;
		return min;
	}

	private void sinkDown(int root) {
		int small=root;
		int left=2*root;
		int right=2*root+1;
		
		if(left<size && m[small]>m[left]) {
			small=left;
		}
		if(right<size && m[small]>m[right]) {
			small=right;
		}
		if(small!=root) {
			swap(root,small);
			sinkDown(small);
		}
				
	}
	
	public void displayHeap(){
		for(int i=1;i<=size;i++) {
			System.out.print("  " +m[i]);
		}
	}
	
	public static void main(String[] args) {

        System.out.println("Output Expected : \nOriginal Array :   3  2  1  7  8  4  10  16  12\r\n" + 
        		"Min-Heap :  1 3 2 7 8 4 10 16 12\r\n" + 
        		"Extract Min :  1  2  3  4  7  8  10  12  16");
        System.out.println("====================");
		int arrA [] = {3,2,1,7,8,4,10,16,12};
		CustomHeap c=new CustomHeap(arrA.length);
		System.out.print("Original Array : ");
		System.out.println();
        for(int i=0;i<arrA.length;i++){
            System.out.print("  " + arrA[i]);
            c.insert(arrA[i]);
        }
        
        System.out.println();
        c.displayHeap();
        
        System.out.println();
        
        for(int i=0;i<arrA.length;i++){
            System.out.print("  " + c.extractMin());
        }
	}

}
