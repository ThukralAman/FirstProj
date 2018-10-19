package aman.trees;

/*
 * https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * 
 * Similar question: https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 */




public class DiamaeterBinaryTree {
	
	public int getDiameterHelper(BinaryTreeNode root, Height h) {
		
		if(root==null) {
			h.height = 0;
			return 0;
		}
		
		Height lHeight = new Height();
		Height rHeight = new Height();
		
		
		int lDiameter = getDiameterHelper(root.left, lHeight);
		int rDiameter = getDiameterHelper(root.right, rHeight);
		
		
		
		int lh = lHeight.height;
		int rh = rHeight.height;
		h.height = 1 + Math.max(lh, rh);
		
		return Math.max((1 + lh + rh) , Math.max(lDiameter, rDiameter));
	}
	
	
	
	public int getDiameter(BinaryTreeNode root) {
		if(root==null) {
			return 0;
		}
		
		/*
		 *  Diameter: longest path between two leaf nodes. It may or may not pass through the root node
		 *  So Diameter = Max(
		 *  	- Diameter of left sub tree
		 *  	- Diameter of right Sub tree
		 *  	- Longest path between leaf nodes that goes through root node
		 *  )
		 * 
		 * Apply this recursively to all nodes
		 * 
		 * Now to calculate longest path going through root node
		 * 	- calculate height of left subtree
		 * 	- calculate height of right sub tree
		 * Longest path = 1 + heightLeftSubTree + HeightRiightSubTree
		 * 
		 * So above approach (recursive approach) will calculate left and right height of subtrees for each node.
		 * Hence time complexity will be O(n^2) for skewed tree
		 * 
		 *  ----- Better Approach
		 *  Pass the height from leaves to root and reuse the information and calculate longest path.
		 *  Just pass info of height of leftchild and right child from leaves onto their parents and so on. 
		 *  This will enable each node to NOT recalculate height of their left and right children.
		 *  
		 *  
		 *  And to help a node to get height info of their left and right children, it needs to pass Height object to both children 
		 *  - This passed Height object will work as pass by reference, since when left and right child return, 
		 *  - the values of heights they updated in their function execution will also be reflected in the 
		 *  - height object passed by their parent
		 *  
		 *   
		 * 
		 * 
		 * 
		 * 
		 */
		
		return  getDiameterHelper(root, new Height());
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
		
		DiamaeterBinaryTree obj = new DiamaeterBinaryTree();
		int res = obj.getDiameter(tree.root);
		System.out.println("diameter = " + res);

	}

}
