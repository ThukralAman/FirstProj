package aman.trees;

public class MaxDepthOrHeightOfTree {
	
	public int findMaxDepthOrHeight(BinaryTreeNode root) {
		
		/*
		 *  1. return => 1 + max( depth(root.left), depth(root.right) )
		 *  2. Terminating condition:
		 *  	- if root/node has no children => return 1
		 *  	- if root/node is null => return 0 
		 */
		
		if(root ==null)  {
			return 0;
		}
		
		if(root.left==null && root.right==null) {
			return 1;
		}else {
			int MaxLeftDepth = findMaxDepthOrHeight(root.left);
			int MaxRightDepth = findMaxDepthOrHeight(root.right);
			if(MaxLeftDepth > MaxRightDepth) {
				return 1 + MaxLeftDepth;
			}else {
				return 1 + MaxRightDepth;
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
		tree.root.left.left.left = new BinaryTreeNode(60);
		
		
		MaxDepthOrHeightOfTree obj = new MaxDepthOrHeightOfTree();
		int maxDepthOrHeight = obj.findMaxDepthOrHeight(tree.root);
		System.out.println("Max depth or Height is: " + maxDepthOrHeight);

	}

}
