package aman.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/*
 *  List of questions:
 *  1. https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 *  2. https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 *  9. https://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
 * 
 * 
 * 
 */

public class AllTreeQuestions {
	
	
	public void mirrorTree(BinaryTreeNode root) {
		// https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
		
		
		if(root==null) {
			return;
		}
		
		mirrorTree(root.left);
		mirrorTree(root.right);
		
		BinaryTreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllTreeQuestions obj = new AllTreeQuestions();
		
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(10);
		
		tree.root.left = new BinaryTreeNode(20);
		tree.root.right = new BinaryTreeNode(30);
		
		tree.root.left.left = new BinaryTreeNode(40);
		tree.root.left.right = new BinaryTreeNode(50);
		tree.root.right.right = new BinaryTreeNode(60);
		
		tree.root.left.left.left = new BinaryTreeNode(70);
		tree.root.right.right.right = new BinaryTreeNode(80);
		obj.mirrorTree(tree.root);
		tree.preOrder(tree.root);

	}*/
	
	// ---------------------- 2  https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/-----------------------------------------------------
	public BinaryTreeNode findLCAinBSTRecursive(BinaryTreeNode root, int n1, int n2) {
		if(root==null) {
			return root;
		}
		
		if( root.data > n1 && root.data > n2 ) {
			return findLCAinBSTRecursive(root.left, n1, n2);
		}else if( root.data < n1 && root.data < n2) {
			return findLCAinBSTRecursive(root.right, n1, n2);
		}
		
		return root;
	}
	
	public BinaryTreeNode findLCAinBSTIterative(BinaryTreeNode root, int n1, int n2) {
		if(root==null) {
			return root;
		}
		
		if(root.data > n1 && root.data > n2) {
			root = root.left;
		}else if(root.data < n1 && root.data < n2) {
			root = root.right;
		}
		
		return root;
		
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllTreeQuestions obj = new AllTreeQuestions();
		
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(50);
		
		tree.root.left = new BinaryTreeNode(30);
		tree.root.right = new BinaryTreeNode(70);
		
		tree.root.left.left = new BinaryTreeNode(20);
		tree.root.left.right = new BinaryTreeNode(40);
		tree.root.right.left = new BinaryTreeNode(60);
		
		tree.root.left.left.left = new BinaryTreeNode(70);
		tree.root.right.right.right = new BinaryTreeNode(80);
		//BinaryTreeNode res = obj.findLCAinBSTRecursive(tree.root, 20, 40);
		BinaryTreeNode res = obj.findLCAinBSTIterative(tree.root, 20, 40);
		System.out.println("LCA: " + res.data);

	}*/
	
	
	// -------------------------- 3 https://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-tree/ -----------------------------------------------------
	
	public BinaryTreeNode findMinInBST(BinaryTreeNode root) {
		
		if(root == null) {
			return root;
		}
		
		//********* Iterative solution ******
		
		/*while(root.left!=null) {
			root = root.left;
		}
		
		return root*/
		
		// ******** Recursive solution ******************
		if(root.left == null) {
			return root;
		}
		
		return findMinInBST(root.left);
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllTreeQuestions obj = new AllTreeQuestions();
		
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(50);
		
		tree.root.left = new BinaryTreeNode(30);
		tree.root.right = new BinaryTreeNode(70);
		
		tree.root.left.left = new BinaryTreeNode(20);
		tree.root.left.right = new BinaryTreeNode(40);
		tree.root.right.left = new BinaryTreeNode(60);
		
		tree.root.left.left.left = new BinaryTreeNode(70);
		tree.root.right.right.right = new BinaryTreeNode(80);
		//BinaryTreeNode res = obj.findLCAinBSTRecursive(tree.root, 20, 40);
		BinaryTreeNode res = obj.findMinInBST(tree.root);
		System.out.println("Min in BST: " + res.data);

	}*/
	
	// ----------- 4: https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/ ------------------------------
	
	public boolean isBST(BinaryTreeNode root, int min, int max) {
		/*
		 * BST is a binary tree in which
		 *  1) All nodes in left subtree should be less than current node
		 *  2) All nodes in right subtree should be greater than current node
		 *  3) Each node in the tree should be a binary search tree
		 * 
		 * Just checking that (currNode > leftNode && currNode < right Node) && isBST(currNode.left) && isBST(currNode.right)
		 *  will not be sufficient and fails on node 4
		 * It fails on case:
		 * 							3
		 * 						  /   \
		 * 						2		5
		 * 					   /  \
		 * 					1		4
		 * 
		 * So for condition 1st & 2nd we will pass
		 * 	both MIN and MAX to each of left and right subtree and check that each node is following condition 1 & 2
		 * 
		 *  - Each nodeVal <= MAX    and nodeVal>=MIN
		 *  - While moving to left node we need to ensure that left node has value less than current node so 
		 *  	max=currNodeValue-1 && leftNode<=max
		 *  	pass min value for left node obtained from recursive call as it is
		 *  - While moving to right node we need to ensure the right node has value greater than current node
		 *  	so min=currNode+1  and rightNode>=min
		 *  	pass value for max as obtained in recursive call as it is
		 */
		
		if(root == null) {
			return true;
		}
		
		if(!((root.data >= min) && (root.data <= max))   ) {
			System.out.println("culprit node is : " + root.data);
			return false;
		}
		
		return isBST(root.left, min, root.data -1) && isBST(root.right, min+1, max);
		
	}
	
	// This is a class field 
	BinaryTreeNode previousNode = null;
	public boolean isBSTCheckByInorderTraversal(BinaryTreeNode root) {
		
		if(root == null) {
			return true;
		}
		
		if(! isBSTCheckByInorderTraversal(root.left)) {
			return false;
		}
		
		System.out.println("root = " + root.data);
		
		if(previousNode!=null && previousNode.data > root.data) {
			return false;
		}
		previousNode = root;
		return isBSTCheckByInorderTraversal(root.right);
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllTreeQuestions obj = new AllTreeQuestions();
		
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(3);
		
		tree.root.left = new BinaryTreeNode(2);
		tree.root.right = new BinaryTreeNode(5);
		
		tree.root.left.left = new BinaryTreeNode(1);
		tree.root.left.right = new BinaryTreeNode(4);
		//tree.root.right.left = new BinaryTreeNode(60);
		
		tree.root.left.left.left = new BinaryTreeNode(70);
		tree.root.right.right.right = new BinaryTreeNode(80);
		//BinaryTreeNode res = obj.findLCAinBSTRecursive(tree.root, 20, 40);
		//boolean res = obj.isBST(tree.root, -1, 1000);
		boolean res = obj.isBSTCheckByInorderTraversal(tree.root);
		System.out.println("Is tree BST: " + res);

	}*/
	
	// --------------------- 4 End ------------------------------------------------------------
	
	// ----------------------- 5 Start : https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/ ---------------------
	
	public void levelOrderTraversalSpiralForm(BinaryTreeNode root) {
		Stack<BinaryTreeNode> st1 = new Stack();
		Stack<BinaryTreeNode> st2 = new Stack();
		
		st1.push(root);
		
		while(!st1.isEmpty() || !st2.isEmpty()) {
			
			while(!st1.isEmpty()) {
				BinaryTreeNode temp = st1.pop();
				System.out.println(temp.data);
				
				if(temp.right!=null) {
					st2.push(temp.right);
				}
				
				if(temp.left!=null) {
					st2.push(temp.left);
				}
			}
			
			while(!st2.isEmpty()) {
				BinaryTreeNode temp2 = st2.pop();
				System.out.println(temp2.data);
				
				if(temp2.left!=null) {
					st1.push(temp2.left);
				}
				
				if(temp2.right!=null) {
					st1.push(temp2.right);
				}	
			}
			
		}
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllTreeQuestions obj = new AllTreeQuestions();
		
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(3);
		
		tree.root.left = new BinaryTreeNode(2);
		tree.root.right = new BinaryTreeNode(5);
		
		tree.root.left.left = new BinaryTreeNode(1);
		tree.root.left.right = new BinaryTreeNode(4);
		//tree.root.right.left = new BinaryTreeNode(60);
		
		tree.root.left.left.left = new BinaryTreeNode(70);
		tree.root.right.right.right = new BinaryTreeNode(80);
		//BinaryTreeNode res = obj.findLCAinBSTRecursive(tree.root, 20, 40);
		//boolean res = obj.isBST(tree.root, -1, 1000);
		obj.levelOrderTraversalSpiralForm(tree.root);
		//System.out.println("Is tree BST: " + res);

	}*/
	
	//------------------------------- 5 END ---------------------------

	//--------------6: https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/ ---------------
	
	public int findIndexInInorderArray(int[] inorderArray, int start, int end, int valToSearch) {
		for(int i=start; i<=end; i++) {
			if(inorderArray[i] == valToSearch) {
				return i;
			}
		}
		System.out.println("value not found in given start-end range of array");
		return -1;
	}
	
	int preIndex = 0;
	public BinaryTreeNode createTree(int[] in, int[] pre, int inStart, int inEnd) {
		
		if(inStart > inEnd) {
			return null;
		}
		
		BinaryTreeNode node = new BinaryTreeNode(pre[preIndex++]);
		
		if(inStart == inEnd) {
			return node;
		}
		
		int inIndex = findIndexInInorderArray(in, inStart, inEnd, node.data);
		
		node.left = createTree(in, pre, inStart, inIndex-1);
		node.right = createTree(in, pre, inIndex+1, inEnd);
		return node;
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllTreeQuestions obj = new AllTreeQuestions();
		
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(2);
		
		tree.root.left = new BinaryTreeNode(1);
		tree.root.right = new BinaryTreeNode(4);
		
		//tree.root.left.left = new BinaryTreeNode(1);
		//tree.root.left.right = new BinaryTreeNode(4);
		//tree.root.right.left = new BinaryTreeNode(3);
		
		tree.root.left.left.left = new BinaryTreeNode(70);
		tree.root.right.right.right = new BinaryTreeNode(80);
		//BinaryTreeNode res = obj.findLCAinBSTRecursive(tree.root, 20, 40);
		//boolean res = obj.isBST(tree.root, -1, 1000);
		
		int[] in = {1, 2, 4, 3};
		int[] pre = {2, 1, 4, 3};
		BinaryTreeNode res =  obj.createTree(in, pre, 0, in.length-1);
		BinaryTree tree = new BinaryTree();
		tree.root = res;
		tree.preOrder(tree.root);
		
		

	}*/
	
	
	//---------------------------------- 6 END -----------------------------------

	// ----------------- 7: https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/ --------------
	
	
	
	public void morrisInorderTraversal(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		
		BinaryTreeNode curr, pre;
		
		curr = root;
		
		while(curr!=null) {
			 /* if there is no left child then :
			  * 	print current;
			  * 	current = curent.right
			  * */
			
			if(curr.left == null) {
				System.out.println(curr.data + " ");
				curr = curr.right;
			}
			
			/* if there is left child then :
			 * 		rightMostNode = getRightMostNode(leftChild)
			 * 	 	if rightMostNode.right == null then:
			 * 			rightMostNode.right = curr      // Create a thread from inorder predecessor to successor
			 * 		if rightMostNode.right == curr then: // This is the case of thread already present so break thread link
			 * 			rightMostNode.right = null
			 * 			print the curr node
			 * 
			 */
			
			else {   // left child is present
				// Setting pre to rightmost node 
				pre = curr.left;
				while(pre.right!=null && pre.right!=curr) {
					pre = pre.right;
				}
				
				if(pre.right == null) {
					pre.right = curr;
					curr = curr.left;
				}
				
				if(pre.right == curr) {
					pre.right = null;
					System.out.println(curr.data + " ");
					curr = curr.right;
				}	
			}
		}
	}
	
	/*public static void main(String[] args) {
	// TODO Auto-generated method stub
	AllTreeQuestions obj = new AllTreeQuestions();
	
	BinaryTree tree = new BinaryTree();
	tree.root = new BinaryTreeNode(3);
	
	tree.root.left = new BinaryTreeNode(2);
	tree.root.right = new BinaryTreeNode(5);
	
	tree.root.left.left = new BinaryTreeNode(1);
	tree.root.left.right = new BinaryTreeNode(4);
	//tree.root.right.left = new BinaryTreeNode(60);
	
	tree.root.left.left.left = new BinaryTreeNode(70);
	tree.root.right.right.right = new BinaryTreeNode(80);
	//BinaryTreeNode res = obj.findLCAinBSTRecursive(tree.root, 20, 40);
	//boolean res = obj.isBST(tree.root, -1, 1000);
	obj.morrisInorderTraversal(tree.root);
	//System.out.println("Is tree BST: " + res);

	}*/
	
	// ---------------------------------- 7 End ----------------------------------------
	
	// ----------- 8: https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/ -------------------
	
	public int isSumTree(BinaryTreeNode root) {
		if(root==null || (root.left==null && root.right==null) ) {
			return 1;
		}
		int leftSum, rightSum;
		
		if(isSumTree(root.left)!=0 && isSumTree(root.right)!=0) {
			if(root.left == null) {
				leftSum = 0;
			}else if(root.left.left == null && root.left.right == null) { 
				// check  if root.left is leaf node then:
				leftSum = root.left.data;	
			}else {
				// root.left is not a leaf node and not null but its an intermediary node && is sumtree following node
				leftSum = 2 * root.left.data; 
			}
			
			
			if(root.right == null) {
				rightSum = 0;
			}else if(root.right.left == null && root.right.right == null) { 
				// check  if root.right is leaf node then:
				rightSum = root.right.data;	
			}else {
				// root.right is not a leaf node and not null but its an intermediary node && is sumtree following node
				rightSum= 2 * root.right.data; 
			}
			
			if(root.data == leftSum + rightSum) {
				return 1;
			}
		}
		
		return 0;
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllTreeQuestions obj = new AllTreeQuestions();
		
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(26);
		
		tree.root.left = new BinaryTreeNode(10);
		tree.root.right = new BinaryTreeNode(3);
		
		tree.root.left.left = new BinaryTreeNode(4);
		tree.root.left.right = new BinaryTreeNode(6);
		tree.root.right.right = new BinaryTreeNode(3);
		
		tree.root.left.left.left = new BinaryTreeNode(70);
		tree.root.right.right.right = new BinaryTreeNode(80);
		//BinaryTreeNode res = obj.findLCAinBSTRecursive(tree.root, 20, 40);
		//boolean res = obj.isBST(tree.root, -1, 1000);
		int res = obj.isSumTree(tree.root);
		System.out.println("Is tree sumTree: " + res);

		}*/
	
	// ---------------------------- 8 END ---------------------------------------------
	
	// ------------------ 9: https://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/ ------------
	
	public void printArr(int[] arr, int index) {
		for(int i=0; i<index; i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	public void  rootToLeafPathPrint(BinaryTreeNode root, int[] arr, int index) {
		if(root == null) {
			return;
		}
		
		arr[index] = root.data;
		index++;
		
		// if node is leaf node print path
		if(root.left == null && root.right == null) {
			printArr(arr, index);
		}else {
			rootToLeafPathPrint(root.left, arr, index);
			rootToLeafPathPrint(root.right, arr, index);
		}
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllTreeQuestions obj = new AllTreeQuestions();
		
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(26);
		
		tree.root.left = new BinaryTreeNode(10);
		tree.root.right = new BinaryTreeNode(3);
		
		tree.root.left.left = new BinaryTreeNode(4);
		tree.root.left.right = new BinaryTreeNode(6);
		tree.root.right.right = new BinaryTreeNode(3);
		
		tree.root.left.left.left = new BinaryTreeNode(70);
		tree.root.right.right.right = new BinaryTreeNode(80);
		//BinaryTreeNode res = obj.findLCAinBSTRecursive(tree.root, 20, 40);
		//boolean res = obj.isBST(tree.root, -1, 1000);
		int[] arr = new int[100];
		obj.rootToLeafPathPrint(tree.root, arr, 0);
		//System.out.println("Is tree sumTree: " + res);

		}*/
	
	// ----------------------- 9 END ---------------------------------------
	
	// --------- 10 : https://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/ ------------
	
	public void increment(BinaryTreeNode node, int diff) {
		if(node.left!=null) {
			node.left.data = node.left.data + diff ;
			increment(node.left, diff);
		}else if(node.right!=null) {
			node.right.data = node.right.data + diff;
			increment(node.right, diff);
		}
	}
	
	public void convertToChildSumTree(BinaryTreeNode root) {
		/*
		 *  We will do a postorder to make each node follow child sum property
		 *   calculate diff = lChild + rChild - parentNode
		 *   
		 *   if diff > 0 then: (meaning children sum is greater than parent)
		 *   	increment parentNode
		 *   if diff < 0 then: (meaning parent node is greater than sum of children)
		 *   	increment left child and also recursively increment its left child so that tree below the parent follows child sum proprty
		 *   if diff = 0 then:
		 *   	do nothing 
		 */
		
		if(root==null || (root.left==null && root.right == null)) {
			return;
		}
		
		convertToChildSumTree(root.left);
		convertToChildSumTree(root.right);
		
		int diff = root.left.data + root.right.data - root.data;
		
		if(diff > 0) {
			root.data = root.data + diff;
		}else if(diff < 0) {
			increment(root, diff * -1);
		}
		
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllTreeQuestions obj = new AllTreeQuestions();
		
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(50);
		
		tree.root.left = new BinaryTreeNode(7);
		tree.root.right = new BinaryTreeNode(2);
		
		tree.root.left.left = new BinaryTreeNode(3);
		tree.root.left.right = new BinaryTreeNode(5);
		tree.root.right.left = new BinaryTreeNode(1);
		tree.root.right.right = new BinaryTreeNode(30);
		
		tree.root.left.left.left = new BinaryTreeNode(70);
		tree.root.right.right.right = new BinaryTreeNode(80);
		//BinaryTreeNode res = obj.findLCAinBSTRecursive(tree.root, 20, 40);
		//boolean res = obj.isBST(tree.root, -1, 1000);
		
		obj.convertToChildSumTree(tree.root);
		tree.inOrder(tree.root);
		
		//System.out.println("Is tree sumTree: " + res);

		}*/
	
	// ---------------- 10 END -----------------------------------------------
	
	// 11------------------ 11: https://www.geeksforgeeks.org/evaluation-of-expression-tree/ -----------------
	
	// ------------------------------ 11 End -----------------------------------------------------
	
	// 12 --------- : https://www.geeksforgeeks.org/print-extreme-nodes-of-each-level-of-binary-tree-in-alternate-order/: ----------------
	
	// 12 ------------------ END -----------------------------------------------
	
	//13 --------------------- https://www.geeksforgeeks.org/bottom-view-binary-tree/
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllTreeQuestions obj = new AllTreeQuestions();
		
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(20);
		
		tree.root.left = new BinaryTreeNode(8);
		tree.root.right = new BinaryTreeNode(22);
		
		tree.root.left.left = new BinaryTreeNode(5);
		tree.root.left.right = new BinaryTreeNode(3);
		tree.root.right.left = new BinaryTreeNode(4);
		tree.root.right.right = new BinaryTreeNode(25);
		tree.root.left.right.left = new BinaryTreeNode(10);
		tree.root.left.right.right = new BinaryTreeNode(14);
		
		
		
		obj.printBottomView(tree.root);
		//tree.inOrder(tree.root);
		
		//System.out.println("Is tree sumTree: " + res);

		}*/
	
	public void printBottomView(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		printBottomViewUtil(root, 0, 0, map);
		
		for(Integer verticalDist:  map.keySet()) {
			System.out.println("VerticalDist  = " + verticalDist);
			System.out.println(map.get(verticalDist));
		}
		
		
	}
	
	public void printBottomViewUtil(BinaryTreeNode root, int verticalDist, int height, HashMap<Integer, ArrayList<Integer>> map) {
		if(root == null) {
			return;
		}
		
		if(map.get(verticalDist) == null) {
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(root.data);
			arr.add(height);
			map.put(verticalDist, arr);
		}
		else {
			ArrayList<Integer> arr = map.get(verticalDist);
			if(arr.get(1) <= height ) {
				arr.set(0, root.data);
				arr.set(1, height);
				map.put(verticalDist, arr);
			}
		}
		
		printBottomViewUtil(root.left, verticalDist-1, height+1, map);
		printBottomViewUtil(root.right, verticalDist + 1, height + 1, map);
		
		
	}
	//--------------- 13 END--------------------------------
	
	
	
	// 14: https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1 -------
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllTreeQuestions obj = new AllTreeQuestions();
		
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(1);
		
		tree.root.left = new BinaryTreeNode(2);
		tree.root.right = new BinaryTreeNode(3);
		
		tree.root.left.left = new BinaryTreeNode(4);
		tree.root.left.right = new BinaryTreeNode(5);
		//tree.root.right.left = new BinaryTreeNode(1);
		tree.root.right.right = new BinaryTreeNode(6);
		
		//tree.root.left.left.left = new BinaryTreeNode(70);
		////tree.root.right.right.right = new BinaryTreeNode(80);
		//BinaryTreeNode res = obj.findLCAinBSTRecursive(tree.root, 20, 40);
		//boolean res = obj.isBST(tree.root, -1, 1000);
		ArrayList<Integer> arr = new ArrayList<>();
		obj.serialize(tree.root, arr);
		System.out.println(arr);
		
		BinaryTreeNode node = obj.deserialize(arr);
		BinaryTree tree_res = new BinaryTree();
		tree_res.root = node;
		tree_res.inOrder(tree.root);
		
		//System.out.println("Is tree sumTree: " + res);

		}
	
	public void  serialize(BinaryTreeNode root, ArrayList<Integer> arr) {
		if(root == null) {
			arr.add(-1);
			return;
		}
		
		arr.add(root.data);
		serialize(root.left, arr);
		serialize(root.right, arr);
	}
	
	int index = 0;
	public BinaryTreeNode deserialize(ArrayList<Integer> arr) {
		
		if(index==arr.size() || arr.get(index) == -1) {
			index++;
			return null;
		}
		
		BinaryTreeNode node = new BinaryTreeNode(arr.get(index));
		index++;
		
		node.left = deserialize(arr);
		node.right = deserialize(arr);
		return node;
	}
	
	// 14 : ---------- END ----------------------------------
	
	
}
