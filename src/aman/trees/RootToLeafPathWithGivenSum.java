package aman.trees;

public class RootToLeafPathWithGivenSum {
	
	public boolean checkSumFromRootToLeaf(BinaryTreeNode root, int sum) {
		/*
		 * 
		 */
		
		if(root == null) {
			return sum==0;
		}
		
		boolean leftTreeSumCheck = checkSumFromRootToLeaf(root.left, sum - root.data);
		boolean rightTreeSumCheck = checkSumFromRootToLeaf(root.right, sum - root.data );
		
		
		if(leftTreeSumCheck || rightTreeSumCheck ) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(10);
		tree.root.left = new BinaryTreeNode(20);
		tree.root.right = new BinaryTreeNode(30);
		tree.root.left.left = new BinaryTreeNode(40);
		tree.root.left.right = new BinaryTreeNode(50);
		
		int sum=30;
		RootToLeafPathWithGivenSum obj = new RootToLeafPathWithGivenSum();
		boolean res = obj.checkSumFromRootToLeaf(tree.root, sum);
		System.out.println("Does path exist with given sum: " +  sum + " : " + res);

	}

}
