package com.zyc.tree;

public class Node<T> {
	private T value;
	private Node<T> leftChild;
	private Node<T> rightChild;
	private Node<T> parent;
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Node(T value) {
		super();
		this.value = value;
	}


	public Node(T value, Node<T> leftChild, Node<T> rightChild, Node<T> parent) {
		super();
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.parent = parent;
	}


	public T getValue() {
		return value;
	}


	public void setValue(T value) {
		this.value = value;
	}


	public Node<T> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}
	public Node<T> getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}


	public Node<T> getParent() {
		return parent;
	}


	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	
	
}
