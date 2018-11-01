package org.anil.myprograms;

public class LoopLink {
  
	class Node{
    	int data;
    	Node next;
    	Node top;
    	Node(){
    	}
    	Node(int data){
    		this.data=data;
    		next=null;
    		top=null;
    	}
    	public void push(int data) {
    		if(head==null || head.data==0) {
    			head=new Node(data);
    			top=head;
    		}
    		else {
    			Node n=new Node(data);
    			top.next=n;
    			top=n;
    		}
    	}
    	public void show() {
    		Node tra=head;
			while(tra!=null) {
				System.out.println(tra.data);
				tra=tra.next;
			}
		}
    }
	
	Node head=new Node();
	
	public static void main(String[] args) {
		LoopLink ll=new LoopLink();
		ll.head.push(1);
		ll.head.push(2);
		ll.head.push(3);
		ll.head.show();
	}

}
