package com.zyc.tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestTree {
	Tree<Integer> tree = new Tree<Integer>();
	@Before
	public void init(){
		Node<Integer> root = new Node<Integer>(1);
		Node<Integer> left = new Node<Integer>(2);
		Node<Integer> right = new Node<Integer>(3);
		Node<Integer> rightr = new Node<Integer>(4);
		Node<Integer> rightl = new Node<Integer>(5);
		Node<Integer> leftr = new Node<Integer>(6);
		Node<Integer> leftl = new Node<Integer>(7);
		root.setLeftChild(left);
		root.setRightChild(right);
		right.setRightChild(rightr);
		right.setLeftChild(rightl);
		left.setRightChild(leftr);
		left.setLeftChild(leftl);
		
		tree.setRoot(root);
	}
	@Test
	public void testXian(){
		System.out.println("===");
		for(int i=0;tree.cengci(tree.getRoot(), i)!=0;i++){
			System.out.println();
		}
		System.out.println("===");
		tree.zhong(tree.getRoot());
		System.out.println();
		System.out.println("===");
		tree.xian(tree.getRoot());
		System.out.println();
		System.out.println("====");
		tree.hou(tree.getRoot());
		System.out.println();
		System.out.println("====");
		
	}
	@Test
	public void testCengci(){
		for(int i=0;tree.cengci(tree.getRoot(), i)!=0;i++){
			System.out.println();
		}
	}
	@Test
	public void DuiPai(){
		List<Node<Integer>> nodes = new ArrayList<Node<Integer>>();
		for(int i=0;i<20;i++){
			nodes.add(new Node<Integer>(i));
		}
		Tree<Integer> tree = new Tree<>(nodes);
		for(int i=0;tree.cengci(tree.getRoot(),i)!=0;i++){
			System.out.println();
		}
	}
}
