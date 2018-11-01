package org.anil.myprograms;

public class Rev {
	Node head;
	 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }
 
    public static void main(String[] args) {
    	Rev list = new Rev();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
         
        System.out.println("Before");
        list.printList(list.head);
        System.out.println("After ");
        list.printList(list.change(list.head));
    }

	private Node change(Node head2) {
		Node prev=null,cur=head2,next=null;
		while(cur!=null) {
			next=cur.next;
			cur.next=prev;
			prev=cur;
			cur=next;			
		}
		return prev;
	}
}
