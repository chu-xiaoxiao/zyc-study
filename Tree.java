package com.zyc.tree;

import java.util.List;

public class Tree<T> {
	private Node<T> root;

	public Tree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tree(Node<T> root) {
		super();
		this.root = root;
	}

	public Tree(List<Node<T>> nodes) {
		this.root = nodes.get(0);
		for (int i = 1; i < nodes.size(); i++) {
			add(root, nodes.get(i));
		}
	}

	private void add(Node<T> tRoot, Node<T> temp) {
		if (tRoot.getLeftChild() == null) {
			temp.setParent(tRoot);
			tRoot.setLeftChild(temp);
		}else if (tRoot.getRightChild() == null) {
			temp.setParent(tRoot);
			tRoot.setRightChild(temp);
		}else {
			if (tRoot.getParent() != null) {
				if (tRoot.getParent().getLeftChild().getLeftChild() == null
						|| tRoot.getParent().getLeftChild().getRightChild() == null) {
					add(tRoot.getLeftChild(), temp);
				} else if(tRoot.getParent().getRightChild().getLeftChild()==null||tRoot.getParent().getRightChild()==null){
					add(tRoot.getLeftChild(), temp);
				}else{
					add(tRoot.getLeftChild(), temp);
				}
			}else{
				if(tRoot.getLeftChild().getLeftChild()==null||tRoot.getLeftChild().getRightChild()==null){
					add(tRoot.getLeftChild(), temp);
				}else if(tRoot.getRightChild().getLeftChild()==null||tRoot.getRightChild().getRightChild()==null){
					add(tRoot.getRightChild(), temp);
				}else{
					add(tRoot.getLeftChild(), temp);
				}
			}
		}
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public void zhong(Node<T> node) {
		if (node.getLeftChild() != null) {
			zhong(node.getLeftChild());
		}
		System.out.print(node.getValue());
		if (node.getRightChild() != null) {
			zhong(node.getRightChild());
		}
	}

	public void xian(Node<T> node) {
		System.out.print(node.getValue());
		if (node.getLeftChild() != null) {
			xian(node.getLeftChild());
		}
		if (node.getRightChild() != null) {
			xian(node.getRightChild());
		}
	}

	public void hou(Node<T> node) {
		if (node.getLeftChild() != null) {
			hou(node.getLeftChild());
		}
		if (node.getRightChild() != null) {
			hou(node.getRightChild());
		}
		System.out.print(node.getValue());
	}

	public Integer cengci(Node<T> node, int leve) {
		if (node == null || leve < 0) {
			return 0;
		}
		if (leve == 0) {
			System.out.print(node.getValue() + ",");
			return 1;
		}
		return (cengci(node.getLeftChild(), leve - 1) + cengci(node.getRightChild(), leve - 1));
	}
}
