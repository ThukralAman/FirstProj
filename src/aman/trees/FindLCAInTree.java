package aman.trees;

/*
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 */

public class FindLCAInTree {
	
	boolean v1, v2;
	
	public BinaryTreeNode findLCAUtil(BinaryTreeNode root, int n1, int n2) {
		if(root==null) {
			return null;
		}
		
		if(root.data == n1) {
			v1 = true;
			return root;
		}else if(root.data == n2) {
			v2 = true;
			return root;
		}
		
		BinaryTreeNode leftLCS = findLCAUtil(root.left, n1, n2);
		BinaryTreeNode rightLCS = findLCAUtil(root.right, n1, n2);
		
		if(leftLCS!=null && rightLCS!=null) {
			return root;
		}
		
		return (leftLCS == null) ? rightLCS : leftLCS;
		
	}
	
	public boolean findOnPath(BinaryTreeNode root, int nodeDataToSearch) {
		
		if(root==null) {
			return false;
		}
		
		if(root.data == nodeDataToSearch) {
			return true;
		}else {
			return findOnPath(root.left, nodeDataToSearch) || findOnPath(root.right, nodeDataToSearch) ;
		}
	}
	
	public BinaryTreeNode findLCA(BinaryTreeNode root, int n1, int n2) {
		/*
		 *  1. Two cases are there in lowest common ancestor
		 *  	- C1: Both n1 and n2 are on same side of root
		 *  			  O
		 *  			/
		 *  		  n1
		 *  		/
		 *  	  n2	
		 *  
		 *  	- C2: Both n1 and n2 are on different side of root
		 *  		   O
		 *  		/	  \
		 * 		   n1	   n2
		 * 
		 *  2. Our recursive function findLCA() would return  node n1 for case 1 but it does not check for n2 after it finds n1.
		 *   But for Case2, recursive function returns node O correcly
		 *  
		 *  3. So to handle case1, once we find n1, we separately need to check if n2 is there on path of n1.
		 *  4. To identify which case is being served, we will use two global variables v1 and v2 to check if both n1 and n2 have
		 *     been visited in recursive function or not. If only one of V1 and V2 is true, then it implies we have Case1 served to us
		 *     and we need to check path
		 * 
		 * 
		 */
		
		BinaryTreeNode ancestor = findLCAUtil(root, n1, n2);
		
		if(v1 && v2 || v1 && findOnPath(ancestor, n2) || v2 && findOnPath(ancestor, n1)) {
			return ancestor;
		}
		
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(10);
		
		tree.root.left = new BinaryTreeNode(20);
		tree.root.right = new BinaryTreeNode(30);
		
		tree.root.left.left = new BinaryTreeNode(40);
		tree.root.left.right = new BinaryTreeNode(50);
		tree.root.right.left = new BinaryTreeNode(60);
		
		tree.root.right.right = new BinaryTreeNode(70);
		
		FindLCAInTree obj = new FindLCAInTree();
		BinaryTreeNode res =  obj.findLCA(tree.root, 20, 70);
		if(res!=null) {
			System.out.println("LCA is: " + res.data);
		}else {
			System.out.println("null node returned for LCA");
		}
		

	}

}
