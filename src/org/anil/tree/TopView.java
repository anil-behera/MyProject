package org.anil.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopView {

	static class QueueObj {
		Node<Integer> node;
		int hd;

		QueueObj(Node<Integer> node, int hd) {
			this.node = node;
			this.hd = hd;
		}
	}

	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(12);
		root.left = new Node<Integer>(10);
		root.right = new Node<Integer>(30);
		root.right.left = new Node<Integer>(25);
		root.right.right = new Node<Integer>(40);
		root.right.left.right = new Node<Integer>(6);
		root.right.left.right.left = new Node<Integer>(18);
		root.right.left.right.right = new Node<Integer>(7);

		BTreePrinter.printNode(root);

		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		topView(root, mp);
		mp.entrySet().forEach(p -> System.out.println(p.getValue()));
	}

	private static void topView(Node<Integer> root, Map<Integer, Integer> mp) {
		if (root == null)
			return;
		Queue<QueueObj> q = new LinkedList<QueueObj>();
		q.add(new QueueObj(root, 0));
		while (!q.isEmpty()) {
			QueueObj obj=q.poll();
			if (!mp.containsKey(obj.hd)) {
				mp.put(obj.hd, obj.node.data);
			}
			if(obj.node.left !=null)
				q.add(new QueueObj(obj.node.left, obj.hd-1));
			if(obj.node.right !=null)
				q.add(new QueueObj(obj.node.right, obj.hd+1));			
			
		}

	}

}
