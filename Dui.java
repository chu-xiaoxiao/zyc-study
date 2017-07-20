package com.zyc.tree;

public class Dui<T extends Comparable<T>> {
	private Tree<T> tree;
	
	public Dui() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dui(Node<T> root) {
		super();
		this.tree = new Tree<>(root);
	}

	public Tree<T> getTree() {
		return tree;
	}

	public void setTree(Tree<T> tree) {
		this.tree = tree;
	}
	
	public void add(Node<T> node,Node<T> add){
		if(add.getValue().compareTo(node.getValue())==-1){
			if(node.getLeftChild()==null){
				node.setLeftChild(add);
			}else{
				this.add(node.getLeftChild(), add);
			}
		}
		if(add.getValue().compareTo(node.getValue())==0||add.getValue().compareTo(node.getValue())==1){
			if(node.getRightChild()==null){
				node.setRightChild(add);
			}else{
				this.add(node.getRightChild(), add);
			}
		}
	}
	public void xiao(){
		
	}
}
