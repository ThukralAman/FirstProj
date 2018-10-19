package aman.trees;

public class CheckTwoTreesIdentical {
	
	public boolean checkIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {
		/*
		 *  1. if both roots are null => return true
		 *  2. if one of the root is null => return false
		 *  3. check for checkIdentical(	)
		 */
		
		
		if(root1 == null && root2==null) {
			return true;
		}else {
			if(root1 == null || root2 == null) {
				return false;
			}else {
				return root1.data==root2.data && checkIdentical(root1.left, root2.left) && checkIdentical(root1.right, root2.right);
			}
			
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(10);
		tree.root.left = new BinaryTreeNode(20);
		tree.root.right = new BinaryTreeNode(30);
		tree.root.left.left = new BinaryTreeNode(40);
		tree.root.left.right = new BinaryTreeNode(50);
		
		BinaryTree tree2 = new BinaryTree();
		tree2.root = new BinaryTreeNode(10);
		tree2.root.left = new BinaryTreeNode(20);
		tree2.root.right = new BinaryTreeNode(30);
		tree2.root.left.left = new BinaryTreeNode(40);
		tree2.root.left.right = new BinaryTreeNode(50);
		//tree2.root.left.right.left = new BinaryTreeNode(60);
		
		CheckTwoTreesIdentical obj = new CheckTwoTreesIdentical();
		boolean res = obj.checkIdentical(tree.root, tree2.root);
		System.out.println("trees identical: " + res);

	}

}
