package org.anil.ms.morg.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Node{
	int data;
	Node left,right;
	Node(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}

class QueuePack{
	Node node;
	int level;
	public QueuePack(int level,Node n) {
		this.node=n;
		this.level=level;
	}
}

public class TopView {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		printInOrder(root);
		
		System.out.println();
		
		topView(root, 0);
		
		System.out.println("\n Height");
		
		System.out.println(heightOfTree(root));

		//TopViewBT p = new TopViewBT();
		//p.topView(root, 0);
	}
	
	static void printInOrder(Node n) {
		if(n==null)
			return;
		
		
		
		System.out.print(n.data + " ");
		
		printInOrder(n.left);
		
		printInOrder(n.right);
	}
	
	public static void topView(Node n,int level) {
		Queue<QueuePack> q=new LinkedList<>();
		Map<Integer,Node> h=new HashMap<>();
		
		int lvl=level;
		
		q.add(new QueuePack(level, n));
		
		while(!q.isEmpty()) {
			QueuePack n1=q.poll();
			lvl=n1.level;
			
			if(!h.containsKey(lvl)) {
				System.out.print(n1.node.data + " ");
				h.put(lvl,n1.node);
			}
			if(n1.node.left!=null) {
				q.add(new QueuePack(lvl-1, n1.node.left));
			}
			if(n1.node.right!=null) {
				q.add(new QueuePack(lvl+1, n1.node.right));
			}
		}
		//System.out.println(h);
		
	}
	
	static int heightOfTree(Node root) {
		if(root==null) {
			return 0;
		}else {
			int left=1+heightOfTree(root.left);
			int right=1+heightOfTree(root.right);
			if(left>right)
				return left;
			else
				return right;
		}
	}

}
