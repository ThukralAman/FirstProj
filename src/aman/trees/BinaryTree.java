package aman.trees;

class BinaryTreeNode {
	int data;
	BinaryTreeNode left, right;
	
	BinaryTreeNode(int data) {
		this.data = data;
		left=right=null;
	}
	
	public boolean hasLeft() {
		return this.left !=null ? true : false;  
	}
	
	public boolean hasRight() {
		return this.right !=null ? true : false;  
	}
}

public class BinaryTree {
	
	BinaryTreeNode root;
	
	BinaryTree() {
		root = null;
	}
	
	BinaryTree(int data) {
		root = new BinaryTreeNode(data);
	}
	
	public void preOrder(BinaryTreeNode root) {
		if(root==null)
			return;
		else {
			System.out.print(root.data + ", ");
			preOrder(root.left);
			preOrder(root.right);
		}
		
	}
	
	public void inOrder(BinaryTreeNode root) {
		if(root==null)
			return;
		else {
			inOrder(root.left);
			System.out.print(root.data + ", ");
			inOrder(root.right);
		}
	}
	
	public void postOrder(BinaryTreeNode root) {
		if(root==null)
			return;
		else {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + ", ");
		}
	}
}