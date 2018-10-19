package aman.trees;

class Height {
	int height=0;
}

public class IsTreeBalanced {
	
	public boolean isBalancedHelper(BinaryTreeNode root, Height h) {
		if(root==null) {
			h.height=0;
			return true;
		}
		
		Height lHeight = new Height();
		Height rHeight = new Height();
		boolean lBalanced = isBalancedHelper(root.left, lHeight);
		boolean rbalanced = isBalancedHelper(root.right, rHeight);
		
		int lh = lHeight.height;
		int rh = rHeight.height;
		h.height = (lh > rh ? lh : rh) + 1;
		
		
		
		
		if(Math.abs(lh-rh) <= 1 && lBalanced && rbalanced) {
			return true;
		}
		System.out.println("Returning false" + root.data);
		return false;
		
	}
	
	public boolean isBalanced(BinaryTreeNode root) {
		if(root==null) {
			return true;
		}
		Height h = new Height();
		return isBalancedHelper(root, h);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(10);
		
		tree.root.left = new BinaryTreeNode(20);
		tree.root.right = new BinaryTreeNode(30);
		
		tree.root.left.left = new BinaryTreeNode(40);
		tree.root.left.right = new BinaryTreeNode(50);
		tree.root.right.right = new BinaryTreeNode(60);
		
		tree.root.left.left.left = new BinaryTreeNode(70);
		tree.root.right.right.right = new BinaryTreeNode(80);
		
		IsTreeBalanced obj = new IsTreeBalanced();
		boolean res = obj.isBalanced(tree.root);
		System.out.println("isBalanced: " + res);
		

	}

}
