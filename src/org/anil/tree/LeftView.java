package org.anil.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeftView {

	public static void main(String[] args) {
		Node<Integer> root = new Node(12);
		root.left = new Node(10);
		root.right = new Node(30);
		root.right.left = new Node(25);
		root.right.right = new Node(40);
		root.right.left.right = new Node(6); 
	    root.right.left.right.left = new Node(18); 
	    root.right.left.right.right = new Node(7);

		BTreePrinter.printNode(root);

		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		
		System.out.println("Using Recursion");
		leftView(root, 0, mp);
		mp.entrySet().forEach(p -> System.out.println(p.getValue()));
		System.out.println("Using Queue");
		leftView(root);

	}

	private static void leftView(Node<Integer> root) {
		if (root == null)
			return;

		Queue<Node<Integer>> q = new LinkedList<Node<Integer>>();
		q.add(root);
		q.add(null);// This is like a delimiter for a current level
		while (!q.isEmpty()) {
			Node<Integer> tmp = q.peek();
			if (tmp != null) {
				System.out.println(tmp.data);
				// This inner loop is to make sure to add all the
				// child elements in the queue for a current level
				while (tmp != null) {
					if (tmp.left != null)
						q.add(tmp.left);
					if (tmp.right != null)
						q.add(tmp.right);
					// once done processing the child node need to remove the
					// parent from the queue to process remaining
					q.remove();
					tmp = q.peek();
				}
				q.add(null);
			}
			// when the inner loop ends then we have encountered the null element
			// so need to remove the null from queue
			q.remove();
		}

	}

	private static void leftView(Node<Integer> root, int level, Map<Integer, Integer> mp) {
		if (root == null)
			return;
		if (!mp.containsKey(level)) {
			mp.put(level, root.data);
		}
		leftView(root.left, level + 1, mp);
		leftView(root.right, level + 1, mp);
	}

}
