package aman.trees;

public class SizeOfTree {
	
	public int getSize(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		
		return 1 + getSize(root.left) + getSize(root.right);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(10);
		tree.root.left = new BinaryTreeNode(20);
		tree.root.right = new BinaryTreeNode(30);
		tree.root.left.left = new BinaryTreeNode(40);
		tree.root.left.right = new BinaryTreeNode(50);

		SizeOfTree obj = new SizeOfTree();
		int res = obj.getSize(tree.root);
		System.out.println("Size of tree: " + res);
	}

}
