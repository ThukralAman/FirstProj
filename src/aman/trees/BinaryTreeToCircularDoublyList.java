package aman.trees;


/*
 * https://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/
 */
public class BinaryTreeToCircularDoublyList {
	
	public void printCircularList(BinaryTreeNode node) {
		BinaryTreeNode temp = node;
		while(temp.right !=node) {
			System.out.println(temp.data + ", ");
			temp = temp.right;
		}
		System.out.println(temp.data + ", ");
	}
	
	public BinaryTreeNode combineList(BinaryTreeNode leftList, BinaryTreeNode rightList) {
		if(leftList==null) {
			return rightList;
		}
		if(rightList==null) {
			return leftList;
		}
		
		BinaryTreeNode leftLast = leftList.left;
		BinaryTreeNode rightLast = rightList.left;
		
		leftLast.right = rightList;
		rightList.left = leftLast;
		
		leftList.left = rightLast;
		rightLast.right = leftList;
		
		return leftList;
		
		
	}
	
	public BinaryTreeNode binaryTreeToCircularDoublyLinkedList(BinaryTreeNode root) {
		if(root == null) {
			return root;
		}
		
		BinaryTreeNode leftList = binaryTreeToCircularDoublyLinkedList(root.left);
		BinaryTreeNode rightList = binaryTreeToCircularDoublyLinkedList(root.right);
		
		root.left = root;
		root.right = root;
		/*System.out.println("root = " + root.data);
		
		printCircularList(combineList(leftList, combineList(root, rightList)));
		System.out.println("-------------------");*/
		
		return combineList(leftList, combineList(root, rightList));
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(10);
		
		tree.root.left = new BinaryTreeNode(12);
		tree.root.right = new BinaryTreeNode(15);
		
		tree.root.left.left = new BinaryTreeNode(25);
		tree.root.left.right = new BinaryTreeNode(30);
		tree.root.right.right = new BinaryTreeNode(36);
		
		BinaryTreeToCircularDoublyList obj = new BinaryTreeToCircularDoublyList();
		BinaryTreeNode res = obj.binaryTreeToCircularDoublyLinkedList(tree.root);
		obj.printCircularList(res);
		
	}

}
