package org.anil.tree;

public class Node<T> {
	Node<T> left,right;
	T data;
	public Node(T data) {
		this.data=data;
		this.left=this.right=null;
	}
	@Override
	public String toString() {
		return this.data.toString();
	}
}
