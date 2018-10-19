package aman.trees;
/*
 * 
 * wrongly implemented.. needs correction
 * 
 */
import java.util.Stack;

public class IterativeInOrderTraversal {
	
	public void iterativeInorderTreeTraversal(BinaryTreeNode root) {
		
		/*
		 *  Initially add the root to top of Stack
		 * 
		 *  1. traverse from root to its left most child and 
		 *  	- keep on adding root to stack on each iteration
		 *  2. pop out first element on stack say TOP_ELEMENT and print it
		 *  3. 	- if TOP_ELEMENT has right child, then 
		 *  		> PUSH it in stack
		 *  		> go to step1
		 *  	- else go step2
		 */ 
		
		if(root == null) {
			return;
		}
		Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
		st.push(root);
		
		while(!st.isEmpty()) {
			
			while(root.left !=null) {
				st.push(root.left);
				root = root.left;
			}
			
			
			while(root.right == null) {
				// popping left most root
				BinaryTreeNode poppedRoot = st.pop();
				System.out.println(poppedRoot.data + ", ");
				// popping one node above the earlier popped left root
				if(!st.isEmpty()) {
					root = st.pop();
				}
				
			}
		
			// Till now we have processed all left part of root and root
			BinaryTreeNode rightchildOfPoppedNode = root.right;
			System.out.println(root.data + ", ");
			if(rightchildOfPoppedNode != null) {
				st.push(rightchildOfPoppedNode);
			}
			
			root = rightchildOfPoppedNode;
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(10);
		
		tree.root.left = new BinaryTreeNode(20);
		tree.root.right = new BinaryTreeNode(30);
		
		/*tree.root.left.left = new BinaryTreeNode(40);
		tree.root.left.right = new BinaryTreeNode(50);
		tree.root.right.left = new BinaryTreeNode(60);
		
		tree.root.right.right = new BinaryTreeNode(70);*/
		
		
		IterativeInOrderTraversal obj = new IterativeInOrderTraversal();
		obj.iterativeInorderTreeTraversal(tree.root);
		
		
	}

}
