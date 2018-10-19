package aman.trees;
/*
 * https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 */
public class ChildrenSumProperty {
	
	public boolean checkChildrenSumProperty(BinaryTreeNode root) {
		if(root == null || (root.left==null && root.right==null)) {
			return true;
		}
		
		int lData=0;
		int rData=0;
		if(root.left !=null) {
			lData = root.left.data;
		}
		
		if(root.right !=null) {
			rData = root.right.data;
		}
		
		if(root.data == (lData + rData) && checkChildrenSumProperty(root.left) && checkChildrenSumProperty(root.right)) {
			return true;
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(10);
		
		tree.root.left = new BinaryTreeNode(8);
		tree.root.right = new BinaryTreeNode(2);
		
		tree.root.left.left = new BinaryTreeNode(3);
		tree.root.left.right = new BinaryTreeNode(5);
		tree.root.right.right = new BinaryTreeNode(2);
		
		
		
		ChildrenSumProperty obj = new ChildrenSumProperty();
		boolean res = obj.checkChildrenSumProperty(tree.root);
		System.out.println("child-sum propery valid: " + res);
	}

}
