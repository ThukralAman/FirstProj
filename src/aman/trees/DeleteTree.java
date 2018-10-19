package aman.trees;

public class DeleteTree {

	public void deleteTree(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		
		deleteTree(root.left);
		deleteTree(root.right);
		
		System.out.println("deleting node: " + root.data);
		root=null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(10);
		tree.root.left = new BinaryTreeNode(20);
		tree.root.right = new BinaryTreeNode(30);
		tree.root.left.left = new BinaryTreeNode(40);
		tree.root.left.right = new BinaryTreeNode(50);
		
		DeleteTree obj = new DeleteTree();
		
		obj.deleteTree(tree.root);

		
		
	}

}
